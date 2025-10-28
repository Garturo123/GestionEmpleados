package gestionempleados;

import java.util.Calendar;
import javax.swing.ImageIcon;
/**
 *
 * @author najma
 */
public class EmpleadoTemporal extends Empleado {
    
    // atributos adicionales
    protected Calendar fechaFinContrato;
    
    // Constructor
    public EmpleadoTemporal(int codigo, String nombre, double salarioBase,ImageIcon foto, Calendar fechaFinContrato) {
        super(codigo, nombre, salarioBase, foto);
        this.fechaFinContrato = fechaFinContrato;
    }
    
    // Métodos Claves
    public double calculoPagoCondicionado() {
        Calendar hoy = Calendar.getInstance();
        
        if (hoy.after(fechaFinContrato)) {
            return 0.0;
            }
        return super.calcularSalarioProporcional();
    }
    
    public void actualizarFechaFinContrato(Calendar nuevaFecha) {
       this.fechaFinContrato = (Calendar) nuevaFecha.clone();
        
    }
    
    // Mostrar info extendida
    @Override
    public String toString() {
            return super.toString()+
            "\nFecha de fin de contrato: "+fechaFinContrato.getTime();
    }
    
    public Calendar getFechaFinContrato() {
        return fechaFinContrato;
    }

    void getFechaFinContrato(Calendar newfecha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
