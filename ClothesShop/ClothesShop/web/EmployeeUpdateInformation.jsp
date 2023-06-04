<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Users Management</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
              rel="stylesheet">
        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/menuDropdowns.css">
    </head>

    <body>
        <c:if test="${sessionScope.ACC eq null || sessionScope.ACC.role ne 'EMPLOYEE'}">
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
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-3">
                        <div class="header__logo">
                            <a href="UserManagementController"><img src="img/img/karim.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="#">Order</a>
                                    <ul class="dropdown">
                                        <li><a href="NewOrdersController">New Order</a></li>
                                        <li><a href="AllOrdersController">All Order</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Category</a>
                                    <ul class="dropdown">
                                        <li><a href="CreateCategory.jsp">Create Category</a></li>
                                        <li><a href="AllCategoryController">All Category</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Product</a>
                                    <ul class="dropdown">
                                        <li><a href="CreateProductController">Create Product</a></li>
                                        <li><a href="AllProductController">All Product</a></li>
                                    </ul>
                                </li>
                                <li class="active"><a href="UserManagementController">User List</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div  class="col-lg-3 col-md-3">
                        <div style="display: flex;justify-content: flex-end; text-align: left;" class="header__nav__option">
                            <nav>
                                <menu>
                                    <menuitem id="demo1">
                                    <a id="mainDrop"><div style="width: 70px;border-radius: 20px ; overflow: hidden" >   <i style="font-size:120% " class="fa-solid fa-circle-user"></i> </div></i></a>
                                    <menu>
                                        <br>
                                        <menuitem><a style="text-decoration: none;" href="MainController?action=Logout" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-user"></i>${sessionScope.ACC.name}</a></menuitem>
                                        <menuitem><a style="text-decoration: none;" href="MainController?action=Logout" id="mainDrop1"><i style="padding-right:  8px;" class="fa-solid fa-right-to-bracket"></i>Log Out</a></menuitem>
                                    </menu>
                                    </menuitem>
                                </menu>
                            </nav>
                        </div>

                    </div>
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>
        </header>
        <!-- Header Section End -->


        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-option">
            <div style="display: flex;justify-content: space-between" class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__text">
                            <h4>Hello ${sessionScope.ACC.name}, let' s manager User .</h4>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <div class="checkout__form">
                    <form action="MainController" method="POST">
                        <div class="row">
                            <div class="col-lg-2 col-md-3">

                            </div>
                            <div class="col-lg-8 col-md-6">
                                <h6 class="checkout__title">Update Information</h6>

                                <div class="checkout__input">
                                    <p>Username <span>*</span></p>
                                    <input type="text" name="username" value="${e.username}" disabled>
                                    <p style="font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px"><b></b></p>
                                </div>
                                <div class="checkout__input">
                                    <p>Name <span>*</span></p>
                                    <input type="text" name="name"  required  minlength="5" value="${e.name}">
                                    <p style="font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px"><b>${requestScope.updateError.fullNameError}</b></p>
                                </div>
                                <div class="checkout__input">
                                    <p>Password <span>*</span></p>
                                    <input type="password" name="password"  required>
                                    <p style="font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px"><b>${requestScope.updateError.passwordError}</b></p>
                                </div>
                                <div class="checkout__input">
                                    <p>New Password <span>*</span></p>
                                    <input type="password" name="newpassword"  required>
                                    <p style="font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px"><b>${requestScope.updateError.newPasswordError}</b></p>
                                </div>
                                <div class="checkout__input">
                                    <p>Re-New Password <span>*</span></p>
                                    <input type="password" name="renewpassword"  required>
                                    <p style="font-size: 80%; color: red; margin-top: -12px;padding-bottom: 15px"><b>${requestScope.updateError.rePasswordError}</b></p>
                                </div>
                                <br/>
                                <input type="text" name="username" value="${e.username}" hidden>
                                <input type="text" name="uriBack" value="${requestScope.uriBack}" hidden>
                                <button type="submit" class="btn btn-success">Save</button>
                                <a style="margin-left: 20px; width: 10px" href="UserManagementController"><input style="width: 80px" class="btn btn-secondary" value="Cancel" /></a>
                                <input name="action" value="UpdateEmployeeInformation" hidden>
                                <!-- code them row heree  -->

                            </div>
                            <div class="col-lg-2 col-md-3">

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>

        <!-- Checkout Section End -->

        <!-- Footer Section Begin -->

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