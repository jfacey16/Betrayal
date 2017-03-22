# cs0320 Term Project

**Team Members:** Alainey Hellman, Jack Facey, Takayoshi Miyamoto, and Zach Hoffman.

**Project Idea:** An online version of the multiplayer tabletop game: Betrayal at House on the Hill.

**Mentor TA:** _Put your mentor TA's name and email here once you're assigned one!_

## Project Requirements

Our project is to build an online, multiplayer version of the tabletop game: Betrayal at House on the Hill.

To accomplish this, the following will be required:

1. The ability for multiple players (3-6) to play the game over the internet.
2. Implementing the game's boards layout for all 3 levels, as well as the specific tiles and tile generation.
3. Both private and public spaces -- the players all see the board and other players’ items/stats; however, certain players will also receive private information necessary for specific tasks (specifically in regards to the haunts).
4. An implementation of the game's phases of pre haunt and post haunt.
5. Implementation of items, omens, and events (cards that you can draw).
6. Characters that players can choose between, each with its own stats.
7. Implementations of several different haunts (which are different scenarios and goals depending on the situation).  This will include implementing traitors, different monsters, different items, and custom rule sets depending on the haunt chosen during the game play.
8. Implementation of a publicly visible track numbered 0-12 that will be incremented and decremented. 

All of these are essential aspects to the tabletop game, so we feel that it is important to implement these. 

## Project Specs and Mockup
_A link to your specifications document and your mockup will go here!_

Mockup was created in balsamiq: [link]

In the home page, a user is given two options given by two side-by-side boxes: to either create a game group or join a game group. Since Betrayal is a game played between 3-6 players, one person should be the host and create a game. 
If you are the host and are creating a game, you have the option to name the group, select how many players should be in the group (3-6, including yourself), and an optional password if need be. 
If you are not looking to host a game, you can join any game that is available in the “join a game” box, which is basically a lobby. Password protected games require a password. A list of game group of names and number of players needed is given for every available group, as well as an option to join that group if one wishes. 

Upon either creating a group as a host or joining a group, you are given a random character, but you are given two options on what stats you want your character to have. You need to select one option, and you can change your option until all needed players join. On the same screen, you can also see a list of players who have already joined and what character they got and what stats they selected. The host will have a button labeled ‘Start Game’ once all players the hosts needs/wants have joined. Once the host presses this button, the game starts.

Once this happens, the “game board”, or main screen will be shown to everyone. On the top strip of that screen, all the characters (players) and their stats, as well as any items, omens, or special conditions of that character will be shown. They can be shown in more detail by clicking on (or mousing over) the specific item, omen, condition, or stat (a small popup would appear upon click). A highlighted character will designate that it is that character’s turn. 

The right strip of the screen will show the current objectives and the omen counter. You can click on the objective/counter to view it in more detail (as a small popup).

Just to the left of the right strip is an option of all the things you can do, if it is your turn. Ending your turn, using an item, picking up an item, or dropping an item can be some of the options. 
The left strip of the screen will show 4 different minimaps: the basement, first floor, second floor, and all the maps at the same time. You could select any of the screens and the center of the page will show that map. The center is just the current map you selected, or by default, the floor of whoever player’s turn it is. The map can be moved around in a click-and-drag fashion. 

If it is your turn, you can move around the game board, which are tiles. You can use either the arrow keys or clicking on doors to move around. You can move spaces up to your speed (which is a stat). If you move to an undiscovered place, a new, random tile appears and the character is moved there. You can choose which way to orient the tile as well. On each tile, it will show which characters are currently on the tile (indicated by colored dots), all the doors of the tile, any dropped items in the tile, and what “type” that tile is (item, omen, or event), if any. 

If you reveal an item tile while discovering a new room, you get an item (everyone can see it). You can use an item when applicable (depends on the item). If you reveal an omen tile, you get an omen and perform its effects, and then do a haunt roll (roll 6 dice which only have 0’s, 1’s and 2’s on them). The omen counter starts as 0, and increments 1 for every revealed omen. If the sum of your roll is less than the number of the omen counter, the “haunt” starts (more on that later). Otherwise, nothing happens. If you land on an event tile, you get an event card and perform its effects. Landing on any of these types of tiles stops you from moving for the turn. You can do other things that don’t require moving, like using an item. You can only keep moving if you go through tiles that are already discovered, or you discover new tiles that don’t have a type. Some tiles have other special effects as well. 

Until the haunt starts, the objective of everyone is to explore the house. Everybody is on the same team. Once the haunt starts, though, there are new objectives for everybody depending on the haunt. (All objectives are shown on the right strip; it’ll show different things depending on whether you are a traitor or not). Usually, there is a traitor, and the traitor has different objectives from everyone else from now on. The traitor knows things that other players don’t, and the players usually know things that the traitor doesn’t as well. Once the objective is fulfilled, either by the traitor or the rest of the players, the game ends. 

Once the haunt starts, traitors (and anything on the traitor’s side; sometimes, the traitor works with monsters or other things that appear once the haunt starts) can attack other players, and vice-versa. You can only attack someone if you are in the same room as them. To attack, you roll dice equal to your might (another stat), and so does the character you are attacking. The difference is taken in damage to any of your stats, depending on which result is higher. 


## Project Design Presentation
_A link to your design presentation/document will go here!_

## How to Build and Run
_A necessary part of any README!_
