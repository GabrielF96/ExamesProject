<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Exame</title>
</head>
<body>
	<h1>Novo Exame</h1>
	
	<form action="inserirExame" method="post">
		<s:hidden name="id_Exame" />
		<s:select name="id_Medico" list="listaMedicos" listKey="id_Medico" listValue="nm_Medico" headerKey="" headerValue="Selecione" label="Nome do M�dico" />
		<s:select name="id_Paciente" list="listaPacientes" listKey="id_Paciente" listValue="nm_Paciente" headerKey="" headerValue="Selecione" label="Nome do Paciente" />
		Data do Exame: <input type="date" name="dt_Exame" />
		Tipo Sangu�neo: <input type="text" name="tp_Sanguineo" placeholder="Ex.: (A+, A-, O+)" />
		
		<h3>Doen�as que j� teve ou tem</h3>
		<input type="checkbox" name="reumatismo" value="true"/> Reumatismo<br>
		<input type="checkbox" name="doenca_cardiaca" value="true"/> Doen�a Card�aca<br>
		<input type="checkbox" name="pressao_alta" value="true"/> Press�o Alta<br>
		<input type="checkbox" name="diabetes" value="true"/> Diabetes<br>
		<input type="checkbox" name="doenca_mental" value="true"/> Doen�a Mental<br>
		<input type="checkbox" name="epilepsia" value="true"/> Epilepsia<br>
		<input type="checkbox" name="hernia" value="true"/> Hernia<br>
		<br>
		C�ncer <input type="text" name="cancer" placeholder="Se sim, escreva o tipo do c�ncer" /><br>
		Alergias <input type="text" name="alergias" placeholder="Se sim, alergia a que?" /><br>
		Outras Doen�as <input type="text" name="outras_doencas" placeholder="Escreva doen�as n�o citadas, separando por v�rgula" /><br>
		Medicamentos <input type="text" name="medicamentos" placeholder="Quais medicamentos voc� toma?" /><br>
		
		<h3>Doen�as Familiares</h3>
		
		Quais doen�as j� aconteceram na sua fam�lia?<br>
		<br>
		<textarea name="doencas_familiares" placeholder="Escreva as doen�as separando por v�rgulas" rows="5" cols="33" ></textarea>
		
		<br><br>
		<button type="submit" name="btnCadastrar" value="cadastrar">Cadastrar</button>
	</form>	
</body>
</html>