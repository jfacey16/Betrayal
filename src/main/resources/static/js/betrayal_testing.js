$(document).ready(() => {
	
	
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
  
  