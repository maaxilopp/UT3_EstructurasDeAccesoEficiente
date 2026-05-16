package ucu.edu.aed.tda.generic_trie.impl;

import ucu.edu.aed.tda.generic_trie.TNodoGenerico;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class TNodoGenericoImpl<T extends Comparable<T>> implements TNodoGenerico<T> {

    private T dato;
    private List<TNodoGenericoImpl<T>> hijos;

    public TNodoGenericoImpl(T dato) {
        this.dato = dato;
        this.hijos = new LinkedList<>();
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public boolean agregarHijo(T padre, T hijo) {
        if (this.dato.compareTo(padre) == 0) {
            this.hijos.add(new TNodoGenericoImpl<>(hijo));
            return true;
        }
        for (TNodoGenericoImpl<T> h : hijos) {
            if (h.agregarHijo(padre, hijo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public TNodoGenerico<T> buscar(Comparable<T> criterio) {
        if (criterio.compareTo(this.dato) == 0) {
            return this;
        }
        for (TNodoGenericoImpl<T> h : hijos) {
            TNodoGenerico<T> encontrado = h.buscar(criterio);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }

    @Override
    public TNodoGenerico<T> obtenerPadre(Comparable<T> criterio) {
        for (TNodoGenericoImpl<T> h : hijos) {
            if (criterio.compareTo(h.getDato()) == 0) {
                return this;
            }
        }
        for (TNodoGenericoImpl<T> h : hijos) {
            TNodoGenerico<T> padre = h.obtenerPadre(criterio);
            if (padre != null) {
                return padre;
            }
        }
        return null;
    }

    @Override
    public TNodoGenerico<T> eliminar(Comparable<T> criterio) {
        for (int i = 0; i < hijos.size(); i++) {
            if (criterio.compareTo(hijos.get(i).getDato()) == 0) {
                TNodoGenericoImpl<T> eliminado = hijos.remove(i);
                return eliminado;
            }
        }
        for (TNodoGenericoImpl<T> h : hijos) {
            TNodoGenerico<T> eliminado = h.eliminar(criterio);
            if (eliminado != null) {
                return eliminado;
            }
        }
        return null;
    }

    @Override
    public void preOrden(Consumer<TNodoGenerico<T>> consumidor) {
        consumidor.accept(this);
        for (TNodoGenericoImpl<T> h : hijos) {
            h.preOrden(consumidor);
        }
    }

    @Override
    public void inOrden(Consumer<TNodoGenerico<T>> consumidor) {
        if (!hijos.isEmpty()) {
            hijos.get(0).inOrden(consumidor);
        }
        consumidor.accept(this);
        for (int i = 1; i < hijos.size(); i++) {
            hijos.get(i).inOrden(consumidor);
        }
    }

    @Override
    public void postOrden(Consumer<TNodoGenerico<T>> consumidor) {
        for (TNodoGenericoImpl<T> h : hijos) {
            h.postOrden(consumidor);
        }
        consumidor.accept(this);
    }

    @Override
    public int altura() {
        if (hijos.isEmpty()) {
            return 0;
        }
        int maxAltura = 0;
        for (TNodoGenericoImpl<T> h : hijos) {
            int alturaHijo = h.altura();
            if (alturaHijo > maxAltura) {
                maxAltura = alturaHijo;
            }
        }
        return 1 + maxAltura;
    }

    @Override
    public int grado() {
        return hijos.size();
    }

    @Override
    public void vaciar() {
        for (TNodoGenericoImpl<T> h : hijos) {
            h.vaciar();
        }
        hijos.clear();
        dato = null;
    }

    @Override
    public List<T> obtenerHijos() {
        List<T> resultado = new LinkedList<>();
        for (TNodoGenericoImpl<T> h : hijos) {
            resultado.add(h.getDato());
        }
        return resultado;
    }
}