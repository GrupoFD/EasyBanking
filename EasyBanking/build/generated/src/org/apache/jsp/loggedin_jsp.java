package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class loggedin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>EasyBanking!</title>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #ebsearch{\n");
      out.write("                background-color:#c3dfef;\n");
      out.write("            }\n");
      out.write("            #ebnewsearch{\n");
      out.write("                float:center;\n");
      out.write("                padding:20px;\n");
      out.write("            }\n");
      out.write("            .ebtextinput{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 5px 15px;\n");
      out.write("                font-family: Arial, Helvetica, sans-serif;\n");
      out.write("                font-size:14px;\n");
      out.write("                border:1px solid #0076a3; border-right:0px;\n");
      out.write("                border-top-left-radius: 5px 5px;\n");
      out.write("                border-bottom-left-radius: 5px 5px;\n");
      out.write("            }\n");
      out.write("            .ebbutton {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 5px 15px;\n");
      out.write("                font-family: Arial, Helvetica, sans-serif;\n");
      out.write("                font-size:14px;\n");
      out.write("                outline: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("                text-align: center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: #ffffff;\n");
      out.write("                border: solid 1px #0076a3; border-right:0px;\n");
      out.write("                background: #0095cd;\n");
      out.write("                background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));\n");
      out.write("                background: -moz-linear-gradient(top,  #00adee,  #0078a5);\n");
      out.write("                border-top-right-radius: 5px 5px;\n");
      out.write("                border-bottom-right-radius: 5px 5px;\n");
      out.write("            }\n");
      out.write("            .ebbutton:hover {\n");
      out.write("                text-decoration: none;\n");
      out.write("                background: #007ead;\n");
      out.write("                background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));\n");
      out.write("                background: -moz-linear-gradient(top,  #0095cc,  #00678e);\n");
      out.write("            }\n");
      out.write("            /* Fixes submit button height problem in Firefox */\n");
      out.write("            .ebbutton::-moz-focus-inner {\n");
      out.write("                border: 0;\n");
      out.write("            }\n");
      out.write("            .ebclear{\n");
      out.write("                clear:both;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
 Date d = new Date();
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"ebsearch\">\n");
      out.write("\n");
      out.write("    <h1>Bienvenido,<br> ");
      out.print( request.getParameter("userName"));
      out.write("!</h1>\n");
      out.write("    Fecha de ingreso: ");
      out.print(d);
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div id=\"ebsearch\">\n");
      out.write("        <form id=\"ebnewsearch\" method=\"get\" action=\"UserData\">\n");
      out.write("            <input type=\"text\" class=\"ebtextinput\" name=\"q\" size=\"21\" maxlength=\"120\"><input type=\"submit\" value=\"search\" class=\"ebbutton\">\n");
      out.write("        </form>\n");
      out.write("        <div class=\"ebclear\"></div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div />\n");
      out.write("\n");
      out.write("        <h1>Presione en la transaccion que desea realizar</h1>\n");
      out.write("        <form action=\"newClient.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Agregar cliente\" name=\"newClient\" />    \n");
      out.write("        </form>\n");
      out.write("        <form action=\"createAccount.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Crear cuenta\" name=\"createAccount\" />\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    \n");
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
