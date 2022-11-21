//LECTURA BINARIA AMB FILEINPUTSTREAM

//Cal crear l'arxiu a llegir (en aquest cas panamera.jfif) dins el directori arrel del projecte

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageManager_OnlyRead {

//Codi per llegir bytes d'una imatge, emmagatzemar-los i escriure'ls en un altre fitxer	
	public static void main(String[] args) {		
		int contador=0;
	//creem un array d'enters per guardar cada byte de la imatge, segons la seva mida en bytes	
		int bytes_image[] = new int[6076];
		
		try {
			FileInputStream arxiu_lectura = new FileInputStream("panamera.jfif");
			boolean EOF=false;
			
			while(!EOF) {
				int byte_entrada = arxiu_lectura.read();
				
				if (byte_entrada !=-1) {
					bytes_image[contador]=byte_entrada;
				} else {
					EOF=true;
				}
				
				System.out.println(byte_entrada); //imprimim byte a byte que llegim
				System.out.println(bytes_image[contador]); //imprimim la copia dels bytes de la imatge menys el -1
				
				contador++;
			}
			
			
			arxiu_lectura.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("La imatge no es troba");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("La imatge té: "+contador+" bytes");

	}

}