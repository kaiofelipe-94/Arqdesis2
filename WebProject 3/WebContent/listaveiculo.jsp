<%@page import="to.*, persistence.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mb" class="manager.ManagerBeanVeiculo" scope="request"/>


<table border=1 >

		<tr>
			<th> Codigo </th>
			<th> Placa </th>
			<th> Grupo </th>
			<th> Marca </th>
			<th> Km </th>
			<th> Cidade </th>
			<th> Estado </th>
			<th> Modelo</th>
			<th> Chassi </th>
			<th> Tarifa Km Livre </th>
			<th> Tarifa Km Controlado </th>
			<th> Disponivel </th>
			<th> Alterar </th>
			<th> Excluir </th>		
		
		</tr>

	
	<c:forEach items="${mb.lista}" var="linha">

		<tr>
			<td> ${linha.id}</td>	
			<td> ${linha.placa}</td>	
			<td> ${linha.grupo}</td>
		    <td> ${linha.marca}</td>
		    <td> ${linha.km}</td>
		    <td> ${linha.cidade}</td>
		    <td> ${linha.estado}</td>
		    <td> ${linha.modelo}</td>
			<td> ${linha.chassi}</td>
			<td> ${linha.tarKmLivre}</td>
			<td> ${linha.tarKmControlado}</td>
			<td> ${linha.disponivel}</td>
		
	        <td> <a href="ControleVeiculo?cmd=buscar&cod=${linha.id}"> Alterar </a> </td>		
			<td> <a href="ControleVeiculo?cmd=excluir&cod=${linha.id}"> Excluir </a> </td>
		</tr>
	</c:forEach>

</table>
${msg}
<br/>
<a href="index.jsp">Voltar para Principal</a>
