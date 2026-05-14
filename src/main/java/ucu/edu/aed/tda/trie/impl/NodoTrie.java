package ucu.edu.aed.tda.trie.impl;

import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TNodoTrie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NodoTrie implements TNodoTrie<String>, Serializable {
    private final NodoTrie[] hijos;
    private Entry <String> dato;
    private boolean esFinDePalabra ;

    public NodoTrie() {
        this.hijos = new NodoTrie[26];
        this.dato = null;
        this.esFinDePalabra = false;
    }

    @Override
    public void recorrer(Consumer<Entry<String>> consumer) {
        if (esFinDePalabra && dato != null) {
            consumer.accept(dato);
        }

        for (NodoTrie hijo : hijos) {
            if (hijo != null) {
                hijo.recorrer(consumer);
            }
        }
    }

    @Override
    public Entry<String> buscar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return null;
        }
        NodoTrie nodoActual = this;
        for (int i = 0; i < palabra.length(); i++) {
            char letra = Character.toLowerCase(palabra.charAt(i));
            int indice = letra - 'a';
            if (indice < 0 || indice >= 26 || nodoActual.hijos[indice] == null) {
                return null;
            }
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
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }

        NodoTrie actual = this;

        for (int i = 0; i < palabra.length(); i++) {
            char letra = Character.toLowerCase(palabra.charAt(i));
            int indice = letra - 'a';
            if (indice < 0 || indice >= 26) {
                return false;
            }

            if (actual.hijos[indice] == null) {
                actual.hijos[indice] = new NodoTrie();
            }

            actual = actual.hijos[indice];
        }

        boolean yaExistia = actual.esFinDePalabra;
        actual.esFinDePalabra = true;
        actual.dato = new Entry<>(dato, true, palabra);

        return !yaExistia;
    }

    @Override
    public List<Entry<String>> predecir(String prefijo) {
        if (prefijo == null || prefijo.isEmpty()) {
            return List.of();
        }
        NodoTrie actual = this;

        for (int i = 0; i < prefijo.length(); i++) {
            char letra = Character.toLowerCase(prefijo.charAt(i));
            int indice = letra - 'a';

            if (indice < 0 || indice >= 26 || actual.hijos[indice] == null) {
                return List.of();
            }

            actual = actual.hijos[indice];
        }

        List<Entry<String>> resultados = new ArrayList<>();
        actual.recorrer(resultados::add);
        return resultados;
    }


    @Override
    public String getDato() {
        return String.valueOf(dato);
    }

    @Override
    public boolean esPalabra() {
        return esFinDePalabra;
    }
}
