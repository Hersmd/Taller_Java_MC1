package EjemploPooAvanzado;

/**
 * Clase principal para demostrar los conceptos básicos de:
 * - Herencia
 * - Polimorfismo
 * - Encapsulamiento
 */
public class Main {
    public static void main(String[] args) {
        // ========== CREACIÓN DE OBJETOS ==========
        // Usamos el tipo base Herramienta pero instanciamos clases concretas
        Herramienta espada = new Espada("Hierro", 8, 5);  // Espada con daño 5
        Herramienta pico = new Pico("Diamante", 12, 3);    // Pico con eficiencia 3
        Herramienta hacha = new Hacha("Madera", 6, 2);   // Hacha con velocidad 2

        // ========== DEMOSTRACIÓN DE ESPADA ==========
        System.out.println("\n=== USANDO ESPADA ===");
        espada.mostrarInfo();  // Método heredado de Herramienta
        
        // Casting a Espada para acceder a métodos específicos
        System.out.println("Daño de la espada: " + ((Espada)espada).getDaño());
        
        espada.usar();  // Comportamiento polimórfico (se ejecuta Espada.usar())
        espada.usar();

        // ========== DEMOSTRACIÓN DE PICO ==========
        System.out.println("\n=== USANDO PICO ===");
        pico.mostrarInfo();
        System.out.println("Eficiencia del pico: " + ((Pico)pico).getEficiencia());
        pico.usar();  // Se ejecuta Pico.usar()

        // ========== DEMOSTRACIÓN DE HACHA ==========
        System.out.println("\n=== USANDO HACHA ===");
        hacha.mostrarInfo();
        System.out.println("Velocidad del hacha: " + ((Hacha)hacha).getVelocidadCorte());
        hacha.usar();  // Se ejecuta Hacha.usar()

        // ========== TEST DE DURABILIDAD ==========
        System.out.println("\n=== TEST DE ROTURA ===");
        Herramienta hachaFragil = new Hacha("Cristal", 2, 1);
        hachaFragil.usar();
        hachaFragil.usar();  // Debería romperse aquí
        hachaFragil.usar();  // Intento de uso cuando está rota
    }
}