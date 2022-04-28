<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="col-6">
<!-- Image Comes Here -->
</div>
<div class="col-6">
<div class="card p-3 m-3" >
  <div class="card-body">
    <h5 class="card-title" >Sign In</h5>
<form action="/doLogin" method="post">
  <div class="form-group m-1">
    <label for="email">Email address</label>
    <input type="text" class="form-control" name="username" id="email"placeholder="Enter email">
  </div>
  <div class="form-group m-1">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
  </div>

  <button type="submit" class="m-1 btn btn-primary">Submit</button>
</form>
</div>
</div>






</div>

</div>







</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>