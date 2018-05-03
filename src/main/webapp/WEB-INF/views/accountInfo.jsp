<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/fragment/lib.jsp"></jsp:include>
</head>
<body>
	 <div class="container-fluid">
         <jsp:include page="header.jsp"></jsp:include>

        <div class="row">
            <div class="col-md-2">
                <jsp:include page="menu.jsp"></jsp:include>
            </div>
	  <div class="page-title">Account Info</div>
 
   <div class="account-container">
       <ul>
           <li>User Name: ${pageContext.request.userPrincipal.name}</li>
           <li>Role:
               <ul>
                   <c:forEach items="${userDetails.authorities}" var="auth">
                       <li>${auth.authority }</li>
                   </c:forEach>
               </ul>
           </li>
       </ul>
   </div>
   </div>
   </div>
</body>
</html>