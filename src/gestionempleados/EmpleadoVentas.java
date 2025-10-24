package gestionempleados;


public class EmpleadoVentas extends Empleado {
    private double tasaComision=0.5;
    private double[] ventasMes; //registro de ventas realizadas cada mes
    
    //constructor
    public EmpleadoVentas(int codigo, String nombre, double salarioBase, int horasTrabajadas, double tasaComision, int mesActual,double[] ventasMes){
     super (codigo,nombre,salarioBase,horasTrabajadas);
     this.tasaComision=tasaComision;
     this.ventasMes = new double[12];
    }
    
    public void registroVentas(int mes,double monto){
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
    
    public double calcularVentasAnuales(double total){
        total=0;
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
                "\n Total de ventas anuales: "+calcularVentasAnuales(total);  
    }
    
    
    
   
    
    
    
    
}
