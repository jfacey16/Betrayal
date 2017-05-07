$(document).ready(() => {
	
	$("#join_game").click(event => {
		
		console.log("join"); 
		
		const $username_join = $("#username_join");
		
		if($username_join.val() === "") {
			$("#join_error").html("<center><p>ERROR: Please enter a username before you join a game!</p></center>");
			document.getElementById("join_error").style.color = "red";
		} else {
			
			$.post("/betrayal_join", {"username": $username_join.val()}, rj => {
				
				console.log("joined");

		    });
		}
		
	});
	
	$("#create_game").click(event => {
		
		console.log("create"); 
		
		const $username_create = $("#username_create");
		
		if($username_create.val() === "") {
			$("#create_error").html("<center><p>ERROR: Please enter a username in order to create a game!</p></center>");
			document.getElementById("create_error").style.color = "red";
		} else {

			const $players = $("input[name=players]:checked");

			console.log($players.val())
			
			$.post("/betrayal_create", {"username": $username_create.val(), "players": $players.val()}, rj => {
				
				console.log("created");

		    });
		}
		
	});

});
