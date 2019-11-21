<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
* {
    margin: 0;
    padding: 0;
    font-family: Helvetica, Arial;
}

header{
	background-color: gray;
	height: 80px;
}

#menu{
	float: right;
	margin-top: 30px;
}

#menu a{
	text-decoration: none;
	color: white;
	text-shadow: 1px 1px 1px black;
	padding: 30px;
	font-weight: bold;
}

#menu a:hover{
	background-color: black;
}

#logo{
	float: left;
	text-decoration: none;
	color: white;
	text-shadow: 1px 1px 1px black;
	padding: 18px;
	font-weight: bold;
	font-size:40px;	
}
</style>
<title>Home</title>
</head>
<body>
	<header>
		<div id="logo">
			<a>EXAMES</a>
		</div>
		<div id="menu">
	   		<s:url var="inserirUrl" action="formExame" />
	       	<s:a href="%{inserirUrl}">Inserir</s:a>
       		<s:url var="listarUrl" action="exames" />
       		<s:a href="%{listarUrl}">Listar</s:a>
		</div>
	</header>

</body>
</html>