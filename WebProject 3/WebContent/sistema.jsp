<h2> Cadastro de Cliente </h2>

<form method="post" action="Controle?cmd=gravar">

		<fieldset>
 <legend>Dados Pessoais</legend>
 <table cellspacing="10">
 
 
  

  
 
 
 
   <tr>
   <td>
    <label for="nome">Nome: </label>
   </td>
   <td align="left">
    <input type="text" name="nome" size="13" maxlength="40" required> 
   
  </tr>
 
   <tr>
   <td>
    <label for="datNasc">Data de Nascimento: </label>
   
   <td align="left">
    <input name="datNasc" type="date" value="13-01-1000"required/>
   </td>
  </tr>
  
  <tr>
   <td>
    <label for="rg">RG: </label>
  
   <td align="left">
    <input  pattern="[a-zA-Z0-9]+" type="text" name="rg" size="13" maxlength="13" required> 
   </td>
  </tr>
  
  <tr>
   <td>
    <label>CPF:</label>
  
   <td align="left">
    <input type="text" name="cpf" size="11" maxlength="15" required>
 </td>
  </tr>

<tr>
   <td>
    <label>Telefone:</label>
    
   <td align="left">
    <input type="text" name="telefone" size="8" maxlength="9"  required> 
     </td>
  </tr>
  
    <tr>
   <td>
    <label for="email">E-mail: </label>
  
   <td align="left">
    <input type="email" name="email" size="18" maxlength="40" required>
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
    <input name="validadeCarteira" type="date" value="13-01-2000"required/> 
    </td>
  </tr>
  
   <tr>
   <td>
    <label for="estadoEmissorRG">Estado Emissor RG: </label>
   
   <td align="left">
    <input type="text" name="estadoEmissorRG" size="2" maxlength="3" required> 
   </td>
  </tr>
  
  
	
</table>
</fieldset>
<input type="submit" value="Cadastrar"/>
</form>

${msg}
<br/>
<a href="lista.jsp">Listagem dos Clientes</a>
<a href="welcome.jsp">Voltar</a>