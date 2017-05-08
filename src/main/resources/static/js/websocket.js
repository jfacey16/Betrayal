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
			case MESSAGE_TYPE.GAMEREADY:
				set_starting_state(data);
				draw_map(data);
				break;
			case MESSAGE_TYPE.GAMEMOVE:
				responseJSON = data;
				update_turn(data.currentTurn);
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
	
	var lobby_text = "<p>";
	
	for(index in lobbies) {
		lobby_text += "<div class=\"lobby_name\">" + lobbies[index] + "</div>";
	}
	
	lobby_text += "</p>";
	
	$("#lobbies").html(lobby_text);
	
	$(".lobby_name").click(function(e) {
		const current_lobby = $(e.target);
		current_lobby_name = current_lobby.text();
	});
}

function update_lobby(data) {
	
	console.log("in update lobby");
	
	const members = JSON.parse(data.members);
	
	var member_text = "<p><p>Current Lobby Members:</p>";
	
	for(index in members) {
		var count = parseInt(index) + 1;
		member_text += "<p>" + count + ". " + members[index] + "</p>";
	}
	
	member_text += "</p>";
	
	$("#members").html(member_text);
}

function join_lobby() {
	
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
	
	$("#temp_lobby").html("");
	
	var choices_text = "";
	
	choices_text += "<div class=\"option\" style=\"width:100%\">";
	choices_text += "<center><h2>Choose your character and begin the Betrayal!</h2></center>";
	
	for(index in choices) {
		choices_text += "<center><div class=\"char_choice\">" + choices[index].name + "</div></center>";
	}

	choices_text += "<div id=\"choose_error\" class=\"message\"></div>";
	choices_text += "<center><button type=\"button\" id=\"choose_character\">Choose Character</button></center>";
	choices_text += "</div>";
	
	$("#temp_lobby").html(choices_text);
	
	$(".char_choice").click(function(e) {
		const choice = $(e.target);
		current_choice = choice.text();
	});
	
	$("#choose_character").click(event => {
		
		if(current_choice != "") {
			var message = {
					type: MESSAGE_TYPE.CHOOSECHARACTER,
					payload: {
						id : userId,
						choice : current_choice
					}
				}

				const json = JSON.stringify(message);
				conn.send(json);
				
				$("#temp_lobby").html("");
				
				var waiting_text = "";
				
				waiting_text += "<div class=\"option\" style=\"width:100%\">";
				waiting_text += "<center><h2>Waiting on other players...</h2></center>";
				waiting_text += "<center>You've chosen to play as " + current_choice + "!</center>";
				waiting_text += "</div>";
				
				$("#temp_lobby").html(waiting_text);
		} else {
			$("#choose_error").html("<center><p>ERROR: Please select a character to start the game!</p></center>");
			document.getElementById("choose_error").style.color = "red";
		}
	});
}

function draw_map(data) {
	const torder = JSON.parse(data.turnOrder);
	paintBoard(-1, torder.length);
}


function game_move(params) {
	var message = {
		type: MESSAGE_TYPE.GAMEMOVE,
		payload: {
			id : userId,
			query : params
		}
	}

	const json = JSON.stringify(message);
	conn.send(json);
}