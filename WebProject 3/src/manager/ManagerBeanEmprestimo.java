package manager;

import java.util.ArrayList;
import java.util.List;
import persistence.ClienteDao;
import to.Cliente;
import to.Emprestimo;
import persistence.EmprestimoDao;
import persistence.VeiculoDao;

public class ManagerBeanEmprestimo {
	
	private List lista;
	

	public List getLista() {
		
		try {			
			lista = new ArrayList<>();
			lista = new EmprestimoDao().findAll();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}	
	
	
	

	
	
	
	
}