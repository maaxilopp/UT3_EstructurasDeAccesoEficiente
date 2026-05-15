package ucu.edu.aed.ejercicio09;

import ucu.edu.aed.tda.hash.Report;

public class Main {
    public static void main(String[] args) {
        int capacidad = 500;
        int[] factoresDeCarga = {70, 75, 80, 85, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

        for (int i : factoresDeCarga) {
            THashSondeoLineal<String, Integer> tabla = new THashSondeoLineal<>(capacidad);
            int cantElementos = (capacidad * i) / 100;
            double totalInser = 0;
            for (int j = 0; j < cantElementos; j++) {
                String clave = "profe si lees esto fue el ejercicio mas duro que hice" + j;
                Report r = new Report();
                tabla.insertar(clave, j, r);
                totalInser += r.getCantidadComparaciones();
            }
            double promInser = (double) totalInser / cantElementos;
            double totalBuscExit = 0;
            for (int j = 0; j < cantElementos; j++) {
                String clave = "clave" + j;
                Report r = new Report();
                tabla.buscar(clave, r);
                totalBuscExit += r.getCantidadComparaciones();
            }
            double promBuscExit = (double) totalBuscExit / cantElementos;

            double totalBuscSinExito = 0;
            for (int j = 0; j < cantElementos; j++) {
                String clave = "algoritmos" + j;
                Report r = new Report();
                tabla.buscar(clave, r);
                totalBuscSinExito += r.getCantidadComparaciones();
            }
            double promBuscSinExito = (double) totalBuscSinExito / cantElementos;

            System.out.println(i + "% | " + String.format("%.2f", promInser) + " | " + String.format("%.2f", promBuscExit) + "|" + String.format("%.2f", promBuscSinExito));
        }
    }
}