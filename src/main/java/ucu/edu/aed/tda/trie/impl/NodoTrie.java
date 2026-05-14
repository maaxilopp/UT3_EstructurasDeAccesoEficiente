package ucu.edu.aed.tda.trie.impl;

import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TNodoTrie;

import java.util.List;
import java.util.function.Consumer;

public class NodoTrie implements TNodoTrie<String> {
    private final NodoTrie[] hijos;
    private Entry <String> dato;
    private boolean esFinDePalabra ;

    public NodoTrie() {
        this.hijos = new NodoTrie[26];
        this.dato = null;
    }

    @Override
    public void recorrer(Consumer<Entry<String>> consumer) {

    }

    @Override
    public Entry<String> buscar(String palabra) {
        NodoTrie nodoActual = this;
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            int indice = letra - 'a';
            if (nodoActual.hijos[indice] == null) {
                return null;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if (nodoActual.esPalabra()) {
            return nodoActual.dato;
        }
        return null;
    }

    @Override
    public boolean insertar(String palabra, String dato) {
        NodoTrie actual = this;
        for (char s: palabra.toCharArray()){
            NodoTrie unHijo = actual.hijos[s];
            if (unHijo.hijos[s] == null) {
                unHijo = new NodoTrie();
                actual.hijos[s -'a'] = unHijo;
            }
            actual = unHijo;
        }
        actual.esFinDePalabra = true;
        actual.dato = new Entry<>(
                dato,
                true,
                palabra
        );
        return true;
    }

    @Override
    public List<Entry<String>> predecir(String prefijo) {
        return List.of();
    }

    @Override
    public String getDato() {
        return String.valueOf(dato);
    }

    @Override
    public boolean esPalabra() {
        return dato !=null;


    }
}
