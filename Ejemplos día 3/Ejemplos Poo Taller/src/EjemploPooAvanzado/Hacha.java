// Pertenece al mismo paquete que Herramienta y Espada
package EjemploPooAvanzado;

/**
 * Clase Hacha que extiende de Herramienta.
 * Representa un hacha en el sistema, con características específicas como velocidad de corte.
 * 
 * Ejemplo de:
 * - Herencia (extiende de Herramienta)
 * - Polimorfismo (implementación única de usar())
 * - Especialización (añade velocidadCorte)
 */
class Hacha extends Herramienta {  // Herencia de la clase abstracta Herramienta

    // ATRIBUTO PROPIO (no existe en la clase padre)
    private int velocidadCorte;  // Velocidad con la que corta el hacha

    /**
     * Constructor de Hacha.
     * @param material Tipo de material (heredado de Herramienta)
     * @param durabilidad Puntos de durabilidad (heredado)
     * @param velocidadCorte Eficiencia de corte específica del hacha
     */
    public Hacha(String material, int durabilidad, int velocidadCorte) {
        super(material, durabilidad);  // Llama al constructor de la clase padre
        this.velocidadCorte = velocidadCorte;  // Inicializa atributo propio
    }

    // ============= IMPLEMENTACIÓN DE MÉTODOS =============

    /**
     * Implementación concreta del método abstracto usar() (OBLIGATORIO por ser Herramienta abstracta)
     * Define el comportamiento específico de un hacha al ser usada.
     * Ejemplo de polimorfismo: misma firma que Espada.usar() pero comportamiento diferente.
     */
    @Override
    public void usar() {
        if (!estaRota()) {  // Usa método heredado para verificar estado
            durabilidad--;  // Reduce durabilidad (atributo protegido de Herramienta)
            System.out.println("¡Talas un árbol con el hacha! Durabilidad restante: " + durabilidad);
        } else {
            System.out.println("El hacha está rota y no puede talar.");
        }
    }

    // ============= MÉTODOS PROPIOS =============
    /**
     * Getter para obtener la velocidad de corte del hacha.
     * @return La velocidad de corte actual del hacha (valor entero)
     * 
     * Este método es importante porque:
     * 1. Permite acceder al valor privado velocidadCorte desde fuera de la clase
     * 2. Sigue el principio de encapsulamiento al no permitir modificación directa
     * 3. Proporciona un punto de control para posibles validaciones futuras
     */
    public int getVelocidadCorte() {
        return velocidadCorte;
    }
}