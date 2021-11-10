
package modelo;

import java.util.Date;

public class Respuesta {
    
    private int id_respuesta;
    private int id_pregunta;
    private String respuesta;
    private String username;
    private Date fecha;
    private String pais_origen;
    
    public Respuesta(int id_pregunta,String respuesta,String username,Date fecha,String pais_origen){
    
        id_respuesta = 0;
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.username = username;
        this.fecha = fecha;
        this.pais_origen = pais_origen;
    
    }
    
    public Respuesta(int id_respuesta,int id_pregunta,String respuesta,String username,Date fecha,String pais_origen){
    
        this.id_respuesta = id_respuesta;
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.username = username;
        this.fecha = fecha;
        this.pais_origen = pais_origen;
    
    }

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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


    
    
    