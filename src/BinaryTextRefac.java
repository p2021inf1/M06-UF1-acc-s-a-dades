//US DE DATAINPUTSTREAM I DATAOUTPUTSTREAM per llegir i escriure respectivament arxius binaris

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryTextRefac {
	
	static String f1 = "binatext" ;

	public static void main(String[] args) {
		
		int[] ints = {128,250,430,520,820};
		
		writeStream(ints); 
		
		readStream();

	}

	private static void writeStream(int[] ints) {
		try {
			FileOutputStream text_binari = new FileOutputStream(f1);
			
			DataOutputStream str1 = new DataOutputStream(text_binari); 
			
			for (int j:ints) {
				str1.writeInt(j);
			}
			
			str1.flush();
			
			str1.close();

			text_binari.close();

		} catch (FileNotFoundException e) {
			System.out.println("EL FITXER NO EXISTEIX");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readStream() {
		try {
			FileInputStream text_binari_i = new FileInputStream(f1);
			
			DataInputStream str2 = new DataInputStream(text_binari_i);
			
			while (str2.available()>0) {
				int k = str2.readInt();
				System.out.println("k: "+k);
			}

			str2.close();

			text_binari_i.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("EL FITXER NO EXISTEIX");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
