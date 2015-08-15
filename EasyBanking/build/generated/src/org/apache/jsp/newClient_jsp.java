package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newClient_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Nuevo cliente</title>\n");
      out.write("    <h1>Nuevo cliente </h1>\n");
      out.write("    <form action=\"CreatePerson\">\n");
      out.write("        Cedula              :<input type=\"text\" name=\"id\"/><br/>\n");
      out.write("        Nombre              :<input type=\"text\" name=\"name\"/><br/>\n");
      out.write("        Primer apellido      :<input type=\"text\" name=\"lastname\"/><br/>\n");
      out.write("        Segundo apellido     :<input type=\"text\" name=\"lastname02\"/><br/>\n");
      out.write("        E-mail              :<input type=\"text\" name=\"email\" value=\"@\"/><br/>\n");
      out.write("        Feacha de nacimiento:<input type=\"text\" name=\"birthdate\" value=\"00/00/0000\"><br/>\n");
      out.write("        Direccion           :<input type=\"text\" name=\"address\"/><br/>\n");
      out.write("        Telefono          : <input type=\"text\" name=\"phone\" value=\"0000-00-00\"/>\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("        Tipo de cliente: <select name=\"clientType\">\n");
      out.write("            <option value=\"juridico\">Jurídico</option>\n");
      out.write("            <option value=\"fisico\">Físico</option>\n");
      out.write("        </select>\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("        Responsable          : <input type=\"text\" name=\"responsable\"/>\n");
      out.write("        <br/>\n");
      out.write("        <br/>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("        function showMessage() {\n");
      out.write("                alert(\"El usuario ha sido creado con exito\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("      <input type=\"submit\" value=\"Agregar\" name=\"newClient\" onclick =\"showMessage()\" />\n");
      out.write("        <br/>\n");
      out.write("       \n");
      out.write("            \n");
      out.write("  \n");
      out.write("\n");
      out.write("</body>\n");
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
