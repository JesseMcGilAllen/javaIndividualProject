<%--
  Created by IntelliJ IDEA.
  User: jessemcgilallen
  Date: 2/23/16
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../jsp/doctype.jsp" />

<html>
<c:set var="algorithm" value="${topic}" scope="request" />
<c:set var="pageTitle" value="Update ${algorithm.name} | Programming Review" scope="request" />
<c:import url="../jsp/header-tag.jsp" />
<body>
<c:import url="../jsp/navigation-bar.jsp" />

<h1>Update Algorithm</h1>

<form action="/pr/algorithms/update" method="post" onsubmit="return checkTopicsForm(this);">
    <div>
        <input type="hidden" id="id" name="id" value="${algorithm.id}"
    </div>
    <div class="form-group">
        <label for="nameField">Name</label>
        <input type="text" class="form-control" id="nameField" name="nameField" placeholder="Name" value="${algorithm.name}">
    </div>
    <div class="form-group">
        <label for="descriptionField">Description</label>
        <textarea class="form-control" id="descriptionField"
                  name="descriptionField" rows="5">${algorithm.description}</textarea>
    </div>
    <button type="submit" class="btn btn-default">Update Algorithm</button>
</form>
</body>
</html>
