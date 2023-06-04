package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/izitoast/1.4.0/css/iziToast.min.css\"\n");
      out.write("          integrity=\"sha512-O03ntXoVqaGUTAeAmvQ2YSzkCvclZEcPQu1eqloPaHfJ5RuNGiS4l+3duaidD801P50J28EHyonCV06CUlTSag==\"\n");
      out.write("          crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css\"\n");
      out.write("          integrity=\"sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==\"\n");
      out.write("          crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("    <!-- CSS only -->\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("          integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/loginUser.css\">\n");
      out.write("\n");
      out.write("    <body style=\"background-image: url(./img/pexels-andreea-ch-1166644.jpg);\">\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <form action=\"MainController\" method=\"POST\" id=\"f1\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-4 col-md-2\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-4 cuscol col-md-8\">\n");
      out.write("                            <div class=\"frameOver\">\n");
      out.write("                                <div class=\"frameOver_x\">\n");
      out.write("                                    <div class=\"frameOver_welcome\">\n");
      out.write("                                        <h4 style=\"text-shadow: 1px 2px #c5c2c2;\">Welcome To Store</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"signUp\">\n");
      out.write("                                        <div class=\"groupSignup\">\n");
      out.write("                                            <div class=\"signContent\">\n");
      out.write("                                                <a href=\"signUp.jsp\">Sign Up</a> or\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"signGoogle\">\n");
      out.write("                                                login with   <a  href=\"https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8084/UserManagerment_T4S2_JSP_JSTL/LoginGoogleHandle&response_type=code\n");
      out.write("                                                                 &client_id=655491711476-3k8fgr816q3s6k4arlmfc9436bebcr5l.apps.googleusercontent.com&approval_prompt=force\"> Google</a>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"groupInput\">\n");
      out.write("                                        <div class=\"titleInput\">\n");
      out.write("                                            Username <b style=\"color: red;\">*</b>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"typeInput\">\n");
      out.write("                                            <input class=\"typeInput__content\" type=\"text\" placeholder=\"Username\" name=\"userID\" required>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"objectError\">\n");
      out.write("                                            <p class=\"cusError\"></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"groupInput\">\n");
      out.write("                                        <div class=\"titleInput\">\n");
      out.write("                                            Password <b style=\"color: red;\">*</b>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"typeInput\">\n");
      out.write("                                            <input class=\"typeInput__content\" type=\"password\" placeholder=\"Password\" name=\"password\" required>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"objectError\">\n");
      out.write("                                            <p class=\"cusError\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ERROR}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <br/>\n");
      out.write("                                    <div class=\"groupInput1\">\n");
      out.write("                                        <div class=\"g-recaptcha cusCapcha\" data-sitekey=\"6LfbaAolAAAAAMbxj9dJkIyNgi_19VPHpD0A5w88\"></div>  \n");
      out.write("                                        <div class=\"objectError1\">\n");
      out.write("                                            <p id=\"errorCap\" class=\"cusError\"></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"buttonSubmit\">\n");
      out.write("                                        <input  name=\"action\" value=\"Login\" hidden/>\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-dark cusButton\" name=\"action\" value=\"Login\">Sign In</button>\n");
      out.write("                                    </div>\n");
      out.write("                                    <br/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-4 col-md-2\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>\n");
      out.write("        <script>\n");
      out.write("            window.onload = function () {\n");
      out.write("                let isValid = false;\n");
      out.write("                const form = document.getElementById(\"f1\");\n");
      out.write("                const error = document.getElementById(\"errorCap\");\n");
      out.write("\n");
      out.write("                form.addEventListener(\"submit\", function (event) {\n");
      out.write("                    event.preventDefault();\n");
      out.write("                    const response = grecaptcha.getResponse();\n");
      out.write("                    if (response) {\n");
      out.write("                        form.submit();\n");
      out.write("                    } else {\n");
      out.write("                        error.innerHTML = \"Please check\";\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/md5.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/js/all.min.js\"\n");
      out.write("                integrity=\"sha512-naukR7I+Nk6gp7p5TMA4ycgfxaZBJ7MO5iC3Fp6ySQyKFHOGfpkSZkYVWV5R7u7cfAicxanwYQ5D1e17EfJcMA==\"\n");
      out.write("        crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("        <!-- JavaScript Bundle with Popper -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("                integrity=\"sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/izitoast/1.4.0/js/iziToast.min.js\"\n");
      out.write("                integrity=\"sha512-Zq9o+E00xhhR/7vJ49mxFNJ0KQw1E1TMWkPTxrWcnpfEFDEXgUiwJHIKit93EW/XxE31HSI5GEOW06G6BF1AtA==\"\n");
      out.write("        crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
