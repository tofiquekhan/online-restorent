<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Membership Plan</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>

<div class="container">
		<div class="row">

			<div class="card p-3 m-3">
				<div class="card-body">
					<table class="table">
						<h5 class="card-title">Membership Plans</h5>
						<thead class="thead-dark">
						 
							<tr>
								<th scope="col">Plan Name</th>
								<th scope="col">Plan Price</th>
								<th scope="col">Plan Validity</th>
							</tr>
							
						</thead>
						<tbody>
							
<c:forEach items="${membershipPlans}" var="membershipPlan">
    <tr>
      <td><c:out value="${membershipPlan.getName()}"/></td>
      <td> <c:out value="${membershipPlan.getPrice()}"/></td>
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