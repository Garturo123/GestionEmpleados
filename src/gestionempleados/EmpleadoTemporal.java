/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleados;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author najma
 */
public class EmpleadoTemporal extends Empleado {
    
    // atributos adicionales
    protected Calendar fechaActual;
    protected Calendar fechaFinContrato;
    
    // Constructor
    public EmpleadoTemporal() {
        super();
        fechaActual = Calendar.getInstance();
        fechaFinContrato.set(2026, Calendar.FEBRUARY, 11);
    }
    
    // Métodos Clave
    public void calculoPagoCondicionado() {
    
        if (fechaActual.before(fechaFinContrato) && fechaActual.equals(fechaFinContrato)) {
        int salarioPorHora;
        // salarioPorHora = (salarioBase / horasTrabajadas);
        // salarioProporcional = salarioPorHora * horasTrabajadas;
        }
    }
    
    public void actualizarFechaFinContrato() {
       
        
    }
    
}
