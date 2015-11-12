package persistence;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import to.Cliente;

public class ClienteDao extends Dao {
	
	
	public void create(Cliente c) throws Exception{		
		open();
			stmt = con.prepareStatement("insert into cliente values(null,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, c.getCpf());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getRg());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getDatNasc());
			stmt.setString(7, c.getGenero());
			stmt.setString(8, c.getEstEmissor());
			stmt.setString(9, c.getValidadeCarteira());
			stmt.execute();
			stmt.close();
		close();		
	}

	public void delete(int cod) throws Exception{		
		open();
			stmt = con.prepareStatement("delete from cliente where id = ?");
			stmt.setInt(1, cod);
			stmt.execute();
			stmt.close();
		close();		
	}

	public void update(Cliente c) throws Exception{		
		open();
			stmt = con.prepareStatement("update cliente set cpf = ? , nome= ?, rg = ?, telefone= ?, email= ?, dataNascimento= ?, genero= ? , estadoEmissorRG= ? , validadeCarteira= ? where id = ?");
			stmt.setString(1, c.getCpf());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getRg());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getDatNasc());
			stmt.setString(7, c.getGenero());
			stmt.setString(8, c.getEstEmissor());
			stmt.setString(9, c.getValidadeCarteira());
			stmt.setInt(10, c.getId());
			stmt.executeUpdate();
			stmt.close();
		close();		
	}
	
	public List findAll() throws Exception{		
		open();
			stmt = con.prepareStatement("select * from cliente");
			rs = stmt.executeQuery();
				List lista = new ArrayList();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setCpf(rs.getString(2));
				cliente.setNome(rs.getString(3));
				cliente.setRg(rs.getString(4));
				cliente.setTelefone(rs.getString(5));
				cliente.setEmail(rs.getString(6));
				cliente.setDatNasc(rs.getString(7));
				cliente.setGenero(rs.getString(8));
				cliente.setEstEmissor(rs.getString(9));
				cliente.setValidadeCarteira(rs.getString(10));
				lista.add(cliente);
			}
			stmt.close();
		close();
		return lista;
	}
	
	
	
	 
	
	public Cliente findByCode(int id) throws Exception{		
		open();
			stmt = con.prepareStatement("select * from Cliente where id = ?");
			stmt.setInt(1, id);	
			rs = stmt.executeQuery();
				Cliente cliente	= null;			
			if(rs.next()){
				cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setCpf(rs.getString(2));
				cliente.setNome(rs.getString(3));
				cliente.setRg(rs.getString(4));
				cliente.setTelefone(rs.getString(5));
				cliente.setEmail(rs.getString(6));
				cliente.setDatNasc(rs.getString(7));
				cliente.setGenero(rs.getString(8));
				cliente.setEstEmissor(rs.getString(9));
				cliente.setValidadeCarteira(rs.getString(10));
				
			}
			stmt.close();
		close();
		return cliente;
	}
	public Cliente consultaCpf(String cpf) throws Exception{		
		open();
			stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE CPF = ?");
			stmt.setString(1, cpf);	
			rs = stmt.executeQuery();
				Cliente cliente	= null;			
			if(rs.next()){
				cliente = new Cliente();
				cliente.setCpf(rs.getString(1));
				
			}
			stmt.close();
		close();
		return cliente;
	}
	
	
	
	
}