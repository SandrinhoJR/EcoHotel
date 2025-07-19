/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author sandro rendon
 */
public class Reserva {
    
    private int idReserva;
    private LocalDate fechaEntrada;
    private LocalDate FechaSalida;
    private Huesped nombre;
    private Habitacion numero;

    public Reserva(int idReserva, LocalDate fechaEntrada, LocalDate FechaSalida, Huesped nombre, Habitacion numero) {
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.FechaSalida = FechaSalida;
        this.nombre = nombre;
        this.numero = numero;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(LocalDate FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public Huesped getNombre() {
        return nombre;
    }

    public void setNombre(Huesped nombre) {
        this.nombre = nombre;
    }

    public Habitacion getNumero() {
        return numero;
    }

    public void setNumero(Habitacion numero) {
        this.numero = numero;
    }
    
    
}
