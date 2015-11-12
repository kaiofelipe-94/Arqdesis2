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

import persistence.LoginDao;  
@WebServlet("/ControleLogin")  //Anotação do Servlet 3.0
public class ControleLogin extends HttpServlet{  
	private static final long serialVersionUID = 1L;
    
    public ControleLogin() {
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
	  LoginDao cc = new LoginDao();
      response.setContentType("text/html");    
      PrintWriter out = response.getWriter();    
        
      String n=request.getParameter("username");    
      String p=request.getParameter("userpass");   
        
      HttpSession session = request.getSession(false);  
      if(session!=null)  
      session.setAttribute("name", n);  
      
      try {
		if (cc.validate(n, p)){    
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            rd.forward(request,response);       
		  }    
		  else{    
		      out.print("<p style=\"color:red\">Usuario ou senha incorreta.Tente de novamente</p>");    
		      RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
		      rd.include(request,response);    
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    

      out.close();    
  }    
}   