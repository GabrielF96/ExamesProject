package webService;

import models.Exame;

public class ExameImplWS {
	
	ExameWS examews = new ExameWS();
	
	public Exame getObjExame(long id) {
		
		Exame exame = examews.getExame(id);
		
		return exame;
	}
}
