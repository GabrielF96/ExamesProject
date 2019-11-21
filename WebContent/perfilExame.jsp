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

.campoCheck{
	margin-bottom: 1.8em;
}

.campo{
	margin-bottom: 1em;
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

</style>
<title>Perfil Exame</title>
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
			
		<br>
		<fieldset class="grupo">
			<div class="campoDiv">
				<label>Nome do Médico:</label>
				<input type="text" style="height:35px; width:350px" value='<s:property value="perfilExame.nm_Medico" />' disabled/>
			</div>
			<div class="campoDiv">
				<label>Nome do Paciente:</label>
				<input type="text" style="height:35px; width:350px" value='<s:property value="perfilExame.nm_Paciente"/>' disabled/><br>
			</div>
		</fieldset>
		<fieldset class="grupo">
				<div class="campoDiv">
					<label for="dt_Exame">Data do Exame:</label>		
					<input type="date" value='<s:property value="perfilExame.dt_Exame" />' style="height:20px; padding:4px; width:340px;" disabled/>
				</div>
				<div class="campoDiv">
					<label for="tp_Sanguineo">Tipo Sanguíneo:</label>
					<input type="text" value='<s:property value="exame.tp_Sanguineo" />' style="height:20px; padding:4px; width:340px;" disabled/>
				</div>
		</fieldset>
			<h3 class="campo">Doenças que já teve ou tem</h3>
			<div class="putLeft">
				<input class="campoCheck" type="checkbox" name="reumatismo" value="true" <s:if test="perfilExame.reumatismo==true">checked</s:if> disabled/>
				<label for="reumatismo">Reumatismo</label><br>
				
				<input class="campoCheck" type="checkbox" name="doenca_cardiaca" value="true" <s:if test="perfilExame.doenca_cardiaca==true">checked</s:if> disabled/>
				<label for="doenca_cardiaca">Doença Cardíaca</label><br>
				
				<input class="campoCheck" type="checkbox" name="pressao_alta" value="true" <s:if test="perfilExame.pressao_alta==true">checked</s:if> disabled/>
				<label for="pressao_alta">Pressão Alta</label><br>
				
				<input class="campoCheck" type="checkbox" name="diabetes" value="true" <s:if test="perfilExame.diabetes==true">checked</s:if> disabled/>
				<label for="diabetes">Diabetes</label><br>
				
				<input class="campoCheck" type="checkbox" name="doenca_mental" value="true" <s:if test="perfilExame.doenca_mental==true">checked</s:if> disabled/>
				<label for="pressao_alta">Doença Mental</label><br>
				
				<input class="campoCheck" type="checkbox" name="epilepsia" value="true" <s:if test="perfilExame.epilepsia==true">checked</s:if> disabled/>
				<label for="epilepsia">Epilepsia</label><br>
				
				<input class="campoCheck" type="checkbox" name="hernia" value="true" <s:if test="perfilExame.hernia==true">checked</s:if> disabled/>
				<label for="hernia">Hérnia</label><br>
			</div>
			
			<div class="putRight">
				<div class="campoDiv">
					<label for="cancer">Câncer:</label>
					<input class="campoText" type="text" name="cancer" value='<s:property value="perfilExame.cancer" />' style="width:300px; height:25px" disabled/><br>
				</div>
				<div class="campoDiv">	
					<label for="alergias">Alergias:</label>
					<input class="campoText" type="text" name="alergias" value='<s:property value="perfilExame.alergias" />' style="width:300px; height:25px" disabled/><br>
				</div>
				<div class="campoDiv">	
					<label for="outras_doencas">Outras Doenças:</label>	
					<input class="campoText" type="text" name="outras_doencas" value='<s:property value="perfilExame.outras_doencas" />' style="width:300px; height:25px" disabled/><br>
				</div>
				<div class="campoDiv">
					<label for="medicamentos">Medicamentos:</label>
					<input class="campoText" type="text" name="medicamentos" value='<s:property value="perfilExame.medicamentos" />' style="width:300px; height:25px" disabled/><br>
				</div>
			</div>
			
			<div class="grupo">
				<div class="campoDiv">
					<label for="doencas_familiares" style="margin-bottom:11px"><h3>Quais doenças já aconteceram na sua família?</h3></label>
					<textarea name="doencas_familiares" rows="5" cols="90" style="font-size:100%" disabled><s:property 
					value="perfilExame.doencas_familiares" />
					</textarea>
				</div>
			</div>
	</div>
	
</body>
</html>