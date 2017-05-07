let $item_window;
let $omen_window;
let $event_window;

$(document).ready(() => {
	
	$item_window = $("#item");
	$omen_window = $("#omen");
	$event_window = $("#event");
	
	$item_window.hide();
	$omen_window.hide();
	$event_window.hide();

    $(document).keypress(function(e) {
        
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
});

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