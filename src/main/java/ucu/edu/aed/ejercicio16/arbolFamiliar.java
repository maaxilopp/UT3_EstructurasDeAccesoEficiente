package ucu.edu.aed.ejercicio16;

import ucu.edu.aed.tda.generic_trie.impl.TArbolGenericoImpl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class arbolFamiliar {

    private TArbolGenericoImpl<Persona> arbol;
    private Persona raiz;

    public arbolFamiliar(TArbolGenericoImpl<Persona> arbol, Persona raiz) {
        this.arbol = arbol;
        this.raiz = raiz;
    }

    public List<Persona> listarDescendientes(Persona persona) {
        LinkedList<Persona> descendientes = new LinkedList<>();
        arbol.preOrden(p -> {
            Persona padre = arbol.obtenerPadre(p);
            while (padre != null) {
                if (padre.compareTo(persona) == 0) {
                    descendientes.add(p);
                    break;
                }
                padre = arbol.obtenerPadre(padre);
            }
        });
        return descendientes;
    }

    public int alturaArbol() {
        return arbol.altura(raiz);
    }

    public int contarPersonas() {
        int[] cont = {0};
        arbol.preOrden(p -> cont[0]++);
        return cont[0];
    }

    public List<Persona> obtenerGeneracion(int generacion) {
        LinkedList<Persona> resultado = new LinkedList<>();
        arbol.preOrden(p -> {
            int nivel = 0;
            Persona padre = arbol.obtenerPadre(p);
            while (padre != null) {
                nivel++;
                padre = arbol.obtenerPadre(padre);
            }
            if (nivel == generacion) resultado.add(p);
        });
        return resultado;
    }

    public Persona ancestroComunMasCercano(Persona a, Persona b) {
        Set<Persona> ancestrosA = new HashSet<>();
        Persona actual = a;
        while (actual != null) {
            ancestrosA.add(actual);
            actual = arbol.obtenerPadre(actual);
        }
        Persona actualB = b;
        while (actualB != null) {
            if (ancestrosA.contains(actualB)) return actualB;
            actualB = arbol.obtenerPadre(actualB);
        }
        return null;
    }

    public boolean esDescendiente(Persona ancestro, Persona posibleDescendiente) {
        if (ancestro.compareTo(posibleDescendiente) == 0) return false;
        Persona actual = arbol.obtenerPadre(posibleDescendiente);
        while (actual != null) {
            if (actual.compareTo(ancestro) == 0) return true;
            actual = arbol.obtenerPadre(actual);
        }
        return false;
    }
}