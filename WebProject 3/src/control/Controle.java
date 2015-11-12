package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ClienteDao;
import to.Cliente;


//Essa anotação serve para identificar o servlet 
// para as paginas jsps e assim poder chamar as métodos
// doPost e doGet
@WebServlet("/Controle")  //Anotação do Servlet 3.0
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controle() {
        super();
    }

	// doGet -> São requisições das paginas jsps enviadas por link
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cmd = request.getParameter("cmd");
		
		if(cmd.equalsIgnoreCase("buscar")){
			buscar(request,response);
		}
		
		if(cmd.equalsIgnoreCase("excluir")){
			excluir(request,response);
		}		
	}
	
	// doPost -> São requisições das paginas jsps enviadas por formulario  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// comando para resgatar um valor da pagina JSP
		String cmd = request.getParameter("cmd");
		
			if(cmd.equalsIgnoreCase("gravar")){
				gravar(request,response);
			}
			
			if(cmd.equalsIgnoreCase("alterar")){
				alterar(request,response);
			}	
	}

protected void buscarP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String buscaCpf = request.getParameter("buscaCpf");
		
		//if (busc == 1){	String cpf = request.getParameter("cpf");									}
		try {
			
			
			Cliente cli = new ClienteDao().consultaCpf(buscaCpf);
			
			request.setAttribute("cliente", cli);
			request.getRequestDispatcher("visualisacpf.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}		
}
	
	
	
	
	
	
	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf =  request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String estadoEmissorRG = request.getParameter("estadoEmissorRG");
		String validadeCarteira = request.getParameter("validadeCarteira");
		String datNasc = request.getParameter("datNasc");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		
		Cliente c = new Cliente();
		c.setCpf(cpf);
		c.setNome(nome);
		c.setRg(rg);
		c.setEstEmissor(estadoEmissorRG);
		c.setValidadeCarteira(validadeCarteira);
		c.setDatNasc(datNasc);
		c.setTelefone(telefone);
		c.setEmail(email);
		c.setGenero(genero);
		
		
		
			try {
				
				new ClienteDao().create(c);
				// Comando para enviar uma msg para pagina jsp
				request.setAttribute("msg", "Dados Gravados");
				
			} catch (Exception e) {
			request.setAttribute("msg", "Error" + e.getMessage());
			}
			finally{
			//Comando para redirecionar para pagina jsp de resposta			
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
			}		
	}
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod = new Integer(request.getParameter("cod"));
		
		try {
			
			Cliente cli = new ClienteDao().findByCode(cod);
			
			request.setAttribute("cliente", cli);
			request.getRequestDispatcher("altera.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}		
	}
	
	
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer cod = new Integer(request.getParameter("cod"));
		String nome = request.getParameter("nome");
		String cpf =  request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String estadoEmissorRG = request.getParameter("estadoEmissorRG");
		String validadeCarteira = request.getParameter("validadeCarteira");
		String datNasc = request.getParameter("datNasc");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		
		Cliente c= new Cliente();
		c.setId(cod);
		c.setCpf(cpf);
		c.setNome(nome);
		c.setRg(rg);
		c.setEstEmissor(estadoEmissorRG);
		c.setValidadeCarteira(validadeCarteira);
		c.setDatNasc(datNasc);
		c.setTelefone(telefone);
		c.setEmail(email);
		c.setGenero(genero);
		
			try {
				
				new ClienteDao().update(c);
				
				request.setAttribute("msg", "Dados Alterados");
				request.getRequestDispatcher("lista.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("msg", "Error" + e.getMessage());
				request.getRequestDispatcher("sistema.jsp").forward(request, response);
			}		
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod = new Integer(request.getParameter("cod"));
		
		try {
			
			new ClienteDao().delete(cod);
			
			request.setAttribute("msg", "Dados Excluídos");
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
		
		
	}}
	
	

	
	
	
	
