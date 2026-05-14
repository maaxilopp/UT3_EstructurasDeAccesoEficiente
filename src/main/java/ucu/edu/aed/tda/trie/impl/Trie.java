package ucu.edu.aed.tda.trie.impl;

import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TTrie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Trie implements TTrie<String>, Serializable {
    private final NodoTrie raiz;

    public Trie() {
        this.raiz = new NodoTrie();
    }

    @Override
    public void recorrer(Consumer<Entry<String>> consumer) {
        raiz.recorrer(consumer);
    }

    @Override
    public Entry<String> buscar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return null;
        }
        return raiz.buscar(palabra);
    }

    @Override
    public boolean insertar(String palabra, String dato) {
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }
        return raiz.insertar(palabra, dato);
    }

    @Override
    public List<Entry<String>> predecir(String prefijo) {
        if (prefijo == null) {
            return List.of();
        }
        return raiz.predecir(prefijo);
    }
}
