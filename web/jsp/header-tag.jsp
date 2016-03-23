<%--
  Created by IntelliJ IDEA.
  User: jessemcgilallen
  Date: 2/17/16
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <c:choose>
        <c:when test="${pageTitle != null}">

        <title>${pageTitle} | Programming Review</title>
        </c:when>
        <c:otherwise>
            <title>Programming Review</title>
        </c:otherwise>
    </c:choose>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>

