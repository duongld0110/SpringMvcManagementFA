<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Fresh Report</title>
    <jsp:include page="/fragment/lib.jsp"></jsp:include>
    <script>
        function getClassBatchInfoById(id) {
            $("#edit").attr("href", "deliveryManager/editClass?id=" + id);
        }
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
                <div class="row">
                    <div class="col-sm-offset-1 col-sm-2">
                        <a href="deliveryManager/createNewClass" class="btn btn-default">Create</a>
                    </div>
                    <div class="col-sm-2">
                        <a id="edit" href="deliveryManager/editClass" class="btn btn-default">Update</a>
                    </div>
                    <div class="col-sm-2">
                        <a href="" class="btn btn-default">Cancel</a>
                    </div>
                    <div class="col-sm-2">
                        <a href="" class="btn btn-default">View</a>
                    </div>
                    <div class="col-sm-2">
                        <a href="searchClass" class="btn btn-default">Search</a>
                    </div>
                </div>

                <table class="table table-bordered" style="margin-top: 30px">
                    <tr>
                        <th></th>
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
                            <td>
                                <input type="radio" onClick="getClassBatchInfoById(${classBatchInfo.getClassId()})" name="classId" value="${ classBatchInfo.getClassId()}">
                            </td>
                            <td><a href="viewClass?role=${authorityRole }&id=${classBatchInfo.getClassId()}">${classBatchInfo.getClassCode()}</a></td>
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
                                <a href="classList?page=${page}" class="nav-item">${page}</a>
                            </c:if>
                            <c:if test="${page == -1 }">
                                <span class="nav-item"> ... </span>
                            </c:if>
                        </c:forEach>

                    </div>
                </c:if>
                <c:if test="${not empty message}">
                    <div class="message" style="color:blue;font-size:90%;font-style:italic;">${message }</div>
                </c:if>
            </div>

        </div>
    </div>

</body>

</html>