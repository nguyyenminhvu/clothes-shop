<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ashion Template">
        <meta name="keywords" content="Ashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Home</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Css Styles -->
        <link rel="stylesheet" href="css/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/css/style.css" type="text/css">
        <link rel="stylesheet" href="css/menuDropdowns.css" type="text/css">
    </head>

    <body>

        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Offcanvas Menu Begin -->
        <div class="offcanvas-menu-overlay"></div>
        <div class="offcanvas-menu-wrapper">
            <div class="offcanvas__close">+</div>
            <ul class="offcanvas__widget">
                <li><span class="icon_search search-switch"></span></li>
                <li><a href="#"><span class="icon_heart_alt"></span>
                        <div class="tip">2</div>
                    </a></li>
                <li><a href="#"><span class="icon_bag_alt"></span>
                        <div class="tip">2</div>
                    </a></li>
            </ul>
            <div  class="offcanvas__logo">
                <a href="./index.html"><img src="img/img/logo.png" alt=""></a>
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="offcanvas__auth">
                <a href="MainController?action=Login">Login</a>
                <a href="#">Register</a>
            </div>
        </div>
        <!-- Offcanvas Menu End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-3 col-lg-2">
                        <div style="display: flex;justify-content: center" class="header__logo">
                            <a href="./index.html"><img src="img/img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-7">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="LoadPage">Home</a></li>
                                <li><a href="MainController?action=LoadShop&idCate=2">Women</a></li>
                                <li><a href="MainController?action=LoadShop&idCate=1">Men</a></li>
                                <li><a href="MainController?action=LoadShop">Shop</a></li>
                                <li><a href="MainController?action=LoadShop&idCate=4">Unisex</a></li>
                                <li><a href="./contact.html">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__right">
                            <div class="header__right__auth">
                                <c:choose>
                                    <c:when test="${sessionScope.ACC != null && sessionScope.ACC.role eq 'USER' }">
                                        <nav>
                                            <menu>
                                                <menuitem id="demo1">
                                                <a id="mainDrop"><div style="width: 70px;border-radius: 20px ; overflow: hidden" >   <i style="font-size:150%" class="fa-solid fa-circle-user"></i> </div></a>
                                                <menu>
                                                    <br>
                                                    <menuitem><a style="text-decoration: none;" href="LoadInformationUserController?username=${sessionScope.ACC.username}&uriBack=LoadPage" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-user"></i>${sessionScope.ACC.name}</a></menuitem>
                                                    <menuitem><a style="text-decoration: none;" href="LoadInformationUserController?username=${sessionScope.ACC.username}&uriBack=LoadPage&key=UpdatePassword" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-key"></i>Change Password</a></menuitem>
                                                    <menuitem><a style="text-decoration: none;" href="MainController?action=Logout" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-right-to-bracket"></i>Log Out</a></menuitem>
                                                </menu>
                                                </menuitem>
                                            </menu>
                                        </nav>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="hvLogin" href="Login.html">Login</a>
                                        <a class="hvRegister" href="SignUp.jsp">Register</a>
                                    </c:otherwise>
                                </c:choose>  
                            </div>
                            <style>
                                .hvRegister:hover,
                                .hvLogin:hover{
                                    opacity: 0.8;
                                    color: #CCC;
                                    transition: 0.2s;

                                }
                            </style>
                            <ul class="header__right__widget">
                                <c:choose>
                                    <c:when test="${sessionScope.ACC != null && sessionScope.ACC.role eq 'USER' }">
                                        <li><a href="MainController?action=DetailCart"><span><i class="fa-solid fa-cart-shopping"></i></span>
                                                <div class="tip">${requestScope.sizeCart}</div>
                                            </a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="Login.html"><span><i class="fa-solid fa-cart-shopping"></i></span>
                                                <div class="tip">${requestScope.sizeCart}</div>
                                            </a></li>
                                        </c:otherwise>
                                    </c:choose>

                                <li><div style="width: 60px"></div></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="canvas__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->

        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 p-0">
                        <div class="categories__item categories__large__item set-bg"
                             data-setbg="img/img/categories/category-1.jpg">
                            <div class="categories__text">
                                <h1>Women fashion</h1>
                                <p>Sitamet, consectetur adipiscing elit, sed do eiusmod tempor incidid-unt labore
                                    edolore magna aliquapendisse ultrices gravida.</p>
                                <a href="#">Shop now</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="img/img/categories/category-2.jpg">
                                    <div class="categories__text">
                                        <h4>Men fashion</h4>
                                        <p>358 items</p>
                                        <a href="#">Shop now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="img/img/categories/category-3.jpg">
                                    <div class="categories__text">
                                        <h4>Kid fashion</h4>
                                        <p>273 items</p>
                                        <a href="#">Shop now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="img/img/categories/category-4.jpg">
                                    <div class="categories__text">
                                        <h4>Unisex</h4>
                                        <p>159 items</p>
                                        <a href="#">Shop now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="img/img/categories/category-5.jpg">
                                    <div class="categories__text">
                                        <h4>Accessories</h4>
                                        <p>792 items</p>
                                        <a href="#">Shop now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <div class="section-title">
                            <h4>New product</h4>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-8">
                        <ul class="filter__controls">
                            <li class="active" data-filter="*">All</li>
                            <!--                            <li data-filter=".men">Men?s</li>
                                                        <li data-filter=".kid">Kid?s</li>
                                                        <li data-filter=".accessories">Accessories</li>
                                                        <li data-filter=".cosmetic">Cosmetics</li>-->
                        </ul>
                    </div>
                </div>
                <div class="row property__gallery">
                    <c:forEach items="${requestScope.listProduct}" var="p">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix women">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="${p.img}">
                                    <ul class="product__hover">
                                        <c:choose>
                                            <c:when test="${sessionScope.ACC != null && sessionScope.ACC.role eq 'USER' }">
                                                <li><a href="MainController?action=AddToCart&id=${p.id}&quantity=1&uri=LoadPage"><span ><i class="fa-solid fa-cart-shopping"></i></span></a></li>
                                                        </c:when>
                                                        <c:otherwise>
                                                <li><a href="Login.html"><span ><i class="fa-solid fa-cart-shopping"></i></span></a></li>
                                                        </c:otherwise>
                                                    </c:choose>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="MainController?action=DetailProduct&id=${p.id}">${p.name}</a></h6>
                                    <div class="rating">

                                    </div>
                                    <div class="product__price">$ ${p.price}</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach> 
                </div>
                <br/>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="product__pagination">
                            <c:forEach begin="${1}" end="${requestScope.sizePaging}" var="i" >
                                <a style="padding: 10px 15px 10px 15px;margin-left: 10px;border-radius: 20px;color: black;" class="${i==requestScope.page?"active":""}" href="LoadPage?page=${i}">${i}</a>
                            </c:forEach>
                            <style>
                                .product__pagination a.active{
                                    border: 1px solid black;
                                    padding: 0px 2px 0px 2px;
                                    margin-left: 10px;
                                    border-radius: 100;
                                    color: black;
                                }
                            </style>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

        <!-- Banner Section Begin -->

        <!-- Banner Section End -->

        <!-- Trend Section Begin -->
        <section class="trend spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
                                <h4>Cheaper</h4>
                            </div>
                            <c:forEach items="${requestScope.listCheaper}" var="cheap">
                                <div class="trend__item">
                                    <div class="trend__item__pic"  style="width: 90px;height: 95px;overflow: hidden">
                                        <img style="width: 90px" src="${cheap.img}" alt="">
                                    </div>
                                    <div class="trend__item__text">
                                        <h6>${cheap.name}</h6>
                                        <div class="rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product__price">$ ${cheap.price}</div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
                                <h4>Best seller</h4>
                            </div>
                            <c:forEach items="${listBestSaller}" var="sale">
                                <div class="trend__item">
                                    <div class="trend__item__pic" style="width: 90px;height: 95px;overflow: hidden">
                                        <img style="width: 90px"   src="${sale.img}" alt="">
                                    </div>
                                    <div class="trend__item__text">
                                        <h6>${sale.name}</h6>
                                        <div class="rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product__price">$ ${sale.price}</div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
                                <h4>New</h4>
                            </div>
                            <c:forEach items="${requestScope.listNew}" var="news">
                                <div class="trend__item">
                                    <div class="trend__item__pic" style="width: 90px;height: 95px;overflow: hidden">
                                        <img style="width: 90px"  src="${news.img}" alt="">
                                    </div>
                                    <div class="trend__item__text">
                                        <h6>${news.name}</h6>
                                        <div class="rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product__price">$ ${news.price}</div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Trend Section End -->

        <!-- Discount Section Begin -->

        <!-- Discount Section End -->

        <!-- Services Section Begin -->
        <section class="services spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-car"></i>
                            <h6>Free Shipping</h6>
                            <p>For all oder over $99</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-money"></i>
                            <h6>Money Back Guarantee</h6>
                            <p>If good have Problems</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-support"></i>
                            <h6>Online Support 24/7</h6>
                            <p>Dedicated support</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-headphones"></i>
                            <h6>Payment Secure</h6>
                            <p>100% secure payment</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services Section End -->

        <!-- Instagram Begin -->
        <div class="instagram">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/img/instagram/insta-1.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/img/instagram/insta-2.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/img/instagram/insta-3.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/img/instagram/insta-4.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/img/instagram/insta-5.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/img/instagram/insta-6.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Instagram End -->

        <!-- Footer Section Begin -->
        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-7">
                        <div class="footer__about">
                            <div class="footer__logo">
                                <a href="./index.html"><img src="img/img/logo.png" alt=""></a>
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                                cilisis.</p>
                            <div class="footer__payment">
                                <a href="#"><img src="img/img/payment/payment-1.png" alt=""></a>
                                <a href="#"><img src="img/img/payment/payment-2.png" alt=""></a>
                                <a href="#"><img src="img/img/payment/payment-3.png" alt=""></a>
                                <a href="#"><img src="img/img/payment/payment-4.png" alt=""></a>
                                <a href="#"><img src="img/img/payment/payment-5.png" alt=""></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-5">
                        <div class="footer__widget">
                            <h6>Quick links</h6>
                            <ul>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Blogs</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">FAQ</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-4">
                        <div class="footer__widget">
                            <h6>Account</h6>
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Orders Tracking</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Wishlist</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-8 col-sm-8">
                        <div class="footer__newslatter">
                            <h6>NEWSLETTER</h6>
                            <form action="#">
                                <input type="text" placeholder="Email">
                                <button type="submit" class="site-btn">Subscribe</button>
                            </form>
                            <div class="footer__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-youtube-play"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <div class="footer__copyright__text">
                            <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                        </div>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search End -->

        <!-- Js Plugins -->
        <script src="js/js/jquery-3.3.1.min.js"></script>
        <script src="js/js/bootstrap.min.js"></script>
        <script src="js/js/jquery.magnific-popup.min.js"></script>
        <script src="js/js/jquery-ui.min.js"></script>
        <script src="js/js/mixitup.min.js"></script>
        <script src="js/js/jquery.countdown.min.js"></script>
        <script src="js/js/jquery.slicknav.js"></script>
        <script src="js/js/owl.carousel.min.js"></script>
        <script src="js/js/jquery.nicescroll.min.js"></script>
        <script src="js/js/main.js"></script>
    </body>

</html>