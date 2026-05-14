package ucu.edu.aed.tda.trie.impl;

import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TNodoTrie;
import ucu.edu.aed.tda.trie.TTrie;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Trie implements TTrie {
    private NodoTrie raiz = null;

    public Trie(NodoTrie raiz) {
        this.raiz = raiz;
    }

    @Override
    public void recorrer(Consumer consumer) {

    }

    @Override
    public Entry buscar(String palabra) {
        if (raiz ==  null){
            return null;
        }
        return raiz.buscar(palabra);
    }

    @Override
    public boolean insertar(String palabra, Object dato) {
        return false;
    }

    @Override
    public List<Entry> predecir(String prefijo) {
        return List.of();
    }
}
