//CLASSE AMB ÚS DE FILE INPUT I OUTPUT STREAM

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageManager_rw {

	public static void main(String[] args) {		
	//creem un array d'enters per guardar cada byte de la imatge, segons la seva mida en bytes	
		final String f_lectura = "panamera.jfif";
		final String f_escriptura = "panamera_out.jfif"; 
		
		int contador = 0;
		int bytes_image[] = new int[6076];
		
	//lectura del fitxer movent els bytes a un array de bytes
		
		try {
			FileInputStream arxiu_lectura = new FileInputStream(f_lectura);
			FileOutputStream arxiu_escriptura = new FileOutputStream(f_escriptura);
			
			boolean EOF=false;
			
			while(!EOF) {
				int byte_entrada = arxiu_lectura.read();
				
				if (byte_entrada !=-1) {
					bytes_image[contador]=byte_entrada;
				} else {
					EOF=true;
				}
				
				contador++;
			}
		
	//recorrem les posicions de l'array i fem write sobre el fitxer de sortida		
			for (int j=0;j<bytes_image.length;j++) {
				arxiu_escriptura.write(bytes_image[j]);
			}
			
			arxiu_lectura.close();
			arxiu_escriptura.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("La imatge no es troba");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}