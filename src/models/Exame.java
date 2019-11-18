package models;

public class Exame {
	
	private long id_Exame;
	private long id_Medico;
	private long id_Paciente;
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
	
	public Exame() {
		
	}
	
	public Exame(long id_Medico, long id_Paciente, String dt_Exame, String tp_Sanguineo,
			boolean reumatismo, boolean doenca_cardiaca, boolean pressao_alta, boolean diabetes, boolean doenca_mental,
			boolean epilepsia, boolean hernia, String cancer, String alergias, String outras_doencas,
			String medicamentos, String doencas_familiares) {
		
		this.id_Medico = id_Medico;
		this.id_Paciente = id_Paciente;
		this.dt_Exame = dt_Exame;
		this.tp_Sanguineo = tp_Sanguineo;
		this.reumatismo = reumatismo;
		this.doenca_cardiaca = doenca_cardiaca;
		this.pressao_alta = pressao_alta;
		this.diabetes = diabetes;
		this.doenca_mental = doenca_mental;
		this.epilepsia = epilepsia;
		this.hernia = hernia;
		this.cancer = cancer;
		this.alergias = alergias;
		this.outras_doencas = outras_doencas;
		this.medicamentos = medicamentos;
		this.doencas_familiares = doencas_familiares;
	}
	
	//getters e setters
	public long getId() {
		return id_Exame;
	}
	public void setId(long id_Exame) {
		this.id_Exame = id_Exame;
	}
	public long getId_Medico() {
		return id_Medico;
	}
	public void setId_Medico(long id_Medico) {
		this.id_Medico = id_Medico;
	}
	public long getId_Paciente() {
		return id_Paciente;
	}
	public void setId_Paciente(long id_Paciente) {
		this.id_Paciente = id_Paciente;
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
