<!doctype html>
<html lang="en">
<head>
  <title>Betrayal Board</title>
  <style>
  #first, #second, #basement {position: relative; top:-425px; left:-375px;}
  #second, #basement {display: none;}
  #box {width:800px; height:514px; border: solid black 1px; overflow: hidden; border-width: 0px 0px 2px 0; position: relative; z-index: 0;}
  #mapf, #maps, #mapb {overflow: hidden; border:solid black 1px; border-width: 0 2px 2px 0; width:170px; height:170px;}
  #map {display: flex; flex-direction:column;}
  #container {display:flex; flex-direction:row;}
  #descr {position: absolute; right: 0; bottom: 0; width:150px; height:514px;
    background: #eeeeee; border: solid black 1px; border-width: 1px 0 0 1px; z-index: 1;}
  button {padding:5px; margin:5px; background:#eeeeee; font-size:14px; width:130px; height:40px;}
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
  const positions = [posp1, posp2, posp3, posp4];
  const offset1 = new Position(25,30);
  const offset2 = new Position(105,30);
  const offset3 = new Position(25,90);
  const offset4 = new Position(105,90);
  const offsets = [offset1, offset2, offset3, offset4];
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
      if (turn >= 3)
        turn = 0;
      else 
        turn++;
      // player.innerHTML = turn + 1;
      moves = 10;
      movesp.innerHTML = 10;
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
  
    <div class="player_2">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 2" style="width:75px;height:75px;"></center>
        </div>
        
        <div class="stats">
          <center>S M K S</center>
        </div>    
      </div>
      
      <div class="info">
          <div class="name">
            <center>Player 2</center>
          </div>
          
          <div class="items">
            <center>Player 2's items</center>
          </div>
        </div>
    </div>
    
    <div class="player_3">
        <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 3" style="width:75px;height:75px;"></center>
        </div>
        
        <div class="stats">
          <center>S M K S</center>
        </div>
      </div>
      
      <div class="info">
          <div class="name">
            <center>Player 3</center>
          </div>
          
          <div class="items">
            <center>Player 3's items</center>
          </div>
        </div>
    </div>
    
    <div class="player_4">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 4" style="width:75px;height:75px;"></center>
        </div>
        
        <div class="stats">
          <center>S M K S</center>
        </div>
      </div>
      
      <div class="info">
          <div class="name">
            <center>Player 4</center>
          </div>
          
          <div class="items">
            <center>Player 4's items</center>
          </div>
        </div>
    </div>
    
    <div class="player_5">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 5" style="width:75px;height:75px;"></center>
        </div>
        
        <div class="stats">
          <center>S M K S</center>
        </div>
      </div>
      
      <div class="info">
          <div class="name">
            <center>Player 5</center>
          </div>
          
          <div class="items">
            <center>Player 5's items</center>
          </div>
        </div>
    </div>
    
    <div class="player_6">
       <div class="image">
          <div class="icon">
            <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 6" style="width:75px;height:75px;"></center>
        </div>
        
        <div class="stats">
          <center>S M K S</center>
        </div>
      </div>
      
      <div class="info">
          <div class="name">
            <center>Player 6</center>
          </div>
          
          <div class="items">
            <center>Player 6's items</center>
          </div>
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
    .player_2{
      display:flex; 
      flex-direction:row;
      width:20%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .player_3{
      display:flex; 
      flex-direction:row;
      width:20%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .player_4{
      display:flex; 
      flex-direction:row;
      width:20%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .player_5{
      display:flex; 
      flex-direction:row;
      width:20%;
      border-style:solid;
      border-width:2px;
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .player_6{
      display:flex; 
      flex-direction:row;
      width:20%;
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
    <div class="player_1">
    
      <center>Player 1</center>
    
      <div class="icon_1">
          <center><img src="http://www.thecatalystagency.com/wp-content/uploads/2015/06/placeholder-user-anon.png" alt="Player 1" style="width:100px;height:100px;border-style:solid;border-width:2px;"></center>
      </div>
        
      <div class="stat">
        <center>S P E E D</center>
      </div>
      
      <div class="stat">
        <center>M I G H T</center>
      </div>
      
      <div class="stat">
        <center>K N O WLEDGE</center>
      </div>
      
      <div class="stat">
        <center>S A N I T Y</center>
      </div>
      
      <p><center>Player 1's Items</center></p>
      
      <p><center>Player 1's Omens</center></p>
      
      <p><center>Player 1's Events</center></p>
       
    </div>
    
    <style type="text/css">
    .icon_1{
      margin:5px;
      background-color:#eeeeee;}
    </style>
    
    <style type="text/css">
    .stat{
      width:92.5%;
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
    <center><button onclick="endturn();">End Turn</button></center>
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
        
        <div class="obj_info">
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."      
          <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>      
        </div>
        
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
    height:514px}
  </style>

</div>

<style type="text/css">
.game{
  display:flex; 
  flex-direction:column;
  width:100%;
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

  let b1 = false;
  $("#first").mousedown(function(){b1=false;}).mousemove(function(){b1=true;}).mouseup(function(event){
    if(!b1){
        const x = event.pageX - first.offsetLeft - 336;
        const y = event.pageY - first.offsetTop - 204;
        const xpos = x - (x % T) + edgex[1];
        const ypos = y - (y % T) + edgex[1];
        descr.innerHTML = xpos + " " + ypos;
     }
  });

  let b2 = false;
  $("#second").mousedown(function(){b2=false;}).mousemove(function(){b2=true;}).mouseup(function(event){
    if(!b2){
        const x = event.pageX - second.offsetLeft - 336;
        const y = event.pageY - second.offsetTop - 204;
        const xpos = x - (x % T) + edgex[2];
        const ypos = y - (y % T) + edgey[2];
        descr.innerHTML = xpos + " " + ypos;
     }
  });

  let b3 = false;
  $("#basement").mousedown(function(){b3=false;}).mousemove(function(){b3=true;}).mouseup(function(event){
    if(!b3){
        const x = event.pageX - basement.offsetLeft - 336;
        const y = event.pageY - basement.offsetTop - 204;
        const xpos = x - (x % T) + edgex[0];
        const ypos = y - (y % T) + edgey[0];
        descr.innerHTML = xpos + " " + ypos;
     }
  });

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