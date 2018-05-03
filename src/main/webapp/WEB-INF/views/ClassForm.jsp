<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form class="form-horizontal" id="form" action="deliveryManager/saveClassBatch" modelAttribute="formClassBatch" method="POST">
    <form:hidden path="classId" value="${classBatch.getClassId() }" class="form-control" />
    <div class="form-group">
        <label class="control-label col-sm-2" style="text-align: left">Class Name*</label>
        <div class="col-sm-2">
            <form:input path="className" class="form-control" />
            <form:errors path="className" class="error-message"></form:errors>
        </div>
        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Class Code*</label>
        <div class="col-sm-2">
            <form:input path="classCode" class="form-control" />
            <form:errors path="classCode" class="error-message"></form:errors>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" style="text-align: left">Expected Start Date*</label>
        <div class="col-sm-2">
            <form:input path="expectedStartDate" id="startdatepicker" class="form-control" />
            <form:errors path="expectedStartDate" class="error-message"></form:errors>
        </div>
        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Expected End Date*</label>
        <div class="col-sm-2">
            <form:input path="expectedEndDate" id="enddatepicker" class="form-control" />
            <form:errors path="expectedEndDate" class="error-message"></form:errors>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" style="text-align: left">Location*</label>
        <div class="col-sm-2">
            <form:select path="locationID" class="form-control ">
                <c:forEach items="${locationList }" var="location">
                    <form:option value="${location.getLocationId() }">${location.getLocationName() }</form:option>
                </c:forEach>
            </form:select>
        </div>
        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Detail Location*</label>
        <div class="col-sm-2">
            <form:input path="detailLocation" class="form-control" />
            <form:errors path="detailLocation" class="error-message"></form:errors>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" style="text-align: left">Class Admin*</label>
        <div class="col-sm-2">
            <form:select path="classadminID" class="form-control">
                <%--       	  	<c:forEach items="${classAdminList }" var="classAdmin"> --%>
                <%-- 	       		 <option value="${classAdmin.getClassAdminId() }">${classAdmin.getRemarks() }</option> --%>
                <%-- 	        </c:forEach> --%>
                            <form:options items="${classAdminList }" itemValue="classAdminId" itemLabel="remarks" />
            </form:select>
        </div>

        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Planned Trainee Number</label>
        <div class="col-sm-2">
            <form:input path="plannedTraineeNumber" class="form-control" type="number" />
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" style="text-align: left">Remarks</label>
        <div class="col-sm-7">
            <form:input path="remarks" class="form-control" />
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" style="text-align: left">History</label>
        <div class="col-sm-7">
            <input class="form-control" type="text" />
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-7 col-sm-1">
            <input type="submit" id="btnSubmit" style="float:right" class="btn btn-success" value="${ButtonSubmit }" />
        </div>
        <div class="col-sm-1">
            <a href="classList" style="float: right" class="btn btn-default">Cancel</a>
        </div>
    </div>
</form:form>
	