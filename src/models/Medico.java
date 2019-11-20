package models;

public class Medico implements Comparable<Medico>{

	private long id_Medico;
	private String nm_Medico;
	
	//Getters e Setters
	public long getId_Medico() {
		return id_Medico;
	}
	public void setId_Medico(long id_Medico) {
		this.id_Medico = id_Medico;
	}
	public String getNm_Medico() {
		return nm_Medico;
	}
	public void setNm_Medico(String nm_Medico) {
		this.nm_Medico = nm_Medico;
	}
	
	//Método para ordenar nome dos médicos
	@Override
	public int compareTo(Medico o) {
		if(this.nm_Medico.compareTo(o.getNm_Medico())>0){
			return -1;
		} else if(this.nm_Medico.compareTo(o.getNm_Medico())<0){
			return 1;
		} else {
			return 0;
		}
	}
	
}
