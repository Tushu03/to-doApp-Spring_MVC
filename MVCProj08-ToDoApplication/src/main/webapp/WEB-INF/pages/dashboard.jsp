<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Boot MVC</title>
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
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<!-- Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>
<body>

<div class="bg-image"></div>

<div class="container mt-3">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow p-4 border-primary border-3 rounded-4">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h2 class="bi bi-person-fill"> Hello, ${user}</h2>                    
                      <form action="logout" method="post">
                      	<a class="btn btn-primary" href="appPage"> Add Appointment</a>
                        <button type="submit" class="btn btn-danger bi bi-box-arrow-right"> Logout</button>
                    </form>
                </div>
                <div class="mt-3">
	                <c:if test="${not empty appointments}">
						    <h4>Your Appointments</h4>
						    <table class="table caption-top table-hover">
						    	<thead>
							   		<tr>
								    	<th>
								    		Title								    		
								    	</th>
								    	<th>
								    		Date								    		
								    	</th>
								    	<th>
								    		Notes								    		
								    	</th>
								    	<th></th>
								    	<th>
								    		Actions								    		
								    	</th>
							    	
							    	</tr>
							    	<c:forEach var="appointment" items="${appointments}">
						            <tr>
						            	 <td>${appointment.title} </td>
						                
						                 <td>${appointment.appDate}</td>
						                 <td>${appointment.note}<td>
						                 <td><a href="appointments/edit/${appointment.id }" class="btn btn-warning mx-1 bi bi-pen-fill"></a>
						                 	 <a href="${pageContext.request.contextPath}/appointment/deleteConfirm/${appointment.id}" class="btn btn-danger mx-1 bi bi-trash-fill"></a>
						                 </td>
						                 
						                 
						            </tr>
						        	</c:forEach>
						    		
						    	</thead>
						    	
						    </table>
						    
					</c:if>
	
					<c:if test="${empty appointments}">
					    <div class="alert alert-info mt-3">
					        You have no appointments.
					    </div>
					</c:if>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
