
package modelo;


public class Usuario {
    
    private int id;
    private String username = "hh";
    private String contraseña;
    private String paisOrigen;
    private String correo;

   
    
    
    public Usuario(String username, String contraseña,String paisOrigen, String correo){
    
        id = 0;
        this.username = username;
        this.contraseña = contraseña;
        this.paisOrigen = paisOrigen;
        this.correo = correo;
        
    }
    
    public Usuario(String username,String paisOrigen, String correo){
    
        this.username = username;
        this.paisOrigen = paisOrigen;
        this.correo = correo;
        
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
