// Pertenece al mismo paquete que la clase Herramienta
package EjemploPooAvanzado;

/**
 * Clase Espada que extiende (hereda) de Herramienta.
 * Representa una espada en el sistema, con características específicas como daño.
 * 
 * Ejemplo de:
 * - Herencia (extiende de Herramienta)
 * - Polimorfismo (sobreescribe el método usar())
 * - Especialización (añade funcionalidad única con getDaño())
 */
class Espada extends Herramienta {  // 'extends' indica herencia
    // ATRIBUTO PROPIO (no existe en Herramienta)
    private int daño;  // Nivel de daño que causa la espada

    /**
     * Constructor de Espada.
     * @param material Tipo de material (hereda de Herramienta).
     * @param durabilidad Puntos de durabilidad (hereda de Herramienta).
     * @param daño Daño específico que causa esta espada.
     */
    public Espada(String material, int durabilidad, int daño) {
        super(material, durabilidad);  // Llama al constructor de la clase padre (Herramienta)
        this.daño = daño;  // Inicializa el atributo propio de Espada
    }

    // ============= IMPLEMENTACIÓN DE MÉTODOS =============

    /**
     * Implementación del método abstracto usar() de Herramienta (POLIMORFISMO).
     * Define el comportamiento específico de una espada al ser usada.
     */
    @Override  // Indica que estamos sobreescribiendo un método de la clase padre
    public void usar() {
        if (!estaRota()) {  // Usa el método heredado estaRota()
            durabilidad--;  // Reduce la durabilidad (atributo protegido de Herramienta)
            System.out.println("¡Atacaste con la espada! Durabilidad restante: " + durabilidad);
        } else {
            System.out.println("La espada está rota y no puede atacar.");
        }
    }

    /**
     * Método específico de Espada (no existe en Herramienta).
     * @return El valor de daño de la espada.
     */
    public int getDaño() {
        return daño;  // Getter para el atributo propio daño
    }
}