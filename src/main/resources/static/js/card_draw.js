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

    // $(document).keypress(function(e) {
        
    //     if(e.which == 49) {
    //         itemDrawn();
    //     }
        
    //     if(e.which == 50) {
    //         omenDrawn();
    //     }
        
    //     if(e.which == 51) {
    //         eventDrawn();
    //     }
    // });
});

function itemDrawn(name, description, logic, room_name) {

	$item_window.show();
	$("#item_info").html(current_char_name + " has found an item in the " + room_name + ".");
	$("#item_name").html("<font size=\"4px\">" + name + "</font>");
	$("#item_description").html(description);
	$("#item_logic").html(logic);
	
	$("#end_turn").unbind().click(event => {

		$item_window.hide();
		
//		addItem(name, logic);
		
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

function omenDrawn(name, description, logic, room_name) {
	
	$omen_window.show();
	$("#omen_info").html(current_char_name + " has found an omen in the " + room_name + ".");
	$("#omen_name").html("<font size=\"4px\">" + name + "</font>");
	$("#omen_description").html(description);
	$("#omen_logic").html(logic);
	
	$("#roll_haunt").unbind().click(event => {

		$omen_window.hide();
		
		//add omen to current player
		
    });
	
}

function eventDrawn(name, description, logic, room_name) {
	
	$event_window.show();
	$("#event_info").html(current_char_name + " has encountered an event in the " + room_name + ".");
	$("#event_name").html("<font size=\"4px\">" + name + "</font>");
	$("#event_description").html(description);
	$("#event_logic").html(logic);
	
	$("#event_action").unbind().click(event => {
		
		$event_window.hide();
		
		//do event stuff

    });
	
}