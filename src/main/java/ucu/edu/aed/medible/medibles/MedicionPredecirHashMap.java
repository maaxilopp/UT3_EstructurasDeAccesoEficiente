package ucu.edu.aed.medible.medibles;

import ucu.edu.aed.medible.lib.Medible;

import java.util.List;
import java.util.Map;

public class MedicionPredecirHashMap extends Medible<String> {

    private final Map<String, String> hashMap;

    public MedicionPredecirHashMap(Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(int repeticiones, String prefijo) {
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : hashMap.keySet()) {
                if (palabra.startsWith(prefijo)) {
                    // coincidencia encontrada
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return hashMap;
    }
}