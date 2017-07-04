<%--
  Created by IntelliJ IDEA.
  User: imgyucheol
  Date: 2017. 6. 11.
  Time: 오후 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chat</title>
    <link href="resources/optibot/css/optibot.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    
</head>
<body>
<!-- Power mode -->
  	
	<div id="container">
	    <div id="header"><span>OPTIBOT!</span></div>
	    <ui id="optimalchat">
	    	<li class="client-req">/?</li>
	     	<li class="server-res">
	     	영상검색 : /v or /ㅍ or /영상<br/>
	     	음식검색 : /f or /ㄹ or /음식<br/>
	     	날씨검색 : /w or /ㅈ or /날씨</li>
	        <li class="client-req">/v swift side 2.0</li>
	        <li class="server-res">
	            <iframe id="videoframe" src="https://www.youtube.com/embed/EWDNScxZ0YU" style="width:100%; height:auto"
	                    frameborder="0" allowfullscreen></iframe>
	        </li>
	    </ui>
	    <div id="user-input">
	        <input id="query-text" type="text" style="width:80%">
	        <button id="send-query" style="float:left; width:20%;">전송</button>
	    </div>
	    <%--<button id="addli"> 버 튼 </button>--%>
	</div>
	<script src="resources/optibot/js/activate-power-mode.js"></script>
  	<script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="resources/optibot/js/optibot.js"/></script>
	
</body>
</html>
