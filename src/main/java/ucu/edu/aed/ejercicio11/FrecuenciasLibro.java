package ucu.edu.aed.ejercicio11;

import ucu.edu.aed.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrecuenciasLibro {

    public static void main(String[] args) {
        String archivo = "src/main/java/ucu/edu/aed/ejercicio11/libro.txt";
        Map<String, Integer> frecuencias = new HashMap<>();

        FileUtils.leerLineas(archivo, linea -> {
            // Normalizar: minúsculas y quitar puntuación
            linea = linea.toLowerCase();
            linea = linea.replaceAll("[^a-záéíóúüñ0-9]+", " ");

            // Separar en palabras
            String[] palabras = linea.trim().split("\\s+");

            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                }
            }
        });

        // Mostrar frecuencias completas
        System.out.println("Frecuencias de palabras:");
        for (Map.Entry<String, Integer> entry : frecuencias.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Ordenar y obtener top 10
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(frecuencias.entrySet());
        listaOrdenada.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nTop 10 palabras más frecuentes:");
        int limite = Math.min(10, listaOrdenada.size());
        for (int i = 0; i < limite; i++) {
            Map.Entry<String, Integer> entry = listaOrdenada.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}