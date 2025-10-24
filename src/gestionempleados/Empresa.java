/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleados;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class Empresa {

    private List<Empleado> Empleado;

    public Empresa() {
        this.Empleado = new ArrayList<>();
    }

    public boolean registrarEmpleados(Empleado newEmpleado) {
        for (Empleado emp : Empleado) {
            if (emp.getCodigo() == newEmpleado.getCodigo()) {
                JOptionPane.showMessageDialog(null, "Error El usuario " + newEmpleado.getCodigo() + " ya existe No se agrego", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return Empleado.add(newEmpleado);
    }

    public Empleado buscarEmpleados(int codigo) {
        for (Empleado emp : Empleado) {
            if (emp.getCodigo() == codigo) {
                return emp;
            }
        }
        return null;
    }

    public boolean registrarhoras(int codigo, int horas) {
        Empleado emp = buscarEmpleados(codigo);
        if (emp != null) {
            emp.registroHorasTrabajadas(horas);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Existe", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean registarVentas(int codigo, int mes, double monto) {
        Empleado emp = buscarEmpleados(codigo);

        if (emp != null) {
            if (emp instanceof EmpleadoVentas) {
                EmpleadoVentas empV = (EmpleadoVentas) emp;
                empV.registroVentas(mes, monto);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Es De Ventas ", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Existe", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean actulizarEmpleado(int codigo, Calendar newfecha) {
        Empleado emp = buscarEmpleados(codigo);
        if (emp != null) {
            if (emp instanceof EmpleadoTemporal) {
                EmpleadoTemporal empfecha = (EmpleadoTemporal) emp;
                empfecha.getFechaFinContrato(newfecha);
                return true;
            }
             JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Es Temporal ", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
        }
        JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Existe", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public double pagoMensual(int codigo) {
        Empleado emp=buscarEmpleados(codigo);        
        if (emp != null) {
            return emp.calcularSalarioProporcional(); 
        }
       JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Existe", "Error", JOptionPane.ERROR_MESSAGE);
        return 0.0;
    }

    public void reporteEmpleados() {
        
    }

}
