package ucu.edu.aed.ejercicio12;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TTrieHashMap {

    private final TNodoTrieHashMap raiz;

    public TTrieHashMap() {
        this.raiz = new TNodoTrieHashMap();
    }

    public void insertar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return;
        }

        String normalizada = palabra.toLowerCase();
        TNodoTrieHashMap actual = raiz;

        for (char c : normalizada.toCharArray()) {
            if (!actual.tieneHijo(c)) {
                actual.agregarHijo(c, new TNodoTrieHashMap());
            }
            actual = actual.getHijo(c);
        }

        actual.setFinDePalabra(true);
    }


    public boolean buscar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }

        TNodoTrieHashMap nodo = buscarNodo(palabra.toLowerCase());
        return nodo != null && nodo.isFinDePalabra();
    }

    // Búsqueda de prefijo
    public boolean predecir(String prefijo) {
        if (prefijo == null || prefijo.isEmpty()) {
            return false;
        }

        return buscarNodo(prefijo.toLowerCase()) != null;
    }

    // Devuelve todas las palabras que empiezan con el prefijo
    public List<String> autocompletar(String prefijo) {
        List<String> resultados = new ArrayList<>();

        if (prefijo == null) {
            return resultados;
        }

        String pref = prefijo.toLowerCase();
        TNodoTrieHashMap nodo = buscarNodo(pref);

        if (nodo == null) {
            return resultados;
        }

        recolectarPalabras(nodo, new StringBuilder(pref), resultados);
        return resultados;
    }


    // Devuelve las posiciones donde ocurre cada patrón encontrado
    public List<PosicionPatron> buscarPatrones(String texto) {
        List<PosicionPatron> ocurrencias = new ArrayList<>();

        if (texto == null || texto.isEmpty()) {
            return ocurrencias;
        }

        String t = texto.toLowerCase();

        for (int i = 0; i < t.length(); i++) {
            TNodoTrieHashMap actual = raiz;
            int j = i;

            while (j < t.length()) {
                char c = t.charAt(j);

                if (!actual.tieneHijo(c)) {
                    break;
                }

                actual = actual.getHijo(c);

                if (actual.isFinDePalabra()) {
                    ocurrencias.add(new PosicionPatron(t.substring(i, j + 1), i));
                }

                j++;
            }
        }

        return ocurrencias;
    }

    // Metodos auxiliares

    private TNodoTrieHashMap buscarNodo(String texto) {
        TNodoTrieHashMap actual = raiz;

        for (char c : texto.toLowerCase().toCharArray()) {
            if (!actual.tieneHijo(c)) {
                return null;
            }
            actual = actual.getHijo(c);
        }

        return actual;
    }

    private void recolectarPalabras(TNodoTrieHashMap nodo, StringBuilder prefijo, List<String> resultados) {
        if (nodo.isFinDePalabra()) {
            resultados.add(prefijo.toString());
        }

        for (Map.Entry<Character, TNodoTrieHashMap> entry : nodo.getHijos().entrySet()) {
            prefijo.append(entry.getKey());
            recolectarPalabras(entry.getValue(), prefijo, resultados);
            prefijo.deleteCharAt(prefijo.length() - 1);
        }
    }

    // Clase auxiliar para representar patrón y posición
    public static class PosicionPatron {
        private final String patron;
        private final int posicion;

        public PosicionPatron(String patron, int posicion) {
            this.patron = patron;
            this.posicion = posicion;
        }
        public String getPatron() {
            return patron;
        }
        public int getPosicion() {
            return posicion;
        }
        @Override
        public String toString() {
            return "Patrón: " + patron + ", posición: " + posicion;
        }
    }
}