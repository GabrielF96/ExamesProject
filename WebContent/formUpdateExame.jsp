<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Exame</title>
</head>
<body>
<h1>Editar Exame</h1>
	
	<form action="inserirExame" method="post">
		<input type="hidden" name="id_Exame" value='<s:property value="exame.id" />' />
		<s:select name="id_Medico" list="listaMedicos" listKey="id_Medico" listValue="nm_Medico" 
		headerKey="" headerValue="" label="Nome do Médico" />
		<s:select name="id_Paciente" list="listaPacientes" listKey="id_Paciente" listValue="nm_Paciente" 
		headerKey="" headerValue="" label="Nome do Paciente" />
		Data do Exame: <input type="date" name="dt_Exame" value='<s:property value="exame.dt_Exame" />' />
		Tipo Sanguíneo: <input type="text" name="tp_Sanguineo" value='<s:property value="exame.tp_Sanguineo" />' placeholder="Ex.: (A+, A-, O+)" />
		
		<h3>Doenças que já teve ou tem</h3>
		<input type="checkbox" name="reumatismo" value="true" <s:if test="exame.reumatismo==true">checked</s:if> /> Reumatismo<br>
		<input type="checkbox" name="doenca_cardiaca" value="true" <s:if test="exame.doenca_cardiaca==true">checked</s:if> /> Doença Cardíaca<br>
		<input type="checkbox" name="pressao_alta" value="true" <s:if test="exame.pressao_alta==true">checked</s:if> /> Pressão Alta<br>
		<input type="checkbox" name="diabetes" value="true" <s:if test="exame.diabetes==true">checked</s:if> /> Diabetes<br>
		<input type="checkbox" name="doenca_mental" value="true" <s:if test="exame.doenca_mental==true">checked</s:if> /> Doença Mental<br>
		<input type="checkbox" name="epilepsia" value="true" <s:if test="exame.epilepsia==true">checked</s:if> /> Epilepsia<br>
		<input type="checkbox" name="hernia" value="true" <s:if test="exame.hernia==true">checked</s:if> /> Hernia<br>
		
		<br>
		Câncer <input type="text" name="cancer" value='<s:property value="exame.cancer" />' placeholder="Se sim, escreva o tipo do câncer" /><br>
		Alergias <input type="text" name="alergias" value='<s:property value="exame.alergias" />' placeholder="Se sim, alergia a que?" /><br>
		Outras Doenças <input type="text" name="outras_doencas" value='<s:property value="exame.outras_doencas" />' 
		placeholder="Escreva doenças não citadas, separando por vírgula" /><br>
		Medicamentos <input type="text" name="medicamentos" value='<s:property value="exame.medicamentos" />' 
		placeholder="Quais medicamentos você toma?" /><br>
		
		<h3>Doenças Familiares</h3>
		
		Quais doenças já aconteceram na sua família?<br>
		<br>
		<textarea name="doencas_familiares" placeholder="Escreva as doenças separando por vírgulas" rows="5" cols="33" ><s:property 
		value="exame.doencas_familiares" />
		</textarea>
		
		<br><br>
		<button type="submit" name="btnCadastrar" value="editar">Cadastrar</button>
	</form>	
</body>
</html>