package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class RezeptBank {
	
	Vector<String> vecName = new Vector<String>();
	Vector<String> vecPfad = new Vector<String>();
	

	public void saveRezept(String rezKategorie, String rezName, String rezPfad){
		addRezept(rezKategorie, rezName, rezPfad);
	}
	
	public void getRezept(String rezKategorie){
		getFile(rezKategorie);
	}
	
	private void addRezept(String rezKategorie, String rezName, String rezPfad){
		try
		{
			File file = new File(rezKategorie + ".txt");
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
			pw.println(rezName + ";" + rezPfad);
			
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
	
	private void getFile(String rezKategorie){
        BufferedReader br = null;
        try {
       		br = new BufferedReader(new FileReader(new File(rezKategorie + ".txt")));
       		String line = null;
       		
       		
       		
       		while((line = br.readLine()) != null) {              
       			String[] parts = line.split(";");
       			
       			vecName.add(parts[0]);
       			vecPfad.add(parts[1]);

       		}
        	} catch(FileNotFoundException e) {
       			e.printStackTrace();
       		} catch(IOException e) {
       			e.printStackTrace();
       		} finally {
       			if(br != null) {
       				try {
       				br.close();
       				} catch(IOException e) {
       					e.printStackTrace();
        		}
        	}
        }
	}
	public Vector<String> getVecName(){
		return vecName;
	}
	public Vector<String> getVecPfad(){
		return vecPfad;
	}
	
	public void deleteRez(int lineNumber, String rezName) throws Exception
	{
		try
		{
			File file = new File(rezName + ".txt");
			File kopie = new File(rezName + "kopie.txt");
			FileWriter kwriter = new FileWriter(kopie, true);
			FileReader freader = new FileReader(file);
			BufferedReader reader = new BufferedReader(freader);
		
			int counter = 0;
			String line;
			while((line = reader.readLine()) != null)
			{
				if(lineNumber != counter)
				{
					kwriter.write(line);
					kwriter.write(System.getProperty("line.separator"));
				}
				counter++;
			}
			reader.close();
			kwriter.close();

			if(file.exists()) file.delete();
			kopie.renameTo(new File(rezName + ".txt"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
