package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.JdbcConnection;
import models.Exame;

public class ExamesDAO {
	
	private JdbcConnection jdbcConnection;
	private Connection conexao;
	
	public ExamesDAO() { }
	
	public ExamesDAO(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
	public void save(Exame exame) {
		conexao = jdbcConnection.connect();
		
		String sql = "insert into exame(id_Medico, id_Paciente, dt_Exame, tp_Sanguineo, reumatismo, doenca_cardiaca, pressao_alta,"
				+ " diabetes, doenca_mental, epilepsia, hernia, cancer, alergias, outras_doencas, medicamentos, doencas_familiares) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		PreparedStatement ps = null;
		
		try {
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, exame.getId_Medico());
			ps.setLong(2, exame.getId_Paciente());
			ps.setString(3, exame.getDt_Exame());
			ps.setString(4, exame.getTp_Sanguineo());
			ps.setBoolean(5, exame.isReumatismo());
			ps.setBoolean(6, exame.isDoenca_cardiaca());
			ps.setBoolean(7, exame.isPressao_alta());
			ps.setBoolean(8, exame.isDiabetes());
			ps.setBoolean(9, exame.isDoenca_mental());
			ps.setBoolean(10, exame.isEpilepsia());
			ps.setBoolean(11, exame.isHernia());
			ps.setString(12, exame.getCancer());
			ps.setString(13, exame.getAlergias());
			ps.setString(14, exame.getOutras_doencas());
			ps.setString(15, exame.getMedicamentos());
			ps.setString(16, exame.getDoencas_familiares());
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("N�o poss�vel fazer a inser��o no banco!");
			e.printStackTrace();
		} finally {
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
	}
	
	public void updateExame(Exame exame) {
		
		String sql = "update exame set id_Medico=?, id_Paciente=?, dt_Exame=?, tp_Sanguineo=?, reumatismo=?, doenca_cardiaca=?, pressao_alta=?," + 
				"+ diabetes=?, doenca_mental=?, epilepsia=?, hernia=?, cancer=?, alergias=?, outras_doencas=?, medicamentos=?, doencas_familiares=? where id_Exame=?";
		
		conexao = jdbcConnection.connect();
		
		PreparedStatement ps = null;
		
		try {
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, exame.getId_Medico());
			ps.setLong(2, exame.getId_Paciente());
			ps.setString(3, exame.getDt_Exame());
			ps.setString(4, exame.getTp_Sanguineo());
			ps.setBoolean(5, exame.isReumatismo());
			ps.setBoolean(6, exame.isDoenca_cardiaca());
			ps.setBoolean(7, exame.isPressao_alta());
			ps.setBoolean(8, exame.isDiabetes());
			ps.setBoolean(9, exame.isDoenca_mental());
			ps.setBoolean(10, exame.isEpilepsia());
			ps.setBoolean(11, exame.isHernia());
			ps.setString(12, exame.getCancer());
			ps.setString(13, exame.getAlergias());
			ps.setString(14, exame.getOutras_doencas());
			ps.setString(15, exame.getMedicamentos());
			ps.setString(16, exame.getDoencas_familiares());
			ps.setLong(16, exame.getId());
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel realizar a atualiza��o!");
			e.printStackTrace();
		} finally {
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
	}
	
	public List<Exame> getAll(){
		
		ArrayList<Exame> exames = null;
		Exame exame;
		String sql = "select * from exames";
		
		conexao = jdbcConnection.connect();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			
			exames = new ArrayList<Exame>();
			exame = new Exame();
			
			while(rs.next()) {
				exame.setId(rs.getLong("id_Exame"));
				exame.setId_Medico(rs.getLong("id_Medico"));
				exame.setId_Paciente(rs.getLong("id_Paciente"));
				exame.setDt_Exame(rs.getString("dt_Exame"));
				exame.setTp_Sanguineo(rs.getString("tp_Sanguineo"));
				exame.setReumatismo(rs.getBoolean("reumatismo"));
				exame.setDoenca_cardiaca(rs.getBoolean("doenca_cardiaca"));
				exame.setPressao_alta(rs.getBoolean("pressao_alta"));
				exame.setDiabetes(rs.getBoolean("diabetes"));
				exame.setDoenca_mental(rs.getBoolean("doenca_mental"));
				exame.setEpilepsia(rs.getBoolean("epilepsia"));
				exame.setHernia(rs.getBoolean("hernia"));
				exame.setCancer(rs.getString("cancer"));
				exame.setAlergias(rs.getString("alergias"));
				exame.setOutras_doencas(rs.getString("outras_doencas"));
				exame.setMedicamentos(rs.getString("medicamentos"));
				exame.setDoencas_familiares(rs.getString("doencas_familiares"));
				
				exames.add(exame);
			}
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel completar essa consulta!");
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
		
		return exames; 
	}
	
	public Exame getExame(Long id) {
		
		Exame exame = null;
		String sql = "select * from exame where id_Exame = ?";
		
		conexao = jdbcConnection.connect();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			exame = new Exame();
			exame.setId(rs.getLong("id_Exame"));
			exame.setId_Medico(rs.getLong("id_Medico"));
			exame.setId_Paciente(rs.getLong("id_Paciente"));
			exame.setDt_Exame(rs.getString("dt_Exame"));
			exame.setTp_Sanguineo(rs.getString("tp_Sanguineo"));
			exame.setReumatismo(rs.getBoolean("reumatismo"));
			exame.setDoenca_cardiaca(rs.getBoolean("doenca_cardiaca"));
			exame.setPressao_alta(rs.getBoolean("pressao_alta"));
			exame.setDiabetes(rs.getBoolean("diabetes"));
			exame.setDoenca_mental(rs.getBoolean("doenca_mental"));
			exame.setEpilepsia(rs.getBoolean("epilepsia"));
			exame.setHernia(rs.getBoolean("hernia"));
			exame.setCancer(rs.getString("cancer"));
			exame.setAlergias(rs.getString("alergias"));
			exame.setOutras_doencas(rs.getString("outras_doencas"));
			exame.setMedicamentos(rs.getString("medicamentos"));
			exame.setDoencas_familiares(rs.getString("doencas_familiares"));

		} catch (SQLException e) {
			System.out.println("N�o poss�vel realizar a consulta!");
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
		
		return exame;
	}
	
	public void deleteExame(Long id) {
		
		String sql = "delete from exame where ?";
		PreparedStatement ps = null;
		
		conexao = jdbcConnection.connect();
		
		try {
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel remover!");
			e.printStackTrace();
		} finally {
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
	}
}
