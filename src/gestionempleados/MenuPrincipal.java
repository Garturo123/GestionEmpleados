package gestionempleados;

import java.awt.Component;
import javax.swing.*;

/**
 *
 * @author gaat1
 */
public class MenuPrincipal extends JFrame{
    public MenuPrincipal(){
        setTitle("Gestion de empleados");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JButton registrarEmpleado = new JButton("Registrar Empleado");
        JButton registrarHoras = new JButton("Registrar Horas");
        JButton registrarVentas = new JButton("Registrar Ventas");
        JButton actualizarContrato = new JButton("Actualizar Contrato");
        JButton calcularPago = new JButton("Calcular Pago");
        JButton reporteGeneral = new JButton("Reporte General");
        
        registrarEmpleado.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarHoras.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarVentas.setAlignmentX(Component.CENTER_ALIGNMENT);
        actualizarContrato.setAlignmentX(Component.CENTER_ALIGNMENT);
        calcularPago.setAlignmentX(Component.CENTER_ALIGNMENT);
        reporteGeneral.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalGlue());
        panel.add(registrarEmpleado);
        panel.add(Box.createVerticalStrut(10));
        panel.add(registrarHoras);
        panel.add(Box.createVerticalStrut(10));
        panel.add(registrarVentas);
        panel.add(Box.createVerticalStrut(10));
        panel.add(actualizarContrato);
        panel.add(Box.createVerticalStrut(10));
        panel.add(calcularPago);
        panel.add(Box.createVerticalStrut(10));
        panel.add(reporteGeneral);
        panel.add(Box.createVerticalGlue());
        
        add(panel);
        
        registrarEmpleado.addActionListener(e ->{ 
            SwingUtilities.invokeLater(()->{
                registrarEmpleado ventana = new registrarEmpleado();
                this.setVisible(false);
               ventana.setVisible(true);
            });
            
        });
        
        
        registrarHoras.addActionListener(e -> {
            
        });
        
        
        registrarVentas.addActionListener(e -> {
       
        });
        
        
        actualizarContrato.addActionListener(e ->{ 
               
        });
        
        
        calcularPago.addActionListener(e -> {
            
        });
        
        
        reporteGeneral.addActionListener(e -> {
        
        });
        
    }
}
