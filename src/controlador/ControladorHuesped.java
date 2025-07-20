/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.HuespedDAO;
import dto.HuespedDTO;
import java.awt.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class ControladorHuesped {

    private final HuespedDAO dao = new HuespedDAO();

    public String agregar(HuespedDTO dto) {

        if (dto.getNombre().isBlank() || dto.getCorreo().isBlank() || dto.getTelefono().isBlank()) {
            return "El nombre, el correo y el telefono no pueden estar vacios. ";
        }
        
        if (!dto.getCorreo().contains("@")) {
            return "el correo debe contener @.";
        }
dao.guardar(dto);
return "Huesped agregado correctamente";
    }
    
    public void eliminar (int documento){
        dao.eliminar(documento);
    }
    
    public String editar (int documento, HuespedDTO dto){
         if (!dto.getCorreo().contains("@")) {
            return "el correo debe contener @.";
        }
boolean resultado = dao.editar(dto);

if(resultado) {
    return "Huesped actualizado correctamente";
}else {
    return "no se puedo editar el huesped";
}
    }
    
    public HuespedDTO buscar(int documento) {
return dao.buscar(documento);
}
    
    public DefaultTableModel listar () {
    return dao.listar();
}
}
