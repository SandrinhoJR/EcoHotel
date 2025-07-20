/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import modelo.Habitacion;
import modelo.Huesped;

/**
 *
 * @author sandro rendon
 */
public class ReservaDTO {
    
     private int idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private HuespedDTO huespedDTO;
    private HabitacionDTO habitacionDTO;

    public ReservaDTO(int idReserva, LocalDate fechaEntrada, LocalDate fechaSalida, HuespedDTO huespedDTO, HabitacionDTO habitacionDTO) {
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.huespedDTO = huespedDTO;
        this.habitacionDTO = habitacionDTO;
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
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public HuespedDTO getHuespedDTO() {
        return huespedDTO;
    }

    public void setHuespedDTO(HuespedDTO huespedDTO) {
        this.huespedDTO = huespedDTO;
    }

    public HabitacionDTO getHabitacionDTO() {
        return habitacionDTO;
    }

    public void setHabitacionDTO(HabitacionDTO habitacionDTO) {
        this.habitacionDTO = habitacionDTO;
    }


    
    
    


}