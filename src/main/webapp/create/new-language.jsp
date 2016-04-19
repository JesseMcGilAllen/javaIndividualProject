<%--
  Created by IntelliJ IDEA.
  User: jessemcgilallen
  Date: 2/22/16
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../jsp/doctype.jsp" />

<html>
<c:set var="pageTitle" value="Add Language | Programming Review" scope="request" />
<c:import url="../jsp/header-tag.jsp" />
<body>
<c:import url="../jsp/navigation-bar.jsp" />
<h1>Add Language</h1>

<form action="/pr/languages/add" method="post">
    <div class="form-group">
        <label for="nameInput">Name</label>
        <input type="text" class="form-control" id="nameInput" name="nameInput" placeholder="Name">
    </div>
    <button type="submit" class="btn btn-default">Add Language</button>
</form>

</body>
</html>
