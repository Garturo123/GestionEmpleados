package gestionempleados;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author gaat1
 */
public class reporteGeneral extends JFrame {
    public reporteGeneral(){
        setTitle("Calcular Pago");
        setSize(450,170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        String[] columnas = {"Codigo", "Nombre", "Tipo","Horas Trabajadas","Salario Base","Ventas anuales/ Comision","Fecha fin contrato"};

        // Datos de la tabla (matriz de objetos)
        Object[][] datos = {
           
        };

        // Crear la tabla
        JTable tabla = new JTable(datos, columnas);

        // Colocar la tabla dentro de un JScrollPane (para que tenga scroll)
        JScrollPane scroll = new JScrollPane(tabla);

    }
}
