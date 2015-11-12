package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ClienteDao;
import to.Cliente;
import persistence.VeiculoDao;
import to.Veiculo;
import persistence.EmprestimoDao;
import to.Emprestimo;


//Essa anotação serve para identificar o servlet 
// para as paginas jsps e assim poder chamar as métodos
// doPost e doGet
@WebServlet("/ControleEmprestimo")  //Anotação do Servlet 3.0
public class ControleEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleEmprestimo() {
        super();
    }

	// doGet -> São requisições das paginas jsps enviadas por link
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cmd = request.getParameter("cmd");
		
		if(cmd.equalsIgnoreCase("buscar")){
			buscar(request,response);
		}
		
		
		
		/*if(cmd.equalsIgnoreCase("excluir")){
			excluir(request,response);
		}	*/
	}
	
	// doPost -> São requisições das paginas jsps enviadas por formulario  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// comando para resgatar um valor da pagina JSP
		String cmd = request.getParameter("cmd");
		
			if(cmd.equalsIgnoreCase("gravar")){
				gravar(request,response);
			}
			
			/*if(cmd.equalsIgnoreCase("alterar")){
				alterar(request,response);
			}	*/
	}

	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cpf =  request.getParameter("cpf");
		String placa = request.getParameter("placa");
		String dataEmp = request.getParameter("dataEmp");
		String dataDev = request.getParameter("dataDev");
		String localEmp = request.getParameter("localEmp");
		String localDev = request.getParameter("localDev");
		String tipoTarifa = request.getParameter("tipoTarifa");
		int valor = new Integer(request.getParameter("valor"));
		String acessorios = request.getParameter("acessorios");
		
		
		Emprestimo em = new Emprestimo();
		em.setCpf(cpf);
		em.setPlaca(placa);
		em.setDataEmp(dataEmp);
		em.setDataDev(dataDev);
		em.setLocalEmp(localEmp);
		em.setLocalDev(localDev);
		em.setTipoTarifa(tipoTarifa);
		em.setValor(valor);
		em.setAcessorios(acessorios);
		
		
			try {
				
				new EmprestimoDao().realizarEmprestimo(em,cpf,placa);
			    new EmprestimoDao().setIndisp(placa);
				// Comando para enviar uma msg para pagina jsp
				request.setAttribute("msg", "Dados Gravados");
				
			} catch (Exception e) {
			request.setAttribute("msg", "Error" + e.getMessage());
			}
			finally{
			//Comando para redirecionar para pagina jsp de resposta			
			request.getRequestDispatcher("sistemaemprestimo.jsp").forward(request, response);
			}		
	}
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod = new Integer(request.getParameter("cod"));
		
		try {
			
			Emprestimo em = new EmprestimoDao().findByCode(cod);
			
			request.setAttribute("emprestimo", em);
			request.getRequestDispatcher("alteraemprestimo.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistemaemprestimo.jsp").forward(request, response);
		}		
	}
}