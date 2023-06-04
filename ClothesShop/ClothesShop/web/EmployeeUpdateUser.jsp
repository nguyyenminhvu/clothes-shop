<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <title>Update</title>
    </head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/izitoast/1.4.0/css/iziToast.min.css"
          integrity="sha512-O03ntXoVqaGUTAeAmvQ2YSzkCvclZEcPQu1eqloPaHfJ5RuNGiS4l+3duaidD801P50J28EHyonCV06CUlTSag=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="css/employeeUpdate.css">

    <body style="background-image: url(./img/pexels-andreea-ch-1166644.jpg);">
    <c:if test="${sessionScope.ACC eq null || sessionScope.ACC.role ne 'EMPLOYEE'}">
        <c:redirect url="Login.html"></c:redirect>
    </c:if>
    <section>
        <div class="container-fluid">
            <form  action="MainController" method="POST">
                <div class="row">
                    <div class="col-lg-4 col-md-2">
                    </div>
                    <div class="col-lg-4 cuscol col-md-8">
                        <div class="frameOver">
                            <div class="frameOver_x">
                                <div class="frameOver_welcome">
                                    <h4 style="text-shadow: 1px 2px #c5c2c2;">Please type the information</h4>
                                </div>
                                <div class="groupInput">
                                    <div class="titleInput">
                                        Username <b style="color: red;">*</b>
                                    </div>
                                    <div class="typeInput">
                                        <input class="typeInput__content" type="text" placeholder="Username" value="${requestScope.USER.username}" disabled>
                                        <input class="typeInput__content" name="username" value="${requestScope.USER.username}" hidden>
                                    </div>
                                    <div class="objectError">
                                        <p class="cusError"></p>
                                    </div>
                                </div>
                                <div class="groupInput">
                                    <div class="titleInput">
                                        Full Name <b style="color: red;">*</b>
                                    </div>
                                    <div class="typeInput">
                                        <input class="typeInput__content" type="text" placeholder="Full Name" name="fullName" value="${requestScope.USER.name}"
                                               required>
                                    </div>
                                    <div class="objectError">
                                        <p class="cusError">${requestScope.uERROR.fullNameERROR} </p>
                                    </div>
                                </div>
                                <div class="groupInput">
                                    <div class="titleInput">
                                        Phone <b style="color: red;">*</b>
                                    </div>
                                    <div class="typeInput">
                                        <input class="typeInput__content" type="number" placeholder="Phone " name="phone" value="${requestScope.USER.phone}"
                                               required>
                                    </div>
                                    <div class="objectError">
                                        <p class="cusError">${requestScope.uERROR.phoneERROR} </p>
                                    </div>
                                </div>
                                <div class="groupInput">
                                    <div class="titleInput">
                                        Address <b style="color: red;">*</b>
                                    </div>
                                    <div class="typeInput">
                                        <input class="typeInput__content" type="text" placeholder="Address"   name="address" value="${requestScope.USER.address}"  required> 
                                        <input class="typeInput__content" type="text" name="role" value='USER'  hidden>
                                    </div>
                                    <div class="objectError">
                                        <p class="cusError">${requestScope.uERROR.addressERROR}</p>
                                    </div>
                                </div>
                                <br/>
                                <div class="buttonSubmit">
                                    <button type="submit" class="btn btn-success cusButton">Save</button>
                                    <a class="cusA" href="UserManagementController"> <input class="inputCusS" type="text" value="Back"
                                                                                            readonly></a>
                                    <input name="action" value="EmployeeUpdateUser" hidden/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-2">
                    </div>
                </div>
            </form>
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