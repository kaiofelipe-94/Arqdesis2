package to;

import persistence.VeiculoDao;



public class Veiculo 
{
	public char grupo;
	public String chassi;
	public String classe;
	public String placa;
	public String cidade;
	public String km;
	public String estado;
	public String modelo;
	public String marca;
	public String tarKmLivre;
	public String tarKmControlado;
	public int disponivel;
	public int id;
	
	public Veiculo () { }

	public String getGrupo() 
	{
		String grupo = "";
		grupo += this.grupo;
		return grupo;
	}

	public void setGrupo(String grupo) 
	{
		char cgrupo = grupo.charAt(0);
		this.grupo = cgrupo;
	}

	public String getChassi() 
	{
		return chassi;
	}

	public void setChassi(String chassi) 
	{
		this.chassi = chassi;
	}

	public String getClasse() 
	{
		return classe;
	}

	public void setClasse(String classe) 
	{
		this.classe = classe;
	}

	public String getPlaca() 
	{
		return placa;
	}

	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}

	public String getCidade() 
	{
		return cidade;
	}

	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}

	public String getKm() 
	{
		return km;
	}

	public void setKm(String km) 
	{
		this.km = km;
	}

	public String getEstado() 
	{
		return estado;
	}

	public void setEstado(String estado) 
	{
		this.estado = estado;
	}

	public String getModelo() 
	{
		return modelo;
	}

	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}

	public String getMarca() 
	{
		return marca;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

	public String getTarKmLivre() 
	{
		return tarKmLivre;
	}

	public void setTarKmLivre(String tarKmLivre) 
	{
		this.tarKmLivre = tarKmLivre;
	}

	public String getTarKmControlado() 
	{
		return tarKmControlado;
	}

	public void setTarKmControlado(String tarKmControlado) 
	{
		this.tarKmControlado = tarKmControlado;
	}

	public int getDisponivel() 
	{
		return disponivel;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setDisponivel(int disponivel) 
	{
		this.disponivel = disponivel;
	}


	
	public boolean consultaPlaca(String placa) throws Exception
	{
		boolean existe = false;
		VeiculoDao p = new VeiculoDao();
		if(p.consultaPlaca(placa).equals(placa))
		{
			existe = true;
		}
		return existe;
	}

}

