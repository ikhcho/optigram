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
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="<c:url value="/resources/optibot/js/optibot.js"/>"></script>
    <link href="<c:url value="/resources/optibot/css/optibot.css"/> " rel="stylesheet">
    <meta name="viewport" content="width=device-width, user-scalable=no">
</head>
<body>

<div id="container">
    <div id="header"><span>Optimal Search 뭐!? </span></div>
    <ui id="optimalchat">
        <li class="client-req">/v swift side 2.0</li>
        <li class="server-res">
            <iframe id="videoframe" src="https://www.youtube.com/embed/EWDNScxZ0YU" style="width:100%; height:auto"
                    frameborder="0" allowfullscreen></iframe>
        </li>
    </ui>
    <div id="user-input">
        <input id="query-text" type="text">
        <button id="send-query"> 전송 </button>
    </div>
    <%--<button id="addli"> 버 튼 </button>--%>
</div>
</body>
</html>
