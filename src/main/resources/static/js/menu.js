$(document).ready(() => {
	
	$("#temp_lobby").draggable();
	
	$("#join_game").click(event => {
		
		console.log("join"); 
		
		const $username_join = $("#username_join");
		
		if($username_join.val() === "") {
			$("#join_error").html("<center><p>ERROR: Please enter a username before you join a game!</p></center>");
			document.getElementById("join_error").style.color = "red";
		} else {
			create_name($username_join.val());
			
			enter_lobby();
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
			enter_lobby();
		}
		
	});

});