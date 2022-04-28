<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.webkorps.onlinerestorent.entity.Dish"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dishes - Online Restro</title>
</head>
<body>
	<jsp:include page="dashboard.jsp"></jsp:include>
	<div class="container">
		<div class="row">

			<div class="card p-3 m-3">
				<div class="card-body">
					<table class="table">
						<h5 class="card-title">Dish List</h5>
						<thead class="thead-dark">
						 
							<tr>
								<th scope="col">Dish Name</th>
								<th scope="col">Dish Price</th>
								<th scope="col">Image</th>
							</tr>
							
						</thead>
						<tbody>
							
<c:forEach items="${restro}" var="dish">
    <tr>
      <td><c:out value="${dish.getName()}"/></td>
      <td> <c:out value="${dish.getPrice()}"/></td>
      <td></td>
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