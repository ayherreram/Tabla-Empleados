package guitablas1;

import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class GuiTablas1 extends JFrame {

    private JTable tablaVehiculos;
    private JScrollPane jscrollPane;
     JTable miTabla = new JTable(10,10);
        

    GuiTablas1() {
        iniciarComponentes();
        setTitle("GUI Interfaces Graficas De Usuario - ADSI 2011");
        setSize(500, 300);
        getContentPane().add(jscrollPane);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miTabla.setVisible(true);
        
    }

    void iniciarComponentes() {
        
        //Matriz Bidimencional que sirve como información de la tabla 
        Object[][] infoVehiculos = new Object[][]{
            
            };
        //Matriz unidimencional que sirve como cabecera para las etiquetas de las tablas 
             String[] cabeceras = new String[]{
                 "Placa","Modelo","Marca", "En servicio"
             };
             tablaVehiculos = new JTable(infoVehiculos, cabeceras);
             jscrollPane = new JScrollPane(tablaVehiculos);

    }

}
