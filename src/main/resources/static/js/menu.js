$(document).ready(() => {
	
	$("#temp_lobby").draggable();
	
	$("#join_game").click(event => {
		
		console.log("join"); 
		
		const $username_join = $("#username_join");
		
		if($username_join.val() === "") {
			$("#join_error").html("<center><p>ERROR: Please enter a username before you join a game!</p></center>");
			document.getElementById("join_error").style.color = "red";
		} else {
			if(current_lobby_name != "") {
				create_name($username_join.val());
				display_lobby();
				join_lobby();
			} else {
				$("#join_error").html("<center><p>ERROR: Please select a lobby before you join a game!</p></center>");
				document.getElementById("join_error").style.color = "red";
			}
		}
		
	});
	
	$("#create_game").click(event => {
		const $username_create = $("#username_create");
		
		if($username_create.val() === "") {
			$("#create_error").html("<center><p>ERROR: Please enter a username in order to create a game!</p></center>");
			document.getElementById("create_error").style.color = "red";
		} else {
			
			create_name($username_create.val());
			create_lobby();
			display_lobby();
		}
		
	});
});

function display_lobby() {
	
	console.log("entering lobby");
	
	$("#temp_lobby").html("");
	
	var lobby_text = "";
	
	lobby_text += "<div class=\"option\" style=\"width:100%\">";
	lobby_text += "<center><h2>You've entered the lobby of " + current_lobby_name + "</h2></center>";
	lobby_text += "<center><div id=\"members\"></div></center>";
	
	if(game_host) {
		lobby_text += "<center><button type=\"button\" id=\"start_game\">Start Game</button></center>";
	}
	
	lobby_text += "</div>";
	
	$("#temp_lobby").html(lobby_text);
	
	$("#start_game").click(event => {
		
		console.log("start clicked");
		
		start_game();
	});
}