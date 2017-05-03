let $player_1_select;
let $player_2_select;
let $player_3_select;
let $player_4_select;
let $player_5_select;
let $player_6_select;

let $char_1;
let $char_2;
let $char_3;
let $char_4;
let $char_5;
let $char_6;

let $item_window;
let $omen_window;
let $event_window;

let responseOject;
let current_char;

$(document).ready(() => {
	
	$player_1_select = $("#player_1_select");
	$player_2_select = $("#player_2_select");
	$player_3_select = $("#player_3_select");
	$player_4_select = $("#player_4_select");
	$player_5_select = $("#player_5_select");
	$player_6_select = $("#player_6_select");

	pickCharacters();
	
	const $temp_lobby = $("#temp_lobby");
	$item_window = $("#item");
	$omen_window = $("#omen");
	$event_window = $("#event");
	
	var x = 1;
	$item_window.hide();
	$omen_window.hide();
	$event_window.hide();
	$temp_lobby.show();

    $(document).keypress(function(e) {
        if(e.which == 13) {
            if(x == 1) {
            	revealCard();
            	x= 0;
            } else {
            	hideCard();
            	x = 1;
            }
        }
        
        if(e.which == 49) {
            itemDrawn();
        }
        
        if(e.which == 50) {
            omenDrawn();
        }
        
        if(e.which == 51) {
            eventDrawn();
        }
    });

    const $create = $("#create");
    
    $create.on('click', function(e) {
    	
    	e.preventDefault();
    	
    	$temp_lobby.hide();

    	setStartingState();
    	

    	$.post("/tileStart", {"0": $char_1.name, "1": $char_2.name, "2": $char_3.name, "3": $char_4.name,
    	     "4": $char_5.name, "5": $char_6.name}, rj2 => {

    	     	setStartingState();
    	     });

    });
});

const pickCharacters = () => {
	 const postParameters = {players:"6"};

     $.post("/create_game", postParameters, responseJSON => {

         // TODO: Parse the JSON response into a JavaScript object. DONE
        responseObject = JSON.parse(responseJSON);
    	
     	$player_1_select.html("<option value=\"1\">" 
     			+ responseObject.characterChoices[0][0].name + "</option><option value=\"2\">" 
     			+ responseObject.characterChoices[0][1].name + "</option>");
    	
     	$player_2_select.html("<option value=\"3\">" 
     			+ responseObject.characterChoices[1][0].name + "</option><option value=\"4\">" 
     			+ responseObject.characterChoices[1][1].name + "</option>");
    	
     	$player_3_select.html("<option value=\"5\">" 
     			+ responseObject.characterChoices[2][0].name + "</option><option value=\"6\">" 
     			+ responseObject.characterChoices[2][1].name + "</option>");
    	
     	$player_4_select.html("<option value=\"7\">" 
     			+ responseObject.characterChoices[3][0].name + "</option><option value=\"8\">" 
     			+ responseObject.characterChoices[3][1].name + "</option>");
    	
     	$player_5_select.html("<option value=\"9\">" 
     			+ responseObject.characterChoices[4][0].name + "</option><option value=\"10\">" 
     			+ responseObject.characterChoices[4][1].name + "</option>");
    	
     	$player_6_select.html("<option value=\"11\">" 
     			+ responseObject.characterChoices[5][0].name + "</option><option value=\"12\">" 
     			+ responseObject.characterChoices[5][1].name + "</option>");

     });
}

const setStartingState = () => {

	const $player_1_name = $("#name_1");
	const $player_2_name = $("#name_2");
	const $player_3_name = $("#name_3");
	const $player_4_name = $("#name_4");
	const $player_5_name = $("#name_5");
	const $player_6_name = $("#name_6");
	
	var val_1 = $player_1_select.val();
	var val_2 = $player_2_select.val();
	var val_3 = $player_3_select.val();
	var val_4 = $player_4_select.val();
	var val_5 = $player_5_select.val();
	var val_6 = $player_6_select.val();
	
		 if(val_1 === "1") {
		 	$char_1 = responseObject.characterChoices[0][0];
		 } else {
		 	$char_1 = responseObject.characterChoices[0][1];
		 }
		
		 if(val_2 === "3") {
		 	$char_2 = responseObject.characterChoices[1][0];
		 } else {
		 	$char_2 = responseObject.characterChoices[1][1];
		 }
	
		 if(val_3 === "5") {
		 	$char_3 = responseObject.characterChoices[2][0];
		 } else {
		 	$char_3 = responseObject.characterChoices[2][1];
		 }
		
		 if(val_4 === "7") {
		 	$char_4 = responseObject.characterChoices[3][0];
		 } else {
		 	$char_4 = responseObject.characterChoices[3][1];
		 }
		
		 if(val_5 === "9") {
		 	$char_5 = responseObject.characterChoices[4][0];
		 } else {
		 	$char_5 = responseObject.characterChoices[4][1];
		 }
		
		 if(val_6 === "11") {
		 	$char_6 = responseObject.characterChoices[5][0];
		 } else {
		 	$char_6 = responseObject.characterChoices[5][1];
		 }
		
		 $player_1_name.html("<center>" + $char_1.name + "</center>");
		 $player_2_name.html("<center>" + $char_2.name + "</center>");
		 $player_3_name.html("<center>" + $char_3.name + "</center>");
		 $player_4_name.html("<center>" + $char_4.name + "</center>");
		 $player_5_name.html("<center>" + $char_5.name + "</center>");
		 $player_6_name.html("<center>" + $char_6.name + "</center>");
		
	
		 const $player_1_speed = $("#speed_1");
		 var $speed = "<center>";
		
		 for (let i = 0, len = $char_1.speedScale.length; i < len; i++) {
		 	if(i === $char_1.speed) {
		 		$speed += "<font color=\"red\">" + $char_1.speedScale[i] + "</font> ";
		 	} else {
		 		$speed += $char_1.speedScale[i] + " ";
		 	}
	     }
		
		 const $player_1_might = $("#might_1");
		 var $might = "<center>";
		
		 for (let i = 0, len = $char_1.mightScale.length; i < len; i++) {
		 	if(i === $char_1.might) {
		 		$might += "<font color=\"red\">" + $char_1.mightScale[i] + "</font> ";
		 	} else {
		 		$might += $char_1.mightScale[i] + " ";
		 	}
	     }
		
		 const $player_1_sanity = $("#sanity_1");
		 var $sanity = "<center>";

		 for (let i = 0, len = $char_1.sanityScale.length; i < len; i++) {
		 	if(i === $char_1.sanity) {
		 		$sanity += "<font color=\"red\">" + $char_1.sanityScale[i] + "</font> ";
		 	} else {
		 		$sanity += $char_1.sanityScale[i] + " ";
		 	}
	     }
	
		 const $player_1_knowledge = $("#knowledge_1");
		 var $knowledge = "<center>";
		
		 for (let i = 0, len = $char_1.knowledgeScale.length; i < len; i++) {
		 	if(i === $char_1.knowledge) {
		 		$knowledge += "<font color=\"red\">" + $char_1.knowledgeScale[i] + "</font> ";
		 	} else {
		 		$knowledge += $char_1.knowledgeScale[i] + " ";
		 	}
	     }

		
		 $player_1_speed.html($speed + "</center>");
		 $player_1_might.html($might + "</center>");
		 $player_1_knowledge.html($knowledge + "</center>");
		 $player_1_sanity.html($sanity + "</center>");
		
	
		 const $player_2_stats = $("#stats_2");
		 const $player_3_stats = $("#stats_3");
		 const $player_4_stats = $("#stats_4");
		 const $player_5_stats = $("#stats_5");
		 const $player_6_stats = $("#stats_6");
		

		 $player_2_stats.html("<center>" + $char_2.speedScale[$char_2.speed] + " " +
		 		$char_2.mightScale[$char_2.might] + " " + 
		 		$char_2.sanityScale[$char_2.sanity] + " " +
		 		$char_2.knowledgeScale[$char_2.knowledge] + " " + "</center>");
		
		 $player_3_stats.html("<center>" + $char_3.speedScale[$char_3.speed] + " " +
		 		$char_3.mightScale[$char_3.might] + " " + 
		 		$char_3.sanityScale[$char_3.sanity] + " " + 
		 		$char_3.knowledgeScale[$char_3.knowledge] + " " + "</center>");
		
		 $player_4_stats.html("<center>" + $char_4.speedScale[$char_4.speed] + " " +
		 		$char_4.mightScale[$char_4.might] + " " + 
		 		$char_4.sanityScale[$char_4.sanity] + " " + 
		 		$char_4.knowledgeScale[$char_4.knowledge] + " " +"</center>");
		
		 $player_5_stats.html("<center>" + $char_5.speedScale[$char_5.speed] + " " +
		 		$char_5.mightScale[$char_5.might] + " " + 
		 		$char_5.sanityScale[$char_5.sanity] + " " + 
		 		$char_5.knowledgeScale[$char_5.knowledge] + " " + "</center>");
		
		 $player_6_stats.html("<center>" + $char_6.speedScale[$char_6.speed] + " " +
		 		$char_6.mightScale[$char_6.might] + " " + 
		 		$char_6.sanityScale[$char_6.sanity] + " " + 
		 		$char_6.knowledgeScale[$char_6.knowledge] + " " + "</center>");
	    
	     moves = $char_1.speedScale[$char_1.speed - 1];
	     movesp.innerHTML = $char_1.speedScale[$char_1.speed - 1];
		 const $objective_description = $("#objective_description");
		 $objective_description.html("<center>Something weird is going on... <p>Explore the house and find out what!</p></center>");
     	document.getElementById("player_1").style.borderColor = "yellow";
}

const update = () => {
	
	current_char = turn + 1;
	
	//this is the action that just happened
	const postParameters = {};

    $.post("/betrayal", postParameters, responseJSON => {

        const responseObject = JSON.parse(responseJSON);

        //updates everything for the one character whose turn it is currently
	
    });
}

const itemDrawn = () => {
	
	current_char = turn + 1;
	
	if(current_char === 1) name = $char_1.name;
	if(current_char === 2) name = $char_2.name;
	if(current_char === 3) name = $char_3.name;
	if(current_char === 4) name = $char_4.name;
	if(current_char === 5) name = $char_5.name;
	if(current_char === 6) name = $char_6.name;

	$item_window.show();
	$("#item_name").html("NAME");
	$("#item_description").html(name + " found an item! [ADD DESCRIPTION]");
	
	$("#end_turn").unbind().click(event => {

		$item_window.hide();
		
		endturn();

    });
	
}

const omenDrawn = () => {
	
	current_char = turn + 1;
	
	$omen_window.show();
	$("#omen_name").html("NAME");
	$("#omen_description").html("You've got an omen! [ADD DESCRIPTION]");
	
	$("#roll_haunt").unbind().click(event => {

		$omen_window.hide();
		
		//add omen to current player
		
    });
	
}

const eventDrawn = () => {
	
	current_char = turn + 1;
	
	$event_window.show();
	$("#event_name").html("NAME");
	$("#event_description").html("You've got an event! [ADD DESCRIPTION]");
	
	$("#event_action").unbind().click(event => {
		
		$event_window.hide();
		
		//do event stuff

    });
	
}


