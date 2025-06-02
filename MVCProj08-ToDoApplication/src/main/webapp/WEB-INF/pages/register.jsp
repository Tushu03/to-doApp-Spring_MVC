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
<form action="register" method="post">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow p-4 rounded rounded-2 border border-3 border-primary" >
                <h2 class="text-center mb-4 bi bi-person-fill"> Register User </h2>
                <table>
                <tr>
                	<td>Username : </td><td><input type="text" class="form-control" required="required" name="name"/><td>
                </tr>
                <tr>
                	<td>Address : </td><td><input type="text" class="form-control" required="required" name="address"/><td>
                </tr>
                 <tr>
                	<td>Contact : </td><td><input type="number" class="form-control" required="required" name="contact"/><td>
                </tr>
                <tr>
                	<td>Email : </td><td><input type="email" class="form-control" required="required" name="email"/><td>
                </tr>
                <tr>
                	<td>Password : </td><td><input type="text" class="form-control" required="required" name="pass"/><td>
                </tr>
                </table>
				


                <div class=" mt-4">
                    <span>Already have an account <a href="loginpage"> Login?</Link></span>
                    <button type="submit" class="btn btn-success w-25 ms-3" style="box-shadow: 5px 5px 5px gray">Register</button>
                   
                 </div>
                  

				<c:if test="${not empty error}">
    				<p style="color: red;">${error}</p>
				</c:if>
            </div>
        </div>
    </div>
</div>

</form>
</div>
</div>


</body>
</html>