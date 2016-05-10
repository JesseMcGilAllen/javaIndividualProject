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
<c:set var="pageTitle" value="Design Patterns | Programming Review" scope="request" />
<c:import url="/jsp/header-tag.jsp" />
<body>

<c:import url="/jsp/navigation-bar.jsp" />
<h1>Design Patterns</h1>

<ul class="nav nav-tabs">
    <li><a href="/pr/create/new-design-pattern.jsp">Add Design Pattern</a></li>

    <%--<c:url value="/random/algorithm" var="randomUrl">--%>
        <%--<c:param name="algorithms" value="${algorithms}" />--%>
    <%--</c:url>--%>

    <%--<li><a href="${randomUrl}">Random Algorithm</a></li>--%>
</ul>

<c:forEach items="${designPatterns}" var="designPattern">
    <div>
        <c:set value="${designPattern.name}" var="designPatternName" scope="page" />
        <c:set value="${designPattern.description}" var="designPatternDescription" scope="page" />
            <%--<c:url value="/language" var="url">--%>
            <%--<c:param name="name" value="${language.name}" />--%>
            <%--</c:url>--%>
        <p>${designPatternName}</p>
        <p>${designPatternDescription}</p>
        <hr />
    </div>
</c:forEach>
</body>
</html>