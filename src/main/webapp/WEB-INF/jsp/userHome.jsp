<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<form method="post" action="/user/restro/search" >
  <div class="form-group row">
  <div class="col-sm-3"></div>
  <div class="col-sm-5">
  
  <input id="searchRestro" type="text" class=" form-control" name="restroName">
  

  </div>
  <div class="col-sm-2">
      <input  type="submit" class="btn btn-primary" value="Search">
    </div>
    <div class="col-sm-3"></div>
  </div>
</form>
</div> 
</div>

	
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">Searched Restro</h5>
<!-- Restro Name Card -->
<c:forEach items="${restros}" var="restro">
<div class="card p-3 m-3">
<a href="/user/restro/menu/${restro.getId()}">
				<div class="card-body">
<h5 class="card-title">${restro.getName()}</h5>
</div>
</a>
</div>
</c:forEach>


</div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>