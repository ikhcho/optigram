/**
 * 
 */
var answerField; // size*size 정답 배열
var size; // Level 에따라 구별되는 맵 크기
var mineNum; // 폭탄개수
var shape; // 필드 모양
var level; // 난이도
var sweeper; // 확인 가능한 칸의 개수
var correctCount; // 맞춘 정답 개수
var leftMine; // 남은 폭탄 개수
//Connect device check
var filter = "win16|win32|win64|mac"; // 접속 기종 모델
var device; // 접속 기종

function playGame(){
	init();
	setMineLocation();
	setMap();
	drawField();
	drawRank();
}

function init(){
	//Connect device check
	if(navigator.platform){
		if(0 > filter.indexOf(navigator.platform.toLowerCase())){
			device='mobile';
		}else{
			device = 'pc';
		}
	}
	
	shape = document.getElementById("shape").value;
	level = document.getElementById("level").value;
	if(level == 'beginner'){
		size =13;
		defaultField();
		mineNum = Math.round(sweeper*0.1);
	}else if(level == 'intermediate'){
		size =15;
		defaultField();
		mineNum = Math.round(sweeper*0.15);
	}else{
		size =17;
		defaultField();
		mineNum = Math.round(sweeper*0.2);
	}
	playTime=0;
	playing=false;
	clearInterval(interval);
}

function setMap(){
	var mineCount = 0;
	var row = 0;
	var col = 0;
	
	for (var point = 0; point < size * size; point++) {
		row = point % size;
		col = Math.floor(point / size);
		for (var i = row-1; i <= row+1; i++) {
			for (var j = col-1; j <= col+1; j++) {
				if ((i == row && j == col) || i < 0 || j < 0 || i == size || j == size){
					continue;
				}else {
					if (answerField[i][j] == 9) mineCount++;
				}
			}
		}
		if (answerField[row][col] == 0) answerField[row][col] = mineCount;
		mineCount = 0;
	}
}

function setMineLocation(){
	leftMine = mineNum;
	correctCount = sweeper - leftMine;
	var mineLocation = [];
	
	for (var i = 0; i < mineNum; i++) {
		mineLocation.push(Math.round((Math.random() * size * size)));
		if(mineLocation[i] == (size*size)){ //invalid last field;
			mineLocation.pop();
			i--;
		}else{
			for (var j = 0; j < i; j++) {
				if (mineLocation[i] == mineLocation[j]){ // overlap check
					mineLocation.pop();
					i--;
				}
			}
			if(answerField[(mineLocation[i] % size)][Math.floor(mineLocation[i] / size)] == 10){
				mineLocation.pop();
				i--;
			}else{
				answerField[(mineLocation[i] % size)][Math.floor(mineLocation[i] / size)] = 9;
			}
		}
	}
}

function drawField(){
	var map='<table>';
	var id;
	for(var i=0; i<size; i++){
		map += '<tr>'
		for(var j=0; j<size; j++){
			id = i+'/'+j;
			map += '<td id ="btn';
			map += id;
			map += '">';
			if(answerField[i][j] == 10){
				map += '<button style="background:#000000" id =';
			}else{
				map += '<button onmousedown="holdCheck(id)" onmouseup="mouseCheck(id)" id =';
			}
			map += id;
			map += '>&nbsp</button></td>';
		}
		map += '</tr>'
	}
	map += '</table>';
	document.getElementById("field").innerHTML = map;	
	document.getElementById("leftSweeper").innerHTML = sweeper;
	document.getElementById("leftMine").innerHTML = leftMine;
}

function drawRank(){
	var data='<iframe src="ams/version2/Rank?map='+shape+'&select_level='+level +'" style="width:264px; height:500px"></iframe>';
	document.getElementById("rank").innerHTML = data;
}
function numberField(id){
	var row = Number(id.split('/')[0]);
	var col = Number(id.split('/')[1]);
	var data='';
	var tabId = 'btn'+id;
	
	data += '<button type="button" class="confirm" style="background: rgb(225, 225, 225)" ondblclick="quickCheck(id)" id =';
	data += id;
	data += '><b>';
	data += answerField[row][col];
	data += '</b></button>';
	document.getElementById(tabId).innerHTML = data;
	sweeper--;
	correctCount--;
	document.getElementById("leftSweeper").innerHTML = sweeper;
}

function flagField(id){
	var data='';
	var tabId = 'btn'+id;
	var row = Number(id.split('/')[0]);
	var col = Number(id.split('/')[1]);
	data += '<img src="/optigram/resources/gmae/imgs/ams/flag.png" onmousedown="holdCheck(id)" onmouseup="mouseCheck(id)" class ="flag" id =';
	data += id;
	data += '>';
	sweeper--;
	leftMine--;
	
	document.getElementById(tabId).innerHTML = data;
	document.getElementById("leftSweeper").innerHTML = sweeper;
	document.getElementById("leftMine").innerHTML = leftMine;
}

function blankField(id){
	var data='';
	var tabId = 'btn'+id;
	var row = Number(id.split('/')[0]);
	var col = Number(id.split('/')[1]);
	data += '<button type="button" onmousedown="holdCheck(id)" onmouseup="mouseCheck(id)" id =';
	data += id;
	data += '>&nbsp</button>';
	sweeper++;
	leftMine++;
	
	document.getElementById(tabId).innerHTML = data;
	document.getElementById("leftSweeper").innerHTML = sweeper;
	document.getElementById("leftMine").innerHTML = leftMine;
}

function answer(success){
	
	var ans='<table>';
	for(var i=0; i<size; i++){
		ans += '<tr>'
		for(var j=0; j<size; j++){
			var btnId = i + '/' + j;
			if(answerField[i][j] == 10){
				ans += '<td><button style="background:#000000"></button>';
			}else{
				if(answerField[i][j] == 9){
					ans += '<td><img src="/optigram/resources/game/imgs/ams/mine2.png"></td>';
				}else if(document.getElementById(btnId).disabled == true && document.getElementById(btnId).getAttribute("class") !='confirm'){
					ans += '<td><button type="button"style="background: rgb(225, 225, 225)">&nbsp</button></td>';
				}else if(document.getElementById(btnId).getAttribute("class") =='confirm'){
					ans += '<td><button type="button" style="background: rgb(225, 225, 225)">';
					ans += answerField[i][j];
					ans += '</button></td>';
				}else{
					ans += '<td><button type="button">&nbsp</button></td>';
				}
			}
		}
		ans += '</tr>';
	}
	document.getElementById("field").innerHTML = ans;
	playing=false;
	clearInterval(interval);
	if(success==false){
		setTimeout("reGame()",200);
	}
}