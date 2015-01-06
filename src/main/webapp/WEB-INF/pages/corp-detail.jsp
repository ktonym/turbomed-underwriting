<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layouts/taglib.jsp" %>

<c:url var="createAnniv" value="/corporate/addAnniv/${corporate.id}" />
<c:url var="createContactPax" value="/corporate/addContact/${corporate.id}"/>

<a href="${createAnniv}">Add anniversary</a> |<a href="${createContactPax}">Add contact person</a>

    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Demo
    </button>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

<table class="table table-bordered">

    <tbody>
       
            <tr>
                <td>
                    Abbreviation:
                </td>
                <td>
                    <input type="text" value="${corporate.abbreviation}" />
                </td>
            </tr>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    <input type="text"  value="${corporate.name}"/>
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td><input type="text" value="${corporate.email}" />
                </td>
            </tr>
            <tr>
                <td>
                    Tel:
                </td>
                <td><input type="text" value="${corporate.tel}" />
                </td>
            </tr>

            <tr>
                <td>
                    Postal ad:
                </td>
                <td><input type="text" value="${corporate.postalAddress}" />
                </td>
            </tr>
            <tr>
                <td>
                    Join date:
                </td>
                <td><input type="text" value="${corporate.joined}" />
                </td>
            </tr>
        
    </tbody>
</table>