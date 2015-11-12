<h2> Cadastro de Veiculo </h2>

<form method="post" action="ControleVeiculo?cmd=gravar">

		<fieldset>
 <legend>Dados do Veiculo</legend>
 <table cellspacing="10">
  <tr>
   <td>
    <label for="grupo">Grupo: </label>
   </td>
   <td align="left">
    <input type="text" name="grupo" size="13" maxlength="40" required> 
   
  </tr>
  
   <tr>
   <td>
    <label for="chassi">Chassi: </label>
   
   <td align="left">
    <input type="text" name="chassi" size="13" maxlength="30" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="placa">Placa: </label>
  
   <td align="left">
    <input type="text" name="placa" size="9" maxlength="9" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label>Cidade:</label>
  
   <td align="left">
    <input type="text" name="cidade" size="11" maxlength="40" required>
 </td>
  </tr>

<tr>
   <td>
    <label>Km:</label>
    
   <td align="left">
    <input type="text" name="km" size="8" maxlength="9" required> 
     </td>
  </tr>
  
    <tr>
   <td>
    <label for="estado">Estado: </label>
  
   <td align="left">
    <input type="text" name="estado" size="18" maxlength="25" required>
   </td>
  </tr>
  
   <tr>
   <td>
    <label for="modelo">Modelo: </label>
   
   <td align="left"> 
    <input type="text" name="modelo" size="13" maxlength="29" required> 
    </td>
  </tr>
  
   <tr>
   <td>
    <label for="marca">Marca: </label>
   
   <td align="left">
    <input type="text" name="marca" size="2" maxlength="40" required> 
   </td>
  </tr>
  
     <tr>
   <td>
    <label for="tarkmlivre">Tarifa Km Livre: </label>
   
   <td align="left">
    <input type="text" name="tarkmlivre" size="2" maxlength="10" required> 
   </td>
  </tr>
  
    <tr>
   <td>
    <label for="tarkmlivre">Tarifa Km Controlado: </label>
   
   <td align="left">
    <input type="text" name="tarkmcontrolado" size="2" maxlength="10" required> 
   </td>
  </tr>
  
    <tr>
   <td>
  <label for="disponivel">Disponivel:</label>

   <td align="left">
    <select name="disponivel"> 
    <option value="1">Sim</option> 
    <option value="0">Não</option> 
 </select>
   </td>
  </tr>
  
	
</table>
</fieldset>
<input type="submit" value="Cadastrar"/>
</form>

${msg}
<br/>
<a href="listaveiculo.jsp">Listagem de Veiculos</a>
<a href="welcome.jsp">Voltar</a>
