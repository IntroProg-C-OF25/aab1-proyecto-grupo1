import java.util.Scanner;

public class FrecuenciaCardiaca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int anioNacimiento, mesNacimiento, diaNacimiento, anioActual, edad, frecuenciaMaxima, rangoBajo, rangoAlto, opcion, duracion, frecuenciaActual;
        // Presentación del programa
        System.out.println("===== Monitor de Frecuencia Cardíaca =====");
        System.out.println("Este programa calcula y analiza tu frecuencia cardíaca.\n");

        // Variables de la persona
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su año de nacimiento: ");
        anioNacimiento = scanner.nextInt();
        System.out.print("Ingrese su mes de nacimiento (1-12): ");
        mesNacimiento = scanner.nextInt();
        System.out.print("Ingrese su día de nacimiento: ");
        diaNacimiento = scanner.nextInt();

        // Calcular edad
        anioActual = 2024;
        edad = anioActual - anioNacimiento;

        // Calcular frecuencia cardíaca máxima y rango esperado
        frecuenciaMaxima = 220 - edad;
        rangoBajo = (int) (frecuenciaMaxima * 0.5);
        rangoAlto = (int) (frecuenciaMaxima * 0.85);

        System.out.printf("\nHola %s, según tu fecha de nacimiento tienes %d años.\n", nombre, edad);
        System.out.printf("Tu frecuencia cardíaca máxima es: %d bpm.\n", frecuenciaMaxima);
        System.out.printf("Tu rango de frecuencia cardíaca esperada está entre %d y %d bpm.\n", rangoBajo, rangoAlto);

        while (continuar) {
            // Menú de opciones
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Registrar una sesión de ejercicio");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Registrar una sesión de ejercicio
                    System.out.print("\nIngrese la duración del ejercicio en minutos: ");
                    duracion = scanner.nextInt();
                    System.out.print("Ingrese la frecuencia cardíaca registrada durante el ejercicio (en bpm): ");
                    frecuenciaActual = scanner.nextInt();

                    // Evaluar la frecuencia cardíaca registrada
                    String estado;
                    if (frecuenciaActual < rangoBajo) {
                        estado = "Frecuencia baja";
                    } else if (frecuenciaActual <= rangoAlto) {
                        estado = "Frecuencia dentro del rango esperado";
                    } else {
                        estado = "Frecuencia elevada";
                    }

                    // Mostrar resultados
                    System.out.println("\nResultados de la sesión:");
                    System.out.printf("Duración: %d minutos\n", duracion);
                    System.out.printf("Frecuencia registrada: %d bpm\n", frecuenciaActual);
                    System.out.printf("Estado: %s\n", estado);
                    break;

                case 2: // Salir
                    System.out.println("\nGracias por utilizar el Monitor de Frecuencia Cardíaca.");
                    continuar = false;
                    break;

                default: // Opción inválida
                    System.out.println("\nOpción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
/***
 * ===== Monitor de Frecuencia Cardíaca =====
 * Este programa calcula y analiza tu frecuencia cardíaca.
 * 
 * Ingrese su nombre: Rafael
 * Ingrese su año de nacimiento: 2006
 * Ingrese su mes de nacimiento (1-12): 11
 * Ingrese su día de nacimiento: 18
 * 
 * Hola Rafael, según tu fecha de nacimiento tienes 18 años.
 * Tu frecuencia cardíaca máxima es: 202 bpm.
 * Tu rango de frecuencia cardíaca esperada está entre 101 y 171 bpm.
 * 
 * Seleccione una opción:
 * 1. Registrar una sesión de ejercicio
 * 2. Salir
 * Opción: 1
 * 
 * Ingrese la duración del ejercicio en minutos: 120
 * Ingrese la frecuencia cardíaca registrada durante el ejercicio (en bpm): 170
 * 
 * Resultados de la sesión:
 * Duración: 120 minutos
 * Frecuencia registrada: 170 bpm
 * Estado: Frecuencia dentro del rango esperado
 * 
 * Seleccione una opción:
 * 1. Registrar una sesión de ejercicio
 * 2. Salir
 * Opción: 2
 * 
 * Gracias por utilizar el Monitor de Frecuencia Cardíaca.
 */