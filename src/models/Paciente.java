package models;

public class Paciente implements Comparable<Paciente>{
	
	private long id_Paciente;
	private String nm_Paciente;

	//Getters e Setters
	public long getId_Paciente() {
		return id_Paciente;
	}
	public void setId_Paciente(long id_Paciente) {
		this.id_Paciente = id_Paciente;
	}
	public String getNm_Paciente() {
		return nm_Paciente;
	}
	public void setNm_Paciente(String nm_Paciente) {
		this.nm_Paciente = nm_Paciente;
	}
	
	@Override
	public int compareTo(Paciente o) {
		if(this.nm_Paciente.compareTo(o.getNm_Paciente())>0){
			return -1;
		} else if(this.nm_Paciente.compareTo(o.getNm_Paciente())<0){
			return 1;
		} else {
			return 0;
		}
	}
}
