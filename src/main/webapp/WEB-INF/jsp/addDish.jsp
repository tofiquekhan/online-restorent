<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.webkorps.onlinerestorent.entity.Dish"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Dish - Online Restro</title>
</head>
<body>
	<jsp:include page="dashboard.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="card p-3 m-3">
				<div class="card-body">
				<c:choose>
				<c:when test = "${msg == 'success'}">
<div class="alert alert-danger" role="alert">
  First Create Restro
</div>
</c:when>
				<c:when test = "${msg == 'success'}">
				<div class="alert alert-success" role="alert">
				
  Dish Added Successfully
</div>
</c:when>
				<c:when test = "${msg == 'fail'} ">
<div class="alert alert-danger" role="alert">
  Dish did not added Successfully
</div>
				</c:when>
				
				</c:choose>
				
				
					<h5 class="card-title">Add Dish</h5>
					<form method="post" action="/client/restro/dish" enctype="multipart/form-data">
						<!-- Dish Menu Start -->
 <div class="form-group mt-1 row">
    <div class="col-md-6 mb-3">
      <label for="dishName">Dish Name</label>
      <input type="text" name="dishName" class="form-control" id="dishName" placeholder="Dish Name" required>
    </div>
    <div class="col-md-3 mb-3">
      <label for="dishPrice">Price</label>
      <input type="number" name="dishPrice" class="form-control" id="dishPrice" placeholder="Dish Price" required>
    </div>
    <div class="col-md-3 mb-3">
      <label for="dishImage">Image</label>
      <input type="file" name="dishImage" class="form-control" id="dishImage" placeholder="Dish Image">
    </div>
  </div>
<!-- Dish Menu End -->
						<div class="form-group row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</div>
					</form>


				</div>
			</div>


		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>