package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.VeiculoDao;
import to.Veiculo;


//Essa anotação serve para identificar o servlet 
// para as paginas jsps e assim poder chamar as métodos
// doPost e doGet
@WebServlet("/ControleVeiculo")  //Anotação do Servlet 3.0
public class ControleVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleVeiculo() {
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

	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String grupo = request.getParameter("grupo");
		String chassi = request.getParameter("chassi");
	    String placa = request.getParameter("placa");
		String cidade = request.getParameter("cidade");
		String km = request.getParameter("km");
		String estado = request.getParameter("estado");
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String tarkmlivre = request.getParameter("tarkmlivre");
		String tarkmcontrolado = request.getParameter("tarkmcontrolado");
		Integer disponivel =new Integer(request.getParameter("disponivel"));
		
		
		Veiculo v= new Veiculo();
		v.setGrupo(grupo);
		v.setChassi(chassi);
	
		v.setPlaca(placa);
		v.setCidade(cidade);
		v.setKm(km);
		v.setEstado(estado);
		v.setModelo(modelo);
		v.setMarca(marca);
		v.setTarKmLivre(tarkmlivre);
		v.setTarKmControlado(tarkmcontrolado);
		v.setDisponivel(disponivel);
		
			try {
				
				new VeiculoDao().create(v);
				// Comando para enviar uma msg para pagina jsp
				request.setAttribute("msg", "Dados Gravados");
				
			} catch (Exception e) {
			request.setAttribute("msg", "Error" + e.getMessage());
			}
			finally{
			//Comando para redirecionar para pagina jsp de resposta			
			request.getRequestDispatcher("sistemaveiculo.jsp").forward(request, response);
			}		
	}
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod = new Integer(request.getParameter("cod"));
		
		try {
			
			Veiculo vei = new VeiculoDao().findByCode(cod);
			
			request.setAttribute("Veiculo", vei);
			request.getRequestDispatcher("alteraveiculo.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistemaveiculo.jsp").forward(request, response);
		}		
	}
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer cod = new Integer(request.getParameter("cod"));
		String grupo = request.getParameter("grupo");
		String chassi = request.getParameter("chassi");
	    String placa = request.getParameter("placa");
		String cidade = request.getParameter("cidade");
		String km = request.getParameter("km");
		String estado = request.getParameter("estado");
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String tarkmlivre = request.getParameter("tarkmlivre");
		String tarkmcontrolado = request.getParameter("tarkmcontrolado");
		Integer disponivel =new Integer(request.getParameter("disponivel"));
		
		Veiculo v= new Veiculo();
		v.setId(cod);
		v.setGrupo(grupo);
		v.setChassi(chassi);
        v.setPlaca(placa);
		v.setCidade(cidade);
		v.setKm(km);
		v.setEstado(estado);
		v.setModelo(modelo);
		v.setMarca(marca);
		v.setTarKmLivre(tarkmlivre);
		v.setTarKmControlado(tarkmcontrolado);
		v.setDisponivel(disponivel);
			try {
				
				new VeiculoDao().update(v);
				
				request.setAttribute("msg", "Dados Alterados");
				request.getRequestDispatcher("listaveiculo.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("msg", "Error" + e.getMessage());
				request.getRequestDispatcher("sistemaveiculo.jsp").forward(request, response);
			}		
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = new Integer(request.getParameter("cod"));
		
		try {
			
			new VeiculoDao().delete(cod);
			
			request.setAttribute("msg", "Dados Excluídos");
			request.getRequestDispatcher("listaveiculo.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistemaveiculo.jsp").forward(request, response);
		}		
	}	
}