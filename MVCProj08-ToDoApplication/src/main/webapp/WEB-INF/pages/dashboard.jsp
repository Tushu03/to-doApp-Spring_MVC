<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<!-- Toastify CSS and JS -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>

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
                <div class="mt-2">
                	<form action="dashboard" method="get" class="d-flex">
					    <label for="sort" class="me-2 fw-bold sort-down ">Sort by:</label>
					    <select name="sort" id="sort" class="form-select me-2 w-25" onchange="this.form.submit()">
					        <option value="" class="form-control">--Select--</option>
					        <option value="title" class="form-control" ${param.sort == 'title' ? 'selected' : ''}>Title</option>
					        <option value="date" class="form-control" ${param.sort == 'date' ? 'selected' : ''}>Date</option>

					    </select>
					    
					    
					    
					    
					</form>

                </div>
                <div class="mt-3">
	                <c:if test="${not empty appointments.getContent()}">
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
							    	<c:forEach var="appointment" items="${appointments.getContent()}">
						            <tr>
						            	 <td>${appointment.title} </td>
						                
						                 <td>${appointment.appDate}</td>
						                 <td>${appointment.note}<td>
						                 <td><a href="appointments/editPage/${appointment.id }" class="btn btn-warning mx-1 bi bi-pen-fill"></a>
						                 	 <a href="${pageContext.request.contextPath}/appointment/deleteConfirm/${appointment.id}" class="btn btn-danger mx-1 bi bi-trash-fill"></a>
						                 </td>
						                 
						                 
						            </tr>
						        	</c:forEach>
						    		
						    	</thead>
						    	
						    </table>
						    <center>
						    	<c:if test="${appointments.hasPrevious()}">
						    		<a href="dashboard?page=${appointments.getPageable().getPageNumber()-1}">prev</a>
						    	</c:if>
						    	<c:if test="${not appointments.isFirst()}">
						    		<a href="dashboard?page=0">first</a>
						    	</c:if>
						    	
						    	<c:forEach var="i" begin="1" end="${appointments.getTotalPages()-1}" step="1">
						    		[<a href="dashboard?page=${i-1}">${i}</a>]
						    	</c:forEach>
						    	
						    	<c:if test="${not appointments.isLast()}">
						    		<a href="dashboard?page=${appointments.getTotalPages()-1}">last</a>
						    	</c:if>
						    	
						    	<c:if test="${appointments.hasNext()}">
						    		<a href="dashboard?page=${appointments.getPageable().getPageNumber()+1}">last</a>
						    	</c:if>
						    	
						    	
						    	
						    </center>
						    
						    
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
<c:if test="${not empty successMsg}">
    <script>
        Toastify({
            text: "✅ ${fn:escapeXml(successMsg)}",
            duration: 4000,
            gravity: "top",
            position: "right",
            backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)", // green gradient
            close: true,
            stopOnFocus: true
        }).showToast();
    </script>
</c:if>

<c:if test="${not empty errorMsg}">
    <script>
        Toastify({
            text: "❌ ${fn:escapeXml(errorMsg)}",
            duration: 5000,
            gravity: "top",
            position: "right",
            backgroundColor: "linear-gradient(to right, #ff5f6d, #ffc371)", // red-orange gradient
            close: true,
            stopOnFocus: true
        }).showToast();
    </script>
</c:if>


</body>
</html>
