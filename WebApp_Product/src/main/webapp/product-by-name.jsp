<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Product by Name</title>
</head>
<body>
	<form action="get-product">
		Enter Product Name: <input type="text" name="productName"> <input
			type="submit" value="Get Product"> <br>
		
	</form>
	<p>Product Id: ${id}</p><br>
	<p>Product Name: ${name}</p><br>
	<p>Product Qty: ${qty}</p><br>
	<p>Product Price: ${price}</p>
	<br><br>
	<p style="color:red">${error}</p>
</body>
</html>