<h2> Pagamento em Credito </h2>

<form method="post" action="ControlePagamentoC">

		<fieldset>
 <legend>Dados Pessoais</legend>
 <table cellspacing="10">
  <tr>
   <td>
    <label for="bandeira">Bandeira: </label>
   </td>
   <td align="left">
    <input type="text" name="bandeira" size="13" maxlength="40" required> 
   
  </tr>
  
   <tr>
   <td>
    <label for="numero">Numero: </label>
   
   <td align="left">
    <input name="numero" type="text" required/>
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="codigo">Codigo: </label>
  
   <td align="left">
    <input type="text" name="codigo" size="13" maxlength="13" required> 
   </td>
  </tr>
  
  
<tr>
   <td>
    <label>Data:</label>
    
   <td align="left">
    <input type="text" name="data" size="8" maxlength="9" required> 
     </td>
  </tr>
  
  <tr>
   <td>
    <label>Cpf:</label>
    
   <td align="left">
    <input type="text" name="cpf" size="8" maxlength="9" required> 
     </td>
  </tr>
  
	
</table>
</fieldset>
<input type="submit" value="Pagar"/>
</form>


