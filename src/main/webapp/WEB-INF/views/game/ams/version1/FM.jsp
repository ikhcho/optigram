<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find Mind</title>
<script type="text/javascript" src="MindMap.js"></script>
<script type="text/javascript" src="Event.js"></script>

<style>
button {
	background: #ffffff;
    border: none;
    color: black;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 20px;
    width: 50px;
	height: 50px;
}

button:disabled {
	background: rgb(225, 225, 225);
    color: black;
	border: none;
	width: 50px;
	height: 50px;
}

table, tr, td {
    border: 2px solid gray;
    border-collapse: collapse;
}

</style>


</head>

<body oncontextmenu='return false'>
<br/>
<div align="center">
	<table>
		<tr>
			<td>
				필드크기
			</td>
			<td>
				<select id="size">
				    <option selected>5x5</option>
				    <option>10x10</option>
				    <option>15x15</option>
				</select>
				
			</td>
			<td>
				<select id="level">
				    <option selected value="beinner">초급</option>
				    <option value="intermediate">중급</option>
				    <option value="advanced">고급</option>
				</select>
				<button onclick="setMap()">OK</button>
			</td>
		</tr>
	</table>

</div>



<br/>
<div align="center" id="field">

</div>
<div align="center" id="mindCount">

</div>
</body>
</html>