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
       
            <tr>
                <td>
                    <span class="glyphicon glyphicon-edit"></span>
                </td>
                <td>
                    ${corporate.abbreviation}
                </td>
                <td>
                    ${corporate.name}
                </td>
                <td>
                    ${corporate.email}
                </td>
            </tr>
        
    </tbody>
</table>