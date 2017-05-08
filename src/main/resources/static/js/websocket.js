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
    GAMEREADY: 10,
    ERROR: 11
}

let conn;
let userId;
let username;
let current_lobby_name = "";
let game_host = false;

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
			case MESSAGE_TYPE.UPDATELOBBY:
				update_lobby(data);
				break;
			case MESSAGE_TYPE.CHOOSECHARACTER:
				console.log("character!");
				choose_character(data);
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
	
	current_lobby_name = username + "'s Game";
	game_host = true;

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

function update_lobby(data) {
	
	console.log("in update lobby");
	
	const members = JSON.parse(data.members);
	
	if(!game_started) {
		console.log(members);
	}
	
	var member_text = "<p><p>Current Lobby Members:</p>";
	
	for(index in members) {
		var count = parseInt(index) + 1;
		member_text += "<p>" + count + ". " + members[index] + "</p>";
	}
	
	member_text += "</p>";
	
	$("#members").html(member_text);
}

function join_lobby() {
	
	console.log("join"); 
	var message = {
		type: MESSAGE_TYPE.JOINLOBBY,
		payload: {
			id : userId,
			lobbyName : current_lobby_name,
		}
	}

	const json = JSON.stringify(message);
	conn.send(json);
}

function start_game() {
	
	console.log("starting"); 
	var message = {
		type: MESSAGE_TYPE.STARTGAME,
		payload: {
			id : userId,
			lobbyName : current_lobby_name,
		}
	}

	const json = JSON.stringify(message);
	conn.send(json);
}

function choose_character(data) {
	
	const choices = JSON.parse(data.choices);
	var current_choice = "";
	console.log(choices);
	
	$("#temp_lobby").html("");
	
	var choices_text = "";
	
	choices_text += "<div class=\"option\" style=\"width:100%\">";
	choices_text += "<center><h2>Choose your character and begin the Betrayal!</h2></center>";
	
	for(index in choices) {
		choices_text += "<center><div class=\"char_choice\">" + choices[index].name + "</div></center>";
	}
	
	choices_text += "<center><button type=\"button\" id=\"choose_character\">Choose Character</button></center>";
	choices_text += "</div>";
	
	$("#temp_lobby").html(choices_text);
	
	$(".char_choice").click(function(e) {
		const choice = $(e.target);
		current_choice = choice.text();
		
		console.log(current_choice);
	});
	
	$("#choose_character").click(event => {
		var message = {
			type: MESSAGE_TYPE.CHOOSECHARACTER,
			payload: {
				id : userId,
				choice : current_choice,
			}
		}
		
		console.log("sending " + current_choice);

		const json = JSON.stringify(message);
		conn.send(json);
	});
	
}

