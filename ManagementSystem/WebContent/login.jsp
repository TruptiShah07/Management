<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="shortcut icon" href="#" />
<style>
Body {  
	font-family: Calibri, Helvetica, sans-serif;  
	background-color: powerblue;  
}  
button {   
	justify-content: center;
    background-color: #4c6daf;   
    width: 70%;  
    color: white;   
    padding: 15px;   
    margin: 8px 0px;   
    border: none;   
    cursor: pointer;   
}  
          
form {   
    border: 1.1px solid black;
	width: 45%;
	margin: 0 auto;
}   
input[type=text], input[type=password] {  
 	justify-content: center;  
    width: 70%;   
    margin: 8px 0;  
    padding: 12px 20px;   
    display: inline-block;   
    border: 2px solid green;   
    box-sizing: border-box;   
}  
button:hover {   
   	opacity: 0.5;   
}   
     
.container {   
  		  
  	justify-content: center;
    padding: 40px;   
    background-color: #FFF8DC;  
}   
</style>
<link> 
</head>
<body>
    <form action="AdminControllerServlet" method="POST">  
        <div class="container"> 
        	<center><h1> Login </h1></center>
        	<input type="hidden" name="command" value="LOGIN" />
            <label>UserName : </label>   
            <br/>
            <input type="text" placeholder="Enter Username" name="username" required>  
            <br/>
            <label>Password : </label>   
            <br/>
            <input type="password" placeholder="Enter Password" name="password" required>  
            <br/>
            <button type="submit">Login</button>   
            <br/>             
        </div>   
    </form>     


</body>

</html>