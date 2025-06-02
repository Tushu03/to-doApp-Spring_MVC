<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Weather Result</title>
    <style>
    .bg-image {
        background-image: url('bg-image.jpg');
        background-size: cover;
        height: 100vh;
        width: 100%;
        position: fixed;
        left: 0;
        z-index: -1;
    }
</style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="bg-image">

	
<frm:form action="register" method="post" modelAttribute="emp">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            
				<div class="container">
	                <div class="alert alert-danger alert-dismissible mx-auto rounded w-75" style={{boxShadow: '5px 5px 5px gray'}}>
	                    <h1 class="alert-title">Delete Record</h1>
	                    <p className="alert-description">Are you sure you to delete this record  ${appointment.title} <br></br>${appointment.appDate}</p>
	
	                    <a href="${pageContext.request.contextPath}/appointment/delete/${appointment.id}" class="btn btn-danger mx-2" >Yes</a>
	                    
	                    <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-warning">Cancel</a>
	                </div>
           		 </div>
                
         
        </div>
    </div>
</div>
</frm:form>
</div>


</body>
</html>
