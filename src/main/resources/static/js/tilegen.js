let characters = [];
let $item_window;
let $omen_window;
let $event_window;

$(document).ready(() => {
 $.post("/create_game", {players : "6"}, responseJSON => {

 	const $temp_lobby = $("#temp_lobby");
	$item_window = $("#item");
	$omen_window = $("#omen");
	$event_window = $("#event");

	$item_window.hide();
	$omen_window.hide();
	$event_window.hide();
	$temp_lobby.hide();
   const responseObject = JSON.parse(responseJSON);
   let choices = responseObject.characterChoices;
     // TODO: Parse the JSON response into a JavaScript object. DONE

   console.log(choices);
   console.log(choices.length);
   for (let i = 0; i < choices.length; i++) {
     let characterMapping = [];
     characterMapping.push(i);
     characterMapping.push(choices[i][0]);
     characters.push(characterMapping);
   }
   console.log("HI");
   console.log(characters);
   $.post("/tileStart", {"0": "Ox Bellows", "1": "Madame Zostra", "2": "Brandon Jaspers", "3": "Missy Dubourde",
     "4": "Professor Longfellow", "5": "Jenny LeClerc"}, rj2 => {
       console.log("HI2");
     const ro2 = JSON.parse(rj2);
     console.log("HI2");
     console.log(ro2.tiles);
     console.log(ro2.characters);
   });

 });
});
