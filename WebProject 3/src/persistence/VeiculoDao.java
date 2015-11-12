package persistence;

import java.util.ArrayList;
import java.util.List;

import to.Cliente;
import to.Veiculo;

public class VeiculoDao extends Dao {
	
	
	public void create(Veiculo v) throws Exception{		
		open();
			stmt = con.prepareStatement("insert into veiculo values(null,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, v.getPlaca());
			stmt.setString(2, v.getMarca());
			stmt.setString(3, v.getModelo());
			stmt.setString(4, v.getGrupo());
			stmt.setString(5, v.getCidade());
			stmt.setString(6, v.getEstado());
			stmt.setString(7, v.getKm());
			stmt.setString(8, v.getChassi());
			stmt.setString(9, v.getTarKmLivre() );
			stmt.setString(10, v.getTarKmControlado());
			stmt.setInt(11, v.getDisponivel());
				
			stmt.execute();
			stmt.close();
		close();		
	}

	public void delete(int id) throws Exception{		
		open();
			stmt = con.prepareStatement("delete from veiculo where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		close();		
	}

	public void update(Veiculo v) throws Exception{		
		open();
			stmt = con.prepareStatement("update veiculo set grupo = ? , chassi = ?,  placa = ?, cidade = ?, km = ?, estado = ?, modelo = ?, marca = ?, tarkmlivre =?,tarkmcontrolado = ?, disponivel = ? where idVeiculo = ?");
			stmt.setString(1, v.getPlaca());
			stmt.setString(2, v.getMarca());
			stmt.setString(3, v.getModelo());
			stmt.setString(4, v.getGrupo());
			stmt.setString(5, v.getCidade());
			stmt.setString(6, v.getEstado());
			stmt.setString(7, v.getKm());
			stmt.setString(8, v.getChassi());
			stmt.setString(9, v.getTarKmLivre() );
			stmt.setString(10, v.getTarKmControlado());
			stmt.setInt(11, v.getDisponivel());
			stmt.execute();
			stmt.close();
		close();		
	}
	
	public List findAll() throws Exception{		
		open();
			stmt = con.prepareStatement("select * from veiculo");
			rs = stmt.executeQuery();
				List lista = new ArrayList();
			while(rs.next()){
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt(1));
				veiculo.setPlaca(rs.getString(2));
				veiculo.setMarca(rs.getString(3));
				veiculo.setModelo(rs.getString(4));
				veiculo.setGrupo(rs.getString(5));
				veiculo.setCidade(rs.getString(6));
				veiculo.setEstado(rs.getString(7));
				veiculo.setKm(rs.getString(8));
				veiculo.setChassi(rs.getString(9));
				veiculo.setTarKmLivre(rs.getString(10));
				veiculo.setTarKmControlado(rs.getString(11));
				veiculo.setDisponivel(rs.getInt(12));
				lista.add(veiculo);
			}
			stmt.close();
		close();
		return lista;
	}
	
	public Veiculo findByCode(int id) throws Exception{		
		open();
			stmt = con.prepareStatement("select * from Veiculo where id = ?");
			stmt.setInt(1, id);	
			rs = stmt.executeQuery();
				Veiculo veiculo	= null;			
			if(rs.next()){
				veiculo = new Veiculo();
				veiculo.setId(rs.getInt(1));
				veiculo.setPlaca(rs.getString(2));
				veiculo.setMarca(rs.getString(3));
				veiculo.setModelo(rs.getString(4));
				veiculo.setGrupo(rs.getString(5));
				veiculo.setCidade(rs.getString(6));
				veiculo.setEstado(rs.getString(7));
				veiculo.setKm(rs.getString(8));
				veiculo.setChassi(rs.getString(9));
				veiculo.setTarKmLivre(rs.getString(10));
				veiculo.setTarKmControlado(rs.getString(11));
				veiculo.setDisponivel(rs.getInt(12));
				
			}
			stmt.close();
		close();
		return veiculo;
	}	
	
	public Veiculo consultaPlaca(String placa) throws Exception{		
		open();
			stmt = con.prepareStatement("SELECT * FROM VEICULO WHERE PLACA = ??");
			stmt.setString(1, placa);	
			rs = stmt.executeQuery();
				Veiculo veiculo	= null;			
			if(rs.next()){
				veiculo = new Veiculo();
				veiculo.setPlaca(rs.getString(1));
				
			}
			stmt.close();
		close();
		return veiculo;
	}
	
}