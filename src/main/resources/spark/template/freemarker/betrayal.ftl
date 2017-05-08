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
  <script src="js/jquery-3.1.1.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/websocket.js"></script>
  <script src="js/begin_game.js"></script>
  <script src="js/all_functions.js"></script>
  <script src="js/menu.js"></script>
  <script src="js/card_draw.js"></script>
</head>
<body>

<div class="game">

	<div id="temp_lobby" class="temp_lobby">
		<div class="option">
			<center><p><h2>Create a game:</h2>
			
			  <p>Give yourself a username to create a game:</p>
			  
			  <div id="create_error" class="message"></div>
			  
			  <p>Username: <input type="text" id="username_create" name="name" placeholder="Enter Your Username"></p>
			  
			  <button type="button" id="create_game">Create Game</button></center>
		</div>
	
		<div class="option">
			<center><p><h2>Join a lobby:</h2></p>
			
			<p>Give yourself a username and select a lobby to join a game:</p>
			
			<div id="join_error" class="message"></div>
			
			<p>Username: <input type="text" id="username_join" name="name" placeholder="Enter Your Username"></p>

			<div id="lobbies" class="lobby_list"></div>
			
			<button type="button" id="join_game">Join Lobby</button></center>
		</div>
	</div>
	
	<style type="text/css">
		.option{
			height:95%;
			width:50%;
			margin:10px;
			border-style:solid;
			border-width:2px;
			background-color:#eeeeee;}
		</style>
	
	<style type="text/css">
        .lobby_list{
          overflow-y:auto;
          height:200px;
          margin:5px;
          margin-left:15px;
          margin-right:15px;
		  border-style:solid;
		  border-width:2px;
          background-color:#eeeeee;}
        </style>

	<style type="text/css">
    .temp_lobby{
        display:flex; 
        flex-direction:row;
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
        <div id="stats_2_popup" class="popup_stats"></div>   
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
        <div id="stats_3_popup" class="popup_stats"></div>
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
        <div id="stats_4_popup" class="popup_stats"></div>
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
        <div id="stats_5_popup" class="popup_stats"></div>
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
        <div id="stats_6_popup" class="popup_stats"></div>
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
    .popup_stats{
      z-index: 20;
      top:184px;
      display:none;
      position:absolute;
      border-style:solid;
      border-color:#eeeeee;
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
    height:100%;1
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
    
    <div id="item" class="card" draggable="true">
    
      <center><div id="item_info"></div></center>
    
      <center><div id="item_name" class="card_name"></div></center>
  
	  <center><div id="item_description" class="card_description"></div></center>
	  
	  <p><center><button type="button" id="end_turn">End Turn</button></center></p>
	    
	</div>

	<div id="omen" class="card" draggable="true">
    
        <center><div id="omen_info"></div></center>
	    
	    <center><div id="omen_name" class="card_name"></div></center>
	  
	    <center><div id="omen_description" class="card_description"></div></center>
	    
	    <p><center><button type="button" id="roll_haunt">Roll for Haunt</button></center></p>
	    
	</div>
	
	<div id="event" class="card" draggable="true">
    
        <center><div id="event_info"></div></center>
	    
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
    top:30%;
    left:18%;
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
    <center><div> Speed Left: <span id="moves">10</span></div></center>
    <center><button id="end" onclick="endturn();">End Turn</button></center>
    <center><button disabled>Attack</button></center>
    <center><button disabled>Pick up Items</button></center>
    <!-- <center><button disabled>Interact w/Room</button></center> -->
    <center><button id="plat" onclick="placeTile();" disabled>Place Tile</button></center>
    <center><button id="rot" onclick="rotate();" disabled>Rotate Clockwise</button></center>
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
<script src="js/movements.js"></script>
</body>
</html>