package gestionempleados;


public class EmpleadoVentas extends Empleado {
    private double tasaComision=0.5;
    private double[] ventasMes; //registro de ventas realizadas cada mes
    private int mesActual =0; 
    
    //constructor
    public EmpleadoVentas(int codigo, String nombre, double salarioBase, int horasTrabajadas, double tasaComision, int mesActual,double[] ventasMes){
     super (codigo,nombre,salarioBase,horasTrabajadas);
     this.tasaComision=tasaComision;
     this.mesActual=0;
     this.ventasMes = new double[12];
    }
    
    public void registroVentas(double monto){
        ventasMes[mesActual]+=monto;
    }
    
    public double calcularComision(){
       return ventasMes[mesActual]*tasaComision;
    }
    
    public double calcularPagoMensual(double pago){
        double salarioProp = super.calcularSalarioProporcional();
        double comision = calcularComision();
        return pago = salarioProp + comision;
    }
    
    public double calcularVentasAnuales(){
      
        return 0;
    }
    
    public String toString(){
        return super.toString();
        
    }
    
    
    
   
    
    
    
    
}
