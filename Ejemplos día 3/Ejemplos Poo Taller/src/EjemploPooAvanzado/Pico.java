// Paquete donde se encuentra la clase
package EjemploPooAvanzado;

/**
 * Clase Pico que hereda de Herramienta.
 * Representa un pico en el sistema con una eficiencia específica para picar materiales.
 * 
 * Ejemplo de:
 * - Herencia (extiende de Herramienta)
 * - Polimorfismo (sobreescritura del método usar())
 * - Encapsulamiento (atributo privado con getter)
 */
class Pico extends Herramienta {
    
    // ATRIBUTO PROPIO
    private int eficiencia;  // Nivel de eficiencia al picar (a mayor número, más eficiente)

    /**
     * Constructor de la clase Pico.
     * @param material Tipo de material del pico (ej: "Hierro", "Diamante")
     * @param durabilidad Puntos de durabilidad inicial
     * @param eficiencia Valor que determina qué tan eficiente es el pico al picar
     */
    public Pico(String material, int durabilidad, int eficiencia) {
        super(material, durabilidad);  // Llama al constructor de la clase padre (Herramienta)
        this.eficiencia = eficiencia;  // Asigna la eficiencia específica del pico
    }

    // ============= IMPLEMENTACIÓN DE MÉTODOS =============

    /**
     * Implementación del método abstracto usar() heredado de Herramienta.
     * Define el comportamiento específico del pico cuando se usa.
     * Ejemplo de polimorfismo: misma firma que otros herramientas pero comportamiento único.
     */
    @Override
    public void usar() {
        if (!estaRota()) {  // Verifica si la herramienta está rota (método heredado)
            durabilidad--;  // Reduce la durabilidad en 1 unidad por uso
            System.out.println("¡Picando piedra con el pico! Durabilidad restante: " + durabilidad);
        } else {
            System.out.println("El pico está roto y no puede picar.");
        }
    }

    // ============= MÉTODOS PROPIOS =============

    /**
     * Getter para obtener la eficiencia del pico.
     * @return El valor actual de eficiencia del pico
     * 
     * Proporciona acceso controlado al atributo privado 'eficiencia',
     * manteniendo el principio de encapsulamiento.
     */
    public int getEficiencia() {
        return this.eficiencia;  // Devuelve el valor de eficiencia
    }
}