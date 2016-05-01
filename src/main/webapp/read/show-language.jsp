<%--  Created by IntelliJ IDEA.  User: jessemcgilallen  Date: 2/22/16  Time: 2:38 PM  To change this template use File | Settings | File Templates.  This is a placeholder for the actual language page--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:import url="/jsp/doctype.jsp" /><html><c:set var="pageTitle" value="${language.name} | Programming Review" scope="request" /><c:import url="../jsp/header-tag.jsp" /><body><c:import url="../jsp/navigation-bar.jsp" /><h1>${language.name}</h1><ul class="nav nav-tabs">    <c:url value="/languages/update" var="updateUrl">        <c:param name="name" value="${language.name}" />    </c:url>    <li><a href="${updateUrl}">Update</a></li>    <c:url value="/languages/delete" var="deleteUrl">        <c:param name="name" value="${language.name}" />    </c:url>    <li><a href="${deleteUrl}">Delete</a></li>    <c:url value="/languages/concepts/new" var="conceptUrl">        <c:param name="name" value="${language.name}" />    </c:url>    <li><a href="${conceptUrl}">Add Concept</a></li>    <li><a href="/pr/create/new-term.jsp">Add Term</a></li></ul><h3><a href="#">Concepts</a></h3><c:forEach items="${concepts}" var="concept">    <h5>        <c:set value="${concept.name}" var="conceptName" scope="page" />        <c:set value="${concept.description}" var="conceptDescription" scope="page" />        <%--<c:url value="/language" var="url">--%>            <%--<c:param name="name" value="${language.name}" />--%>        <%--</c:url>--%>        <p> ${conceptName}</p>        <p>${conceptDescription}</p>    </h5></c:forEach><h3><a href="#">Terms</a></h3></body></html>