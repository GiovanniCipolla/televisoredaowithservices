package it.prova.dao.televisore;

import java.time.LocalDate;
import java.util.List;

import it.prova.dao.IBaseDAO;
import it.prova.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	
	public Televisore WantTvBiggest()throws Exception;
	public int howManyTvMakeBetweenDate(LocalDate dataMin, LocalDate dataMax)throws Exception;
	public List<String> wantBrandTvLastSixMonths() throws Exception;
	
}
