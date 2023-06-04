<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Shop</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
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
            <div class="offcanvas__option">
                <div class="offcanvas__links">
                    <a href="#">Sign in</a>
                    <a href="#">FAQs</a>
                </div>
                <div class="offcanvas__top__hover">
                    <span>Usd <i class="arrow_carrot-down"></i></span>
                    <ul>
                        <li>USD</li>
                        <li>EUR</li>
                        <li>USD</li>
                    </ul>
                </div>
            </div>
            <div class="offcanvas__nav__option">
                <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                <a href="#"><img src="img/icon/heart.png" alt=""></a>
                <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
                <div class="price">$0.00</div>
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="offcanvas__text">
                <p>Free shipping, 30-day return or refund guarantee.</p>
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
                                <li><a href="LoadPage   ">Home</a></li>
                                <li class="${requestScope.idCate==2?"active":""}"><a href="MainController?action=LoadShop&idCate=2">Women</a></li>
                                <li class="${requestScope.idCate==1?"active":""}"><a href="MainController?action=LoadShop&idCate=1">Men</a></li>
                                <li class="${requestScope.idCate==-1?"active":""}"><a href="MainController?action=LoadShop">Shop</a></li>
                                <li class="${requestScope.idCate==4?"active":""}"><a href="MainController?action=LoadShop&idCate=4">Unisex</a></li>
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
                <style>
                    .hvRegister:hover,
                    .hvLogin:hover{
                        opacity: 0.8;
                        color: #CCC;
                        transition: 0.2s;

                    }
                </style>
                <div class="canvas__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__text">
                            <h4>Shop</h4>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shop Section Begin -->
        <section class="shop spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="shop__sidebar">
                            <div class="shop__sidebar__search">
                                <form action="MainController">
                                    <input name="keySearch" type="text" placeholder="Search..." value="${requestScope.rsSearch}">
                                    <input name="action" type="text"value="LoadShop" hidden>
                                    <button type="submit"><span class="icon_search"></span></button>
                                </form>
                            </div>
                            <div class="shop__sidebar__accordion">
                                <div class="accordion" id="accordionExample">
                                    <div class="card">
                                        <div class="card-heading">
                                            <p style="font-size: 20px;font-weight: 600">Categories</p>
                                        </div>
                                        <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__categories">
                                                    <ul style="height: 180px" class="nice-scroll">
                                                        <li><a class="${requestScope.idCate==-1?"active":""}" style="font-size: 16px" href="MainController?action=LoadShop&idCate=-1">All</a></li>
                                                            <c:forEach items="${requestScope.listCate}" var="c" varStatus="loop"  >
                                                            <li><a class="${requestScope.idCate==(loop.index+1)?"active":""}" style="font-size: 16px" href="MainController?action=LoadShop&idCate=${c.id}">${c.name}</a></li>
                                                            </c:forEach>
                                                    </ul>
                                                </div>
                                                <style>
                                                    .shop__sidebar__categories a.active{
                                                        font-weight: 700;
                                                        color: black;
                                                    }
                                                </style>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <p style="font-size: 20px;font-weight: 600">Price</p>
                                        </div>
                                        <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__price">
                                                    <ul>
                                                        <li><a class="${requestScope.priceNum==-1?"active":""}" style="font-size: 16px" href="MainController?action=LoadShop&priceNum=-1">All</a></li>
                                                        <li><a class="${requestScope.priceNum==1?"active":""}" href="MainController?action=LoadShop&priceNum=1">$0.00 - $100.00</a></li>
                                                        <li><a class="${requestScope.priceNum==2?"active":""}" href="MainController?action=LoadShop&priceNum=2">$100.00 - $200.00</a></li>
                                                        <li><a class="${requestScope.priceNum==3?"active":""}" href="MainController?action=LoadShop&priceNum=3">$200.00 - $250.00</a></li>
                                                        <li><a class="${requestScope.priceNum==4?"active":""}" href="MainController?action=LoadShop&priceNum=4">$250.00 - $400.00</a></li>
                                                        <li><a class="${requestScope.priceNum==5?"active":""}" href="MainController?action=LoadShop&priceNum=5">$400.00 - $450.00</a></li>
                                                        <li><a class="${requestScope.priceNum==6?"active":""}" href="MainController?action=LoadShop&priceNum=6">$450.00+</a></li>
                                                    </ul>
                                                </div>
                                                <style>
                                                    .shop__sidebar__price a.active{
                                                        font-weight: 700;
                                                        color: black;
                                                    }
                                                </style>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <p style="font-size: 20px;font-weight: 600">Keyword</p>
                                        </div>
                                        <div id="collapseSix" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__tags">
                                                    <a href="MainController?action=LoadShop&keyword=Blazer">Blazer</a>
                                                    <a href="MainController?action=LoadShop&keyword=Kimono">Kimono</a>
                                                    <a href="MainController?action=LoadShop&keyword=Shirt">Shirt</a>
                                                    <a href="MainController?action=LoadShop&keyword=Cotton">Cotton</a>
                                                    <a href="MainController?action=LoadShop&keyword=Nike">Nike</a>
                                                    <a href="MainController?action=LoadShop&keyword=Slim">Slim</a>
                                                    <a href="MainController?action=LoadShop&keyword=Kid">Kid</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="shop__product__option">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__left">
                                        <p style="font-size: 17px"><b>${requestScope.nameShow}</b></p>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__right" >
                                        <p>Sort by Price:</p>
                                        <form id="f" action="MainController">
                                            <input name="action" value="LoadShop" hidden/>
                                            <input name="idCate" value="${requestScope.idCate}" hidden/>
                                            <input name="numPrie" value="${requestScope.numPrie}" hidden/>
                                            <input name="keyword" value="${requestScope.keyword}" hidden/>
                                            <input name="page" value="${requestScope.page}" hidden/>
                                            <select onchange="sortFunc()" name="sortNum" style="margin-top: 5px">
                                                <option  value="1">Low To High</option>
                                                <option  value="2">High To Low</option>
                                            </select>
                                        </form>
                                        <script>
                                            function sortFunc() {
                                                document.getElementById('f').submit();
                                            }
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${requestScope.listProduct}" var="p">
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="${p.img}">
                                        </div>
                                        <div class="product__item__text">
                                            <c:choose>
                                                <c:when test="${sessionScope.ACC != null && sessionScope.ACC.role eq 'USER' }">
                                                    <a href="MainController?action=AddToCart&id=${p.id}&quantity=1&uri=LoadShopController" class="add-cart">+ Add To Cart</a>                                                        </c:when>
                                                <c:otherwise>
                                                    <a href="Login.html" class="add-cart">+ Add To Cart</a>                                                        </c:otherwise>
                                            </c:choose>
                                            <h6>${p.name}</h6>

                                            <div class="rating">
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                            </div>
                                            <h5>$ ${p.price}</h5>
                                            <div class="product__color__select">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="product__pagination">
                                    <c:forEach begin="${1}" end="${requestScope.sizePaging}" var="i" >
                                        <a class="${i==requestScope.page?"active":""}" href="MainController?action=LoadShop&page=${i}&idCate=${requestScope.idCate}&priceNum=${requestScope.priceNum}&keyword=${requestScope.keyword}">${i}</a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Section End -->

        <!-- Footer Section Begin -->
        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__logo">
                                <a href="#"><img src="img/footer-logo.png" alt=""></a>
                            </div>
                            <p>The customer is at the heart of our unique business model, which includes design.</p>
                            <a href="#"><img src="img/payment.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                        <div class="footer__widget">
                            <h6>Shopping</h6>
                            <ul>
                                <li><a href="#">Clothing Store</a></li>
                                <li><a href="#">Trending Shoes</a></li>
                                <li><a href="#">Accessories</a></li>
                                <li><a href="#">Sale</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-6">
                        <div class="footer__widget">
                            <h6>Shopping</h6>
                            <ul>
                                <li><a href="#">Contact Us</a></li>
                                <li><a href="#">Payment Methods</a></li>
                                <li><a href="#">Delivary</a></li>
                                <li><a href="#">Return & Exchanges</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                        <div class="footer__widget">
                            <h6>NewLetter</h6>
                            <div class="footer__newslatter">
                                <p>Be the first to know about new arrivals, look books, sales & promos!</p>
                                <form action="#">
                                    <input type="text" placeholder="Your email">
                                    <button type="submit"><span class="icon_mail_alt"></span></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="footer__copyright__text">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            <p>Copyright ©
                                <script>
                                    document.write(new Date().getFullYear());
                                </script>2020
                                All rights reserved | This template is made with <i class="fa fa-heart-o"
                                                                                    aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            </p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </div>
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
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>