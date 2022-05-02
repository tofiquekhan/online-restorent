<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notification - Online Restro</title>
</head>
<body>
<jsp:include page="dashboard.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="card p-3 m-3">
<h5 class="card-title">Notification</h5>
				<div class="card-body">
				<div class="card p-3 m-3">
<h5 class="card-title">Membership</h5>
				<div class="card-body">
<h6>Plan Expire Date :  ${client.getMembership().getExpireDate()}</h6>
</div>
</div>



<div class="card p-3 m-3">
<h5 class="card-title">Order Cancel</h5>
				<div class="card-body">
<h6>Order Id : </h6>
<h6>User Name : </h6>
</div>
</div>





</div>
</div>
</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>