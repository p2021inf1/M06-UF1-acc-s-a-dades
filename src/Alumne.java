//CLASSE PER EXPLICAR SERIALITZACIO I DES SERIALITZACIO

import java.io.Serializable;

public class Alumne implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
    private int edad;
    private String ciclo;
    private double notamedia;

    public Alumne (String nombre, int edad, String ciclo, double d) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setCiclo(ciclo);
        this.setNotamedia(d);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public double getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(double d) {
        this.notamedia = d;
    }

    @Override
    public String toString() {
        return nombre + ", edad " + edad + ", estudia el ciclo " + ciclo + " y tiene una media de " + notamedia;
    }
    
    public String toCSV() {
    	return nombre + "," + edad + "," + ciclo + "," + notamedia ;
    }
    
    public boolean aprovat(){
        return this.notamedia>5;
    }
}