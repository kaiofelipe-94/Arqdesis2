<h2> Pagamento em Debito </h2>

<form method="post" action="ControlePagamentoD">

		<fieldset>
 <legend>Dados Pessoais</legend>
 <table cellspacing="10">
  <tr>
   <td>
    <label for="banco">Banco: </label>
   </td>
   <td align="left">
    <input type="text" name="banco" size="13" maxlength="40" required> 
   
  </tr>
  
   <tr>
   <td>
    <label for="agencia">Agência: </label>
   
   <td align="left">
    <input name="agência" type="text" required/>
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="conta">Conta: </label>
  
   <td align="left">
    <input type="text" name="conta" size="13" maxlength="13" required> 
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



