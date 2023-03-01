package com.prueba1.pruebajava.models;

// hereda la clase alumno, ya que un alumno tiene la clase
public class Clase extends Alumno {
    
    public String nombreCurso;

    public Clase() {
        super();
    }
    

    public Clase(String nombreAlumno, Double nota, String nombreCurso) {
        super(nombreAlumno, nota);
        this.nombreCurso = nombreCurso;
    }


    public Clase(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @Override
    public String toString() {
        return super.toString()+" pertenece al curso: " + nombreCurso+"\n";
    }

    

    

    
}
