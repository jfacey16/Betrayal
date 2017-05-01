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

$(document).ready(() => {
	
	$player_1_select = $("#player_1_select");
	$player_2_select = $("#player_2_select");
	$player_3_select = $("#player_3_select");
	$player_4_select = $("#player_4_select");
	$player_5_select = $("#player_5_select");
	$player_6_select = $("#player_6_select");
	
	// setup for all players
	pickCharacters();
	
	const $temp_lobby = $("#temp_lobby");
	const $item_card = $("#item");
	var x = 1;
	$item_card.hide();
	$temp_lobby.show();
  

$(document).ready(() => {


	//setup for all players
	setStartingState();

	const $item_card = $("#item");
	var x = 1;
	$item_card.hide();

	function revealCard() {
		$item_card.show();
		x = 0;
	}

    function hideCard() {
  	  $item_card.hide();
  	  x = 1;
    }

    $(document).keypress(function(e) {
        if(e.which == 13) {
            if(x == 1) {
            	revealCard();
            } else {
            	hideCard();
            }
        }
    });

    const $create = $("#create");
    
    $create.on('click', function(e) {
    	
    	e.preventDefault();

    	console.log("yay!");
    	
    	$temp_lobby.hide();

    	setStartingState();

    });
});

const pickCharacters = () => {
	const postParameters = {players:"6"};

    $.post("/create_game", postParameters, responseJSON => {

        // TODO: Parse the JSON response into a JavaScript object. DONE
        const responseObject = JSON.parse(responseJSON);
    	
    	console.log(responseObject.characterChoices[0][0].name);
    	
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
      const responseObject = JSON.parse(responseJSON);

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

	const postParameters = {players:"6"};

    $.post("/create_game", postParameters, responseJSON => {

        // TODO: Parse the JSON response into a JavaScript object. DONE
        const responseObject = JSON.parse(responseJSON);
	
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

	const $player_1_knowledge = $("#knowledge_1");
	var $knowledge = "<center>";
	
	for (let i = 0, len = $char_1.knowledgeScale.length; i < len; i++) {
		if(i === $char_1.knowledge) {
			$knowledge += "<font color=\"red\">" + $char_1.knowledgeScale[i] + "</font> ";
		} else {
			$knowledge += $char_1.knowledgeScale[i] + " ";
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
	
	$player_1_speed.html($speed + "</center>");
	$player_1_might.html($might + "</center>");
	$player_1_knowledge.html($knowledge + "</center>");
	$player_1_sanity.html($sanity + "</center>");
	

	const $player_2_stats = $("#stats_2");
	const $player_3_stats = $("#stats_3");
	const $player_4_stats = $("#stats_4");
	const $player_5_stats = $("#stats_5");
	const $player_6_stats = $("#stats_6");
	
	$player_2_stats.html("<center>" + $char_2.speedScale[$char_2.speed - 1] + " " +
			$char_2.mightScale[$char_2.might - 1] + " " + 
			$char_2.knowledgeScale[$char_2.knowledge - 1] + " " +
			$char_2.sanityScale[$char_2.sanity - 1] + " " + "</center>");
	
	$player_3_stats.html("<center>" + $char_3.speedScale[$char_3.speed - 1] + " " +
			$char_3.mightScale[$char_3.might - 1] + " " + 
			$char_3.knowledgeScale[$char_3.knowledge - 1] + " " +
			$char_3.sanityScale[$char_3.sanity - 1] + " " + "</center>");
	
	$player_4_stats.html("<center>" + $char_4.speedScale[$char_4.speed - 1] + " " +
			$char_4.mightScale[$char_4.might - 1] + " " + 
			$char_4.knowledgeScale[$char_4.knowledge - 1] + " " +
			$char_4.sanityScale[$char_4.sanity - 1] + " " + "</center>");
	
	$player_5_stats.html("<center>" + $char_5.speedScale[$char_5.speed - 1] + " " +
			$char_5.mightScale[$char_5.might - 1] + " " + 
			$char_5.knowledgeScale[$char_5.knowledge - 1] + " " +
			$char_5.sanityScale[$char_5.sanity - 1] + " " + "</center>");
	
	$player_6_stats.html("<center>" + $char_6.speedScale[$char_6.speed - 1] + " " +
			$char_6.mightScale[$char_6.might - 1] + " " + 
			$char_6.knowledgeScale[$char_6.knowledge - 1] + " " +
			$char_6.sanityScale[$char_6.sanity - 1] + " " + "</center>");
	
	const $objective_description = $("#objective_description");
	$objective_description.html("<center>Something weird is going on... <p>Explore the house and find out what!</p></center>")
	
	
//	const $player_2_items = $("#items_2");
//	const $player_3_items = $("#items_3");
//	const $player_4_items = $("#items_4");
//	const $player_5_items = $("#items_5");
//	const $player_6_items = $("#items_6");
//	
//	$player_2_items.html("<center>" + "Sarah" + "</center>");
//	$player_3_items.html("<center>" + "Sarah" + "</center>");
//	$player_4_items.html("<center>" + "Sarah" + "</center>");
//	$player_5_items.html("<center>" + "Sarah" + "</center>");
//	$player_6_items.html("<center>" + "Sarah" + "</center>");
	
    });
}
