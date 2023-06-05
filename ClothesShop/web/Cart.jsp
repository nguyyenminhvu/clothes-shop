<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cart</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
              rel="stylesheet">
        <!-- Font-awesome-->
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
        <c:if test="${sessionScope.ACC eq null || sessionScope.ACC.role ne 'USER'}" >
            <c:redirect url="Login.html"></c:redirect>
        </c:if>
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
                        <div class="header__logo">
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
                        <div style="display: flex;justify-content:flex-start " class="header__right">
                            <div class="header__right__auth">
                                <c:choose>
                                    <c:when test="${sessionScope.ACC != null && sessionScope.ACC.role eq 'USER' }">
                                        <nav>
                                            <menu>
                                                <menuitem id="demo1">
                                                <a style="width: fit-content" id="mainDrop"><div style="width: 70px;border-radius: 20px ; overflow: hidden;width: fit-content" >   <i style="font-size:150%" class="fa-solid fa-circle-user"></i> </div></a>
                                                <menu>
                                                    <br>
                                                    <menuitem><a style="text-decoration: none;" href="LoadInformationUserController?username=${sessionScope.ACC.username}&uriBack=LoadDetailCartController" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-user"></i>${sessionScope.ACC.name}</a></menuitem>
                                                    <menuitem><a style="text-decoration: none;" href="LoadInformationUserController?username=${sessionScope.ACC.username}&uriBack=LoadDetailCartController&key=UpdatePassword" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-key"></i>Change Password</a></menuitem>
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
                                <li><a href="#"><span><i class="fa-solid fa-cart-shopping"></i></span>
                                        <div class="tip">${requestScope.sizeCart}</div>
                                    </a></li>
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
        <c:choose>
            <c:when test="${sessionScope.CART.getMapCart().size()>0}">
                <!-- Shopping Cart Section Begin -->
                <section class="shopping-cart spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="shopping__cart__table">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Product</th>
                                                <th>Quantity</th>
                                                <th>Total</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set value="${sessionScope.CART.getMapCart()}" var="cart"/>
                                            <c:forEach items="${cart.values()}" var="c">
                                                <tr>
                                                    <td class="product__cart__item">
                                                        <div class="product__cart__item__pic">
                                                            <div style="width: 140px;overflow: hidden;height:150px">
                                                                <img style="width: 140px  "  src="${c.img}" alt="">
                                                            </div>
                                                        </div>
                                                        <div class="product__cart__item__text">
                                                            <h6><a class="linkDetail" href="MainController?action=DetailProduct&id=${c.id}">${c.name}</a></h6>
                                                            <h5>$${c.price}</h5>
                                                        </div>
                                                    </td>
                                                    <td class="quantity__item">
                                                        <div class="quantity">
                                                            <div style="display: flex;width:90px ;justify-content: space-between ;">
                                                                <span><a href="MainController?action=ProcessCart&quantity=-1&id=${c.id}"><Button class="btnDownQuantity">-</Button></a></span>
                                                                <input readonly class="inputQuantity" type="text" value="${c.quantity}" min="1">
                                                                <span><a href="MainController?action=ProcessCart&quantity=1&id=${c.id}"><Button class="btnUpQuantity">+</Button></a></span>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td class="cart__price">$ ${c.quantity*c.price}</td>
                                                    <td  class="cart__close"><form action="MainController" method="POST">
                                                            <input name="action" value="ProcessCart" hidden/>
                                                            <input name="id" value="${c.id}" hidden/>
                                                            <button type="submit" class="closeBtn">x</button>
                                                        </form></td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                    <style>
                                        .linkDetail{
                                            color: black;
                                        }
                                        .linkDetail:hover{
                                            color: grey;
                                        }
                                        .closeBtn{
                                            border: none;
                                            background-color: #d9dadc;
                                            border-radius: 5px;
                                            font-weight: 600;
                                            padding: 5px;
                                        }
                                        .btnUpQuantity,
                                        .btnDownQuantity {
                                            background-color: white;
                                            border: none;
                                            font-weight: bold;
                                        }

                                        .inputQuantity {
                                            width: 30px;
                                            text-align: center;
                                            border: none;
                                        }
                                    </style>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="continue__btn">
                                            <a href="LoadPage">Continue Shopping</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="cart__total">
                                    <h6>Cart total</h6>
                                    <ul>
                                        <li>Total <span>$ ${requestScope.total}</span></li>
                                    </ul>
                                    <a href="CheckoutPageConfirm.jsp" class="primary-btn">Proceed to checkout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </c:when>
            <c:otherwise>
                <!--Empty cart-->               
                <section class="shopping-cart spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="shopping__cart__table">
                                    <table>
                                        <thead>

                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                </div>
                                <div class="row">
                                    <div style="text-align: center" class="col-lg-12 col-md-10 col-sm-12">
                                        <h2><b>Cart Empty</b></h2>
                                    </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="continue__btn">

                                            <a href="LoadPage">Continue Shopping</a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-4">
                            </div>
                        </div>
                    </div>
                </section>
            </c:otherwise>
        </c:choose>



        <!-- Shopping Cart Section End -->

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