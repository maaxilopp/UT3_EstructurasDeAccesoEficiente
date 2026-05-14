package ucu.edu.aed.medible.medibles;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.tda.trie.TTrie;

import java.util.List;
import java.util.Map;

public class MedicionBuscarHashMap  extends Medible<List<String>> {

    private final Map<String, String> hashMap;

    // Recibe el Trie que se quiere medir.
    public MedicionBuscarHashMap ( Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        // Repite varias veces la búsqueda de todas las palabras sobre el Trie.
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                hashMap.get(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return hashMap;
    }
}


