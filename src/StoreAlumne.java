//ESCRIPTURA I SERIALITZACIÓ AMB LA CLASSE ALUMNE

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StoreAlumne {
	
    private static final String nombreFicheroIN = "alumnos.txt";
    private static final String nombreFicheroOUT = "alumnosAprobados.csv";
    
    private static final String nombreFicheroSERIALOUT = "alumnosAprobados.dat";
		
	public static ArrayList<Alumne> importar(String nombre) {
		FileReader fr1 = null;
		ArrayList<Alumne> alumnos = null;
		
		try {
			alumnos = new ArrayList<>();
			File Alumn = new File(nombre);
			fr1 = new FileReader(Alumn);
			BufferedReader br1 = new BufferedReader(fr1);
			String linea = "";
			
			while ((linea = br1.readLine()) != null) {
				
				String [] fields = linea.split(",");
				
				Alumne al1 = new Alumne(fields [0],
						Integer.parseInt(fields [1]),
						fields [2],Double.parseDouble(fields [3]));
				
				alumnos.add(al1);
			}
			fr1.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
                fr1.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
		}
		
		return alumnos;
	}
	
    public static Alumne cercarMillorNota(ArrayList<Alumne> alumnos) {
        if (alumnos == null) {
            return null;
        }
        Alumne a = alumnos.get(0);
        for (int i = 1; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNotamedia() > a.getNotamedia()) {
                a = alumnos.get(i);
            }
        }
        return a;
    }
    
    public static void exportarAprovats(String nom, ArrayList<Alumne> alumnos) {
        FileWriter fw = null;
        try {
            File f = new File(nom);
            fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
            for (Alumne alumno : alumnos) {
                if (alumno.aprovat()) {
                    bfw.write(alumno.toCSV());
                    bfw.newLine();
                }
            }
            bfw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void exportarAprovatsSerial(String nom, ArrayList<Alumne> alumnos) {
        try {
        	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nom));
            for (Alumne alumno : alumnos) {
                if (alumno.aprovat()) {
                	oos.writeObject(alumnos);
                }
            }
            oos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
	
	public static void main(String[] args) throws IOException, Throwable {
        ArrayList<Alumne> alumnos;
        alumnos = importar(nombreFicheroIN);
        for (Alumne alumno: alumnos) {
        	System.out.println(alumno);
        }
        Alumne NotaMesAlta = cercarMillorNota(alumnos);
        System.out.println("L'alumne amb la nota mes elevada es: "+ NotaMesAlta);
        
        exportarAprovats(nombreFicheroOUT, alumnos);
        
        exportarAprovatsSerial(nombreFicheroSERIALOUT, alumnos);

	}

}