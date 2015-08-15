package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import com.easybanking.banking.BankAccount;
import java.util.ArrayList;
import com.easybanking.banking.Person;

public final class banking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");

        Person p = (Person) session.getAttribute("CLIENT");
    
      out.write("\n");
      out.write("\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        body{background:#c3dfef}\n");
      out.write("        a {\n");
      out.write("            text-decoration:none;\n");
      out.write("        }\n");
      out.write("        #ebsearch{\n");
      out.write("            background-color:#c3dfef;\n");
      out.write("        }\n");
      out.write("        #ebnewsearch{\n");
      out.write("            float:center;\n");
      out.write("            padding:20px;\n");
      out.write("        }\n");
      out.write("        .ebtextinput{\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 5px 15px;\n");
      out.write("            font-family: Arial, Helvetica, sans-serif;\n");
      out.write("            font-size:14px;\n");
      out.write("            border:1px solid #0076a3; border-right:0px;\n");
      out.write("            border-top-left-radius: 5px 5px;\n");
      out.write("            border-bottom-left-radius: 5px 5px;\n");
      out.write("        }\n");
      out.write("        .ebbutton {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 5px 15px;\n");
      out.write("            font-family: Arial, Helvetica, sans-serif;\n");
      out.write("            font-size:14px;\n");
      out.write("            outline: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: #ffffff;\n");
      out.write("            border: solid 1px #0076a3; border-right:0px;\n");
      out.write("            background: #0095cd;\n");
      out.write("            background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));\n");
      out.write("            background: -moz-linear-gradient(top,  #00adee,  #0078a5);\n");
      out.write("            border-top-right-radius: 5px 5px;\n");
      out.write("            border-bottom-right-radius: 5px 5px;\n");
      out.write("        }\n");
      out.write("        .ebbutton:hover {\n");
      out.write("            text-decoration: none;\n");
      out.write("            background: #007ead;\n");
      out.write("            background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));\n");
      out.write("            background: -moz-linear-gradient(top,  #0095cc,  #00678e);\n");
      out.write("        }\n");
      out.write("        .ebbutton::-moz-focus-inner {\n");
      out.write("            border: 0;\n");
      out.write("        }\n");
      out.write("        .ebclear{\n");
      out.write("            clear:both;\n");
      out.write("        }\n");
      out.write("        h1 { \n");
      out.write("            margin: 0 auto; \n");
      out.write("            width:255px;\n");
      out.write("        }\n");
      out.write("        table { \n");
      out.write("            \n");
      out.write("            margin: 0 auto; \n");
      out.write("            width:250px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Easy Banking!</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Cliente ID: ");
      out.print(p.getId());
      out.write(" Nombre: ");
      out.print(p.getName());
      out.write("</h1>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <td align=\"center\">  # Cuenta  </td>\n");
      out.write("            <td align=\"center\">  Moneda  </td>\n");
      out.write("            <td align=\"center\">Fecha Creacion</td>\n");
      out.write("            <td align=\"center\">Fecha Expiracion</td>\n");
      out.write("            <td align=\"center\">  Monto  </td>\n");
      out.write("            ");

                
                ArrayList<BankAccount> personBankAccount = (ArrayList<BankAccount>) session.getAttribute("BANK_ACCOUNT");
                SimpleDateFormat sdf = new SimpleDateFormat("MM / yyyy");

                if (personBankAccount != null) {
                    for (BankAccount ba : personBankAccount) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\">");
      out.print(ba.getId());
      out.write("</td>\n");
      out.write("                <td align=\"center\">");
      out.print(ba.currencyFormat(ba.getCurrency()));
      out.write("</td>\n");
      out.write("                <td align=\"center\">");
      out.print(sdf.format(ba.getRegisteredDate().getTime()));
      out.write("</td>\n");
      out.write("                <td align=\"center\">");
      out.print(sdf.format(ba.getExpirationDate().getTime()));
      out.write("</td>\n");
      out.write("                <td align=\"center\">");
      out.print(ba.getAmount());
      out.write("</td>\n");
      out.write("                <td style=\"border: 1\"><button type=\"summit\" class=\"ebbutton\" onclick=\"myFunction()\">Deposito</button></td>\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Retiro</button></td>\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Transferencia</button></td>\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Historial</button></td>\n");
      out.write("            </tr>        \n");
      out.write("            ");

                    }
                }
                session.removeAttribute("RESULT_CLIENT");
            
      out.write("            \n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
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
