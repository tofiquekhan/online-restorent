<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart- Online Restro</title>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="userHeader.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="card p-3 m-3">
<h5 class="card-title">Cart</h5>
				<div class="card-body">
				

<table class="table">
						<thead class="thead-dark">
						 
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
							</tr>
							
						</thead>
						<tbody>
							
<c:forEach items="${cart}" var="dish">
    <tr>
      <td><c:out value="${dish.key.getName()}"/></td>
      <td> <c:out value="${dish.key.getPrice()}"/></td>
      <td><c:out value="${dish.value} "/></td>
      <%-- <td align="right" ><a href="/user/dish/${restro.getId()}/addToCart/${dish.getId()}" class="btn btn-primary">Add Cart</a></td> --%>
    </tr>
    
   </c:forEach>
   
   <tr>
   <td class="fw-bold">Total Amount</td>
   <td class="fw-bold">${totalAmount}</td>
   <input type="hidden" id="totalAmount" value="${totalAmount}" name="totalAmount"/>
   <td align="right"><button onclick="foodPaymentStart()" type="button" class="btn btn-primary">Payment</button></td>
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