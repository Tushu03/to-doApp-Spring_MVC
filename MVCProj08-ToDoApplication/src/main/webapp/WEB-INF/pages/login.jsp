<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    
    <!-- Toastify CSS and JS -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
    
</head>
<body>
<div class="mx-auto">
<div class="bg-image">
<form action="login" method="post">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow p-4 rounded rounded-2 border border-3 border-primary" >
                <h2 class="text-center mb-4 bi bi-person-fill"> Login User </h2>
                
                <table>
                <tr>
                	<td>Username : </td><td><input type="text" class="form-control" required="required" name="name"/><td>
                </tr>
                <tr>
                	<td>Password : </td><td><input type="text" class="form-control" required="required" name="pass"/><td>
                </tr>
                </table>
				


                <div class=" mt-4">
                    <span>Don't have an account <a href="registerpage"> New user? </a></span>
                    <button type="submit" class="btn btn-warning w-25 ms-3" style="box-shadow: 5px 5px 5px gray">Login</button>
               
                 
            </div>
        </div>
    </div>
</div>

</form>
</div>
</div>


</body>
<c:if test="${not empty success}">
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

<c:if test="${not empty error}">
    <script>
        Toastify({
            text: "❌ ${fn:escapeXml(error)}",
            duration: 5000,
            gravity: "top",
            position: "right",
            backgroundColor: "linear-gradient(to right, #ff5f6d, #ffc371)", // red-orange gradient
            close: true,
            stopOnFocus: true
        }).showToast();
    </script>
</c:if>
</html>