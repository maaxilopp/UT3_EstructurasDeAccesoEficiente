package ucu.edu.aed.ejercicio16;

import ucu.edu.aed.tda.generic_trie.impl.TArbolGenericoImpl;

public class Main {
    public static void main(String[] args) {
        Persona maximiliano = new Persona("Maximiliano", 1935);
        Persona trinidad = new Persona("Trinidad", 1955);
        Persona juani = new Persona("Juan ignacio", 1980);
        Persona paola = new Persona("Paola", 1984);
        Persona santiago = new Persona("Santiago", 2010);
        Persona lucas = new Persona("Lucas", 2015);
        Persona violeta = new Persona("Violeta", 2020);
        Persona jesus = new Persona("Jesus", 2022);
        Persona camila = new Persona("Camila", 2024);
        Persona vladimir = new Persona("Vladimir", 2026);

        TArbolGenericoImpl<Persona> arbol = new TArbolGenericoImpl<>(maximiliano);
        arbol.agregarHijo(maximiliano, trinidad);
        arbol.agregarHijo(trinidad, juani);
        arbol.agregarHijo(trinidad, paola);
        arbol.agregarHijo(juani, santiago);
        arbol.agregarHijo(juani, lucas);
        arbol.agregarHijo(paola, violeta);
        arbol.agregarHijo(paola, jesus);
        arbol.agregarHijo(paola, camila);
        arbol.agregarHijo(paola, vladimir);

        System.out.println(arbol);

        arbolFamiliar familia = new arbolFamiliar(arbol, maximiliano);


        System.out.println("Descendientes de Trinidad:");
        familia.listarDescendientes(trinidad).forEach(p -> System.out.println("   - " + p.getNombre()));

        System.out.println("\nAltura del arbol: " + familia.alturaArbol());


        System.out.println("\nCantidad total de personas: " + familia.contarPersonas());


        System.out.println("\nPersonas en generacion 2:");
        familia.obtenerGeneracion(2).forEach(p -> System.out.println("   - " + p.getNombre()));

        System.out.println("\nAncestro comun mas cercano (Jesus, Santiago): "
                + familia.ancestroComunMasCercano(jesus, santiago).getNombre());
        System.out.println("Ancestro comun mas cercano (Camila, Vladimir): "
                + familia.ancestroComunMasCercano(camila, vladimir).getNombre());

        System.out.println("\nJesus es descendiente de Trinidad? "
                + familia.esDescendiente(trinidad, jesus));
        System.out.println("Santiago es descendiente de Paola? "
                + familia.esDescendiente(paola, santiago));
    }
}