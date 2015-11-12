package persistence;

import to.User;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  

import to.Cliente;

public class PagamentoDao extends Dao{  
	public boolean validate(String bandeira,String numero, String codigo, String data, String cpf) throws Exception{		
		open();
		boolean status = false;  
		
			stmt = con.prepareStatement("select * from PagamentoCredito where bandeira=? and numero=? and codigo=? and data=? and cpf=?");
		
			 	                    
	            stmt.setString(1, numero);  
	            stmt.setString(2, codigo);  
	            stmt.setString(3, data);  
	            stmt.setString(4, cpf);
	           	            rs = stmt.executeQuery();  
	            status = rs.next();  


    return status;  
}  
	
	
	public boolean validateD(String banco,String agencia, String conta, String cpf) throws Exception{		
		open();
		boolean status = false;  
		
			stmt = con.prepareStatement("select * from PagamentoDebito where banco=? and agencia=? and conta=? and cpf=?");
		
			 	                    
	            stmt.setString(1, banco);  
	            stmt.setString(2, agencia);  
	            stmt.setString(3, conta);  
	            stmt.setString(4, cpf);
	           	            rs = stmt.executeQuery();  
	            status = rs.next();  


    return status;  
}  
	  
     
}  
  

