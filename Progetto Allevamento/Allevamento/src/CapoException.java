/**
 * Eccezione. Indica che il capo non è presente
 * @author Umberto Pè
 *
 */
public class CapoException extends Exception 
{
	private String messaggio;
	
	public CapoException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
