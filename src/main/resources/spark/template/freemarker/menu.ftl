<#assign content>

<h1>Betrayal at House on the Hill!</h1>

${message}

<p><h2>Create a game:</h2>

<form method="POST" action="/create_game"> 

  <p>Fill out and submit the following form to create a game:</p>
  
  <p>Game Name: <input type="text" id="name" name="name" placeholder="Enter Game Name"></p>
  
  <p>Game Size: 
  <select name="players" id="players">
    <option value="3">3 Players</option>
    <option value="4">4 Players</option>
    <option value="5">5 Players</option>
    <option value="6">6 Players</option>
  </select></p>
  
  <input type="submit" value="Create Game">
</form>

<p><h2>Join a lobby:</h2></p>

<p>Game "X": 4/6 players ready.</p>

<p>Game "Y": 2/3 players ready.</p>

<p>Game "Z": 5/6 players ready.</p>

<button type="button" id="join">Join Lobby</button></p>

</#assign>
<#include "main.ftl">
