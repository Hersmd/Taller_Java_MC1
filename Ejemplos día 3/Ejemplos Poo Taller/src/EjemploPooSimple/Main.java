package EjemploPooSimple;

public class Main {
    public static void main(String[] args) {
        // CREACIÓN DE OBJETOS (instancias de la clase Espada)
        // Cada uno es una espada diferente con sus propios valores
        
        // Espada de madera con daño 4 y durabilidad 10
        Espada espadaMadera = new Espada("Madera", 4, 10);
        
        // Espada de hierro con daño 6 y durabilidad 20
        Espada espadaHierro = new Espada("Hierro", 6, 20);
        
        // Espada de diamante con daño 8 y durabilidad 30
        Espada espadaDiamante = new Espada("Diamante", 8, 30);
        
        // Mostramos la información de cada espada
        System.out.println("-----------------------");
        espadaMadera.mostrarInfo();  // Llamamos al método mostrarInfo() del objeto espadaMadera
        System.out.println("-----------------------");
        espadaHierro.mostrarInfo();  // Llamamos al método mostrarInfo() del objeto espadaHierro
        System.out.println("-----------------------");
        espadaDiamante.mostrarInfo(); // Llamamos al método mostrarInfo() del objeto espadaDiamante
        System.out.println("-----------------------");
        
        System.out.println("\n#######################");
        
        // DEMOSTRACIÓN DE CAMBIO DE ESTADO
        // Al atacar, modificamos el estado interno del objeto (su durabilidad)
        espadaMadera.atacar();  // Llamamos al método atacar() del objeto espadaMadera
        
        System.out.println("-----------------------");
        espadaMadera.mostrarInfo(); // Mostramos la info otra vez para ver el cambio
    }
}