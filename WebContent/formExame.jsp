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
		<s:select name="id_Medico" list="listaMedicos" listKey="id_Medico" listValue="nm_Medico" headerKey="" headerValue="Selecione" label="Nome do Médico" />
		<s:select name="id_Paciente" list="listaPacientes" listKey="id_Paciente" listValue="nm_Paciente" headerKey="" headerValue="Selecione" label="Nome do Paciente" />
		Data do Exame: <input type="date" name="dt_Exame" />
		Tipo Sanguíneo: <input type="text" name="tp_Sanguineo" placeholder="Ex.: (A+, A-, O+)" />
		
		<h3>Doenças que já teve ou tem</h3>
		<input type="checkbox" name="reumatismo" value="true"/> Reumatismo<br>
		<input type="checkbox" name="doenca_cardiaca" value="true"/> Doença Cardíaca<br>
		<input type="checkbox" name="pressao_alta" value="true"/> Pressão Alta<br>
		<input type="checkbox" name="diabetes" value="true"/> Diabetes<br>
		<input type="checkbox" name="doenca_mental" value="true"/> Doença Mental<br>
		<input type="checkbox" name="epilepsia" value="true"/> Epilepsia<br>
		<input type="checkbox" name="hernia" value="true"/> Hernia<br>
		<br>
		Câncer <input type="text" name="cancer" placeholder="Se sim, escreva o tipo do câncer" /><br>
		Alergias <input type="text" name="alergias" placeholder="Se sim, alergia a que?" /><br>
		Outras Doenças <input type="text" name="outras_doencas" placeholder="Escreva doenças não citadas, separando por vírgula" /><br>
		Medicamentos <input type="text" name="medicamentos" placeholder="Quais medicamentos você toma?" /><br>
		
		<h3>Doenças Familiares</h3>
		
		Quais doenças já aconteceram na sua família?<br>
		<br>
		<textarea name="doencas_familiares" placeholder="Escreva as doenças separando por vírgulas" rows="5" cols="33" ></textarea>
		
		<br><br>
		<button type="submit" name="btnCadastrar" value="cadastrar">Cadastrar</button>
	</form>	
</body>
</html>