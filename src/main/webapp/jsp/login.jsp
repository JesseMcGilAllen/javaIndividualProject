

<%--
  Created by IntelliJ IDEA.
  User: jessemcgilallen
  Date: 2/17/16
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="doctype.jsp" />
<html>
<c:set var="pageTitle" value="Login | Programming Review" scope="request" />
<c:import url="header-tag.jsp" />
<body>

<c:import url="navigation-bar.jsp" />

<div class="container">
    <form action="j_security_check" method="post">
        <div class="row">
            <div class="form-group col-lg-6">
                <label for="inputUsername">Username</label>
                <input type="text" class="form-control" id="inputUsername" placeholder="Username" name="j_username">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-6">
                <label for="inputPassword">Password</label>
                <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="j_password">
            </div>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>
