/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rober
 */
public class Utilidades {
    public static void lanzaAlertaCampoVacio(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static boolean combosSinSeleccionar(String opcion) {
        return opcion.equals("Seleccione");
    }

    public static void lanzaAlertaComboVacio(Component ventanaPadre, JComboBox combo) {
        JOptionPane.showMessageDialog(ventanaPadre, "El combo " + combo.getName() + " es obligatoria");
    }

    public static boolean campoVacio(JTextField campo) {
            return "".equals((campo.getText()));
    }
}
