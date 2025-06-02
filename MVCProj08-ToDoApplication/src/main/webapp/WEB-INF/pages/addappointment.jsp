<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Boot MVC</title>
<style >
	.bg-image{
	  background-image: url('bg-image.jpg');
	  background-size: cover;
	  height: 850px;
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
<div class="mx-auto">
<div class="bg-image">
<form action="appointments/add" method="post">
<div class="container mt-3">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card shadow p-4 rounded rounded-2 border border-3 border-danger" >
          
            	<h2 class="text-center mb-4 bi bi-person-fill"> Add Appointments </h2>
            	<table>
            	<tr>
            	<td>Title : </td><td><input type="text" class="form-control" name="title" required="required"/></td>
            	</tr>
            	<tr>
            	<td>Date And Time : </td><td><input type="datetime-local" class="form-control" name="dateTime" required="required"/></td>
            	</tr>
            	<tr>
            	<td>Note : </td><td><input type="text" class="form-control" name="notes"/></td>
            	</tr>
            	</table>
            	<div class=" mt-4">
            		<button type="submit" class="btn btn-success w-25 ms-4" style="box-shadow: 5px 5px 5px gray">Add</button>
                   
                  	 <a href="dashboard" class="btn btn-warning mx-1" style="box-shadow: 5px 5px 5px gray" > Cancel</a>
                    
                 </div>
            
       
                
                
            </div>
        </div>
    </div>
</div>

</form>
</div>
</div>


</body>
</html>