//APLICACIO RANDOM ACCESS FILE

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ProdsRAM {
	
	private final static BufferedReader entradaConsola = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Products> prods = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		System.out.println("Digueu si voleu llegir(L) o escriure(E): ");
		
		switch(entradaConsola.readLine()) {
		case "E":
			readConsole(prods);
			escriuRam();
			break;
		case "L":
			llegeixRam();
		} 
	}
	

	public static void readConsole(ArrayList<Products> prods2) {
		int idP=0;
		String nameP="";
		double preuP=0.0;
		boolean descompteP=false;
		char tipusP=' ';
		
		int counter=0;
		
		do {
			idP=llegirEnter("Introduir la id del producte: ");
			nameP=llegirText("Introduir el nom del producte: ");
			preuP=llegirDouble("Introduir el preu: ");
			descompteP=llegirBoolean("Té descompte? trieu true/false): ");
			tipusP=llegirChar("Tipus de producte, trieu 'T','P','K': ");
			
			prods2.add(new Products(idP,nameP,preuP,descompteP,tipusP));
			
			counter ++;
		} while (counter < 5);
	}
	
	public static void escriuRam() {
		try (RandomAccessFile raf = new RandomAccessFile("productes_raf.dat", "rw")) { 
			for (Products p:prods) { 
                raf.writeInt(p.getId());
                
                StringBuffer sb = new StringBuffer(p.getNombre());
                sb.setLength(10);
 
                raf.writeChars(sb.toString());
                raf.writeDouble(p.getPrecio());
                raf.writeBoolean(p.isDescuento());
                raf.writeChar(p.getTipo());
			}		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void llegeixRam() {
		try (RandomAccessFile raf = new RandomAccessFile("productes_raf.dat", "r")) {
			System.out.println(raf.length());
			System.out.println(raf.getFilePointer());
	           raf.seek(35);
	           System.out.println(raf.readInt());
	            String nombre = "";
	            for (int i = 0; i < 10; i++) {
	                nombre += raf.readChar();
	            }
	            System.out.println(nombre);
	            System.out.println(raf.readDouble());
	            System.out.println(raf.readBoolean());
	            System.out.println(raf.readChar());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
    public static String llegirText(String mensaje) {
        String respuesta=null;
        do{
            try {
                System.out.print(mensaje);
                respuesta= entradaConsola.readLine();
            } // ()
            catch (IOException ex) {
                return "";
            }
        } while(respuesta ==null);
        return respuesta;
        
    }

    public static int llegirEnter(String mensaje) {
        int n=0;
        boolean aconseguit=false;
        while(!aconseguit){
            try{
                n= Integer.parseInt(llegirText(mensaje));
                aconseguit=true;
            }
            catch(NumberFormatException ex){
                System.out.println("Deus posar un numero correcte");
            }
        }
        return n;
    }

    public static double llegirDouble(String mensaje) {
        double n=0.0;
        boolean aconseguit=false;
        while(!aconseguit){
            try{
                n= Double.parseDouble(llegirText(mensaje));
                aconseguit=true;
            }
            catch(NumberFormatException ex){
                System.out.println("Deus posar un numero correcte");
            }
        }
        return n;
    }
    
    public static boolean llegirBoolean(String mensaje) {
        boolean b=false;
        boolean aconseguit=false;
        while(!aconseguit){
            try{
                b= Boolean.parseBoolean(llegirText(mensaje));
                aconseguit=true;
            }
            catch(NumberFormatException ex){
                System.out.println("Deus posar un numero correcte");
            }
        }
        return b;
    }
    
    public static char llegirChar(String mensaje) {
        char c=' ';
        do{
            try {
                System.out.print(mensaje);
                c=(char) (entradaConsola.read());
            }
            catch (IOException ex) {
                return ' ';
            }
        } while(c == ' ');
        return c;
    }


}