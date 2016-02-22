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
<c:import url="../jsp/header-tag.jsp" />
<body>

<h1>Languages</h1>

<h3><a href="/language/add-language.jsp">Add Language</a></h3>
<h3><a href="/language/language.jsp">Language</a></h3>

</body>
</html>