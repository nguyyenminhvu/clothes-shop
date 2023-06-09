<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <title>
            Review Order
        </title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/izitoast/1.4.0/css/iziToast.min.css"
              integrity="sha512-O03ntXoVqaGUTAeAmvQ2YSzkCvclZEcPQu1eqloPaHfJ5RuNGiS4l+3duaidD801P50J28EHyonCV06CUlTSag=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <link rel="stylesheet" href="css/reviewPayment.css">
    </head>

    <body>
        <c:if test="${requestScope.transaction eq null || requestScope.payer eq null  }">
            <c:redirect url="LoadPage"></c:redirect>
        </c:if>
        <div style="height: 100px;">
        </div>
        <section>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4">
                    </div>
                    <div class="col-lg-4">
                        <div class="tilte__check">
                            <div class="tilte__check_x">
                                REVIEW YOUR ORDER
                            </div>
                        </div>
                        <br>
                        <hr>
                        <div class="groupTable">
                            <table>
                                <tr>
                                    <td><b>Description:</b> </td>
                                    <td>${requestScope.transaction.description}</td>
                                </tr>
                                <tr>
                                    <td>Subtotal: </td>
                                    <td>${requestScope.transaction.amount.details.subtotal}</td>
                                </tr>
                                <tr>
                                    <td>Tax:</td>
                                    <td>${requestScope.transaction.amount.details.tax}</td>
                                </tr>
                                <tr>
                                    <td>Shipping Fee:</td>
                                    <td>${requestScope.transaction.amount.details.shipping}</td>
                                </tr>
                                <tr>
                                    <td>Total:</td>
                                    <td>${requestScope.transaction.amount.total}</td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                </tr>
                                <tr>
                                    <td><b>Payer Information:</b> </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>
                                        First Name: 
                                    </td>
                                    <td>
                                        ${requestScope.payer.firstName}
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Last Name: 
                                    </td>
                                    <td>
                                        ${requestScope.payer.lastName}
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Email:
                                    </td>
                                    <td>
                                        ${requestScope.payer.email}
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                </tr>
                                <tr>
                                    <td><b>Shipping Address:</b></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Recipient Name:</td>
                                    <td>${requestScope.shippingAddress.recipientName}</td>
                                </tr>
                                <tr>
                                    <td>Line 1:</td>
                                    <td>${requestScope.shippingAddress.line1}</td>
                                </tr>
                                <tr>
                                    <td>City:</td>
                                    <td>${requestScope.shippingAddress.city}</td>
                                </tr>
                                <tr>
                                    <td>State:</td>
                                    <td>${requestScope.shippingAddress.state}</td>
                                </tr>
                                <tr>
                                    <td>Country Code:</td>
                                    <td>${requestScope.shippingAddress.countryCode}</td>
                                </tr>
                                <tr>
                                    <td>Postal Code:</td>
                                    <td>${requestScope.shippingAddress.postalCode}</td>
                                </tr>
                            </table>
                        </div>
                        <br>
                        <hr>
                        <div class="groupTotal">
                            <div class="groupTotal__x">
                                <h3> Total: <b>$ ${requestScope.totalResult}</b></h3>
                            </div>
                        </div>
                        <br/>
                        <div class="p3">
                            <div class="groupButtonF">
                                <div class="groupA">
                                    <form action="PaymentExecute" method="POST">
                                        <input name="paymentId" value="${param.paymentId}" hidden/>
                                        <input name="PayerID" value="${param.PayerID}" hidden/>
                                        <button type="submit" class="btn btn-primary">Payment</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                    </div>
                </div>
            </div>
        </section>

        <br/>
        <br/>
        <br/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/md5.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/js/all.min.js"
                integrity="sha512-naukR7I+Nk6gp7p5TMA4ycgfxaZBJ7MO5iC3Fp6ySQyKFHOGfpkSZkYVWV5R7u7cfAicxanwYQ5D1e17EfJcMA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/izitoast/1.4.0/js/iziToast.min.js"
                integrity="sha512-Zq9o+E00xhhR/7vJ49mxFNJ0KQw1E1TMWkPTxrWcnpfEFDEXgUiwJHIKit93EW/XxE31HSI5GEOW06G6BF1AtA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </body>

</html>