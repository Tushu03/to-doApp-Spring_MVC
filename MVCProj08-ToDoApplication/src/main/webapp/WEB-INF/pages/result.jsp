<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Weather Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">


<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow p-4">
                <h2 class="text-center mb-4 bi bi-person"> Employee Data </h2>
				<ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <strong>Desigation :</strong> ${desg}
                    </li>
                    <li class="list-group-item">
                        <strong>Salary :</strong> ${sal}
                    </li>
                    <li class="list-group-item">
                        <strong>Employee :</strong>  ${emp}
                    </li>
                    
                </ul>


                <div class="text-center mt-4">
                    <a href="./" class="btn btn-primary">Register Another Employee</a>
                   
                 </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
