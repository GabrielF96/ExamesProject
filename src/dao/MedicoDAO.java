package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.JdbcConnection;
import models.Medico;

public class MedicoDAO {
	
	private JdbcConnection jdbcConnection;
	private Connection conexao;
	private String sql;
	private List<Medico> medicos;
	private PreparedStatement ps;
	private ResultSet rs;
	private Medico medico;
	
	public MedicoDAO() { }
	
	public MedicoDAO(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
	public List<Medico> getAll(){
		
		conexao = jdbcConnection.connect();
		sql = "select id_Medico, nm_Medico from Medico;";
		
		try {
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			medicos = new ArrayList<Medico>();
			
			while(rs.next()) {
				medico = new Medico();
				
				medico.setId_Medico(rs.getLong("id_Medico"));
				medico.setNm_Medico(rs.getString("nm_Medico"));
				
				medicos.add(medico);
			}
			
		} catch (SQLException e) {
			System.out.println("Não foi possível fazer a consulta! (Médicos)");
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
		
		return medicos;
	}
}
