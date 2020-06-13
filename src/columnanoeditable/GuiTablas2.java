package columnanoeditable;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GuiTablas2 extends JFrame {

    JTable tablaVehiculo;
    JScrollPane jscrollPane;

    GuiTablas2() {
        iniciarComponentes();
        setSize(600, 300);
        getContentPane().add(jscrollPane);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Cambiar el tamaño de una columna
        TableColumn columna = null;
        columna = tablaVehiculo.getColumnModel().getColumn(1);
        columna.setPreferredWidth(30);

    }

    void iniciarComponentes() {
        Object[][] infoVehiculos = new Object[][]{
            {"IBM 321", 1990, "Mazda 323", true},
            {"IBR 678", 1998, "Hiunday Accent", true},
            {"IBZ 123", 2001, "Corsa", true},
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
        String cabeceras[] = {"Placa", "Modelo", "Marca", "En servicio"};

        tablaVehiculo = new JTable();
        //Crea una clase anonima, derivada de DefaulTableModel
        tablaVehiculo.setModel(new DefaultTableModel(infoVehiculos, cabeceras) {
            Class[] tipoColumna = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] editarColumna = new boolean[]{false, true, true};

            public Class getColumnClass(int indColum) {
                return tipoColumna[indColum];
            }

            public boolean isCellEditable(int indFila, int indColumna) {
                return editarColumna[indColumna];
            }
            
        });
        jscrollPane = new JScrollPane(tablaVehiculo);

    }
}
