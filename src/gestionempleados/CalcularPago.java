<<<<<<< HEAD:src/gestionempleados/calcularPago.java
package gestionempleados;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author gaat1
 */
public class CalcularPago extends JFrame {
    public CalcularPago(){
         setTitle("Calcular Pago");
        setSize(450,170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(3,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        
        JLabel Salario = new JLabel("Salario: ");
        
        JButton Calcular = new JButton("Calcular");
        JButton Salir = new JButton("Salir");
        
        add(centro, BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(Salario);
        centro.add(Calcular);
        centro.add(Salir);
        
        Salir.addActionListener(e -> {
            
            SwingUtilities.invokeLater(()->{
                MenuPrincipal Inicio = new MenuPrincipal();
                this.setVisible(false);
               Inicio.setVisible(true);
               
            });
        });
         Calcular.addActionListener(e -> {
             Salario.setText("Salario:    $" + Empresa.pagoMensual(Integer.parseInt(codigo.getText())));
             revalidate();
             repaint();
        });
    }
}
=======
package gestionempleados;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author gaat1
 */
public class CalcularPago extends JFrame {
    public CalcularPago(){
         setTitle("Calcular Pago");
        setSize(450,170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(3,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        JLabel Salario = new JLabel("Salario: ");
        JButton Calcular = new JButton("Calcular");
        JButton Salir = new JButton("Salir");
        
        add(centro, BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(Salario);
        centro.add(Calcular);
        centro.add(Salir);
        
        Salir.addActionListener(e -> {
            
            SwingUtilities.invokeLater(()->{
                MenuPrincipal Inicio = new MenuPrincipal();
                this.setVisible(false);
               Inicio.setVisible(true);
               
            });
        });
         Calcular.addActionListener(e -> {
            Salario.setText("Salario:    $" + 0);
           
        });
    }
}
>>>>>>> a08b30cebe300531a7101217f72a1d942754e977:src/gestionempleados/CalcularPago.java
