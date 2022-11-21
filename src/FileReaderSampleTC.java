//CLASSE PER LLEGIR CARACTER A CARACTER UN FITXER

//args[0] és el nom del fitxer que volem mirar
//Es pot fer de dues maneres: A les configuracions del run, anar als
//arguments del programa i ficar allà la ruta del fitxer.
//Eclipse seria: Run As --> Run Configurations, anar a la pestanya Arguments
//i omplir el requadre program arguments amb la ruta del fitxer.

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderSampleTC {

	public static void main(String[] args) {
		String route = args[0];
		File f1 = new File(route);
				
		try {
			FileReader fr = new FileReader(f1);
					
			int c = 0;
					
			while (c!=-1) {
				c = fr.read();
				char lletra = (char) c;
				System.out.println("Caracter llegit: " + lletra);
			}
			
			fr.close();
						
		} catch (IOException ex) {
			System.out.println("El fitxer no existeix");
		}
	} 
}
			
		
	