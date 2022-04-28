<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home - Online Restro</title>
</head>
<body>
<jsp:include page="userHeader.jsp"></jsp:include>
<div class="container">
<div class="row">

<div class="card p-3 m-3">
<h5 class="card-title" align="center">Search Restro</h5>
				<div class="card-body">
<form method="post" action="" >
  <div class="form-group row">
  <div class="col-sm-3"></div>
  <div class="col-sm-5">
  
  <input id="searchRestro" class=" form-control" name="searchRestro">
  

  </div>
  <div class="col-sm-2">
      <input  type="button" class="btn btn-primary" value="Search">
    </div>
    <div class="col-sm-3"></div>
  </div>
</form>


	
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">Searched Restro</h5>

<!-- Restro Name Card -->
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">Restro Name</h5>


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