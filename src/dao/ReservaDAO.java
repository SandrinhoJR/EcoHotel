/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.HuespedDTO;
import dto.ReservaDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class ReservaDAO {
      private ArrayList<ReservaDTO> reservasDTO = new ArrayList<>();
      private HuespedDAO huespedDAO;

    public ReservaDAO(HuespedDAO huespedDAO) {
        this.huespedDAO = huespedDAO;
    }

    public ArrayList<ReservaDTO> getReservasDTO() {
        return reservasDTO;
    }

    public void setReservasDTO(ArrayList<ReservaDTO> reservasDTO) {
        this.reservasDTO = reservasDTO;
    }
      
      
    
    public boolean guardar(ReservaDTO reservaDTO) {
        if (reservaDTO != null && buscar(reservaDTO.getIdReserva())==null && reservaDTO.getHabitacionDTO().getEstado().equals("Libre")) {
            reservasDTO.add(reservaDTO);
            return true;
        }
        return false;
    }

    public ReservaDTO buscar(int id) {
        for (ReservaDTO reservaDTO : reservasDTO) {
            if (reservaDTO.getIdReserva()==(id)) {
                return reservaDTO;
            }
        }
        return null;
    }
    
    public HuespedDTO buscarHuesped (int documento){
        return huespedDAO.buscar(documento);
    }

    public boolean eliminar(int id, int documento) {
        HuespedDTO huespedDTO = buscarHuesped(documento);
 
        for (int i = 0; i < reservasDTO.size(); i++) {
            if (reservasDTO.get(i).getIdReserva()==(id)) {
                reservasDTO.remove(i);
                huespedDTO.getReservas().remove(i);
                
                return true;
            }
        }
        return false;
    }

    public boolean editar(ReservaDTO reservaDTO) {
    ReservaDTO aux = buscar(reservaDTO.getIdReserva());

    if (aux != null) {
        aux.setFechaEntrada(reservaDTO.getFechaEntrada());
        aux.setFechaSalida(reservaDTO.getFechaSalida());
        aux.setHabitacionDTO(reservaDTO.getHabitacionDTO());
        aux.setHuespedDTO(reservaDTO.getHuespedDTO());

        // Buscar el huésped por su ID
        HuespedDTO h = buscarHuesped(reservaDTO.getHuespedDTO().getDocumento());
        if (h != null) {
            for (ReservaDTO r : h.getReservas()) {
                if (r.getIdReserva()==(reservaDTO.getIdReserva())) {
                    r.setFechaEntrada(reservaDTO.getFechaEntrada());
                    r.setFechaSalida(reservaDTO.getFechaSalida());
                    r.getHabitacionDTO().setNumero(reservaDTO.getHabitacionDTO().getNumero());
                    r.setHuespedDTO(reservaDTO.getHuespedDTO());
                    break;
                }
            }
        }

        return true;
    }

    return false;
}
    
     public DefaultTableModel listar() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Check-in", "Check-out","Habitacion","Huesped"});
    for (ReservaDTO reservaDTO : reservasDTO) {
        modelo.addRow(new Object[]{
            reservaDTO.getFechaEntrada(),
            reservaDTO.getFechaSalida(),
            reservaDTO.getHabitacionDTO().getNumero(),
            reservaDTO.getHuespedDTO().getNombre()
        });
    }
    return modelo;
}

}