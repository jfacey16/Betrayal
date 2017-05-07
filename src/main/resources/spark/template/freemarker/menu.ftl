<#assign content>

<div class="game">

	<div class="title_row">
		<div class="title">
		   <center><font size="5">Betrayal at House on the Hill</font></center>
		</div>
		
		<style type="text/css">
		.title{
			float:left;
			width:99%;
			border-style:solid;
			border-width:2px;
			margin:5px;
			background-color:#eeeeee;}
		</style>
	</div>
		
	<div class="options">
	
		<div class="option">
			<center><p><h2>Create a game:</h2>
			
			  <p>Fill out and submit the following form to create a game:</p>
			  
			  <div id="create_error" class="message"></div>
			  
			  <p>Username: <input type="text" id="username_create" name="name" placeholder="Enter Your Username"></p>
			  
			  </p><form>
				  <input type="radio" name="players" value="3" checked> 3 players
				  <input type="radio" name="players" value="4"> 4 players
				  <input type="radio" name="players" value="5"> 5 players
				  <input type="radio" name="players" value="6"> 6 players
			  </form><p>
			  
			  <button type="button" id="create_game">Create Game</button></center>
		</div>
	
		<div class="option">
			<center><p><h2>Join a lobby:</h2></p>
			
			<p>Fill out your username and select a lobby in order to join a game:</p>
			
			<div id="join_error" class="message"></div>
			
			<p>Username: <input type="text" id="username_join" name="name" placeholder="Enter Your Username"></p>

			<p>Game "X": 4/6 players ready.</p>
			
			<p>Game "Y": 2/3 players ready.</p>
			
			<p>Game "Z": 5/6 players ready.</p>
			
			<button type="button" id="join_game">Join Lobby</button></center>
		</div>
		
		<style type="text/css">
		.option{
			height:500px;
			width:50%;
			margin:10px;
			border-style:solid;
			border-width:2px;
			background-color:#eeeeee;}
		</style>
		
	<div>
	
	<style type="text/css">
	.options{
		display:flex; 
		flex-direction:row;
		height:75%;
		width:99%;
		margin:5px;
		border-style:solid;
		border-width:2px;
		background-color:#eeeeee;}
	</style>
</div>

<style type="text/css">
.menu{
	display:flex; 
	flex-direction:column;
	height:100%;
	width:100%;
	background-color:#ffffff;}
</style>

</#assign>
<#include "main.ftl">
