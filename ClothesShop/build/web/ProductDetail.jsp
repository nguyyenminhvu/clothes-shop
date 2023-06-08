<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ashion Template">
        <meta name="keywords" content="Ashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ashion Fashion</title>

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
            <div class="offcanvas__logo">
                <a href="./index.html"><img src="img/img/logo.png" alt=""></a>
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="offcanvas__auth">
                <a href="#">Login</a>
                <a href="#">Register</a>
            </div>
        </div>
        <!-- Offcanvas Menu End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-3 col-lg-2">
                        <div class="header__logo">
                            <a href="./index.html"><img src="img/img/karim.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-7">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="LoadPage   ">Home</a></li>
                                <li class="${requestScope.idCate==2?"active":""}"><a href="MainController?action=LoadShop&idCate=2">Women</a></li>
                                <li class="${requestScope.idCate==1?"active":""}"><a href="MainController?action=LoadShop&idCate=1">Men</a></li>
                                <li class="${requestScope.idCate==-1?"active":""}"><a href="MainController?action=LoadShop">Shop</a></li>
                                <li class="${requestScope.idCate==4?"active":""}"><a href="MainController?action=LoadShop&idCate=4">Unisex</a></li>
                                <li><a href="https://github.com/nguyyenminhvu">Contact</a></li>
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
                                                    <menuitem><a style="text-decoration: none;" href="MainController?action=Logout" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-user"></i>${sessionScope.ACC.name}</a></menuitem>
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
                            <ul class="header__right__widget">
                                <li><a href="MainController?action=DetailCart"><span><i class="fa-solid fa-cart-shopping"></i></span>
                                        <div class="tip">${requestScope.sizeCart}</div>
                                    </a></li>
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

        <!-- Breadcrumb Begin -->

        <!-- Breadcrumb End -->

        <!-- Product Details Section Begin -->
        <section class="product-details spad">
            <c:set value="${requestScope.product}" var="p"/>
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="product__details__pic" style=" height: 580px;width: 100%;overflow: hidden;  ">
                            <img style="width: 80%; text-align: center" src="${p.img}" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="product__details__text">
                            <h3>Essential structured blazer <span>Brand: ${p.category.name}</span></h3>
                            <div class="rating">

                            </div>
                            <div class="product__details__price">$ ${p.price}</div>
                            <p>${p.description}</p>
                            <div class="product__details__button">
                                <form id="f" action="MainController">
                                    <div class="quantity" style="display: flex;">
                                        <span>Quantity:</span>
                                        <div style="width: 100px; display: flex;justify-content: center;" >
                                            <input id="inputNek" name="quantity"   style="width: 80px;text-align: center; height: 50px;border: 1px solid rgb(192, 193, 199); border-radius:15px ;" type="number" min="1" value="1" >
                                            <input name="id" value="${p.id}" hidden/>
                                            <input name="action" value="AddToCart" hidden/>
                                            <input name="uri" value="MainController?action=DetailProduct&id=${p.id}" hidden/>
                                        </div>
                                    </div>
                                    <button style="border:none" onclick="confirmQuantity('${p.id}')" class="cart-btn" type="submit">
                                        Add to cart
                                    </button>
                                </form>
                            </div>
                            <script>
                                var input = document.getElementById('inputNek');
                                input.addEventListener("change", function () {
                                    if (input.value <= 0) {
                                        input.value = 1;
                                    }
                                })
                            </script>
                            <div class="product__details__widget">
                                <ul>
                                    <li>
                                        <span>Availability:</span>
                                        <div class="stock__checkbox">
                                            <label style="margin-left:-20px">
                                                In Stock
                                            </label>
                                        </div>
                                    </li>

                                    <li>
                                        <span>Promotions:</span>
                                        <p>Free shipping</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <h6>Description</h6>
                                    <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                        quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                        Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                        voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                        consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                        consequat massa quis enim.</p>
                                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                        dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                        nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                        quis, sem.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="related__title">
                            <h5>BEST SALER PRODUCTS</h5>
                        </div>
                    </div>
                    <c:forEach items="${requestScope.top4}" var="t4">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="${t4.img}">
                                    <ul class="product__hover">
                                        <li><a href="#"><span ><i class="fa-solid fa-cart-shopping"></i></span></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="MainController?action=DetailProduct&id=${t4.id}">${t4.name}</a></h6>
                                    <div class="rating">

                                    </div>
                                    <div class="product__price">$ ${t4.price}</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Product Details Section End -->

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