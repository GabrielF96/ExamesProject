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
		headerKey="" headerValue="" label="Nome do M�dico" />
		<s:select name="id_Paciente" list="listaPacientes" listKey="id_Paciente" listValue="nm_Paciente" 
		headerKey="" headerValue="" label="Nome do Paciente" />
		Data do Exame: <input type="date" name="dt_Exame" value='<s:property value="exame.dt_Exame" />' />
		Tipo Sangu�neo: <input type="text" name="tp_Sanguineo" value='<s:property value="exame.tp_Sanguineo" />' placeholder="Ex.: (A+, A-, O+)" />
		
		<h3>Doen�as que j� teve ou tem</h3>
		<input type="checkbox" name="reumatismo" value="true" <s:if test="exame.reumatismo==true">checked</s:if> /> Reumatismo<br>
		<input type="checkbox" name="doenca_cardiaca" value="true" <s:if test="exame.doenca_cardiaca==true">checked</s:if> /> Doen�a Card�aca<br>
		<input type="checkbox" name="pressao_alta" value="true" <s:if test="exame.pressao_alta==true">checked</s:if> /> Press�o Alta<br>
		<input type="checkbox" name="diabetes" value="true" <s:if test="exame.diabetes==true">checked</s:if> /> Diabetes<br>
		<input type="checkbox" name="doenca_mental" value="true" <s:if test="exame.doenca_mental==true">checked</s:if> /> Doen�a Mental<br>
		<input type="checkbox" name="epilepsia" value="true" <s:if test="exame.epilepsia==true">checked</s:if> /> Epilepsia<br>
		<input type="checkbox" name="hernia" value="true" <s:if test="exame.hernia==true">checked</s:if> /> Hernia<br>
		
		<br>
		C�ncer <input type="text" name="cancer" value='<s:property value="exame.cancer" />' placeholder="Se sim, escreva o tipo do c�ncer" /><br>
		Alergias <input type="text" name="alergias" value='<s:property value="exame.alergias" />' placeholder="Se sim, alergia a que?" /><br>
		Outras Doen�as <input type="text" name="outras_doencas" value='<s:property value="exame.outras_doencas" />' 
		placeholder="Escreva doen�as n�o citadas, separando por v�rgula" /><br>
		Medicamentos <input type="text" name="medicamentos" value='<s:property value="exame.medicamentos" />' 
		placeholder="Quais medicamentos voc� toma?" /><br>
		
		<h3>Doen�as Familiares</h3>
		
		Quais doen�as j� aconteceram na sua fam�lia?<br>
		<br>
		<textarea name="doencas_familiares" placeholder="Escreva as doen�as separando por v�rgulas" rows="5" cols="33" ><s:property 
		value="exame.doencas_familiares" />
		</textarea>
		
		<br><br>
		<button type="submit" name="btnCadastrar" value="editar">Cadastrar</button>
	</form>	
</body>
</html>