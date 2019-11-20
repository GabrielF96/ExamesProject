<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exames</title>
</head>
<body>
<h1>Exames</h1>
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
		
		<s:url var="inserirUrl" action="formExame"></s:url>
		<s:a href="%{inserirUrl}">Inserir Exame</s:a>
		
			<s:iterator value='listaExames'>
				<tr>
					<td><s:property value="dt_Exame"/></td>
					<td><s:property value="nm_Paciente"/></td>
					<td><s:property value="nm_Medico"/></td>
					<td><s:url var="editarUrl" action="editarExame">
							<s:param name="id" value="id_Exame"></s:param>
						</s:url>
						<s:a href="%{editarUrl}">Editar</s:a>
					</td>
					<td>
						<s:url var="removerUrl" action="removerExame">
							<s:param name="id" value="id_Exame" />
						</s:url>
						<s:a href="%{removerUrl}">Remover</s:a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>