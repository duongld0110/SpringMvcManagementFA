<%@page session="false"%>

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
	  <div style="color:red; font-size: 22px">${messageAccessDenied}</div>
 	  <span><a href="classList"> Back </a></span>
   	
   </div>
   </div>
</body>
</html>