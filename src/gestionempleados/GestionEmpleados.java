/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionempleados;

import javax.swing.SwingUtilities;

/**
 *
 * @author gaat1
 */
public class GestionEmpleados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            MenuPrincipal Inicio = new MenuPrincipal();
           Inicio.setVisible(true);
        });
    }
    
}
