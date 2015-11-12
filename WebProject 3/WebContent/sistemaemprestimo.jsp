<h2> Realizar Locação </h2>

<form method="post" action="ControleEmprestimo?cmd=gravar">

		<fieldset>
 <legend>Dados Pessoais</legend>
 <table cellspacing="10">
  <tr>
   <td>
    <label for="cpf">CPF: </label>
   </td>
   <td align="left">
    <input type="text" name="cpf" size="13" maxlength="15" required> 
   
  </tr>
  
   <tr>
   <td>
    <label for="placa">Placa </label>
   
   <td align="left">
    <input type="text" name="placa" size="9" maxlength="9" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="dataEmp">Data de Emprestimo: </label>
  
   <td align="left">
    <input name="dataEmp" type="date" value="13-01-2000"required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label>Data de Devolução:</label>
  
   <td align="left">
    <input name="dataDev" type="date" value="13-01-2000"required>
 </td>
  </tr>

  
  <tr>
   <td>
  <label for="localEmp">Local de Emprestimo:</label>

   <td align="left">
    <select name="localEmp"> 
    <option value="1">Filial 1</option> 
    <option value="2">Filial 2</option> 
 </select>
   </td>
  </tr>
  
   <tr>
   <td>
  <label for="localDev">Local de Devolução:</label>

   <td align="left">
    <select name="localDev"> 
    <option value="1">Filial 1</option> 
    <option value="2">Filial 2</option> 
 </select>
   </td>
  </tr>
  
  
    <tr>
   <td>
  <label for="tipoTarifa">Tipo de Tarifa:</label>

   <td align="left">
    <select name="tipoTarifa"> 
    <option value="Km Livre">Km Livre</option> 
    <option value="Km Controlado">Km Controlado</option> 
 </select>
   </td>
  </tr>
  
   <tr>
   <td>
    <label for="valor">Valor: </label>
   
   <td align="left">
    <input type="text" name="valor" size="2" maxlength="3" required> 
   </td>
  </tr>
  
   <tr>
   <td>
    <label for="acessorios">Acessorios: </label>
   
   <td align="left">
    <input type="text" name="acessorios" size="2" maxlength="3" required> 
   </td>
  </tr>
  
  
  
	
</table>
</fieldset>
<input type="submit" value="Realizar Locação"/>
</form>

${msg}
<br/>
<a href="listaemprestimo.jsp">Listagem das Locações</a>
<a href="welcome.jsp">Voltar</a>
