<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" >
<!--link rel="stylesheet" href="webjars/bootstrap/3.1.1/css/bootstrap.min.css"-->
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<!--link rel="stylesheet" href="webjars/bootstrap/3.1.1/css/bootstrap-theme.min.css"-->
<!-- link rel="stylesheet" href="css/bootstrap-theme.min.css"-->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<!--script src="webjars/bootstrap/3.1.1/js/bootstrap.min.js"></script-->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!--script src="webjars/jquery/2.1.1/jquery.min.js"></script-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"/></title>
</head>
<body>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="current"/>


    <div class="container">

      <!-- Static navbar -->
      <%--<nav class="navbar navbar-default" role="navigation">--%>
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <%--<span class="icon-bar"></span>--%>
              <%--<span class="icon-bar"></span>--%>
              <%--<span class="icon-bar"></span>--%>
            </button>
            <a class="navbar-brand" href="#">Medical Underwriting</a>
          </div>
          <%--<div id="navbar" class="navbar-collapse collapse">--%>
            <ul class="nav nav-pills">

              <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/"/>'><span class="glyphicon glyphicon-home"></span> Home</a></li>
              <%--<li class="${current == 'marketing' ? 'active' : ''}"><a href="#"><span class="glyphicon glyphicon-cutlery"></span> Marketing</a></li>--%>
              <li class="${current == 'corporates' ? 'active' : ''}"><a href='<spring:url value="/corporates/1" />'>Corporates</a></li>
              <%--<li class="${current == 'care' ? 'active' : ''}"><a href='<sprtable table-bordered table-hover table-condenseding:url value="/care" />'><span class="glyphicon glyphicon-tint"></span>Care</a></li>--%>
              <%--<li class="${current == 'reports' ? 'active' : ''}"><a href='<spring:url value="/reports" />'>Reports</a></li>--%>
              <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                      Claims<b class="caret"></b>
                  </a>
              	<ul class="dropdown-menu">
              		<li><a href='<spring:url value="/claims/capture" />'>Capture</a></li>
              		<li><a href='<spring:url value="/claims/batch" />'>Batch</a></li>
              		<li><a href='<spring:url value="/claims/vetting" />'>Vet</a></li>
              		<li><a href='<spring:url value="/claims/authorize" />'>Authorize</a></li>
              	</ul>
              </li>
              <li class="${current == 'users' ? 'active' : ''}"><a href='<spring:url value="/users" />'>Users</a></li>
              <li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register" />'>Register</a></li>
              
            </ul>
          <%--</div><!--/.nav-collapse -->--%>
        </div><!--/.container-fluid -->
      <%--</nav>--%>

   <tiles:insertAttribute name="body"/>

    </div>




<br><br>

<center>
	<tiles:insertAttribute name="footer"/>
</center>

</body>
</html>
