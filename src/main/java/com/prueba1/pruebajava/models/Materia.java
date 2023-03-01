package com.prueba1.pruebajava.models;

public class Materia extends Clase {
    
    public String nombreMateria;
    // se agrega profesor aca ya que la materia siempre tendra un profesor a cargo 
    public String profesorImparte;

    public Materia() {
        super();
    }

    public Materia(String nombreCurso, String nombreMateria, String profesorImparte) {
        super(nombreCurso);
        this.nombreMateria = nombreMateria;
        this.profesorImparte = profesorImparte;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getProfesorImparte() {
        return profesorImparte;
    }

    public void setProfesorImparte(String profesorImparte) {
        this.profesorImparte = profesorImparte;
    }

    @Override
    public String toString() {
        return super.toString()+ "Materia [nombreMateria=" + nombreMateria + ", profesorImparte=" + profesorImparte + "]";
    }

    

    

    
}
