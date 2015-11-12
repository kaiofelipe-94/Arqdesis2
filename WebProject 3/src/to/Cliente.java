package to;
import persistence.ClienteDao;

public class Cliente
{
	private int id;
	private String cpf;
	private String nome;
	private String rg;
	private String email;
	private String telefone;
	private String datNasc;
	private String genero;
	private String estEmissor;
	private String validadeCarteira;
	/*private final DateFormat FORMATTER = new SimpleDateFormat("dd/mm/yyyy");
	private Calendar cal = GregorianCalendar.getInstance();
	@SuppressWarnings("deprecation")
	private final Date regra = new Date((cal.get(Calendar.YEAR)-2), 01, 01), 
		atual = new Date((cal.get(Calendar.YEAR)-21), 01, 01);*/;

		public Cliente() {
			// TODO Auto-generated constructor stub
		}

	public Cliente(int id, String nome, String cpf, String email, String datNasc,
			String genero, String estEmissor, String validadeCarteira, String telefone, String rg)
	{
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.datNasc = datNasc;
		this.genero = genero;
		this.estEmissor = estEmissor;
		this.validadeCarteira = validadeCarteira;
		this.rg = rg;
	}

	public String getNome()
	{
		return nome;
	}

	public String getCpf()
	{
		return cpf;
	}

	public String getEmail()
	{
		return email;
	}

	public String getDatNasc()
	{
		return datNasc;
	}

	public String getGenero()
	{
		String genero = "";
		genero += this.genero;
		return genero;
	}

	public String getEstEmissor()
	{
		return estEmissor;
	}

	public String getValidadeCarteira()
	{
		return validadeCarteira;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public void setDatNasc(String datNasc)
	{
		this.datNasc = datNasc;
	}

	public void setGenero(String genero)
	{
		this.genero = genero;
	}

	public void setEstEmissor(String estEmissor)
	{
		this.estEmissor = estEmissor;
	}

	public void setValidadeCarteira(String validadeCarteira)
	{
		this.validadeCarteira = validadeCarteira;
	}
	
	public boolean consultaCpf(String cpf) throws Exception
	{
		boolean existe = false;
		ClienteDao p = new ClienteDao();
		if(p.consultaCpf(cpf).equals(cpf))
		{
			existe = true;
		}
		return existe;
	}


	
	public boolean verificaIdadeCliente(String datNasc)
	{
		boolean resposta = true;
		String inv = "";
		String comp = "";
		String nasc = "";
		nasc = datNasc.replace("/", "");
		inv = nasc.substring(4, 8) + nasc.substring(2, 4) + nasc.substring(0, 2);
		comp += (2014 - 21) + nasc.substring(2, 4) + nasc.substring(0, 2);

		if(inv.compareTo(comp) > 0) resposta = false;
		
		return resposta;
	}

	
}
