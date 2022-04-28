<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account - Online Restro</title>
</head>
<body>
<jsp:include page="dashboard.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">My Account</h5>
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">My Plan</h5>
<h6>Purchase Date : ${client.getMembership().getPurchaseDate()}</h6>
<h6>Expire Date : ${client.getMembership().getExpireDate()}</h6>
<h6>Price of Plan : ${client.getMembership().getPrice()}</h6>

</div>
</div>
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">Renew Plan</h5>
  <div class="form-group row">
  <label for="membershipPlan" class="col-sm-12 col-form-label">Membership Plan</label>
  <div class="col-sm-9">
  <select id="membership" class="custom-select form-control" name="membershipPlan">
  <option selected value="">Select Membership Plan</option>
  <option value="plan1">One Month Membership Price 150Rs</option>
  <option value="plan2">Two Month Membership Price 290Rs</option>
  <option value="plan3">Two Month Membership Price 290Rs</option>
</select>

  </div>
  <div class="col-sm-2">
      <button onclick="paymentStart()" type="button" class="btn btn-primary">Payment</button>
    </div>
  </div>

</div>
</div>

</div>
</div>
</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>