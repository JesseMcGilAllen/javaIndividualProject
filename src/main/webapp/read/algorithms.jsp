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
<c:set var="pageTitle" value="Algorithms | Programming Review" scope="request" />
<c:import url="/jsp/header-tag.jsp" />
<body>

<c:import url="/jsp/navigation-bar.jsp" />
<h1>Algorithms</h1>

<h3><a href="/pr/create/new-algorithm.jsp">Add Algorithm</a></h3>
<h3><a href="../read/show-algorithm.jsp">Algorithm</a></h3>

<c:forEach items="${topics}" var="algorithm">
    <div>
        <c:set value="${algorithm.name}" var="algorithmName" scope="page" />
        <c:set value="${algorithm.description}" var="algorithmDescription" scope="page" />
            <c:url value="/algorithm" var="url">
            <c:param name="id" value="${algorithm.id}" />
            </c:url>
        <h3><a href="${url}">${algorithmName}</a></h3>
        <p>${algorithmDescription}</p>
        <hr />
    </div>
</c:forEach>
</body>
</html>