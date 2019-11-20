package models;

public class ExameDto {
	
	private long id_Exame;
	private String dt_Exame;
	private String nm_Paciente;
	private String nm_Medico;
	
	//Getters e Setters
	public long getId_Exame() {
		return id_Exame;
	}
	public void setId_Exame(long id_Exame) {
		this.id_Exame = id_Exame;
	}
	public String getDt_Exame() {
		return dt_Exame;
	}
	public void setDt_Exame(String dt_Exame) {
		this.dt_Exame = dt_Exame;
	}
	public String getNm_Paciente() {
		return nm_Paciente;
	}
	public void setNm_Paciente(String nm_Paciente) {
		this.nm_Paciente = nm_Paciente;
	}
	public String getNm_Medico() {
		return nm_Medico;
	}
	public void setNm_Medico(String nm_Medico) {
		this.nm_Medico = nm_Medico;
	}
	
	
}
