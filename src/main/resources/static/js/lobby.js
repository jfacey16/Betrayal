let choices = responseObject.characterChoices;

	const postParameters = {players:"6"};

    $.post("/create_game", postParameters, responseJSON => {

        // TODO: Parse the JSON response into a JavaScript object. DONE
        const responseObject = JSON.parse(responseJSON);
        
        console.log(responseObject);

				let choices = responseObject.characterChoices;
    });
for (let i = 0; i < choices.length; i++) {
  let characterMapping = [];
  characterMapping.push(i);
  characterMapping.push(choices[0]);
  characters.push(characterMapping);
}
console.log("HI");
$.post("/tileStart", {"0": "Ox Bellows", "1": "Madame Zostra", "2": "Brandon Jaspers", "3": "Missy Dubourde",
  "4": "Professor Longfellow", "5": "Jenny LeClerc"}, rj2 => {
  const ro2 = JSON.parse(rj2);
  console.log("HI2");
  console.log(ro2.tile);
  console.log(ro2.character);
});
