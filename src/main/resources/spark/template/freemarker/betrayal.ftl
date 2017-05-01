<!doctype html>
<html lang="en">
<head>
  <title>Betrayal at House on the Hill</title>
  <style>
  #first, #second, #basement {position: relative; top:-425px; left:-375px;}
  #second, #basement {display: none;}
  #box {width:800px; height:514px; border: solid black 1px; overflow: hidden; border-width: 0px 0px 2px 0; position: relative; z-index: 0;}
  #mapf, #maps, #mapb {overflow: hidden; border:solid black 1px; border-width: 0 2px 2px 0; width:170px; height:170px;}
  #map {display: flex; flex-direction:column;}
  #container {display:flex; flex-direction:row;}
  #descr {position: absolute; right: 0; bottom: 0; width:150px; height:514px;
    background: #eeeeee; border: solid black 1px; border-width: 1px 0 0 2px; z-index: 1;}
  button {padding:5px; margin:5px; background:#eeeeee; font-size:14px; width:130px; height:40px;}
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="js/betrayal_testing.js"></script>
  <script src="js/tilegen.js"></script>
  <script type="text/javascript">
  class Tile {
    constructor(posx, posy, north, east, south, west) {
      this.posx = posx;
      this.posy = posy;
      this.north = north;
      this.east = east;
      this.south = south;
      this.west = west;
    }
  }
  class Player {
    constructor(posx, posy, floor, north, east, south, west) {
      this.posx = posx;
      this.posy = posy;
      this.floor = floor;
      this.north = north;
      this.east = east;
      this.south = south;
      this.west = west;
    }
  }
  class Position {
    constructor(posx, posy) {
      this.posx = posx;
      this.posy = posy;
    }
  }
  
  let $player_1_turn;
  let $player_2_turn;
  let $player_3_turn;
  let $player_4_turn;
  let $player_5_turn;
  let $player_6_turn;
  
  const T = 150;
  const P = 20;
  const D = 50;
  const X = 10;
  const S = 7.5;
  const offx = -375;
  const offy = -425;
  let turn = 0;
  const outside = new Tile(450,600,false,false,false,false); 
  const ehall = new Tile(600,600,true,true,true,false);
  const foyer = new Tile(750,600,true,true,true,true);
  const toupper = new Tile(900,600,false,false,false,true);
  const sland = new Tile(600,600,true,true,true,true);
  const bland = new Tile(600,600,true,true,true,true);
  let ftiles = [outside,ehall,foyer,toupper];
  let stiles = [sland];
  let btiles = [bland];
  let posp1 = new Player(600,600,1,true,true,true,false);
  let posp2 = new Player(600,600,1,true,true,true,false);
  let posp3 = new Player(600,600,1,true,true,true,false);
  let posp4 = new Player(600,600,1,true,true,true,false);
  let posp5 = new Player(600,600,1,true,true,true,false);
  let posp6 = new Player(600,600,1,true,true,true,false);
  const positions = [posp1, posp2, posp3, posp4, posp5, posp6];
  const offset1 = new Position(25,30);
  const offset2 = new Position(105,30);
  const offset3 = new Position(25,90);
  const offset4 = new Position(105,90);
  const offset5 = new Position(65,25);
  const offset6 = new Position(65,95);
  const offsets = [offset1, offset2, offset3, offset4, offset5, offset6];
  const v = new Position(50,10);
  const h = new Position(10,50);
  function tileExists(posx, posy, floor) {
    let temp;
    if (floor == 0)
      temp = btiles;
    else if (floor == 1)
      temp = ftiles;
    else if (floor == 2)
      temp = stiles;
    for (let i = 0; i < temp.length; i++) {
      if (temp[i].posx === posx && temp[i].posy === posy)
        return i;
    }
    return -1;
  }
  $( function() {
    $( "#first" ).draggable();
  } );
  $( function() {
    $( "#second" ).draggable();
  } );
  $( function() {
    $( "#basement" ).draggable();
  } );
  $( function() {
    $( "#mfirst" ).draggable();
  } );
  $( function() {
    $( "#msecond" ).draggable();
  } );
  $( function() {
    $( "#mbasement" ).draggable();
  } );
  function endturn() {
  
      if (turn >= 5)
        turn = 0;
      else 
        turn++;
      // player.innerHTML = turn + 1;
      
      if(turn === 0) {
      
	      moves = $char_1.speedScale[$char_1.speed - 1];
	      movesp.innerHTML = $char_1.speedScale[$char_1.speed - 1];
	      document.getElementById("player_1").style.borderColor = "yellow";
	      document.getElementById("player_2").style.borderColor = "black";
	      document.getElementById("player_3").style.borderColor = "black";
	      document.getElementById("player_4").style.borderColor = "black";
	      document.getElementById("player_5").style.borderColor = "black";
	      document.getElementById("player_6").style.borderColor = "black";
      }
      
      if(turn === 1) {
      
	      moves = $char_2.speedScale[$char_2.speed - 1];
	      movesp.innerHTML = $char_2.speedScale[$char_2.speed - 1];
	      document.getElementById("player_1").style.borderColor = "black";
	      document.getElementById("player_2").style.borderColor = "yellow";
	      document.getElementById("player_3").style.borderColor = "black";
	      document.getElementById("player_4").style.borderColor = "black";
	      document.getElementById("player_5").style.borderColor = "black";
	      document.getElementById("player_6").style.borderColor = "black";
      }
      
      if(turn === 2) {
      
	      moves = $char_3.speedScale[$char_3.speed - 1];
	      movesp.innerHTML = $char_3.speedScale[$char_3.speed - 1];
	      document.getElementById("player_1").style.borderColor = "black";
	      document.getElementById("player_2").style.borderColor = "black";
	      document.getElementById("player_3").style.borderColor = "yellow";
	      document.getElementById("player_4").style.borderColor = "black";
	      document.getElementById("player_5").style.borderColor = "black";
	      document.getElementById("player_6").style.borderColor = "black";
      }
      
      if(turn === 3) {
      
	      moves = $char_4.speedScale[$char_4.speed - 1];
	      movesp.innerHTML = $char_4.speedScale[$char_4.speed - 1];
	      document.getElementById("player_1").style.borderColor = "black";
	      document.getElementById("player_2").style.borderColor = "black";
	      document.getElementById("player_3").style.borderColor = "black";
	      document.getElementById("player_4").style.borderColor = "yellow";
	      document.getElementById("player_5").style.borderColor = "black";
	      document.getElementById("player_6").style.borderColor = "black";
      }
      
      if(turn === 4) {
      
	      moves = $char_5.speedScale[$char_5.speed - 1];
	      movesp.innerHTML = $char_5.speedScale[$char_5.speed - 1];
	      document.getElementById("player_1").style.borderColor = "black";
	      document.getElementById("player_2").style.borderColor = "black";
	      document.getElementById("player_3").style.borderColor = "black";
	      document.getElementById("player_4").style.borderColor = "black";
	      document.getElementById("player_5").style.borderColor = "yellow";
	      document.getElementById("player_6").style.borderColor = "black";
      }
      
      if(turn === 5) {
      
	      moves = $char_6.speedScale[$char_6.speed - 1];
	      movesp.innerHTML = $char_6.speedScale[$char_6.speed - 1];
	      document.getElementById("player_1").style.borderColor = "black";
	      document.getElementById("player_2").style.borderColor = "black";
	      document.getElementById("player_3").style.borderColor = "black";
	      document.getElementById("player_4").style.borderColor = "black";
	      document.getElementById("player_5").style.borderColor = "black";
	      document.getElementById("player_6").style.borderColor = "yellow";
      }
      
      if (positions[turn].floor == 0) {
        first.style.display = 'none';
        second.style.display = 'none';
        basement.style.display = 'block';
        const xpos = offx - (positions[turn].posx - 600) + edgex[0];
        const ypos = offy - (positions[turn].posy - 600) + edgey[0];
        basement.style.top = ypos + 'px';
        basement.style.left = xpos + 'px';
      } else if (positions[turn].floor == 1) {
        first.style.display = 'block';
        second.style.display = 'none';
        basement.style.display = 'none';
        const xpos = offx - (positions[turn].posx - 600) + edgex[1];
        const ypos = offy - (positions[turn].posy - 600) + edgey[1];
        first.style.top = ypos + 'px';
        first.style.left = xpos + 'px';
      } else if (positions[turn].floor == 2) {
        first.style.display = 'none';
        second.style.display = 'block';
        basement.style.display = 'none';
        const xpos = offx - (positions[turn].posx - 600) + edgex[2];
        const ypos = offy - (positions[turn].posy - 600) + edgey[2];
        second.style.top = ypos + 'px';
        second.style.left = xpos + 'px';
      }
      
  }
  function paintBoard(floor) {
    if (floor == 0 || floor == -1) {
      ctxb.strokeRect(600,600,T,T);
      ctxb.strokeRect(650,600,50,10);
      ctxb.strokeRect(650,740,50,10);
      ctxb.strokeRect(600,650,10,50);
      ctxb.strokeRect(740,650,10,50);
      ctxmb.strokeRect(80,80,P,P);
      if (btiles.length > 1) {
        for (let i = 1; i < btiles.length; i++) {
          ctxb.strokeRect(btiles[i].posx, btiles[i].posy, T, T);
          ctxmb.strokeRect(btiles[i].posx / S, btiles[i].posy / S, P, P);
          if (btiles[i].north) 
            ctxb.strokeRect(btiles[i].posx + D, btiles[i].posy, D, X);
          if (btiles[i].east) 
            ctxb.strokeRect(btiles[i].posx + T - X, btiles[i].posy + D, X, D);
          if (btiles[i].south)
            ctxb.strokeRect(btiles[i].posx + D, btiles[i].posy + T - X, D, X);
          if (btiles[i].west) 
            ctxb.strokeRect(btiles[i].posx, btiles[i].posy + D, X, D);
        }
      }
    } 
    if (floor == 1 || floor == -1) {
      ctxf.strokeRect(600,600,T*3,T);
      ctxf.moveTo(600,750);
      ctxf.arc(637.5,675,75,2*Math.PI/3,4*Math.PI/3);
      ctxf.stroke();
      ctxf.strokeRect(650,600,50,10);
      ctxf.strokeRect(650,740,50,10);
      ctxf.strokeRect(800,600,50,10);
      ctxf.strokeRect(800,740,50,10);
      ctxf.strokeRect(1040,610,10,130);
      ctxf.strokeRect(1030,620,10,110);
      ctxf.strokeRect(1020,652,10,36);
      ctxmf.strokeRect(80,80,P*3,P);
      ctxmf.strokeRect(1040 / S,610 / S,10 / S,130 / S);
      ctxmf.strokeRect(1030 / S,620 / S,10 / S,110 / S);
      ctxmf.strokeRect(1020 / S,652 / S,10 / S,36 / S);
      if (ftiles.length > 4) {
        for (let i = 4; i < ftiles.length; i++) {
          ctxf.strokeRect(ftiles[i].posx, ftiles[i].posy, T, T);
          ctxmf.strokeRect(ftiles[i].posx / S, ftiles[i].posy / S, P, P);
          if (ftiles[i].north) 
            ctxf.strokeRect(ftiles[i].posx + D, ftiles[i].posy, D, X);
          if (ftiles[i].east) 
            ctxf.strokeRect(ftiles[i].posx + T - X, ftiles[i].posy + D, X, D);
          if (ftiles[i].south)
            ctxf.strokeRect(ftiles[i].posx + D, ftiles[i].posy + T - X, D, X);
          if (ftiles[i].west) 
            ctxf.strokeRect(ftiles[i].posx, ftiles[i].posy + D, X, D);
        }
      }
    } 
    if (floor == 2 || floor == -1) {
      ctxs.strokeRect(600,600,T,T);
      ctxs.strokeRect(650,600,50,10);
      ctxs.strokeRect(650,740,50,10);
      ctxs.strokeRect(600,650,10,50);
      ctxs.strokeRect(740,650,10,50);
      ctxs.strokeRect(640,660,70,10);
      ctxs.strokeRect(650,670,50,10);
      ctxs.strokeRect(660,680,30,10);
      ctxms.strokeRect(80,80,P,P);
      ctxms.strokeRect(640 / S,660 / S,70 / S,10 / S);
      ctxms.strokeRect(650 / S,670 / S,50 / S,10 / S);
      ctxms.strokeRect(660 / S,680 / S,30 / S,10 / S);
      if (stiles.length > 1) {
        for (let i = 1; i < stiles.length; i++) {
          ctxs.strokeRect(stiles[i].posx, stiles[i].posy, T, T);
          ctxms.strokeRect(stiles[i].posx / S, stiles[i].posy / S, P, P);
          if (stiles[i].north) 
            ctxs.strokeRect(stiles[i].posx + D, stiles[i].posy, D, X);
          if (stiles[i].east) 
            ctxs.strokeRect(stiles[i].posx + T - X, stiles[i].posy + D, X, D);
          if (stiles[i].south)
            ctxs.strokeRect(stiles[i].posx + D, stiles[i].posy + T - X, D, X);
          if (stiles[i].west) 
            ctxs.strokeRect(stiles[i].posx, stiles[i].posy + D, X, D);
        }
      }
    }
    for (let i = 0; i < positions.length; i++) {
      if (floor == positions[i].floor || floor == -1) {
        if (positions[i].floor == 0) {
          ctxb.strokeRect(positions[i].posx + offsets[i].posx, positions[i].posy + offsets[i].posy, P, P);
          ctxmb.strokeRect((positions[i].posx + offsets[i].posx) / S, 
            (positions[i].posy + offsets[i].posy) / S, P / S, P / S);
        }
        else if (positions[i].floor == 1) {
          ctxf.strokeRect(positions[i].posx + offsets[i].posx, positions[i].posy + offsets[i].posy, P, P);
          ctxmf.strokeRect((positions[i].posx + offsets[i].posx) / S, 
            (positions[i].posy + offsets[i].posy) / S, P / S, P / S);
        }
        else if (positions[i].floor == 2) {
          ctxs.strokeRect(positions[i].posx + offsets[i].posx, positions[i].posy + offsets[i].posy, P, P);
          ctxms.strokeRect((positions[i].posx + offsets[i].posx) / S, 
            (positions[i].posy + offsets[i].posy) / S, P / S, P / S);
        }
      }
    }
  }
  </script>
</head>
<body>
<div class="game">

	<div id="temp_lobby" class="temp_lobby">
		<center><p><h2>Let's play Betrayal!</h2>

			<form method="POST" action="/betrayal"> 
			
			  <p>Select characters for each player, then start the game:</p>
			  
			  <p>Game Name: <input type="text" id="name" name="name" placeholder="Enter Game Name"></p>
			  
			  <p>Player 1: 
			  <select id="player_1_select"></select></p>
			  
			  <p>Player 2: 
			  <select id="player_2_select"></select></p>
			  
			  <p>Player 3: 
			  <select id="player_3_select"></select></p>
			  
			  <p>Player 4: 
			  <select id="player_4_select"></select></p>
			  
			  <p>Player 5: 
			  <select id="player_5_select"></select></p>
			  
			  <p>Player 6: 
			  <select id="player_6_select"></select></p>
			  
			  <input type="submit" id="create" value="Create Game"></center>
			</form>
	</div>

	<style type="text/css">
    .temp_lobby{
      display:flex; 
      flex-direction:column;
    position:absolute;
    top:10%;
    left:10%;
    float:left;
    z-index:20;
    height:500px;
    width:1000px;
        border-style:solid;
        border-width:2px;
        margin-bottom:5px;
        background-color:#ffffff;}
    </style>


  <div class="title_row">
    <div class="title">
       <center><font size="5">Betrayal at House on the Hill</font></center>
    </div>
    
    <style type="text/css">
    .title{
      float:left;
      width:100%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
  </div>
  
  <style type="text/css">
  .title_row{
    display:flex; 
    flex-direction:row;
    height:30%;}
  </style>
  
  <div class="player_row">
  
    <div id="player_2" class="player">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 2" style="width:75px;height:75px;"></center>
        </div>
        
        <div id="stats_2" class="stats"><center> X </center></div>    
      </div>
      
      <div class="info">
          <div id="name_2" class="name"></div>
          
          <div id="items_2" class="items"></div>
        </div>
    </div>
    
    <div id="player_3" class="player">
        <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 3" style="width:75px;height:75px;"></center>
        </div>
        
        <div id="stats_3" class="stats"><center> X </center></div> 
      </div>
      
      <div class="info">
          <div id="name_3" class="name"></div>
          
          <div id="items_3" class="items"></div>
        </div>
    </div>
    
    <div id="player_4" class="player">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 4" style="width:75px;height:75px;"></center>
        </div>
        
        <div id="stats_4" class="stats"><center> X </center></div> 
      </div>
      
      <div class="info">
          <div id="name_4" class="name"> </div>
          
          <div id="items_4" class="items"></div>
        </div>
    </div>
    
    <div id="player_5" class="player">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 5" style="width:75px;height:75px;"></center>
        </div>
        
        <div id="stats_5" class="stats"><center> X </center></div> 
      </div>
      
      <div class="info">
          <div id="name_5" class="name"> </div>
          
          <div id="items_5" class="items"></div>
        </div>
    </div>
    
    <div id="player_6" class="player">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 6" style="width:75px;height:75px;"></center>
        </div>
        
        <div id="stats_6" class="stats"><center> X </center></div> 
      </div>
      
      <div class="info">
          <div id="name_6" class="name"> </div>
          
          <div id="items_6" class="items"></div>
        </div>
    </div>
    
    <style type="text/css">
    .icon{
      width:100%;
      border-style:solid;
      border-width:2px;
      margin-bottom:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .stats{
      width:100%;
      border-style:solid;
      border-width:2px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .image{
      display:flex; 
      flex-direction:column;
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .info{
      display:flex; 
      flex-direction:column;
      width:100%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>

    <style type="text/css">
    .player{
      display:flex; 
      flex-direction:row;
      width:20%;
      height:20%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
  </div>
  
  <style type="text/css">
  .player_row{
    border-style:solid;
    border-width:2px;
    margin:5px;
    display:flex; 
    flex-direction:row;
    height:100%;
    background-color:#707070;}
  </style>
  
  
  <div class="main_game">
    <div id="player_1" class="player_1">
    
      <div id="name_1" class="name"><center> X </center></div>
    
      <div class="icon_1">
          <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 1" style="width:100px;height:100px;border-style:solid;border-width:2px;"></center>
      </div>
        
      <center><div id="speed_1" class="stat"><center> X </center></div></center>
      
      <center><div id="might_1" class="stat"><center> X </center></div></center>
      
      <center><div id="sanity_1" class="stat"><center> X </center></div></center>
      
      <center><div id="knowledge_1" class="stat"><center> X </center></div></center>
       
    </div>
    
    <style type="text/css">
    .icon_1{
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .stat{
      width:88%;
      border-style:solid;
      border-width:2px;
      margin:2px;
      margin-left:5px;
      margin-right:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .player_1{
      display:flex; 
      flex-direction:column;
      float:left;
      width:15%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <div class="board">
    
    <div id="item" class="card">
    
      <center><div id="item_name" class="card_name"></div></center>
  
	  <center><div id="item_description" class="card_description"></div></center>
	  
	  <p><center><button type="button" id="end_turn">End Turn</button></center></p>
	    
	</div>

	<div id="omen" class="card">
	    
	    <center><div id="omen_name" class="card_name"></div></center>
	  
	    <center><div id="omen_description" class="card_description"></div></center>
	    
	    <p><center><button type="button" id="roll_haunt">Roll for Haunt</button></center></p>
	    
	</div>
	
	<div id="event" class="card">
	    
	    <center><div id="event_name" class="card_name"></div></center>
	  
	    <center><div id="event_description" class="card_description"></div></center>
	  
	  	<p><center><button type="button" id="event_action">ACTION BUTTON</button></center></p>
	    
	</div>
  
  <style type="text/css">
  .card_name{
    width:100%;
    height:10%;
        margin-bottom:5px;
        background-color:#ffffff;}
     </style>
     
     <style type="text/css">
  .card_description{
    width:95%;
    height:80%;
        border-style:solid;
        border-width:2px;
        margin-bottom:5px;
        background-color:#eeeeee;}
     </style>

  <style type="text/css">
  .card{
      display:flex; 
      flex-direction:column;
    position:absolute;
    top:35%;
    left:37%;
    float:left;
    z-index:20;
    height:350px;
    width:250px;
        border-style:solid;
        border-width:2px;
        margin-bottom:5px;
        background-color:#ffffff;}
     </style>
    
<div id="container">
  <div id="map">
    <div id="mapf"><canvas id="mfirst"></canvas></div>
    <div id="maps"><canvas id="msecond"></canvas></div>
    <div id="mapb"><canvas id="mbasement"></canvas></div>
  </div>
  <div id="box">
    <canvas id="first"></canvas>
    <canvas id="second"></canvas>
    <canvas id="basement"></canvas>
    <div id="descr">
    <!-- <div> Player <span id="player">1</span>'s turn</div> -->
    <center><div> Speed Left: <span id="moves">10</span></div></center>
    <center><button id="end" onclick="endturn();">End Turn</button></center>
    <center><button disabled>Attack</button></center>
    <center><button disabled>Pick up Items</button></center>
    <center><button disabled>Interact w/Room</button></center>
    <div id="scription"></div>
    </div>
  </div>
</div>
</div>
    
    <style type="text/css">
    .board{
      float:left;
      width:70%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <div class="interaction">
      <div class="objective">
        <center>Objectives</center>
        
        <div id="objective_description" class="obj_info"></div>
        
        <style type="text/css">
        .obj_info{
          overflow-y:auto;
          height:85%;
          margin:5px;
          background-color:#eeeeee;}
        </style>
        
      </div>
      
      <style type="text/css">
      .objective{
        width:99%;
        height:50%;
        border-style:solid;
        border-width:2px;
        margin-bottom:10px;
        background-color:#eeeeee;}
      </style>
      
      <div class="chat">
        <center>Chat</center>
        <div class="log"></div>
        
        <div class="user_text">
          <center><input type="text" id="chat_text" name="chat_text" placeholder="Enter Message" style="width:95%;"></center>
        </div>
        
      </div>
      
      <style type="text/css">
      .log{
        width:99%;
        height:80%;
        background-color:#eeeeee;}
      </style>
      
      <style type="text/css">
      .chat{
        display:flex; 
        flex-direction:column;
        width:99%;
        height:50%;
        border-style:solid;
        border-width:2px;
        background-color:#eeeeee;}
      </style>
    </div>
    
    <style type="text/css">
    .interaction{
      display:flex; 
      flex-direction:column;
      width:25%;
      margin:5px;}
    </style>
  </div>
  
  <style type="text/css">
  .main_game{
    display:flex; 
    flex-direction:row;
    height:528px}
  </style>

</div>

<style type="text/css">
.game{
  display:flex; 
  flex-direction:column;
      border-style:solid;
      border-width:2px;
  background-color:#727272;}
</style>

<script type="text/javascript">
  let m1 = false;
  $("#mfirst").mousedown(function(){m1=false;}).mousemove(function(){m1=true;}).mouseup(function(event){
    if(!m1){
        first.style.display = 'block';
        second.style.display = 'none';
        basement.style.display = 'none';
     }
  });
  let m2 = false;
  $("#msecond").mousedown(function(){m2=false;}).mousemove(function(){m2=true;}).mouseup(function(event){
    if(!m2){
        first.style.display = 'none';
        second.style.display = 'block';
        basement.style.display = 'none';
     }
  });
  let m3 = false;
  $("#mbasement").mousedown(function(){m3=false;}).mousemove(function(){m3=true;}).mouseup(function(event){
    if(!m3){
        first.style.display = 'none';
        second.style.display = 'none';
        basement.style.display = 'block';
     }
  });
//  let b1 = false;
//  $("#first").mousedown(function(){b1=false;}).mousemove(function(){b1=true;}).mouseup(function(event){
//    if(!b1){
//        const x = event.pageX - first.offsetLeft - 336;
//        const y = event.pageY - first.offsetTop - 204;
//        const xpos = x - (x % T) + edgex[1];
//        const ypos = y - (y % T) + edgex[1];
//        descr.innerHTML = xpos + " " + ypos;
//     }
//  });
//  let b2 = false;
//  $("#second").mousedown(function(){b2=false;}).mousemove(function(){b2=true;}).mouseup(function(event){
//    if(!b2){
//        const x = event.pageX - second.offsetLeft - 336;
//        const y = event.pageY - second.offsetTop - 204;
//        const xpos = x - (x % T) + edgex[2];
//        const ypos = y - (y % T) + edgey[2];
//        descr.innerHTML = xpos + " " + ypos;
//     }
//  });
//  let b3 = false;
//  $("#basement").mousedown(function(){b3=false;}).mousemove(function(){b3=true;}).mouseup(function(event){
//    if(!b3){
//        const x = event.pageX - basement.offsetLeft - 336;
//        const y = event.pageY - basement.offsetTop - 204;
//        const xpos = x - (x % T) + edgex[0];
//        const ypos = y - (y % T) + edgey[0];
//        descr.innerHTML = xpos + " " + ypos;
//     }
//  });
    let moves = 10;
    const first = document.getElementById("first");
    const second = document.getElementById("second");
    const basement = document.getElementById("basement");
    const descr = document.getElementById("scription");
    // const player = document.getElementById("player");
    const movesp = document.getElementById("moves");
    const mfirst = document.getElementById("mfirst");
    const msecond = document.getElementById("msecond");
    const mbasement = document.getElementById("mbasement");
    first.width = 1350;
    first.height = 1350;
    second.width = 1350;
    second.height = 1350;
    basement.width = 1350;
    basement.height = 1350;
    mfirst.width = 180;
    mfirst.height = 180;
    msecond.width = 180;
    msecond.height = 180;
    mbasement.width = 180;
    mbasement.height = 180;
    const ctxf = first.getContext("2d");
    const ctxs = second.getContext("2d");
    const ctxb = basement.getContext("2d");
    const ctxmf = mfirst.getContext("2d");
    const ctxms = msecond.getContext("2d");
    const ctxmb = mbasement.getContext("2d");
    let edgex = [0, 0, 0];
    let edgey = [0, 0, 0];
  $(document).ready(() => {
    paintBoard(-1);
    $(document).keyup(event => {
      if (moves > 0) {
        let r1 = Math.random() >= 0.5;
        let r2 = Math.random() >= 0.5;
        let r3 = Math.random() >= 0.5;
        let ctx;
        let flo;
        let lev;
        let ctxm;
        let levm;
        if (positions[turn].floor == 0) {
          ctx = ctxb;
          flo = btiles;
          lev = basement;
          ctxm = ctxmb;
          levm = mbasement;
        }
        else if (positions[turn].floor == 1) {
          ctx = ctxf;
          flo = ftiles;
          lev = first;
          ctxm = ctxmf;
          levm = mfirst;
        }
        else if (positions[turn].floor == 2) {
          ctx = ctxs;
          flo = stiles;
          lev = second;
          ctxm = ctxms;
          levm = msecond;
        }
        let temp;
        if (positions[turn].posx == 900 && positions[turn].posy == 600 && 
          positions[turn].floor == 1 && event.which == 69) {
          ctx.clearRect(900 + offsets[turn].posx - 1, 600 + offsets[turn].posy - 1, P + 2, P + 2);
          ctxs.strokeRect(600 + offsets[turn].posx, 600 + offsets[turn].posy, P, P);
          ctxm.clearRect((900 + offsets[turn].posx) / S - 1, 
            (600 + offsets[turn].posy) / S - 1, P / S + 2, P / S + 2);
          ctxms.strokeRect((600 + offsets[turn].posx) / S, 
            (600 + offsets[turn].posy) / S, P / S, P / S);
          first.style.display = 'none';
          second.style.display = 'block';
          basement.style.display = 'none';
          second.style.top = '-425px';
          second.style.left = '-375px';
          positions[turn].posx = 600;
          positions[turn].floor = 2;
          positions[turn].north = true;
          positions[turn].east = true;
          positions[turn].south = true;
          positions[turn].west = true;
          moves--;
        } else if (positions[turn].posx == 600 && positions[turn].posy == 600 && 
          positions[turn].floor == 2 && event.which == 69) {
          ctx.clearRect(600 + offsets[turn].posx - 1, 600 + offsets[turn].posy - 1, P + 2, P + 2);
          ctxf.strokeRect(900 + offsets[turn].posx, 600 + offsets[turn].posy, P, P);
          ctxm.clearRect((600 + offsets[turn].posx) / S - 1, 
            (600 + offsets[turn].posy) / S - 1, P / S + 2, P / S + 2);
          ctxmf.strokeRect((900 + offsets[turn].posx) / S, 
            (600 + offsets[turn].posy) / S, P / S, P / S);
          first.style.display = 'block';
          second.style.display = 'none';
          basement.style.display = 'none';
          first.style.top = '-425px';
          first.style.left = '-375px';
          positions[turn].posx = 900;
          positions[turn].floor = 1;
          positions[turn].north = false;
          positions[turn].east = false;
          positions[turn].south = false;
          positions[turn].west = true;
          moves--;
        }else if (event.which == 87) {
          if (positions[turn].posy - T < edgey[positions[turn].floor]) {
            lev.height += 150;
            edgey[positions[turn].floor] -= 150;
            ctx.translate(Math.abs(edgex[positions[turn].floor]), Math.abs(edgey[positions[turn].floor]));
            levm.height += 20;
            ctxm.translate(Math.abs(edgex[positions[turn].floor]) / S, 
              Math.abs(edgey[positions[turn].floor]) / S);
            paintBoard(positions[turn].floor);
          }
          if (((temp = tileExists(positions[turn].posx, positions[turn].posy - T,
           positions[turn].floor)) == -1 || flo[temp].south) && positions[turn].north) {
            ctx.clearRect(positions[turn].posx + offsets[turn].posx - 1, 
              positions[turn].posy + offsets[turn].posy - 1, P + 2, P + 2);
            ctx.strokeRect(positions[turn].posx + offsets[turn].posx, 
              positions[turn].posy - T + offsets[turn].posy, P, P);
            ctxm.clearRect((positions[turn].posx + offsets[turn].posx) / S - 1, 
              (positions[turn].posy + offsets[turn].posy) / S - 1, P / S + 2, P / S + 2);
            ctxm.strokeRect((positions[turn].posx + offsets[turn].posx) / S, 
              (positions[turn].posy - T + offsets[turn].posy) / S, P / S, P / S);
            if (temp == -1) {
              const ntile = new Tile(positions[turn].posx, positions[turn].posy - T, r1, r2, true, r3);
              flo.push(ntile);
              ctx.strokeRect(positions[turn].posx, positions[turn].posy - T, T, T);
              ctxm.strokeRect(positions[turn].posx / S, (positions[turn].posy - T) / S, P, P);
              if (r1 == true) 
                ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - T, D, X);
              if (r2 == true)
                ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy - T + D, X, D);
              if (r3 == true) 
                ctx.strokeRect(positions[turn].posx, positions[turn].posy - T + D, X, D);
              ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - X, D, X);
              positions[turn].north = r1;
              positions[turn].east = r2;
              positions[turn].south = true;
              positions[turn].west = r3;
            } else {
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
            }
            positions[turn].posy = positions[turn].posy - T;
            moves--;
            const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
            const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
            lev.style.top = ypos + 'px';
            lev.style.left = xpos + 'px';
          } 
        } else if (event.which == 68) {
          if (positions[turn].posx + T >= lev.width + edgex[positions[turn].floor]) {
            lev.width += 150;
            ctx.translate(Math.abs(edgex[positions[turn].floor]), Math.abs(edgey[positions[turn].floor]));
            levm.width += 20;
            ctxm.translate(Math.abs(edgex[positions[turn].floor]) / S,
             Math.abs(edgey[positions[turn].floor]) / S);
            paintBoard(positions[turn].floor);
          }
          if (((temp = tileExists(positions[turn].posx + T, positions[turn].posy,
           positions[turn].floor)) == -1 || flo[temp].west) && positions[turn].east) {
            ctx.clearRect(positions[turn].posx + offsets[turn].posx - 1, 
              positions[turn].posy + offsets[turn].posy - 1, P + 2, P + 2);
            ctx.strokeRect(positions[turn].posx + T + offsets[turn].posx, 
              positions[turn].posy + offsets[turn].posy, P, P);
            ctxm.clearRect((positions[turn].posx + offsets[turn].posx) / S - 1, 
              (positions[turn].posy + offsets[turn].posy) / S - 1, P / S + 2, P / S + 2);
            ctxm.strokeRect((positions[turn].posx + T + offsets[turn].posx) / S, 
              (positions[turn].posy + offsets[turn].posy) / S, P / S, P / S);
            if (temp == -1) {
              const ntile = new Tile(positions[turn].posx + T, positions[turn].posy, r1, r2, r3, true);
              flo.push(ntile);
              ctx.strokeRect(positions[turn].posx + T, positions[turn].posy, T, T);
              ctxm.strokeRect((positions[turn].posx + T) / S, positions[turn].posy / S, P, P);
              if (r1 == true) 
                ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy, D, X);
              if (r2 == true)
                ctx.strokeRect(positions[turn].posx + T + T - X, positions[turn].posy + D, X, D);
              if (r3 == true) 
                ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy + T - X, D, X);
              ctx.strokeRect(positions[turn].posx + T, positions[turn].posy + D, X, D);
              positions[turn].north = r1;
              positions[turn].east = r2;
              positions[turn].south = r3;
              positions[turn].west = true;
            } else {
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
            }
            positions[turn].posx = positions[turn].posx + T;
            moves--;
            const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
            const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
            lev.style.top = ypos + 'px';
            lev.style.left = xpos + 'px';
          } 
        } else if (event.which == 83) {
          if (positions[turn].posy + T >= lev.height + edgey[positions[turn].floor]) {
            lev.height += 150;
            ctx.translate(Math.abs(edgex[positions[turn].floor]), Math.abs(edgey[positions[turn].floor]));
            levm.height += 20;
            ctxm.translate(Math.abs(edgex[positions[turn].floor]) / S, 
              Math.abs(edgey[positions[turn].floor]) / S);
            paintBoard(positions[turn].floor);
          }
          if (((temp = tileExists(positions[turn].posx, positions[turn].posy + T,
           positions[turn].floor)) == -1 || flo[temp].north) && positions[turn].south) {
            ctx.clearRect(positions[turn].posx + offsets[turn].posx - 1, 
              positions[turn].posy + offsets[turn].posy - 1, P + 2, P + 2);
            ctx.strokeRect(positions[turn].posx + offsets[turn].posx, 
              positions[turn].posy + T + offsets[turn].posy, P, P);
            ctxm.clearRect((positions[turn].posx + offsets[turn].posx) / S - 1, 
              (positions[turn].posy + offsets[turn].posy) / S - 1, P / S + 2, P / S + 2);
            ctxm.strokeRect((positions[turn].posx + offsets[turn].posx) / S, 
              (positions[turn].posy + T + offsets[turn].posy) / S, P / S, P / S);
            if (temp == -1) {
              const ntile = new Tile(positions[turn].posx, positions[turn].posy + T, true, r1, r2, r3);
              flo.push(ntile);
              ctx.strokeRect(positions[turn].posx, positions[turn].posy + T, T, T);
              ctxm.strokeRect(positions[turn].posx / S, (positions[turn].posy + T) / S, P, P);
              if (r1 == true) 
                ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy + T + D, X, D);
              if (r2 == true)
                ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T + T - X, D, X);
              if (r3 == true) 
                ctx.strokeRect(positions[turn].posx, positions[turn].posy + T + D, X, D);
              ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T, D, X);
              positions[turn].north = true;
              positions[turn].east = r1;
              positions[turn].south = r2;
              positions[turn].west = r3;
            } else {
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
            }
            positions[turn].posy = positions[turn].posy + T;
            moves--;
            const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
            const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
            lev.style.top = ypos + 'px';
            lev.style.left = xpos + 'px';
          }
        } else if (event.which == 65) {
          if (positions[turn].posx - T < edgex[positions[turn].floor]) {
            lev.width += 150;
            edgex[positions[turn].floor] -= 150;
            ctx.translate(Math.abs(edgex[positions[turn].floor]), Math.abs(edgey[positions[turn].floor]));
            levm.width += 20;
            ctxm.translate(Math.abs(edgex[positions[turn].floor]) / S,
             Math.abs(edgey[positions[turn].floor]) / S);
            paintBoard(positions[turn].floor);
          }
          if (((temp = tileExists(positions[turn].posx - T, positions[turn].posy,
           positions[turn].floor)) == -1 || flo[temp].east) && positions[turn].west) {
            ctx.clearRect(positions[turn].posx + offsets[turn].posx - 1, 
              positions[turn].posy + offsets[turn].posy - 1, P + 2, P + 2);
            ctx.strokeRect(positions[turn].posx - T + offsets[turn].posx, 
              positions[turn].posy + offsets[turn].posy, P, P);
            ctxm.clearRect((positions[turn].posx + offsets[turn].posx) / S - 1, 
              (positions[turn].posy + offsets[turn].posy) / S - 1, P / S + 2, P / S + 2);
            ctxm.strokeRect((positions[turn].posx  - T + offsets[turn].posx) / S, 
              (positions[turn].posy + offsets[turn].posy) / S, P / S, P / S);
            if (temp == -1) {
              const ntile = new Tile(positions[turn].posx - T, positions[turn].posy, r1, true, r2, r3);
              flo.push(ntile);
              ctx.strokeRect(positions[turn].posx - T, positions[turn].posy, T, T);
              ctxm.strokeRect((positions[turn].posx - T) / S, positions[turn].posy / S, P, P);
              if (r1 == true) 
                ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy, D, X);
              if (r2 == true)
                ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy + T - X, D, X);
              if (r3 == true) 
                ctx.strokeRect(positions[turn].posx - T, positions[turn].posy + D, X, D);
              ctx.strokeRect(positions[turn].posx - X, positions[turn].posy + D, X, D);
              positions[turn].north = r1;
              positions[turn].east = true;
              positions[turn].south = r2;
              positions[turn].west = r3;
            } else {
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
            }
            positions[turn].posx = positions[turn].posx - T;
            moves--;
            const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
            const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
            lev.style.top = ypos + 'px';
            lev.style.left = xpos + 'px';
          } 
        }
        movesp.innerHTML = moves;
      }
    });
  });  
</script>
</body>
</html>