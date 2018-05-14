import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import org.junit.Test;


public class NodoTest 
{

	@Test
	public void testCostruttoreNodo() 
	{
		Capo c=new Capo();
		Nodo n=new Nodo(c);
		assertTrue("Costruttore nodo",n.getInfo().equals(c)&&n.getLink()==null);
	}
	
	@Test
	public void testGetLink() 
	{
		Capo c1=new Capo();
		Nodo n=new Nodo(c1);
		assertEquals("getLinknull", n.getLink());
	}

	@Test
	public void testGetInfo() 
	{
		Capo c1=new Capo();
		Nodo n=new Nodo(c1);
		assertEquals("getInfo",c1, n.getInfo());
	}
	
	@Test
	public void testSetInfo() 
	{
		Capo c1=new Capo();
		Capo c2=new Capo();
		Nodo n=new Nodo(c1);
		n.setInfo(c2);
		assertTrue("setInfo",n.getInfo().equals(c2)&& n.getLink()==null);
	}
	
	@Test
	public void testSetLink() 
	{
		Capo c1=new Capo();
		CApo c2=new Capo();
		Nodo n1=new Nodo(c1);
		Nodo n2=new Nodo(c2);
		n1.setLink(n2);
		assertTrue("setLink",n1.getInfo().equals(c1)&& n1.getLink()==n2);
	}
}
