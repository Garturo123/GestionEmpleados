package gestionempleados;

import java.util.Calendar;
import javax.swing.ImageIcon;


public class EmpleadoVentas extends Empleado {
    private double tasaComision;
    private int mesContrato;
    private static double[] ventasMes; //registro de ventas realizadas cada mes
    
    //constructor
    public EmpleadoVentas(int codigo, String nombre, double salarioBase,ImageIcon foto, double tasaComision){
        super (codigo,nombre,salarioBase,foto);
        this.tasaComision=tasaComision;
        ventasMes = new double[12];
        mesContrato = Calendar.getInstance().get(Calendar.MONTH);
    }
    public double getComision(){
        return tasaComision;
    }
    public static void registroVentas(int mes,double monto){
        if (mes<0 || 12<mes){
        ventasMes[mes]+=monto;}
    }
    
    public double calcularComision(int mes){
        if (mes<0 || 12<mes){
       return ventasMes[mes]*tasaComision;}
        else{
            return 0;}
    }
    
    public double calcularPagoMensual(double pago,int mes){
        double salarioProp = super.calcularSalarioProporcional();
        double comision = calcularComision(mes);
        return pago = salarioProp + comision;
    }
    
    public double calcularVentasAnuales(){
        double total=0;
        for (int i =0; i<ventasMes.length;i++){
            double v = ventasMes[i];
        total = total + v;}
        return total;
    }
    
    public String toString(int mes,double total){
        return super.toString() +
                "\n Tasa de comisión: " +(tasaComision * 100) + "%"
                + "\n Ventas de mes actual: " +ventasMes[mes]+
                "\n Comision del mes actual: "+calcularComision(mes)+
                "\n Total de ventas anuales: "+calcularVentasAnuales();  
    }
    
    
}
