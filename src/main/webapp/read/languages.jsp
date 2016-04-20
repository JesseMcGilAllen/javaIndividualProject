<%--
  Created by IntelliJ IDEA.
  User: jessemcgilallen
  Date: 2/18/16
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/jsp/doctype.jsp" />

<html>
<c:set var="pageTitle" value="Languages | Programming Review" scope="request" />
<c:import url="/jsp/header-tag.jsp" />
<body>

<c:import url="/jsp/navigation-bar.jsp" />
<h1>Languages</h1>

<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 text-center">

    <div class="list-group list-group-horizontal">
        <a href="create/new-language.jsp" class="list-group-item">Add Language</a>

    </div>

</div>


<h1>Languages</h1>
<c:forEach items="${languages}" var="language">

    <h3>
        <c:set value="${language.name}" var="name" scope="request" />
        <c:set value="${altName}" var="altName" scope="request" />
        <c:choose>
            <c:when test="${altName != null}">
                <a href="language?name=${altName}">${language.name}</a>
            </c:when>
            <c:otherwise>
                <a href="language?name=${language.name}">${language.name}</a>
            </c:otherwise>
        </c:choose>

    </h3>
</c:forEach>


</body>
</html>