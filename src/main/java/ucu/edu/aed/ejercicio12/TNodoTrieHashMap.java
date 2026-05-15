package ucu.edu.aed.ejercicio12;

import java.util.HashMap;
import java.util.Map;

public class TNodoTrieHashMap {

    private final Map<Character, TNodoTrieHashMap> hijos;
    private boolean finDePalabra;

    public TNodoTrieHashMap() {
        this.hijos = new HashMap<>();
        this.finDePalabra = false;
    }

    public Map<Character, TNodoTrieHashMap> getHijos() {
        return hijos;
    }

    public boolean isFinDePalabra() {
        return finDePalabra;
    }

    public void setFinDePalabra(boolean finDePalabra) {
        this.finDePalabra = finDePalabra;
    }

    public boolean tieneHijo(char c) {
        return hijos.containsKey(c);
    }

    public TNodoTrieHashMap getHijo(char c) {
        return hijos.get(c);
    }

    public void agregarHijo(char c, TNodoTrieHashMap nodo) {
        hijos.put(c, nodo);
    }
}