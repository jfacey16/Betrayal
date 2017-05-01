package com.term_project.system;

import com.term_project.game.GameState;
import com.term_project.system.MemorySlot;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import spark.ExceptionHandler;
import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;


import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import freemarker.template.Configuration;

/**
 * Hello world!
 *
 */
public class Main {
	private static final int DEFAULT_PORT = 4567;
	private static GameState gameState = null;
	private static final Gson GSON = new Gson();

	public static void main(String[] args) {
		new Main(args).run();
	}
	private String[] args;

	private Main(String[] args) {
		this.args = args;
	}

	private void run() {
		OptionParser parser = new OptionParser();
	  parser.accepts("gui");
	  parser.accepts("port")
					.withRequiredArg()
					.ofType(Integer.class)
	        .defaultsTo(DEFAULT_PORT);
	  OptionSet options = parser.parse(args);

	  if (options.has("gui")) {
			runSparkServer((int) options.valueOf("port"));
	  } else {
			System.out.println("Starting REPL");
			Environment env = new Environment();
			try {
			  env.startRepl();
			} catch (Throwable e) {
			  e.printStackTrace();
			}
		}
	}

	/*
	* Some Spark methods/classes are currently residing in Main. We've discussed moving them if they get too over-bearing.
	*
	*/
	private static FreeMarkerEngine createEngine() {
	  Configuration config = new Configuration();
	  File templates = new File("src/main/resources/spark/template/freemarker");
	  try {
	    config.setDirectoryForTemplateLoading(templates);
	  } catch (IOException ioe) {
	    System.out.printf("ERROR: Unable use %s for template loading.%n",
	        							templates);
	    System.exit(1);
	  }
	  return new FreeMarkerEngine(config);
	}

	private void runSparkServer(int port) {
	  Spark.port(port);
	  Spark.externalStaticFileLocation("src/main/resources/static");
	  Spark.exception(Exception.class, new ExceptionPrinter());

	  FreeMarkerEngine freeMarker = createEngine();

	  // Setup Spark Routes
	  Spark.get("/betrayal_menu", new MenuHandler(), freeMarker);
	  Spark.get("/create_game", new LobbyHandler(), freeMarker);
		Spark.post("/create_game", new LobbyStart());
	  Spark.get("/betrayal", new BetrayalHandler(), freeMarker);
		Spark.post("/betrayal", new UpdateHandler());
		Spark.post("/tileStart", new TileStart());
	}

	private static class MenuHandler implements TemplateViewRoute {
		@Override
		public ModelAndView handle(Request req, Response res) {
		  String message = "<p>Let's play Betrayal!</p> To begin, either create your own game or join a lobby below:";

		  Map<String, Object> variables = ImmutableMap.of(
					"title",
		      "Betrayal at House on the Hill",
					"message",
					message
			);
		  return new ModelAndView(variables, "menu.ftl");
		}
	}

	private static class LobbyHandler implements TemplateViewRoute {
	    @Override
	    public ModelAndView handle(Request req, Response res) {

	      QueryParamsMap qm = req.queryMap();
	      String game_name = qm.value("name");
				String player_number = qm.value("players");

	      String message = "<p><h4>You're currently in the lobby of Game \"" + game_name + "\".</h4></p>";
	      message += "<p><h4>Waiting for X more players to join your lobby of " + player_number + ".</h4></p>";

				 Map<String, Object> variables;
				variables = ImmutableMap.of(
					"title", "Betrayal at House on the Hill",
					"message", message
				);
				return new ModelAndView(variables, "lobby.ftl");
	    }
	}

	private static class LobbyStart implements Route {
	    @Override
	    public String handle(Request req, Response res) {
				System.out.println("LobbyHandler");
	      QueryParamsMap qm = req.queryMap();
	      String game_name = qm.value("name");
				//setup ids
	      int player_number = Integer.parseInt(qm.value("players"));
				List<String> ids =  new ArrayList();
				for (int i = 0; i < player_number; i++) {
					ids.add(Integer.toString(i));
				}

				gameState = new GameState(ids, new MemorySlot());

	      Map<String, Object> variables = new HashMap<>();

				variables.putAll(gameState.start());
				variables = ImmutableMap.copyOf(variables);

				//System.out.println(variables);
			  return GSON.toJson(variables);
	    }
	}

	private static class BetrayalHandler implements TemplateViewRoute {
	  @Override
	  public ModelAndView handle(Request req, Response res) {
	    Map<String, Object> variables = ImmutableMap.of(
					"title",
	        "Betrayal at House on the Hill"
			);
	    return new ModelAndView(variables, "betrayal.ftl");
	  }
	}

	private static class UpdateHandler implements Route {
	  @Override
	  public String handle(Request req, Response res) {
			QueryParamsMap qm = req.queryMap();
			
		      Map<String, Object> variables = new HashMap<>();

					variables.putAll(gameState.update(qm));
					variables = ImmutableMap.copyOf(variables);

					//System.out.println(variables);
				  return GSON.toJson(variables);
	  }
	}

	private static class TileStart implements Route {
	  @Override
	  public String handle(Request req, Response res) {
			System.out.println("TILE START");
			QueryParamsMap qm = req.queryMap();

			Map<String, Object> variables = gameState.buildMap(qm);

			variables = ImmutableMap.copyOf(variables);

			System.out.println(variables);
			//System.out.println(variables);
			String parsed = GSON.toJson(variables).toString();
			return GSON.toJson(variables);
	  }
	}

	private static class ItemHandler implements TemplateViewRoute {

		@Override
		public ModelAndView handle(Request arg0, Response arg1)
				throws Exception {


			return null;
		}
	}

	private static class OmenHandler implements TemplateViewRoute {

		@Override
		public ModelAndView handle(Request arg0, Response arg1)
				throws Exception {


			return null;
		}
	}

	private static class EventHandler implements TemplateViewRoute {

		@Override
		public ModelAndView handle(Request arg0, Response arg1)
				throws Exception {


			return null;
		}
	}

	private static class ExceptionPrinter implements ExceptionHandler {
    @Override
    public void handle(Exception e, Request req, Response res) {
	    res.status(500);
	    StringWriter stacktrace = new StringWriter();
	    try (PrintWriter pw = new PrintWriter(stacktrace)) {
	      pw.println("<pre>");
	      e.printStackTrace(pw);
	      pw.println("</pre>");
	    }
	    res.body(stacktrace.toString());
    }
	}
}
