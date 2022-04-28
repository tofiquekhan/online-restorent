<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Order</title>
</head>
<body>
<jsp:include page="dashboard.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="card p-3 m-3">
				<div class="card-body">
<h5 class="card-title">Orders</h5>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">User</th>
      <th scope="col">Dishes</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Mark</td>
      <td>Otto</td>
    </tr>
    <tr>
      <td>Jacob</td>
      <td>Thornton</td>
    </tr>
    <tr>
      <td>Larry</td>
      <td>the Bird</td>
    </tr>
  </tbody>
</table>


</div>
</div>
</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>