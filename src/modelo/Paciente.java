/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author rober
 */
public class Paciente {
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private int telefono;
    private String email;
    private String direccion;
    private String tipoSeguro;
    private String nseguro;
    private String antecedentesSalud;
    private String tratamientoGeneral;
    private Date fechaRegistro;

    public Paciente(String dni, String nombre, String apellidos, Date fechaNacimiento, int telefono, String email, String direccion, String tipoSeguro, String nseguro, String antecedentesSalud, String tratamientoGeneral, Date fechaRegistro) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.tipoSeguro = tipoSeguro;
        this.nseguro = nseguro;
        this.antecedentesSalud = antecedentesSalud;
        this.tratamientoGeneral = tratamientoGeneral;
        this.fechaRegistro = fechaRegistro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getNseguro() {
        return nseguro;
    }

    public void setNseguro(String nseguro) {
        this.nseguro = nseguro;
    }

    public String getAntecedentesSalud() {
        return antecedentesSalud;
    }

    public void setAntecedentesSalud(String antecedentesSalud) {
        this.antecedentesSalud = antecedentesSalud;
    }

    public String getTratamientoGeneral() {
        return tratamientoGeneral;
    }

    public void setTratamientoGeneral(String tratamientoGeneral) {
        this.tratamientoGeneral = tratamientoGeneral;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
