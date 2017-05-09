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
  <link rel="stylesheet" href="css/main.css">
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
		<div class="option wrapper">
			<center><p><font size="5">Create a game:</font>

			  <p>Give yourself a username to create a game:</p>

			  <div id="create_error" class="message"></div>

			  <p>Username: <input type="text" id="username_create" name="name" placeholder="Enter Your Username"></p>

			  <button type="button" id="create_game">Create Game</button></center>
		</div>

		<div class="option">
			<center><p><font size="5">Join a lobby:</font></p>

			<p>Give yourself a username and select a lobby to join a game:</p>

			<div id="join_error" class="message"></div>

			<p>Username: <input type="text" id="username_join" name="name" placeholder="Enter Your Username"></p>

			<div id="lobbies" class="lobby_list wrapper"></div>

			<button type="button" id="join_game">Join Lobby</button></center>
		</div>
	</div>

  <div class="title_row">
    <div class="title wrapper">
       <center><font size="5">Betrayal at House on the Hill</font></center>
    </div>
  </div>

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
  </div>

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

    <div class="board">

    <div id="item" class="card" draggable="true">

      <center><div id="item_name" class="card_name"></div></center>

      <div class="card_cont">
      	<center><div id="item_info" class="card_info"></div></center>

	  	<center><div id="item_description" class="card_description"></div></center>

	  	<center><div id="item_logic" class="card_logic"></div></center>
	  </div>
	  <p><center><button type="button" id="end_turn">End Turn</button></center></p>

	</div>

	<div id="omen" class="card" draggable="true">
	    <center><div id="omen_name" class="card_name"></div></center>

        <div class="card_cont">
        	<center><div id="omen_info" class="card_info"></div></center>

	    	<center><div id="omen_description" class="card_description"></div></center>

	    	<center><div id="omen_logic" class="card_logic"></div></center>
	    </div>
	    <p><center><button type="button" id="roll_haunt">Roll for Haunt</button></center></p>

	</div>

	<div id="event" class="card" draggable="true">
	    <center><div id="event_name" class="card_name"></div></center>

      <div class="card_cont">
      	<center><div id="event_info" class="card_info"></div></center>
      	<center><div id="event_description" class="card_description"></div></center>
      	<center><div id="event_logic" class="card_logic"></div></center>
      </div>

	  	<p><center><button type="button" id="event_action">ACTION BUTTON</button></center></p>
	</div>
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

    <div class="interaction">
      <div class="objective">
        <center>Objectives</center>

        <div id="objective_description" class="obj_info"></div>

      </div>

      <div class="chat">
        <center>Chat</center>
        <div class="log" id="chat_log"></div>

        <div class="user_text">
          <center><input type="text" id="chat_text" name="chat_text" placeholder="Enter Message" style="width:95%;"></center>
        </div>

      </div>
    </div>
  </div>
</div>
<script src="js/movements.js"></script>
</body>
</html>
