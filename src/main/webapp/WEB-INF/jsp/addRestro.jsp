<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Restro - Online Restro</title>
</head>
<body>
<jsp:include page="dashboard.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="card p-3 m-3" >
  <div class="card-body">
    <h5 class="card-title" >Create Restro</h5>
    <form method="post" action="/client/restro">
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Restro Name</label>
    <div class="col-sm-10">
      <input type="text" name='name' class="form-control" id="name" value="${name }" placeholder="Restro Name">
    </div>
  </div>
  
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