<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Fresh Report</title>
    <jsp:include page="/fragment/lib.jsp"></jsp:include>
    <script>
    $(function() {
       var check = $("#role").hasClass('col-sm-offset-5');
   		 if (check == false) {
   			$("#cancel").addClass("col-sm-offset-7");
		 }
    });
    </script>
</head>
<body>
    <div class="container-fluid">
         <jsp:include page="header.jsp"></jsp:include>
        <div class="row">
            <div class="col-md-2">
                <jsp:include page="menu.jsp"></jsp:include>
            </div>
            <div class="col-md-10">
                <form class="form-horizontal" id="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="text-align: left">Class Name*</label>
                        <div class="col-sm-2">
                            ${classbatchInfo.getClassName()}
                        </div>
                        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Class Code*</label>
                        <div class="col-sm-2">
                            ${classbatchInfo.getClassCode()}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="text-align: left">Expected Start Date*</label>
                        <div class="col-sm-2">
                            ${classbatchInfo.getExpectedStartDate()}
                        </div>
                        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Expected End Date*</label>
                        <div class="col-sm-2">
                            ${classbatchInfo.getExpectedEndDate()}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="text-align: left">Location*</label>
                        <div class="col-sm-2">

                            <c:forEach items="${locationList }" var="location">
                                <c:if test="${classbatchInfo.locationID == location.locationId }">
                                    ${location.getLocationName()}
                                </c:if>
                            </c:forEach>

                        </div>

                        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Detail Location*</label>
                        <div class="col-sm-2">
                            ${classbatchInfo.getDetailLocation()}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="text-align: left">Class Admin*</label>
                        <div class="col-sm-2">
                            ${classAdminName}
                        </div>

                        <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Planned Trainee Number</label>
                        <div class="col-sm-2">
                            ${classbatchInfo.getPlannedTraineeNumber()}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="text-align: left">Remarks</label>
                        <div class="col-sm-7">
                            ${classbatchInfo.getRemarks()}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="text-align: left">History</label>
                        <div class="col-sm-7">
                            Create by ...
                        </div>
                    </div>
                    <div class="form-group">
                    	<c:if test="${ROLE eq 'ROLE_0'}">
		                    <div class="col-sm-offset-5 col-sm-1" id = "role">
	                    		<a href="classList" style="float: right" class="btn btn-default">Approve</a>
	                        </div>
	                        <div class="col-sm-1">
	                    		<a href="classList" style="float: right" class="btn btn-default">Reject</a>
	                        </div>
                    	</c:if>
                    	<c:if test="${ROLE eq 'ROLE_2'}">
		                    <div class="col-sm-offset-5 col-sm-1">
	                    		<a href="classList" style="float: right" class="btn btn-default">Accept</a>
	                        </div>
	                        <div class="col-sm-1">
	                    		<a href="classList" style="float: right" class="btn btn-default">Decline</a>
	                        </div>
                    	</c:if>
                    		<div class="col-sm-1" id = "cancel">
                            	<a href="classList" style="float: right" class="btn btn-default">Cancel</a>
                            </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>