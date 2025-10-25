package gestionempleados;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
public class actualizarContrato extends JFrame {
    public actualizarContrato(){
        setTitle("Registrar Ventas");
        setSize(450,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        JDateChooser selectorFecha = new JDateChooser();
        selectorFecha.setDateFormatString("dd/MM/yyyy"); // formato de fecha

        // Botón para obtener la fecha
        JButton Registrar = new JButton("Registrar");
        Registrar.addActionListener(e -> {
            java.util.Date fecha = selectorFecha.getDate();
            SwingUtilities.invokeLater(()->{
                MenuPrincipal Inicio = new MenuPrincipal();
                this.setVisible(false);
               Inicio.setVisible(true);
               
            });
        });
        add(centro, BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(selectorFecha);
        centro.add(Registrar);
    }
}
