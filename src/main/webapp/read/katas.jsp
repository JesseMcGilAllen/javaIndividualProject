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
<c:set var="pageTitle" value="Katas | Programming Review" scope="request" />
<c:import url="/jsp/header-tag.jsp" />
<body>

<c:import url="/jsp/navigation-bar.jsp" />
<h1>Katas</h1>

<h3><a href="../create/new-kata.jsp">Add Kata</a></h3>
<h3><a href="../read/show-kata.jsp">Kata</a></h3>

<c:forEach items="${katas}" var="kata">
    <div>
        <c:set value="${kata.name}" var="kataName" scope="page" />
        <c:set value="${kata.description}" var="kataDescription" scope="page" />
        <%--<c:url value="/language" var="url">--%>
        <%--<c:param name="name" value="${language.name}" />--%>
        <%--</c:url>--%>
        <p>${kataName}</p>
        <p>${kataDescription}</p>
        <hr />
    </div>
</c:forEach>

</body>
</html>