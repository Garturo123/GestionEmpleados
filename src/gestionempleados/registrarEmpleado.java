package gestionempleados;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.*;



/**
 *
 * @author gaat1
 */
public class registrarEmpleado extends JFrame{
    public registrarEmpleado(){
        setTitle("Registrar Empleados");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        JPanel nav = new JPanel();
        nav.setLayout(new BoxLayout(nav, BoxLayout.X_AXIS));
        JButton Estandar = new JButton("Empleado Estadar");
        JButton Temporal = new JButton("Empleado Temporal");
        JButton Ventas = new JButton("Empleado Ventas");
        
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(10,2,10,10));
        centro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        JLabel LabelCodigo = new JLabel("Codigo: ");
        JTextField codigo = new JTextField();
        JLabel LabelNombre = new JLabel("Nombre: ");
        JTextField nombre = new JTextField();
        JLabel LabelSalarioBase = new JLabel("Salario Base: ");
        JTextField salarioBase = new JTextField();
        JLabel LfechaFinContrato = new JLabel("Fecha fin contrato: ");
        JTextField fechaFinContrato = new JTextField();
        
        
        
        JButton SelecionarImagen = new JButton("Selecionar Imagen");
        
        
        JPanel footer = new JPanel();
        footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));
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
        Temporal.addActionListener(e ->{
           centro.add(LfechaFinContrato);
           centro.add(fechaFinContrato);
           revalidate();
            repaint();
       });
        Estandar.addActionListener(e ->{
           centro.remove(LfechaFinContrato);
           centro.remove(fechaFinContrato);
           revalidate();
            repaint();
        });
        Ventas.addActionListener(e ->{
           centro.remove(LfechaFinContrato);
           centro.remove(fechaFinContrato);
           revalidate();
            repaint();
        });
        Registrar.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                MenuPrincipal ventana = new MenuPrincipal();
                this.setVisible(false);
               ventana.setVisible(true);
            });
            
        });
        Cancelar.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                MenuPrincipal ventana = new MenuPrincipal();
                this.setVisible(false);
               ventana.setVisible(true);
            });
            
        });
        
        
    }
}
