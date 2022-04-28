<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Sign Up</title>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<div class="row p-3">
<div class="col-md-6">
<img alt="Restro Image" class="img-fluid" src="/img/restro.jpg">
</div>
<div class="col-md-6">
<div class="card" >
  <div class="card-body">
    <h5 class="card-title" >Client Sign Up</h5>
    




<form method="post" action="/public/client/signup" >
  <div class="form-group row">
    <label for="name" class="col-sm-12 col-form-label">Name</label>
    <div class="col">
      <input type="text" class="form-control" name="name" id="name" placeholder="Name">
    </div>
  </div>
   <div class="form-group row">
    <label for="email" class="col-sm-12 col-form-label">Email</label>
    <div class="col">
      <input type="email" class="form-control" name="email" id="email" placeholder="Email">
    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-12 col-form-label">Password</label>
    <div class="col">
      <input type="password" class="form-control" name="password" id="password" placeholder="Password">
    </div>
  </div>
   <div class="form-group row">
    <label for="phoneNumber" class="col-sm-12 col-form-label">Phone Number</label>
    <div class="col">
      <input type="number" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="Phone Number">
    </div>
  </div>
  
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
  <div id='paymentMsg' class="alert alert-success" role="alert" >
<h6></h6><%=request.getParameter("status") %>
</div>
 <!-- <div class="form-group row">
    
  </div>  -->
<br>

	

  
  <div class="form-group row">
    <div class="col">
      <input type="submit" class="btn btn-primary" value="Sign Up">
    </div>
  </div>
</form>
  </div>
</div>
</div>

</div>









</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>