<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.ResultSet"%>
<%@ page import = "java.sql.SQLException"%>
<%@ page import = "java.sql.PreparedStatement" %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
	if(request.getParameter("id") != null){
		String id = request.getParameter("id");
		String map = request.getParameter("map");
		String select_level = request.getParameter("select_level");
		int clear_time = Integer.parseInt(request.getParameter("clear_time"));
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "insert into minesweeper(id, map, select_level, clear_time, reg_date) values(?,?,?,?,sysdate)";
		
		try {
			conn = DriverManager.getConnection(url, "bit", "bit");
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, map);
			ps.setString(3, select_level);
			ps.setInt(4, clear_time);
		
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
%>
</head>
<body>
<%if(request.getParameter("id") == null){ %>
	<form action="game/ams/version2/SaveData.jsp" method="post">
		이름을 입력해주세요.<input type="text" name = "id">
		<input type="submit" value="등록">
		<input type="hidden" name="map" value="<%=request.getParameter("map") %>">
		<input type="hidden" name="select_level" value="<%=request.getParameter("select_level") %>">
		<input type="hidden" name="clear_time" value="<%=request.getParameter("clear_time") %>">
	</form>
<%}else{%>
	<div><h1>저장됐습니다.</h1></div>

<%} %>

</body>
</html>