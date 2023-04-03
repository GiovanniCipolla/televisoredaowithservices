package it.prova.dao.televisore;

import java.util.List;

import it.prova.dao.IBaseDAO;
import it.prova.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	
	public Televisore WantTvBiggest();
	public int howManyTvMakeBetweenDate();
	public List<String> wantBrandTvLastSixMonths();
	
}
