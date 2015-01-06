<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>


<form:form commandName="corporate">
    
        <c:if test="${param.success eq true}">
            <div class="alert alert-success">Corporate added successfully</div>
        </c:if>
    
        <div class="form-group">
              <label for="name" class="col-sm-2 control-label">Name:</label>
              <div class="col-sm-10">
                  <form:input path="name" cssClass="form-control"/>
              </div>
        </div>

        <div class="form-group">
            <label for="abbreviation" class="col-sm-2 control-label">Abbreviation:</label>
            <div class="col-sm-10">
                <form:input path="abbreviation" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="tel" class="col-sm-2 control-label">tel.:</label>
            <div class="col-sm-10">
                <form:input path="tel" cssClass="form-control"/>
            </div>
        </div>


        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email:</label>
            <div class="col-sm-10">
                <form:input path="email" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="postalAddress" class="col-sm-2 control-label">Postal Address:</label>
            <div class="col-sm-10">
                <form:input path="postalAddress" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
            </div>
        </div>
</form:form>