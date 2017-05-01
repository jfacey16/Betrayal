$(document).ready(() => {
	
	const postParameters = {};

    $.post("/create_game", postParameters, responseJSON => {

        // TODO: Parse the JSON response into a JavaScript object. DONE
        const responseObject = JSON.parse(responseJSON);
        
        
        console.log(responseObject);
        
    });
});  
  
