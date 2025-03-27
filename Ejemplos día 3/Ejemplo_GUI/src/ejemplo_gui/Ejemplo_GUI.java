/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_gui;

import GUI.VentanaPrincipal;

/**
 *
 * @author angel
 */
public class Ejemplo_GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // El Try-Catch es solo para ponerle el tema que trae la ventana JFrame por defecto
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Aquí si se crea un objeto de la clase que creamos, la clase de la ventana principal
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        // Y luego solo se hace visible este objeto, para que aparezca en pantalla
        ventanaPrincipal.setVisible(true);
    }
    
}
