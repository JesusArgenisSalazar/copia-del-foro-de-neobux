
package modelo;

import java.util.Date;


public class Pregunta {
    
    private int id_pregunta;
    private String pregunta;
    private String username;
    private Date fecha;
    private String pais_origen;
    
    public Pregunta(String pregunta,String username,Date fecha,String pais_origen){
    
        this.id_pregunta = 0;
        this.pregunta = pregunta;
        this.username = username;
        this.fecha = fecha;
        this.pais_origen = pais_origen;
    
    }
    
    
    public Pregunta(int id,String pregunta,String username,Date fecha,String pais_origen){
    
        this.id_pregunta = id;
        this.pregunta = pregunta;
        this.username = username;
        this.fecha = fecha;
        this.pais_origen = pais_origen;
    }
    
    
    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }
   
    
    
}
