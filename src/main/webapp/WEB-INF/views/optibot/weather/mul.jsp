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
<table>
<c:choose>
	<c:when  test="${ type == 2}">
		<c:forEach var="i" begin="0" end="${size-1 }">
			<tr><td colspan="2">${wwv.getLocation().get(i)}</td></tr>
			<tr><td>날씨</td><td>${wwv.getWeather().get(i)}</td></tr>
			<c:if test="${wwv.getTemperature2().isEmpty()}">
			<tr><td>온도</td><td>${wwv.getTemperature().get(i)}℃</td></tr>
			<tr><td>강수확률</td><td>${wwv.getRainfall().get(i)}%</td></tr>
			</c:if>
			<c:if test="${wvo.getRainfall().isEmpty()}">
			<tr><td>최저온도</td><td>${wwv.getTemperature().get(i)}℃</td></tr>
			<tr><td>최고온도</td><td>${wwv.getTemperature2().get(i)}℃</td></tr>
			</c:if>
		</c:forEach>
	</c:when>
	
	<c:when  test="${ type == 3}">
		<tr><c:forEach var="i" begin="0" end="4"><td colspan="2">${wwv.getLocation().get(i)}</td></c:forEach></tr>
		<tr><c:forEach var="i" begin="0" end="4"><td>날씨</td><td>${wwv.getWeather().get(i)}</td></c:forEach></tr>
		<tr><c:forEach var="i" begin="0" end="4"><td>온도</td><td>${wwv.getTemperature().get(i)}℃c</td></c:forEach></tr>
		<tr><c:forEach var="i" begin="0" end="4"><td>강수확률</td><td>${wwv.getRainfall().get(i)}%</td></c:forEach></tr>
		<tr><td colspan="10">&nbsp;</td></tr>
		<tr><c:forEach var="i" begin="5" end="9"><td colspan="2">${wwv.getLocation().get(i)}</td></c:forEach></tr>
		<tr><c:forEach var="i" begin="5" end="9"><td>날씨</td><td>${wwv.getWeather().get(i)}</td></c:forEach></tr>
		<tr><c:forEach var="i" begin="0" end="4"><td>최저온도</td><td>${wwv.getTemperature().get(i)}℃</td></c:forEach></tr>
		<tr><c:forEach var="i" begin="0" end="4"><td>최고온도</td><td>${wwv.getRainfall().get(i)}%</td></c:forEach></tr>
	</c:when>
	<c:otherwise>
		<tr><td>지역</td><td>날씨</td><td>온도</td></tr>
		<c:forEach var="i" begin="0" end="${size-1}">
		<tr>
			<td>${wwv.getLocation().get(i)}</td>
			<td>${wwv.getWeather().get(i)}</td>
			<td>${wwv.getTemperature().get(i)}℃c</td>
		</tr>
		</c:forEach>
		${text}
	</c:otherwise>
</c:choose 	>
</table>

</body>
</html>