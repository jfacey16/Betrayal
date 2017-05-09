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
let turnIndex;
let numPlayers;

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
				choose_character(data);
				break;
			case MESSAGE_TYPE.GAMEREADY:
				set_starting_state(data);
				draw_map(data);
				const using = JSON.parse(data.idTurnOrder);
				numPlayers = using.length;
				turnIndex = using.indexOf(userId);
				turn = 0;
				console.log("t:" + turn);
				console.log("ti:" + turnIndex);
				if (turn != turnIndex)
					ending.disabled = true;
				break;
			case MESSAGE_TYPE.GAMEMOVE:
				const pay = JSON.parse(data.payload);
				if (pay.phase === 1) 
					receiveCard(data);
			 	else if (pay.phase === 0)
					actualMovement(data);
				
				if(pay.rolls) {
					if(pay.result) {
						eventRoll(pay);
					} else {
						console.log("omen roll sent");
						omenRoll(pay);
					}
				}
				
				console.log(data);
				console.log(pay);
				console.log("current " + current_char);
				if(pay.character) {
					if(pay.item.length >= 1) {
						addItem(pay.character, pay.item[0]);
					} else if(pay.omen.length) {
						addOmen(pay.character, pay.omen[0]);
					}
				}
				
				update_turn(data.currentTurn);
				break;
			case MESSAGE_TYPE.CHATUPDATE:
				console.log("message recieved");
				display_message(data);
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

	var lobby_text = "";

	for(index in lobbies) {
		lobby_text += "<div class=\"lobby_name\">" + lobbies[index] + "</div>";
	}

	lobby_text += "";

	$("#lobbies").html(lobby_text);

	$(".lobby_name").click(function(e) {
    $('.lobby_name').each(function() {
      $(this).removeClass('selected_lobby');
    });

		const current_lobby = $(e.target);
		current_lobby_name = current_lobby.text();
    current_lobby.addClass("selected_lobby");
	});
}

function update_lobby(data) {

	console.log("in update lobby");

	const members = JSON.parse(data.members);

	var member_text = "<h2><div class='text_title text_normal'>Current Lobby Members:</div></h2>";

  member_text+='<div id="players" class="wrapper text_normal">';
	for(index in members) {
		var count = parseInt(index) + 1;
		member_text += "<div class='member_name'>" + members[index] + "</div>";
	}

	member_text += "</div>";

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

	var choices_text = `
	<div class="option wrapper">
		<p class="title"> Choose your character </p>
		<div class="contents">
	`;

	for(index in choices) {
		choices_text += "<div class=\"char_choice text_normal\">" + choices[index].name + "</div>";
	}

  choices_text += "</div>"
  choices_text += "<div class=\"menu_button\"><button type=\"button\" id=\"choose_character\" class=\"myButton\">Choose</button></div>";


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
				waiting_text += "<center><font size=\"5\">Waiting on other players...</font></center>";
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
