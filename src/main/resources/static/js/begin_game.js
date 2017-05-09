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

let current_char_name = "";
 
let current_char;
let current_turn; 
let total_players;
let starting_data;
let player_list;
let character_list;

let message_log ="";
 
$(document).ready(() => {
   
    const $temp_lobby = $("#temp_lobby");
   
    $temp_lobby.show();
});

const allow_chat = () => {
	$("#chat_text").bind("keypress", function(e) {
		if(e.which == 13) {
			
			var mess = $("#chat_text").val();
			console.log(mess);
			
			var message = {
					type: MESSAGE_TYPE.CHATUPDATE,
					payload: {
						id : userId,
						message : mess
					}
		      }

			const json = JSON.stringify(message);
			conn.send(json);
			
			document.getElementById("chat_text").value = "";
		}
	});
}

function display_message(data) {
	
	message_log += data.name + ": " + data.message + "<br />";
	
	$("#chat_log").html(message_log);
	var log = document.getElementById("chat_log");
	log.scrollTop = log.scrollHeight;
}
 
const allow_mouseover = () => {
   
    const stats_2 = document.getElementById("stats_2");
    const stats_3 = document.getElementById("stats_3");
    const stats_4 = document.getElementById("stats_4");
    const stats_5 = document.getElementById("stats_5");
    const stats_6 = document.getElementById("stats_6");
   
    stats_2.onmouseover = function() {
        $("#stats_2_popup").html("Speed - Might - Sanity - Knowledge");
        document.getElementById('stats_2_popup').style.display = 'block';
    };
   
    stats_2.onmouseout = function() {
        document.getElementById('stats_2_popup').style.display = 'none';
    };
 
    stats_3.onmouseover = function() {
        $("#stats_3_popup").html("Speed - Might - Sanity - Knowledge");
        document.getElementById('stats_3_popup').style.display = 'block';
    };
 
    stats_3.onmouseout = function() {
        document.getElementById('stats_3_popup').style.display = 'none';
    };
 
    stats_4.onmouseover = function() {
        $("#stats_4_popup").html("Speed - Might - Sanity - Knowledge");
        document.getElementById('stats_4_popup').style.display = 'block';
    };
 
    stats_4.onmouseout = function() {
        document.getElementById('stats_4_popup').style.display = 'none';
    };
 
    stats_5.onmouseover = function() {
        $("#stats_5_popup").html("Speed - Might - Sanity - Knowledge");
        document.getElementById('stats_5_popup').style.display = 'block';
    };
 
    stats_5.onmouseout = function() {
        document.getElementById('stats_5_popup').style.display = 'none';
    };
 
    stats_6.onmouseover = function() {
        $("#stats_6_popup").html("Speed - Might - Sanity - Knowledge");
        document.getElementById('stats_6_popup').style.display = 'block';
    };
 
    stats_6.onmouseout = function() {
        document.getElementById('stats_6_popup').style.display = 'none';
    };
}

function set_starting_state(data) {
	
	starting_data = JSON.parse(data.payload);
	console.log(starting_data);
	
	$("#temp_lobby").hide();
	
	var found = false;
	var added = 0;
	var players = JSON.parse(data.turnOrder);
	total_players = players.length;
	current_turn = 0;
	
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
		
		if(player === first_player) {
			current_char = i;
			console.log(i);
		}
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
	allow_chat();
	allowkeys = true;

	current_char--;
	current_turn--;
	update_turn(0);
	const $objective_description = $("#objective_description");
	$objective_description.html("<center>Something weird is going on... <p>Explore the house and find out what!</p></center>");
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
       
         var icon = $("#icon_1");
         
         switch($char_1) {
         	default :
         		console.log("should not get here!");
         		break;
         	case "Darrin 'Flash' Williams" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/10e75595bcbe2b3fe1ed07d7e2198a62/tumblr_opoocmb3Yj1tfi4hzo1_1280.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Ox Bellows" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/f44f78562f3abc6a79b366af80662a36/tumblr_opoocmb3Yj1tfi4hzo2_1280.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Brandon Jaspers" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/919f4e70b1690921871a355205bd9c00/tumblr_opoodwJKtX1tfi4hzo5_1280.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Peter Akimoto" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/a6c6d7e2ca1f0387081274d2083e7342/tumblr_opoodwJKtX1tfi4hzo4_1280.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Professor Longfellow" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/efbd829de01b6f643e2eccaa2e12db55/tumblr_opoocmb3Yj1tfi4hzo6_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Father Rhinehardt" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/24ba17f9cd903f4d1543801ce4c5dc4f/tumblr_opoocmb3Yj1tfi4hzo5_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Missy Dubourde" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/3868e3003998973b749ec97ee7385c58/tumblr_opoocmb3Yj1tfi4hzo3_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Zoe Ingstrom" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/0342acaff6cb1c673ff3d9f140cbc1d5/tumblr_opoocmb3Yj1tfi4hzo4_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Heather Granville" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/5d4c0001b5f4f4a7a9998d3ba5d47819/tumblr_opoodwJKtX1tfi4hzo3_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Jenny LeClerc" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/95069d02b4d42d3ea41224a4aad743c2/tumblr_opoodwJKtX1tfi4hzo6_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Vivian Lopez" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/bb340e320709c3886f8ed9dce91d8819/tumblr_opoodwJKtX1tfi4hzo1_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         	case "Madame Zostra" :
         		icon.html("<center><img src=\"http://68.media.tumblr.com/abde61c175160ed4d997a98ada201b76/tumblr_opoodwJKtX1tfi4hzo2_250.jpg\" alt=\"Player 1\" style=\"width:100px;height:100px;border-style:solid;border-width:2px;\"></center>");
         		break;
         }
         
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
        
        var icon = $("#icon_2");
        
        switch($char_2) {
        	default :
        		console.log("should not get here!");
        		break;
        	case "Darrin 'Flash' Williams" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/10e75595bcbe2b3fe1ed07d7e2198a62/tumblr_opoocmb3Yj1tfi4hzo1_1280.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Ox Bellows" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/f44f78562f3abc6a79b366af80662a36/tumblr_opoocmb3Yj1tfi4hzo2_1280.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Brandon Jaspers" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/919f4e70b1690921871a355205bd9c00/tumblr_opoodwJKtX1tfi4hzo5_1280.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Peter Akimoto" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/a6c6d7e2ca1f0387081274d2083e7342/tumblr_opoodwJKtX1tfi4hzo4_1280.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Professor Longfellow" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/efbd829de01b6f643e2eccaa2e12db55/tumblr_opoocmb3Yj1tfi4hzo6_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Father Rhinehardt" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/24ba17f9cd903f4d1543801ce4c5dc4f/tumblr_opoocmb3Yj1tfi4hzo5_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Missy Dubourde" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/3868e3003998973b749ec97ee7385c58/tumblr_opoocmb3Yj1tfi4hzo3_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Zoe Ingstrom" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/0342acaff6cb1c673ff3d9f140cbc1d5/tumblr_opoocmb3Yj1tfi4hzo4_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Heather Granville" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/5d4c0001b5f4f4a7a9998d3ba5d47819/tumblr_opoodwJKtX1tfi4hzo3_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Jenny LeClerc" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/95069d02b4d42d3ea41224a4aad743c2/tumblr_opoodwJKtX1tfi4hzo6_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Vivian Lopez" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/bb340e320709c3886f8ed9dce91d8819/tumblr_opoodwJKtX1tfi4hzo1_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Madame Zostra" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/abde61c175160ed4d997a98ada201b76/tumblr_opoodwJKtX1tfi4hzo2_250.jpg\" alt=\"Player 2\" style=\"width:75px;height75px;\"></center>");
        		break;
        }
       
    } else {
    	const $player_2_name = $("#name_2");
    	$player_2_name.html("<center> Another victim of the house... </center>");
    	const $player_2_stats = $("#stats_2");
    	$player_2_stats.html("<center>X X X X</center>");
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
        
        var icon = $("#icon_3");
        
        switch($char_3) {
        	default :
        		console.log("should not get here!");
        		break;
        	case "Darrin 'Flash' Williams" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/10e75595bcbe2b3fe1ed07d7e2198a62/tumblr_opoocmb3Yj1tfi4hzo1_1280.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Ox Bellows" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/f44f78562f3abc6a79b366af80662a36/tumblr_opoocmb3Yj1tfi4hzo2_1280.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Brandon Jaspers" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/919f4e70b1690921871a355205bd9c00/tumblr_opoodwJKtX1tfi4hzo5_1280.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Peter Akimoto" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/a6c6d7e2ca1f0387081274d2083e7342/tumblr_opoodwJKtX1tfi4hzo4_1280.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Professor Longfellow" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/efbd829de01b6f643e2eccaa2e12db55/tumblr_opoocmb3Yj1tfi4hzo6_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Father Rhinehardt" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/24ba17f9cd903f4d1543801ce4c5dc4f/tumblr_opoocmb3Yj1tfi4hzo5_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Missy Dubourde" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/3868e3003998973b749ec97ee7385c58/tumblr_opoocmb3Yj1tfi4hzo3_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Zoe Ingstrom" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/0342acaff6cb1c673ff3d9f140cbc1d5/tumblr_opoocmb3Yj1tfi4hzo4_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Heather Granville" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/5d4c0001b5f4f4a7a9998d3ba5d47819/tumblr_opoodwJKtX1tfi4hzo3_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Jenny LeClerc" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/95069d02b4d42d3ea41224a4aad743c2/tumblr_opoodwJKtX1tfi4hzo6_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Vivian Lopez" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/bb340e320709c3886f8ed9dce91d8819/tumblr_opoodwJKtX1tfi4hzo1_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Madame Zostra" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/abde61c175160ed4d997a98ada201b76/tumblr_opoodwJKtX1tfi4hzo2_250.jpg\" alt=\"Player 3\" style=\"width:75px;height75px;\"></center>");
        		break;
        }
       
    } else {
    	const $player_3_name = $("#name_3");
    	$player_3_name.html("<center> Another victim of the house... </center>");
    	const $player_3_stats = $("#stats_3");
    	$player_3_stats.html("<center>X X X X</center>");
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

        var icon = $("#icon_4");
        
        switch($char_4) {
        	default :
        		console.log("should not get here!");
        		break;
        	case "Darrin 'Flash' Williams" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/10e75595bcbe2b3fe1ed07d7e2198a62/tumblr_opoocmb3Yj1tfi4hzo1_1280.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Ox Bellows" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/f44f78562f3abc6a79b366af80662a36/tumblr_opoocmb3Yj1tfi4hzo2_1280.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Brandon Jaspers" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/919f4e70b1690921871a355205bd9c00/tumblr_opoodwJKtX1tfi4hzo5_1280.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Peter Akimoto" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/a6c6d7e2ca1f0387081274d2083e7342/tumblr_opoodwJKtX1tfi4hzo4_1280.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Professor Longfellow" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/efbd829de01b6f643e2eccaa2e12db55/tumblr_opoocmb3Yj1tfi4hzo6_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Father Rhinehardt" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/24ba17f9cd903f4d1543801ce4c5dc4f/tumblr_opoocmb3Yj1tfi4hzo5_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Missy Dubourde" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/3868e3003998973b749ec97ee7385c58/tumblr_opoocmb3Yj1tfi4hzo3_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Zoe Ingstrom" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/0342acaff6cb1c673ff3d9f140cbc1d5/tumblr_opoocmb3Yj1tfi4hzo4_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Heather Granville" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/5d4c0001b5f4f4a7a9998d3ba5d47819/tumblr_opoodwJKtX1tfi4hzo3_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Jenny LeClerc" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/95069d02b4d42d3ea41224a4aad743c2/tumblr_opoodwJKtX1tfi4hzo6_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Vivian Lopez" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/bb340e320709c3886f8ed9dce91d8819/tumblr_opoodwJKtX1tfi4hzo1_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Madame Zostra" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/abde61c175160ed4d997a98ada201b76/tumblr_opoodwJKtX1tfi4hzo2_250.jpg\" alt=\"Player 4\" style=\"width:75px;height75px;\"></center>");
        		break;
        }
    } else {
    	const $player_4_name = $("#name_4");
    	$player_4_name.html("<center> Another victim of the house... </center>");
    	const $player_4_stats = $("#stats_4");
    	$player_4_stats.html("<center>X X X X</center>");
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

        var icon = $("#icon_5");
        
        switch($char_5) {
        	default :
        		console.log("should not get here!");
        		break;
        	case "Darrin 'Flash' Williams" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/10e75595bcbe2b3fe1ed07d7e2198a62/tumblr_opoocmb3Yj1tfi4hzo1_1280.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Ox Bellows" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/f44f78562f3abc6a79b366af80662a36/tumblr_opoocmb3Yj1tfi4hzo2_1280.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Brandon Jaspers" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/919f4e70b1690921871a355205bd9c00/tumblr_opoodwJKtX1tfi4hzo5_1280.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Peter Akimoto" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/a6c6d7e2ca1f0387081274d2083e7342/tumblr_opoodwJKtX1tfi4hzo4_1280.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Professor Longfellow" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/efbd829de01b6f643e2eccaa2e12db55/tumblr_opoocmb3Yj1tfi4hzo6_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Father Rhinehardt" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/24ba17f9cd903f4d1543801ce4c5dc4f/tumblr_opoocmb3Yj1tfi4hzo5_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Missy Dubourde" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/3868e3003998973b749ec97ee7385c58/tumblr_opoocmb3Yj1tfi4hzo3_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Zoe Ingstrom" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/0342acaff6cb1c673ff3d9f140cbc1d5/tumblr_opoocmb3Yj1tfi4hzo4_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Heather Granville" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/5d4c0001b5f4f4a7a9998d3ba5d47819/tumblr_opoodwJKtX1tfi4hzo3_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Jenny LeClerc" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/95069d02b4d42d3ea41224a4aad743c2/tumblr_opoodwJKtX1tfi4hzo6_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Vivian Lopez" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/bb340e320709c3886f8ed9dce91d8819/tumblr_opoodwJKtX1tfi4hzo1_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Madame Zostra" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/abde61c175160ed4d997a98ada201b76/tumblr_opoodwJKtX1tfi4hzo2_250.jpg\" alt=\"Player 5\" style=\"width:75px;height75px;\"></center>");
        		break;
        }
    } else {
    	const $player_5_name = $("#name_5");
    	$player_5_name.html("<center> Another victim of the house... </center>");
    	const $player_5_stats = $("#stats_5");
    	$player_5_stats.html("<center>X X X X</center>");
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

        var icon = $("#icon_6");
        
        switch($char_6) {
        	default :
        		console.log("should not get here!");
        		break;
        	case "Darrin 'Flash' Williams" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/10e75595bcbe2b3fe1ed07d7e2198a62/tumblr_opoocmb3Yj1tfi4hzo1_1280.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Ox Bellows" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/f44f78562f3abc6a79b366af80662a36/tumblr_opoocmb3Yj1tfi4hzo2_1280.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Brandon Jasprs" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/919f4e70b1690921871a355205bd9c00/tumblr_opoodwJKtX1tfi4hzo5_1280.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Peter Akimoto" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/a6c6d7e2ca1f0387081274d2083e7342/tumblr_opoodwJKtX1tfi4hzo4_1280.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Professor Longfellow" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/efbd829de01b6f643e2eccaa2e12db55/tumblr_opoocmb3Yj1tfi4hzo6_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Father Rhinehardt" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/24ba17f9cd903f4d1543801ce4c5dc4f/tumblr_opoocmb3Yj1tfi4hzo5_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Missy Dubourde" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/3868e3003998973b749ec97ee7385c58/tumblr_opoocmb3Yj1tfi4hzo3_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Zoe Ingstrom" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/0342acaff6cb1c673ff3d9f140cbc1d5/tumblr_opoocmb3Yj1tfi4hzo4_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Heather Granville" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/5d4c0001b5f4f4a7a9998d3ba5d47819/tumblr_opoodwJKtX1tfi4hzo3_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Jenny LeClerc" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/95069d02b4d42d3ea41224a4aad743c2/tumblr_opoodwJKtX1tfi4hzo6_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Vivian Lopez" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/bb340e320709c3886f8ed9dce91d8819/tumblr_opoodwJKtX1tfi4hzo1_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        	case "Madame Zostra" :
        		icon.html("<center><img src=\"http://68.media.tumblr.com/abde61c175160ed4d997a98ada201b76/tumblr_opoodwJKtX1tfi4hzo2_250.jpg\" alt=\"Player 6\" style=\"width:75px;height75px;\"></center>");
        		break;
        }
	} else {
    	const $player_6_name = $("#name_6");
    	$player_6_name.html("<center> Another victim of the house... </center>");
    	const $player_6_stats = $("#stats_6");
    	$player_6_stats.html("<center>X X X X</center>");
	}
}
