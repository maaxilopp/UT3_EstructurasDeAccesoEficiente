package ucu.edu.aed.ejercicio15;

import org.junit.jupiter.api.Test;

public class PruebaLibros {

    @Test
    public void mismoISBNIngresaUnelemento() {
        Libro a = new Libro("1", "Título A", "Autor A", 2020);
        Libro b = new Libro("1", "Título B", "Autor B", 2021);
        assert a.equals(b);
    }

    @Test
    public void diferenteISBNIngresaDosElementos() {
        Libro a = new Libro("1", "Título A", "Autor A", 2020);
        Libro b = new Libro("2", "Título B", "Autor B", 2021);
        assert !a.equals(b);
    }

    @Test
    public void mismoISBNHashCodeIgual() {
        Libro a = new Libro("1", "Título A", "Autor A", 2020);
        Libro b = new Libro("1", "Título B", "Autor B", 2021);
        assert a.hashCode() == b.hashCode();
    }

    @Test
    public void diferenteISBNHashCodeDiferente() {
        Libro a = new Libro("1", "Título A", "Autor A", 2020);
        Libro b = new Libro("2", "Título B", "Autor B", 2021);
        assert a.hashCode() != b.hashCode();
    }
}
