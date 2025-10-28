<<<<<<< HEAD
package gestionempleados;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author gaat1
 */
public class RegistrarHorasTrabajadas extends JFrame {
    public RegistrarHorasTrabajadas(){
        setTitle("Registrar Horas Trabajadas");
        setSize(320,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(3,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel LabelCodigo = new JLabel("Codigo de empleado: ");
        JTextField codigo = new JTextField();
        JLabel LabelHoras = new JLabel("Horas Trabajadas: ");
        JTextField Horas = new JTextField();
        JButton Registrar = new JButton("Registrar");
        JButton Cancelar = new JButton("Cancelar");
        
        add(centro,  BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(LabelHoras);
        centro.add(Horas);
        centro.add(Registrar);
        centro.add(Cancelar);
        
        Registrar.addActionListener(e ->{
           Empresa.registrarhoras(Integer.parseInt(codigo.getText()), Integer.parseInt(Horas.getText()));
                SwingUtilities.invokeLater(()->{
                    MenuPrincipal Inicio = new MenuPrincipal();
                    this.setVisible(false);
                   Inicio.setVisible(true);
                });
            
            
        });
        Cancelar.addActionListener(e ->{
            SwingUtilities.invokeLater(()->{
                MenuPrincipal Inicio = new MenuPrincipal();
                this.setVisible(false);
               Inicio.setVisible(true);
            });
        });
        
    }
}
=======
package gestionempleados;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author gaat1
 */
public class RegistrarHorasTrabajadas extends JFrame {
    public RegistrarHorasTrabajadas(){
        setTitle("Registrar Horas Trabajadas");
        setSize(320,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(3,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel LabelCodigo = new JLabel("Codigo de empleado: ");
        JTextField codigo = new JTextField();
        JLabel LabelHoras = new JLabel("Horas Trabajadas: ");
        JTextField Horas = new JTextField();
        JButton Registrar = new JButton("Registrar");
       
        add(centro,  BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(LabelHoras);
        centro.add(Horas);
        centro.add(Registrar);
        
        Registrar.addActionListener(e ->{
            SwingUtilities.invokeLater(()->{
                MenuPrincipal Inicio = new MenuPrincipal();
                this.setVisible(false);
               Inicio.setVisible(true);
            });
        });
        
    }
}
>>>>>>> a08b30cebe300531a7101217f72a1d942754e977
