package persistence;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import to.Emprestimo;
import to.Cliente;
import to.Veiculo;

import com.mysql.jdbc.Connection;

import javax.swing.JOptionPane;

public class EmprestimoDao extends Dao
{
	public String consultarClientes()
	{
		String sqlSelect = "SELECT NOME, CPF FROM CLIENTE"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		Cliente c = new Cliente();
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			rs = stm.executeQuery();
			ArrayList <Cliente> list = new ArrayList<Cliente>();

			if (!rs.next())
			{
				JOptionPane.showMessageDialog(null, "Sem registro!");
			}
			else
			{
				do 
				{ 
					consulta += rs.getString("nome") + "\n";
					consulta += rs.getString("cpf") + "\n\n";
				} while (rs.next());
			}
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		try 
		{ 
			conn.rollback(); 
		} 
		catch (SQLException e1) 
		{ 
			e1.getStackTrace(); 
		} 
		finally 
		{ 
			if (stm != null) 
			{ 
				try 
				{ 
					stm.close(); 
				} 
				catch (SQLException e1) 
				{ 
					System.out.print(e1.getStackTrace()); 
				} 
			} 
		}
		return consulta;
	}

	public String consultarVeiculos()
	{
		String sqlSelect = "SELECT PLACA, MARCA, MODELO FROM VEICULO WHERE DISPONIVEL = 1"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		Veiculo v = new Veiculo();
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			rs = stm.executeQuery();

			if (!rs.next())
			{
				JOptionPane.showMessageDialog(null, "Sem registro!");
			}
			else
			{
				do 
				{ 
					consulta += rs.getString("placa") + "\n";
					consulta += rs.getString("marca") + "\n";
					consulta += rs.getString("modelo") + "\n\n";
				} while (rs.next());
			}
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		try 
		{ 
			conn.rollback(); 
		} 
		catch (SQLException e1) 
		{ 
			e1.getStackTrace(); 
		} 
		finally 
		{ 
			if (stm != null) 
			{ 
				try 
				{ 
					stm.close(); 
				} 
				catch (SQLException e1) 
				{ 
					System.out.print(e1.getStackTrace()); 
				} 
			} 
		}
		return consulta;
	}


	public void realizarEmprestimo(Emprestimo e, String cpf, String placa) throws Exception
	{ 
		
		open();
		stmt = con.prepareStatement("insert into emprestimo values(null,?, ?,?,?, ?, ?, ?, ?, ?,?,? ,1)");
		 stmt.setInt(1, getIdCli(cpf));
         stmt.setString(2, cpf);
         stmt.setInt(3, getIdVei(placa));
         stmt.setString(4, placa);
         stmt.setString(5,e.getDataEmp());
         stmt.setString(6,e.getDataDev());
         stmt.setString(7,e.getLocalEmp());
         stmt.setString(8,e.getLocalDev());
         stmt.setString(9,e.getTipoTarifa());
         stmt.setString(10,e.getAcessorios());
         stmt.setDouble(11,e.getValor());
         stmt.execute();
         stmt.close();
         close();
			
	}

	public void setIndisp(String placa)
	{
		String sqlUpdate = "UPDATE VEICULO SET DISPONIVEL = 0 WHERE PLACA = ?"; 

		Connection conn = null;
		PreparedStatement stm = null; 

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
			stm = (PreparedStatement) conn.prepareStatement(sqlUpdate); 
			stm.setString(1, placa);
			stm.execute();
			conn.commit();
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
	}

	public int getIdCli(String cpf)
	{
		String sqlSelect = "SELECT ID FROM CLIENTE WHERE CPF = ?"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		int consulta = 0;

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			stm.setString(1, cpf);
			rs = stm.executeQuery();

			while (rs.next())
			{
				consulta = rs.getInt("id");
			}
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}

	public int getIdVei(String placa)
	{
		String sqlSelect = "SELECT ID FROM VEICULO WHERE PLACA = ?"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		int consulta = 0;

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			stm.setString(1, placa);
			rs = stm.executeQuery();

			while (rs.next())
			{
				consulta = rs.getInt("id");
			}
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}

	public String getValKmLivre(String placa)
	{
		String sqlSelect = "SELECT TARIFAKMLIVRE FROM VEICULO WHERE PLACA = ?"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			stm.setString(1, placa);
			rs = stm.executeQuery();

			while (rs.next())
			{
				consulta = rs.getString("tarifaKmLivre");
			}
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}

	public String getValKmControlado(String placa)
	{
		String sqlSelect = "SELECT TARIFAKMCONTROLADO FROM VEICULO WHERE PLACA = ?"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			stm.setString(1, placa);
			rs = stm.executeQuery();

			while (rs.next())
			{
				consulta = rs.getString("tarifaKmControlado");
			}
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}
	
	public List findAll() throws Exception
	{
		open();
	stmt = con.prepareStatement("select * from emprestimo");
	rs = stmt.executeQuery();
		List lista = new ArrayList();
	while(rs.next()){
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setId(rs.getInt(1));
		rs.getInt(2);
		emprestimo.setCpf(rs.getString(3));
		rs.getInt(4);
		emprestimo.setPlaca(rs.getString(5));
		emprestimo.setDataEmp(rs.getString(6));
		emprestimo.setDataDev(rs.getString(7));
		emprestimo.setLocalEmp(rs.getString(8));
		emprestimo.setLocalDev(rs.getString(9));
		emprestimo.setTipoTarifa(rs.getString(10));
		emprestimo.setValor(rs.getInt(11));
		emprestimo.setAcessorios(rs.getString(12));
		emprestimo.setAtivo(rs.getInt(13));
		lista.add(emprestimo);
	}
	stmt.close();
close();
return lista;
		
		
	}

	
	public Emprestimo findByCode(int id) throws Exception{		
		open();
			stmt = con.prepareStatement("select * from Emprestimo where id = ?");
			stmt.setInt(1, id);	
			rs = stmt.executeQuery();
				Emprestimo emprestimo	= null;			
				if(rs.next()){
					emprestimo = new Emprestimo();
					emprestimo.setId(rs.getInt(1));
					rs.getInt(2);
					emprestimo.setCpf(rs.getString(3));
					rs.getInt(4);
					emprestimo.setPlaca(rs.getString(5));
					emprestimo.setDataEmp(rs.getString(6));
					emprestimo.setDataDev(rs.getString(7));
					emprestimo.setLocalEmp(rs.getString(8));
					emprestimo.setLocalDev(rs.getString(9));
					emprestimo.setTipoTarifa(rs.getString(10));
					emprestimo.setValor(rs.getInt(11));
					emprestimo.setAcessorios(rs.getString(12));
					emprestimo.setAtivo(rs.getInt(13));
					
				}
				stmt.close();
			close();
		return emprestimo;
	}
	
	public String getEmprestimos()
	{
		String sqlSelect = "SELECT T3.ID, T2.MARCA, T2.MODELO, T1.NOME, T1.CPF, " +  
				"T3.DATAEMPRESTIMO, T3.DATADEVOLUCAO, T3.VALOREMPRESTIMO " + 
				"FROM CLIENTE AS T1 " + 
				"INNER JOIN EMPRESTIMO AS T3 " + 
				"ON T1.ID = T3.IDCLI " + 
				"INNER JOIN VEICULO AS T2 " + 
				"ON T3.IDVEI = T2.ID " + 
				"WHERE ATIVO = 1 " + 
				"ORDER BY T1.NOME"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			//stm.setString(1, placa);
			rs = stm.executeQuery();

			while (rs.next())
			{
				consulta += rs.getString("id") + "  ";
				consulta += rs.getString("marca") + "  ";
				consulta += rs.getString("modelo")+ "  ";
				consulta += rs.getString("nome")+ "  ";
				consulta += rs.getString("cpf")+ "  ";
				consulta += rs.getString("dataEmprestimo")+ "  ";
				consulta += rs.getString("dataDevolucao")+ "  ";
				consulta += rs.getString("valorEmprestimo") + "\n";
			}
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}

	public String getEmprestimoDev(int id)
	{
		String sqlSelect = "SELECT T3.ID, T2.MARCA, T2.MODELO, T1.NOME, T1.CPF, " +  
				"T3.DATAEMPRESTIMO, T3.DATADEVOLUCAO, T3.VALOREMPRESTIMO " + 
				"FROM CLIENTE AS T1 " + 
				"INNER JOIN EMPRESTIMO AS T3 " + 
				"ON T1.ID = T3.IDCLI " + 
				"INNER JOIN VEICULO AS T2 " + 
				"ON T3.IDVEI = T2.ID " +
				"WHERE T3.ID = ? " + 
				"AND T3.ATIVO = 1 " +
				"ORDER BY T1.NOME"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			stm.setInt(1, id);
			rs = stm.executeQuery();

			if (rs.next())
			{
				consulta += rs.getString("id") + "  ";
				consulta += rs.getString("marca") + "  ";
				consulta += rs.getString("modelo")+ "  ";
				consulta += rs.getString("nome")+ "  ";
				consulta += rs.getString("cpf")+ "  ";
				consulta += rs.getString("dataEmprestimo")+ "  ";
				consulta += rs.getString("dataDevolucao")+ "  ";
				consulta += rs.getString("valorEmprestimo") + "\n";
			}
			else consulta = "Não há dados para esse número de empréstimo!";
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}

	public String getDataDev(int id)
	{
		String sqlSelect = "SELECT DATADEVOLUCAO FROM EMPRESTIMO WHERE ID = ?"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			stm.setInt(1, id);
			rs = stm.executeQuery();

			if (rs.next())
			{
				consulta += rs.getString("dataDevolucao");
			}
			//else consulta = "Não há dados para esse número de empréstimo!";
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}

	public void alterarStatusEmprestimo(int id) 
	{ 
		String sqlUpdate = "UPDATE EMPRESTIMO SET ATIVO = 0 WHERE ID = ?";

		Connection conn = null;
		PreparedStatement stm = null; 
		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
			// 
			// Inclusao dos dados na tabela CLIENTE 
			// 
			stm = (PreparedStatement) conn.prepareStatement(sqlUpdate);
			stm.setInt(1, id);
			stm.execute();
			conn.commit();
		}

		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			try 
			{ 
				conn.rollback(); 
			} 
			catch (SQLException e1) 
			{ 
				System.out.print(e1.getStackTrace()); 
			} 
		} 
		finally 
		{ 
			if (stm != null) 
			{ 
				try 
				{ 
					stm.close(); 
				} 
				catch (SQLException e1) 
				{ 
					System.out.print(e1.getStackTrace()); 
				} 
			} 
		}
	}
	
	public String getValorEmp(int id)
	{
		String sqlSelect = "SELECT VALOREMPRESTIMO FROM EMPRESTIMO WHERE ID = ?"; 

		Connection conn = null;
		PreparedStatement stm = null; 
		ResultSet rs = null;
		String consulta = "";

		try 
		{ 
			AcessoBD bd = new AcessoBD(); 
			conn = bd.obtemConexao();
			stm = conn.prepareStatement(sqlSelect); 
			stm.setInt(1, id);
			rs = stm.executeQuery();

			if (rs.next())
			{
				consulta += rs.getString("valoremprestimo");
			}
			//else consulta = "Não há dados para esse número de empréstimo!";
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
		return consulta;
	}
}
