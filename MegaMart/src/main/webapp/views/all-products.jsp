<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>All Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<nav class="navbar navbar-expand-lg" style="background-color: #16A085;">
	  <div class="container-fluid">
	    <a class="navbar-brand ms-5" href="#">MegaMart</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse justify-content-end me-5" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link" href="/get-all-users">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/get-all-users">All Users</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/register">Add User</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page">All Products</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/new-product">Add Product</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="table-responsive mx-5 mt-3" >
	<center> <p>${msg}</p> </center>
  <table class="table">
	  <thead >
	    <tr>
	      <th scope="col">PRODUCT NAME</th>
	      <th scope="col">CATEGORY</th>
	      <th scope="col">QUANTITY</th>
	      <th scope="col">PRICE</th>
	      <th scope="col">MANUFACTURER</th>
	      <th scope="col">DESCRIPTION</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${allProducts}" var="p">
	    <tr>
	      <td>${p.productName}</td>
	      <td>${p.productCategory}</td>
	      <td>${p.productQty}</td>
	      <td>${p.productPrice}</td>
	      <td>${p.manufacturer}</td>
	      <td>${p.productDescription}</td>
	      <td>
	      <a class="btn btn-success" href="/delete-product/${p.productId}">DELETE</a>
	      <a class="btn btn-danger" href="/get-product-by-id/${p.productId}">EDIT</a>
	      </td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>