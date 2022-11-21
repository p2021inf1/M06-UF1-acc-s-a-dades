//DESERIALITZAR AMB LA CLASSE ALUMNE

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadSerialAlumne {
	
	public static void main(String[] args) {
		
		ObjectInputStream deserializador = null;
		
		try {
		  deserializador = new ObjectInputStream(new FileInputStream("C:\\Users\\Tonla\\alumnosAprobados.dat"));
		  
		  ArrayList<Alumne> Alumnes = (ArrayList<Alumne>)deserializador.readObject();
		  
		  System.out.print(Alumnes);
		  
		  
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