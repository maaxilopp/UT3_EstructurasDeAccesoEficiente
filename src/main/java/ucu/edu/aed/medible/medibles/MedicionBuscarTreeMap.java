package ucu.edu.aed.medible.medibles;

import ucu.edu.aed.medible.lib.Medible;

import java.util.List;
import java.util.Map;

public class MedicionBuscarTreeMap extends Medible<List<String>>{
    private final Map<String, String> treeMap;

    public MedicionBuscarTreeMap ( Map<String, String> treeMap) {
        this.treeMap = treeMap;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        // Repite varias veces la búsqueda de todas las palabras sobre el Trie.
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                treeMap.get(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return treeMap;
    }
}

