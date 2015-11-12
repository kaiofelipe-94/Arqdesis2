<%@page import="to.*, persistence.*"%>

<%
	if(request.getAttribute("cliente") != null){
		
		Cliente cli = (Cliente) request.getAttribute("cliente");		
%>
<form method="post" action="Controle?cmd=alterar">
		<fieldset>
 <legend>Dados Pessoais</legend>
 <table cellspacing="10">
  <tr>
   <td>
    <label for="id">ID: </label>
   </td>
   <td align="left">
    <input type="text" name="cod" value="<%=cli.getId() %>" readonly="readonly" size="5">
   
  </tr>
 
  <tr>
   <td>
    <label for="nome">Nome: </label>
   </td>
   <td align="left">
    <input type="text" name="nome" value="<%=cli.getNome() %>" size="13" maxlength="40" required> 
   
  </tr>
  
   <tr>
   <td>
    <label for="datNasc">Data de Nascimento: </label>
   
   <td align="left">
    <input type="date" name="datNasc" value="<%=cli.getDatNasc() %>" size="13" maxlength="13" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="rg">RG: </label>
  
   <td align="left">
    <input type="text" name="rg" value="<%=cli.getRg() %>" size="13" maxlength="13" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label>CPF:</label>
  
   <td align="left">
    <input type="text" name="cpf" value="<%=cli.getCpf() %>" size="11" maxlength="11" required>
 </td>
  </tr>

<tr>
   <td>
    <label>Telefone:</label>
    
   <td align="left">
    <input type="text" name="telefone" value="<%=cli.getTelefone() %>" size="8" maxlength="9" required> 
     </td>
  </tr>
  
    <tr>
   <td>
    <label for="email">E-mail: </label>
  
   <td align="left">
    <input type="text" name="email" value="<%=cli.getEmail() %>" size="18" maxlength="20" required>
   </td>
  </tr>
  
  <tr>
   <td>
  <label for="genero">Gênero:</label>

   <td align="left">
    <select name="genero"> 
    <option value="masculino">Masculino</option> 
    <option value="feminino">Feminino</option> 
 </select>
   </td>
  </tr>
  
   <tr>
   <td>
    <label for="validadeCarteira">Validade Carteira: </label>
   
   <td align="left"> 
    <input type="date" name="validadeCarteira" value="<%=cli.getValidadeCarteira() %>" size="13" maxlength="13" required> 
    </td>
  </tr>
  
   <tr>
   <td>
    <label for="estadoEmissorRG">Estado Emissor RG: </label>
   
   <td align="left">
    <input type="text" name="estadoEmissorRG" value="<%=cli.getEstEmissor() %>" size="2" maxlength="3" required> 
   </td>
  </tr>
  
  
	
</table>
</fieldset>
<input type="submit" value="Alterar"/>
</form>

<%
	}
%>
${msg}
<a href="index.jsp">Voltar</a>
