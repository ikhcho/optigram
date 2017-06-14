<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.project.optigram.optibot.weather.WeatherService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<style>
table{
	border : 2px solid black;
}
td :first{
	border-bottom: double;
}
</style>
</head>
<body>
<h1>검색어 : ${param.input}</h1>
<c:if test="${type == 1 }">
<table>
<tr><td>기온</td><td>${wvo.getTemperature()}℃</td></tr>
<tr><td>날씨</td><td>${wvo.getWeather()}</td></tr>
<tr><td>강수확률</td><td>${wvo.getRainfall()}%</td></tr>
<tr><td>미세먼지</td><td>${wvo.getDust()}</td></tr>
<tr><td>오 존</td><td>${wvo.getOzone()}</td></tr>
</table>
</c:if>
${text}
</body>
</html>