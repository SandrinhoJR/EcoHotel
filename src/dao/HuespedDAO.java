/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.HuespedDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Huesped;

/**
 *
 * @author sandro rendon
 */
public class HuespedDAO {
    
    
    private ArrayList<HuespedDTO> huespedesDTO = new ArrayList<>();

    public ArrayList<HuespedDTO> getHuespedesDTO() {
        return huespedesDTO;
    }

    public boolean guardar(HuespedDTO huespedDTO) {
        if (huespedDTO != null && buscar(huespedDTO.getDocumento())==null) {
            huespedesDTO.add(huespedDTO);
            return true;
        }
        return false;
    }

    public HuespedDTO buscar(int documento) {
        for (HuespedDTO huespedDTO : huespedesDTO) {
            if (huespedDTO.getDocumento()==(documento)) {
                return huespedDTO;
            }
        }
        return null;
    }

    public boolean eliminar(int documento) {
        for (int i = 0; i < huespedesDTO.size(); i++) {
            if (huespedesDTO.get(i).getDocumento()==(documento)) {
                huespedesDTO.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editar(HuespedDTO huespedDTO) {
        HuespedDTO aux = buscar(huespedDTO.getDocumento());
        if (aux != null) {
            aux.setNombre(huespedDTO.getNombre());
            aux.setCorreo(huespedDTO.getCorreo());
            aux.setTelefono(huespedDTO.getTelefono());
            return true;
        }
        return false;
    }
    
     public DefaultTableModel listar() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Documento", "Nombre","Correo","Telefono"});
    for (HuespedDTO huespedDTO : huespedesDTO) {
        modelo.addRow(new Object[]{
            huespedDTO.getDocumento(),
            huespedDTO.getNombre(),
            huespedDTO.getCorreo(),
            huespedDTO.getTelefono()        
        });
    }
    return modelo;
}

    
}