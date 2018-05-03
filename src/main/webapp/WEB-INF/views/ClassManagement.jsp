<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>

    <jsp:include page="/fragment/lib.jsp"></jsp:include>

    <script>
        $(function() {
            $("#startdatepicker").datepicker();
            $("#enddatepicker").datepicker();
        });
    </script>
    <style>
        .error-message {
            color: red;
            font-size: 90%;
            font-style: italic;
        }
        
        .error {
            display: inline-block;
            color: red;
        }
    </style>
</head>

<body>
    <div class="container-fluid">
         <jsp:include page="header.jsp"></jsp:include>

        <div class="row">
            <div class="col-md-2">
                <h2>${formTitle }</h2>
                <jsp:include page="menu.jsp"></jsp:include>
            </div>

            <div class="col-md-10">
                <h2 id="act">Dynamic Tabs</h2>

                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                    <li><a data-toggle="tab" href="#menu1">General</a></li>
                    <li><a data-toggle="tab" href="#menu2">Details</a></li>
                    <li><a data-toggle="tab" href="#menu3">Budget</a></li>
                    <li><a data-toggle="tab" href="#menu4">Trainee</a></li>
                    <li><a data-toggle="tab" href="#menu5">Audit</a></li>
                </ul>

                <div class="tab-content" style="margin-top: 30px">
                    <div id="home" class="tab-pane in active">
                        <jsp:include page="ClassForm.jsp"></jsp:include>
                    </div>
                    <div id="menu1" class="tab-pane">
                        <h3>Menu 1</h3>
                        <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                    <div id="menu2" class="tab-pane">
                        <h3>Menu 2</h3>
                        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                    </div>
                    <div id="menu3" class="tab-pane">
                        <h3>Menu 3</h3>
                        <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                    </div>
                    <div id="menu4" class="tab-pane">
                        <p>4.</p>
                    </div>
                    <div id="menu5" class="tab-pane">
                        <p>5</p>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <script>
        $(document).ready(function() {
            $(".nav-tabs a").click(function() {
                $(this).tab('show');
            });
            $('.nav-tabs a').on('shown.bs.tab', function(event) {
                var x = $(event.target).text(); // active tab
                if (x == "General") {
                    $("#act").text("Create Class");
                }

            });

            $('#form').validate({ // initialize the plugin
                rules: {
                    className: {
                        required: true,
                        maxlength: 30
                    },
                    expectedStartDate: {
                        required: true,
                        date: true,
                        minlength: 5
                    },
                    expectedEndDate: {
                        required: true,
                        date: true,
                        minlength: 5
                    },
                    classCode: {
                        required: true
                    },
                    detailLocation: {
                        required: true
                    }
                }
            });
        });
    </script>

</body>

</html>