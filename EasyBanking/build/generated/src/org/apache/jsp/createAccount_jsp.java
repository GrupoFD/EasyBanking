package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Nueva Cuenta</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <form action=\"CreateAccount\">\n");
      out.write("        \n");
      out.write("        <h1>Ingrese la información que se le solicita</h1>\n");
      out.write("        Numero de cedula:<input type=\"text\" name=\"Identification\"/><br/>\n");
      out.write("        Numero de cuenta:<input type=\"text\" name=\"Account\"/><br/>\n");
      out.write("        Moneda          : <select name=\"Currency\"><br/>\n");
      out.write("            <option value=\"colon\">Colon</option>\n");
      out.write("            <option value=\"dolar\">Dolar</option>\n");
      out.write("            <option value=\"euro\">Euro</option>\n");
      out.write("       </select><br/>\n");
      out.write("       Monto a depositar:<input type=\"number\" name=\"Amount\"/><br/>\n");
      out.write("       \n");
      out.write("       <script type=\"text/javascript\">\n");
      out.write("        function showMessage() {\n");
      out.write("                alert(\"La cuenta ha sido creado con exito\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("      <input type=\"submit\" value=\"Agregar\" name=\"newClient\" onclick =\"showMessage()\" />\n");
      out.write("        <br/>\n");
      out.write("       <br/>\n");
      out.write("       \n");
      out.write("       \n");
      out.write("       <form/>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
