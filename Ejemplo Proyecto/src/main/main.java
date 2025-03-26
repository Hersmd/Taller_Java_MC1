package main;

import java.util.Scanner;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // =============================================
        // PASO 1: SOLICITAR EL NÚMERO Y NOMBRE DE VARIABLES
        // =============================================
        // Solicitar al usuario el número de variables (entre 2 y 5)
        System.out.print("Ingrese el número de variables (2-5): ");
        int numeroVariables = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner después de leer el número

        // Validar que el número de variables esté en el rango permitido
        if (numeroVariables < 2 || numeroVariables > 5) {
            System.out.println("Error: El número de variables debe estar entre 2 y 5.");
            scanner.close();
            return; // Terminar el programa si la entrada no es válida
        }

        // Lista para almacenar los nombres de las variables
        ArrayList<String> nombresVariables = new ArrayList<>();

        // Solicitar al usuario el nombre de cada variable
        for (int i = 0; i < numeroVariables; i++) {
            System.out.print("Ingrese el nombre de la variable " + (i + 1) + ": ");
            nombresVariables.add(scanner.nextLine());
        }

        // =============================================
        // PASO 2: GENERAR LA TABLA DE VERDAD BINARIA
        // =============================================
        // Calcular el número de filas necesarias (2^numeroVariables)
        int numeroFilas = (int) Math.pow(2, numeroVariables);

        // Crear la tabla de verdad con una columna extra para la función de salida
        int[][] tablaVerdad = new int[numeroFilas][numeroVariables + 1];

        // Llenar la tabla de verdad con todas las combinaciones binarias posibles
        for (int columna = 0; columna < numeroVariables; columna++) {
            int contador = 0; // Para controlar cuándo cambiar de 0 a 1 o viceversa
            int valor = 0;    // Valor inicial (0)

            // Calcular cada cuántas filas debe cambiar el valor
            int limite = (int) Math.pow(2, numeroVariables - columna - 1);

            for (int fila = 0; fila < numeroFilas; fila++) {
                // Asignar el valor actual (0 o 1) a la celda correspondiente
                tablaVerdad[fila][columna] = valor;
                contador++;

                // Cambiar el valor cuando se alcanza el límite
                if (contador == limite) {
                    valor = 1 - valor; // Alternar entre 0 y 1
                    contador = 0;      // Reiniciar el contador
                }
            }
        }

        // =============================================
        // PASO 3: SOLICITAR LOS VALORES DE LA FUNCIÓN (f1)
        // =============================================
        System.out.println("\nIngrese los valores de la función (0 o 1):");

        // Para cada fila de la tabla de verdad, solicitar el valor de la función
        for (int fila = 0; fila < numeroFilas; fila++) {
            while (true) { // Repetir hasta que se ingrese un valor válido
                // Mostrar la combinación actual de variables
                System.out.print("Para (");
                for (int columna = 0; columna < numeroVariables; columna++) {
                    System.out.print(nombresVariables.get(columna) + "=" + tablaVerdad[fila][columna] + " ");
                }
                System.out.print(") → f1: ");

                // Verificar si la entrada es un número entero
                if (scanner.hasNextInt()) {
                    int entrada = scanner.nextInt();

                    // Validar que la entrada sea 0 o 1
                    if (entrada == 0 || entrada == 1) {
                        tablaVerdad[fila][numeroVariables] = entrada; // Almacenar el valor
                        break; // Salir del bucle while
                    } else {
                        System.out.println("❌ Error: Ingrese solo 0 o 1.");
                    }
                } else {
                    System.out.println("❌ Error: Solo números (0 o 1). ");
                    scanner.next(); // Limpiar la entrada inválida
                }
            }
        }

        // =============================================
        // PASO 4: IMPRIMIR LA TABLA DE VERDAD COMPLETA
        // =============================================
        System.out.println("\nTabla de Verdad:");

        // Imprimir los encabezados de las variables
        for (String variable : nombresVariables) {
            System.out.print(variable + "\t");
        }
        System.out.println("f1"); // Encabezado para la columna de la función

        // Imprimir línea separadora
        for (int i = 0; i < numeroVariables; i++) {
            System.out.print("----\t");
        }
        System.out.println("---");

        // Imprimir los valores de la tabla de verdad
        for (int fila = 0; fila < numeroFilas; fila++) {
            for (int columna = 0; columna <= numeroVariables; columna++) {
                System.out.print(tablaVerdad[fila][columna] + "\t");
            }
            System.out.println(); // Nueva línea para la siguiente fila
        }
        
        

        // =============================================
        // PASO 5: OBTENER Y MOSTRAR LA FUNCIÓN BOOLEANA CANÓNICA
        // =============================================
        String funcionBooleana = obtenerFuncionCanonica(tablaVerdad, nombresVariables, numeroVariables);
        System.out.println("\nFunción Booleana Canónica: " + funcionBooleana);

        // =============================================
        // PASO 6: GENERAR E IMPRIMIR EL MAPA DE KARNAUGH
        // =============================================
        imprimirMapaKarnaugh(tablaVerdad, numeroVariables, nombresVariables);
        
        

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }

    // =============================================
    // MÉTODO PARA OBTENER LA FUNCIÓN CANÓNICA (SOP - Suma de Productos)
    // =============================================
    /**
     * Genera la función booleana en forma de suma de productos (SOP) a partir
     * de la tabla de verdad.
     *
     * @param tabla La tabla de verdad con todas las combinaciones de entrada
     * @param vars Lista con los nombres de las variables
     * @param numVars Número de variables en la función
     * @return String que representa la función booleana canónica
     */
    public static String obtenerFuncionCanonica(int[][] tabla, ArrayList<String> vars, int numVars) {
        // Inicializamos el string de la funcion a devolver
        String funcion = "";

        // Bandera para controlar cuándo agregar el operador "+"
        boolean primerTermino = true;

        // Recorrer todas las filas de la tabla de verdad
        for (int fila = 0; fila < tabla.length; fila++) {
            // Solo considerar las filas donde la función de salida es 1
            if (tabla[fila][numVars] == 1) {

                // Agregar "+" antes de cada término, excepto el primero
                if (!primerTermino) {
                    funcion += (" + ");
                }

                // Construir el término (minterm) para esta fila
                for (int columna = 0; columna < numVars; columna++) {
                    if (tabla[fila][columna] == 0) {
                        // Si el valor es 0, agregar la variable negada (ej: A')
                        funcion += (vars.get(columna)) + ("'");
                    } else {
                        // Si el valor es 1, agregar la variable directa (ej: A)
                        funcion += (vars.get(columna));
                    }
                }

                // Ya no es el primer término
                primerTermino = false;
            }
        }

        // Si no se agregó ningún término, la función es 0
        if (funcion.length() == 0) {
            return "0";
        }

        return funcion;
    }

    // =============================================
    // MÉTODO PARA IMPRIMIR EL MAPA DE KARNAUGH
    // =============================================
    /**
     * Imprime el mapa de Karnaugh correspondiente a la tabla de verdad.
     *
     * @param tabla La tabla de verdad con todas las combinaciones
     * @param numVars Número de variables (2-5)
     * @param vars Lista con los nombres de las variables
     */
    public static void imprimirMapaKarnaugh(int[][] tabla, int numVars, ArrayList<String> vars) {
        System.out.println("\nMapa de Karnaugh:");

        // Secuencia de código Gray para mantener adyacencias lógicas
        // (cada número adyacente difiere en un solo bit)
        int[] codigoGray = {0, 1, 3, 2}; // Representa: 00, 01, 11, 10


        // ========= CASO PARA 2 VARIABLES =========
        if (numVars == 2) {
            // El mapa para 2 variables es una matriz 2x2
            // LSB (vars.get(1)) en filas, MSB (vars.get(0)) en columnas
            int[][] mapa = new int[2][2];

            // Llenar el mapa con los valores de la tabla de verdad
            // i representa el valor de la variable LSB (fila)
            // j representa el valor de la variable MSB (columna)
            for (int i = 0; i < 2; i++) { // LSB (fila)
                for (int j = 0; j < 2; j++) { // MSB (columna)
                    // Calcular posición en tabla de verdad: MSB primero, LSB después
                    // vars orden: [MSB, LSB]
                    int posicionTabla = j * 2 + i; // j (MSB) tiene mayor peso
                    mapa[i][j] = tabla[posicionTabla][numVars];
                }
            }

            // Imprimir encabezados del mapa
            // Formato: LSB (filas) vs MSB (columnas)
            System.out.println("Mapa para " + vars.get(1) + " (filas, LSB) y " + vars.get(0) + " (columnas, MSB):");
            System.out.println("\\ " + vars.get(0) + " 0   1"); // Columnas: MSB
            System.out.println(vars.get(1) + " \\-------");     // Filas: LSB

            // Imprimir los valores del mapa
            for (int i = 0; i < 2; i++) { // Filas (LSB)
                System.out.print(i + " | ");
                for (int j = 0; j < 2; j++) { // Columnas (MSB)
                    System.out.print(" " + mapa[i][j] + " ");
                }
                System.out.println();
            }

        // ========= CASO PARA 3 VARIABLES =========
        } else if (numVars == 3) {
            // El mapa para 3 variables es 2x4 (z en filas, xy en columnas)
            int[][] mapa = new int[2][4];

            // Llenar el mapa
            for (int z = 0; z < 2; z++) { // z es la variable menos significativa (filas)
                for (int xy = 0; xy < 4; xy++) { // xy son las otras dos variables (columnas)
                    // Decodificar los valores de x e y del código Gray
                    int valorGray = codigoGray[xy];
                    int x = (valorGray >= 2) ? 1 : 0; // Primer bit del código Gray
                    int y = (valorGray % 2 == 1) ? 1 : 0; // Segundo bit del código Gray

                    // Calcular la posición correspondiente en la tabla de verdad
                    // Orden en tabla: x (MSB), y, z (LSB)
                    int posicionTabla = x * 4 + y * 2 + z;
                    mapa[z][xy] = tabla[posicionTabla][numVars];
                }
            }

            // Imprimir encabezados del mapa
            System.out.println("Mapa para " + vars.get(2) + " (filas) y " + vars.get(0) + vars.get(1) + " (columnas):");
            System.out.print("\\ " + vars.get(0) + vars.get(1));
            System.out.println(" 00  01  11  10");
            System.out.println(vars.get(2) + " \\------------");

            // Imprimir los valores del mapa
            for (int z = 0; z < 2; z++) {
                System.out.print(z + " | ");
                for (int xy = 0; xy < 4; xy++) {
                    System.out.print(" " + mapa[z][xy] + " ");
                }
                System.out.println();
            }

            // ========= CASO PARA 4 VARIABLES =========
        } else if (numVars == 4) {
            // El mapa para 4 variables es 4x4 (zw en filas, xy en columnas)
            int[][] mapa = new int[4][4];

            // Llenar el mapa
            for (int fila = 0; fila < 4; fila++) { // zw son las dos variables menos significativas (filas)
                for (int col = 0; col < 4; col++) { // xy son las dos más significativas (columnas)
                    // Decodificar valores de x e y del código Gray (columnas)
                    int grayCol = codigoGray[col];
                    int x = (grayCol >= 2) ? 1 : 0;
                    int y = (grayCol % 2 == 1) ? 1 : 0;

                    // Decodificar valores de z y w del código Gray (filas)
                    int grayFila = codigoGray[fila];
                    int z = (grayFila >= 2) ? 1 : 0;
                    int w = (grayFila % 2 == 1) ? 1 : 0;

                    // Calcular posición en tabla de verdad (orden: x,y,z,w)
                    int posicionTabla = x * 8 + y * 4 + z * 2 + w;
                    mapa[fila][col] = tabla[posicionTabla][numVars];
                }
            }

            // Imprimir encabezados del mapa
            System.out.println("Mapa para " + vars.get(2) + vars.get(3) + " (filas) y " + vars.get(0) + vars.get(1) + " (columnas):");
            System.out.print(" \\ " + vars.get(0) + vars.get(1));
            System.out.println(" 00  01  11  10");
            System.out.println(vars.get(2) + vars.get(3) + " \\------------");

            // Imprimir los valores del mapa
            for (int fila = 0; fila < 4; fila++) {
                // Formatear el número de fila para que tenga 2 dígitos
                String numFila = (codigoGray[fila] < 10) ? "0" + codigoGray[fila] : "" + codigoGray[fila];
                System.out.print(numFila + " | ");

                for (int col = 0; col < 4; col++) {
                    System.out.print(" " + mapa[fila][col] + " ");
                }
                System.out.println();
            }

            // ========= CASO PARA 5 VARIABLES =========
        } else if (numVars == 5) {
            // Para 5 variables usamos dos mapas 4x4 superpuestos (uno para v=0 y otro para v=1)
            System.out.println("Mapa para 5 variables (" + vars.get(0) + " variable de superposición)");
            System.out.println("Se muestran dos mapas 4x4, uno para " + vars.get(0) + "=0 y otro para " + vars.get(0) + "=1");

            // Crear los dos mapas (v=0 y v=1)
            int[][][] mapas = new int[2][4][4]; // [v][fila][col]

            // Llenar ambos mapas
            for (int v = 0; v < 2; v++) { // v es la variable más significativa
                for (int fila = 0; fila < 4; fila++) { // zw (variables 3 y 4)
                    for (int col = 0; col < 4; col++) { // xy (variables 1 y 2)
                        // Decodificar valores de x e y del código Gray (columnas)
                        int grayCol = codigoGray[col];
                        int x = (grayCol >= 2) ? 1 : 0;
                        int y = (grayCol % 2 == 1) ? 1 : 0;

                        // Decodificar valores de z y w del código Gray (filas)
                        int grayFila = codigoGray[fila];
                        int z = (grayFila >= 2) ? 1 : 0;
                        int w = (grayFila % 2 == 1) ? 1 : 0;

                        // Calcular posición en tabla de verdad (orden: v,x,y,z,w)
                        int posicionTabla = v * 16 + x * 8 + y * 4 + z * 2 + w;
                        mapas[v][fila][col] = tabla[posicionTabla][numVars];
                    }
                }
            }

            // Imprimir primer mapa (v=0)
            System.out.println("\n--- Mapa para " + vars.get(0) + "=0 ---");
            System.out.println("Representa " + vars.get(3) + vars.get(4) + " (filas) vs " + vars.get(1) + vars.get(2) + " (columnas)");
            System.out.print(" \\ " + vars.get(1) + vars.get(2));
            System.out.println(" 00  01  11  10");
            System.out.println(vars.get(3) + vars.get(4) + " \\------------");

            for (int fila = 0; fila < 4; fila++) {
                String numFila = (codigoGray[fila] < 10) ? "0" + codigoGray[fila] : "" + codigoGray[fila];
                System.out.print(numFila + " | ");
                for (int col = 0; col < 4; col++) {
                    System.out.print(" " + mapas[0][fila][col] + " ");
                }
                System.out.println();
            }

            // Imprimir segundo mapa (v=1)
            System.out.println("\n--- Mapa para " + vars.get(0) + "=1 ---");
            System.out.println("Representa " + vars.get(3) + vars.get(4) + " (filas) vs " + vars.get(1) + vars.get(2) + " (columnas)");
            System.out.print(" \\ " + vars.get(1) + vars.get(2));
            System.out.println(" 00  01  11  10");
            System.out.println(vars.get(3) + vars.get(4) + " \\------------");

            for (int fila = 0; fila < 4; fila++) {
                String numFila = (codigoGray[fila] < 10) ? "0" + codigoGray[fila] : "" + codigoGray[fila];
                System.out.print(numFila + " | ");
                for (int col = 0; col < 4; col++) {
                    System.out.print(" " + mapas[1][fila][col] + " ");
                }
                System.out.println();
            }

            System.out.println("\nNota: Para 5 variables, considere las adyacencias entre ambos mapas");
            System.out.println("Las celdas en la misma posición de ambos mapas también son adyacentes");
        }
    }
}
