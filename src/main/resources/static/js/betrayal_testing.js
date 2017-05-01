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
});  
  
const setStartingState = () => {
	const $player_1_name = $("#name_1");
	const $player_2_name = $("#name_2");
	const $player_3_name = $("#name_3");
	const $player_4_name = $("#name_4");
	const $player_5_name = $("#name_5");
	const $player_6_name = $("#name_6");
	
	$player_1_name.html("<center>" + "Sarah" + "</center>");
	$player_2_name.html("<center>" + "Sarah" + "</center>");
	$player_3_name.html("<center>" + "Sarah" + "</center>");
	$player_4_name.html("<center>" + "Sarah" + "</center>");
	$player_5_name.html("<center>" + "Sarah" + "</center>");
	$player_6_name.html("<center>" + "Sarah" + "</center>");
	
	
	const $player_1_speed = $("#speed_1");
	const $player_1_might = $("#might_1");
	const $player_1_knowledge = $("#knowledge_1");
	const $player_1_sanity = $("#sanity_1");
	const $player_2_stats = $("#stats_2");
	const $player_3_stats = $("#stats_3");
	const $player_4_stats = $("#stats_4");
	const $player_5_stats = $("#stats_5");
	const $player_6_stats = $("#stats_6");
	
	$player_2_stats.html("<center>" + "Sarah" + "</center>");
	$player_3_stats.html("<center>" + "Sarah" + "</center>");
	$player_4_stats.html("<center>" + "Sarah" + "</center>");
	$player_5_stats.html("<center>" + "Sarah" + "</center>");
	$player_6_stats.html("<center>" + "Sarah" + "</center>");

	const $player_2_items = $("#items_2");
	const $player_3_items = $("#items_3");
	const $player_4_items = $("#items_4");
	const $player_5_items = $("#items_5");
	const $player_6_items = $("#items_6");
	
	$player_2_items.html("<center>" + "Sarah" + "</center>");
	$player_3_items.html("<center>" + "Sarah" + "</center>");
	$player_4_items.html("<center>" + "Sarah" + "</center>");
	$player_5_items.html("<center>" + "Sarah" + "</center>");
	$player_6_items.html("<center>" + "Sarah" + "</center>");
	
}