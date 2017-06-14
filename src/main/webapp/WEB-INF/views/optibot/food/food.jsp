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
<h1>검색어 : ${param.query}</h1>
<c:forEach items="${flist}" var = "food">
	${food.toString()}
</c:forEach>

</body>
</html>