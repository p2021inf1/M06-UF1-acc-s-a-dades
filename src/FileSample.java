//CLASSE PER EXAMINAR FITXERS I LES SEVES CARACTERÍSTIQUES

//args[0] és el nom del fitxer que volem mirar
//Es pot fer de dues maneres: A les configuracions del run, anar als
//arguments del programa i ficar allà la ruta del fitxer.
//Eclipse seria: Run As --> Run Configurations, anar a la pestanya Arguments
//i omplir el requadre program arguments amb la ruta del fitxer.

import java.io.File;

public class FileSample {

	public static void main(String[] args) {
		String route = args[0];
		File f1 = new File(route);
		
		if (f1.exists()) {
			if (f1.isFile()) {
				System.out.println("Mida: " + f1.length() );
				System.out.println("Es pot llegir: " + f1.canRead());
				System.out.println("Es pot escriure: " + f1.canWrite());
				System.out.println("Es pot executar: " + f1.canExecute());
			} else {
				String [] arxius = f1.list();
				System.out.println("El directori: " +  route + " conte: ");
				for (String arxiu : arxius) {
					System.out.println("\t" + arxiu);
				}
			}
		} else {
			System.out.println("El fitxer o ruta no existeixen");
		}
		
	}

}