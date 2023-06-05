<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>New Orders</title>

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
                                <li class="active"><a href="#">Order</a>
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
                                <li><a href="UserManagementController">User List</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3 col-md-3">
                        <div style="display: flex;justify-content: flex-end; text-align: left;"
                             class="header__nav__option">
                            <nav>
                                <menu>
                                    <menuitem id="demo1">
                                    <a id="mainDrop">
                                        <div style="width: 70px;border-radius: 20px ; overflow: hidden"> <i
                                                style="font-size:120% " class="fa-solid fa-circle-user"></i> </div></i>
                                    </a>
                                    <menu>
                                        <br>
                                        <menuitem><a style="text-decoration: none;" href="MainController?action=UpdateEmployeeInformation&username=${sessionScope.ACC.username}"
                                                     id="mainDrop1"><i style="padding-right:  8px;"
                                                          class="fa-solid fa-user"></i>${sessionScope.ACC.name}</a></menuitem>
                                        <menuitem><a style="text-decoration: none;" href="MainController?action=Logout"
                                                     id="mainDrop1"><i style="padding-right:  8px;"
                                                          class="fa-solid fa-right-to-bracket"></i>Log Out</a></menuitem>
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
                            <h4>Hello ${sessionScope.ACC.name}, new orders waiting you.</h4>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container-fluid">
                <div class="checkout__form">
                    <div class="row">
                        <div class="col-lg-2 col-md-3">

                        </div>
                        <div class="col-lg-8 col-md-6">
                            <div class="row">
                                <div class="col-lg-6 col-md-7">
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
                                                <c:forEach items="${requestScope.listOrderDetail}" var="od">
                                                    <tr>
                                                        <td class="product__cart__item">
                                                            <div style="width: 120px;overflow: hidden;height:130px" class="product__cart__item__pic" >
                                                                <img  style="width: 120px  " src="${od.product.img}" alt="">
                                                            </div>
                                                            <div class="product__cart__item__text">
                                                                <h6>${od.product.name}</h6>
                                                                <h5>$${od.price}</h5>
                                                            </div>
                                                        </td>
                                                        <td class="quantity__item">
                                                            <div class="quantity">
                                                                <div
                                                                    style="display: flex;width:90px ;justify-content: space-between ;">
                                                                    <input class="inputQuantity" type="text" value="${od.quantity}"
                                                                           min="1">
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td class="cart__price">$ ${od.quantity*od.price}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                            <style>
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
                                        </table>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-5">
                                    <div class="cart__total">
                                        <h6><b>Detail User</b></h6>
                                        <ul class="ulDetailUser">
                                            <li>Name <span>${requestScope.listOrderDetail[0].deliveryShipping.firstName}</span></li>
                                            <li>Address <span>${requestScope.listOrderDetail[0].deliveryShipping.address}</span></li>
                                            <li>Phone <span>${requestScope.listOrderDetail[0].deliveryShipping.phone}</span></li>
                                            <li>Email <span>${requestScope.listOrderDetail[0].deliveryShipping.email}</span></li>
                                        </ul>
                                    </div>
                                    <div class="cart__total">
                                        <h6><b>Detail Order</b></h6>
                                        <ul>
                                            <li>Subtotal <span>${requestScope.subTotal}</span></li>
                                            <li>Tax <span>${requestScope.tax}</span></li>
                                            <li>Shipping <span>${requestScope.shipping}</span></li>
                                            <li>Total <span>${requestScope.total}</span></li>
                                        </ul>
                                        <c:choose>
                                            <c:when test="${requestScope.status eq 'true'}">
                                                <div style="display: flex; justify-content: space-between">
                                                    <button disabled class="primary-btn">Accepted </button>
                                                    <a href="${requestScope.uriBack}"><button type="button" class="btn btn-secondary">Back</button></a>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div  style="display: flex; justify-content: space-between">
                                                    <button onclick="askingAccept('${requestScope.username}', '${requestScope.orderid}')" class="primary-btn">Accept Order</button>
                                                    <a href="${requestScope.uriBack}"><button type="button" class="btn btn-secondary">Back</button></a>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                </div>
                            </div>
                            <style>
                                .ulDetailUser li{
                                    display: flex;
                                    justify-content: space-between;
                                }
                            </style>
                            <script>
                                    function askingAccept(username, orderid) {
                                    if (confirm("Mark as read and accept Order ID: " + orderid+" of User: "+username)) {
                                        window.location = "MainController?action=SetStatusOrder&orderid="+ orderid;
                                    }
                                }
                                function askingDelete(username, keySearch, orderid, page) {
                                    if (confirm("Mark as read and accept Order ID: " + orderid + " of User: " + username)) {
                                        window.location = "MainController?action=SetStatusOrder&keySearch=" + keySearch + "&orderid=" + orderid + "&page=" + page;
                                    }
                                }
                            </script>
                            <!-- code them row heree  -->
                            <br />
                        </div>
                        <div class="col-lg-2 col-md-3">

                        </div>
                    </div>
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