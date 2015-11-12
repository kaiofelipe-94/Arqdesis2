package persistence;

import to.User;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  

import to.Cliente;

public class LoginDao extends Dao{  
	public boolean validate(String user,String pass) throws Exception{		
		open();
		boolean status = false;  
		
			stmt = con.prepareStatement("select * from login where user=? and password=?");
		
			 	                    
	            stmt.setString(1, user);  
	            stmt.setString(2, pass);  
	  
	            rs = stmt.executeQuery();  
	            status = rs.next();  


    return status;  
}  
	  
     
}  
  
