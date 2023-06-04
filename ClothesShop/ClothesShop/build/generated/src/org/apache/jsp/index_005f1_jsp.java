package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
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
      out.write("        <meta name=\"description\" content=\"Ashion Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"Ashion, unica, creative, html\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Home</title>\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Cookie&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\"\n");
      out.write("              integrity=\"sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("        <!-- Css Styles -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/jquery-ui.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/magnific-popup.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/style.css\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- Page Preloder -->\n");
      out.write("        <div id=\"preloder\">\n");
      out.write("            <div class=\"loader\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Offcanvas Menu Begin -->\n");
      out.write("        <div class=\"offcanvas-menu-overlay\"></div>\n");
      out.write("        <div class=\"offcanvas-menu-wrapper\">\n");
      out.write("            <div class=\"offcanvas__close\">+</div>\n");
      out.write("            <ul class=\"offcanvas__widget\">\n");
      out.write("                <li><span class=\"icon_search search-switch\"></span></li>\n");
      out.write("                <li><a href=\"#\"><span class=\"icon_heart_alt\"></span>\n");
      out.write("                        <div class=\"tip\">2</div>\n");
      out.write("                    </a></li>\n");
      out.write("                <li><a href=\"#\"><span class=\"icon_bag_alt\"></span>\n");
      out.write("                        <div class=\"tip\">2</div>\n");
      out.write("                    </a></li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"offcanvas__logo\">\n");
      out.write("                <a href=\"./index.html\"><img src=\"img/img/logo.png\" alt=\"\"></a>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"mobile-menu-wrap\"></div>\n");
      out.write("            <div class=\"offcanvas__auth\">\n");
      out.write("                <a href=\"MainController?action=Login\">Login</a>\n");
      out.write("                <a href=\"#\">Register</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Offcanvas Menu End -->\n");
      out.write("\n");
      out.write("        <!-- Header Section Begin -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xl-3 col-lg-2\">\n");
      out.write("                        <div class=\"header__logo\">\n");
      out.write("                            <a href=\"./index.html\"><img src=\"img/img/logo.png\" alt=\"\"></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-6 col-lg-7\">\n");
      out.write("                        <nav class=\"header__menu\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"active\"><a href=\"LoadPage\">Home</a></li>\n");
      out.write("                                <li><a href=\"MainController?action=LoadShop&idCate=2\">Women</a></li>\n");
      out.write("                                <li><a href=\"MainController?action=LoadShop&idCate=1\">Men</a></li>\n");
      out.write("                                <li><a href=\"MainController?action=LoadShop\">Shop</a></li>\n");
      out.write("                                <li><a href=\"MainController?action=LoadShop&idCate=4\">Unisex</a></li>\n");
      out.write("                                <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"header__right\">\n");
      out.write("                            <div class=\"header__right__auth\">\n");
      out.write("                                <a href=\"Login.html\">Login</a>\n");
      out.write("                                <a href=\"#\">Register</a>\n");
      out.write("                            </div>\n");
      out.write("                            <ul class=\"header__right__widget\">\n");
      out.write("                                <li><a href=\"MainController?action=DetailCart\"><span><i class=\"fa-solid fa-cart-shopping\"></i></span>\n");
      out.write("                                        <div class=\"tip\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.sizeCart}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                    </a></li>\n");
      out.write("                                <li><div style=\"width: 60px\"></div></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"canvas__open\">\n");
      out.write("                    <i class=\"fa fa-bars\"></i>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- Header Section End -->\n");
      out.write("\n");
      out.write("        <!-- Categories Section Begin -->\n");
      out.write("        <section class=\"categories\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-6 p-0\">\n");
      out.write("                        <div class=\"categories__item categories__large__item set-bg\"\n");
      out.write("                             data-setbg=\"img/img/categories/category-1.jpg\">\n");
      out.write("                            <div class=\"categories__text\">\n");
      out.write("                                <h1>Women fashion</h1>\n");
      out.write("                                <p>Sitamet, consectetur adipiscing elit, sed do eiusmod tempor incidid-unt labore\n");
      out.write("                                    edolore magna aliquapendisse ultrices gravida.</p>\n");
      out.write("                                <a href=\"#\">Shop now</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-6 col-md-6 col-sm-6 p-0\">\n");
      out.write("                                <div class=\"categories__item set-bg\" data-setbg=\"img/img/categories/category-2.jpg\">\n");
      out.write("                                    <div class=\"categories__text\">\n");
      out.write("                                        <h4>Men fashion</h4>\n");
      out.write("                                        <p>358 items</p>\n");
      out.write("                                        <a href=\"#\">Shop now</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-6 col-md-6 col-sm-6 p-0\">\n");
      out.write("                                <div class=\"categories__item set-bg\" data-setbg=\"img/img/categories/category-3.jpg\">\n");
      out.write("                                    <div class=\"categories__text\">\n");
      out.write("                                        <h4>Kid fashion</h4>\n");
      out.write("                                        <p>273 items</p>\n");
      out.write("                                        <a href=\"#\">Shop now</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-6 col-md-6 col-sm-6 p-0\">\n");
      out.write("                                <div class=\"categories__item set-bg\" data-setbg=\"img/img/categories/category-4.jpg\">\n");
      out.write("                                    <div class=\"categories__text\">\n");
      out.write("                                        <h4>Unisex</h4>\n");
      out.write("                                        <p>159 items</p>\n");
      out.write("                                        <a href=\"#\">Shop now</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-6 col-md-6 col-sm-6 p-0\">\n");
      out.write("                                <div class=\"categories__item set-bg\" data-setbg=\"img/img/categories/category-5.jpg\">\n");
      out.write("                                    <div class=\"categories__text\">\n");
      out.write("                                        <h4>Accessories</h4>\n");
      out.write("                                        <p>792 items</p>\n");
      out.write("                                        <a href=\"#\">Shop now</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Categories Section End -->\n");
      out.write("\n");
      out.write("        <!-- Product Section Begin -->\n");
      out.write("        <section class=\"product spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4 col-md-4\">\n");
      out.write("                        <div class=\"section-title\">\n");
      out.write("                            <h4>New product</h4>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-8 col-md-8\">\n");
      out.write("                        <ul class=\"filter__controls\">\n");
      out.write("                            <li class=\"active\" data-filter=\"*\">All</li>\n");
      out.write("                            <!--                            <li data-filter=\".men\">Men?s</li>\n");
      out.write("                                                        <li data-filter=\".kid\">Kid?s</li>\n");
      out.write("                                                        <li data-filter=\".accessories\">Accessories</li>\n");
      out.write("                                                        <li data-filter=\".cosmetic\">Cosmetics</li>-->\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row property__gallery\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("                </div>\n");
      out.write("                <br/>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div class=\"product__pagination\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            <style>\n");
      out.write("                                .product__pagination a.active{\n");
      out.write("                                    border: 1px solid black;\n");
      out.write("                                    padding: 0px 2px 0px 2px;\n");
      out.write("                                    margin-left: 10px;\n");
      out.write("                                    border-radius: 100;\n");
      out.write("                                    color: black;\n");
      out.write("                                }\n");
      out.write("                            </style>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Product Section End -->\n");
      out.write("\n");
      out.write("        <!-- Banner Section Begin -->\n");
      out.write("\n");
      out.write("        <!-- Banner Section End -->\n");
      out.write("\n");
      out.write("        <!-- Trend Section Begin -->\n");
      out.write("        <section class=\"trend spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4 col-md-4 col-sm-6\">\n");
      out.write("                        <div class=\"trend__content\">\n");
      out.write("                            <div class=\"section-title\">\n");
      out.write("                                <h4>Cheaper</h4>\n");
      out.write("                            </div>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4 col-md-4 col-sm-6\">\n");
      out.write("                        <div class=\"trend__content\">\n");
      out.write("                            <div class=\"section-title\">\n");
      out.write("                                <h4>Best seller</h4>\n");
      out.write("                            </div>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4 col-md-4 col-sm-6\">\n");
      out.write("                        <div class=\"trend__content\">\n");
      out.write("                            <div class=\"section-title\">\n");
      out.write("                                <h4>New</h4>\n");
      out.write("                            </div>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Trend Section End -->\n");
      out.write("\n");
      out.write("        <!-- Discount Section Begin -->\n");
      out.write("\n");
      out.write("        <!-- Discount Section End -->\n");
      out.write("\n");
      out.write("        <!-- Services Section Begin -->\n");
      out.write("        <section class=\"services spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6\">\n");
      out.write("                        <div class=\"services__item\">\n");
      out.write("                            <i class=\"fa fa-car\"></i>\n");
      out.write("                            <h6>Free Shipping</h6>\n");
      out.write("                            <p>For all oder over $99</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6\">\n");
      out.write("                        <div class=\"services__item\">\n");
      out.write("                            <i class=\"fa fa-money\"></i>\n");
      out.write("                            <h6>Money Back Guarantee</h6>\n");
      out.write("                            <p>If good have Problems</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6\">\n");
      out.write("                        <div class=\"services__item\">\n");
      out.write("                            <i class=\"fa fa-support\"></i>\n");
      out.write("                            <h6>Online Support 24/7</h6>\n");
      out.write("                            <p>Dedicated support</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6\">\n");
      out.write("                        <div class=\"services__item\">\n");
      out.write("                            <i class=\"fa fa-headphones\"></i>\n");
      out.write("                            <h6>Payment Secure</h6>\n");
      out.write("                            <p>100% secure payment</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Services Section End -->\n");
      out.write("\n");
      out.write("        <!-- Instagram Begin -->\n");
      out.write("        <div class=\"instagram\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                        <div class=\"instagram__item set-bg\" data-setbg=\"img/img/instagram/insta-1.jpg\">\n");
      out.write("                            <div class=\"instagram__text\">\n");
      out.write("                                <i class=\"fa fa-instagram\"></i>\n");
      out.write("                                <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                        <div class=\"instagram__item set-bg\" data-setbg=\"img/img/instagram/insta-2.jpg\">\n");
      out.write("                            <div class=\"instagram__text\">\n");
      out.write("                                <i class=\"fa fa-instagram\"></i>\n");
      out.write("                                <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                        <div class=\"instagram__item set-bg\" data-setbg=\"img/img/instagram/insta-3.jpg\">\n");
      out.write("                            <div class=\"instagram__text\">\n");
      out.write("                                <i class=\"fa fa-instagram\"></i>\n");
      out.write("                                <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                        <div class=\"instagram__item set-bg\" data-setbg=\"img/img/instagram/insta-4.jpg\">\n");
      out.write("                            <div class=\"instagram__text\">\n");
      out.write("                                <i class=\"fa fa-instagram\"></i>\n");
      out.write("                                <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                        <div class=\"instagram__item set-bg\" data-setbg=\"img/img/instagram/insta-5.jpg\">\n");
      out.write("                            <div class=\"instagram__text\">\n");
      out.write("                                <i class=\"fa fa-instagram\"></i>\n");
      out.write("                                <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                        <div class=\"instagram__item set-bg\" data-setbg=\"img/img/instagram/insta-6.jpg\">\n");
      out.write("                            <div class=\"instagram__text\">\n");
      out.write("                                <i class=\"fa fa-instagram\"></i>\n");
      out.write("                                <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Instagram End -->\n");
      out.write("\n");
      out.write("        <!-- Footer Section Begin -->\n");
      out.write("        <footer class=\"footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4 col-md-6 col-sm-7\">\n");
      out.write("                        <div class=\"footer__about\">\n");
      out.write("                            <div class=\"footer__logo\">\n");
      out.write("                                <a href=\"./index.html\"><img src=\"img/img/logo.png\" alt=\"\"></a>\n");
      out.write("                            </div>\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt\n");
      out.write("                                cilisis.</p>\n");
      out.write("                            <div class=\"footer__payment\">\n");
      out.write("                                <a href=\"#\"><img src=\"img/img/payment/payment-1.png\" alt=\"\"></a>\n");
      out.write("                                <a href=\"#\"><img src=\"img/img/payment/payment-2.png\" alt=\"\"></a>\n");
      out.write("                                <a href=\"#\"><img src=\"img/img/payment/payment-3.png\" alt=\"\"></a>\n");
      out.write("                                <a href=\"#\"><img src=\"img/img/payment/payment-4.png\" alt=\"\"></a>\n");
      out.write("                                <a href=\"#\"><img src=\"img/img/payment/payment-5.png\" alt=\"\"></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-3 col-sm-5\">\n");
      out.write("                        <div class=\"footer__widget\">\n");
      out.write("                            <h6>Quick links</h6>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">About</a></li>\n");
      out.write("                                <li><a href=\"#\">Blogs</a></li>\n");
      out.write("                                <li><a href=\"#\">Contact</a></li>\n");
      out.write("                                <li><a href=\"#\">FAQ</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-3 col-sm-4\">\n");
      out.write("                        <div class=\"footer__widget\">\n");
      out.write("                            <h6>Account</h6>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">My Account</a></li>\n");
      out.write("                                <li><a href=\"#\">Orders Tracking</a></li>\n");
      out.write("                                <li><a href=\"#\">Checkout</a></li>\n");
      out.write("                                <li><a href=\"#\">Wishlist</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4 col-md-8 col-sm-8\">\n");
      out.write("                        <div class=\"footer__newslatter\">\n");
      out.write("                            <h6>NEWSLETTER</h6>\n");
      out.write("                            <form action=\"#\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Email\">\n");
      out.write("                                <button type=\"submit\" class=\"site-btn\">Subscribe</button>\n");
      out.write("                            </form>\n");
      out.write("                            <div class=\"footer__social\">\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-youtube-play\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                        <div class=\"footer__copyright__text\">\n");
      out.write("                            <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a></p>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
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
      out.write("        <script src=\"js/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"js/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("        <script src=\"js/js/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"js/js/mixitup.min.js\"></script>\n");
      out.write("        <script src=\"js/js/jquery.countdown.min.js\"></script>\n");
      out.write("        <script src=\"js/js/jquery.slicknav.js\"></script>\n");
      out.write("        <script src=\"js/js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/js/jquery.nicescroll.min.js\"></script>\n");
      out.write("        <script src=\"js/js/main.js\"></script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listProduct}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("p");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <div class=\"col-lg-3 col-md-4 col-sm-6 mix women\">\n");
          out.write("                            <div class=\"product__item\">\n");
          out.write("                                <div class=\"product__item__pic set-bg\" data-setbg=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.img}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <ul class=\"product__hover\">\n");
          out.write("                                        <li><a href=\"MainController?action=AddToCart&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&quantity=1&uri=LoadPage\"><span ><i class=\"fa-solid fa-cart-shopping\"></i></span></a></li>\n");
          out.write("                                    </ul>\n");
          out.write("                                </div>\n");
          out.write("                                <div class=\"product__item__text\">\n");
          out.write("                                    <h6><a href=\"MainController?action=DetailProduct&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h6>\n");
          out.write("                                    <div class=\"rating\">\n");
          out.write("\n");
          out.write("                                    </div>\n");
          out.write("                                    <div class=\"product__price\">$ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                </div>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setBegin(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${1}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_1.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.sizePaging}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_1.setVar("i");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <a style=\"padding: 10px 15px 10px 15px;margin-left: 10px;border-radius: 20px;color: black;\" class=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i==requestScope.page?\"active\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" href=\"LoadPage?page=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listCheaper}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("cheap");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <div class=\"trend__item\">\n");
          out.write("                                    <div class=\"trend__item__pic\"  style=\"width: 90px;height: 95px;overflow: hidden\">\n");
          out.write("                                        <img style=\"width: 90px\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cheap.img}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\n");
          out.write("                                    </div>\n");
          out.write("                                    <div class=\"trend__item__text\">\n");
          out.write("                                        <h6>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cheap.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\n");
          out.write("                                        <div class=\"rating\">\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                        </div>\n");
          out.write("                                        <div class=\"product__price\">$ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cheap.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                    </div>\n");
          out.write("                                </div>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listBestSaller}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_3.setVar("sale");
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <div class=\"trend__item\">\n");
          out.write("                                    <div class=\"trend__item__pic\" style=\"width: 90px;height: 95px;overflow: hidden\">\n");
          out.write("                                        <img style=\"width: 90px\"   src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sale.img}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\n");
          out.write("                                    </div>\n");
          out.write("                                    <div class=\"trend__item__text\">\n");
          out.write("                                        <h6>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sale.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\n");
          out.write("                                        <div class=\"rating\">\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                        </div>\n");
          out.write("                                        <div class=\"product__price\">$ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sale.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                    </div>\n");
          out.write("                                </div>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_4.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_4.setParent(null);
    _jspx_th_c_forEach_4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listNew}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_4.setVar("news");
    int[] _jspx_push_body_count_c_forEach_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_4 = _jspx_th_c_forEach_4.doStartTag();
      if (_jspx_eval_c_forEach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <div class=\"trend__item\">\n");
          out.write("                                    <div class=\"trend__item__pic\" style=\"width: 90px;height: 95px;overflow: hidden\">\n");
          out.write("                                        <img style=\"width: 90px\"  src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${news.img}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\n");
          out.write("                                    </div>\n");
          out.write("                                    <div class=\"trend__item__text\">\n");
          out.write("                                        <h6>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${news.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\n");
          out.write("                                        <div class=\"rating\">\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                            <i class=\"fa fa-star\"></i>\n");
          out.write("                                        </div>\n");
          out.write("                                        <div class=\"product__price\">$ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${news.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                    </div>\n");
          out.write("                                </div>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_4.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_4);
    }
    return false;
  }
}
