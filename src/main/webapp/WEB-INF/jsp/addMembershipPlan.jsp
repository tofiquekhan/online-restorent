<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="card p-3 m-3">
				<div class="card-body">
				
				<c:if test = "${msg == 'success'}">
				<div class="alert alert-success" role="alert">
				
  Membership Plan Added Successfully
</div>
  </c:if>
				<c:if test = "${msg == 'fail'}">
<div class="alert alert-danger" role="alert">
  Membership Plan did not added Successfully
</div>
				</c:if>
				
				
				
					<h5 class="card-title">Add Membership Plan</h5>
					<form method="post" action="/admin/addmembershipplan">
						<!-- Dish Menu Start -->
 <div class="form-group mt-1 row">
    <div class="col-md-6 mb-3">
      <label for="membershipPlanName">Membership Plan Name</label>
      <input type="text" name="membershipPlanName" class="form-control" id="membershipPlanName" placeholder="Membership Plan Name" required>
    </div>
    <div class="col-md-3 mb-3">
      <label for="membershipPlanPrice">Price</label>
      <input type="number" name="membershipPlanPrice" class="form-control" id="membershipPlanPrice" placeholder="Membership Plan Price" required>
    </div>
    <div class="col-md-3 mb-3">
      <label for="membershipPlanDays">Days</label>
      <input type="numbers" name="membershipPlanDays" class="form-control" id="membershipPlanDays" placeholder="Membership Plan Days">
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