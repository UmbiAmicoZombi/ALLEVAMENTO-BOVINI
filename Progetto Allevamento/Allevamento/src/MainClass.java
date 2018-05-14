import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws IOException, FileException, ClassNotFoundException, CapoException
	{
		int scelta = 0;
		ListaCapi listaCapi = new ListaCapi();
		
		do
		{
			System.out.println("1--> Registra acquisto Nuovo Capo" + '\n' + "2--> Registra vendita Capo" + '\n' + "3--> Eliminare un capo" + '\n' + "4--> Visualizza capi in ordine di data d'acquisto" + '\n' + "5-->Visualizza capi in ordine di peso " + '\n' +"6-->Chiudi programma");
			
			
			Scanner tastiera = new Scanner(System.in);
			scelta = tastiera.nextInt();
			
			if(scelta == 0 || scelta > 6)
			{
				System.out.println("Valore non valido, reinserire il valore :");
				scelta = tastiera.nextInt();
			}
			
			else if (scelta == 1)
			{
				tastiera.nextLine();
				Capo vitello = new Capo(scelta, scelta, scelta);
				System.out.println("Inserisci il CodiceID");
				vitello.setCodiceID(tastiera.nextInt());
				System.out.println("Inserisci il peso all'acquisto");
				vitello.setPesoA(tastiera.nextInt());
				System.out.println("Data d'acquisto salvata");
				LocalDate DataA = LocalDate.now();
				System.out.println("Data d'acquisto è il:"+DataA);
				listaCapi.salvaListaCapi("listaCapi.bin");
				System.out.println("salvataggio completato");
			}
			else if (scelta == 2)
			{
				tastiera.nextLine();
				
			}
			else if (scelta == 3)
			{
				tastiera.nextLine();
				System.out.println("Inserisci il CodiceID del Capo che desideri eliminare");
			
			}
			else if (scelta == 4)
			{
				tastiera.nextLine();
				listaCapi.ordinaData(listaCapi);
			}
			else if (scelta == 5)
			{
				tastiera.nextLine();
				listaCapi.ordinaPeso(listaCapi);
			}
			else if (scelta == 6)
			{
				System.out.println("chiusura programma");
				break;
			}
			
		}while(scelta >= 0 || scelta <=6);
		
		
	}

}
