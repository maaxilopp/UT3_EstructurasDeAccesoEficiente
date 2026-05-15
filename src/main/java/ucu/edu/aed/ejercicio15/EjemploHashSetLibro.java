package ucu.edu.aed.ejercicio15;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetLibro {
    public static void main(String[] args) {
        Libro l1 = new Libro("94729", "Hola mundo", "Trinidad Bunge", 2026);
        Libro l2 = new Libro("94729", "Hola mundo", "Trinidad Bunge", 2026);

        Set<Libro> libros = new HashSet<>();
        libros.add(l1);
        libros.add(l2);

        System.out.println("Cantidad de elementos en el HashSet: " + libros.size());
        System.out.println("Contiene l1: " + libros.contains(l1));
        System.out.println("Contiene l2: " + libros.contains(l2));
    }
}
