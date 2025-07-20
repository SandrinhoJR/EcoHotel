/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.HabitacionDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class HabitacionDAO {
    
    private ArrayList<HabitacionDTO> habitacionesDTO = new ArrayList<>();

    public ArrayList<HabitacionDTO> getHabitacionesDTO() {
        return habitacionesDTO;
    }

    public boolean guardar(HabitacionDTO habitacionDTO) {
        if (habitacionDTO != null && buscar(habitacionDTO.getNumero())==null) {
            habitacionesDTO.add(habitacionDTO);
            return true;
        }
        return false;
    }

    public HabitacionDTO buscar(int numero) {
        for (HabitacionDTO habitacionDTO : habitacionesDTO) {
            if (habitacionDTO.getNumero()==(numero)) {
                return habitacionDTO;
            }
        }
        return null;
    }

    public boolean eliminar(int numero) {
        for (int i = 0; i < habitacionesDTO.size(); i++) {
            if (habitacionesDTO.get(i).getNumero()==(numero)) {
                habitacionesDTO.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editar(HabitacionDTO habitacionDTO) {
        HabitacionDTO aux = buscar(habitacionDTO.getNumero());
        if (aux != null) {
            aux.setNumero(habitacionDTO.getNumero()); 
            aux.setTipo(habitacionDTO.getTipo());
            aux.setCapacidad(habitacionDTO.getCapacidad());
            aux.setEstado(habitacionDTO.getEstado());
            return true;
        }
        return false;
    }
    
     public DefaultTableModel listar() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Documento", "Nombre","Correo","Telefono"});
    for (HabitacionDTO habitacionDTO : habitacionesDTO) {
        modelo.addRow(new Object[]{
            habitacionDTO.getNumero(),
            habitacionDTO.getTipo(),
            habitacionDTO.getCapacidad(),
            habitacionDTO.getEstado()
        });
    }
    return modelo;
   }      
    

}
