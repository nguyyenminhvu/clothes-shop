package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserManagement_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_redirect_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_redirect_url_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"description\" content=\"Male_Fashion Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"Male_Fashion, unica, creative, html\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Users Management</title>\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("        <!-- FontAwesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\"\n");
      out.write("              integrity=\"sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==\"\n");
      out.write("              crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("        <!-- Css Styles -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/nice-select.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/menuDropdowns.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <!-- Page Preloder -->\n");
      out.write("        <div id=\"preloder\">\n");
      out.write("            <div class=\"loader\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Offcanvas Menu Begin -->\n");
      out.write("        <div class=\"offcanvas-menu-overlay\"></div>\n");
      out.write("        <div class=\"offcanvas-menu-wrapper\">\n");
      out.write("            <div class=\"offcanvas__option\">\n");
      out.write("                <div class=\"offcanvas__links\">\n");
      out.write("                    <a href=\"#\">Sign in</a>\n");
      out.write("                    <a href=\"#\">FAQs</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"offcanvas__top__hover\">\n");
      out.write("                    <span>Usd <i class=\"arrow_carrot-down\"></i></span>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>USD</li>\n");
      out.write("                        <li>EUR</li>\n");
      out.write("                        <li>USD</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"offcanvas__nav__option\">\n");
      out.write("                <a href=\"#\" class=\"search-switch\"><img src=\"img/icon/search.png\" alt=\"\"></a>\n");
      out.write("                <a href=\"#\"><img src=\"img/icon/heart.png\" alt=\"\"></a>\n");
      out.write("                <a href=\"#\"><img src=\"img/icon/cart.png\" alt=\"\"> <span>0</span></a>\n");
      out.write("                <div class=\"price\">$0.00</div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"mobile-menu-wrap\"></div>\n");
      out.write("            <div class=\"offcanvas__text\">\n");
      out.write("                <p>Free shipping, 30-day return or refund guarantee.</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Offcanvas Menu End -->\n");
      out.write("\n");
      out.write("        <!-- Header Section Begin -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3 col-md-3\">\n");
      out.write("                        <div class=\"header__logo\">\n");
      out.write("                            <a href=\"UserManagementController\"><img src=\"img/img/karim.png\" alt=\"\"></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6 col-md-6\">\n");
      out.write("                        <nav class=\"header__menu mobile-menu\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">Order</a>\n");
      out.write("                                    <ul class=\"dropdown\">\n");
      out.write("                                        <li><a href=\"NewOrdersController\">New Order</a></li>\n");
      out.write("                                        <li><a href=\"AllOrdersController\">All Order</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\">Category</a>\n");
      out.write("                                    <ul class=\"dropdown\">\n");
      out.write("                                        <li><a href=\"CreateCategory.jsp\">Create Category</a></li>\n");
      out.write("                                        <li><a href=\"AllCategoryController\">All Category</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\">Product</a>\n");
      out.write("                                    <ul class=\"dropdown\">\n");
      out.write("                                        <li><a href=\"CreateProductController\">Create Product</a></li>\n");
      out.write("                                        <li><a href=\"AllProductController\">All Product</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"active\"><a href=\"UserManagementController\">User List</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                    <div  class=\"col-lg-3 col-md-3\">\n");
      out.write("                        <div style=\"display: flex;justify-content: flex-end; text-align: left;\" class=\"header__nav__option\">\n");
      out.write("                            <nav>\n");
      out.write("                                <menu>\n");
      out.write("                                    <menuitem id=\"demo1\">\n");
      out.write("                                    <a id=\"mainDrop\"><div style=\"width: 70px;border-radius: 20px ; overflow: hidden\" >   <i style=\"font-size:120% \" class=\"fa-solid fa-circle-user\"></i> </div></i></a>\n");
      out.write("                                    <menu>\n");
      out.write("                                        <br>\n");
      out.write("                                        <menuitem><a style=\"text-decoration: none;\" href=\"MainController?action=Logout\" id=\"mainDrop1\"><i style=\"padding-right:  8px;\" class=\"fa-solid fa-user\"></i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.ACC.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></menuitem>\n");
      out.write("                                        <menuitem><a style=\"text-decoration: none;\" href=\"MainController?action=Logout\" id=\"mainDrop1\"><i style=\"padding-right:  8px;\" class=\"fa-solid fa-right-to-bracket\"></i>Log Out</a></menuitem>\n");
      out.write("                                    </menu>\n");
      out.write("                                    </menuitem>\n");
      out.write("                                </menu>\n");
      out.write("                            </nav>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"canvas__open\"><i class=\"fa fa-bars\"></i></div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- Header Section End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Breadcrumb Section Begin -->\n");
      out.write("        <section class=\"breadcrumb-option\">\n");
      out.write("            <div style=\"display: flex;justify-content: space-between\" class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div class=\"breadcrumb__text\">\n");
      out.write("                            <h4>Hello ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.ACC.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(", let' s manager User .</h4>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Breadcrumb Section End -->\n");
      out.write("\n");
      out.write("        <!-- Checkout Section Begin -->\n");
      out.write("        <section class=\"checkout spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"checkout__form\">\n");
      out.write("                    <form action=\"MainController\" method=\"POST\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-2 col-md-3\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-8 col-md-6\">\n");
      out.write("                                <h6 class=\"checkout__title\">Update Information</h6>\n");
      out.write("\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Username <span>*</span></p>\n");
      out.write("                                    <input type=\"text\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" disabled>\n");
      out.write("                                    <p style=\"font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px\"><b></b></p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Name <span>*</span></p>\n");
      out.write("                                    <input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required  minlength=\"5\">\n");
      out.write("                                    <p style=\"font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px\"><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.updateError.nameError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Phone <span>*</span></p>\n");
      out.write("                                    <input type=\"text\" name=\"phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required  minlength=\"10\">\n");
      out.write("                                    <p style=\"font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px\"><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.updateError.phoneError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Address <span>*</span></p>\n");
      out.write("                                    <input type=\"text\" name=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required minlength=\"5\">\n");
      out.write("                                    <p style=\"font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px\"><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.updateError.addressError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Password <span>*</span></p>\n");
      out.write("                                    <input type=\"password\" name=\"password\"  required>\n");
      out.write("                                    <p style=\"font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px\"><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.updateError.passwordError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></p>\n");
      out.write("                                </div>\n");
      out.write("                                <br/>\n");
      out.write("                                <input type=\"text\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" hidden>\n");
      out.write("                                <input type=\"text\" name=\"uriBack\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.uriBack}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" hidden>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success\">Save</button>\n");
      out.write("                                <a style=\"margin-left: 20px; width: 10px\" href=\"LoadPage\"><input style=\"width: 80px\" class=\"btn btn-secondary\" value=\"Cancel\" /></a>\n");
      out.write("                                <input name=\"action\" value=\"UpdateInformationUser\" hidden>\n");
      out.write("                                <!-- code them row heree  -->\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-2 col-md-3\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Checkout Section End -->\n");
      out.write("\n");
      out.write("        <!-- Footer Section Begin -->\n");
      out.write("\n");
      out.write("        <!-- Footer Section End -->\n");
      out.write("\n");
      out.write("        <!-- Search Begin -->\n");
      out.write("        <div class=\"search-model\">\n");
      out.write("            <div class=\"h-100 d-flex align-items-center justify-content-center\">\n");
      out.write("                <div class=\"search-close-switch\">+</div>\n");
      out.write("                <form class=\"search-model-form\">\n");
      out.write("                    <input type=\"text\" id=\"search-input\" placeholder=\"Search here.....\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Search End -->\n");
      out.write("\n");
      out.write("        <!-- Js Plugins -->\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.nice-select.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.nicescroll.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.countdown.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.slicknav.js\"></script>\n");
      out.write("        <script src=\"js/mixitup.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.ACC eq null || sessionScope.ACC.role ne 'EMPLOYEE'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_redirect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_redirect_0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _jspx_tagPool_c_redirect_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_c_redirect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_redirect_0.setUrl("Login.html");
    int _jspx_eval_c_redirect_0 = _jspx_th_c_redirect_0.doStartTag();
    if (_jspx_th_c_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
      return true;
    }
    _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
    return false;
  }
}
