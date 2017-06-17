<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import= "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.ResultSet"%>
<%@ page import = "java.sql.SQLException"%>
<%@ page import = "java.sql.Statement" %>
<%
	String map = request.getParameter("map");
	String select_level = request.getParameter("select_level");
	String id="";
	int clear_time =0; 
	int rank=0;
	double hour = 0;
	double min = 0;
	double sec = 0;
	String time ="";
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String sql = "select * from (select * from minesweeper where map = '" + map + "' and select_level= '" + select_level+ "' order by clear_time) where rownum<=10";
		
	try {
		conn = DriverManager.getConnection(url, "bit", "bit");
		st = conn.createStatement();
		rs = st.executeQuery(sql);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
table,tr{
	border: 2px solid gray;
    border-collapse: collapse;
}
td{
	width:70px;
    text-align: center;
}
</style>
</head>
<body>
<div  style="width:250px">
<table>
<tr>
<td>순위</td>
<td>이름</td>
<td>시간</td>
</tr>
<div style="float:right">
<a href="Rank?map=<%=map %>&select_level=<%=select_level %>"><img src="/optigram/resources/game/ams/imgs/refresh.jpg"></a>
</div>
<%
	if(rs!=null){ 
		while(rs.next()){
			id = rs.getString("id");
			clear_time = rs.getInt("clear_time");
			rank++;
			hour = Math.floor(clear_time / 3600);
			min = Math.floor( (clear_time-(hour*3600)) / 60 );
			sec = (clear_time - (hour*3600) - (min*60));
			if(hour>=1){
				time = String.valueOf((int)hour) + "`` " +String.valueOf((int)min) +"` " + String.valueOf((int)sec); 
			}else if(min>=1){
				time = String.valueOf((int)min) +"` " + String.valueOf((int)sec); 
			}else{
				time = String.valueOf((int)sec); 
			}
			
	
%>
<tr>
<td><%=rank %></td>
<td><%=id %></td>
<td><%=time %></td>
</tr>
<%}} %>
</table>
</div>
<%	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(rs != null){
			rs.close();
		}
		if(st != null){
			st.close();
		}
		if(conn != null){
			conn.close();
		}
	}%>
</body>
</html>