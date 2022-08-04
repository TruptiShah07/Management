<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teachers</title>
<link rel="shortcut icon" href="#" />
<style>
		html, body{
	 
			padding:0px; 
			font-family:Verdana, Arial, Helvetica, sans-serif;
			margin-left: 103px; /* Same as the width of the sidenav */
		}
		table {   
			border-collapse:collapse;
			border:1px solid gray;
			font-family: Tahoma,Verdana,Segoe,sans-serif;
			width:72%;
		 
		}
		th {
			border-bottom:1px solid gray;
			background:none repeat scroll 0 0 #2e872d;
			padding:10px;
			color: #FFFFFF;
		}
		tr {
			border-top:1px solid gray;
			text-align:center;	
		}
		 
		tr:nth-child(even) {background: #FFFFFF}
		tr:nth-child(odd) {background: #BBBBBB}	
		 
		#wrapper {width: 100%; text-align: center; }
		#header {width: 72%; background: #2e872d; margin-top: 0px; padding:5px 0px 15px 0px;}
		#header h3 {width: 100%; margin:auto; color: #FFFFFF;}
		#container {width: 100%; margin:auto}
		#container h3 {color: #000;}
		#container #content {margin-top: 20px;}
		
		.sidenav  {
		  height: 100%;
		  width: 200px;
		  border-color: #FFFFFF;
		  position: fixed;
		  z-index: 1;
		  top: 0;
		  left: 0;
		  background-color: #81A594;
		  overflow-x: hidden;
		  padding-top: 20px;
		}
		
		.sidenav a {
		  padding: 6px 6px 6px 32px;
		  text-decoration: none;
		  font-size: 25px;
		  color: white;
		  display: block;
		}
		
		.sidenav a:hover {
		  color: blue;
		}
		
		@media screen and (max-height: 450px) {
		  .sidenav {padding-top: 15px;}
		  .sidenav a {font-size: 18px;}
		}
		
		#page{
		 
		  height: 100%;
		  
			
		}
		
		#logo{
			font-family: 'Trebuchet MS', sans-serif;
			text-align: center;
			color: white;
			
		}
		.bar-item{
			border-color: #FFFFFF;
			border-width: 3px;
			border-bottom: .5px solid rgba(255, 255, 255, 0.247);
		}
	</style>
</head>
<body>
	<div id="page">
		<jsp:include page="leftPannel.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Subjects</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>Name</th>
					</tr>
					<c:forEach var="tempSubject" items="${SUBJECTS_LIST}">
						<tr>
							<td>${tempSubject.subjectName}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>