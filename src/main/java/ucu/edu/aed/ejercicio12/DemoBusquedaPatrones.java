package ucu.edu.aed.ejercicio12;

import java.util.List;

public class DemoBusquedaPatrones {

    public static void main(String[] args) {
        TTrieHashMap trie = new TTrieHashMap();

        trie.insertar("ana");
        trie.insertar("nana");
        trie.insertar("ban");
        trie.insertar("anaa");

        String texto = "bananana";

        List<TTrieHashMap.PosicionPatron> patrones = trie.buscarPatrones(texto);

        System.out.println("Patrones encontrados:");
        for (TTrieHashMap.PosicionPatron p : patrones) {
            System.out.println(p);
        }
    }
}
