//CLASSE PER ESCRIURE AMB BUFFERWRITTER

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferWritter {
	File fitxer = null;
	FileWriter fw1 = null;
	BufferedWriter bw1 = null;
	Scanner sc1 = null;
	
	public void crear() {
		fitxer = new File("arxiu_writer.txt");
	}
	
	public void demanar_consola() {
		sc1 = new Scanner(System.in);
		System.out.println("Hola, posa el teu nom i cognoms: ");
	}
	
	public void escriure () {
		try {
			fw1 = new FileWriter(fitxer);
			bw1 = new BufferedWriter(fw1);
//Alternativa per fer en una línia el que es fa en dues.
//          bw1 = new BufferedWriter(new FileWriter(fitxer));
			String toFile = sc1.nextLine();
			bw1.write(toFile);
			bw1.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (bw1 != null) {
				try {
					bw1.close();
					fw1.close();
				} catch (IOException ioe) {
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		BufferWritter write1 = new BufferWritter();
		write1.crear();
		write1.demanar_consola();
		write1.escriure();
	}

}