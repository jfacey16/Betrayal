const MESSAGE_TYPE = {
    CONNECT: 0,
    CHATUPDATE: 1,
    UPDATELOBBIES: 2,
    SETNAME: 3,
    CREATELOBBY: 4,
    JOINLOBBY: 5,
    UPDATELOBBY: 6,
    STARTGAME: 7,
    GAMEMOVE: 8,
    CHOOSECHARACTER: 9,
    GAMERADY: 10,
    ERROR: 11
}

let conn;
let userId;
let username;
let current_lobby_name;

$(document).ready(() => {
	setup_betrayal();
});

const setup_betrayal = () => {
	conn = new WebSocket("ws://localhost:4567/betrayal_connection");
	
	conn.onerror = err => {
		console.log('Connection error:', err);
	}
	
	conn.onmessage = msg => {
		const data = JSON.parse(msg.data);
		switch(data.type) {
			default: 
				console.log("Unknown message type: ", data.type);
				break;
			case MESSAGE_TYPE.CONNECT:
				userId = data.id;
				break;
			case MESSAGE_TYPE.UPDATELOBBIES:
				update_lobbies(data);
				break;
		
		
		
		}
		
	}
}

const create_name = user => {
	
	username = user;
	var message = {
		type: MESSAGE_TYPE.SETNAME,
		payload: {
			id : userId,
			name : user
		}
	}
	
	const json = JSON.stringify(message);
	conn.send(json);
}

const create_lobby = () => {
	console.log("create"); 
	var message = {
		type: MESSAGE_TYPE.CREATELOBBY,
		payload: {
			id : userId,
			lobbyName : username + "'s Game",
		}
	}

	const json = JSON.stringify(message);
	conn.send(json);
}

function update_lobbies(data) {
	
	const lobbies = JSON.parse(data.lobbies);
	
	if(!game_started) {
		console.log(lobbies);
	}
	
	var lobby_text = "<p>";
	
	for(index in lobbies) {
		lobby_text += "<div class=\"lobby_name\">" + lobbies[index] + "</div>";
	}
	
	lobby_text += "</p>";
	
	$("#lobbies").html(lobby_text);
	
	$(".lobby_name").click(function(e) {
		const current_lobby = $(e.target);
		current_lobby_name = current_lobby.text();
		
		console.log(current_lobby_name);
	});
}



