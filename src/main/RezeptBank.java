package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RezeptBank {
	public void saveRezept(String rezKategorie, String rezName, String rezPfad){
		addRezept(rezKategorie, rezName, rezPfad);
	}
	
	private void addRezept(String rezKategorie, String rezName, String rezPfad){
		try
		{
			File file = new File("C:\\Users\\Armin\\Documents\\" + rezKategorie + ".txt");
			FileWriter fw = null;
			
			if(file.exists())
			{
				System.out.println("Datei existiert bereits.");
			} else
			{
				System.out.println("Datei wird erstellt.");
			}
			
			fw = new FileWriter(file.getPath(), true);
			
			PrintWriter pw = new PrintWriter(fw);
			pw.println(rezName + "; " + rezPfad + "# ");
			
			fw.flush();
			fw.close();
			
			pw.flush();
			pw.close();				
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	

}
