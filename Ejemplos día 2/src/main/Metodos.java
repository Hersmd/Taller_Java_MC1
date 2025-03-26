package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa con varios métodos útiles para aprender Java
 * @author relda
 */
public class Metodos {

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
    
    /**
     * Muestra un menú interactivo con varias opciones de operaciones matemáticas
     * y de texto, ejecutando la función correspondiente a la opción seleccionada.
     */
    public static void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n------------------ MENU PRINCIPAL ----------------------");
            System.out.println("1. Generar tabla de multiplicar de un número");
            System.out.println("2. Listar números pares hasta un límite");
            System.out.println("3. Contar vocales en un texto");
            System.out.println("0. Salir del programa");
            System.out.print("Elige una opción (0-3): ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            
            switch (opcion) {
                case 1:
                    System.out.println("\n--- TABLA DE MULTIPLICAR ---");
                    System.out.print("Ingrese el número para generar su tabla: ");
                    int numeroParaTabla = scanner.nextInt();
                    scanner.nextLine();
                    generarTablaMultiplicar(numeroParaTabla);
                    break;
                    
                case 2:
                    System.out.println("\n--- NÚMEROS PARES ---");
                    System.out.print("Ingrese el límite máximo: ");
                    int limite = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<Integer> numerosPares = obtenerNumerosParesHastaLimite(limite);
                    System.out.println("Números pares encontrados: " + numerosPares);
                    break;
                    
                case 3:
                    System.out.println("\n--- CONTADOR DE VOCALES ---");
                    System.out.print("Ingrese el texto a analizar: ");
                    String textoParaAnalizar = scanner.nextLine();
                    int cantidadVocales = contarVocalesEnTexto(textoParaAnalizar);
                    System.out.println("El texto contiene " + cantidadVocales + " vocales");
                    break;
                    
                case 0:
                    System.out.println("Saliendo del programa... ¡Hasta pronto!");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor, elige un número del 0 al 3.");
            }
        } while (true); // El bucle continúa hasta que se elige salir (opción 0)
    }
     
    /**
     * Genera y muestra la tabla de multiplicar de un número dado
     * @param numeroBase El número del cual se generará la tabla de multiplicar
     */
    public static void generarTablaMultiplicar(int numeroBase) {
        System.out.println("\nTabla de multiplicar del " + numeroBase + ":");
        
        // Iteramos del 1 al 10 para mostrar las multiplicaciones
        for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
            int resultado = numeroBase * multiplicador;
            System.out.printf("%d x %d = %d\n", numeroBase, multiplicador, resultado);
        }
    }

    /**
     * Genera una lista de números pares desde 1 hasta el límite especificado
     * @param limiteSuperior El número máximo hasta donde buscar pares
     * @return ArrayList con los números pares encontrados
     */
    public static ArrayList<Integer> obtenerNumerosParesHastaLimite(int limiteSuperior) {
        ArrayList<Integer> numerosPares = new ArrayList<>();
        
        // Verificamos cada número desde 1 hasta el límite
        for (int numero = 1; numero <= limiteSuperior; numero++) {
            if (numero % 2 == 0) { // Si es divisible por 2 (par)
                numerosPares.add(numero); // Lo agregamos a la lista
            }
        }
        return numerosPares;
    }

    /**
     * Cuenta la cantidad de vocales (a, e, i, o, u) en un texto dado
     * @param texto El texto en el que se buscarán vocales
     * @return La cantidad total de vocales encontradas
     */
    public static int contarVocalesEnTexto(String texto) {
        int contadorVocales = 0;
        String textoEnMinusculas = texto.toLowerCase(); // Convertimos a minúsculas para simplificar
        
        // Convertimos el texto en un arreglo de caracteres para analizar cada letra
        char[] caracteres = textoEnMinusculas.toCharArray();
        
        // Revisamos cada caracter del texto
        for (char caracter : caracteres) {
            // Verificamos si el caracter actual es una vocal
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || 
                caracter == 'o' || caracter == 'u') {
                contadorVocales++; // Incrementamos el contador
            }
        }
        
        return contadorVocales;
    }
}