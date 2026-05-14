package ucu.edu.aed.medible.medibles;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TTrie;

import java.util.List;

public class MedicionPredecirTrie extends Medible<String> {

    private final TTrie<String> trie;

    public MedicionPredecirTrie(TTrie<String> trie) {
        this.trie = trie;
    }

    @Override
    public void ejecutar(int repeticiones, String prefijo) {
        for (int i = 0; i < repeticiones; i++) {
            List<Entry<String>> resultado = trie.predecir(prefijo);
            resultado.size();
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return trie;
    }
}