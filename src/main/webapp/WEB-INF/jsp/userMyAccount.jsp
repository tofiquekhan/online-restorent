<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account - Online Restro</title>
</head>
<body>
<jsp:include page="userHeader.jsp"></jsp:include>
<jsp:useBean id="user" class="com.webkorps.onlinerestorent.entity.User" scope="session"></jsp:useBean>
<div class="container">
<div class="row">
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">My Account</h5>
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">Change Password</h5>
<form method="post" action="/user/changepassword" >
<input type="hidden" name="id" value="<%=user.getId()%>">
  <div class="form-group row">
    <label for="name" class="col-sm-12 col-form-label">New Password</label>
    <div class="col">
      <input type="password" class="form-control" name="newPassword" id="name" placeholder="New Password">
    </div>
  </div>
  
   <div class="form-group row pt-2">
    <div class="col">
      <input type="submit" class="btn btn-primary" value="Change Password">
    </div>
  </div>
  </form>
</div>
</div>
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">Delete Account</h5>
 <form action="/user/delete" method="post">
 <input type="hidden" name="id" value="<%=user.getId()%>">
 <input type="submit" class="form-control btn btn-dark" value="Delete Account">
 
 </form>

</div>
</div>

</div>
</div>
</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>