<%--  Created by IntelliJ IDEA.  User: jessemcgilallen  Date: 2/22/16  Time: 2:38 PM  To change this template use File | Settings | File Templates.  This is a placeholder for the actual kata page--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:import url="/jsp/doctype.jsp" /><<html><c:set var="kata" value="${topic}" scope="request" /><c:set var="pageTitle" value="${kata.name} | Programming Review" scope="request" /><c:import url="../jsp/header-tag.jsp" /><body><h1>${kata.name}</h1><ul class="nav nav-tabs">    <c:url value="/katas/update" var="updateUrl">        <c:param name="id" value="${kata.id}" />    </c:url>    <li><a href="${updateUrl}">Update</a></li>    <c:url value="/katas/delete" var="deleteUrl">        <c:param name="id" value="${kata.id}" />    </c:url>    <li><a href="${deleteUrl}">Delete</a></li>    <c:url value="/examples/new" var="exampleUrl">        <c:param name="id" value="${kata.id}" />    </c:url>    <li><a href="${exampleUrl}">Add Example</a></li></ul><div>    <h4>Description</h4>    <p>${kata.description}</p></div></body></html>