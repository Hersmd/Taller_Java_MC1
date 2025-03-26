package main;

import java.util.ArrayList;

/**
 * Ejemplo completo de arreglos y matrices
 * @author Angel
 */
public class ArreglosMatrices {

    public static void main(String[] args) {
        // ==============================================
        // 1. ARREGLOS ESTÁTICOS (tamaño fijo)
        // ==============================================
        System.out.println("=== PARTE 1: ARREGLOS ESTÁTICOS ===");
        
        // 1.1 Declaración de arreglos de diferentes tipos
        // Arreglo de enteros con 4 posiciones (se inicializan en 0)
        int[] edades = new int[4];
        
        // Arreglo de doubles ya inicializado con valores
        double[] estaturas = {1.65, 1.72, 1.80, 1.58};
        
        // Arreglo de caracteres (para formar una palabra)
        char[] letrasPalabra = {'H', 'o', 'l', 'a'};
        
        // 1.2 Acceso a elementos de un arreglo
        System.out.println("\nAcceso a elementos:");
        System.out.println("Segunda estatura: " + estaturas[1]); // Muestra 1.72
        System.out.println("Primera letra: " + letrasPalabra[0]); // Muestra 'H'
        
        // 1.3 Modificación de elementos
        letrasPalabra[0] = 'M'; // Cambiamos 'H' por 'M'
        edades[2] = 25; // Asignamos 25 a la tercera posición
        
        System.out.println("\nDespués de modificar:");
        System.out.println("Primera letra ahora: " + letrasPalabra[0]); // Muestra 'M'
        System.out.println("Tercera edad: " + edades[2]); // Muestra 25
        
        // 1.4 Longitud de un arreglo
        System.out.println("\nTamaño de los arreglos:");
        System.out.println("Cantidad de estaturas: " + estaturas.length); // 4
        System.out.println("Letras en la palabra: " + letrasPalabra.length); // 4
        
        // ==============================================
        // 2. ARREGLOS DINÁMICOS (ArrayList)
        // ==============================================
        System.out.println("\n\n=== PARTE 2: ARREGLOS DINÁMICOS (ArrayList) ===");
        
        // 2.1 Creación de un ArrayList de Strings
        ArrayList<String> listaCompras = new ArrayList<>();
        System.out.println("\nArrayList recién creado: " + listaCompras); // Muestra []
        
        // 2.2 Agregar elementos
        listaCompras.add("Manzanas");
        listaCompras.add("Leche");
        listaCompras.add("Pan");
        System.out.println("Después de agregar items: " + listaCompras);
        
        // 2.3 Insertar en posición específica
        listaCompras.add(1, "Huevos"); // Inserta en segunda posición
        System.out.println("Después de insertar Huevos: " + listaCompras);
        
        // 2.4 Obtener elemento por posición
        String primerItem = listaCompras.get(0);
        System.out.println("\nPrimer item de la lista: " + primerItem);
        
        // 2.5 Modificar elemento existente
        listaCompras.set(2, "Leche descremada");
        System.out.println("Después de modificar: " + listaCompras);
        
        // 2.6 Eliminar elemento
        listaCompras.remove(3); // Elimina "Pan"
        System.out.println("Después de eliminar: " + listaCompras);
        
        // 2.7 Tamaño del ArrayList
        System.out.println("\nCantidad actual de items: " + listaCompras.size());
        
        // ==============================================
        // 3. MATRICES (arreglos bidimensionales)
        // ==============================================
        System.out.println("\n\n=== PARTE 3: MATRICES ===");
        
        // 3.1 Matriz de números (3 filas x 3 columnas)
        int[][] matrizNumeros = new int[3][3];
        
        // Llenamos la matriz con valores
        matrizNumeros[0][0] = 1;
        matrizNumeros[0][1] = 2;
        matrizNumeros[0][2] = 3;
        matrizNumeros[1][0] = 4;
        matrizNumeros[1][1] = 5;
        matrizNumeros[1][2] = 6;
        matrizNumeros[2][0] = 7;
        matrizNumeros[2][1] = 8;
        matrizNumeros[2][2] = 9;
        
        // 3.2 Matriz de strings ya inicializada
        String[][] nombres = {
            {"Juan", "María", "Pedro"},
            {"Ana", "Luis", "Carlos"},
            {"Sofía", "Pablo", "Laura"}
        };
        
        // 3.3 Acceso a elementos de matriz
        System.out.println("\nElemento central de matriz números: " + matrizNumeros[1][1]);
        System.out.println("Primer nombre en matriz: " + nombres[0][0]);
        
        // ==============================================
        // 4. RECORRER ARREGLOS Y MATRICES
        // ==============================================
        System.out.println("\n\n=== PARTE 4: RECORRER ARREGLOS Y MATRICES ===");
        
        // 4.1 Recorrer arreglo estático con for tradicional
        System.out.println("\nEstaturas:");
        for (int i = 0; i < estaturas.length; i++) {
            System.out.println("Estatura " + (i+1) + ": " + estaturas[i]);
        }
        
        // 4.2 Recorrer arreglo estático con for-each
        System.out.println("\nLetras de la palabra:");
        for (char letra : letrasPalabra) {
            System.out.println("Letra: " + letra);
        }
        
        // 4.3 Recorrer ArrayList
        System.out.println("\nItems de compra:");
        for (int i = 0; i < listaCompras.size(); i++) {
            System.out.println("Item #" + (i+1) + ": " + listaCompras.get(i));
        }
        
        // 4.4 Recorrer matriz de números
        System.out.println("\nMatriz de números:");
        for (int i = 0; i < matrizNumeros.length; i++) {
            for (int j = 0; j < matrizNumeros[i].length; j++) {
                System.out.print(matrizNumeros[i][j] + " ");
            }
            System.out.println(); // Salto de línea al terminar cada fila
        }
        
        // ==============================================
        // 5. EJEMPLO PRÁCTICO: PIRÁMIDE CON MATRIZ
        // ==============================================
        System.out.println("\n\n=== PARTE 5: CONSTRUIR PIRÁMIDE ===");
        
        // 5.1 Configuración de la pirámide
        int niveles = 4;
        int tamanoBase = 2 * niveles - 1;
        char[][] piramide = new char[niveles][tamanoBase];
        
        // 5.2 Inicializar toda la matriz con espacios
        for (int fila = 0; fila < niveles; fila++) {
            for (int columna = 0; columna < tamanoBase; columna++) {
                piramide[fila][columna] = ' ';
            }
        }
        
        // 5.3 Construir la pirámide con asteriscos
        for (int fila = 0; fila < niveles; fila++) {
            int inicio = niveles - 1 - fila;
            int fin = niveles - 1 + fila;
            
            for (int columna = inicio; columna <= fin; columna++) {
                piramide[fila][columna] = '*';
            }
        }
        
        // 5.4 Mostrar la pirámide
        System.out.println("\nPirámide de " + niveles + " niveles:\n");
        for (int fila = 0; fila < niveles; fila++) {
            for (int columna = 0; columna < tamanoBase; columna++) {
                System.out.print(piramide[fila][columna]);
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
}