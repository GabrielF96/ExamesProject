package webService;

import dao.ExamesDAO;
import models.Exame;

public class ExameWS {
	
	private ExamesDAO examesDAO;
	private Exame exame;
		
	public ExameWS(){
		this.examesDAO = new ExamesDAO();
	}
	
	public Exame getExame(long id) {
		
		exame = examesDAO.getExame(id);
		
		return exame;
	}
}