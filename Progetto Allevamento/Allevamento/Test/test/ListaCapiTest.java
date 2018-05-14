package test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Test;

public class ListaCapiTest 
{
	LocalDate DataA = LocalDate(2012, 1, 1);
	LocalDate DataV = LocalDate(2013, 11, 11);
	
	
	
	@Test
	public void testInserisciInTesta()
	{
		Capo c=new Capo();
		Capo c1=new Capo();
		c.InserisciInTesta(c1);
	}

	@Test
	public void testSerializzazioneDeserializzazione() throws ClassNotFoundException, IOException 
	{
		Capo c=new Capo();
		Capo c1=new Capo(null);
		c.InserisciInTesta(c1);
		c.salvaListaCapi("listaCapi.bin");
		Capo c2=c.caricaListaCapi("listaCapi.bin");
		assertTrue("Serializzazione e Deserializzzazione",c.toString().equals(c2.toString()));
	}
}
