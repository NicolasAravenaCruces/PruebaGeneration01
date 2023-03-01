package com.prueba1.pruebajava;


import org.springframework.boot.autoconfigure.SpringBootApplication;
//ANTES DE EMPEZAR !!
/*como el caso practico hablaba de clase,alumnos,materias, profesores por logica empece haciendo los objetos primero, pero luego en las funciones no vi
 para que me serviria la materia por ejemplo o el profesor, ya que no iban al caso, asique como esto lo puedo ocupar despues para mejorarlo o si agregarle 
 esas cosas dejo el objeto materia igual creado 

*/
// importamos todo lo que utilizaremos para nuestras funciones y para poder llenar y llamar a mis objetos 
import com.prueba1.pruebajava.models.Alumno;
import com.prueba1.pruebajava.models.Clase;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class PruebajavaApplication {

	//1.- Se debe crear una función que permita al profesor ingresar notas por estudiante y que
    //luego permita obtener el promedio de cada estudiante.

	public static Double promedioNotas(ArrayList<Double>listaNotas){
		Double suma = 0.0;
		//recorrimos el array que contiene las notas
        for(int i = 0; i< listaNotas.size();i++){
			suma+=listaNotas.get(i);
		}
		//retorno el promedio 
		return suma/listaNotas.size();
	}

	//2.- Se debe crear una función que permita guardar un arreglo de una cierta cantidad de alumnos por curso y que luego los muestre.

	public static void cursos(){
		//iniciamos el array donde guardaremos los objetos de tipo clase
		ArrayList<Clase> curso = new ArrayList<Clase>();
		Scanner teclado = new Scanner(System.in);
		// pedimos al usuario ingresar cuantos alumnos tiene ese curso
		System.out.print("Cuantos alumnos tiene el curso: ");
		int cantidadAlumnos= teclado.nextInt();
		// recorrimos en total las veces por las que sea el total de alumnos
		for(int i = 1; i<=cantidadAlumnos; i++){
			Clase clase = new Clase();
			teclado.nextLine();
			// ocupo do para que por lo menos ingrese 1 nota y para que se repita hasta que i sea mayor a la cantidad de alumnos que ingresa el usuario
			do {
				System.out.println("Ingrese alumno n°"+i);
				System.out.print("Ingrese nombre del curso: ");
		        clase.setNombreCurso(teclado.nextLine());
				System.out.print("Ingrese Nombre del Alumno: ");
				clase.setNombreAlumno(teclado.nextLine());
				System.out.print("Ingrese promedio del Alumno: ");
				clase.setNota(teclado.nextDouble());			
			} while (i>cantidadAlumnos);
			// agregamos los alumnos al array de tipo clase
			curso.add(clase);
		}
		// mostramos todo el curso al usuario
		System.out.print(curso);

	}
     // 3.- Se debe crear una función que dado un arreglo de notas obtenga la mejor nota, la peor nota y el promedio de notas
	 // para mi la mejor nota siempre sera la mayor o mas alta, la peor la mas baja o menor por eso las variables
	public static void evaluar(ArrayList<Double>notas){
		Double mayor = 0.0;
		Double menor = 100.0;
		Double suma = 0.0;
		Double promedio = 0.0;
        // recorremos el arreglo en este caso de tipo Double
		for (int i = 0; i < notas.size(); i++) {
			//sumamos las notas 
			suma = suma + notas.get(i); 
			// ocupo dos if, y por que no un if else, por que aca necesito que si o si se cumplan las dos condiciones, y no que si no se cumpla la primera pase a al else recien
			// obligo al programa que pase si o si por los dos if
			if(notas.get(i)>mayor){
				mayor = notas.get(i);
			}
			if(notas.get(i)<menor){
				menor = notas.get(i);
			}
	
		}
		//sacamos el promedio y lo guardamos en la variable promedio 
		promedio = suma/notas.size();
        // mostramos el resultado
		System.out.println("La nota mas alta fue: "+mayor+"\nla nota mas baja fue: "+menor+ "\nel promedio de notas es de: "+promedio);
	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
        // parto la opcion en 1 para obligar al programa a entrar en el while principal
		// ocupe un menu para que fuera mas interactivo para el usuario
		int opcion=1;
		while(opcion!=0){
			do {
				System.out.println("Bienvenido");
				System.out.println("Ingresa 1 si quieres ver el promedio por alumno");
				System.out.println("Ingresa 2 si quieres guardar un curso");
				System.out.println("Ingresa 3 si quieres guardar notas y evaluarlas");
				System.out.println("Ingresa 0 para salir del menú");
				System.out.print("Ingresa tu opcion: ");
				opcion=teclado.nextInt();

			} while (opcion < 0 || opcion > 3);
			if(opcion==1){
				// inicializamos un hashmap para guardar un alumno con diferentes notas guardadas en un array 
				HashMap <String,ArrayList<Double>> notas = new HashMap<>();
				int cantAlum;
				int cantNotas;
				System.out.print("Indique cantidad de alumnos a ingresar : ");
				cantAlum = teclado.nextInt(); // pide cantidad de alumnos
				System.out.print("Indique cantidad de notas a ingresar : ");
				cantNotas= teclado.nextInt(); // pide cantidad de notas 
	
                // guardar las notas + el nombre del alumno en un hashmap traidas desde el objeto alumno
				for (int i = 1; i <= cantAlum; i++) {
					// array donde guardaremos las notas
					ArrayList<Double> notasAlumnos = new ArrayList<Double>(); 
					// inicializamos el objeto alumno
					Alumno alumno = new Alumno();
					teclado.nextLine();
					System.out.print("Ingrese nombre del alumno: ");
					// indicamos el nombre del alumno y lo seteamos en el objeto
					alumno.setNombreAlumno(teclado.nextLine());
					for (int x = 1; x <= cantNotas; x++) {
						//indicamos la nota del alumno y lo seteamos en el objeto
						System.out.print("Ingrese nota "+x+" del alumno "+alumno.getNombreAlumno()+" :");
						alumno.setNota(teclado.nextDouble());
						// finalmente guardamos las notas en el array 
						notasAlumnos.add(alumno.getNota());
						
					}
					//obtenemos el nombre del objeto alumno + el array de notas y lo guardamos en el hashmap	
					notas.put(alumno.getNombreAlumno(), notasAlumnos);		
		        }
				for(String i : notas.keySet()){
					//llamamos a la funcion promedio y le pasamos el valor de la key, que en este caso son de tipo array
					Double promAlumno = promedioNotas(notas.get(i));
		            System.out.println("El promedio del alumno "+ i + " es de:" + promAlumno);
				}
			}
			else if(opcion ==2){
				// llamamos a la funcion cursos, que en este caso todo lo hace en la funcion 
				cursos();

			}
			else if(opcion == 3){
				ArrayList<Double> notas = new ArrayList<Double>(); // creamos el array donde se guardaran las notas
				System.out.print("Cuantas notas vamos a ingresar?: ");
				int cantNotas = teclado.nextInt();
				for(int i=0; i<cantNotas;i++){ 
					Alumno alumno = new Alumno(); // creamos un objeto de tipo alumno nuevo
					do {
						System.out.println("Ingrese nota n°"+(i+1));
						System.out.print("Ingrese nota: ");
						alumno.setNota(teclado.nextDouble()); // seteamos o guardamos la nota
						
					} while (i>cantNotas);
					notas.add(alumno.getNota()); // pasamos la nota al array 
				}

				evaluar(notas); // llamamos a la funcion en donde le pasaremos nuestro array 
			}


			}



		
		
		
	    

		
	}

}
