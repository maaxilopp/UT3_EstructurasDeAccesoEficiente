package ucu.edu.aed.ejercicio16;

public class Persona implements Comparable <Persona> {
    String nombre;
    int añoNacimiento;

    public Persona(String nombre, int añoNacimiento) {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + añoNacimiento + ")";
    }
}



