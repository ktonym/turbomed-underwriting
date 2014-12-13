<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<c:choose>
    <c:when test="${users.isEmpty()}">
        <div class="alert alert-warning" role="alert">There are no users to display!</div>
    </c:when>

    <c:otherwise>

            <table class="table table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>
                            Username
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            More..
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>
                                 ${user.username}
                            </td>
                            <td>
                                 ${user.email}
                            </td>
                            <td>
                                 ${user.password}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </c:otherwise>

</c:choose>