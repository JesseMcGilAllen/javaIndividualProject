<%--  Created by IntelliJ IDEA.  User: jessemcgilallen  Date: 2/22/16  Time: 2:38 PM  To change this template use File | Settings | File Templates.  This is a placeholder for the actual           page--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:import url="/jsp/doctype.jsp" /><html><c:set var="concept" value="${topic}" scope="request" /><c:set var="pageTitle" value="${concept.name} | Programming Review" scope="request" /><c:import url="../jsp/header-tag.jsp" /><body><c:import url="../jsp/navigation-bar.jsp" /><h1>${concept.name}</h1><ul class="nav nav-tabs">    <c:url value="/concepts/update" var="updateUrl">        <c:param name="id" value="${concept.id}" />        <c:param name="languageName" value="${languageName}" />    </c:url>    <li><a href="${updateUrl}">Update</a></li>    <c:url value="/concepts/delete" var="deleteUrl">        <c:param name="id" value="${concept.id}" />        <c:param name="languageName" value="${languageName}" />    </c:url>    <li><a href="${deleteUrl}">Delete</a></li></ul><div>    <h4>Description</h4>    <p>${concept.description}</p></div></body></html>