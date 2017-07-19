<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<h2>Student Information</h2>
<form:form method = "POST"    commandName="form"  >
    <table>
        <tr>

            <td><form:input path = "categoryName" /></td>
        </tr>

        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>

            <c:forEach items="${categoryList}"
                       var="getCategoryAll">

                ${categoryList.categoryName}
            </c:forEach>
            <br>
        </tr>
    </table>
</form:form>
</body>

</html>