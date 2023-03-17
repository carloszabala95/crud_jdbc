package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    String url = "jdbc:mysql://localhost:3306/estudiantedb";
    String user = "root";
    String pass = "1234";

    Connection con; //objeto conexion

    public Connection getConnection() { //Hago metodo conexión que retorna un objeto tipo conexión
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) { //Excepción para enseñar que no se hizo conexión a db
            System.out.println(e);
        }
        return con;
    }

}
