package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;
import models.PerfilExameDto;

public class ConsultaExameAction extends ActionSupport{
	
	private ExamesDAO examesDAO;
	private PerfilExameDto perfilExame;
	private long id;
	
	public ConsultaExameAction(ExamesDAO examesDAO) {
		this.examesDAO = examesDAO;
	}
	
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		
		id = Long.parseLong(request.getParameter("id"));
		perfilExame = examesDAO.getPerfilExame(id);

		return SUCCESS;
	}

	public PerfilExameDto getPerfilExame() {
		return perfilExame;
	}

	public void setPerfilExame(PerfilExameDto perfilExame) {
		this.perfilExame = perfilExame;
	}
	
}
