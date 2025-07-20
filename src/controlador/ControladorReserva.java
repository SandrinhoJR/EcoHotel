/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.HuespedDAO;
import dao.ReservaDAO;
import dto.ReservaDTO;
import java.time.LocalDate;

/**
 *
 * @author sandro rendon
 */
public class ControladorReserva {
    
    public class ControladorReserva {
    
    private final ReservaDAO dao = new ReservaDAO(new HuespedDAO());
      
    public String agregar(ReservaDTO dto) {
      if (dto.getFechaEntrada().isBefore(LocalDate.now())) {
        return "La fecha de entrada no puede ser anterior a la fecha actual";
    }

    if (dto.getFechaSalida().isBefore(dto.getFechaEntrada()) || dto.getFechaSalida().isEqual(dto.getFechaEntrada())) {
        return "La fecha de salida debe ser posterior a la fecha de entrada";
    }

    if (!dto.getHabitacionDTO().getEstado().equalsIgnoreCase("Libre")) {
        return "La habitación no está disponible para reservar.";
    }

    for (ReservaDTO reserva : dao.getReservasDTO()) {
        if (reserva.getHabitacionDTO().getNumero() == dto.getHabitacionDTO().getNumero()) {
            if (!dto.getFechaEntrada().isAfter(reserva.getFechaSalida()) &&
                !dto.getFechaSalida().isBefore(reserva.getFechaEntrada())) {
                return "La habitación no está disponible en ese rango de fechas.";
            }
        }
    }

    

    
