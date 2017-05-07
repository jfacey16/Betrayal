package edu.brown.cs.zacharyhoffman.boggle;

import java.io.IOException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;

@WebSocket
public class GameWebSocket {
  private static final Gson GSON = new Gson();
  //private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

  //my multiplayer maps
  private static Map<String, String> idToLobby = new ConcurrentHashMap<>();
  private static Map<Session, String> sessionToId = new ConcurrentHashMap<>();
  private static Map<String, Queue<Session>> lobbyToSessions = new ConcurrentHashMap<>();
  private static Map<String, String> idToName = new ConcurrentHashMap<>();

  private static enum MESSAGE_TYPE {
    CONNECT,
    CHATUPDATE,
    GETLOBBIES,
    SETNAME,
    CREATELOBBY,
    JOINLOBBY
  }

  @OnWebSocketConnect
  public void connected(Session session) throws IOException {
    // TODO Add the session to the queue
    //sessions.add(session);

    // TODO Build the CONNECT message
    JsonObject connect =  new JsonObject();
    connect.addProperty("type", MESSAGE_TYPE.CONNECT.ordinal());

    String id = UUID.randomUUID().toString();
    connect.addProperty("id", id);
    sessionToId.put(session, id);
    idToName.put(id, id);

    // TODO Send the CONNECT message
    session.getRemote().sendString(connect.toString());
  }

  @OnWebSocketClose
  public void closed(Session session, int statusCode, String reason) {
    String id = sessionToId.get(session);
    String lobby = idToLobby.get(id);

    //remove it from all 4 lists
    lobbyToSessions.get(lobby).remove(session);
    idToLobby.remove(id);
    sessionToId.remove(session);
    idToName.remove(id);

  }

  @OnWebSocketMessage
  public void message(Session session, String message) throws IOException {
    JsonObject received = GSON.fromJson(message, JsonObject.class);
    int type = received.get("type").getAsInt();
    MESSAGE_TYPE[] vals = MESSAGE_TYPE.values();
    switch (vals[type]) {
      case CHATUPDATE:
        chatUpdate(received, session);
        break;
      case GETLOBBIES:
        getLobbies(received, session);
        break;
      case SETNAME:
        setName(received, session);
        break;
      case CREATELOBBY:
        createLobby(received, session);
        break;
      case JOINLOBBY:
        joinLobby(received, session);
        break;
      default:
        assert false;
        System.out.println("ERROR: Type does not exists - " + Integer.toString(type));
        break;

    }
  }

  private synchronized void chatUpdate(JsonObject received, Session session) throws IOException {
    JsonObject payload = received.get("payload").getAsJsonObject();
    String id = payload.get("id").getAsString();
    assert id.equals(sessionToId.get(session));

    // TODO Send an UPDATE message to all users
    JsonObject update =  new JsonObject();
    update.addProperty("type", MESSAGE_TYPE.CHATUPDATE.ordinal());
    update.addProperty("id", id);
    update.addProperty("name", idToName.get(id));
    update.addProperty("message", payload.get("message").getAsString());

    String lobby = idToLobby.get(id);
    Queue<Session> sessions = lobbyToSessions.get(lobby);
    for (Session ses : sessions) {
      ses.getRemote().sendString(update.toString());
    }
  }

  private synchronized void getLobbies(JsonObject received, Session session) throws IOException {
    JsonObject payload = received.get("payload").getAsJsonObject();
    String id = payload.get("id").getAsString();
    assert id.equals(sessionToId.get(session));

    // TODO Send an UPDATE message to all users
    JsonObject update =  new JsonObject();
    update.addProperty("type", MESSAGE_TYPE.GETLOBBIES.ordinal());
    update.addProperty("lobbies", GSON.toJson(lobbyToSessions.keySet()));

    session.getRemote().sendString(update.toString());
  }

  private synchronized void setName(JsonObject received, Session session) throws IOException {
    JsonObject payload = received.get("payload").getAsJsonObject();
    String id = payload.get("id").getAsString();
    assert id.equals(sessionToId.get(session));

    idToName.put(id, payload.get("name").getAsString());
  }

  private synchronized void createLobby(JsonObject received, Session session) throws IOException {
    JsonObject payload = received.get("payload").getAsJsonObject();
    String id = payload.get("id").getAsString();
    String lobbyName = payload.get("lobbyName").getAsString();
    assert id.equals(sessionToId.get(session));

    if (lobbyToSessions.keySet().contains(lobbyName)) {
      System.out.println("lobby already exists");
      //throw new IOException("Lobby allready exists.");
    }

    idToLobby.put(id, lobbyName);
    lobbyToSessions.put(lobbyName, new ConcurrentLinkedQueue<>());
    lobbyToSessions.get(lobbyName).add(session);
  }

  private synchronized void joinLobby(JsonObject received, Session session) throws IOException {
    JsonObject payload = received.get("payload").getAsJsonObject();
    String id = payload.get("id").getAsString();
    String lobbyName = payload.get("lobbyName").getAsString();
    assert id.equals(sessionToId.get(session));

    if (!lobbyToSessions.keySet().contains(lobbyName)) {
      throw new IOException("Lobby doesn't exist.");
    }

    lobbyToSessions.get(lobbyName).add(session);
    idToLobby.put(id, lobbyName);
  }
}
