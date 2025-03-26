/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamc1;

/**
 *
 * @author marti
 */
public class Ejemplo_variables_operadores {
    public static void main(String[] args) {
        // Declaraciones
        // Datos primitivos
        int num = 40;
        boolean correcto = true;
        
        // No primitivos
        String texto = "Hola, mundo!";
        int[] arregloNums = {1, 2, 3, 4};
        
        // Sin valor inicial
        int num2;
        boolean falso;
        
        // Declaracion multiple
        double altura = 1.75, peso = 47.6;
        String texto1 = "Hola", texto2 = "Adios";
        
        altura = 1.76;
        
        // Constante
        final double pi = 3.1416;
        
        
        
        // Operadores
        // Aritmeticos
        int valor1 = 20;
        double valor2 = 30.5;
        System.out.println(valor1 + valor2);
        double resultado = valor1 + valor2;
                
        double double1 = 20;
        System.out.println(double1);
        
        System.out.println("Hola, " + "mundo!");
        
        int mod1 = 10 % 2;
        System.out.println(mod1);
        
        // Asignaciones
        char caracter = 'A';
        caracter = 'C';
        System.out.println(caracter);
        
        int num20 = 20;
        num20 -= 10;
        System.out.println(num20);
        
        num20++;
        System.out.println(num20);
    }
}
