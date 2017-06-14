/**
 * Created by imgyucheol on 2017. 6. 11..
 */

$(function () {

    // window.chatFlag = true;
    //
    // $('#addli').click(function () {
    //     if (flag) {
    //         var chatul = $('#optimalchat');
    //         chatul.append('<li class="client-req">ddd?</li>');
    //         chatul.scrollTop(chatul[0].scrollHeight);
    //         flag = false;
    //     } else {
    //         var chatul = $('#optimalchat');
    //         chatul.append('<li class="server-res">ddd!!</li>');
    //         chatul.scrollTop(chatul[0].scrollHeight);
    //         flag = true;
    //     }
    // });

    $('#send-query').click(function () {
        var chatul = $('#optimalchat');
        var query = $('#query-text').val();
        if (query === "") {
            return;
        }
        drawQuery(query);
        chatul.scrollTop(chatul[0].scrollHeight);

        var resultKey = "";
        $.ajax({
            type: "GET",
            url: "/optigram/video/search",
            data: {"query": query},
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            async: false,
            success: function (data) {
                resultKey = data;
                alert(resultKey);
            }
        });
        drawVideoFrame(resultKey);
        $('#query-text').val("");
        chatul.scrollTop(chatul[0].scrollHeight);
    });
});


function drawVideoFrame(key) {
    var viewFrame = document.getElementById('optimalchat');
    console.log(key);
    var videoUrl = 'https://www.youtube.com/embed/'+key;
    viewFrame.innerHTML += '<li class="server-res"><iframe class="resultVideo" src="" style="width:100%; height:auto" frameborder="0" allowfullscreen></iframe></li>';
    $('.resultVideo').last().attr('src', videoUrl);
}

function drawQuery(query) {
    var viewFrame = document.getElementById('optimalchat');
    viewFrame.innerHTML += '<li class="client-req">' + query + '</li>';
}