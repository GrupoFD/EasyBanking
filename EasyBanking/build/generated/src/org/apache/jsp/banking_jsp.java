package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import com.easybanking.banking.BankAccount;
import java.text.SimpleDateFormat;
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    ");

        Person p = (Person) session.getAttribute("CLIENT");
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("        body{background:#c3dfef}\r\n");
      out.write("        a {\r\n");
      out.write("            text-decoration:none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #ebsearch{\r\n");
      out.write("            background-color:#c3dfef;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #ebnewsearch{\r\n");
      out.write("            float:center;\r\n");
      out.write("            padding:20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .ebtextinput{\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 5px 15px;\r\n");
      out.write("            font-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("            font-size:14px;\r\n");
      out.write("            border:1px solid #0076a3; border-right:0px;\r\n");
      out.write("            border-top-left-radius: 5px 5px;\r\n");
      out.write("            border-bottom-left-radius: 5px 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .ebbutton {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 5px 15px;\r\n");
      out.write("            font-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("            font-size:14px;\r\n");
      out.write("            outline: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            color: #ffffff;\r\n");
      out.write("            border: solid 1px #0076a3; border-right:0px;\r\n");
      out.write("            background: #0095cd;\r\n");
      out.write("            background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));\r\n");
      out.write("            background: -moz-linear-gradient(top,  #00adee,  #0078a5);\r\n");
      out.write("            border-top-left-radius: 5px 5px;\r\n");
      out.write("            border-bottom-left-radius: 5px 5px;\r\n");
      out.write("            border-top-right-radius: 5px 5px;\r\n");
      out.write("            border-bottom-right-radius: 5px 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .ebbutton:hover {\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            background: #007ead;\r\n");
      out.write("            background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));\r\n");
      out.write("            background: -moz-linear-gradient(top,  #0095cc,  #00678e);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .ebbutton::-moz-focus-inner {\r\n");
      out.write("            border: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .ebclear{\r\n");
      out.write("            clear:both;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h1 { \r\n");
      out.write("            alignment-adjust: central;\r\n");
      out.write("            margin: 0 auto; \r\n");
      out.write("            width: 500px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 { \r\n");
      out.write("            margin: 0 auto; \r\n");
      out.write("            width:270px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table { \r\n");
      out.write("\r\n");
      out.write("            margin: 0 auto; \r\n");
      out.write("            width:250px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        div { \r\n");
      out.write("            alignment-adjust: central;\r\n");
      out.write("            margin: 0 auto; \r\n");
      out.write("            width:690px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function deposit()\r\n");
      out.write("            {\r\n");
      out.write("                var deposit = prompt(\"Ingrese monto a depositar\", \"\");      \r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Easy Banking!</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <h1>Cliente ID: ");
      out.print(p.getId());
      out.write(" Nombre: ");
      out.print(p.getName());
      out.write("</h1>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <h2> Cuentas de ahorro</h2>\r\n");
      out.write("        <br>\r\n");
      out.write("        <table border=\"1\">\r\n");
      out.write("            <td align=\"center\">  # Cuenta  </td>\r\n");
      out.write("            <td align=\"center\">  Moneda  </td>\r\n");
      out.write("            <td align=\"center\">  Fecha Creacion  </td>\r\n");
      out.write("            <td align=\"center\">  Fecha Expiracion  </td>\r\n");
      out.write("            <td align=\"center\">  Monto  </td>\r\n");
      out.write("            ");


                ArrayList<BankAccount> personBankAccount = (ArrayList<BankAccount>) session.getAttribute("BANK_ACCOUNT");
                SimpleDateFormat sdf = new SimpleDateFormat("MM / yyyy");

                if (personBankAccount != null) {
                    for (BankAccount ba : personBankAccount) {
                        if (ba.getCurrency() != 4) {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td align=\"center\">");
      out.print(ba.getId());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(ba.currencyFormat(ba.getCurrency()));
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(sdf.format(ba.getRegisteredDate().getTime()));
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(sdf.format(ba.getExpirationDate().getTime()));
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(ba.getAmount());
      out.write("</td>\r\n");
      out.write("                <td style=\"border: 1\"><button type=\"summit\" class=\"ebbutton\" onclick=\"deposit()\">Deposito</button></td>\r\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Retiro</button></td>\r\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Transferencia</button></td>\r\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Historial</button></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            ");
 }
                }
      out.write("</table>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <h2>Cuentas de credito</h2>\r\n");
      out.write("        <br>\r\n");
      out.write("        <table border=\"1\">\r\n");
      out.write("            <td align=\"center\">  # Cuenta  </td>\r\n");
      out.write("            <td align=\"center\">  Moneda  </td>\r\n");
      out.write("            <td align=\"center\">  Fecha Creacion  </td>\r\n");
      out.write("            <td align=\"center\">  Fecha Expiracion  </td>\r\n");
      out.write("            <td align=\"center\">  Monto  </td>\r\n");
      out.write("            ");
 for (BankAccount ba : personBankAccount) {
                    if (ba.getCurrency() == 4) {
      out.write("\r\n");
      out.write("                   \r\n");
      out.write("            <tr>\r\n");
      out.write("                <td align=\"center\">");
      out.print(ba.getId());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(ba.currencyFormat(ba.getCurrency()));
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(sdf.format(ba.getRegisteredDate().getTime()));
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(sdf.format(ba.getExpirationDate().getTime()));
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(ba.getAmount());
      out.write("</td>\r\n");
      out.write("                <td style=\"border: 1\"><input type = \"button\" class=\"ebbutton\" value=\"Deposito\" onclick=\"changecolor()\"></td>\r\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Retiro</button></td>\r\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Transferencia</button></td>\r\n");
      out.write("                <td style=\"border: 1\"><button class=\"ebbutton\" onclick=\"myFunction()\">Historial</button></td>\r\n");
      out.write("            </tr>    \r\n");
      out.write("        </table>\r\n");
      out.write("        ");
 }

                    session.removeAttribute("BANK_ACCOUNT");
                }
            }
      out.write(" \r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div><a href=\"createaccount.jsp\"><button class=\"ebbutton\" value=\"createaccount\">Agregar cuenta</button></a></div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
