<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Sign Up</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<div class="row">


<form>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" id="name" placeholder="Name">
    </div>
  </div>
   <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" name="email" id="email" placeholder="Email">
    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" placeholder="Password">
    </div>
  </div>
   <div class="form-group row">
    <label for="phoneNumber" class="col-sm-2 col-form-label">Phone Number</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="Phone Number">
    </div>
  </div>
  <fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0">Membershop</legend>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="membershipPlan" id="plan1" value="1" checked>
          <label class="form-check-label" for="plan1">
            One Month Membership Price 150Rs
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="membershipPlan" id="plan2" value="2">
          <label class="form-check-label" for="plan2">
            Two Month Membership Price 290Rs
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="membershipPlan" id="plan3" value="3">
          <label class="form-check-label" for="plan3">
            Three Month Membership Price 400Rs
          </label>
        </div>
      </div>
    </div>
  </fieldset>
  <div class="form-group row">
    <div class="col-sm-2">Checkbox</div>
    <div class="col-sm-10">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck1">
        <label class="form-check-label" for="gridCheck1">
          Example checkbox
        </label>
      </div>
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
  </div>
</form>


</div>









</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>