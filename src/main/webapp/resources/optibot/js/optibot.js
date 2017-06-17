/**
 * Created by imgyucheol on 2017. 6. 11..
 */

$(function() {
	$('#send-query').click(function() {
		var chatul = $('#optimalchat');
		var query = $('#query-text').val();
		if (query === "") {
			return;
		}
		drawQuery(query);
		requestQuery(query);
		chatul.scrollTop(chatul[0].scrollHeight);
	});
});

function requestQuery(query) {
	var tag = query.split(" ")[0];
	var url = "/optigram";
	query = query.substring(query.indexOf(" ")+1);
	var result;
	if (tag == "/v" || tag == "/ㅍ" || tag == "/영상") {
		url += "/optibot/video";
		result = requestServer(url, query);
		var videoUrl = 'https://www.youtube.com/embed/' + result;
		var text = '<iframe class="resultVideo" src="'+videoUrl+'" style="width:100%; height:auto" frameborder="0" allowfullscreen></iframe>';
		responseServer(text);
	} else if (tag == "/f" || tag == "/ㄹ" || tag == "/음식") {
		url += "/optibot/food";
		result = requestServer(url, query);
		var obj= JSON.parse(result);
		var text = "";
		for(var i=0; i<obj.food.length; i++){
			for(var key in obj.food[i]){
				if(key == 'imgUrl'){
					text+= '<img src="' + obj.food[i][key] +'"><br/>'; 
				}else if(key == 'url'){
					text += '<a href="' + obj.food[i][key] +'" target="_blank">' + obj.food[i][key] + '</a><br/>';
				}else{
					text+= key + " : " + obj.food[i][key]+"<br/>";
				}
			}
			text+="<hr>";
		}
		responseServer(text);
	} else if (tag =="/w" || tag == "/ㅈ" || tag == "/날씨") {
		url += "/optibot/weather";
		query = query.includes("날씨") ? query : query + "+날씨";
		result = requestServer(url, query);
		var obj= JSON.parse(result);
		var text = "";
		for(var i=0; i<obj.weather.length; i++){
			for(var key in obj.weather[i]){
				text+= key + " : " + obj.weather[i][key]+"<br/>";
			}
			text+="<hr>";
		}
		responseServer(text);
	}
}

function requestServer(url, query){
	$.ajax({
		type : "GET",
		url : url,
		data : {
			"query" : query
		},
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		async : false,
		success : function(data) {
			result = data;
		}
	});
	return result;
}

function responseServer(text){
	$('#optimalchat').append('<li class="server-res"></li>');
	$('.server-res').last().append(text);
}

function drawQuery(query) {
	$('#optimalchat').append('<li class="client-req">' + query + '</li>');
	/*
	 * var viewFrame = document.getElementById('optimalchat');
	 * viewFrame.innerHTML += '<li class="client-req">' + query + '</li>';
	 */
}

/*function drawVideoFrame(key) {
	// var viewFrame = document.getElementById('optimalchat');
	// console.log(key);
	var videoUrl = 'https://www.youtube.com/embed/' + key;
	$('#optimalchat')
			.append(
					'<li class="server-res"><iframe class="resultVideo" src="" style="width:100%; height:auto" frameborder="0" allowfullscreen></iframe></li>');
	$('.resultVideo').last().attr('src', videoUrl);
}*/