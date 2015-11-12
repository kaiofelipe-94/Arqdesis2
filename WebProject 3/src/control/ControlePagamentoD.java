package control;


import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

import persistence.PagamentoDao;  
@WebServlet("/ControlePagamentoD")  //Anotação do Servlet 3.0
public class ControlePagamentoD extends HttpServlet{  
	private static final long serialVersionUID = 1L;
    
    public ControlePagamentoD() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String cmd = request.getParameter("cmd");
		
		/*if(cmd.equalsIgnoreCase("buscar")){
			buscar(request,response);
		}
		
		if(cmd.equalsIgnoreCase("excluir")){
			excluir(request,response);
		}	*/	
	}
	
  public void doPost(HttpServletRequest request, HttpServletResponse response)    
          throws ServletException, IOException {    
	  PagamentoDao cc = new PagamentoDao();
      response.setContentType("text/html");    
      PrintWriter out = response.getWriter();    
        
      String n=request.getParameter("banco");    
      String p=request.getParameter("agencia");   
      String f=request.getParameter("conta");    
      String g=request.getParameter("cpf");   

      HttpSession session = request.getSession(false);  
      if(session!=null)  
      session.setAttribute("name", n);  
      
      try {
		if (cc.validateD(n,p,f,g)){    
			RequestDispatcher rd=request.getRequestDispatcher("pagamentosucesso.jsp");    
            rd.forward(request,response);       
		  }    
		  else{    
		      out.print("<p style=\"color:red\">Pagamento não aceito</p>");    
		      RequestDispatcher rd=request.getRequestDispatcher("pagamentodebito.jsp");    
		      rd.include(request,response);    
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    

      out.close();    
  }    
}   