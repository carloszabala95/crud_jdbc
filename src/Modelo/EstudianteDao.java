
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EstudianteDao {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    Conexion conectar = new Conexion();
    Estudiante p;
    
    public List listar(){
        List<Estudiante> datos = new ArrayList<>(); //Lista de objetos de clase estudiante
        try {
            con = conectar.getConnection(); // al objeto con de clase conectar le aplico el metodo de su clase getConnection
            ps = con.prepareStatement("select*from estudiante"); //hago sentencia sql para traer datos de bd
            rs = ps.executeQuery(); //Recibo lo que dio la ejecucion del ps
            while(rs.next()){//mientras rs tenga un siguiente registro se ejecuta
                
                Estudiante p = new Estudiante();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));
                
                datos.add(p);
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        
        return datos;
    }
    
    public int agregar(Estudiante per){
        
        int r=0;
        
        String sql = "insert into estudiante(Nombres, Correo, Telefono) values(?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getCorreo());
            ps.setString(3, per.getTelefono());
            r = ps.executeUpdate();
            
            if (r==1){
                return 1;
                
            }else{
                return 0;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        
        return r;
    
    }
    
    public int actualizar(Estudiante per){
        int r = 0 ;
        String sql = "update estudiante set Nombre=?, Correo=?, Telefono=? where id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getCorreo());
            ps.setString(3,per.getTelefono());
            ps.setInt(4,per.getId());
            r = ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        return r;

    }
    
    public int borrar(int id){
        int r = 0;
        
        String sql = "delete from estudiante where Id ='"+id+"'";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
        
        return r;
    } 
    
}
