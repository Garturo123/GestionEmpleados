/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleados;

import java.util.Calendar;
/**
 *
 * @author najma
 */
public class EmpleadoTemporal extends Empleado {
    
    // atributos adicionales
    protected Calendar fechaFinContrato;
    
    // Constructor
    public EmpleadoTemporal(int codigo, String nombre, double salarioBase, int horasTrabajadas, 
            int anioFin, int mesFin, int diaFin) {
        super(codigo, nombre, salarioBase, horasTrabajadas);
        this.fechaFinContrato = Calendar.getInstance();
        this.fechaFinContrato.set(anioFin, mesFin, diaFin);
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
