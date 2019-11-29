package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import models.Exame;
import models.Medico;
import models.Paciente;

public class InsereExameAction extends ActionSupport{

	private ExamesDAO examesDAO;
	private MedicoDAO medicosDAO;
	private PacienteDAO pacientesDAO;
	private List<Medico> listaMedicos;
	private List<Paciente> listaPacientes;
	private Exame exame;
	
	public InsereExameAction(ExamesDAO examesDAO, MedicoDAO medicosDAO, PacienteDAO pacientesDAO) {
		this.examesDAO = examesDAO;
		this.medicosDAO = medicosDAO;
		this.pacientesDAO = pacientesDAO;
	}
	
	public String execute() {
		
		listaMedicos = medicosDAO.getAll();
		listaPacientes = pacientesDAO.getAll();
		setListaMedicos(listaMedicos);
		setListaPacientes(listaPacientes);
		
		return SUCCESS;
	}
	
	public String insereExame() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(request.getParameter("btnCadastrar").equalsIgnoreCase("Cadastrar")) {
			examesDAO.save(exame);
		} else if(request.getParameter("btnCadastrar").equalsIgnoreCase("Editar")){
			examesDAO.updateExame(exame);
		}
		
		return SUCCESS;
	}
	
	public String editarExame() {
		
		listaMedicos = medicosDAO.getAll();
		listaPacientes = pacientesDAO.getAll();
		Collections.sort(listaMedicos);
		Collections.sort(listaPacientes);
		setListaMedicos(listaMedicos);
		setListaPacientes(listaPacientes);
		HttpServletRequest request = ServletActionContext.getRequest();
		exame = examesDAO.getExame(Long.parseLong(request.getParameter("id")));
		
		return SUCCESS;	
	} 
	
	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	
	public Exame getExame() {
		return exame;
	}
	
	public void setExame(Exame exame) {
		this.exame = exame;
	}
}
