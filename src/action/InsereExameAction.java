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
		exame = new Exame();
		
		exame.setId_Medico(Long.parseLong(request.getParameter("id_Medico")));
		exame.setId_Paciente(Long.parseLong(request.getParameter("id_Paciente")));
		exame.setDt_Exame(request.getParameter("dt_Exame"));
		exame.setTp_Sanguineo(request.getParameter("tp_Sanguineo"));
		exame.setReumatismo(Boolean.parseBoolean(request.getParameter("reumatismo")));
		exame.setDoenca_cardiaca(Boolean.parseBoolean(request.getParameter("doenca_cardiaca")));
		exame.setPressao_alta(Boolean.parseBoolean(request.getParameter("pressao_alta")));
		exame.setDiabetes(Boolean.parseBoolean(request.getParameter("diabetes")));
		exame.setDoenca_mental(Boolean.parseBoolean(request.getParameter("doenca_mental")));
		exame.setEpilepsia(Boolean.parseBoolean(request.getParameter("epilepsia")));
		exame.setHernia(Boolean.parseBoolean(request.getParameter("hernia")));
		exame.setCancer(request.getParameter("cancer"));
		exame.setAlergias(request.getParameter("alergias"));
		exame.setOutras_doencas(request.getParameter("outras_doencas"));
		exame.setMedicamentos(request.getParameter("medicamentos"));
		exame.setDoencas_familiares(request.getParameter("doencas_familiares"));
		
		if(request.getParameter("btnCadastrar").equalsIgnoreCase("Cadastrar")) {
			examesDAO.save(exame);
		} else if(request.getParameter("btnCadastrar").equalsIgnoreCase("Editar")){
			exame.setId(Long.parseLong(request.getParameter("id_Exame")));
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
