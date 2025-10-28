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
        JButton registrarHorasTrabajadas = new JButton("Registrar Horas Trabajadas");
        JButton registrarVentas = new JButton("Registrar Ventas");
        JButton actualizarContrato = new JButton("Actualizar Contrato");
        JButton calcularPago = new JButton("Calcular Pago");
        JButton reporteGeneral = new JButton("Reporte General");
        
        registrarEmpleado.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarHorasTrabajadas.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarVentas.setAlignmentX(Component.CENTER_ALIGNMENT);
        actualizarContrato.setAlignmentX(Component.CENTER_ALIGNMENT);
        calcularPago.setAlignmentX(Component.CENTER_ALIGNMENT);
        reporteGeneral.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalGlue());
        panel.add(registrarEmpleado);
        panel.add(Box.createVerticalStrut(10));
        panel.add(registrarHorasTrabajadas);
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
                RegistrarEmpleado ventana = new RegistrarEmpleado();
                this.setVisible(false);
               ventana.setVisible(true);
            });
            
        });
        
        
       
        
        
        registrarHorasTrabajadas.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                RegistrarHorasTrabajadas ventana = new RegistrarHorasTrabajadas();
                this.setVisible(false);
               ventana.setVisible(true);
            });
        });
        
        
        
        
        registrarVentas.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                RegistrarVentas ventana = new RegistrarVentas();
                this.setVisible(false);
               ventana.setVisible(true);
            });
       
        });
        
        
        
        
        actualizarContrato.addActionListener(e ->{ 
           SwingUtilities.invokeLater(()->{
                ActualizarContrato ventana = new ActualizarContrato();
                this.setVisible(false);
               ventana.setVisible(true);
            });    
        });
        
        
               
    
        
        
        calcularPago.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                CalcularPago ventana = new CalcularPago();
                this.setVisible(false);
               ventana.setVisible(true);
            });    
        });
        
        
        
        
        reporteGeneral.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                ReporteGeneral ventana = new ReporteGeneral();
                this.setVisible(false);
               ventana.setVisible(true);
            });  
        
        });
        
        
    }
}
