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

function addItem(name, logic) {
	///refresh values
	
	console.log("add item");
	
}

function addOmen(name, logic) {

	console.log("add omen");
	
}
