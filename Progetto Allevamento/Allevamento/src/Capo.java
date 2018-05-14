import java.time.LocalDate;
import java.time.Month;
/**
 * La classe rappresenta una allevamento bovino. Gli attributi sono: il  CodiceID del bovino,
 * il peso del bovino all'acquisto, la data d'acquisto ,il peso alla vendita, la data della vendita
 * @author Umberto Pè
 */
public class Capo 

{
	//attributi
	private int CodiceID;
	private int PesoA;
	private LocalDate DataA;
	private int PesoV;
	private LocalDate DataV;
	
	
	/**
	 *  Costruttore.  Costruttore della classe Capo, istanzia un nuovo capo.
	 * Richiede il codiceID, il peso all'acquisto, il peso alla vendita.
	 * @param codiceID codiceID del bovino
	 * @param PesoA il peso all'acquisto
	 * @param PesoV il peso alla vendita
	 */
	public Capo (int codiceID, int pesoA, int pesoV) 
	{
		setCodiceID(codiceID);
		setPesoA(pesoA);
		setDataA(LocalDate.from(LocalDate.now()));
		setPesoV(pesoV);
		setDataV(null);
	}


	/**
	 * Metodo getter che restituisce il codiceID del bovino
	 * @return codiceID del bovino
	 */
		public int getCodiceID() 
		{
			return CodiceID;
		}


		/**
		 * Metodo setter che consente di impostare il codiceID del bovino
		 * @param codiceID codiceID del bovino
		 */
		public void setCodiceID(int codiceID) 
		{
			CodiceID = codiceID;
		}


		/**
		 * Metodo getter che restituisce il peso all'acquisto del bovino
		 * @return peso all'acquisto del bovino
		 */
		public int getPesoA() 
		{
			return PesoA;
		}


		/**
		 * Metodo setter che consente di impostare il peso all'acquisto del bovino
		 * @param PesoA peso all'acquisto del bovino
		 */
		public void setPesoA(int pesoA) 
		{
			PesoA = pesoA;
		}


		/**
		 * Metodo getter che restituisce la data di acquisto del bovino
		 * @return data di acquisto del bovino
		 */
		public LocalDate getDataA() 
		{
			return DataA;
		}

		/**
		 * Metodo setter che consente di impostare la data  di acquisto del bovino
		 * @param DataA data di acquisto del bovino
		 */

		public void setDataA(LocalDate dataA) 
		{
			DataA = dataA;
		}


		/**
		 * Metodo getter che restituisce il peso alla vendita del bovino
		 * @return peso alla vendita del bovino
		 */
		public int getPesoV() 
		{
			return PesoV;
		}


		/**
		 * Metodo setter che consente di impostare il peso alla vendita del bovino
		 * @param PesoV peso alla vendita del bovino
		 */
		public void setPesoV(int pesoV) 
		{
			PesoV = pesoV;
		}


		/**
		 * Metodo getter che restituisce la data di vendita del bovino
		 * @return data di vendita del bovino
		 */
		public LocalDate getDataV() 
		{
			return DataV;
		}


		/**
		 * Metodo setter che consente di impostare la data  di vendita del bovino
		 * @param DataV data di vendita del bovino
		 */

		public void setDataV(LocalDate dataV) 
		{
			DataV = dataV;
		}

		
		/**
		 * Restituisce una stringa contenente le informazioni sul bovino: codiceID, Peso all'acquisto , Data d'acquisto, Peso alla vendita, Data di vendita
		 */		
		public String toString(int i) 
		{
			return(getCodiceID()+" "+getPesoA()+" "+getDataA()+" "+getPesoV()+" "+getDataV());
		}
	



}
