package manager; 

import java.util.ArrayList;
import java.util.List;

import persistence.VeiculoDao;



public class ManagerBeanVeiculo {
	
	private List lista;
	

	public List getLista() {
		
		try {			
			lista = new ArrayList<>();
			lista = new VeiculoDao().findAll();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}	
	
	
	

	
	
	
	
}