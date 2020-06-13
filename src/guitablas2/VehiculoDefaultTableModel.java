package guitablas2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VehiculoDefaultTableModel extends JFrame {

    private JPanel panel;
    private JTable tablaVehiculo;
    private JScrollPane scroll;
    private DefaultTableModel modeloTabla;

    VehiculoDefaultTableModel() {
        iniciarTabla();
        getContentPane().add(scroll, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void iniciarTabla() {
        Object[][] datos = new Object[][]{{"BMX", 1990, "Mazda 323", true},
        {"IBR 678", 1998, "Hiunday Accent", new Boolean(true)},
        {"IBZ 123", 2001, "Corsa", new Boolean(true)},
        {"IBZ 124", 2001, "Corsa", true},
        {"IBZ 321", 2001, "Hiunday Accent", true},
        {"IBZ 322", 2001, "Corsa", false},
        {"ICB 321", 2008, "Corsa", true},
        {"ICB 323", 2008, "Hiunday Accent", true},
        {"ICB 322", 200, "Corsa", true},
        {"ICK 321", 2008, "Corsa", true},
        {"ICK 323", 2008, "Hiunday Accent", true},
        {"ICK 500", 2008, "Corsa", true},
        {"ICK 521", 2008, "Corsa", true},
        {"ICK 522", 2008, "Hiunday Accent", true},
        {"ICK 523", 2008, "Corsa", true},
        {"ICK 524", 2008, "Hiunday Accent", true},
        {"ICM 301", 2010, "Corsa", true}
        };
        
        String[] cabecera = new String[]{
            "Placa","Modelo","Marca","En servicio"
        };
        modeloTabla = new DefaultTableModel(datos,cabecera);
        tablaVehiculo = new JTable(modeloTabla);
        scroll = new JScrollPane(tablaVehiculo);
        
        //A través del modelo podemos agregar columnas
        modeloTabla.addColumn("KPG");
         //A través del modelo podemos agregar filas
        Object[] nuevaFila = {"BMR", "2011", "Hiunday", "nuevo"};
        
        modeloTabla.addRow(nuevaFila);
        
        //Modificar una celda específica 
        modeloTabla.setValueAt("cambio", 14, 0);
    }
}
