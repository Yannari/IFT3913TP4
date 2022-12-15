package ua.karatnyk;


//import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Map;
import java.util.TreeMap;

//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import ua.karatnyk.impl.CurrencyConversion;
import ua.karatnyk.impl.CurrencyConvertor;
import ua.karatnyk.impl.OfflineJsonWorker;


public class TestCurrencyConvertor {

	//private CurrencyConvertor test;
	private CurrencyConversion conversion;
	
	
	@Before
	public void init() {
		//test = new CurrencyConvertor();
	}

	/*
	 * Critère de couverture des instructions 
	 */
	@Test
	public void currency() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "CAD" , "USD", conversion);
		assertTrue(output == 8.926242650988774);
	}
	@Test
	public void currency2() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 8.926242650988774, "USD" , "CAD", conversion);
		assertTrue(output == 12.00);
	}
	
	@Test 
	public void currency3() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "JPY" , "JPY", conversion);
		assertTrue(output == 12.00);
	}
	
	/*
	 * Critère de couverture des arcs du graphe de flot
	 * de contrôle
	 */
	//testing exception to
	@Test (expected = ParseException.class)
	public void currency5() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "CAFFD" , "USD", conversion);
	}
	
	@Test (expected = ParseException.class)
	public void currency6() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 8.926242650988774, "CAFFD" , "USSSD", conversion);
		assertTrue(output == 12.00);
	}
	//testing exception from
	@Test (expected = ParseException.class)
	public void currency7() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "CAD" , "USSSD", conversion);
	}
	
	
	/*
	 * Critère de couverture des conditions
	 */
	
	@Test (expected = ParseException.class)
	public void currency8() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "" , "USD", conversion);
	}
	
	@Test (expected = ParseException.class)
	public void currency9() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "CAD" , "", conversion);
	}
	
	@Test 
	public void currency10() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert(2147483647, "CAD" , "USD", conversion);
		assertTrue(output == 1.5974133435126934E9);
	}
	
	
	@Test
	public void currency11() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert(-2147483648, "CAD" , "USD", conversion);
		assertTrue(output == -1.597413344256547E9);
	}
	
	@Test (expected = ParseException.class)
	public void currency12() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "" , "", conversion);
	}
	
	@Test (expected = ParseException.class)
	public void currency13() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "12.00" , "USD", conversion);
	}
	
	@Test (expected = ParseException.class)
	public void currency14() throws ParseException{
		conversion  = new OfflineJsonWorker().parser();
		double output = CurrencyConvertor.convert( 12.00, "CAD" , "12.00", conversion);
	}
	

	
	
	
	
	
	
	
}
