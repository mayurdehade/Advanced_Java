<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="css/register-style.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="container">
    <div class="title">Add Product</div>
    <div class="content">
      <form action="add-product" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Product Name</span>
            <input type="text" placeholder="Product Name" name="productName" required>
          </div>
          <div class="input-box">
            <span class="details">Category</span>
            <input type="text" placeholder="Category" name="productCategory" required>
          </div>
          <div class="input-box">
            <span class="details">Quantity</span>
            <input type="text" placeholder="Quantity" name="productQty" required>
          </div>
          <div class="input-box">
            <span class="details">Price</span>
            <input type="text" placeholder="Price" name="productPrice" required>
          </div>
          <div class="input-box">
            <span class="details">Description</span>
            <input type="text" placeholder="Description" name="productDescription" required>
          </div>
          <div class="input-box">
            <span class="details">Manufacturer</span>
            <input type="text" placeholder="Manufacturer" name="manufacturer" required>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Add Product">
        </div>
      </form>
    </div>
  </div>

</body>
</html>