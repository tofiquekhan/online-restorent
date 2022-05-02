<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restro</title>
</head>
<body>
<jsp:include page="userHeader.jsp"></jsp:include>
	<div class="container">
		<div class="row">
		
		<div class="card p-3 m-3">
				<div class="card-body">
				<h5 class="card-title">${restro.getName()}</h5>
					</div>
					</div>
		

			<div class="card p-3 m-3">
				<div class="card-body">
					<table class="table">
						<h5 class="card-title">Menu</h5>
						<thead class="thead-dark">
						 
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Price</th>
								<th scope="col">Image</th>
								<th scope="col"></th>
							</tr>
							
						</thead>
						<tbody>
							
<c:forEach items="${dishes}" var="dish">
    <tr>
      <td><c:out value="${dish.getName()}"/></td>
      <td> <c:out value="${dish.getPrice()}"/></td>
      <td></td>
      <td align="right" ><a href="/user/dish/${restro.getId()}/addToCart/${dish.getId()}" class="btn btn-primary">Add Cart</a></td>
    </tr>
   </c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>