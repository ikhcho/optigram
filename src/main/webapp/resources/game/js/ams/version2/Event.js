/**
 * 
 */

var timer;
var istrue = false;
var delay = 500; // how much long u have to hold click in MS
var playTime=0;
var playing=false;
var interval;
function startPlayTimer(){
	if(playing == true){
		interval = setInterval(function(){
			playTime +=1;
			if(playTime<=60){
				document.getElementById("timerset").innerHTML = playTime;
			}else{
				var min = Math.floor(playTime/ 60);
				var sec = playTime - (min*60);
				if(min<=60){
					document.getElementById("timerset").innerHTML = min + '`'+sec;
				}else{
					var hour = Math.floor(playTime / 3600);
					min = Math.floor( (playTime-(hour*3600)) / 60 );
					sec = playTime - (hour*3600) - (min*60);
					document.getElementById("timerset").innerHTML = hour + '``' + min + '`' + sec;
				}
			}
			
		}, 1000);
	}
}

//mousedown for mobile
function holdCheck(id)
{
	if(device == 'mobile'){
		istrue = true;
		timer = setTimeout(function(){ 
			if(timer){
				clearTimeout(timer);
			}
			if(istrue){
				checkFlag(id);
			}
		},delay);
	}
}

//mousedbclick
function quickCheck(id)
{
	var perfect = true;
	var row = Number(id.split('/')[0]);
	var col = Number(id.split('/')[1]);
	var flagCount=0;
	//perfect check
	for(var i=(row-1); i<=(row+1); i++){
		for(var j = (col-1); j<=(col+1); j++){
			if (i < 0 || j < 0 || i >= size || j >= size){
				continue;
			}else{
				btnId = i+'/'+j;
				if(document.getElementById(btnId).getAttribute("class") =='flag'){
					flagCount++;
				}
				if(answerField[i][j] == 9 && document.getElementById(btnId).getAttribute("class") !='flag'){
					perfect = false;
				}
			}
		}
	}
	if(flagCount == answerField[row][col]){
		//confirm
		if(perfect){
			sweeper++; //중복
			correctCount++; //중복
			nonMine(row,col);
		}else{
			answer(false);
		}
	}
}

//mouseup
function mouseCheck(id){
	
	if(playing == false){
		playing = true;
		startPlayTimer();
		
	}
	
	istrue =false;
	var timer;
	var btn = event.button;
	if(btn == 2){
		checkFlag(id);
	}else{
		if(document.getElementById(id).getAttribute("class")=='flag'){
			function prevent(event){
				 event.preventDefault()
			};
		}else{
			checkMine(id);
		}
	}
}

function checkFlag(id){
	
	if(document.getElementById(id).getAttribute("class")=='flag'){
		blankField(id);
	}else{
		flagField(id);
	}
	endCheck();
}

function checkMine(id){
	var row = Number(id.split('/')[0]);
	var col = Number(id.split('/')[1]);
	
	switch(answerField[row][col]){
		case 0:
			nonMine(row,col);
			break;
		case 9:
			answer(false);
			break;
		default :
			numberField(id);
	}
	endCheck();
}

function nonMine(row, col){
	var btnId = row + '/' + col;
	document.getElementById(btnId).disabled='disabled';
	sweeper--;
	correctCount--;
	for (var i = (row - 1); i <= (row + 1); i++) {
		for (var j = (col - 1); j <= (col + 1); j++) {
			btnId = i+'/'+j;
			if ((i == row && j == col) || i < 0 || j < 0 || i >= size || j >= size || answerField[i][j] == 10){
				continue;
			}else{
				if(answerField[i][j] == 0 && document.getElementById(btnId).disabled == false){
					nonMine(i,j);
				}else if(answerField[i][j] != 0 && answerField[i][j] != 9 && document.getElementById(btnId).getAttribute("class") !='confirm'){
					numberField(btnId);
				}
			}
		}
	}
	document.getElementById("leftSweeper").innerHTML = sweeper;
	document.getElementById("leftMine").innerHTML = leftMine;
	endCheck();
}

function endCheck(){
	if(correctCount == 0){
		save();
		answer(true);
	}
}

function reGame(){
	var re = confirm('다시 하시겠습니까?');
	if(re){
		playGame();
	}
}
function save() {
	var popWidth  = '400'; // 파업사이즈 너비
	var popHeight = '200'; // 팝업사이즈 높이
	var winWidth  = document.body.clientWidth;  // 현재창의 너비
	var winHeight = document.body.clientHeight; // 현재창의 높이
	var winX      = window.screenX || window.screenLeft || 0;// 현재창의 x좌표
	var winY      = window.screenY || window.screenTop || 0; // 현재창의 y좌표
	w = winX + (winWidth - popWidth) / 2;
	h = winY + (winHeight - popHeight) / 2;
	window.open("/optigram/game/ams/version2/SaveData?map="+shape+"&select_level="+level+"&clear_time="+playTime, "기록저장", "width="+popWidth + " height="+popHeight +" top="+h+" left="+w);
}