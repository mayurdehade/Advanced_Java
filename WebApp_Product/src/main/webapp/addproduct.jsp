<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Products Here</title>
</head>
<body>
	<form action="add-product">
		<table>
			<tr>
				<th>Product Name:</th>
				<td><input type="text" name="productname"></td>
			</tr>
			<tr>
				<th>Product Qty:</th>
				<td><input type="text" name="productQty"></td>
			</tr>
			<tr>
				<th>Product Price:</th>
				<td><input type="text" name="productprice"></td>
			</tr>
			<tr>
				<input type="submit" value="Add Product">
			</tr>
		</table>
	</form>
</body>
</html>