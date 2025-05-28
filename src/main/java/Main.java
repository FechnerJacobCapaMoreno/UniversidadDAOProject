import dao.impl.EstudianteDAO;
import entities.Estudiante;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del nuevo estudiante:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        Estudiante nuevo = new Estudiante();
        nuevo.setNombre(nombre);
        nuevo.setCorreo(correo);

        estudianteDAO.insertar(nuevo);
        System.out.println("✅ Estudiante insertado exitosamente.");

     
        List<Estudiante> estudiantes = estudianteDAO.obtenerTodos();
        System.out.println("\nLista actualizada de estudiantes:");
        for (Estudiante e : estudiantes) {
            System.out.println("ID: " + e.getId() + ", Nombre: " + e.getNombre() + ", Correo: " + e.getCorreo());
        }

        scanner.close();
    }
}
