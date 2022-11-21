import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

//DESERIALITZAR AMB CLASSE PRODUCTES

public class DesSerialProds { 

	public static void main(String[] args) {
		
		ObjectInputStream deserializador = null;
//		Object listaProductos = null;
		
		try {
		  deserializador = new ObjectInputStream(new FileInputStream("arxiuSer2.dat"));
		  
		  Productes[] listaProductos = (Productes[])deserializador.readObject();
		  
		  for(Productes p:listaProductos) {
			  System.out.print(p);
		  }
		  
		  deserializador.close();  

		} catch (FileNotFoundException fnfe ) {
		  fnfe.printStackTrace();
		} catch (EOFException e1)  { 
		  e1.printStackTrace();
		} catch (IOException ioe) { 
		  ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 		

	}

}