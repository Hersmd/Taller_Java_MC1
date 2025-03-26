package main;

import java.util.Scanner;

/**
 * Programa demostrativo de los diferentes tipos de bucles en Java
 *
 * @author Fernando
 */
public class Bucles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ------------------------------------------------------------
        // EJEMPLO 1: BUCLE FOR - Números del 1 al 10
        // ------------------------------------------------------------
        System.out.println("\nEJEMPLO 1: BUCLE FOR - Números del 1 al 10");
        System.out.println("El bucle for se usa cuando sabemos exactamente cuántas veces queremos repetir algo.");

        for (int numero = 1; numero <= 10; numero++) {
            System.out.print(numero + " ");
        }
        System.out.println("\n");

        // ------------------------------------------------------------
        // EJEMPLO 2: BUCLE FOR - Tabla de multiplicar
        // ------------------------------------------------------------
        System.out.println("EJEMPLO 2: BUCLE FOR - Tabla de multiplicar del 5");
        System.out.println("Muestra cómo usar un for para cálculos repetitivos.");

        for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
            int resultado = 5 * multiplicador;
            System.out.println("5 × " + multiplicador + " = " + resultado);
        }
        System.out.println();

        // ------------------------------------------------------------
        // EJEMPLO 3: BUCLE WHILE - Validación de entrada
        // ------------------------------------------------------------
        System.out.println("EJEMPLO 3: BUCLE WHILE - Validación de número positivo");
        System.out.println("El while es ideal cuando no sabemos cuántas veces se repetirá.");

        System.out.print("Por favor, ingrese un número positivo: ");
        int numeroIngresado = scanner.nextInt();

        while (numeroIngresado < 0) {
            System.out.print("Número inválido. Debe ser positivo. Intente de nuevo: ");
            numeroIngresado = scanner.nextInt();
        }
        System.out.println("¡Correcto! Ha ingresado: " + numeroIngresado + "\n");

        // ------------------------------------------------------------
        // EJEMPLO 4: BUCLE WHILE - Contador regresivo
        // ------------------------------------------------------------
        System.out.println("EJEMPLO 4: BUCLE WHILE - Contador regresivo de 10 a 1");

        int contador = 10;
        while (contador >= 1) {
            System.out.print(contador + " ");
            contador--; // Decrementamos el contador
        }
        System.out.println("\n\n¡Despegue!\n");

        // ------------------------------------------------------------
        // EJEMPLO 5: BUCLE DO-WHILE - Menú interactivo
        // ------------------------------------------------------------
        System.out.println("EJEMPLO 5: BUCLE DO-WHILE - Menú interactivo");
        System.out.println("El do-while garantiza que el bloque se ejecute al menos una vez.");

        int opcion;
        do {
            System.out.println("\n----- MENÚ PRINCIPAL -----");
            System.out.println("1. Saludar");
            System.out.println("2. Despedirse");
            System.out.println("3. Salir del programa");
            System.out.print("Seleccione una opción (1-3): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n¡Hola! Bienvenido al programa de ejemplos de bucles.\n");
                    break;
                case 2:
                    System.out.println("\n¡Hasta pronto! Espero que hayas aprendido sobre bucles.\n");
                    break;
                case 3:
                    System.out.println("\nFinalizando el programa...\n");
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor seleccione 1, 2 o 3.\n");
            }
        } while (opcion != 3);

        scanner.close();
    }

}
