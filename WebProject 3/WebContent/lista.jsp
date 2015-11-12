<%@page import="to.*, persistence.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mb" class="manager.ManagerBean" scope="request"/>


<table border=1 >

		<tr>
			<th> Codigo </th>
			<th> Nome </th>
			<th> Cpf </th>
			<th> Rg </th>
			<th> Email </th>
			<th> Telefone </th>
			<th> Data de Nascimento </th>
			<th> Validade Carteira</th>
			<th> Gênero </th>
			<th> Estado Emissor RG</th>
			<th> Alterar </th>
			<th> Excluir </th>		
		
		</tr>

	
	<c:forEach items="${mb.lista}" var="linha">

		<tr>
			<td> ${linha.id}</td>	
			<td> ${linha.nome}</td>	
			<td> ${linha.cpf}</td>
		    <td> ${linha.rg}</td>
		    <td> ${linha.email}</td>
		    <td> ${linha.telefone}</td>
		    <td> ${linha.datNasc}</td>
		    <td> ${linha.validadeCarteira}</td>
			<td> ${linha.genero}</td>
			<td> ${linha.estEmissor}</td>
	
		
	        <td> <a href="Controle?cmd=buscar&cod=${linha.id}"> Alterar </a> </td>		
			<td> <a href="Controle?cmd=excluir&cod=${linha.id}"> Excluir </a> </td>
		</tr>
	</c:forEach>

</table>
${msg}
<br/>
<a href="index.jsp">Voltar para Principal</a>
