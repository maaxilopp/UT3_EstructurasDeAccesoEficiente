package ucu.edu.aed.ejercicio15;

import java.util.Objects;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;

    public Libro(String isbn,String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getIsbn() {return isbn;}
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}
    public int getAnio() {return anio;}

    public void setIsbn(String isbn) {this.isbn = isbn;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setAnio(int anio) {this.anio = anio;}

    @Override
    public boolean equals (Object o){
        if (this == o) return true; //misma direccion de memoria
        if (o == null || getClass() != o.getClass()) return false; //si es nulo o las clases no coinciden
        Libro libro = (Libro) o; //casting del objeto a Libro
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn); //el isbn ya es unico
    }
}
