let $char_1;
let $char_2;
let $char_3;
let $char_4;
let $char_5;
let $char_6;
 
let $data_1;
let $data_2;
let $data_3;
let $data_4;
let $data_5;
let $data_6;
 
let current_char;
 
let total_players;
let starting_data;
let player_list;
let character_list;
 
$(document).ready(() => {
   
    const $temp_lobby = $("#temp_lobby");
   
    $temp_lobby.show();
});
 
const allow_mouseover = () => {
   
    const stats_2 = document.getElementById("stats_2");
    const stats_3 = document.getElementById("stats_3");
    const stats_4 = document.getElementById("stats_4");
    const stats_5 = document.getElementById("stats_5");
    const stats_6 = document.getElementById("stats_6");
   
    stats_2.onmouseover = function() {
        $("#stats_2_popup").html("PLAYER 2 STATS");
        document.getElementById('stats_2_popup').style.display = 'block';
    };
   
    stats_2.onmouseout = function() {
        document.getElementById('stats_2_popup').style.display = 'none';
    };
 
    stats_3.onmouseover = function() {
        $("#stats_3_popup").html("PLAYER 3 STATS");
        document.getElementById('stats_3_popup').style.display = 'block';
    };
 
    stats_3.onmouseout = function() {
        document.getElementById('stats_3_popup').style.display = 'none';
    };
 
    stats_4.onmouseover = function() {
        $("#stats_4_popup").html("PLAYER 4 STATS");
        document.getElementById('stats_4_popup').style.display = 'block';
    };
 
    stats_4.onmouseout = function() {
        document.getElementById('stats_4_popup').style.display = 'none';
    };
 
    stats_5.onmouseover = function() {
        $("#stats_5_popup").html("PLAYER 5 STATS");
        document.getElementById('stats_5_popup').style.display = 'block';
    };
 
    stats_5.onmouseout = function() {
        document.getElementById('stats_5_popup').style.display = 'none';
    };
 
    stats_6.onmouseover = function() {
        $("#stats_6_popup").html("PLAYER 6 STATS");
        document.getElementById('stats_6_popup').style.display = 'block';
    };
 
    stats_6.onmouseout = function() {
        document.getElementById('stats_6_popup').style.display = 'none';
    };
}
 
const setStartingState = () => {
   
         
   
         const $player_2_stats = $("#stats_2");
         const $player_3_stats = $("#stats_3");
         const $player_4_stats = $("#stats_4");
         const $player_5_stats = $("#stats_5");
         const $player_6_stats = $("#stats_6");
       
       
         $player_3_stats.html("<center>" + $char_3.speedScale[$char_3.speed] + " " +
                $char_3.mightScale[$char_3.might] + " " +
                $char_3.sanityScale[$char_3.sanity] + " " +
                $char_3.knowledgeScale[$char_3.knowledge] + " " + "</center>");
       
         $player_4_stats.html("<center>" + $char_4.speedScale[$char_4.speed] + " " +
                $char_4.mightScale[$char_4.might] + " " +
                $char_4.sanityScale[$char_4.sanity] + " " +
                $char_4.knowledgeScale[$char_4.knowledge] + " " +"</center>");
       
         $player_5_stats.html("<center>" + $char_5.speedScale[$char_5.speed] + " " +
                $char_5.mightScale[$char_5.might] + " " +
                $char_5.sanityScale[$char_5.sanity] + " " +
                $char_5.knowledgeScale[$char_5.knowledge] + " " + "</center>");
       
         $player_6_stats.html("<center>" + $char_6.speedScale[$char_6.speed] + " " +
                $char_6.mightScale[$char_6.might] + " " +
                $char_6.sanityScale[$char_6.sanity] + " " +
                $char_6.knowledgeScale[$char_6.knowledge] + " " + "</center>");
       
         moves = $char_1.speedScale[$char_1.speed - 1];
         movesp.innerHTML = $char_1.speedScale[$char_1.speed - 1];
         const $objective_description = $("#objective_description");
         $objective_description.html("<center>Something weird is going on... <p>Explore the house and find out what!</p></center>");
        document.getElementById("player_1").style.borderColor = "yellow";
}
 
const update = () => {
   
    current_char = turn + 1;
}
 
function set_starting_state(data) {
   
    starting_data = JSON.parse(data.payload);
    console.log(starting_data);
   
    $("#temp_lobby").hide();
   
    var found = false;
    var added = 0;
    var players = JSON.parse(data.turnOrder);
    total_players = players.length;
   
    var first_player = players[0];
   
    player_list = new Array(total_players);
   
    for(var index = 0; index < total_players; index++) {
        if(username === players[index]) {
            player_list[added] = players[index];
            found = true;
            added++;
        } else {
            if(found) {
                player_list[added] = players[index];
                added++;
            }
        }
    }
   
    var needed = (total_players - added);
   
    if(added != total_players) {
        for(var i = 0; i <= needed; i++) {
            player_list[added] = players[i];
            added++;
        }
    }
   
    character_list = new Array(total_players);
   
    for (var i = 0; i < total_players; i++) {
        var player = player_list[i];
        var player_char = "";
       
        for(var j = 0; j < JSON.parse(data.users).length; j++) {
            if(JSON.parse(data.users)[j][0] === player) {
                player_char = JSON.parse(data.users)[j][1];
            }
        }
       
        character_list[i] = player_char;
    }
   
    if(total_players === 1) {
        setup_player_1(true);
        setup_player_2(false);
        setup_player_3(false);
        setup_player_4(false);
        setup_player_5(false);
        setup_player_6(false);
    } else if(total_players === 2) {
        setup_player_1(true);
        setup_player_2(true);
        setup_player_3(false);
        setup_player_4(false);
        setup_player_5(false);
        setup_player_6(false);
    } else if(total_players === 3) {
        setup_player_1(true);
        setup_player_2(true);
        setup_player_3(true);
        setup_player_4(false);
        setup_player_5(false);
        setup_player_6(false);
    } else if(total_players === 4) {
        setup_player_1(true);
        setup_player_2(true);
        setup_player_3(true);
        setup_player_4(true);
        setup_player_5(false);
        setup_player_6(false);
    } else if(total_players === 5) {
        setup_player_1(true);
        setup_player_2(true);
        setup_player_3(true);
        setup_player_4(true);
        setup_player_5(true);
        setup_player_6(false);
    } else if(total_players === 6) {
        setup_player_1(true);
        setup_player_2(true);
        setup_player_3(true);
        setup_player_4(true);
        setup_player_5(true);
        setup_player_6(true);
    } else {
        console.log("ERROR: Weird number of players.");
    }
   
    allow_mouseover();
}
 
function setup_player_1(inGame) {
    if(inGame) {
        const $player_1_name = $("#name_1");
 
        $char_1 = character_list[0];
        $player_1_name.html("<center>" + $char_1 + "</center>");
       
        for(var i = 0; i < total_players; i++) {
            if($char_1 === starting_data.characters[i].name) {
                $data_1 = starting_data.characters[i];
            }
        }
       
        const $player_1_speed = $("#speed_1");
         var $speed = "<center>";
       
         for (let i = 0, len = $data_1.speedScale.length; i < len; i++) {
            if(i === $data_1.speed) {
                $speed += "<font color=\"red\">" + $data_1.speedScale[i] + "</font> ";
            } else {
                $speed += $data_1.speedScale[i] + " ";
            }
         }
       
         const $player_1_might = $("#might_1");
         var $might = "<center>";
       
         for (let i = 0, len = $data_1.mightScale.length; i < len; i++) {
            if(i === $data_1.might) {
                $might += "<font color=\"red\">" + $data_1.mightScale[i] + "</font> ";
            } else {
                $might += $data_1.mightScale[i] + " ";
            }
         }
       
         const $player_1_sanity = $("#sanity_1");
         var $sanity = "<center>";
 
         for (let i = 0, len = $data_1.sanityScale.length; i < len; i++) {
            if(i === $data_1.sanity) {
                $sanity += "<font color=\"red\">" + $data_1.sanityScale[i] + "</font> ";
            } else {
                $sanity += $data_1.sanityScale[i] + " ";
            }
         }
   
         const $player_1_knowledge = $("#knowledge_1");
         var $knowledge = "<center>";
       
         for (let i = 0, len = $data_1.knowledgeScale.length; i < len; i++) {
            if(i === $data_1.knowledge) {
                $knowledge += "<font color=\"red\">" + $data_1.knowledgeScale[i] + "</font> ";
            } else {
                $knowledge += $data_1.knowledgeScale[i] + " ";
            }
         }
       
         $player_1_speed.html($speed + "</center>");
         $player_1_might.html($might + "</center>");
         $player_1_knowledge.html($knowledge + "</center>");
         $player_1_sanity.html($sanity + "</center>");
       
    } else {
       
    }
}
 
function setup_player_2(inGame) {
    if(inGame) {
        const $player_2_name = $("#name_2");
 
        $char_2 = character_list[1];
        $player_2_name.html("<center>" + $char_2 + "</center>");
       
        for(var i = 0; i < total_players; i++) {
            if($char_2 === starting_data.characters[i].name) {
                $data_2 = starting_data.characters[i];
            }
        }
       
        const $player_2_stats = $("#stats_2");
 
        $player_2_stats.html("<center>" + $data_2.speedScale[$data_2.speed] + " " +
            $data_2.mightScale[$data_2.might] + " " +
            $data_2.sanityScale[$data_2.sanity] + " " +
            $data_2.knowledgeScale[$data_2.knowledge] + " " + "</center>");
       
    } else {
       
    }
}
 
function setup_player_3(inGame) {
    if(inGame) {
        const $player_3_name = $("#name_3");
 
        $char_3 = character_list[2];
        $player_3_name.html("<center>" + $char_3 + "</center>");
       
        for(var i = 0; i < total_players; i++) {
            if($char_3 === starting_data.characters[i].name) {
                $data_3 = starting_data.characters[i];
            }
        }
       
        const $player_3_stats = $("#stats_3");
 
        $player_3_stats.html("<center>" + $data_3.speedScale[$data_3.speed] + " " +
            $data_3.mightScale[$data_3.might] + " " +
            $data_3.sanityScale[$data_3.sanity] + " " +
            $data_3.knowledgeScale[$data_3.knowledge] + " " + "</center>");
       
    } else {
       
    }
}
 
function setup_player_4(inGame) {
    if(inGame) {
        const $player_4_name = $("#name_4");
 
        $char_4 = character_list[3];
        $player_4_name.html("<center>" + $char_4 + "</center>");
       
        for(var i = 0; i < total_players; i++) {
            if($char_4 === starting_data.characters[i].name) {
                $data_4 = starting_data.characters[i];
            }
        }
       
        const $player_4_stats = $("#stats_4");
 
        $player_4_stats.html("<center>" + $data_4.speedScale[$data_4.speed] + " " +
            $data_4.mightScale[$data_4.might] + " " +
            $data_4.sanityScale[$data_4.sanity] + " " +
            $data_4.knowledgeScale[$data_4.knowledge] + " " + "</center>");
       
    } else {
       
    }
}
 
function setup_player_5(inGame) {
    if(inGame) {
        const $player_5_name = $("#name_5");
 
        $char_5 = character_list[4];
        $player_5_name.html("<center>" + $char_5 + "</center>");
       
        for(var i = 0; i < total_players; i++) {
            if($char_5 === starting_data.characters[i].name) {
                $data_5 = starting_data.characters[i];
            }
        }
       
        const $player_5_stats = $("#stats_5");
 
        $player_5_stats.html("<center>" + $data_5.speedScale[$data_5.speed] + " " +
            $data_5.mightScale[$data_5.might] + " " +
            $data_5.sanityScale[$data_5.sanity] + " " +
            $data_5.knowledgeScale[$data_5.knowledge] + " " + "</center>");
       
    } else {
       
    }
}
 
function setup_player_6(inGame) {
    if(inGame) {
        const $player_6_name = $("#name_6");
 
        $char_6 = character_list[5];
        $player_6_name.html("<center>" + $char_6 + "</center>");
       
        for(var i = 0; i < total_players; i++) {
            if($char_6 === starting_data.characters[i].name) {
                $data_6 = starting_data.characters[i];
            }
        }
       
        const $player_6_stats = $("#stats_6");
 
        $player_6_stats.html("<center>" + $data_6.speedScale[$data_6.speed] + " " +
            $data_6.mightScale[$data_6.might] + " " +
            $data_6.sanityScale[$data_6.sanity] + " " +
            $data_6.knowledgeScale[$data_6.knowledge] + " " + "</center>");
       
    } else {
       
    }
}

