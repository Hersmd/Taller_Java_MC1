/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TiendaMascotas;

public class EjemploPOO {

    /**
     * M�todo principal (punto de entrada del programa)
     * @param args argumentos de l�nea de comandos (no se usan en este ejemplo)
     */
    public static void main(String[] args) {
        // ==============================================
        // 1. CREACI�N DE ANIMALES (INSTANCIACI�N DE OBJETOS)
        // ==============================================
        
        // Crear un perro usando el constructor de la clase Perro
        Perro perro1 = new Perro("Rex", 3, 150.50, "Labrador");
        // Par�metros: nombre, edad, precio, raza
        
        // Crear un gato usando el constructor de la clase Gato
        Gato gato1 = new Gato("Luna", 2, 99.99, true);
        // Par�metros: nombre, edad, precio, tienePeloLargo
        
        // Crear un ave usando el constructor de la clase Ave
        Ave ave1 = new Ave("Piol�n", 1, 50.00, true);
        // Par�metros: nombre, edad, precio, puedeVolar
        
        // Llamar al m�todo comer() del ave (heredado de la clase Animal)
        ave1.comer();  // Esto imprimir� "Piol�n est� comiendo."
        perro1.comer();
        
        System.out.println(perro1.getNombre() + " hace: " + perro1.emitirSonido());

        // ==============================================
        // 2. CREACI�N Y CONFIGURACI�N DE LA TIENDA
        // ==============================================
        
        // Crear una instancia de TiendaMascotas
        TiendaMascotas tienda = new TiendaMascotas();
        
        // Agregar animales al inventario de la tienda
        tienda.agregarAnimal(perro1);  // Agrega el perro Rex
        tienda.agregarAnimal(gato1);   // Agrega el gato Luna
        tienda.agregarAnimal(ave1);    // Agrega el ave Piol�n

        // ==============================================
        // 3. DEMOSTRACI�N DE POLIMORFISMO
        // ==============================================
        
        // Recorrer todos los animales en la tienda
        for (Animal animal : tienda.getListaAnimales()) {
            // animal.emitirSonido() muestra comportamiento diferente seg�n el tipo de animal
            System.out.println(animal.getNombre() + " hace: " + animal.emitirSonido());
            // Output esperado:
            // Rex hace: �Guau!
            // Luna hace: �Miau!
            // Piol�n hace: �P�o!
        }

        // ==============================================
        // 4. INTERACCI�N CON CLIENTE
        // ==============================================
        
        // Crear un cliente con nombre "Juan" y presupuesto $200
        Cliente cliente = new Cliente("Juan", 200);
        
        // Mostrar el inventario actual de la tienda
        tienda.mostrarInventario();
        
        // Juan intenta comprar a Rex (�xito, dentro de su presupuesto)
        cliente.comprarMascota(tienda, "Rex");
        
        // Juan intenta comprar a Luna (falla, supera su presupuesto restante)
        cliente.comprarMascota(tienda, "Luna");
        
        // Mostrar las mascotas que Juan ha comprado
        cliente.mostrarMascotas();

        // ==============================================
        // 5. CONSULTA DE ESTAD�STICAS
        // ==============================================
        
        // Obtener y mostrar las ganancias totales de la tienda
        System.out.println("\nGanancias de la tienda: $" + tienda.getGanancias());
    }
}