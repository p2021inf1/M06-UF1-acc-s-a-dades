//CLASSE DE LECTURA AMB BUFFER READER

//Cal crear l'arxiu.txt o arxiu a llegir dins el directori arrel del projecte

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferRead {
	File fitxer = null;
	FileReader lector = null;
	BufferedReader buffer = null;
		
	public void llegir() {
		try {
			fitxer = new File("arxiu.txt");
			lector = new FileReader(fitxer);
			buffer = new BufferedReader(lector);		
			
			String linea = null;
			while ((linea = buffer.readLine()) != null)
				System.out.println(linea);
		} catch (FileNotFoundException ex) {
//			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} catch (IOException iex) { 
//			System.out.println(iex.getMessage());
			iex.printStackTrace(); 
		} finally {
			if (buffer != null)
				try {
					buffer.close();
				} catch (IOException ioe) {
					
				}
			}
	}
 
	public static void main(String[] args) {
		BufferRead br1 = new BufferRead();
		br1.llegir();
	}

}