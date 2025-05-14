/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import utilidades.Encriptado;

/**
 *
 * @author rober
 */
public class Cita {

    private String dniPaciente;
    private String nombre;
    private Date dia;
    private double hora;

    public Cita(String dniPaciente, String nombre, Date dia, double hora) {
        this.dniPaciente = dniPaciente;
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public double getHora() {
        return hora;
    }

    public void setHora(double hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        try {
            String dniDesencriptado = Encriptado.desencriptar(this.dniPaciente);
            String nombreDesencriptado = Encriptado.desencriptar(this.nombre);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", new Locale("es", "ES"));
            String fecha = sdf.format(this.dia);
            String hora = String.format("%.2f", this.hora);

            return "<div style='font-family: Verdana, sans-serif; color: #444;'>"
                    + "<h2 style='color: #1A5276;'>Confirmación de cita médica</h2>"
                    + "<div style='border-top: 2px solid #1A5276; width: 60%; margin-bottom: 15px;'></div>"
                    + "<p><span style='font-weight: bold;'>DNI:</span> " + dniDesencriptado + "</p>"
                    + "<p><span style='font-weight: bold;'>Nombre completo:</span> " + nombreDesencriptado + "</p>"
                    + "<p><span style='font-weight: bold;'>Fecha de la cita:</span> " + fecha + "</p>"
                    + "<p><span style='font-weight: bold;'>Hora asignada:</span> " + hora + "</p>"
                    + "<div style='border-top: 1px dotted #bbb; margin: 25px 0;'></div>"
                    + "<img src='https://reynaldomd.com/firmacorreo/firmacorreo.png' alt='Centro Médico' style='width: 180px; margin-top: 15px;'/>"
                    + "<p style='font-size: 13px; color: #666;'>Este mensaje ha sido enviado porque has reservado una cita en nuestro centro.<br/>"
                    + "Te recordamos que este correo es automático, por lo que no debe ser respondido.</p>"
                    + "</div>";

        } catch (Exception e) {
            return "Error al generar el contenido del correo: " + e.getMessage();
        }
    }

}
