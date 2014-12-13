<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layouts/taglib.jsp" %>

<table class="table table-bordered">

    <tbody>
       
            <tr>
                <td>
                    Abbreviation:
                </td>
                <td>
                    ${corporate.abbreviation}
                </td>
            </tr>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    ${corporate.name}
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    ${corporate.email}
                </td>
            </tr>
        
    </tbody>
</table>