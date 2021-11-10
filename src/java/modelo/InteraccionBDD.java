
package modelo;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.ArrayList;
import javax.sql.DataSource;


public class InteraccionBDD {
    
    DataSource pool;
    
    public InteraccionBDD(DataSource pool){
        
        this.pool = pool;
    
    }
    
  
    public ArrayList<Pregunta> recibePregunta() throws SQLException{
    
        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
        
        
        Connection cn = pool.getConnection();
        Statement st = cn.createStatement();
        
        String sql = "SELECT * FROM preguntas";
        
        ResultSet rs = st.executeQuery(sql);
        
        
        while(rs.next()){
        
            int id = rs.getInt(1);
            String preguntaConten = rs.getString(2);
            String username = rs.getString(3);
            Date fecha = rs.getDate(4);
            String pais = rs.getString(5);
            
            
            
            
            Pregunta preguntaTmp = new Pregunta(id, preguntaConten, username, fecha, pais);
            
            preguntas.add(preguntaTmp);
        
        }
        
        cn.close();
        return preguntas;
    
    
    }

    public void RegistraPRT(Pregunta nuevaPrt) throws SQLException {
        
        //crea objetos connecion y preparedStatement
        Connection cn = pool.getConnection();
        PreparedStatement pst = cn.prepareStatement("INSERT INTO PREGUNTAS (PREGUNTA,USERNAME,FECHA,PAIS_ORIGEN) VALUES (?,?,?,?)");
        
        //establece los parametros de la cosulta
        pst.setString(1, nuevaPrt.getPregunta());
        pst.setString(2,nuevaPrt.getUsername());
        
        Date fechaSQL = new Date(nuevaPrt.getFecha().getTime());
        
        
        
        pst.setDate(3,  fechaSQL);
        
        pst.setString(4,nuevaPrt.getPais_origen());
        
        //ejecuta la consulta
        pst.executeUpdate();
        cn.close();
        
    }

    public ArrayList<Respuesta> CargaRespuestas(int id_pregunta)throws SQLException {
        
        ArrayList<Respuesta> RespuestasList = new ArrayList<Respuesta>();
        
        Connection cn = pool.getConnection();
        PreparedStatement pst = cn.prepareStatement("SELECT * FROM RESPUESTAS WHERE ID_PREGUNTA = ?");
        
        pst.setInt(1, id_pregunta);
        
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            
            int id_respuesta = rs.getInt(1);
            String respuesta = rs.getString(3);
            String username = rs.getString(4);
            Date fecha = rs.getDate(5);
            String paisOrginen =  rs.getString(6);
            
            Respuesta respuesta_tmp = new Respuesta(id_respuesta,id_pregunta, respuesta, username, fecha, paisOrginen);
           
            RespuestasList.add(respuesta_tmp);
        }
        
        cn.close();
        return RespuestasList;
    }

    public void InsertaRespuesta(Respuesta nuevaRPT) throws SQLException {
        
      Connection cn = pool.getConnection();
      PreparedStatement pst = cn.prepareStatement("INSERT INTO RESPUESTAS VAlUES(?,?,?,?,?,?)");
        
      Date sql = new Date(nuevaRPT.getFecha().getTime());
      
      pst.setInt(1, 0);
      pst.setInt(2,nuevaRPT.getId_pregunta());
      pst.setString(3,nuevaRPT.getRespuesta());
      pst.setString(4, nuevaRPT.getUsername());
      pst.setDate(5, sql);
      pst.setString(6, nuevaRPT.getPais_origen());
      
      pst.executeUpdate();
      cn.close();
    }

    public void RegistraUsuario(Usuario nuevo) throws SQLException {
        
         //crea objetos connecion y preparedStatement
        Connection cn = pool.getConnection();
        PreparedStatement pst = cn.prepareStatement("INSERT INTO user(usuario,contrasena,paisOrigen,correo) VALUES (?,?,?,?)");
        
        //establece los parametros de la cosulta
        pst.setString(1, nuevo.getUsername());
        pst.setString(2,nuevo.getContraseña());
        pst.setString(3,nuevo.getPaisOrigen());
        pst.setString(4,nuevo.getCorreo());
        
        
        //ejecuta la consulta
        pst.executeUpdate();
        cn.close();
        
    }

    public Usuario ComprovarUserBDD(String usuario, String contraseña) throws SQLException {
        
        Connection cn = pool.getConnection();
        PreparedStatement pst = cn.prepareStatement("SELECT * FROM user WHERE USUARIO = ? AND CONTRASENA = ?");
        
        pst.setString(1,usuario);
        pst.setString(2,contraseña);
        
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            
           String user = rs.getString("usuario");
           String contrasena = rs.getString("contrasena");
           String pais = rs.getString("paisOrigen");
           String correo = rs.getString("correo");
           
           if(user.equals(user) && contrasena.equals(contraseña)){
           
               
               Usuario userActivo = new Usuario(user,pais,correo);
               
               return userActivo;
               
           }
            
        }
        
        return null;
    }

  
    
    
    
}
