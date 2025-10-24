package gestionempleados;

import java.awt.Component;
import javax.swing.*;

/**
 *
 * @author gaat1
 */
public class RegistrarHorasTrabajadas extends JFrame {
    public RegistrarHorasTrabajadas(){
        setTitle("Gestion de empleados");
        setSize(150,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        JLabel LabelNombre = new JLabel("Nombre: ");
        JTextField nombre = new JTextField();
        JButton Registrar = new JButton("Registrar");
        Registrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(LabelCodigo);
        add(codigo);
        add(LabelNombre);
        add(nombre);
        add(Registrar);
        
        Registrar.addActionListener(e ->{
            SwingUtilities.invokeLater(()->{
                MenuPrincipal Inicio = new MenuPrincipal();
               Inicio.setVisible(true);
            });
        });
        
    }
}
