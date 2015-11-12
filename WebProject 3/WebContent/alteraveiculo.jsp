<%@page import="to.*, persistence.*"%>

<%
	if(request.getAttribute("veiculo") != null){
		
		Veiculo vei = (Veiculo) request.getAttribute("veiculo");		
%>
<form method="post" action="ControleVeiculo?cmd=alterar">
		<fieldset>
 <legend>Dados Pessoais</legend>
 <table cellspacing="10">
  <tr>
   <td>
    <label for="id">ID: </label>
   </td>
   <td align="left">
    <input type="text" name="cod" value="<%=vei.getId() %>" readonly="readonly" size="5">
   
  </tr>
 
  <tr>
   <td>
    <label for="grupo">Grupo: </label>
   </td>
   <td align="left">
    <input type="text" name="grupo" value="<%=vei.getGrupo() %>" size="13" maxlength="40" required> 
   
  </tr>
  
   <tr>
   <td>
    <label for="chassi">Chassi: </label>
   
   <td align="left">
    <input type="text" name="chassi" value="<%=vei.getChassi() %>" size="13" maxlength="13" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="placa">Placa: </label>
  
   <td align="left">
    <input type="text" name="placa" value="<%=vei.getPlaca() %>" size="13" maxlength="13" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label>Cidade:</label>
  
   <td align="left">
    <input type="text" name="cidade" value="<%=vei.getCidade() %>" size="11" maxlength="11" required>
 </td>
  </tr>

<tr>
   <td>
    <label>Km:</label>
    
   <td align="left">
    <input type="text" name="km" value="<%=vei.getKm() %>" size="8" maxlength="9" required> 
     </td>
  </tr>
  
    <tr>
   <td>
    <label for="estado">Estado: </label>
  
   <td align="left">
    <input type="text" name="estado" value="<%=vei.getEstado() %>" size="18" maxlength="20" required>
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="modelo">Modelo: </label>
  
   <td align="left">
    <input type="text" name="modelo" value="<%=vei.getModelo() %>" size="18" maxlength="20" required>
   </td>
  </tr>
  
   <tr>
   <td>
    <label for="Marca">Marca: </label>
   
   <td align="left"> 
    <input type="text" name="marca" value="<%=vei.getMarca() %>" size="13" maxlength="13" required> 
    </td>
  </tr>
  
   <tr>
   <td>
    <label for="tarifakmlivre">Tarifa Km Livre: </label>
   
   <td align="left">
    <input type="text" name="tarifakmlivre" value="<%=vei.getTarKmLivre() %>" size="2" maxlength="3" required> 
   </td>
  </tr>
  
    <tr>
   <td>
    <label for="tarifakmcontrolado">Tarifa Km Controlado: </label>
   
   <td align="left">
    <input type="text" name="tarifakmcontrolado" value="<%=vei.getTarKmControlado() %>" size="2" maxlength="3" required> 
   </td>
  </tr>
  
	
	  <tr>
   <td>
    <label for="disponivel">Disponivel: </label>
   
   <td align="left">
    <input type="text" name="disponivel" value="<%=vei.getDisponivel() %>" size="2" maxlength="3" required> 
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
