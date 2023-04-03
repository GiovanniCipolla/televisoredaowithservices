package it.prova.service.televisore;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDAO;

	public void setTelevisoreDao(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;
	}

	// ----------------------- METODO LISTA --------------------
	public List<Televisore> lista() throws Exception {
		List<Televisore> result = new ArrayList<>();

		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public Televisore leggo(Long idInput) throws Exception {

		Televisore result = null;

		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public int inserisco(Televisore televisore) throws Exception {

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.insert(televisore);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public int aggiorno(Televisore televisore) throws Exception {

		int result = 0;

		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.update(televisore);

			if (result < 1)
				throw new Exception("TEST FAILED");

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public int elimino(Televisore televisore) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.delete(televisore);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public Televisore televisorePiuGrande() {

		Televisore result = new Televisore();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.WantTvBiggest();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int quantiTraLeDate(LocalDate minimo, LocalDate massimo) {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);
			
//			LocalDate dataMin = LocalDate.parse("2000-01-01");
//			LocalDate dataMax = LocalDate.parse("2015-01-01");
			// eseguo quello che realmente devo fare
			result = televisoreDAO.howManyTvMakeBetweenDate(minimo,massimo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<String> marcheDegliUltimiSeiMesi(){
		List<String> result = new ArrayList<>();
		
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			
			// eseguo quello che realmente devo fare
			result = televisoreDAO.wantBrandTvLastSixMonths();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
