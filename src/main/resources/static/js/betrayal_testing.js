const HEIGHT = 600;
const WIDTH = 900;

let canvas;

let ctx;

$(document).ready(() => {
	
    canvas = $('#canvas')[0];
    canvas.width = WIDTH;
    canvas.height = WIDTH;

    ctx = canvas.getContext("2d");
    
    paintBoard();

});

const paintBoard = () => {
	
	// Setting the context's font and lineWidth.
    ctx.font = '50px Andale Mono';
    ctx.lineWidth = 1;

    // Fill the background color of the canvas element DONE
    // to something other than white
    ctx.fillStyle="#eeeeee";
    ctx.fillRect(0,0,WIDTH,HEIGHT);

    ctx.beginPath();
    ctx.moveTo(0,0);
    ctx.lineTo(WIDTH, 0);
    ctx.lineTo(WIDTH,HEIGHT);
    ctx.lineTo(0,HEIGHT);
    ctx.lineTo(0,0);
    ctx.stroke();
    
};
