
package Controlador;

import Modelo.Estudiante;
import Modelo.EstudianteDao;
import Vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    
   EstudianteDao dao = new EstudianteDao();
   Estudiante estudiante = new Estudiante();
   
   Interfaz vista = new Interfaz();
   
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador (Interfaz v){
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
    }
    
    void nuevo(){
        
        vista.txtId.setText("");
        vista.txtNom.setText("");
        vista.txtCorreo.setText("");
        vista.txtTel.setText("");
    
    }
    
    void limpiarTabla(){
    
        for(int i =0; i<vista.jTabla.getRowCount(); i++){
            
            modelo.removeRow(i);
            i = i-1;
        
        }
    }
    
    public void borrar(){
        
        int fila = vista.jTabla.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(vista,"Seleccione un registro");
        }else{
            int id = Integer.parseInt((String) vista.jTabla.getValueAt(fila, 0).toString());
            dao.borrar(id);
            JOptionPane.showMessageDialog(vista, "Estudiante Eliminado");
            
        }
        limpiarTabla();
    
    }
    
    public void anhadir(){
    
        String nom = vista.txtNom.getText();
        String correo = vista.txtCorreo.getText();
        String tel = vista.txtTel.getText();
        
        estudiante.setNombre(nom);
        estudiante.setCorreo(correo);
        estudiante.setTelefono(tel);
        int r  = dao.agregar(estudiante);
        if(r==1){
            JOptionPane.showMessageDialog(vista, "Se pudo agregar");
            
        }else{
            JOptionPane.showMessageDialog(vista, "No se pudo agregar");
        }
        limpiarTabla();
        
    }
   
    public void actualizar(){
        if(vista.txtId.getText().equals("")){
            JOptionPane.showMessageDialog(vista, "Seleccione primero");
        }else{
            int id = Integer.parseInt(vista.txtId.getText());
            String nom = vista.txtNom.getText();
            String correo = vista.txtCorreo.getText();
            String tel = vista.txtTel.getText();
            estudiante.setId(id);
            estudiante.setNombre(nom);
            estudiante.setCorreo(correo);
            estudiante.setTelefono(tel);
            int r = dao.actualizar(estudiante);
            if(r==1){
            JOptionPane.showMessageDialog(vista, "Se pudo ctualizar");
            
        }else{
            JOptionPane.showMessageDialog(vista, "No se pudo actualizar");
        }
        limpiarTabla();
        }
        limpiarTabla();
    }
    
    public void listar(JTable jTabla){
        modelo = (DefaultTableModel) jTabla.getModel();
        jTabla.setModel(modelo);
        jTabla.setModel(modelo);
        List<Estudiante> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i<lista.size();i++){
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getCorreo();
            objeto[3] = lista.get(i).getTelefono();
            modelo.addRow(objeto);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == vista.btnListar){
            limpiarTabla();
            listar(vista.jTabla);
            nuevo();
            
        }
        if(e.getSource()==vista.btnAgregar){
            anhadir();
            listar(vista.jTabla);
            nuevo();
        }
        if(e.getSource() == vista.btnEditar){
            int fila = vista.jTabla.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Seleccione uno");
            }else{
                int id = Integer.parseInt((String) vista.jTabla.getValueAt(fila, 0).toString());
                String nom = (String) vista.jTabla.getValueAt(fila, 1);
                String correo = (String) vista.jTabla.getValueAt(fila, 2);
                String telefono = (String) vista.jTabla.getValueAt(fila, 3);
                vista.txtId.setText(""+id);
                vista.txtNom.setText(nom);
                vista.txtCorreo.setText(correo);
                vista.txtTel.setText(telefono);
                
            }
            
        }
        
        if(e.getSource()==vista.btnActualizar){
            actualizar();
            listar(vista.jTabla);
            nuevo();
        }
        if(e.getSource()== vista.btnBorrar){
            borrar();
            listar(vista.jTabla);
            nuevo();
        }
        if(e.getSource()==vista.btnLimpiar){
            nuevo();
        }
    }
}
