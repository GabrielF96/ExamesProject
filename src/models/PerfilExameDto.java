package models;

public class PerfilExameDto {

	private long id_Exame;
	private String nm_Medico;
	private String nm_Paciente;
	private String dt_Exame;
	private String tp_Sanguineo;
	private boolean reumatismo;
	private boolean doenca_cardiaca;
	private boolean pressao_alta;
	private boolean diabetes;
	private boolean doenca_mental;
	private boolean epilepsia;
	private boolean hernia;
	private String cancer;
	private String alergias;
	private String outras_doencas;
	private String medicamentos;
	private String doencas_familiares;
	
	
	public long getId_Exame() {
		return id_Exame;
	}
	public void setId_Exame(long id_Exame) {
		this.id_Exame = id_Exame;
	}
	public String getNm_Medico() {
		return nm_Medico;
	}
	public void setNm_Medico(String nm_Medico) {
		this.nm_Medico = nm_Medico;
	}
	public String getNm_Paciente() {
		return nm_Paciente;
	}
	public void setNm_Paciente(String nm_Paciente) {
		this.nm_Paciente = nm_Paciente;
	}
	public String getDt_Exame() {
		return dt_Exame;
	}
	public void setDt_Exame(String dt_Exame) {
		this.dt_Exame = dt_Exame;
	}
	public String getTp_Sanguineo() {
		return tp_Sanguineo;
	}
	public void setTp_Sanguineo(String tp_Sanguineo) {
		this.tp_Sanguineo = tp_Sanguineo;
	}
	public boolean isReumatismo() {
		return reumatismo;
	}
	public void setReumatismo(boolean reumatismo) {
		this.reumatismo = reumatismo;
	}
	public boolean isDoenca_cardiaca() {
		return doenca_cardiaca;
	}
	public void setDoenca_cardiaca(boolean doenca_cardiaca) {
		this.doenca_cardiaca = doenca_cardiaca;
	}
	public boolean isPressao_alta() {
		return pressao_alta;
	}
	public void setPressao_alta(boolean pressao_alta) {
		this.pressao_alta = pressao_alta;
	}
	public boolean isDiabetes() {
		return diabetes;
	}
	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}
	public boolean isDoenca_mental() {
		return doenca_mental;
	}
	public void setDoenca_mental(boolean doenca_mental) {
		this.doenca_mental = doenca_mental;
	}
	public boolean isEpilepsia() {
		return epilepsia;
	}
	public void setEpilepsia(boolean epilepsia) {
		this.epilepsia = epilepsia;
	}
	public boolean isHernia() {
		return hernia;
	}
	public void setHernia(boolean hernia) {
		this.hernia = hernia;
	}
	public String getCancer() {
		return cancer;
	}
	public void setCancer(String cancer) {
		this.cancer = cancer;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getOutras_doencas() {
		return outras_doencas;
	}
	public void setOutras_doencas(String outras_doencas) {
		this.outras_doencas = outras_doencas;
	}
	public String getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	public String getDoencas_familiares() {
		return doencas_familiares;
	}
	public void setDoencas_familiares(String doencas_familiares) {
		this.doencas_familiares = doencas_familiares;
	}
	
}
