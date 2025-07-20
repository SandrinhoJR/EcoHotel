/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author sandro rendon
 */
public class Huesped {

    private int documento;
    private String nombre;
    private String correo;
    private String telefono;
    private ArrayList <Reserva> reservas;

    public Huesped(int documento, String nombre, String correo, String telefono) {

        setDocumento(documento);
        setNombre(nombre);  
        setCorreo(correo);
        setTelefono(telefono);
        this.reservas = new ArrayList<>();
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}