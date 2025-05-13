/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author rober
 */
public class Utilidades {
    public static boolean campoVacio(JTextField campo) {
        return !("".equals(campo.getText()));
    }
    public static boolean areavacia(JTextArea campo) {
        return !campo.getText().isBlank();
    }

    public static boolean lanzaAlertaCampoVacio(JTextField campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es obligatorio");
        return false;
    }
    
    public static boolean combosSinSeleccionar(String opcion) {
        return opcion.equals("Seleccione");
    }
    
    public static boolean validacionLetraDni(String dni) {

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        int posicion = Integer.parseInt(numeroDni) % 23;

        return letraDni == letras.charAt(posicion);

    }
    
    public static boolean validacionLetra(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        int posicion = Integer.parseInt(numeroDni) % 23;

        return letraDni == letras.charAt(posicion);

    }

    public static boolean validaciontelefonofijo(String telefono) {
        String patrontelefonofijo = "^[9,8]{1}[0-8]{1}[0-9]{7}$";
        return telefono.matches(patrontelefonofijo);

    }

    public static boolean rangotel(int tefn) {
        return tefn <= 988999999;

    }

    public static boolean LazarAlertaCampoNumerico(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El campo" + campo.getName() + "solo admite numeros");
        return false;
    }

    public static boolean enteroCorrecto(JTextField campo) {
        try {
            String texto = campo.getText();

            int numero = Integer.parseInt(texto);

            if (numero > 0) {
                return true;
            }
        } catch (NumberFormatException e) {

        }

        return false;
    }

    public static boolean comboNoSeleccionado(JComboBox combo) {
        return combo.getSelectedIndex() == 0;
    }

    public static void alertaComboNoSeleccionado(Component c) {
        JOptionPane.showMessageDialog(c, "Debes seleccionar un elemento del campo " + c.getName());
    }

    public static boolean confirmaacionDNI(JTextField campo) {

        String patDni = "^[0-9]{8}[A-Z]{1}$";

        return campo.getText().matches(patDni);

    }
    public static Date sumarRestarDiasFecha(Date fec, int dia) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fec);
        calendar.add(Calendar.DAY_OF_YEAR, dia);
        return calendar.getTime();
    }
}
