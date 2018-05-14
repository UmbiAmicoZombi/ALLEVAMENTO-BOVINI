import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * @author Umberto Pè
 */
public class ListaCapi implements Serializable
{

	private Nodo head;
	private int elementi;
	
	/**
	 * Costruttore della lista capi
	 */
	public ListaCapi()
	{
		head=null;
		elementi=0;
	}
	
	/**
	 * Metodo getter che restituisce il numero di elementi (Capi)
	 * @return
	 */
	public int getElementi()
	{
		return elementi;
	}
	
	/**
	 * Metodo che consente di creare un nodo passando l'oggetto(Capo) e il link del nodo 
	 * @param capo è l'oggetto capo della mia lista capi
	 * @param link
	 * @return il nodo;
	 */
	private Nodo creaNodo(Capo vitello, Nodo link)
	{
		Nodo nodo= new Nodo(vitello);
		nodo.setLink(link);
		return nodo;
	}
	
	/**
	 *  Restituisce il nodo nella posizione inserita come parametro
	 * @param posizione
	 * @return posizione
	 * @throws CapoException,  Eccezione sollevata nel caso in cui nella lista capi non siano presenti capi
	 */
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
	/**
	 * Permette di inserire in testa alla lista di capi un capo
	 * @param capo
	 */
	public void inserisciInTesta (Capo vitello)
	{
		
		Nodo p=creaNodo(vitello, head);
		head=p;
		elementi++;
	}
	
	/**
	 * Restituisce una stringa che contiene  l'elenco dei capi presenti nella lista capi
	 */
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
	
	/**
	 * Permette di inserire in coda alla lista di capi un capo
	 * @param capo
	 */
	public void inserisciInCoda(Capo vitello) throws CapoException 
	{
		if(elementi==0)
		{
			inserisciInTesta(vitello);
			return;
		}
		
		Nodo pn=creaNodo(vitello, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	
	public void inserisciInPosizione(Capo vitello,int posizione) throws CapoException 
	{
		if (posizione<=1)
		{
			inserisciInTesta(vitello);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(vitello);
			return;
		}
		
		Nodo pn=creaNodo(vitello, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	/**
	 * Consente di eliminare un capo presente nella lista capi,l'oggetto che verra eliminato sara quello in testa
	 * @throws CapoException,  Eccezione sollevata nel caso in cui nella lista capi non siano presenti capi 
	 */
	public void eliminaInTesta() throws CapoException 
	{
		if (elementi==0)
			throw new CapoException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	
	/**
	 * Consente di eliminare un capo presente nella lista capi,l'oggetto che verra eliminato sara quello in coda
	 * @throws CapoException,  Eccezione sollevata nel caso in cui nella lista capi non siano presenti capi 
	 */
	public void eliminaInCoda() throws CapoException 
	{
		if (elementi==0)
			throw new CapoException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws CapoException
	{
		if (elementi==0)
			throw new CapoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new CapoException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	public String visita (int posizione) throws CapoException 
	{
		if (elementi==0)
			throw new CapoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new CapoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	
	/**
	 * Consente di restituire un capo scelto in base alla posizione
	 * @param posizione posizione del capo da visualizzare
	 * @return l'oggetto scelto
	 * @throws CapoException  Eccezione, sollevata nel caso in cui nella lista capi in caso non siano presenti capi
	 */
	public Capo getCapo (int posizione) throws CapoException 
	{
		if (elementi==0)
			throw new CapoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new CapoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	/**
	 * consente di visualizzare la lista dei capi in ordine di peso dal più pesante al meno pesante
	 * @return lista capi ordinata
	 * @throws CapoException,  Eccezione sollevata nel caso in cui nella lista capi in caso non siano presenti capi 
	 */
	public void ordinaPeso(ListaCapi capi) throws CapoException
	{
		boolean controllo = true;
		int elementi = capi.getElementi()+1;
		ListaCapi listac = new ListaCapi();
		for (int i = 1; i < elementi; i++) 
		{
			listac.inserisciInPosizione(capi.getCapo(i), i);
		}
		elementi--;
	do
	{
		controllo = true;
		for (int i = 1; i < elementi; i++) 
		{
			if (listac.getCapo(i).getPesoA() < listac.getCapo(i+1).getPesoA())
			{
				listac.inserisciInPosizione(listac.getCapo(i+1), i);
				listac.eliminaInPosizione(i+2);
				controllo = false;
			}
			else
			{
			}
		}
	}while(controllo == false);			
		elementi++;
		for (int i = 1; i < elementi; i++) 
		{
			listac.getCapo(i).toString(i);
		}
		System.out.println("Visualizzazione completata");
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
	
	/**
	 * consente di visualizzare la lista dei capi in ordine di data 
	 * @return lista capi ordinata
	 * @throws CapoException,  Eccezione sollevata nel caso in cui nella lista capi in caso non siano presenti capi 
	 */
	public void ordinaData(ListaCapi capi) throws CapoException
	{
		boolean controllo = true;
		int elementi = capi.getElementi()+1;
		ListaCapi listac = new ListaCapi();
		for (int i = 1; i < elementi; i++) 
		{
			listac.inserisciInPosizione(capi.getCapo(i), i);
		}
		elementi--;
	do
	{
		controllo = true;
		for (int i = 1; i < elementi; i++) 
		{
			if (listac.getCapo(i).getDataA().compareTo(listac.getCapo(i+1).getDataA()) > 0)
			{
				listac.inserisciInPosizione(listac.getCapo(i+1), i);
				listac.eliminaInPosizione(i+2);
				controllo = false;
			}
			else
			{
			}
		}
	}while(controllo == false);			
		elementi++;
		for (int i = 1; i < elementi; i++) 
		{
			listac.getCapo(i).toString(i);
		}
		System.out.println("Visualizzazione completata");
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
	
	/**	 
	 * Esporta su un file di testo un elenco in formato CSV con tutti dati di tutte le attività del progetto.
	 * Per ogni attività presente vengono memorizzate : il codiceID, il peso all'acquisto, la data d'acquisto, la data alla vendita, il peso alla vendita
	 * @param nomeFile Nome del file in cui salvare le attività. Il nome deve essere comprensivo del path e dell'estensione del file di testo.
	 * @throws IOException, Eccezione che viene sollevata nel caso non sia possibile accedere al file di testo
	 * @throws FileException, Eccezione che si verifica nel caso in cui il file da scrivere sia aperto in lettura.
	 */
	public void esportaCSV (String nomeFile) throws IOException, CapoException, FileException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String vitelloCSV;
		Capo vitello;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			vitello=getCapo(i);
			vitelloCSV=vitello.getCodiceID()+";"+vitello.getPesoA()+";"+vitello.getDataA()+";"+vitello.getPesoV()+";"+vitello.getDataV()+";";
			file.toFile(vitelloCSV);
		}
		file.closeFile();
		
	}

	public ListaCapi importaCSV (String nomeFile) throws IOException, FileException, CapoException
	{
		ListaCapi listaCapi=new ListaCapi();
		TextFile file=new TextFile(nomeFile,'R');
		String rigaLetta;
		String[] elementiVitello;
		Capo vitello = null;
		
			try 
			{
				while(true)
				{
					rigaLetta=file.fromFile();
					elementiVitello=rigaLetta.split(";");
					int CodiceID = vitello.getCodiceID();
					int PesoA = vitello.getPesoA();
					int PesoV = vitello.getPesoV();
					vitello = new Capo(CodiceID, PesoA, PesoV);
					listaCapi.inserisciInCoda(vitello);
				}
				
			} 
			catch (FileException e) 
			{
				if (e.toString().compareTo("End of file")==0)
					file.closeFile();
				else
					throw new FileException(e.toString());
			}
		
			return listaCapi;		
			
	}
	
	
	
	
	/**
	 * Si occupa della serializzare della lista dei capi in esecuzione su un file di tipo .bin
	 * @param nomeFile Nome del file in cui salvare le attività. Il nome deve essere comprensivo del path e dell'estensione del file di testo.
	 * @throws IOException Eccezione che viene sollevata nel caso non sia possibile accedere al file di testo
	 */
	public void salvaListaCapi(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	/**
	 *  Si occupa di deserializzare un capo da un file .bin ciò è necessario per rendere persistente un ogetto
	 * @param nomeFile Nome del file in cui salvare le attività. Il nome deve essere comprensivo del path e dell'estensione del file di testo.
	 * @throws  IOException, Eccezione che viene sollevata nel caso non sia possibile accedere al file di testo
	 * @throws ClassNotFoundException, Eccezione che viene sollevata nel caso non si trovi la classe
	 */
	public ListaCapi caricaListaCapi (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		ListaCapi listaCapi;
		listaCapi=(ListaCapi)(reader.readObject());
		file.close();
		return listaCapi;
	}
}