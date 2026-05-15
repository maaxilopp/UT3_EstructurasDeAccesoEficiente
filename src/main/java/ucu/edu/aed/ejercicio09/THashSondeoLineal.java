package ucu.edu.aed.ejercicio09;

import ucu.edu.aed.tda.hash.Entry;
import ucu.edu.aed.tda.hash.Report;
import ucu.edu.aed.tda.hash.THash;
import ucu.edu.aed.tda.hash.TNodoHash;

import java.util.ArrayList;
import java.util.List;

public class THashSondeoLineal<K, V> extends THash<K, V> {

    private int cantidadElementos = 0;

    public THashSondeoLineal(int capacidad) {
        super(capacidad);
    }

    @Override
    protected int calcularCapacidadOptima(int elementosEsperados) {

        return elementosEsperados;
    }

    @Override
    protected int functionHashing(K valor) {
        return Math.abs(valor.hashCode()) % hashTable.length;
    }

    @Override
    public boolean insertar(K clave, V valor, Report report) {
        int pos = functionHashing(clave);
        int comparaciones = 0;
        int primerlugarExOcupado = -1;
        for (int i = 0; i < hashTable.length; i++) {
            int idx = (pos + i) % hashTable.length;
            comparaciones++;

            if (hashTable[idx] == null) {
                int insertPos = (primerlugarExOcupado != -1) ? primerlugarExOcupado : idx;
                hashTable[insertPos] = new TNodoHash<>(clave, valor);
                cantidadElementos++;
                report.setCantidadComparaciones(comparaciones);
                return true;
            } else if (hashTable[idx].isLoteLibre()) {
                if (primerlugarExOcupado == -1) primerlugarExOcupado = idx;
            } else if (hashTable[idx].getClave().equals(clave)) {
                report.setCantidadComparaciones(comparaciones);
                return false;
            }
        }

        if (primerlugarExOcupado != -1) {
            hashTable[primerlugarExOcupado] = new TNodoHash<>(clave, valor);
            cantidadElementos++;
            report.setCantidadComparaciones(comparaciones);
            return true;
        }

        report.setCantidadComparaciones(comparaciones);
        return false;
    }

    @Override
    public V buscar(K clave, Report report) {
        int pos = functionHashing(clave);
        int comparaciones = 0;

        for (int i = 0; i < hashTable.length; i++) {
            int idx = (pos + i) % hashTable.length;
            comparaciones++;

            if (hashTable[idx] == null) {
                break;
            } else if (!hashTable[idx].isLoteLibre() && hashTable[idx].getClave().equals(clave)) {
                report.setCantidadComparaciones(comparaciones);
                return hashTable[idx].getValor();
            }
        }

        report.setCantidadComparaciones(comparaciones);
        return null;
    }

    @Override
    public boolean delete(K clave, Report report) {
        int pos = functionHashing(clave);
        int comparaciones = 0;

        for (int i = 0; i < hashTable.length; i++) {
            int idx = (pos + i) % hashTable.length;
            comparaciones++;

            if (hashTable[idx] == null) {
                break;
            } else if (!hashTable[idx].isLoteLibre() && hashTable[idx].getClave().equals(clave)) {
                hashTable[idx].setLoteLibre(true);
                cantidadElementos--;
                report.setCantidadComparaciones(comparaciones);
                return true;
            }
        }

        report.setCantidadComparaciones(comparaciones);
        return false;
    }

    @Override
    public boolean esVacio() {
        return cantidadElementos == 0;
    }

    @Override
    public void vaciar() {
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = null;
        }
        cantidadElementos = 0;
    }

    @Override
    protected boolean redimensionar() {
        return false;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        List<Entry<K, V>> lista = new ArrayList<>();
        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getEntry());
            }
        }
        return lista;
    }

    @Override
    public Iterable<K> keys() {
        List<K> lista = new ArrayList<>();
        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getClave());
            }
        }
        return lista;
    }

    @Override
    public Iterable<V> values() {
        List<V> lista = new ArrayList<>();
        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getValor());
            }
        }
        return lista;
    }
}
