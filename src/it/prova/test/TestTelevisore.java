package it.prova.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.Televisore;
import it.prova.service.MyServiceFactory;
import it.prova.service.televisore.TelevisoreService;

public class TestTelevisore {

	public static void main(String[] args) {

		// parlo direttamente con il service
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceimpl();
		try {
			// -------------------------- TEST -------------------------

//			testLista(televisoreService);
//			
//			testLeggo(televisoreService);
//			
//			testInserisco(televisoreService);
			
//			testAggiorno(televisoreService);
			
//			testElimino(televisoreService);
			
//			testTelevisorePiuGrande(televisoreService);
//			
//			testQuantiTraLeDate(televisoreService);
//			
//			testMarcheDegliUltimiSeiMesi(televisoreService);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//--------------------------------METODI TEST -----------------------------
	// ------------------------- METODO TEST LISTA --------------------------
	private static void testLista(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testLista inizio.............");

		List<Televisore> result = televisoreService.lista();

		if (result.isEmpty())
			throw new RuntimeException("TEST FAILED");
		System.out.println(result);

		System.out.println(".......testLista fine.............");
	}

	// -------------------------- METODO TEST LEGGO -----------------
	private static void testLeggo(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testLeggo inizio.............");

		Televisore result = televisoreService.leggo(1l);

		System.out.println(result);

		System.out.println(".......testLeggo fine.............");
	}

	//------------------------ METODO TEST INSERISCO ------------------------
	private static void testInserisco(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testInsert inizio.............");
		int result= 0;
		// faccio la insert e verifico che sia tutto ok
		LocalDate data = LocalDate.parse("2021-06-30");
		Televisore televisoreDaInserire = new Televisore("Edge", "d23", 47, data);

		result = televisoreService.inserisco(televisoreDaInserire);
		
		if(result<1)
			throw new RuntimeException("TEST FAILED");
		// test visivo
	


		System.out.println(".......testInsert fine.............");

	}
	//------------------------ METODO TEST AGGIORNO -------------------------
	private static void testAggiorno(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testUpdate inizio.............");
		int result = 0;
		// faccio la insert e verifico che sia tutto ok
		LocalDate data = LocalDate.parse("2017-01-19");
		Televisore televisoreDaInserire = new Televisore(2l,"Samsung", "d69", 40, data);

		result = televisoreService.aggiorno(televisoreDaInserire);


		if(result<1)
			throw new Exception("TEST FAILED");

		System.out.println(".......testUpdate fine.............");
	}
	//------------------------ METODO TEST ELIMINO -------------------------
//	private static void testElimino(TelevisoreService televisoreService) throws Exception {
//		System.out.println(".......testElimino inizio.............");
//		int result = 0;
//		
//		result=televisoreService.elimino(televisoreService.lista().get(4));
//
//		if(result<1)
//			throw new Exception("TEST FAILED");
//
//		System.out.println(".......testElimino fine.............");
//		
//	}
	//---------------------------- METODO TEST televisorePiuGrande ------------------------------
	private static void testTelevisorePiuGrande(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testTelevisorePiuGrande inizio.............");
		
		
		
		System.out.println(televisoreService.televisorePiuGrande());

		

		System.out.println(".......testTelevisorePiuGrande fine.............");
		
	}
		//---------------------------- METODO TEST quantiTraLeDate------------------------------
	private static void testQuantiTraLeDate(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testQuantiTraLeDate inizio.............");
		
		int result = 0;
		LocalDate dataMin = LocalDate.parse("2000-01-01");
		LocalDate dataMax = LocalDate.parse("2015-01-01");
		result=televisoreService.quantiTraLeDate(dataMin, dataMax);
		System.out.println(result);

		System.out.println(".......testTelevisorePiuGrande fine.............");
	}
		//---------------------------- METODO TEST marcheDegliUltimiSeiMesi------------------------------
	private static void testMarcheDegliUltimiSeiMesi(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testMarcheDegliUltimiSeiMesi inizio.............");
		
		List<String> result = new ArrayList<>();
		
		result=televisoreService.marcheDegliUltimiSeiMesi();
		System.out.println(result);

		System.out.println(".......testMarcheDegliUltimiSeiMesi fine.............");
	}
	
}