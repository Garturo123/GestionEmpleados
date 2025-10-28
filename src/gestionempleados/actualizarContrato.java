package gestionempleados;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;
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
public class ActualizarContrato extends JFrame {
    public ActualizarContrato(){
        setTitle("Actualizar Contrato");
        setSize(450,180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(3,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        JDateChooser selectorFecha = new JDateChooser();
        selectorFecha.setDateFormatString("dd/MM/yyyy"); // formato de fecha

        // Botón para obtener la fecha
        JButton Registrar = new JButton("Registrar");
        JButton Cancelar = new JButton("Cancelar");
        Registrar.addActionListener(e -> {
            Empleado Emp = Empresa.buscarEmpleados(Integer.parseInt(codigo.getText()));
            if(Emp != null){
                java.util.Date fecha = selectorFecha.getDate();
            if(fecha == null)    {
                 Calendar fechaContrato = Calendar.getInstance();
                fechaContrato.setTime(fecha);
                if(fechaContrato.after(Emp.fechaContrato)){
                    JOptionPane.showMessageDialog(null, "Fecha fin de contrato actualizada con exito.");
                    EmpleadoTemporal.actualizarFechaFinContrato(fechaContrato);
                SwingUtilities.invokeLater(()->{
                    MenuPrincipal Inicio = new MenuPrincipal();
                    this.setVisible(false);
                   Inicio.setVisible(true);

                });
                    }
                else
                 JOptionPane.showMessageDialog(null, "La nueva fecha de fin de contrato es invalida.");
                }
            else
                 JOptionPane.showMessageDialog(null, "Ingrese una fecha para el fin del contrato.");
            }
            else
                 JOptionPane.showMessageDialog(null, "No hay empleado con ese codigo.");
        });
        Cancelar.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                MenuPrincipal Inicio = new MenuPrincipal();
                this.setVisible(false);
               Inicio.setVisible(true);
               
            });
        });
        add(centro, BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(new JLabel("Fecha del Fin del Contrato: "));
        centro.add(selectorFecha);
        centro.add(Registrar);
        centro.add(Cancelar);
    }
}
