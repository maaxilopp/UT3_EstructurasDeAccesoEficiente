package ucu.edu.aed.ejercicio13;

public class Alumno {
    private int id;
    private String fullName;
    private String email;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id;   // equals por id ya que es único
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);  // hashCode basado en id
    }
}
