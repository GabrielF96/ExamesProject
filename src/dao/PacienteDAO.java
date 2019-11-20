package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.JdbcConnection;
import models.Paciente;

public class PacienteDAO {

	private JdbcConnection jdbcConnection;
	private Connection conexao;
	private List<Paciente> pacientes;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	private Paciente paciente;
	
	public PacienteDAO() { }
	
	public PacienteDAO(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
	public List<Paciente> getAll(){
		
		sql = "select id_Paciente, nm_Paciente from Paciente;";
		conexao = jdbcConnection.connect();
		
		try {
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			pacientes = new ArrayList<Paciente>();
			
			while(rs.next()) {
				
				paciente = new Paciente();
				
				paciente.setId_Paciente(rs.getLong("id_Paciente"));
				paciente.setNm_Paciente(rs.getString("nm_Paciente"));
				
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível fazer a consulta! (Pacientes)");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pacientes;
	}
}
