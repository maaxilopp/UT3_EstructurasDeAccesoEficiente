package ucu.edu.aed.ejercicio12;


import java.util.List;

public class DemoAutocompletar {

    public static void main(String[] args) {
        TTrieHashMap trie = new TTrieHashMap();

        trie.insertar("casa");
        trie.insertar("casar");
        trie.insertar("casamiento");
        trie.insertar("casco");
        trie.insertar("camino");
        trie.insertar("cama");
        trie.insertar("canal");
        trie.insertar("arbol");

        String prefijo = "cas";
        List<String> sugerencias = trie.autocompletar(prefijo);

        System.out.println("Sugerencias para el prefijo " + prefijo + ":");
        for (String palabra : sugerencias) {
            System.out.println(palabra);
        }
    }
}