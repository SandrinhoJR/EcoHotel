/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.HabitacionDAO;
import dto.HabitacionDTO;

/**
 *
 * @author sandro rendon
 */
public class ControladorHabitacion {
    
    
      private final HabitacionDAO dao = new HabitacionDAO();

    public String agregar(HabitacionDTO dto) {
if (buscar(dto.getNumero()) !=null) {
    return "ya existe una habitacion con ese numero";
}
if (dto.getCapacidad()< 0) {
    return "la capacidad debe ser mayor a cero";
}
dao.guardar(dto);
return "habitacion agregado correctamente";
    }
    
     public void eliminar (int numero){
        dao.eliminar(numero);
    }
     
     public boolean editar (int numero, HabitacionDTO dto){
         return dao.editar(dto);
     }
     
         public HabitacionDTO buscar(int numero) {
return dao.buscar(numero);
}
    
}
    

