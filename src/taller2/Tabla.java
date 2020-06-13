package taller2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {

    private JFrame marco = new JFrame();
    private JTabbedPane pestaña = new JTabbedPane();
    private JPanel panel = new JPanel();
    private JLabel panel2 = new JLabel();
    private JLabel panel3 = new JLabel();
    private DefaultTableModel modeloTabla;
    private JTable tablaEmpleado;
    private JScrollPane jscrollPane;
    private JButton boton = new JButton("Guardar");
    JTextField cedula = new JTextField();
    JTextField apellidos = new JTextField();
    JTextField nombres = new JTextField();
    JTextField direccion = new JTextField();
    JTextField telefono = new JTextField();
    JTextField cargo = new JTextField();
    JTextField sueldo = new JTextField();

    Tabla() {
        marco.setTitle("Empelados");
        marco.setSize(600, 300);
        marco.setLocationRelativeTo(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(new BorderLayout());
        crearEmpleado();
        //Registra manejador evento
        boton.addActionListener(new ActionListener() {
            String nombre, apellido, direc, ced, tel, carg, salario;
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton) {
                    ced = cedula.getText();
                    nombre = nombres.getText();
                    apellido = apellidos.getText();
                    direc = direccion.getText();
                    tel = telefono.getText();
                    carg = cargo.getText();
                    salario = sueldo.getText();
                    Object nuevFila[] = {ced, apellido, nombre, direc, tel, carg, salario};
                    modeloTabla.addRow(nuevFila);
                    limpiar();
                }

            }

        });

    }
    void crearEmpleado() {
        panel = new JPanel();
        JPanel izquierdo = new JPanel();
        JPanel central = new JPanel();
        JPanel inferior2 = new JPanel();

        izquierdo.setLayout(new GridLayout(9, 1));
        izquierdo.add(new JLabel("Cédula"));
        izquierdo.add(new JLabel("Apellidos"));
        izquierdo.add(new JLabel("Nombres"));
        izquierdo.add(new JLabel("Dirección"));
        izquierdo.add(new JLabel("Teléfono"));
        izquierdo.add(new JLabel("cargo"));
        izquierdo.add(new JLabel("Sueldo básico"));

        central.setLayout(new GridLayout(9, 1));
        central.add(cedula);
        central.add(apellidos);
        central.add(nombres);
        central.add(direccion);
        central.add(telefono);
        central.add(cargo);
        central.add(sueldo);

        inferior2.setLayout(new FlowLayout());
        inferior2.add(boton);

        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(izquierdo, BorderLayout.WEST);
        panel.add(central, BorderLayout.CENTER);
        panel.add(inferior2, BorderLayout.SOUTH);
        pestaña.addTab("Registro de empleados", panel);

        Object[][] infoEmpleados = new Object[][]{};

        String cabeceras[] = {"Cedula", "Apellido", "Nombre", "Direccion", "Telefono", "Cargo", "Sueldo"};

        modeloTabla = new DefaultTableModel(infoEmpleados, cabeceras);
        tablaEmpleado = new JTable(modeloTabla);
        jscrollPane = new JScrollPane(tablaEmpleado);
        pestaña.addTab("Reporte", jscrollPane);

        marco.getContentPane().add(pestaña, BorderLayout.CENTER);
        marco.setVisible(true);
    }
    void limpiar() {
        cedula.setText(null);
        nombres.setText(null);
        apellidos.setText(null);
        direccion.setText(null);
        telefono.setText(null);
        cargo.setText(null);
        sueldo.setText(null);
    }
}
