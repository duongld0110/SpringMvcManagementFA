<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

    <div class="page-header">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <span style="font-size: 18px;" class="col-sm-offset-10 col-sm-1" >Hello &nbsp;
           <a href="${pageContext.request.contextPath}/accountInfo" >
                ${pageContext.request.userPrincipal.name} </a> </span>
           <a href="${pageContext.request.contextPath}/logout" >Logout</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
    </div>
