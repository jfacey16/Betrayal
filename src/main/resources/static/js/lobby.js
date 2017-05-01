$(document).ready(() => {

	const postParameters = {players:"6"};


    console.log("hi");

    $.post("/create_game", postParameters, responseJSON => {

        // TODO: Parse the JSON response into a JavaScript object. DONE
        const responseObject = JSON.parse(responseJSON);

				let choices = responseObject.characterChoices;
				console.log(responseObject.characterChoices);

    });
});
