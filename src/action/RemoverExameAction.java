package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;

public class RemoverExameAction extends ActionSupport{

	private ExamesDAO examesDAO;
	private long id;
	
	public RemoverExameAction(ExamesDAO examesDAO) {
		this.examesDAO = examesDAO;
	}
	
	public String execute() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		id = Long.parseLong(request.getParameter("id"));
		examesDAO.deleteExame(id);
		
		return SUCCESS;
	}
}
