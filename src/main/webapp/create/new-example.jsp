<%--
  Created by IntelliJ IDEA.
  User: jessemcgilallen
  Date: 5/10/16
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../jsp/doctype.jsp" />

<html>
<c:set var="pageTitle" value="Add Example | Programming Review" scope="request" />
<c:import url="../jsp/header-tag.jsp" />
<body>
<c:import url="../jsp/navigation-bar.jsp" />
<h1>Add Example</h1>

<form action="/pr/examples/new" method="post">
    <div class="form-group">
        <select name="languageSelect">
            <c:forEach var="language" items="${languages}">
                <option value="${language.id}">${language.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <div>To add an Example</div>
        <ul>
            <li>go to <a href="https://gist.github.com">gist.github.com</a></li>
            <li>create a gist</li>
            <li>Copy the gist url</li>
            <li>Paste the url in the Gist URL box</li>
            <li>URL Should follow 'https://' + url + '.js'</li>
        </ul>

        <label for="gistField">Gist URL</label>
        <input type="text" class="form-control" id="gistField" name="gistField" placeholder="Gist URL">
    </div>
    <input type="hidden" id="topicId" name="topicId" value="${topicId}" />
    <button type="submit" class="btn btn-default">Add Example</button>
</form>

</body>
</html>