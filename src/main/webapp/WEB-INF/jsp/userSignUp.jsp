<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Sign Up</title>
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
    <h5 class="card-title" >User Sign Up</h5>
    




<form method="post" action="/public/user/signup" >
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