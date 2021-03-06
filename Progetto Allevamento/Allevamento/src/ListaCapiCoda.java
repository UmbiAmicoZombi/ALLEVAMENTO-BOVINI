
public class ListaCapiCoda 
{

	private Nodo head;
	private int elementi;
	
	public ListaCapiCoda()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Capo vitello, Nodo link)
	{
		Nodo nodo= new Nodo(vitello);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws CapoException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new CapoException("Posizione non valida");
		if (elementi==0)
			throw new CapoException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	
			n++;
		}
		
		return p;
	}
	
	public void enqueue (Capo vitello)
	{
		
		Nodo p=creaNodo(vitello, head);
		head=p;
		elementi++;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	
	public Capo dequeue() throws CapoException
	{
		if (elementi==0)
			throw new CapoException("Lista vuota");
		Nodo p;
		if (elementi==1)
		{
			p=head;
			head=null;
			elementi--;
			return p.getInfo();
		}
		
		p=getLinkPosizione(elementi);
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
		return p.getInfo();
	}
}
