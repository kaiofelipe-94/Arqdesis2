package to;

import persistence.EmprestimoDao;

public class Emprestimo
{
	private int id;
	private int idCliente;
	private int idVeiculo;
	private String cpf;
	private String placa;
	private String dataEmp;
	private String dataDev;
	private String localEmp;
	private String localDev;
	private String tipoTarifa;
	private double valor;
	private String acessorios;
	private int ativo;
	
	public Emprestimo()
	{
		
	}
	
	

	public int getId()
	{
		return id;
	}
	
	public int getIdCliente()
	{
		return idCliente;
	}
	
	public int getIdVeiculo()
	{
		return idVeiculo;
	}

	public String getCpf()
	{
		return cpf;
	}

	public String getPlaca()
	{
		return placa;
	}
	
	public int getAtivo()
	{ return ativo; }
	
	public void setAtivo(int ativo)
	{this.ativo = ativo;}

	public String getDataEmp()
	{
		return dataEmp;
	}

	public String getDataDev()
	{
		return dataDev;
	}

	public String getTipoTarifa()
	{
		return tipoTarifa;
	}

	public double getValor()
	{
		return valor;
	}

	public String getAcessorios()
	{
		return acessorios;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}
	
	public void setIdVeiculo(int idVeiculo)
	{
		this.idVeiculo = idVeiculo;
	}
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public void setPlaca(String placa)
	{
		this.placa = placa;
	}

	public void setDataEmp(String dataEmp)
	{
		this.dataEmp = dataEmp;
	}

	public void setDataDev(String dataDev)
	{
		this.dataDev = dataDev;
	}

	public void setTipoTarifa(String tipoTarifa)
	{
		
		this.tipoTarifa = tipoTarifa;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}

	public void setAcessorios(String acessorios)
	{
		this.acessorios = acessorios;
	}
	
	public String getLocalEmp()
	{
		return localEmp;
	}

	public String getLocalDev()
	{
		return localDev;
	}

	public void setLocalEmp(String localEmp)
	{
		this.localEmp = localEmp;
	}

	public void setLocalDev(String localDev)
	{
		this.localDev = localDev;
	}


}
