
package Modelo;

public class Estudiante { //Se crean atributos y metodos a la clase Estudiante
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Estudiante() { //Contructor Vacio

    }

    public Estudiante(int id, String nonmbre, String correo, String telefono) { //Constructor inicializando atributos
        this.id = id;
        this.nombre = nonmbre;
        this.correo = correo;
        this.telefono = telefono;
    }

    /**
     * @return the id
     */
    public int getId() { //Getters and Setters 
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nonmbre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nonmbre the nonmbre to set
     */
    public void setNombre(String nonmbre) {
        this.nombre = nonmbre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}
