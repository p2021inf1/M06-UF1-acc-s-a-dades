//ESCRIPTURA ARRAY CLASSE PRODUCTES SERIALITZADA

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StoreProds { 
			
	public static void main(String[] args) {
		
		Productes[] prods = new Productes[4];
		
		prods[0] = new Productes(1,"Coca Cola",200,0.65);
		prods[1] = new Productes(2,"White Label",20,14.50);
		prods[2] = new Productes(3,"Gel",100,1.50);
		prods[3] = new Productes(4,"Snacks",300,1.20);
		
		ObjectOutputStream serializador = null;
		
		try {
// instanciem l'object output stream			
			serializador = new ObjectOutputStream(new FileOutputStream("arxiuSer2.dat"));
// fem el writeObject			
			serializador.writeObject(prods);
// tanquem object output stream : IMPORTANT!!		
			serializador.close();
			
		} catch (IOException ioe) { 
			System.out.print(ioe.getMessage());
		}
	}

}