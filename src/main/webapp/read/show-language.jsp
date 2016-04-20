<%--  Created by IntelliJ IDEA.  User: jessemcgilallen  Date: 2/22/16  Time: 2:38 PM  To change this template use File | Settings | File Templates.  This is a placeholder for the actual language page--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:import url="/jsp/doctype.jsp" /><html><c:set var="pageTitle" value="${language.name} | Programming Review" scope="request" /><c:import url="../jsp/header-tag.jsp" /><body><c:import url="../jsp/navigation-bar.jsp" /><h1>${language.name}</h1><ul class="nav nav-tabs">    <c:set value="${altName}" var="altName" scope="request" />    <c:choose>        <c:when test="${altName != null}">            <li><a href="languages/update?name=${altName}">Update</a></li>        </c:when>        <c:otherwise>            <li><a href="languages/update?name=${language.name}">Update</a></li>        </c:otherwise>    </c:choose>    <li><a href="../delete/delete-language.jsp">Delete</a></li></ul><h3><a href="#">Concepts</a></h3><a href="../create/new-concept.jsp">Add Concept</a><h3><a href="#">Terms</a></h3><a href="../create/new-term.jsp">Add Term</a></body></html>