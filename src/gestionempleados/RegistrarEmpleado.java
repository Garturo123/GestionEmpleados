package gestionempleados;

import com.toedter.calendar.JDateChooser;
import gestionempleados.Empleado;
import gestionempleados.EmpleadoTemporal;
import gestionempleados.EmpleadoVentas;
import gestionempleados.Empresa;
import gestionempleados.MenuPrincipal;
import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.Date;

import javax.swing.*;



/**
 *
 * @author gaat1
 */
public class RegistrarEmpleado extends JFrame{
    private int TipoEmpleado = 0;
      
    
    public RegistrarEmpleado(){
        setTitle("Registrar Empleados");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        JPanel nav = new JPanel();
        nav.setLayout(new BoxLayout(nav, BoxLayout.X_AXIS));
        JButton Estandar = new JButton("Empleado Estandar");
        JButton Temporal = new JButton("Empleado Temporal");
        JButton Ventas = new JButton("Empleado Ventas");
        
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(5,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        JLabel LabelNombre = new JLabel("Nombre: ");
        JTextField nombre = new JTextField();
        JLabel LabelSalarioBase = new JLabel("Salario Base: ");
        JTextField salarioBase = new JTextField();
        JLabel LfechaFinContrato = new JLabel("Fecha fin contrato: ");
         JDateChooser selectorFecha = new JDateChooser();
        selectorFecha.setDateFormatString("dd/MM/yyyy"); // formato de fecha
        
        
        
        JLabel LabelComision = new JLabel("Comision: ");
        JTextField Comision = new JTextField();
        
        JButton SelecionarImagen = new JButton("Selecionar Imagen");
        
        
        JPanel footer = new JPanel();
        footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));
        footer.setLayout(new GridLayout(1,2,10,10));
        footer.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JButton Registrar = new JButton("Registrar");
        JButton Cancelar = new JButton("Cancelar");
        
        add(nav, BorderLayout.NORTH);
        nav.add(Estandar);
        nav.add(Temporal);
        nav.add(Ventas);
        
        add(centro,  BorderLayout.CENTER);
        centro.add(LabelCodigo);
        centro.add(codigo);
        centro.add(LabelNombre);
        centro.add(nombre);
        centro.add(LabelSalarioBase);
        centro.add(salarioBase);
        centro.add(SelecionarImagen);
        centro.add(new JLabel(""));
        
        add(footer, BorderLayout.SOUTH);
        footer.add(Registrar);
        footer.add(Cancelar);
        
        SelecionarImagen.addActionListener(e ->{
            JFileChooser fileChooser = new JFileChooser();
            // Solo permitir archivos de imagen
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                    "Imágenes", "jpg", "png", "gif", "jpeg"));
            
            // Mostrar el diálogo
            int opcion = fileChooser.showOpenDialog(null);
            if(opcion == JFileChooser.APPROVE_OPTION){
                File archivo = fileChooser.getSelectedFile();
                System.out.println("Archivo seleccionado: " + archivo.getAbsolutePath());
                
                // Mostrar la imagen en un JLabel
                ImageIcon imagen = new ImageIcon(archivo.getAbsolutePath());
                JLabel label = new JLabel(imagen);
                JOptionPane.showMessageDialog(null, label, "Imagen seleccionada", JOptionPane.PLAIN_MESSAGE);
            }
   
        });
        String ruta = "lib/profile.jpg";
        ImageIcon imagen = new ImageIcon(ruta);
        Temporal.addActionListener(e ->{
            TipoEmpleado =2;
           setTitle("Registrar Empleado Temporal");
           centro.remove(LabelComision);
           centro.remove(Comision);   
           centro.add(LfechaFinContrato);
           centro.add(selectorFecha);
           revalidate();
            repaint();
       });
        Estandar.addActionListener(e ->{
            
            TipoEmpleado = 1;
            
           setTitle("Registrar Empleado Estandar");
           centro.remove(LabelComision);
           centro.remove(Comision);        
           centro.remove(LfechaFinContrato);
           centro.remove(selectorFecha);
           revalidate();
            repaint();            
        });
        Ventas.addActionListener(e ->{
            TipoEmpleado = 3;
           setTitle("Registrar Empleado Ventas");
           
           centro.remove(LfechaFinContrato);
           centro.remove(selectorFecha);
           centro.add(LabelComision);
           centro.add(Comision);
           revalidate();
            repaint();
        });
       
        Registrar.addActionListener(e -> {
            RegistarEmp(codigo,salarioBase,nombre,Comision,selectorFecha,imagen);
            
        });
        Cancelar.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                MenuPrincipal ventana = new MenuPrincipal();
                this.setVisible(false);
               ventana.setVisible(true);
            });
            
        });
        
        
    }  

    private void RegistarEmp(JTextField codigo, JTextField salarioBase, JTextField nombre, JTextField Comision, JDateChooser selectorFecha, ImageIcon imagen) {
            if(codigo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese el codigo empleado.");
                return ;
            }
            if(salarioBase.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese el salario base empleado.");
                return ;
            }
            if(nombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de empleado.");
                return ;
            }
             int cod = Integer.parseInt(codigo.getText());
            double sal = Double.parseDouble(salarioBase.getText());   
            if(sal <= 0){
                JOptionPane.showMessageDialog(null, "El empleado no puede tener un salario 0 o negativo.");
                return ;}
            if(Empresa.buscarEmpleados(cod)!=null){
                JOptionPane.showMessageDialog(null, "Ya hay un empleado con este codigo.");
                return; }
            if(TipoEmpleado == 0){
                JOptionPane.showMessageDialog(null, "Selecione un tipo de empleado.");
                return; }
            if(TipoEmpleado == 3 && Double.parseDouble(Comision.getText())<=0){
                JOptionPane.showMessageDialog(null, "La comision tiene que ser mayor a 0.");
                return;
            }
            if(TipoEmpleado == 2){
                Date fecha = selectorFecha.getDate();
                if(fecha != null){
                 Calendar fechaContrato = Calendar.getInstance();
                fechaContrato.setTime(fecha);
                    if(fechaContrato.before(Calendar.getInstance())){
                        JOptionPane.showMessageDialog(null, "Esta fecha para fin de contrato no es valida.");
                        return;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione una fecha para el fin del contrato.");
                    return;
                }
                
            }
                
            
            if(TipoEmpleado == 1){
                Empleado newEmpleado = new Empleado(cod,nombre.getText(),sal,imagen);
                Empresa.registrarEmpleados(newEmpleado);
            }
            
            if(TipoEmpleado == 3){
                EmpleadoVentas newVentasEmp = new EmpleadoVentas(cod, nombre.getText(), sal, imagen, Double.parseDouble(Comision.getText()));
                Empresa.registrarEmpleados(newVentasEmp);
            }
           if(TipoEmpleado == 2 ){  
                Date fecha = selectorFecha.getDate();
                Calendar fechaContrato = Calendar.getInstance();
                fechaContrato.setTime(fecha);
                EmpleadoTemporal newEmpleadoTemp = new EmpleadoTemporal(cod,nombre.getText(),sal,imagen,fechaContrato);
                Empresa.registrarEmpleados(newEmpleadoTemp);
            }
            

                JOptionPane.showMessageDialog(this, "Empleado registrado con exito");
                SwingUtilities.invokeLater(()->{
                    MenuPrincipal ventana = new MenuPrincipal();
                    this.setVisible(false);
                   ventana.setVisible(true);

                });
            
    }
}   