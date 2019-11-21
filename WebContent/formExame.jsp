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

.container{
	width: 960px;
	margin: 0 auto;
}

.campo{
	margin-bottom: 1em;
}

.campoCheck{
	margin-bottom: 1.8em;
}

.campoSelect{
    margin-bottom: 1em;
	padding:4px;
	width:200px;	
}

.campoText{
	padding: 5px;
	width: 400px;
}

.putLeft{
	min-height:200px;
	width:30%;
	float:left;
}

.putRight{
	min-height:200px;
	width:70%;
	float:right;
}

button {
    font-size: 1.5em;
    background: gray;
    border: 0;
    margin-bottom: 1em;
    color: white;
    padding: 0.2em 0.6em;
    box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
    text-shadow: 1px 1px 1px rgba(0,0,0,0.5);
    cursor: pointer;
}

.campoDiv {
    margin-bottom: 1em;
}

.campoDiv label {
    margin-bottom: 0.2em;
    color: black;
    display: block;
}

fieldset {
    border: 0;
}

.grupo:before, .grupo:after {
    content: " ";
    display: table;
}

.grupo:after, .grupo:before{
    clear: both;
}

fieldset.grupo .campoDiv {
    float:  left;
    margin-right: 1em;
}
</style>

<script>
function valida_form (){
	if(document.getElementById("dt_Exame")=="" || document.getElementById("dt_Exame")==null){
		alert('Por favor, preencha o campo data');
		document.getElementById("dt_Exame").focus();
		return false;
	}
}
</script>

<title>Novo Exame</title>
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
		
	<div class="container">	
		<form id="form" action="inserirExame" method="post" onsubmit="return valida_form(this)">
			<s:hidden name="id_Exame" /><br>
			
			<fieldset class="grupo">
				<div class="campoDiv">
					<s:select name="id_Medico" list="listaMedicos" 
					listKey="id_Medico" listValue="nm_Medico" headerKey="" headerValue="Selecione" label="Nome do Médico" style="height:35px; width:350px" />
				</div>
				<div class="campoDiv">
					<s:select name="id_Paciente" list="listaPacientes" 
					listKey="id_Paciente" listValue="nm_Paciente" headerKey="" headerValue="Selecione" label="Nome do Paciente" style="height:35px; width:350px"/><br>
				</div>
			</fieldset>
			
			<fieldset class="grupo">
				<div class="campoDiv">
					<label for="dt_Exame">Data do Exame:</label>
					<input class="campo" type="date" name="dt_Exame" style="height:20px; padding:4px; width:340px;" required/>
				</div>	
				<div class="campoDiv">
					<label for="tp_Sanguineo">Tipo Sanguíneo:</label>
					<input class="campo" type="text" name="tp_Sanguineo" placeholder="Ex.: (A+, A-, O+)" style="height:20px; padding:4px; width:340px;"/>
				</div>
			</fieldset>
			
			<h3 class="campo">Doenças que já teve ou tem</h3>
			<div class="putLeft">
				<input class="campoCheck" type="checkbox" name="reumatismo" value="true"/>
				<label for="reumatismo">Reumatismo</label><br>
				
				<input class="campoCheck" type="checkbox" name="doenca_cardiaca" value="true"/>
				<label for="doenca_cardiaca">Doença Cardíaca</label><br>
				
				<input class="campoCheck" type="checkbox" name="pressao_alta" value="true"/>
				<label for="pressao_alta">Pressão Alta</label><br>
				
				<input class="campoCheck" type="checkbox" name="diabetes" value="true"/>
				<label for="diabetes">Diabetes</label><br>
				
				<input class="campoCheck" type="checkbox" name="doenca_mental" value="true"/>
				<label for="pressao_alta">Doença Mental</label><br>
				
				<input class="campoCheck" type="checkbox" name="epilepsia" value="true"/>
				<label for="epilepsia">Epilepsia</label><br>
				
				<input class="campoCheck" type="checkbox" name="hernia" value="true"/>
				<label for="hernia">Hérnia</label><br>
			</div>
			
			<div class="putRight">
				<div class="campoDiv">
					<label for="cancer">Câncer:</label>
					<input class="campoText" type="text" name="cancer" placeholder="Se sim, escreva o tipo do câncer" />
				</div>
				<div class="campoDiv">
					<label for="alergias">Alergias:</label>
					<input class="campoText" type="text" name="alergias" placeholder="Se sim, alergia a que?" />
				</div>
				<div class="campoDiv">
					<label for="outras_doencas">Outras Doenças:</label>
					<input class="campoText" type="text" name="outras_doencas" placeholder="Escreva doenças não citadas, separando por vírgula" />
				</div>
				<div class="campoDiv">
					<label for="medicamentos">Medicamentos:</label>
					<input class="campoText" type="text" name="medicamentos" placeholder="Quais medicamentos você toma?" />
				</div>
			</div>
			
			<div class="grupo">
				<div class="campoDiv">
					<label for="doencas_familiares" style="margin-bottom:11px"><h3>Quais doenças já aconteceram na sua família?</h3></label>
					<textarea name="doencas_familiares" placeholder="Escreva as doenças separando por vírgulas" rows="5" cols="90" style="font-size:100%"></textarea>
				</div>
			</div>
			<br>
			<button type="submit" name="btnCadastrar" value="cadastrar">Cadastrar</button>
		</form>	
	</div>	
</body>
</html>