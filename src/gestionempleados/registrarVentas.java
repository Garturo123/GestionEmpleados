package gestionempleados;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author gaat1
 */
public class RegistrarVentas extends JFrame {
    public RegistrarVentas(){
        setTitle("Registrar Ventas");
        setSize(450,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2,3,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        JButton Registrar = new JButton("Registrar");
        
        String[] Meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Diciembre"};
        JComboBox<String> comboMes = new JComboBox<>(Meses);
        comboMes.setBounds(50, 50, 150, 25);

        JButton Cancelar = new JButton("Cancelar");
        
        JLabel LabelMonto = new JLabel("Monto Venta: ");
        JTextField Monto = new JTextField();
        
       
        add(centro,  BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(new JLabel("Mes venta: "));
       
        
        centro.add(Registrar);
        centro.add(LabelMonto);
        
        centro.add(Monto);
        centro.add(comboMes);
        centro.add(Cancelar);
        Registrar.addActionListener(e ->{
             
               Empresa.registarVentas(Integer.parseInt(codigo.getText()), comboMes.getSelectedIndex()+1, Double.parseDouble(Monto.getText()));
                SwingUtilities.invokeLater(()->{
                    JOptionPane.showMessageDialog(null, "Venta registrada con exito.");
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
