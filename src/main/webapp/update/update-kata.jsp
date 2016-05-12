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
<c:set var="kata" value="${topic}" scope="request" />
<c:set var="pageTitle" value="Update ${kata.name} | Programming Review" scope="request" />
<c:import url="../jsp/header-tag.jsp" />
<body>
<c:import url="../jsp/navigation-bar.jsp" />

<h1>Update kata</h1>

<form action="/pr/katas/update" method="post" onsubmit="return checkTopicsForm(this);">
    <div>
        <input type="hidden" id="id" name="id" value="${kata.id}"
    </div>
    <div class="form-group">
        <label for="nameField">Name</label>
        <input type="text" class="form-control" id="nameField" name="nameField" placeholder="Name" value="${kata.name}">
    </div>
    <div class="form-group">
        <label for="descriptionField">Description</label>
        <textarea class="form-control" id="descriptionField"
                  name="descriptionField" rows="5">${kata.description}</textarea>
    </div>
    <button type="submit" class="btn btn-default">Update kata</button>
</form>
</body>
</html>
