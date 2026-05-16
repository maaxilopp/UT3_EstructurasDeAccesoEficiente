package ucu.edu.aed.tda.generic_trie.impl;

import ucu.edu.aed.tda.generic_trie.TArbolGenerico;
import ucu.edu.aed.tda.generic_trie.TNodoGenerico;

import java.util.function.Consumer;

public class TArbolGenericoImpl<T extends Comparable<T>> implements TArbolGenerico<T> {

    private TNodoGenericoImpl<T> raiz;

    public TArbolGenericoImpl(T datoRaiz) {
        this.raiz = new TNodoGenericoImpl<>(datoRaiz);
    }

    @Override
    public boolean agregarHijo(Comparable<T> padre, T hijo) {
        return raiz.agregarHijo((T) padre, hijo);
    }

    @Override
    public void eliminar(Comparable<T> criterio) {
        if (criterio.compareTo(raiz.getDato()) == 0) {
            raiz = null;
        } else {
            raiz.eliminar(criterio);
        }
    }

    @Override
    public T obtenerPadre(Comparable<T> criterio) {
        if (raiz == null) return null;
        TNodoGenerico<T> padre = raiz.obtenerPadre(criterio);
        return padre != null ? padre.getDato() : null;
    }

    @Override
    public T buscar(Comparable<T> criterio) {
        if (raiz == null) return null;
        TNodoGenerico<T> nodo = raiz.buscar(criterio);
        return nodo != null ? nodo.getDato() : null;
    }

    @Override
    public void preOrden(Consumer<T> consumidor) {
        if (raiz != null) raiz.preOrden(n -> consumidor.accept(n.getDato()));
    }

    @Override
    public void inOrden(Consumer<T> consumidor) {
        if (raiz != null) raiz.inOrden(n -> consumidor.accept(n.getDato()));
    }

    @Override
    public void postOrden(Consumer<T> consumidor) {
        if (raiz != null) raiz.postOrden(n -> consumidor.accept(n.getDato()));
    }

    @Override
    public void vaciar() {
        if (raiz != null) {
            raiz.vaciar();
            raiz = null;
        }
    }

    @Override
    public int grado(Comparable<T> criterio) {
        if (raiz == null) return -1;
        TNodoGenerico<T> nodo = raiz.buscar(criterio);
        return nodo != null ? nodo.grado() : -1;
    }

    @Override
    public int altura(Comparable<T> criterio) {
        if (raiz == null) return -1;
        TNodoGenerico<T> nodo = raiz.buscar(criterio);
        return nodo != null ? nodo.altura() : -1;
    }
    public TNodoGenerico<T> buscarNodo(Comparable<T> criterio) {
        return raiz == null ? null : raiz.buscar(criterio);
    }

    @Override
    public String toString() {
        if (raiz == null) return "(arbol vacio)";
        StringBuilder sb = new StringBuilder();
        preOrden(p -> {
            int nivel = 0;
            T padre = obtenerPadre(p);
            while (padre != null) {
                nivel++;
                padre = obtenerPadre(padre);
            }
            for (int i = 0; i < nivel; i++) sb.append("  ");
            sb.append(nivel == 0 ? "" : "|-- ")
                    .append(p.toString())
                    .append("\n");
        });
        return sb.toString();
    }
}