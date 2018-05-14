import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;




public class CapoTest 
{
	
	LocalDate DataA = LocalDate(2012, 12, 01);
	LocalDate DataV = LocalDate(2013, 11, 11);
	Capo c1 =  new Capo(1,"",  DataA);
	Capo c2 =  new Capo(2,"", DataV);
		
	
	 @Test
		public void testCostruttoreVuoto() 
		{
			Capo test=new Capo(0,"",null);
			test.setDataA();
			test.setDataV();
			Capo c = new Capo();
			assertEquals("Costruttore vuoto errato",test,c);	
			
		}
	
	@Test

	public void testSetCodiceID()
	{
		Capo c1 =  new Capo();
		c1.setCodiceID(10023);
		assertEquals("Settaggio CodiceID del bovino ", 10023,c1.getCodiceID());
	}

	@Test
	public void testSetPesoA()
	{
		Capo c1 =  new Capo();
		c1.setPesoA(134);
		assertTrue("Settaggio peso del bovino all'acquisto ", c1.getPesoA().compareTo(134)==0);
	}
	
	@Test
	public void testSetDataA() 
	{
		LocalDate dataA = LocalDate(2012, 12, 01);
		Capo c1 =  new Capo(DataA);
		c1.setDataA(dataA);

		
		LocalDate test = LocalDate(2012, 12, 01);
		assertEquals("settaggio data di acquisto", test, c1.getDataA());
	}

	@Test
	public void testSetPesoV()
	{
		Capo c1 =  new Capo();
		c1.setPesoV(150);
		assertTrue("Settaggio peso del bovino alla vendita ", c1.getPesoV().compareTo(150)==0);
	}
	
	@Test
	public void testSetDataV() 
	{
		LocalDate dataA = LocalDate(2013, 11, 11);
		Capo c1 =  new Capo(DataV);
		c1.setDataV(dataV);

		
		LocalDate test = LocalDate(2013, 11, 11);
		assertEquals("settaggio data di vendita", test, c1.getDataV());
	}
	
}