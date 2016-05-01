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
<c:set var="pageTitle" value="Add Term | Programming Review" scope="request" />
<c:import url="../jsp/header-tag.jsp" />
<body>
<c:import url="../jsp/navigation-bar.jsp" />
<h1>Add Term</h1>

<form action="/pr/languages/terms/new" method="post">
    <div class="form-group">
        <label for="nameField">Name</label>
        <input type="text" class="form-control" id="nameField" name="nameField" placeholder="Name">
    </div>
    <div class="form-group">
        <label for="descriptionField">Description</label>
        <textarea class="form-control" id="descriptionField"
                  name="descriptionField" rows="3"></textarea>
    </div>
    <input type="hidden" id="language" name="language" value="${language.name}" />
    <button type="submit" class="btn btn-default">Add Term</button>
</form>
</body>
</html>
