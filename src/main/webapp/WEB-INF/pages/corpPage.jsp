<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="firstUrl" value="/corporates/1" />
<c:url var="lastUrl" value="/corporates/${corpPage.totalPages}" />
<c:url var="prevUrl" value="/corporates/${currentIndex - 1}" />
<c:url var="nextUrl" value="/corporates/${currentIndex + 1}" />

<div>
    <ul class="pagination pagination-small">
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#">&laquo;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&laquo;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>

        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/corporates/${i}"/>
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${currentIndex == corpPage.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&raquo;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&raquo;</a></li>
            </c:otherwise>
        </c:choose>

    </ul>
</div>

<table class="table table-bordered table-hover table-condensed">
    <thead>
    <tr>
        <th>Abbreviation</th>
        <th>Scheme Name</th>
        <th>Email address</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    
    <c:choose>
    	<c:when test="${corpList.isEmpty()}">
    		<div class="alert alert-warning" role="alert">There are no more items to display!</div>
    	</c:when>
    	<c:otherwise>
    		<c:forEach items="${corpList}" var="corp">
		        <tr>
		            <td>
		                    ${corp.abbreviation}
		            </td>
		            <td>
		                    ${corp.name}
		            </td>
		            <td>
		                    ${corp.email}
		            </td>
		            <td>
		            	<span class="glyphicon glyphicon-edit"></span>
		            	<a href="/corporates/edit/${corp.id}">edit</a>
		            </td>
		        </tr>
    		</c:forEach>    	
    	</c:otherwise>
    </c:choose>
    
    
    </tbody>
</table>

