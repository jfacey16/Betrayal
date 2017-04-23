//const MAP_HEIGHT = 500;
//const MAP_WIDTH = 700;
//
//// Global reference to the canvas element.
//let canvas;
//
//// Global reference to the canvas' context.
//let ctx;
//
///*
//	When the document is ready, this runs.
//*/
//$(document).ready(() => {
//	
//	// Setting up the canvas.
//    canvas = $('#canvas')[0];
//    canvas.width = MAP_WIDTH;
//    canvas.height = MAP_HEIGHT;
//
//    // Set up the canvas context.
//    ctx = canvas.getContext("2d");
//
//    paintBoard();
//});
//
///*
//	Paints the boggle board.
//*/
//const paintBoard = () => {
//	
//	// Setting the context's font and lineWidth.
//    ctx.font = '50px Andale Mono';
//    ctx.lineWidth = 1;
//
//    // Fill the background color of the canvas element DONE
//    // to something other than white
//    ctx.fillStyle="#ffffff";
//    ctx.fillRect(0,0,MAP_WIDTH,MAP_HEIGHT);
//
//    // Draw the grid lines
//    ctx.beginPath();
//    ctx.moveTo(0,0);
//    ctx.lineTo(MAP_WIDTH, 0);
//    ctx.stroke();
//    ctx.lineTo(MAP_WIDTH,MAP_HEIGHT);
//    ctx.stroke();
//    ctx.lineTo(0,MAP_HEIGHT);
//    ctx.stroke();
//    ctx.lineTo(0,0);
//    ctx.stroke();
//    
//	const postParameters = "";
//	
//	$.post("/mapping", postParameters, responseJSON => {
//		
//		ctx.lineWidth = 10;
//		ctx.strokeStyle = "#808080";
//
//        const responseObject = JSON.parse(responseJSON);
//        const ways = responseObject.ways;
//        
//        console.log(ways.length);
//        
//        //we assume that the following constraints are in place:
////      private static double NW_LAT = 41.8209;
////		private static double NW_LON = -71.4006;
////		private static double SE_LAT = 41.8197;
////		private static double SE_LON = -71.3997;
//		
//        for (let i = 0; i < ways.length; i++) {
//        	
//
//            console.log((Math.abs(-71.4006 - ways[i][1]) /.009) *700);
//            console.log(ways[i][1]);
//            console.log((Math.abs(-71.4006 - ways[i][3]) /.009) *700);
//            console.log(ways[i][1]);
//        	
//        	ctx.beginPath();
//            ctx.moveTo( (Math.abs(-71.4006 - ways[i][1]) /.0009) *700, (Math.abs(41.8209 - ways[i][0]) /.0012) *500);
//            ctx.lineTo( (Math.abs(-71.4006 - ways[i][3]) /.0009) *700, (Math.abs(41.8209 - ways[i][2]) /.0012) *500);
//            ctx.stroke();
//            
//        }
//    });
//    
//};
//
//
//const $street_1 = $("#street_1");
//
//const $cstreet_1 = $("#cstreet_1");
//
//const $street_2 = $("#street_2");
//
//const $cstreet_2 = $("#cstreet_2");
//
//const list_elements = $("li");
//
//$($street_1).keyup(event => {
//	
//	console.log($street_1.val()); 
//	currText = $street_1.val();
//	
//	const postParameters = {text:currText};
//	
//    $.post("/mapcorrecting", postParameters, responseJSON => {
//
//        const responseObject = JSON.parse(responseJSON);
//        const results = responseObject.results;
//        
//        for (let i = 0, len = list_elements.length; i < len; i++) {
//            $(list_elements[i]).text(results[i]);
//        }
//    });
//	
//});
//
//$($cstreet_1).keyup(event => {
//	
//	console.log($cstreet_1.val()); 
//	currText = $cstreet_1.val();
//	
//	const postParameters = {text:currText};
//	
//    $.post("/mapcorrecting", postParameters, responseJSON => {
//
//        const responseObject = JSON.parse(responseJSON);
//        const results = responseObject.results;
//        
//        for (let i = 0, len = list_elements.length; i < len; i++) {
//            $(list_elements[i]).text(results[i]);
//        }
//    });
//	
//});
//
//$($street_2).keyup(event => {
//	
//	console.log($street_2.val()); 
//	currText = $street_2.val();
//	
//	const postParameters = {text:currText};
//	
//    $.post("/mapcorrecting", postParameters, responseJSON => {
//
//        const responseObject = JSON.parse(responseJSON);
//        const results = responseObject.results;
//        
//        for (let i = 0, len = list_elements.length; i < len; i++) {
//            $(list_elements[i]).text(results[i]);
//        }
//    });
//	
//});
//
//$($cstreet_2).keyup(event => {
//	
//	console.log($cstreet_2.val()); 
//	currText = $cstreet_2.val();
//	
//	const postParameters = {text:currText};
//	
//    $.post("/mapcorrecting", postParameters, responseJSON => {
//
//        const responseObject = JSON.parse(responseJSON);
//        const results = responseObject.results;
//        
//        for (let i = 0, len = list_elements.length; i < len; i++) {
//            $(list_elements[i]).text(results[i]);
//        }
//    });
//	
//});
//
/////*
////	Called when the board is clicked.
////	This function does two things if the click was valid:
////	- Paints the clicked square on the board
////	- Draws a path from the previous click to the current click
////*/
////const paintOnClick = event => {
////
////	// Get the x, y coordinates of the click event
////	// with (0, 0) being the top left corner of canvas.
////    const x = event.pageX - canvas.offsetLeft;
////    const y = event.pageY - canvas.offsetTop;
////
////    // TODO: Use these x, y coordinates to determine DONE
////    // the row and column of the clicked tile.
////    
////    var col = 0;
////    var row = 0;
////    
////    if(x >= 0 && x <= 4*TILE_SIZE){
////    	if(x < TILE_SIZE) {
////    		row = 0;
////    	} else if(x < 2*TILE_SIZE && x >= TILE_SIZE) {
////    		row = 1;
////    	} else if(x < 3*TILE_SIZE && x >= 2*TILE_SIZE) {
////    		row = 2;
////    	} else if(x < 4*TILE_SIZE && x >= 3*TILE_SIZE) {
////    		row = 3;
////    	} else {
////    		System.out.println("Should never get here!");
////    	}
////    } else {
////    	System.out.println("If this ever prints, you gotta fix something in canvas.js.");
////    }
////    
////    if(y >= 0 && y <= 4*TILE_SIZE){
////    	if(y < TILE_SIZE) {
////    		col = 0;
////    	} else if(y < 2*TILE_SIZE && y >= TILE_SIZE) {
////    		col = 1;
////    	} else if(y < 3*TILE_SIZE && y >= 2*TILE_SIZE) {
////    		col = 2;
////    	} else if(y < 4*TILE_SIZE && y >= 3*TILE_SIZE) {
////    		col = 3;
////    	} else {
////    		System.out.println("Should never get here!");
////    	}
////    } else {
////    	System.out.println("If this ever prints, you gotta fix something in canvas.js.");
////    }
////    
////    const currPosition = new Position(row, col);
////    const lastPosition = positions[positions.length-1];
////
////    if (positions.length === 0 || isValidClick(lastPosition, currPosition)) {
////
////    	const letter = letterGrid[row][col];
////
////    	// TODO: Using the row and col variables, change the color of the
////    	// clicked tile with ctx.fillRect() and ctx.fillText().
////        
////        ctx.fillStyle="#ff8080";
////        ctx.fillRect(row*TILE_SIZE,col*TILE_SIZE,TILE_SIZE,TILE_SIZE);
////        ctx.lineWidth = 10;
////        
////        
////        ctx.fillStyle="#ffffff";
////        ctx.fillText(letterGrid[row][col],TILE_SIZE/2 + row*TILE_SIZE + -14,TILE_SIZE/2 + col*TILE_SIZE +14);
////
////	    // Drawing the path from the previous click to the current click.
////    	if (positions.length === 0) { // Is first click
////    		ctx.beginPath();
////	        ctx.moveTo(x, y);
////	        currWord += letter.toLowerCase();
////	        positions.push(currPosition);
////	    } else if (isValidClick(lastPosition, currPosition)) {
////	        ctx.lineTo(x, y);
////	        ctx.stroke();
////	        currWord += letter.toLowerCase();
////	        positions.push(currPosition);
////	    }
////
////    }
////}
