import java.io.Serializable;
/**
 * Istanzia il nodo di una lista,implementa la serializzazione 
 * @author Umberto Pè
 */
public class Nodo implements Serializable
{
	private Capo info;
	private Nodo link;
	
	/**
	*Il costruttore riceve come parametro un oggetto di tipo Vitello e assegna al proprio
	*attributo info una copia di questo Vitello
	* L'attributo link viene posto a null.
	* @param Vitello è il capo da aggiungere
	*/
	public Nodo(Capo vitello)
	{
		setInfo(vitello);
		link=null;
	}

	/**
	 * Metodo getter che restituisce la componente informativa di un nodo
	 * @return la componente informativa di un nodo
	 */
	public Capo getInfo() 
	{
		return info;
	}

	/**
	 * Metodo setter che consente di impostare la componente informativa di un nodo
	 * @param info componente informativa di un nodo
	 */
	public void setInfo(Capo info) 
	{
		this.info = info;
	}

	/**
	 * Metodo getter che restituisce il link di un nodo
	 * @return il link di un nodo
	 */
	public Nodo getLink() 
	{
		return link;
	}

	/**
	 *  Metodo setter che consente di impostare il link di un nodo 
	 * @param link link di un nodo
	 */
	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}
