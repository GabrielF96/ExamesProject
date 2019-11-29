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

</script>
<title>Editar Exame</title>
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
		<form action="inserirExame" method="post">
			<s:hidden name="exame.id" /><br>
			
			<fieldset class="grupo">
				<div class="campoDiv">
					<s:select name="exame.id_Medico" list="listaMedicos" listKey="id_Medico" listValue="nm_Medico" 
				 	label="Nome do Médico" style="height:35px; width:350px"/>
				</div>
				<div class="campoDiv">
					<s:select name="exame.id_Paciente" list="listaPacientes" listKey="id_Paciente" listValue="nm_Paciente" 
					headerKey="" headerValue="" label="Nome do Paciente" style="height:35px; width:350px"/>
				</div>
			</fieldset>
			<fieldset class="grupo">
				<div class="campoDiv">
					<label for="exame.dt_Exame">Data do Exame:</label>		
					<s:textfield name="exame.dt_Exame" style="height:20px; padding:4px; width:340px;"/>
				</div>
				<div class="campoDiv">
					<label for="exame.tp_Sanguineo">Tipo Sanguíneo:</label>
					<s:textfield name="exame.tp_Sanguineo" placeholder="Ex.: (A+, A-, O+)" style="height:20px; padding:4px; width:340px;"/>
				</div>
			</fieldset>
					
			<h3 class="campo">Doenças que já teve ou tem</h3>
			<div class="putLeft">
				<s:checkbox class="campoCheck" name="exame.reumatismo"  />
				<label for="reumatismo">Reumatismo</label><br>
				
				<s:checkbox class="campoCheck" name="exame.doenca_cardiaca" />
				<label for="doenca_cardiaca">Doença Cardíaca</label><br>
				
				<s:checkbox class="campoCheck" name="exame.pressao_alta" />
				<label for="pressao_alta">Pressão Alta</label><br>
				
				<s:checkbox class="campoCheck" name="exame.diabetes" />
				<label for="diabetes">Diabetes</label><br>
				
				<s:checkbox class="campoCheck" name="exame.doenca_mental" />
				<label for="pressao_alta">Doença Mental</label><br>
				
				<s:checkbox class="campoCheck" name="exame.epilepsia" />
				<label for="epilepsia">Epilepsia</label><br>
				
				<s:checkbox class="campoCheck" name="exame.hernia" />
				<label for="hernia">Hérnia</label><br>
			</div>
			
			<div class="putRight">
				<div class="campoDiv">
					<label for="cancer">Câncer:</label>
					<s:textfield class="campoText" name="exame.cancer" placeholder="Se sim, escreva o tipo do câncer" /><br>
				</div>
				<div class="campoDiv">	
					<label for="alergias">Alergias:</label>
					<s:textfield class="campoText" name="exame.alergias" placeholder="Se sim, alergia a que?" /><br>
				</div>
				<div class="campoDiv">	
					<label for="outras_doencas">Outras Doenças:</label>	
					<s:textfield class="campoText" name="exame.outras_doencas" 
					placeholder="Escreva doenças não citadas, separando por vírgula" /><br>
				</div>
				<div class="campoDiv">
					<label for="medicamentos">Medicamentos:</label>
					<s:textfield class="campoText" name="exame.medicamentos" 
					placeholder="Quais medicamentos você toma?" /><br>
				</div>
			</div>

			<div class="grupo">
				<div class="campoDiv">
					<label for="doencas_familiares" style="margin-bottom:11px"><h3>Quais doenças já aconteceram na sua família?</h3></label>
					<s:textarea name="exame.doencas_familiares" placeholder="Escreva as doenças separando por vírgulas" rows="5" cols="90" style="font-size:100%" >
					</s:textarea>
				</div>
			</div>
			
			<br>
			<button type="submit" name="btnCadastrar" value="editar">Cadastrar</button>
		</form>
	</div>
</body>
</html>