import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe per la gestione della scrittura di un file di testo.
 * La Classe consente di aprire e chiudere un file di testo in lettura o in scrittura e fornisce
 * i metodi per la scrittura di una stringa sul file  e per la lettura di una stringa dal file 
 * @author Umberto Pè
 *
 */

public class TextFile 
{
	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	/**
	 * Costruttore
	 * @param filename del file da aprire
	 * @param mode, modalità di apertura del file R per sola lettura, W per sola scrittura
	 * @throws IOException, nel caso non sia possibile accedere al file
	 * @throws FileException, se il file è aperto in lettura
	 */
	
	public TextFile(String fileName, char mode) throws IOException
	{
		this.mode='R';
		if (mode=='w' || mode=='W')
		{
			FileWriter f1= new FileWriter(fileName);
			writer = new BufferedWriter(f1);
			this.mode='W';
		}
		else
		{
			FileReader f1= new FileReader(fileName);
			reader= new BufferedReader(f1);
			this.mode='R';
		}
		
		
	}
	
	/**
	 * Scrive una stringa sul file di testo
	 * @param line, stringa da scrivere
	 * @throws IOException, nel caso non sia possibile accedere al file
	 * @throws FileException, se il file è aperto in lettura
	 */
	public void toFile(String line)throws FileException,IOException
	{
		if (mode=='R')
			throw new FileException("File aperto in lettura");
		writer.write(line);
		writer.newLine();
	}
	
	/**
	 * Legge una riga di testo dal file.
	 * @return riga letta
	 * @throws IOException, nel caso non sia possibile accedere al file
	 * @throws FileException, se il file è aperto in scrittura
	 * @throws FileException, se è stata raggiunta la fine del file
	 */
	public String fromFile() throws FileException, IOException 
	{
		String rigaLetta;
		if (mode=='W')
			throw new FileException("File aperto in scrittura");
		rigaLetta=reader.readLine();
		if (rigaLetta==null)
			throw new FileException("End of file");
		return rigaLetta;
	}
	
	/**
	 * Chiude il file aperto
	 * @throws IOException, nel caso non sia possibile accedere al file
	 */
	public void closeFile() throws IOException
	{
		if (mode=='R')
			reader.close();
		else
			writer.close();
	}
}
