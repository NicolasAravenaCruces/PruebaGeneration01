package com.prueba1.pruebajava.models;

public class Alumno{
    
    public String nombreAlumno;
    public Double nota;

    public Alumno() {
    }

    public Alumno(String nombreAlumno, Double nota) {
        this.nombreAlumno = nombreAlumno;
        this.nota = nota;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return " nombreAlumno: " + nombreAlumno + ", promedio: " + nota;
    }

    

    

    

    
}
