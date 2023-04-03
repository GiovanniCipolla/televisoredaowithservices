package it.prova.service.televisore;

import java.util.List;

import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

public interface TelevisoreService {
	
	
	// questo mi serve per injection
	public void setTelevisoreDao(TelevisoreDAO televisoreDAO);

	public List<Televisore> lista() throws Exception;
	
	public Televisore leggo(Long idInput) throws Exception;
	
	public int inserisco(Televisore televisore) throws Exception;
	
	public int aggiorno(Televisore televisore) throws Exception;
	
	public int elimino(Televisore televisore) throws Exception;
	
	
	

}