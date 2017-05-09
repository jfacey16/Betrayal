let $item_window;
let $omen_window;
let $event_window;

$(document).ready(() => {
	
	$item_window = $("#item");
	$omen_window = $("#omen");
	$event_window = $("#event");

	$('#item').draggable();
	$('#omen').draggable();
	$('#event').draggable();
	
	$('#item').draggable();
	$('#omen').draggable();
	$('#event').draggable();
	
	$item_window.hide();
	$omen_window.hide();
	$event_window.hide();
});

function itemDrawn(data, card_info, room_name) {

	$item_window.show();
	$("#item_info").html(current_char_name + " has found an item in the " + room_name + ".");
	$("#item_name").html("<font size=\"4px\">" + card_info.name + "</font>");
	$("#item_description").html(card_info.description);
	$("#item_logic").html(card_info.logic);
	
	$("#end_turn").unbind().click(event => {

		$item_window.hide();

		addItem(JSON.parse(data.payload).character, card_info);
		
		turn_end();
		
		var message = {
				type: MESSAGE_TYPE.GAMEMOVE,
				payload: {
					id : userId,
					query : {
						name : "end"
					}
				}
	      }

		const json = JSON.stringify(message);
		conn.send(json);

		$("#item_info").html("");
		$("#item_name").html("");
		$("#item_description").html("");
		$("#item_logic").html("");
    });
}

function omenDrawn(data, card_info, room_name) {
	
	$omen_window.show();
	$("#omen_info").html(current_char_name + " has found an omen in the " + room_name + ".");
	$("#omen_name").html("<font size=\"4px\">" + card_info.name + "</font>");
	$("#omen_description").html(card_info.description);
	$("#omen_logic").html(card_info.logic);
	
	$("#roll_haunt").unbind().click(event => {
		
		addOmen(JSON.parse(data.payload).character, card_info);
		
		var message = {
				type: MESSAGE_TYPE.GAMEMOVE,
				payload: {
					id : userId,
					query : {
						name : "haunt"
					}
				}
	      }

		const json = JSON.stringify(message);
		conn.send(json);
		
    });
}

function omenRoll(data) {
	
	var rolls = data.rolls;
	var all_rolls = "<center>You rolled the following values:</center><br /><center>";
	var sum = 0;

	for(roll in rolls) {
		all_rolls += rolls[roll] + " ";
		sum += rolls[roll];
	}
	
	all_rolls += " = " + sum + "</center>" +
		"<center><button type=\"button\" id=\"end_turn_omen\">End Turn</button></center>";
	
	$("#omen_roll").html(all_rolls);
	var omen_info = document.getElementById("omen_cont");
	omen_info.scrollTop = omen_info.scrollHeight;
		
	$("#end_turn_omen").unbind().click(event => {

		$omen_window.hide();
		
		turn_end();
		
		$("#omen_roll").html("");
		$("#omen_info").html("");
		$("#omen_name").html("");
		$("#omen_description").html("");
		$("#omen_logic").html("");
    });
}

function eventDrawn(data, card_info, room_name) {
	
	$event_window.show();
	$("#event_info").html(current_char_name + " has encountered an event in the " + room_name + ".");
	$("#event_name").html("<font size=\"4px\">" + card_info.name + "</font>");
	$("#event_description").html(card_info.description);
	$("#event_logic").html(card_info.logic);
	
	$("#event_action").unbind().click(event => {
		
		$event_window.hide();
		
		//do event stuff

    });
	
}

function addItem(data, card_info) {
	///refresh values
	
	console.log("refresh game and add item");
	
	if(current_char === 0) {
		$("#items_1").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:500px\">" + card_info.logic + "</div>");
		update_player_1(data);
		
	} else if(current_char === 1) {
		$("#items_2").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_21(data);
		
	} else if(current_char === 2) {
		$("#items_3").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_3(data);
		
	} else if(current_char === 3) {
		$("#items_4").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_4(data);
		
	} else if(current_char === 4) {
		$("#items_5").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_5(data);
		
	} else if(current_char === 5) {
		$("#items_6").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_6(data);
		
	} else {
		console.log("ERROR: should never get here, bad # of players");
	}

	console.log(document.getElementById(card_info.name));
	
	document.getElementById(card_info.name).onmouseover = function() {
        document.getElementById(card_info.name + "_popup").style.display = 'block';
    };
   
    document.getElementById(card_info.name).onmouseout = function() {
        document.getElementById(card_info.name + "_popup").style.display = 'none';
    };
}

function addOmen(data, card_info) {

	console.log("refresh game and add omen");
	
	if(current_char === 0) {
		$("#items_1").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:500px\">" + card_info.logic + "</div>");
		update_player_1(data);
		
	} else if(current_char === 1) {
		$("#items_2").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_2(data);
		
	} else if(current_char === 2) {
		$("#items_3").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_3(data);
		
	} else if(current_char === 3) {
		$("#items_4").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_4(data);
		
	} else if(current_char === 4) {
		$("#items_5").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_5(data);
		
	} else if(current_char === 5) {
		$("#items_6").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\">" + card_info.logic + "</div>");
		update_player_6(data);
		
	} else {
		console.log("ERROR: should never get here, bad # of players");
	}

	document.getElementById(card_info.name).onmouseover = function() {
        document.getElementById(card_info.name + "_popup").style.display = 'block';
    };
   
    document.getElementById(card_info.name).onmouseout = function() {
        document.getElementById(card_info.name + "_popup").style.display = 'none';
    };
}

function update_player_1(data) {
	
	const $player_1_speed = $("#speed_1");
    var $speed = "<center>";
  
    for (let i = 0, len = data.speedScale.length; i < len; i++) {
       if(i === data.speed) {
           $speed += "<font color=\"red\">" + data.speedScale[i] + "</font> ";
       } else {
           $speed += data.speedScale[i] + " ";
       }
    }
  
    const $player_1_might = $("#might_1");
    var $might = "<center>";
  
    for (let i = 0, len = data.mightScale.length; i < len; i++) {
       if(i === data.might) {
           $might += "<font color=\"red\">" + data.mightScale[i] + "</font> ";
       } else {
           $might += data.mightScale[i] + " ";
       }
    }
  
    const $player_1_sanity = $("#sanity_1");
    var $sanity = "<center>";

    for (let i = 0, len = data.sanityScale.length; i < len; i++) {
       if(i === data.sanity) {
           $sanity += "<font color=\"red\">" + data.sanityScale[i] + "</font> ";
       } else {
           $sanity += data.sanityScale[i] + " ";
       }
    }

    const $player_1_knowledge = $("#knowledge_1");
    var $knowledge = "<center>";
  
    for (let i = 0, len = data.knowledgeScale.length; i < len; i++) {
       if(i === data.knowledge) {
           $knowledge += "<font color=\"red\">" + data.knowledgeScale[i] + "</font> ";
       } else {
           $knowledge += data.knowledgeScale[i] + " ";
       }
    }
    $player_1_speed.html("");
    $player_1_might.html("");
    $player_1_knowledge.html("");
    $player_1_sanity.html("");
    $player_1_speed.html($speed + "</center>");
    $player_1_might.html($might + "</center>");
    $player_1_knowledge.html($knowledge + "</center>");
    $player_1_sanity.html($sanity + "</center>");
}

function update_player_2(data) {
	
	const $player_2_stats = $("#stats_2");
	$player_2_stats.html("");

	$player_2_stats.html("<center>" + data.speedScale[data.speed] + " " +
		data.mightScale[data.might] + " " + 
		data.sanityScale[data.sanity] + " " +
		data.knowledgeScale[data.knowledge] + " " + "</center>");
}

function update_player_3(data) {
	
	const $player_3_stats = $("#stats_3");
	$player_3_stats.html("");

	$player_3_stats.html("<center>" + data.speedScale[data.speed] + " " +
		data.mightScale[data.might] + " " + 
		data.sanityScale[data.sanity] + " " +
		data.knowledgeScale[data.knowledge] + " " + "</center>");
}

function update_player_4(data) {
	
	const $player_4_stats = $("#stats_4");
	$player_4_stats.html("");

	$player_4_stats.html("<center>" + data.speedScale[data.speed] + " " +
		data.mightScale[data.might] + " " + 
		data.sanityScale[data.sanity] + " " +
		data.knowledgeScale[data.knowledge] + " " + "</center>");
}

function update_player_5(data) {
	
	const $player_5_stats = $("#stats_5");
	$player_5_stats.html("");

	$player_5_stats.html("<center>" + data.speedScale[data.speed] + " " +
		data.mightScale[data.might] + " " + 
		data.sanityScale[data.sanity] + " " +
		data.knowledgeScale[data.knowledge] + " " + "</center>");
}

function update_player_6(data) {
	
	const $player_6_stats = $("#stats_6");
	$player_6_stats.html("");

	$player_6_stats.html("<center>" + data.speedScale[data.speed] + " " +
		data.mightScale[data.might] + " " + 
		data.sanityScale[data.sanity] + " " +
		data.knowledgeScale[data.knowledge] + " " + "</center>");
}


