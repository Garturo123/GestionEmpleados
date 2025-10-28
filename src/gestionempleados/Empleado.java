<<<<<<< HEAD
package gestionempleados;

import java.util.Calendar;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author najma
 */
public class Empleado {

    // atributos 
    protected int codigo;
    protected String nombre;
    protected Calendar fechaContrato;
    protected double salarioBase;
    protected int horasTrabajadas;
    protected String rutaFoto;
    protected ImageIcon foto;

    // Constructor 
    public Empleado(int codigo, String nombre, double salarioBase,ImageIcon foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        horasTrabajadas = 0;
        this.foto = foto;
        this.fechaContrato = Calendar.getInstance();
    }

    // Implementar getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getFechaContrato() {
        return fechaContrato;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    // Implementar setters
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
        this.foto = null;
    }

    // Métodos clave
    public void registroHorasTrabajadas(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Horas negativas no validas!");
        }
        this.horasTrabajadas += horas;
    }

    public double calcularSalarioProporcional() {

        // Horas trabajadas según un mes estándar de 160 horas
        double salarioPorHora = salarioBase / 160.0;
        double salarioProporcional = salarioPorHora * horasTrabajadas;
        double salarioNeto = salarioProporcional * (1.0 - 0.035);

        return salarioNeto;
    }

    // Función de Imagen de identificación personal
    public ImageIcon getFotoEscalada(int ancho, int alto) {
        if (rutaFoto == null) {
            return null;
        }
        try {
            Image img = new ImageIcon(rutaFoto).getImage();
            Image esc = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(esc);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + "\nNombre: " + nombre
                + "\nFecha de contratación: " + fechaContrato.getTime()
                + (rutaFoto != null ? ("\nFoto: " + rutaFoto) : " ");
    }

}
=======
package gestionempleados;

import java.util.Calendar;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author najma
 */
public class Empleado {

    // atributos 
    protected int codigo;
    protected String nombre;
    protected Calendar fechaContrato;
    protected double salarioBase;
    protected int horasTrabajadas;
    protected String rutaFoto;
    protected ImageIcon foto;

    // Constructor 
    public Empleado(int codigo, String nombre, double salarioBase,ImageIcon foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        horasTrabajadas = 0;
        this.foto = foto;
        this.fechaContrato = Calendar.getInstance();
    }

    // Implementar getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getFechaContrato() {
        return fechaContrato;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    // Implementar setters
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
        this.foto = null;
    }

    // Métodos clave
    public void registroHorasTrabajadas(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Horas negativas no validas!");
        }
        this.horasTrabajadas += horas;
    }

    public double calcularSalarioProporcional() {

        // Horas trabajadas según un mes estándar de 160 horas
        double salarioPorHora = salarioBase / 160.0;
        double salarioProporcional = salarioPorHora * horasTrabajadas;
        double salarioNeto = salarioProporcional * (1.0 - 0.035);

        return salarioNeto;
    }

    // Función de Imagen de identificación personal
    public ImageIcon getFotoEscalada(int ancho, int alto) {
        if (rutaFoto == null) {
            return null;
        }
        try {
            Image img = new ImageIcon(rutaFoto).getImage();
            Image esc = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(esc);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + "\nNombre: " + nombre
                + "\nFecha de contratación: " + fechaContrato.getTime()
                + (rutaFoto != null ? ("\nFoto: " + rutaFoto) : " ");
    }

}
>>>>>>> a08b30cebe300531a7101217f72a1d942754e977
