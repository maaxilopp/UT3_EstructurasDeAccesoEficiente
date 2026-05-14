package ucu.edu.aed.medible.medibles;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.tda.trie.TTrie;

import java.util.List;

public class MedicionBuscarTTrie extends Medible<List<String>> {

    // Trie sobre el que se van a realizar las búsquedas.
    private final TTrie<String> trie;

    // Recibe el Trie que se quiere medir.
    public MedicionBuscarTTrie(TTrie<String> trie) {
        this.trie = trie;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        // Repite varias veces la búsqueda de todas las palabras sobre el Trie.
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                trie.buscar(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return trie;
    }
}
