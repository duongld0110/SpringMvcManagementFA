<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=charset=UTF-8">
    <title>Fresh Report</title>
    <jsp:include page="/fragment/lib.jsp"></jsp:include>
    <script>
        $(function() {
            $("#startdatepicker").datepicker();
            $("#enddatepicker").datepicker();
        });
    </script>
</head>

<body>
    <div class="container-fluid">
         <jsp:include page="header.jsp"></jsp:include>

        <div class="row">
            <div class="col-md-2">
                <h2>Fresher Report</h2>
                <jsp:include page="menu.jsp"></jsp:include>
            </div>

            <div class="col-md-10">
                <div class="row">

                    <form class="form-horizontal" id="form" action="searchClass" method="POST">
                        <input type="hidden" class="form-control" />

                        <div class="form-group">
                            <label class="control-label col-sm-2" style="text-align: left">Location</label>
                            <div class="col-sm-2">
                                <select name="locationName" class="form-control ">
                                    <c:forEach items="${locationList }" var="location">
                                        <option value="${location.getLocationId() }">${location.getLocationName() }</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Class Code
                            </label>
                            <div class="col-sm-2">
                                <input type="text" name="classCode" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" style="text-align: left">Expected Start Date</label>
                            <div class="col-sm-2">
                                <input type="text" name="expectedStartDate" id="startdatepicker" placeholder=" /	/" class="form-control" />
                            </div>

                            <label class="control-label col-sm-offset-1 col-sm-2" style="text-align: left">Expected End Date</label>
                            <div class="col-sm-2">
                                <input type="text" name="expectedEndDate" id="enddatepicker" placeholder=" /	/" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" style="text-align: left">Status</label>
                            <div class="col-sm-2">
                                <select name="status" class="form-control ">
                                    <option value="">All</option>
                                    <option value="Closed">Closed</option>
                                    <option value="Reviewed">Reviewed</option>
                                    <option value="Planned">Planned</option>
                                </select>
                            </div>

                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-7 col-sm-1">
                                <input type="submit" id="btnSubmit" style="float: right" class="btn btn-success" value="Search" />
                            </div>

                            <div class="col-sm-1">
                                <a href="classList" style="float: right" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form>
                </div>

                <h4>Search Result :	${classBatchInfoList.totalRecords } Results</h4>
                <table class="table table-bordered" style="margin-top: 30px">
                    <tr>
                        <th>Class Code</th>
                        <th>Location</th>
                        <th>Status</th>
                        <th>Expected Start Date</th>
                        <th>Expected End Date</th>
                        <th>Actual Start Date</th>
                        <th>Actual End Date</th>
                        <th>Class Admin</th>
                        <th>Trainer</th>
                    </tr>
                    <c:forEach items="${classBatchInfoList.list}" var="classBatchInfo">
                        <tr>
                            <td><a href="viewClass?id=${classBatchInfo.getClassId()}">${classBatchInfo.getClassCode()}</a></td>
                            <td>${classBatchInfo.getLocationName()}</td>
                            <td>${classBatchInfo.getStatus()}</td>
                            <td>${classBatchInfo.getExpectedStartDate()}</td>
                            <td>${classBatchInfo.getExpectedEndDate()}</td>
                            <td>${classBatchInfo.getActualStartDate()}</td>
                            <td>${classBatchInfo.getActualEndDate()}</td>
                            <td>${classBatchInfo.getClassadminRemarks()}</td>
                            <td>${classBatchInfo.getTrainerRemarks()}</td>

                        </tr>

                    </c:forEach>
                </table>
                <c:if test="${classBatchInfoList.totalPages > 1}">
                    <div class="page-navigator">
                        <c:forEach items="${classBatchInfoList.navigationPages}" var="page">
                            <c:if test="${page != -1 }">
                                <a href="searchClass?page=${page}" class="nav-item">${page}</a>
                            </c:if>
                            <c:if test="${page == -1 }">
                                <span class="nav-item"> ... </span>
                            </c:if>
                        </c:forEach>

                    </div>
                </c:if>
                <c:if test="${not empty message}">
                    <div class="message" style="color: blue; font-size: 90%; font-style: italic;">${message }</div>
                </c:if>
            </div>

        </div>
    </div>

</body>

</html>