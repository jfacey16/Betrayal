$(document).ready(() => {

	const postParameters = {players:"6"};
<<<<<<< HEAD


    console.log("hi");
=======
>>>>>>> a1f72e205d79fa733d839dd80b0be5037841e047

    $.post("/create_game", postParameters, responseJSON => {

        // TODO: Parse the JSON response into a JavaScript object. DONE
        const responseObject = JSON.parse(responseJSON);
<<<<<<< HEAD

				let choices = responseObject.characterChoices;
				console.log(responseObject.characterChoices);

=======
>>>>>>> a1f72e205d79fa733d839dd80b0be5037841e047
    });
});
