package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.JdbcConnection;
import models.Exame;
import models.ExameDto;
import models.PerfilExameDto;

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
			System.out.println("Não possível fazer a inserção no banco!");
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
				" diabetes=?, doenca_mental=?, epilepsia=?, hernia=?, cancer=?, alergias=?, outras_doencas=?, medicamentos=?, doencas_familiares=? where id_Exame=?";
		
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
			ps.setLong(17, exame.getId());
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar a atualização!");
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
	
	public List<ExameDto> getAll(){
		
		List<ExameDto> examesDto = null;
		ExameDto exame;
		String sql = "select e.id_Exame, e.dt_Exame, paciente.nm_Paciente, medico.nm_medico from Exame e, (select p.id_paciente, p.nm_paciente from paciente p) as paciente, (select m.id_medico, m.nm_medico from medico m) as medico "
				+ "where e.id_paciente = paciente.id_paciente and e.id_medico = medico.id_medico;";
		
		conexao = jdbcConnection.connect();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			
			examesDto = new ArrayList<ExameDto>();
			
			while(rs.next()) {
				
				exame = new ExameDto();
				
				exame.setId_Exame(rs.getLong("id_Exame"));
				exame.setDt_Exame(rs.getString("dt_Exame"));
				exame.setNm_Medico(rs.getString("nm_Medico"));
				exame.setNm_Paciente(rs.getString("nm_Paciente"));
				
				examesDto.add(exame);
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível completar essa consulta!");
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
		
		return examesDto; 
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
			
			while(rs.next()) {
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
			}

		} catch (SQLException e) {
			System.out.println("Não possível realizar a consulta!");
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
	
	public PerfilExameDto getPerfilExame(long id) {
		
		PerfilExameDto perfilExame = null;
		String sql = "select e.*, e.dt_Exame, paciente.nm_Paciente, medico.nm_medico from Exame e, (select p.id_paciente, p.nm_paciente from paciente p) as paciente, (select m.id_medico, m.nm_medico from medico m) as medico where e.id_paciente = paciente.id_paciente and e.id_medico = medico.id_medico and e.id_exame=?;";
		
		conexao = jdbcConnection.connect();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				perfilExame = new PerfilExameDto();
				perfilExame.setId_Exame(rs.getLong("e.id_Exame"));
				perfilExame.setNm_Medico(rs.getString("medico.nm_Medico"));
				perfilExame.setNm_Paciente(rs.getString("paciente.nm_Paciente"));
				perfilExame.setDt_Exame(rs.getString("e.dt_Exame"));
				perfilExame.setTp_Sanguineo(rs.getString("e.tp_Sanguineo"));
				perfilExame.setReumatismo(rs.getBoolean("e.reumatismo"));
				perfilExame.setDoenca_cardiaca(rs.getBoolean("e.doenca_cardiaca"));
				perfilExame.setPressao_alta(rs.getBoolean("e.pressao_alta"));
				perfilExame.setDiabetes(rs.getBoolean("e.diabetes"));
				perfilExame.setDoenca_mental(rs.getBoolean("e.doenca_mental"));
				perfilExame.setEpilepsia(rs.getBoolean("e.epilepsia"));
				perfilExame.setHernia(rs.getBoolean("e.hernia"));
				perfilExame.setCancer(rs.getString("e.cancer"));
				perfilExame.setAlergias(rs.getString("e.alergias"));
				perfilExame.setOutras_doencas(rs.getString("e.outras_doencas"));
				perfilExame.setMedicamentos(rs.getString("e.medicamentos"));
				perfilExame.setDoencas_familiares(rs.getString("e.doencas_familiares"));
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível fazer a consulta!");
			e.printStackTrace();
		}finally {
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
		
		return perfilExame;
	}
	
	public void deleteExame(Long id) {
		
		String sql = "delete from exame where id_exame = ?";
		PreparedStatement ps = null;
		
		conexao = jdbcConnection.connect();
		
		try {
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível remover!");
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
