/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Huesped;

/**
 *
 * @author sandro rendon
 */
public class HuespedDAO {
    
    
    private ArrayList<Huesped> huespedes = new ArrayList<>();

    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public boolean guardar(Huesped huesped) {
        if (huesped != null && buscar(huesped.getDocumento())==null) {
            huespedes.add(huesped);
            return true;
        }
        return false;
    }

    public Huesped buscar(String id) {
        for (Huesped huesped : huespedes) {
            if (huesped.getDocumento().equals(id)) {
                return huesped;
            }
        }
        return null;
    }

    public boolean eliminar(String id) {
        for (int i = 0; i < huespedes.size(); i++) {
            if (huespedes.get(i).getDocumento().equals(id)) {
                huespedes.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editar(Huesped huesped) {
        Huesped aux = buscar(huesped.getDocumento());
        if (aux != null) {
            aux.setNombre(huesped.getNombre());
            aux.setCorreo(huesped.getCorreo());
            aux.setTelefono(huesped.getTelefono());
            return true;
        }
        return false;
    }
    
     public DefaultTableModel listar() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Documento", "Nombre","Correo","Telefono"});
    for (Huesped huesped : huespedes) {
        modelo.addRow(new Object[]{
            huesped.getDocumento(),
            huesped.getNombre(),
            huesped.getCorreo(),
            huesped.getTelefono()        
        });
    }
    return modelo;
}

    
}
