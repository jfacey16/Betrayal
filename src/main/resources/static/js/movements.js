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
    const movesp = document.getElementById("moves");
    const mfirst = document.getElementById("mfirst");
    const msecond = document.getElementById("msecond");
    const mbasement = document.getElementById("mbasement");
    const rotation = document.getElementById("rot");
    const placet = document.getElementById("plat");
    const ending = document.getElementById("end");

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
      if (moves > 0 && rotation.disabled && placet.disabled) {
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
          const postParameters = {name: "move", direction: "UP"};
          $.post("/requestTile", postParameters, responseJSON => {
            const responseObject = JSON.parse(responseJSON);
            console.log(responseObject);
          });
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
          movesp.innerHTML = moves;
        } else if (positions[turn].posx == 600 && positions[turn].posy == 600 &&
          positions[turn].floor == 2 && event.which == 69) {
          ctx.clearRect(600 + offsets[turn].posx - 1, 600 + offsets[turn].posy - 1, P + 2, P + 2);
          ctxf.strokeRect(900 + offsets[turn].posx, 600 + offsets[turn].posy, P, P);
          ctxm.clearRect((600 + offsets[turn].posx) / S - 1,
            (600 + offsets[turn].posy) / S - 1, P / S + 2, P / S + 2);
          ctxmf.strokeRect((900 + offsets[turn].posx) / S,
            (600 + offsets[turn].posy) / S, P / S, P / S);
          const postParameters = {name: "move", direction: "DOWN"};
          $.post("/requestTile", postParameters, responseJSON => {
            const responseObject = JSON.parse(responseJSON);
            console.log(responseObject);
          });
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
          movesp.innerHTML = moves;
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
//              const ntile = new Tile(positions[turn].posx, positions[turn].posy - T, r1, r2, true, r3);
//              flo.push(ntile);
            if ((positions[turn].posy - T) != 600 || (positions[turn].posx != 600 && positions[turn].posx != 750
             && positions[turn].posx != 900)) {
              ctx.strokeRect(positions[turn].posx, positions[turn].posy - T, T, T);
              ctxm.strokeRect(positions[turn].posx / S, (positions[turn].posy - T) / S, P, P);
            }
//              if (r1 == true)
//                ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - T, D, X);
//              if (r2 == true)
//                ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy - T + D, X, D);
//              if (r3 == true)
//                ctx.strokeRect(positions[turn].posx, positions[turn].posy - T + D, X, D);
//             ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - X, D, X);
//              positions[turn].north = r1;
//              positions[turn].east = r2;
//              positions[turn].south = true;
//              positions[turn].west = r3;
                const postParameters = {name: "move", direction: "NORTH"};
                $.post("/requestTile", postParameters, responseJSON => {
                  const responseObject = JSON.parse(responseJSON);
                  console.log(responseObject);
                  if (responseObject.newtile.availableDoors.length == 4) {
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - T, D, X);
                    ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy - T + D, X, D);
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - X, D, X);
                    ctx.strokeRect(positions[turn].posx, positions[turn].posy - T + D, X, D);
                    $.post("/requestTile", {name: "move", rotations: "0"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = true;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = true;
                    const ntile = new Tile(positions[turn].posx, positions[turn].posy - T, true, true, true, true);
                    flo.push(ntile);
                  } else if (responseObject.newtile.availableDoors.length == 3) {
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - T, D, X);
                    ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy - T + D, X, D);
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - X, D, X);
                    rotation.disabled = false;
                    placet.disabled = false;
                    rot = 0;
                    avdoor = 3;
                    tempdir = 0;
                    rottile = new Tile(positions[turn].posx, positions[turn].posy - T, true, true, true, false);
                    positions[turn].north = true;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = false;
                  } else if (responseObject.newtile.availableDoors.length == 2) {
                    if ((responseObject.newtile.availableDoors.indexOf("NORTH") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("SOUTH") != -1) ||
                      (responseObject.newtile.availableDoors.indexOf("EAST") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("WEST") != -1)) {
                      ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - T, D, X);
                      ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - X, D, X);
                      $.post("/requestTile", {name: "move", rotations: "0"}, rj2 => {
                        const ro = JSON.parse(rj2);
                        receiveTile(ro);
                      });
                      positions[turn].north = true;
                      positions[turn].east = false;
                      positions[turn].south = true;
                      positions[turn].west = false;    
                    } else {
                      ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy - T + D, X, D);
                      ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - X, D, X);
                      rotation.disabled = false;
                      placet.disabled = false;
                      rot = 1;
                      avdoor = 2;
                      tempdir = 0;
                      rottile = new Tile(positions[turn].posx, positions[turn].posy - T, false, true, true, false);
                      positions[turn].north = false;
                      positions[turn].east = true;
                      positions[turn].south = true;
                      positions[turn].west = false;
                    }
 
                  } else if (responseObject.newtile.availableDoors.length == 1) {
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy - X, D, X);
                    $.post("/requestTile", {name: "move", rotations: "2"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = false;
                    positions[turn].east = false;
                    positions[turn].south = true;
                    positions[turn].west = false;
                    const ntile = new Tile(positions[turn].posx, positions[turn].posy - T, false, false, true, false);
                    flo.push(ntile);
                  }
 
                  ctx.font = "17px Times New Roman";
                  ctx.fillText(responseObject.newtile.name, positions[turn].posx + textOff.posx,
                    positions[turn].posy - T + textOff.posy);
                  console.log(responseObject.newtile.name);
                  ctx.font = "25px Times New Roman";
                  if (responseObject.newtile.eventCount > 0)
                    ctx.fillText("E", positions[turn].posx + symbOff.posx, positions[turn].posy - T + symbOff.posy);
                  else if (responseObject.newtile.itemCount > 0)
                    ctx.fillText("I", positions[turn].posx + symbOff.posx + 6, positions[turn].posy - T + symbOff.posy);
                  else if (responseObject.newtile.omenCount > 0)
                    ctx.fillText("O", positions[turn].posx + symbOff.posx - 2, positions[turn].posy - T + symbOff.posy);
 
                  positions[turn].posy = positions[turn].posy - T;
                  moves--;
                  movesp.innerHTML = moves;
                  const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
                  const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
                  lev.style.top = ypos + 'px';
                  lev.style.left = xpos + 'px';
                });  
           
            } else {
              const postParameters = {name: "move", direction: "NORTH"};
              $.post("/requestTile", postParameters, responseJSON => {
                const responseObject = JSON.parse(responseJSON);
                console.log(responseObject);
              });
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
              positions[turn].posy = positions[turn].posy - T;
              moves--;
              movesp.innerHTML = moves;
              const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
              const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
              lev.style.top = ypos + 'px';
              lev.style.left = xpos + 'px';
            }
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
              // const ntile = new Tile(positions[turn].posx + T, positions[turn].posy, r1, r2, r3, true);
              // flo.push(ntile);
              if ((positions[turn].posy) != 600 || ((positions[turn].posx + T) != 600 && (positions[turn].posx + T) != 750
             && (positions[turn].posx + T) != 900)) {
                ctx.strokeRect(positions[turn].posx + T, positions[turn].posy, T, T);
                ctxm.strokeRect((positions[turn].posx + T) / S, positions[turn].posy / S, P, P);
              }
              // if (r1 == true)
              //   ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy, D, X);
              // if (r2 == true)
              //   ctx.strokeRect(positions[turn].posx + T + T - X, positions[turn].posy + D, X, D);
              // if (r3 == true)
              //   ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy + T - X, D, X);
              // ctx.strokeRect(positions[turn].posx + T, positions[turn].posy + D, X, D);
              // positions[turn].north = r1;
              // positions[turn].east = r2;
              // positions[turn].south = r3;
              // positions[turn].west = true;
              const postParameters = {name: "move", direction: "EAST"};
              $.post("/requestTile", postParameters, responseJSON => {
                  const responseObject = JSON.parse(responseJSON);
                  console.log(responseObject);
                  if (responseObject.newtile.availableDoors.length == 4) {
                    ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy, D, X);
                    ctx.strokeRect(positions[turn].posx + T + T - X, positions[turn].posy + D, X, D);
                    ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy + T - X, D, X);
                    ctx.strokeRect(positions[turn].posx + T, positions[turn].posy + D, X, D);
                    $.post("/requestTile", {name: "move", rotations: "0"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = true;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = true;
                    const ntile = new Tile(positions[turn].posx + T, positions[turn].posy, true, true, true, true);
                    flo.push(ntile);
                  } else if (responseObject.newtile.availableDoors.length == 3) {
                    ctx.strokeRect(positions[turn].posx + T + T - X, positions[turn].posy + D, X, D);
                    ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy + T - X, D, X);
                    ctx.strokeRect(positions[turn].posx + T, positions[turn].posy + D, X, D);
                    rotation.disabled = false;
                    placet.disabled = false;
                    rot = 1;
                    avdoor = 3;
                    tempdir = 1;
                    rottile = new Tile(positions[turn].posx + T, positions[turn].posy, false, true, true, true);
                    positions[turn].north = false;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = true;
                  } else if (responseObject.newtile.availableDoors.length == 2) {
                    if ((responseObject.newtile.availableDoors.indexOf("NORTH") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("SOUTH") != -1) ||
                      (responseObject.newtile.availableDoors.indexOf("EAST") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("WEST") != -1)) {
                      ctx.strokeRect(positions[turn].posx + T + T - X, positions[turn].posy + D, X, D);
                      ctx.strokeRect(positions[turn].posx + T, positions[turn].posy + D, X, D);
                      $.post("/requestTile", {name: "move", rotations: "1"}, rj2 => {
                        const ro = JSON.parse(rj2);
                        receiveTile(ro);
                      });
                      positions[turn].north = false;
                      positions[turn].east = true;
                      positions[turn].south = false;
                      positions[turn].west = true;    
                    } else {
                      ctx.strokeRect(positions[turn].posx + T + D, positions[turn].posy + T - X, D, X);
                      ctx.strokeRect(positions[turn].posx + T, positions[turn].posy + D, X, D);
                      rotation.disabled = false;
                      placet.disabled = false;
                      rot = 2;
                      avdoor = 2;
                      tempdir = 1;
                      rottile = new Tile(positions[turn].posx + T, positions[turn].posy, false, false, true, true);
                      positions[turn].north = false;
                      positions[turn].east = false;
                      positions[turn].south = true;
                      positions[turn].west = true;
                    }

                  } else if (responseObject.newtile.availableDoors.length == 1) {
                    ctx.strokeRect(positions[turn].posx + T, positions[turn].posy + D, X, D);
                    $.post("/requestTile", {name: "move", rotations: "3"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = false;
                    positions[turn].east = false;
                    positions[turn].south = false;
                    positions[turn].west = true;
                    const ntile = new Tile(positions[turn].posx + T, positions[turn].posy, false, false, false, true);
                    flo.push(ntile);
                  }
 
                  ctx.font = "17px Times New Roman";
                  ctx.fillText(responseObject.newtile.name, positions[turn].posx + T + textOff.posx,
                    positions[turn].posy + textOff.posy);
                  console.log(responseObject.newtile.name);
                  ctx.font = "25px Times New Roman";
                  if (responseObject.newtile.eventCount > 0)
                    ctx.fillText("E", positions[turn].posx + T + symbOff.posx, positions[turn].posy + symbOff.posy);
                  else if (responseObject.newtile.itemCount > 0)
                    ctx.fillText("I", positions[turn].posx + T + symbOff.posx + 6, positions[turn].posy + symbOff.posy);
                  else if (responseObject.newtile.omenCount > 0)
                    ctx.fillText("O", positions[turn].posx + T + symbOff.posx - 2, positions[turn].posy + symbOff.posy);

                  positions[turn].posx = positions[turn].posx + T;
                  moves--;
                  movesp.innerHTML = moves;
                  const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
                  const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
                  lev.style.top = ypos + 'px';
                  lev.style.left = xpos + 'px';
                });
            } else {
              const postParameters = {name: "move", direction: "EAST"};
              $.post("/requestTile", postParameters, responseJSON => {
                const responseObject = JSON.parse(responseJSON);
                console.log(responseObject);
              });
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
              positions[turn].posx = positions[turn].posx + T;
              moves--;
              movesp.innerHTML = moves;
              const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
              const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
              lev.style.top = ypos + 'px';
              lev.style.left = xpos + 'px';
            }
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
              // const ntile = new Tile(positions[turn].posx, positions[turn].posy + T, true, r1, r2, r3);
              // flo.push(ntile);
              if ((positions[turn].posy + T) != 600 || (positions[turn].posx != 600 && positions[turn].posx != 750
             && positions[turn].posx != 900)) {
                ctx.strokeRect(positions[turn].posx, positions[turn].posy + T, T, T);
                ctxm.strokeRect(positions[turn].posx / S, (positions[turn].posy + T) / S, P, P);
              }
              // if (r1 == true)
              //   ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy + T + D, X, D);
              // if (r2 == true)
              //   ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T + T - X, D, X);
              // if (r3 == true)
              //   ctx.strokeRect(positions[turn].posx, positions[turn].posy + T + D, X, D);
              // ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T, D, X);
              // positions[turn].north = true;
              // positions[turn].east = r1;
              // positions[turn].south = r2;
              // positions[turn].west = r3;
              const postParameters = {name: "move", direction: "SOUTH"};
              $.post("/requestTile", postParameters, responseJSON => {
                  const responseObject = JSON.parse(responseJSON);
                  console.log(responseObject);
                  if (responseObject.newtile.availableDoors.length == 4) {
                    console.log("4");
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T, D, X);
                    ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy + T + D, X, D);
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T + T - X, D, X);
                    ctx.strokeRect(positions[turn].posx, positions[turn].posy + T + D, X, D);
                    $.post("/requestTile", {name: "move", rotations: "0"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = true;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = true;
                    const ntile = new Tile(positions[turn].posx, positions[turn].posy + T, true, true, true, true);
                    flo.push(ntile);
                  } else if (responseObject.newtile.availableDoors.length == 3) {
                    console.log("3");
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T, D, X);
                    ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy + T + D, X, D);
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T + T - X, D, X);
                    rotation.disabled = false;
                    placet.disabled = false;
                    rot = 0;
                    avdoor = 3;
                    tempdir = 2;
                    rottile = new Tile(positions[turn].posx, positions[turn].posy + T, true, true, true, false);
                    positions[turn].north = true;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = false;
                  } else if (responseObject.newtile.availableDoors.length == 2) {
                    console.log("2");
                    if ((responseObject.newtile.availableDoors.indexOf("NORTH") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("SOUTH") != -1) ||
                      (responseObject.newtile.availableDoors.indexOf("EAST") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("WEST") != -1)) {
                      ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T, D, X);
                      ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T + T - X, D, X);
                      $.post("/requestTile", {name: "move", rotations: "0"}, rj2 => {
                        const ro = JSON.parse(rj2);
                        receiveTile(ro);
                      });
                      positions[turn].north = true;
                      positions[turn].east = false;
                      positions[turn].south = true;
                      positions[turn].west = false;    
                    } else {
                      ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T, D, X);
                      ctx.strokeRect(positions[turn].posx + T - X, positions[turn].posy + T + D, X, D);
                      rotation.disabled = false;
                      placet.disabled = false;
                      rot = 0;
                      avdoor = 2;
                      tempdir = 2;
                      rottile = new Tile(positions[turn].posx, positions[turn].posy + T, true, true, false, false);
                      positions[turn].north = true;
                      positions[turn].east = true;
                      positions[turn].south = false;
                      positions[turn].west = false;
                    }

                  } else if (responseObject.newtile.availableDoors.length == 1) {
                    console.log("1");
                    ctx.strokeRect(positions[turn].posx + D, positions[turn].posy + T, D, X);
                    $.post("/requestTile", {name: "move", rotations: "0"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = true;
                    positions[turn].east = false;
                    positions[turn].south = false;
                    positions[turn].west = false;
                    const ntile = new Tile(positions[turn].posx, positions[turn].posy + T, true, false, false, false);
                    flo.push(ntile);
                  }

                  ctx.font = "17px Times New Roman";
                  ctx.fillText(responseObject.newtile.name, positions[turn].posx + textOff.posx, positions[turn].posy + T + textOff.posy);
                  console.log(responseObject.newtile.name);
                  ctx.font = "25px Times New Roman";
                  if (responseObject.newtile.eventCount > 0)
                    ctx.fillText("E", positions[turn].posx + symbOff.posx, positions[turn].posy + T + symbOff.posy);
                  else if (responseObject.newtile.itemCount > 0)
                    ctx.fillText("I", positions[turn].posx + symbOff.posx + 6, positions[turn].posy + T + symbOff.posy);
                  else if (responseObject.newtile.omenCount > 0)
                    ctx.fillText("O", positions[turn].posx + symbOff.posx - 2, positions[turn].posy + T + symbOff.posy);

                  positions[turn].posy = positions[turn].posy + T;
                  moves--;
                  movesp.innerHTML = moves;
                  const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
                  const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
                  lev.style.top = ypos + 'px';
                  lev.style.left = xpos + 'px';
                });
            } else {
              const postParameters = {name: "move", direction: "SOUTH"};
              $.post("/requestTile", postParameters, responseJSON => {
                const responseObject = JSON.parse(responseJSON);
                console.log(responseObject);
              });
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
              positions[turn].posy = positions[turn].posy + T;
              moves--;
              movesp.innerHTML = moves;
              const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
              const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
              lev.style.top = ypos + 'px';
              lev.style.left = xpos + 'px';
            }
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
              // const ntile = new Tile(positions[turn].posx - T, positions[turn].posy, r1, true, r2, r3);
              // flo.push(ntile);
              if ((positions[turn].posy) != 600 || ((positions[turn].posx + T) != 600 && (positions[turn].posx + T) != 750
             && (positions[turn].posx + T) != 900)) {
                ctx.strokeRect(positions[turn].posx - T, positions[turn].posy, T, T);
                ctxm.strokeRect((positions[turn].posx - T) / S, positions[turn].posy / S, P, P);
              }
              // if (r1 == true)
              //   ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy, D, X);
              // if (r2 == true)
              //   ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy + T - X, D, X);
              // if (r3 == true)
              //   ctx.strokeRect(positions[turn].posx - T, positions[turn].posy + D, X, D);
              // ctx.strokeRect(positions[turn].posx - X, positions[turn].posy + D, X, D);
              // positions[turn].north = r1;
              // positions[turn].east = true;
              // positions[turn].south = r2;
              // positions[turn].west = r3;
              const postParameters = {name: "move", direction: "WEST"};
              $.post("/requestTile", postParameters, responseJSON => {
                  const responseObject = JSON.parse(responseJSON);
                  console.log(responseObject);
                  if (responseObject.newtile.availableDoors.length == 4) {
                    ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy, D, X);
                    ctx.strokeRect(positions[turn].posx - X, positions[turn].posy + D, X, D);
                    ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy + T - X, D, X);
                    ctx.strokeRect(positions[turn].posx - T, positions[turn].posy + D, X, D);
                    $.post("/requestTile", {name: "move", rotations: "0"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = true;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = true;
                    const ntile = new Tile(positions[turn].posx - T, positions[turn].posy, true, true, true, true);
                    flo.push(ntile);
                  } else if (responseObject.newtile.availableDoors.length == 3) {
                    ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy, D, X);
                    ctx.strokeRect(positions[turn].posx - X, positions[turn].posy + D, X, D);
                    ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy + T - X, D, X);
                    rotation.disabled = false;
                    placet.disabled = false;
                    rot = 0;
                    avdoor = 3;
                    tempdir = 3;
                    rottile = new Tile(positions[turn].posx - T, positions[turn].posy, true, true, true, false);
                    positions[turn].north = true;
                    positions[turn].east = true;
                    positions[turn].south = true;
                    positions[turn].west = false;
                  } else if (responseObject.newtile.availableDoors.length == 2) {
                    if ((responseObject.newtile.availableDoors.indexOf("NORTH") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("SOUTH") != -1) ||
                      (responseObject.newtile.availableDoors.indexOf("EAST") != -1 &&
                      responseObject.newtile.availableDoors.indexOf("WEST") != -1)) {
                      ctx.strokeRect(positions[turn].posx - X, positions[turn].posy + D, X, D);
                      ctx.strokeRect(positions[turn].posx - T, positions[turn].posy + D, X, D);
                      $.post("/requestTile", {name: "move", rotations: "1"}, rj2 => {
                        const ro = JSON.parse(rj2);
                        receiveTile(ro);
                      });
                      positions[turn].north = false;
                      positions[turn].east = true;
                      positions[turn].south = false;
                      positions[turn].west = true;    
                    } else {
                      ctx.strokeRect(positions[turn].posx - T + D, positions[turn].posy, D, X);
                      ctx.strokeRect(positions[turn].posx - X, positions[turn].posy + D, X, D);
                      rotation.disabled = false;
                      placet.disabled = false;
                      rot = 0;
                      avdoor = 2;
                      tempdir = 3;
                      rottile = new Tile(positions[turn].posx - T, positions[turn].posy, true, true, false, false);
                      positions[turn].north = true;
                      positions[turn].east = true;
                      positions[turn].south = false;
                      positions[turn].west = false;
                    }
                  } else if (responseObject.newtile.availableDoors.length == 1) {
                    ctx.strokeRect(positions[turn].posx - X, positions[turn].posy + D, X, D);
                    $.post("/requestTile", {name: "move", rotations: "1"}, rj2 => {
                      const ro = JSON.parse(rj2);
                      receiveTile(ro);
                    });
                    positions[turn].north = false;
                    positions[turn].east = true;
                    positions[turn].south = false;
                    positions[turn].west = false;
                    const ntile = new Tile(positions[turn].posx - T, positions[turn].posy, false, true, false, false);
                    flo.push(ntile);
                  }
 
                  ctx.font = "17px Times New Roman";
                  ctx.fillText(responseObject.newtile.name, positions[turn].posx - T + textOff.posx,
                    positions[turn].posy + textOff.posy);
                  console.log(responseObject.newtile.name);
                  ctx.font = "25px Times New Roman";
                  if (responseObject.newtile.eventCount > 0)
                    ctx.fillText("E", positions[turn].posx - T + symbOff.posx, positions[turn].posy + symbOff.posy);
                  else if (responseObject.newtile.itemCount > 0)
                    ctx.fillText("I", positions[turn].posx - T + symbOff.posx + 6, positions[turn].posy + symbOff.posy);
                  else if (responseObject.newtile.omenCount > 0)
                    ctx.fillText("O", positions[turn].posx - T + symbOff.posx - 2, positions[turn].posy + symbOff.posy);

                  positions[turn].posx = positions[turn].posx - T;
                  moves--;
                  movesp.innerHTML = moves;
                  const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
                  const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
                  lev.style.top = ypos + 'px';
                  lev.style.left = xpos + 'px';
                });

            } else {
              const postParameters = {name: "move", direction: "WEST"};
              $.post("/requestTile", postParameters, responseJSON => {
                const responseObject = JSON.parse(responseJSON);
                console.log(responseObject);
              });
              positions[turn].north = flo[temp].north;
              positions[turn].east = flo[temp].east;
              positions[turn].south = flo[temp].south;
              positions[turn].west = flo[temp].west;
              positions[turn].posx = positions[turn].posx - T;
              moves--;
              movesp.innerHTML = moves;
              const xpos = offx - (positions[turn].posx - 600) + edgex[positions[turn].floor];
              const ypos = offy - (positions[turn].posy - 600) + edgey[positions[turn].floor];
              lev.style.top = ypos + 'px';
              lev.style.left = xpos + 'px';
            }
          }
        }
      }
    });
  });
  