
package gestionempleados;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gaat1
 */
public class ReporteGeneral extends JFrame {
    public ReporteGeneral(){
        setTitle("Calcular Pago");
        setSize(1000,370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
         JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        
        add(centro,  BorderLayout.CENTER);

        JTable tablaEmpleados = new JTable();
        JScrollPane scroll = new JScrollPane(tablaEmpleados);
        JButton Salir = new JButton("Salir");
        JLabel titulo = new JLabel("Tipos de empleados:");
        JLabel Estandar = new JLabel("Estandar: "+ Empresa.contarPorTipo("Estandar"));
        JLabel Temporal = new JLabel("Temporal: "+ Empresa.contarPorTipo("Temporal"));
        JLabel Ventas = new JLabel("Ventas: "+ Empresa.contarPorTipo("Ventas"));
        
        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        Estandar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Temporal.setAlignmentX(Component.CENTER_ALIGNMENT);
        Ventas.setAlignmentX(Component.CENTER_ALIGNMENT);
        Salir.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        centro.add(scroll);
        centro.add(titulo);
        centro.add(Estandar);
        centro.add(Temporal);
        centro.add(Ventas);
        centro.add(Salir);
        
        Salir.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                MenuPrincipal ventana = new MenuPrincipal();
                this.setVisible(false);
               ventana.setVisible(true);
            });
            
        });
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Tipo","Horas Trabajadas","Salario Base","Fecha de contrato","Fecha fin contrato","Comision","Ventas anuales"});
        tablaEmpleados.setModel(modelo);


        modelo.setRowCount(0); 

        List<String[]> datos = Empresa.generarReporteGeneral();

        for (String[] fila : datos) {
            modelo.addRow(fila);
        }

        
    }
}
