package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;
import modelo.InteraccionBDD;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Usuario;

/**
 *
 * @author Amaterasu
 */
@WebServlet(name = "DateControlador5", urlPatterns = {"/DateControlador5"})
public class DateControlador5 extends HttpServlet {
    
    @Resource(name = "jdbc")
    DataSource pool;
    
    InteraccionBDD modelo;
    HttpSession session;
    
    @Override
    public void init() throws ServletException {
        
        super.init();
        
        try {
            
            modelo = new InteraccionBDD(pool);
            
            
        } catch (Exception e) {
            
            throw new ServletException(e);
        }
        
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("codigo");
        session = request.getSession();
        
        Usuario user;
        user = (Usuario) session.getAttribute("UsuarioActivo");
        
        
     
        if (user == null && !"comprovarUser".equals(codigo)) {
            
                RequestDispatcher dispat = request.getRequestDispatcher("login.jsp");
                dispat.forward(request, response);
            
        }
        
        switch (codigo) {
            
            case "insertarUser":
                InsertarUsuario(request, response);
                break;
            case "comprovarUser":
                ComprovarUsuario(request, response);
                break;
            case "leerPRT":
                ProcesaPreguntas(request, response);
               
                break;
            case "InsertarPRT":
                establecePregunta(request, response);
                break;
            case "leerPRTSelection":
                CargaPreguntaSelection(request, response);
                break;
            
            case "InsertarRPT":
                estableceRespuesta(request, response);
                break;
            default:
                ProcesaPreguntas(request, response);
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    public void ProcesaPreguntas(HttpServletRequest request, HttpServletResponse response) {
        
         Usuario usuarioActivo = (Usuario) session.getAttribute("UsuarioActivo");
         
         request.setAttribute("usuario", usuarioActivo);
        
        try {
            //crea arrayList para recibir la preguntas

            ArrayList<Pregunta> ListPreguntas = modelo.recibePregunta();

            //Estable la lista en el reques
            request.setAttribute("listPrt", ListPreguntas);

            //reenviar los datos
        } catch (SQLException e) {
            
            e.getMessage();
            System.out.println("Error de coneccion a bdd");
            
        }
        
        try {
            RequestDispatcher dispat = request.getRequestDispatcher("Prin.jsp");
            
            dispat.forward(request, response);
        } catch (IOException | ServletException e) {
            
            e.getMessage();
            System.out.println("error a reenviar datos");
        }
        
    }
    
    private void establecePregunta(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            //captura la fecha de tu  ordenador
            Calendar calendar = Calendar.getInstance();
            
            Date fecha = new Date(calendar.getTimeInMillis());

            //recibe parametros del request
            String PRT = request.getParameter("PRT");
            
            String username = request.getParameter("username");
            String pais = request.getParameter("pais");
            


            //crea objeto pregunta y envia al modelo
            Pregunta nuevaPrt = new Pregunta(PRT, username, fecha, pais);
            
            System.out.println(PRT + username + fecha + pais);
            modelo.RegistraPRT(nuevaPrt);
            


            //redirige el flujo de ejecucion
            ProcesaPreguntas(request, response);
            

            
        } catch (SQLException ex) {
            
            ex.getMessage();
            System.out.println("error al insertar pregunta");
        }
    }
    
    private void CargaPreguntaSelection(HttpServletRequest request, HttpServletResponse response) {
        
        
         Usuario usuarioActivo = (Usuario) session.getAttribute("UsuarioActivo");
         
         request.setAttribute("usuario", usuarioActivo);
        try {
            
            
            String id_String = request.getParameter("ID");
            String user = request.getParameter("user");
            String pregunta = request.getParameter("pregunta");
            
            int id = Integer.parseInt(id_String);
            request.setAttribute("user", user);
            request.setAttribute("pregunta", pregunta);
            

            ArrayList<Respuesta> Respuestas = new ArrayList<Respuesta>();
            
            Respuestas = modelo.CargaRespuestas(id);
            
            request.setAttribute("ListRespuestas", Respuestas);
            
            RequestDispatcher dispat = request.getRequestDispatcher("Respuestas.jsp");
            
            try {
                dispat.forward(request, response);
                
            } catch (Exception ex) {
                
                ex.getMessage();
                System.out.println("error en Dispatcher a respuestas");
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de coneccion");
        }
    }
    
    private void estableceRespuesta(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            String cita = request.getParameter("cita");
            
            Calendar calendar = Calendar.getInstance();
            
            int ID = Integer.parseInt(request.getParameter("ID"));
            String respuesta;
            
            if (cita == null) {
                
                respuesta = request.getParameter("RPT");
                
            } else {
                
                respuesta = "[" + cita + "] " + request.getParameter("RPT");
                
            }
            
            String username = request.getParameter("username");
            Date fecha = calendar.getTime();
            String pais = request.getParameter("pais");
            
            Respuesta nuevaRPT = new Respuesta(ID, respuesta, username, fecha, pais);
            
            modelo.InsertaRespuesta(nuevaRPT);
            
            CargaPreguntaSelection(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de coneccion");
        }
        
    }
    
    private void InsertarUsuario(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            String correo = request.getParameter("correo");
            String pais = request.getParameter("paisOrigen");
            String username = request.getParameter("usuario");
            String contraseña = request.getParameter("contraseña");
            
            Usuario nuevo = new Usuario(username, contraseña, pais, correo);
            
            try {
                modelo.RegistraUsuario(nuevo);
            } catch (SQLException ex) {
                Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error de coneccion");
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error en Dispatcher");
        } catch (IOException ex) {
            Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error en Dispatcher");
        }
    }
    
    private void ComprovarUsuario(HttpServletRequest request, HttpServletResponse response) {
        
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        
        Usuario validar = null;
        try {
            
            validar = modelo.ComprovarUserBDD(usuario, contraseña);
            
        } catch (SQLException ex) {
            Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error de coneccion");
        }
        
        try {
            if (validar != null) {
                
                session.setMaxInactiveInterval(500);
                session.setAttribute("UsuarioActivo", validar);
                
                ProcesaPreguntas(request, response);
                
            } else {
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
                
            }
            
        } catch (ServletException ex) {
            Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DateControlador5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
