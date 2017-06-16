/**
 * 
 */
var answerField;
var size;
var mindNum;
var leftMind;
//Connect device check
var filter = "win16|win32|win64|mac"; 
var device;


function setMap(){
	//=================Connect device check=================//
	if(navigator.platform){
		if(0 > filter.indexOf(navigator.platform.toLowerCase())){
			device='mobile';
		}else{
			device = 'pc';
		}
	}
	//=====================================================//
	size = Number(document.getElementById("size").value.split('x')[0]);
	var fmMap = setMindLocation(size);
	var mindCount = 0;
	var row = 0;
	var col = 0;
	leftMind = size*size-mindNum;
	
	for (var point = 0; point < size * size; point++) {
		row = point % size;
		col = Math.floor(point / size);
		for (var i = row-1; i <= row+1; i++) {
			for (var j = col-1; j <= col+1; j++) {
				
				if ((i == row && j == col) || i < 0 || j < 0 || i == size || j == size){
					continue;
				}else {
					if (fmMap[i][j] == 9) mindCount++;
				}
			}
		}
		if (fmMap[row][col] != 9) fmMap[row][col] = mindCount;
		mindCount = 0;
	}
	answerField = fmMap;
	drawField(fmMap,size);
}

function setMindLocation(size){
	var level = document.getElementById("level").value;

	switch(level){
		case 'beinner':
			mindNum = Math.round(size*size*0.1);
			break;
		case 'intermediate':
			mindNum = Math.round(size*size*0.2);
			break;
		case 'advanced':
			mindNum = Math.round(size*size*0.3);
			break;
	}
	
	var mindLocation = [];
	var field = new Array(size);
	for(var i=0; i<size; i++){
		field[i] = new Array(size);
		for(var j=0; j<size; j++){
			field[i][j] = 0;
		}
	}
	for (var i = 0; i < mindNum; i++) {
		mindLocation.push(Math.round((Math.random() * size * size)));
		if(mindLocation[i] == (size*size)){
			mindLocation.pop();
			i--;
		}else{
			for (var j = 0; j < i; j++) {
				if (mindLocation[i] == mindLocation[j]){
					mindLocation.pop();
					i--;
				}
			}
			field[(mindLocation[i] % size)][Math.floor(mindLocation[i] / size)] = 9;
		}
	}
	return field;
}

function drawField(field,size){
	var map='<table>';
	var id;
	for(var i=0; i<size; i++){
		map += '<tr>'
		for(var j=0; j<size; j++){
			id = i+'/'+j;
			map += '<td id ="btn';
			map += id;
			map += '">';
			map += '<button type="button" onmousedown="holdCheck(id)" onmouseup="mouseCheck(id)" id =';
			map += id;
			map += '>&nbsp</button></td>';
		}
		map += '</tr>'
	}
	map += '</table>';
	document.getElementById("field").innerHTML = map;
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
	leftMind--;
	
	document.getElementById("mindCount").innerHTML = leftMind;
}

function flagField(id){
	var data='';
	var tabId = 'btn'+id;
	
	data += '<img src="flag.png" onmousedown="holdCheck(id)" onmouseup="mouseCheck(id)" class ="flag" id =';
	data += id;
	data += '>';
	document.getElementById(tabId).innerHTML = data;
	
}

function blankField(id){
	
	var data='';
	var tabId = 'btn'+id;
	data += '<button type="button" onmousedown="holdCheck(id)" onmouseup="mouseCheck(id)" id =';
	data += id;
	data += '>&nbsp</button>';
	document.getElementById(tabId).innerHTML = data;
}

function answer(){
	var ans='<table>';
	for(var i=0; i<size; i++){
		ans += '<tr>'
		for(var j=0; j<size; j++){
			if(answerField[i][j] == 9){
				ans += '<td><img src="mine2.png">';
			}else{
				ans += '<td><button type="button" style="background: rgb(225, 225, 225); border: none; color:red">';
				ans += answerField[i][j];
			}
			ans += '</td>';
		}
		ans += '</tr>';
	}
	document.getElementById("field").innerHTML = ans;
}