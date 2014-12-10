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

    <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Medical Underwriting</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href='<spring:url value="/"/>'>Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href='<spring:url value="/corporate" />'>Corporates</a></li>
              <li><a href='<spring:url value="/corporates" />'>Corporate Pages</a></li>
              <li><a href="#">Contact</a></li>
              
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

   <tiles:insertAttribute name="body"/>

    </div>




<br><br>

<center>
	<tiles:insertAttribute name="footer"/>
</center>

</body>
</html>
