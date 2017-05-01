$(document).ready(() => {
	
	const postParameters = {};
	
	
    console.log("hi");

    $.post("/create_game", postParameters, responseJSON => {

        // TODO: Parse the JSON response into a JavaScript object. DONE
        const responseObject = JSON.parse(responseJSON);
        
        
        console.log(responseObject);
        
    });
});  
  
