package it.prova.dao.televisore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.Televisore;

public class TelevisoreDAOImpl extends AbstractMySQLDAO implements TelevisoreDAO {
	
	
	public void setConnection(Connection connection) {
		this.connection=connection;
		
	}
	
	// ------------------------------- METODO LIST ---------------------------
	public List list() throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");
		
		List<Televisore> result = new ArrayList<>();
		
		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from televisore")) {

			while (rs.next()) {
				Televisore temp = new Televisore();
				temp.setId(rs.getLong("id"));
				temp.setMarca(rs.getString("marca"));
				temp.setModello(rs.getString("modello"));
				temp.setPollici(rs.getInt("pollici"));
				temp.setDataProduzione(
						rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
				result.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	
	public Televisore get(Long idInput) throws Exception {
		
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		Televisore result = null;
		
		try (PreparedStatement ps = connection.prepareStatement("select * from televisore where id=?")) {
			ps.setLong(1, idInput);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Televisore();
					result.setMarca(rs.getString("marca"));
					result.setModello(rs.getString("modello"));
					result.setPollici(rs.getInt("pollici"));
					result.setDataProduzione(
							rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
					result.setId(rs.getLong("id"));
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	public int update(Televisore input) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		
		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE televisore SET marca=?, modello=?, pollici=?, dataproduzione=? where id=?;")) {
			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getPollici());
			ps.setDate(4, java.sql.Date.valueOf(input.getDataProduzione()));
			ps.setLong(5, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	public int insert(Televisore input) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO televisore (marca, modello, pollici, dataproduzione) VALUES (?, ?, ?, ?);")) {
			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getPollici());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(4, java.sql.Date.valueOf(input.getDataProduzione()));
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	public int delete(Televisore input) throws Exception {
		
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM televisore WHERE ID=?")) {
			
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	public Televisore WantTvBiggest() throws Exception{
		
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		Televisore result = null;
		try (Statement s = connection.createStatement()) {

			try (ResultSet rs = s
					.executeQuery("select * from televisore where pollici = (select max(pollici) from televisore)")) {
				if (rs.next()) {
					result = new Televisore();
					result.setId(rs.getLong("id"));
					result.setMarca(rs.getString("marca"));
					result.setModello(rs.getString("modello"));
					result.setPollici(rs.getInt("pollici"));
					result.setDataProduzione(
							rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}


	public int howManyTvMakeBetweenDate(LocalDate dataMin, LocalDate dataMax)throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (dataMin == null || dataMax == null)
			throw new Exception("Valore di input non ammesso.");

		int count = 0;
		Televisore temp = null;
		try (PreparedStatement ps = connection
				.prepareStatement("select * from televisore where dataproduzione between ? and ?")) {

			ps.setDate(1, java.sql.Date.valueOf(dataMin));
			ps.setDate(2, java.sql.Date.valueOf(dataMax));
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					count++;
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

	public List<String> wantBrandTvLastSixMonths()throws Exception {
		
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");
		
		List<String> result = new ArrayList<>();
		
		try (PreparedStatement ps = connection
				.prepareStatement("select distinct (marca) from televisore where dataproduzione > ?;")) {
			
			ps.setDate(1, java.sql.Date.valueOf(LocalDate.now().minusMonths(6)));
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String marcaTemp ="";
					marcaTemp = rs.getString("marca");
					result.add(marcaTemp);
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

		}
		return result;
	}

	


	
}
