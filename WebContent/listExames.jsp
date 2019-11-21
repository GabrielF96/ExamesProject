<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
* {
    margin: 0;
    padding: 0;
    font-family: "Helvetica", "Arial";
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
	margin-top: 12px;
}

#logo a{
	color: white;
	text-decoration: none;
	text-shadow: 1px 1px 1px black;
	padding: 18px;
	font-weight: bold;
	font-size:40px;	
}

.buttonSide{
	float: right
}

</style>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    
<title>Exames</title>
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
	  
	<table>
		<thead>
			<tr>
				<th>Data do Exame</th>
				<th>Nome do Paciente</th>
				<th>Nome do Médico</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<s:iterator value='listaExames'>
				<tr>
					<td><s:property value="dt_Exame"/></td>
					<td><s:property value="nm_Paciente"/></td>
					<td><s:property value="nm_Medico"/></td>
					<td class="buttonSide"><s:url var="editarUrl" action="editarExame">
							<s:param name="id" value="id_Exame"></s:param>
						</s:url>
						<s:a href="%{editarUrl}" class="waves-effect waves-light btn"><i class="material-icons left"></i>EDITAR</s:a>
					</td>
					<td class="buttonSide">
						<s:url var="removerUrl" action="removerExame">
							<s:param name="id" value="id_Exame" />
						</s:url>
						<s:a href="%{removerUrl}" class="waves-effect waves-light btn"><i class="material-icons center">delete</i></s:a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>