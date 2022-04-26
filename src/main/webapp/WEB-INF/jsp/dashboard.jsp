<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container-fluid">
<div class="row">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/client/restro">Dashboard</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link " aria-current="page" href="/client/restro">Add Restro</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/client/restro/dish">Add Dish</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/client/restro/order">View Order</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/client/restro/notification">Notification</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/client/myaccount">My Account</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/logout">Logout</a>
        </li>
      </ul>
    
    </div>
  </div>
  </nav>
  </div>
  </div>
  
</body>
</html>