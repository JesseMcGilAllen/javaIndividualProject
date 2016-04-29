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

<div class="text-center">

    <div class="list-group list-group-horizontal">
        <a href="../pr/create/new-language.jsp" class="list-group-item">Add Language</a>

    </div>

</div>


<c:forEach items="${languages}" var="language">

    <h3>
        <c:set value="${language.name}" var="name" scope="request" />
        <c:url value="/language" var="url">
            <c:param name="name" value="${language.name}" />
        </c:url>
        <a href="${url}">${name}</a>
    </h3>
</c:forEach>


</body>
</html>