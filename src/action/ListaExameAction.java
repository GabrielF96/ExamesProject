package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;
import models.ExameDto;


public class ListaExameAction extends ActionSupport{

	private ExamesDAO examesDAO;
	private List<ExameDto> listaExames;
	
	public ListaExameAction(ExamesDAO examesDAO) {
		this.examesDAO = examesDAO;
	}
	
	public String execute() {
		
		listaExames = examesDAO.getAll();
		
		return SUCCESS;
	}
	
	public List<ExameDto> getListaExames() {
		return listaExames;
	}

	public void setListaExames(List<ExameDto> listaExames) {
		this.listaExames = listaExames;
	}
	
	
}
