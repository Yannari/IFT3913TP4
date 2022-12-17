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
	
	//Black Box test
	/*
	 * Classes d’équivalence
	 */
	
	@Test 
	public void currency15() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(0, "CAD" , "USD", conversion);
			assertTrue(output == 0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	@Test 
	public void currency16() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(0, "CAD" , "CAD", conversion);
			assertTrue(output == 0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	@Test 
	public void currency17() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(0, "CAD" , "KOR", conversion);
			assertTrue(output == 0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	
	@Test 
	public void currency18() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(10000, "CAD" , "USD", conversion);
			assertTrue(output>0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	public void currency19() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(10000, "CAD" , "CAD", conversion);
			assertTrue(output>0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	public void currency20() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(10000, "CAD" , "KOR", conversion);
			assertTrue(output>0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	
	@Test (expected = ParseException.class)
	public void currency21() throws ParseException{
		try{

		
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(-1, "CAD" , "USD", conversion);
			
			assertFalse(output>0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
		
	} 
	public void currency22() throws ParseException{
		try{

		
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(-1, "CAD" , "CAD", conversion);
			
			assertFalse(output>0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
		
	} 
	public void currency23() throws ParseException{
		try{

		
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(-1, "CAD" , "KOR", conversion);
			
			assertFalse(output>0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
		
	} 
	
	@Test (expected = ParseException.class)
	public void currency24() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(10001, "CAD" , "USD", conversion);
			assertFalse(output<0);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
		
	}
	@Test (expected = ParseException.class)
	public void currency25() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(10001, "CAD" , "KOR", conversion);
			
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
		
	}
	@Test (expected = ParseException.class)
	public void currency26() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(10001, "CAD" , "CAD", conversion);
			assertTrue(output==10001);
			
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
		
	}
	
	/*
	 * Valeurs frontières
	 */
	
	@Test 
	public void currency27() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(1, "CAD" , "USD", conversion);
			
			assertTrue(output == 0.7438535542490645);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	public void currency28() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(1, "CAD" , "CAD", conversion);
			
			assertTrue(output == 1);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	public void currency29() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(1, "CAD" , "KOR", conversion);
			
			
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	
	@Test 
	public void currency30() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(9999, "CAD" , "USD", conversion);
			assertTrue(output == 7437.791688936396);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	public void currency31() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(9999, "CAD" , "CAD", conversion);
			assertTrue(output == 9999);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	public void currency32() throws ParseException{
		try{
			conversion  = new OfflineJsonWorker().parser();
			double output = CurrencyConvertor.convert(9999, "CAD" , "KOR", conversion);
		}
		catch(Exception e)
		{
			fail("currency not currently support");
		}
	}
	
	
	
	
}	



