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

			<form method="GET" action="/create_game"> 
			
			  <p>Fill out and submit the following form to create a game:</p>
			  
			  <p>Game Name: <input type="text" id="name" name="name" placeholder="Enter Game Name"></p>
			  
			  <p>Game Size: 
			  <select name="players" id="players">
			    <option value="3">3 Players</option>
			    <option value="4">4 Players</option>
			    <option value="5">5 Players</option>
			    <option value="6">6 Players</option>
			  </select></p>
			  
			  <input type="submit" value="Create Game"></center>
			</form>
		</div>
	
		<div class="option">
			<center><p><h2>Join a lobby:</h2></p>

			<p>Game "X": 4/6 players ready.</p>
			
			<p>Game "Y": 2/3 players ready.</p>
			
			<p>Game "Z": 5/6 players ready.</p>
			
			<button type="button" id="join">Join Lobby</button></p></center>
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
