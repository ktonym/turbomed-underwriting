<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered">
    <thead>
        <tr>
            <th></th>
            <th>Abbreviation</th>
            <th>Scheme Name</th>
            <th>Email address</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${corps}" var="corp">
            <tr>
                <td>
                    <span class="glyphicon glyphicon-edit"></span>
                </td>
                <td>
                    ${corp.abbreviation}
                </td>
                <td>
                    ${corp.name}
                </td>
                <td>
                    ${corp.email}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>