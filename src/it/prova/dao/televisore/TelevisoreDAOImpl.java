package it.prova.dao.televisore;

import java.sql.Connection;
import java.util.List;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.Televisore;

public class TelevisoreDAOImpl extends AbstractMySQLDAO implements TelevisoreDAO {
	
	

	public List list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Televisore get(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int update(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int insert(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int delete(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	public Televisore WantTvBiggest() {
		// TODO Auto-generated method stub
		return null;
	}

	public int howManyTvMakeBetweenDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List wantBrandTvLastSixMonths() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
