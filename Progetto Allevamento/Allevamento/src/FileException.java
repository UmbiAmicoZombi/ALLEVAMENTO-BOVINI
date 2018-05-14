/**
 * Eccezione, indica il verificarsi di un eccezione nella gestione dei file di testo.
 * @author Umberto Pè
 *
 */
public class FileException extends Exception
{
	private String message;
	
	public FileException(String message)
	{
		this.message = message;
	}
	
	public String toString()
	{
		return message;
	}
}