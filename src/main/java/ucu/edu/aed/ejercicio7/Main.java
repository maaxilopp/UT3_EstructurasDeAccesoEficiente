package ucu.edu.aed.ejercicio7;


import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.medible.lib.Medicion;
import ucu.edu.aed.medible.medibles.*;
import ucu.edu.aed.tda.trie.TTrie;
import ucu.edu.aed.tda.trie.impl.Trie;
import ucu.edu.aed.utils.FileUtils;

import java.util.*;

public class Main {

    private static final int REPETICIONES = 20;


    public static void main(String[] args) {
        TTrie<String> trie = new Trie();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        List<String> palabrasParaAgregar = new LinkedList<>();
        List<String> palabrasParaBuscar = new LinkedList<>();
        FileUtils.leerLineas("./ut03/listado-general-desordenado.txt", palabrasParaAgregar::add);
        FileUtils.leerLineas("./ut03/listado-general-palabrasBuscar.txt", palabrasParaBuscar::add);

        for (String p : palabrasParaAgregar) {
            // insertar la palabra p en el trie
            trie.insertar(p,p);
            // insertar la palabra p en el linkedList
            linkedList.add(p);
            // insertar la palabra p en el arrayList
            arrayList.add(p);
            // insertar la palabra p en el hashMap
            hashMap.put(p, p);
            // insertar la palabra p en el treeMap
            treeMap.put(p, p);
        }

        List<Medible<List<String>>> medibles = new LinkedList<>();
        medibles.add(new MedicionBuscarArrayList(arrayList));
        medibles.add(new MedicionBuscarLinkedList(linkedList));
        medibles.add(new MedicionBuscarHashMap(hashMap));
        medibles.add(new MedicionBuscarTreeMap(treeMap));
        medibles.add(new MedicionBuscarTTrie(trie));


        StringBuilder sb = new StringBuilder();
        sb.append("algoritmo,tiempo,memoria\n");

        for (Medible<List<String>> m : medibles) {
            Medicion mi = m.medir(REPETICIONES, palabrasParaBuscar);
            mi.print();
            sb
                    .append(mi.toCSV())
                    .append("\n");
        }

        // bloque PREDECIR: medimos predecir("cas") 20 veces
        String prefijo = "cas";
        List<Medible<String>> medibles2 = new LinkedList<>();
        medibles2.add(new MedicionPredecirLinkedList(linkedList));
        medibles2.add(new MedicionPredecirHashMap(hashMap));
        medibles2.add(new MedicionPredecirTrie(trie));

        StringBuilder sb2 = new StringBuilder();
        sb2.append("algoritmo,tiempo,memoria\n");

        // Iteramos medibles2 y cada medible espera un String (el prefijo)
        for (Medible<String> m2 : medibles2) {
            Medicion mi = m2.medir(REPETICIONES, prefijo);
            mi.print();
            sb2.append(mi.toCSV()).append("\n");
        }

        FileUtils.escribirLineas("./salida_predecir.csv", sb2.toString());


    }
}