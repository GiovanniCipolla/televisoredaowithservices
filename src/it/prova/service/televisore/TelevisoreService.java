package it.prova.service.televisore;

import it.prova.dao.televisore.TelevisoreDAO;

public interface TelevisoreService {
	// questo mi serve per injection
		public void setTelevisoreDao(TelevisoreDAO televisoreDAO);
}
