package dao;

import model.Pais;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class PaisDAO {
	public static int criar(String nome, long populacao, double area) {
		String sqlInsert = "INSERT INTO pais(nomePais, populacaoPais, areaPais) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, nome);
			stm.setLong(2, populacao);
			stm.setDouble(3, area);
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					Pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Pais.getId();
	}
	public static void atualizar(int idPais, String nomePais, long populacaoPais, double areaPais) {
		String sqlUpdate = "UPDATE pais SET nomePais=?, populacaoPais=?, areaPais=? WHERE idPais=?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, nomePais);
			stm.setLong(2, populacaoPais);
			stm.setDouble(3, areaPais);
			stm.setInt(4, idPais);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void excluir(int idPais) {
		String sqlDelete = "DELETE FROM pais WHERE idPais = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, idPais);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Pais carregar(int idPais) {
		Pais pais = null;
		String sqlSelect = "SELECT nomePais, populacaoPais, areaPais FROM pais WHERE idPais = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idPais);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					String nome = (rs.getString("nomePais"));
					Long populacao = (rs.getLong("populacaoPais"));
					Double area = (rs.getDouble("areaPais"));
					pais = new Pais(nome, populacao, area);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList buscaPaisMaisHab() {
		ArrayList buscaHabi = new ArrayList();
		String sqlSelect = "select * from pais order by populacaoPais desc limit 1";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					buscaHabi.add(rs.getString("nomePais"));
					buscaHabi.add(rs.getString("populacaoPais"));
					buscaHabi.add(rs.getString("areaPais"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return buscaHabi;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList buscaPaisMenor() {
		ArrayList buscaArea = new ArrayList();
		String sqlSelect = "select * from pais order by areaPais asc limit 1";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					buscaArea.add(rs.getString("nomePais"));
					buscaArea.add(rs.getString("populacaoPais"));
					buscaArea.add(rs.getString("areaPais"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return buscaArea;
	}

	public static Pais[] Vetor() {
		Pais pais = null;
		Pais[] vetor = new Pais[3];
		int count = 0;
		String sqlSelect = "SELECT idPais, nomePais, populacaoPais, areaPais FROM pais limit 3";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					String nome = rs.getString("nomePais");
					Long populacao = rs.getLong("populacaoPais");
					Double area = rs.getDouble("areaPais");
					pais = new Pais(nome, populacao, area);
					vetor[count++] = pais;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return vetor;
	}
}
