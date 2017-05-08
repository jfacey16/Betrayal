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
	
	$item_window.hide();
	$omen_window.hide();
	$event_window.hide();

//    $(document).keypress(function(e) {
//        
//        if(e.which == 49) {
//            itemDrawn();
//        }
//        
//        if(e.which == 50) {
//            omenDrawn();
//        }
//        
//        if(e.which == 51) {
//            eventDrawn();
//        }
//    });
});

function itemDrawn(name, description, func, room_name) {
	
	current_char = turn + 1;
	
	if(current_char === 1) char_name = $char_1.name;
	if(current_char === 2) char_name = $char_2.name;
	if(current_char === 3) char_name = $char_3.name;
	if(current_char === 4) char_name = $char_4.name;
	if(current_char === 5) char_name = $char_5.name;
	if(current_char === 6) char_name = $char_6.name;

	$item_window.show();
	$("#item_info").html(char_name + " has found an item in the " + room_name + ".");
	$("#item_name").html(name);
	$("#item_description").html(description);
	
	$("#end_turn").unbind().click(event => {

		$item_window.hide();
		
		endturn();

    });
	
}

function omenDrawn(name, description, func, room_name) {
	
	current_char = turn + 1;
	
	if(current_char === 1) char_name = $char_1.name;
	if(current_char === 2) char_name = $char_2.name;
	if(current_char === 3) char_name = $char_3.name;
	if(current_char === 4) char_name = $char_4.name;
	if(current_char === 5) char_name = $char_5.name;
	if(current_char === 6) char_name = $char_6.name;
	
	$omen_window.show();
	$("#omen_info").html(char_name + " has found an omen in the " + room_name + ".");
	$("#omen_name").html(name);
	$("#omen_description").html(description);
	
	$("#roll_haunt").unbind().click(event => {

		$omen_window.hide();
		
		//add omen to current player
		
    });
	
}

function eventDrawn(name, description, func, room_name) {
	
	current_char = turn + 1;
	
	if(current_char === 1) char_name = $char_1.name;
	if(current_char === 2) char_name = $char_2.name;
	if(current_char === 3) char_name = $char_3.name;
	if(current_char === 4) char_name = $char_4.name;
	if(current_char === 5) char_name = $char_5.name;
	if(current_char === 6) char_name = $char_6.name;
	
	$event_window.show();
	$("#event_info").html(char_name + " has encountered an event in the " + room_name + ".");
	$("#event_name").html(name);
	$("#event_description").html(description);
	
	$("#event_action").unbind().click(event => {
		
		$event_window.hide();
		
		//do event stuff

    });
	
}