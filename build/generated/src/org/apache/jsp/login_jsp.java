package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"contenedor\"> \n");
      out.write("            <div id = \"barra\">\n");
      out.write("\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"Sinc_up.jsp\">Registrate</a>  \n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href =\"login.jsp\">Login</a> \n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id= \"baner\">\n");
      out.write("                \n");
      out.write("                <img width=\"300\" height=\"47\" src=\"images/baner1.png\" alt=\"2\">  \n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id=\"principal\">\n");
      out.write("                \n");
      out.write("                <img width=\"294\" height=\"85\" src=\"images/vi??eta.png\" alt=\"2\" id=\"imagen\"></img>\n");
      out.write("                <h2>Login</h2>\n");
      out.write("\n");
      out.write("                <form action=\"DateControlador5\">\n");
      out.write("\n");
      out.write("                    <input type = \"hidden\" name = \"codigo\"  value =\"comprovarUser\">\n");
      out.write("\n");
      out.write("                    <div style = \"text-align: center\">    \n");
      out.write("                        <table width = \"300\" border = \"0\" style = \"margin: auto\" id=\"tablaform\" > \n");
      out.write("\n");
      out.write("                            <tr> \n");
      out.write("                                <td>\n");
      out.write("                                    <label>Usuario : </label> <br> <br>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type = \"text\" name = \"usuario\" id=\"campoText\"> <br> <br>\n");
      out.write("                                </td>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <label>Contrase??a : </label> <br> <br>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type = \"text\" name = \"contrase??a\" id=\"campoText\"> <br> <br>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan = \"2\" style=\"text-align: center\">\n");
      out.write("                                    <input type = \"submit\" name = \"boton\" value = \"Enviar\" id=\"botonMin\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
