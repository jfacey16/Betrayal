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

function itemDrawn(card_info, room_name) {

	$item_window.show();
	$("#item_info").html(current_char_name + " has found an item in the " + room_name + ".");
	$("#item_name").html("<font size=\"4px\">" + card_info.name + "</font>");
	$("#item_description").html(card_info.description);
	$("#item_logic").html(card_info.logic);
	
	$("#end_turn").unbind().click(event => {

		$item_window.hide();
		
		addItem(card_info);
		
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
    });
	
}

function omenDrawn(card_info, room_name) {
	
	$omen_window.show();
	$("#omen_info").html(current_char_name + " has found an omen in the " + room_name + ".");
	$("#omen_name").html("<font size=\"4px\">" + card_info.name + "</font>");
	$("#omen_description").html(card_info.description);
	$("#omen_logic").html(card_info.logic);
	
	$("#roll_haunt").unbind().click(event => {

		$omen_window.hide();
		
		addOmen(card_info);
		
		turn_end();
		
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

function eventDrawn(card_info, room_name) {
	
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

function addItem(card_info) {
	///refresh values
	
	console.log("refresh game and add item");
	
	if(current_char === 0) {
		$("#items_1").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:500px\"></div>");
	} else if(current_char === 1) {
		$("#items_2").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 2) {
		$("#items_3").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 3) {
		$("#items_4").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 4) {
		$("#items_5").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 5) {
		$("#items_6").html("<div id=\"" + card_info.name + "\" class=\"item\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else {
		console.log("ERROR: should never get here, bad # of players");
	}
	
    const new_item = document.getElementById(card_info.name);
	
    new_item.onmouseover = function() {
        $("#" + card_info.name + "_popup").html(card_info.logic);
        console.log($("#" + card_info.name + "_popup").val());
        document.getElementById(card_info.name + "_popup").style.display = 'block';
    };
   
    new_item.onmouseout = function() {
        document.getElementById(card_info.name + "_popup").style.display = 'none';
    };
}

function addOmen(card_info) {

	console.log("refresh game and add omen");
	
	if(current_char === 0) {
		$("#omens_1").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:500px\"></div>");
	} else if(current_char === 1) {
		$("#omens_2").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 2) {
		$("#omens_3").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 3) {
		$("#omens_4").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 4) {
		$("#omens_5").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else if(current_char === 5) {
		$("#omens_6").html("<div id=\"" + card_info.name + "\" class=\"omen\">" + card_info.name + "</div>" +
				"<div id=\"" + card_info.name + "_popup\" class=\"popup_stats\" style=\"top:150px\"></div>");
	} else {
		console.log("ERROR: should never get here, bad # of players");
	}

    const new_omen = document.getElementById(card_info.name);
	
    new_omen.onmouseover = function() {
        $("#" + card_info.name + "_popup").html(card_info.logic);
        console.log($("#" + card_info.name + "_popup").val());
        document.getElementById(card_info.name + "_popup").style.display = 'block';
    };
   
    new_omen.onmouseout = function() {
        document.getElementById(card_info.name + "_popup").style.display = 'none';
    };
}
