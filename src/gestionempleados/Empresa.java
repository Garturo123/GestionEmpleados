
package gestionempleados;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class Empresa {

    private static List<Empleado> Empleado = new ArrayList<>();;

    public static boolean registrarEmpleados(Empleado newEmpleado) {
        for (Empleado emp : Empleado) {
            if (emp.getCodigo() == newEmpleado.getCodigo()) {
                JOptionPane.showMessageDialog(null, "Error El usuario " + newEmpleado.getCodigo() + " ya existe No se agrego", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return Empleado.add(newEmpleado);
    }

    public static Empleado buscarEmpleados(int codigo) {
        for (Empleado emp : Empleado) {
            if (emp.getCodigo() == codigo) {
                return emp;
            }
        }
        return null;
    }

    public static boolean registrarhoras(int codigo, int horas) {
        Empleado emp = buscarEmpleados(codigo);
        if (emp != null) {
            emp.registroHorasTrabajadas(horas);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Existe", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public static boolean registarVentas(int codigo, int mes, double monto) {
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

    public static double pagoMensual(int codigo) {
        Empleado emp = buscarEmpleados(codigo);
        if (emp != null) {
            return emp.calcularSalarioProporcional();
        }
        JOptionPane.showMessageDialog(null, "Error El usuario coodigo: " + codigo + " No Existe", "Error", JOptionPane.ERROR_MESSAGE);
        return 0.0;
    }

    public static List<String[]> generarReporteGeneral() {
        List<String[]> datos = new ArrayList<>();
        for(Empleado e : Empleado){
            String tipo = "";
            String ventasAnuales = "";
            String comision = "";
            String fechaFinContrato = "";
            if(e instanceof EmpleadoTemporal){
                tipo = "Temporal";
                EmpleadoTemporal empTemp = (EmpleadoTemporal) e;
                fechaFinContrato = empTemp.getFechaFinContrato().getTime().toString();
                ventasAnuales = "-----";
                comision = "-----";
            }else if(e instanceof EmpleadoVentas){
                tipo = "Ventas";
                EmpleadoVentas empVentas = (EmpleadoVentas) e;
                ventasAnuales = empVentas.calcularVentasAnuales()+"";
                comision = empVentas.getComision()+"";
                fechaFinContrato = "-----";
            }else {
                tipo = "Estandar";
                ventasAnuales = "-----";
                comision = "-----";
                fechaFinContrato = "-----";
            }
            double pago = e.calcularSalarioProporcional();
            datos.add(new String[]{
                e.codigo+"",
                e.nombre,
                tipo,
                e.horasTrabajadas+"",
                e.getSalarioBase()+"",
                e.fechaContrato.getTime()+"",
                fechaFinContrato,
                comision,
                ventasAnuales
            });
        }
        
        return datos;
    }
    public static int contarPorTipo(String tipo){
        int contador = 0;
        for (Empleado e : Empleado) {
            if ( tipo.equals("Estandar")&&!(e instanceof EmpleadoTemporal) && !(e instanceof EmpleadoVentas)) contador++;
            else if (tipo.equals("Temporal")&& e instanceof EmpleadoTemporal) contador++;
            else if (tipo.equals("Ventas")&& e instanceof EmpleadoVentas) contador++;
        }
        return contador;
    }
}
