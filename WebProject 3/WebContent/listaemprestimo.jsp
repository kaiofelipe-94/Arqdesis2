<%@page import="to.*, persistence.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mb" class="manager.ManagerBeanEmprestimo" scope="request"/>


<table border=1 >

		<tr>
			<th> Codigo </th>
			<th> Cpf </th>
			<th> Placa </th>
			<th> Data de Emprestimo </th>
			<th> Data de Devolução </th>
			<th> Local de Emprestimo </th>
			<th> Local de Devolução </th>
			<th> Tipo de Tarifa</th>
			<th> Valor </th>
			<th> Acessorios</th>
			<th> Ativo</th>
			<th> Alterar </th>
			<th> Excluir </th>		
		
		</tr>

	
	<c:forEach items="${mb.lista}" var="linha">

		<tr>
			<td> ${linha.id}</td>	
		    <td> ${linha.cpf}</td>
		    <td> ${linha.placa}</td>
		    <td> ${linha.dataEmp}</td>
		    <td> ${linha.dataDev}</td>
		    <td> ${linha.localEmp}</td>
		    <td> ${linha.localDev}</td>
			<td> ${linha.tipoTarifa}</td>
			<td> ${linha.valor}</td>
			<td> ${linha.acessorios}</td>
			<td> ${linha.ativo}</td>
	
		
	        <td> <a href="ControleEmprestimo?cmd=buscar&cod=${linha.id}"> Alterar </a> </td>		
			<td> <a href="ControleEmprestimo?cmd=excluir&cod=${linha.id}"> Excluir </a> </td>
			<td> <a href="pagamentocredito.jsp"> Pagar Credito </a> </td>
			<td> <a href="pagamentodebito.jps"> Pagar Debito </a> </td>
			
		</tr>
	</c:forEach>

</table>
${msg}
<br/>
<a href="index.jsp">Voltar para Principal</a>
