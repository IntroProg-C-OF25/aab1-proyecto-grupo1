
/**
 * Se le solicita desarrollar un demo tipo juego, que permita generar un número aleatorio y 
 * le rete al usuario que lo adivine. Si no adivina el número, el juego debe sugerirle lo intente nuevamente con pistas 
 * (es mayor, menor, es par, impar, es primo, pertenece a la serie de fibonacy, es multiplo de N, etc.), 
 * el usuario es quien deberá ir pidiendo repetitivamente que el sistema le muestre o no, más pintas, 
 * solo que, si el usuario pide más pistas, el sistema automáticamente le resta un intento y le informa cuantos intentos 
 * le quedan. Al finalizar el juego, se debe felicitar al usuario si gana y como, o pedir que lo intente de nuevo.
 * @author Usuario juampyz7
 */
import java.util.Random;
import java.util.Scanner;

public class juego_Adivinarnumero2o {

    public static void main(String[] args) {
        int aleatorio = (int) (Math.random() * 100 + 1);
        int intentos = 5;
        int numero;
        Scanner tcl = new Scanner(System.in);

        boolean[] pistasDadas = new boolean[3];
        Random random = new Random();

        System.out.println("Bienvenido al juego de adivinar el numero mejorado 2.0");
        System.out.println("Debes intentar adivinar un numero entre 1 y 100. Para lo cual tienes " + intentos + " intentos.");

        while (intentos > 0) {
            System.out.print("ADIVINA EL NUMERO: ");
            numero = tcl.nextInt();

            if (numero == aleatorio) {
                System.out.println("¡FELICIDADES HAZ ADIVINADO EL NUMERO!");
                break;
            } else {
                intentos--;
                if (intentos > 0) {
                    System.out.println("Tu numero es incorrecto. Te quedan " + intentos + " intentos.");

                    // Preguntar si quiere una pista adicional
                    System.out.print("¿Deseas obtener una pista adicional? (si/no): ");
                    String respuesta = tcl.next();

                    if (respuesta.equalsIgnoreCase("si")) {
                        if (!todasLasPistasDadas(pistasDadas)) {
                            darPistaAleatoria(aleatorio, pistasDadas, random);
                            intentos--; // Resta un intento por pedir una pista
                            if (intentos > 0) {
                                System.out.println("Ahora te quedan " + intentos + " intentos.");
                            } else {
                                System.out.println("Lamentablement se te acabaron los intentos.");
                            }
                        } else {
                            System.out.println("Ya no hay mas pistas disponibles.");
                        }
                    } else if (respuesta.equalsIgnoreCase("no")) {
                        System.out.println("¡Esta bien, sigue intentando adivinar sin pistas!");
                    } else {
                        System.out.println("Tu respuesta no es valida. ¡Intenta nuevamente!");
                    }
                } else {
                    System.out.println("\nLo lamento, se te acabaron los intentos pero estuviste cerca..");
                    System.out.println("El numero secreto era: " + aleatorio);
                }
            }
        }
        tcl.close();
    }

    private static void darPistaAleatoria(int aleatorio, boolean[] pistasDadas, Random random) {
        while (true) {
            int indice = random.nextInt(3);
            if (!pistasDadas[indice]) {
                switch (indice) {
                    case 0:
                        if (aleatorio % 2 == 0) {
                            System.out.println("PILAS: EL NUMERO ES PAR.");
                        } else {
                            System.out.println("PILAS: EL NUMERO ES IMPAR.");
                        }
                        break;
                    case 1:
                        if (numPrimo(aleatorio)) {
                            System.out.println("PILAS: EL NUMERO ES PRIMO.");
                        } else {
                            System.out.println("PILAS: EL NUMERO NO ES PRIMO.");
                        }
                        break;
                    case 2:
                        int divisor = 5;
                        if (aleatorio % divisor == 0) {
                            System.out.println("PILAS: EL NUMERO ES MULTIPLO DE " + divisor + ".");
                        } else {
                            System.out.println("PILAS: EL NUMERO NO ES MULTIPLO DE " + divisor + ".");
                        }
                        break;
                }
                pistasDadas[indice] = true;
                break;
            }
        }
    }

    private static boolean todasLasPistasDadas(boolean[] pistasDadas) {
        for (boolean pista : pistasDadas) {
            if (!pista) {
                return false;
            }
        }
        return true;
    }

    private static boolean numPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Bienvenido al juego de adivinar el numero mejorado 2.0
 * Debes intentar adivinar un numero entre 1 y 100. Para lo cual tienes 5 intentos.
 * ADIVINA EL NUMERO: 50
 * Tu numero es incorrecto. Te quedan 4 intentos.
 * �Deseas obtener una pista adicional? (si/no): si
 * PILAS: EL NUMERO NO ES PRIMO.
 * Ahora te quedan 3 intentos.
 * ADIVINA EL NUMERO: 60
 * Tu numero es incorrecto. Te quedan 2 intentos.
 * �Deseas obtener una pista adicional? (si/no): si
 * PILAS: EL NUMERO ES PAR.
 * Ahora te quedan 1 intentos.
 * ADIVINA EL NUMERO: 80
 * 
 * Lo lamento, se te acabaron los intentos, pero estuviste cerca..
 * El numero secreto era: 100
 * BUILD SUCCESSFUL (total time: 11 seconds)
 */
