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

<form action="j_security_check" method="post">
    <div class="form-group">
        <label for="inputUsername">Username</label>
        <input type="text" class="form-control" id="inputUsername" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="inputPassword">Password</label>
        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>

</body>
</html>
