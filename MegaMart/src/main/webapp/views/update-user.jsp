<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>Update User</title>
    <link rel="stylesheet" href="../css/register-style.css">
   </head>
<body>
  <div class="container">
    <div class="title">Update User</div>
    <div class="content">
      <form action="update-user" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Full Name</span>
            <input type="text" value="${user.name}" name="name" required>
          </div>
          <div class="input-box">
            <span class="details">Username</span>
            <input type="text" value="${user.username}" name="username" readonly>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" value="${user.email}" name="email" required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="text" value="${user.phoneNumber}" name="phoneNumber" required>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input type="text" value="${user.password}" name="password" required>
          </div>
          <div class="input-box">
            <span class="details">Confirm Password</span>
            <input type="text" value="${user.password}" required>
          </div>
        </div>
        <div class="gender-details">
          <input type="radio" name="gender" id="dot-1" value="Male" checked>
          <input type="radio" name="gender" id="dot-2" value="Female">
          <input type="radio" name="gender" id="dot-3" value="Prefer not to say">
          <span class="gender-title">Gender</span>
          <div class="category">
            <label for="dot-1">
            <span class="dot one"></span>
            <span class="gender">Male</span>
          </label>
          <label for="dot-2">
            <span class="dot two"></span>
            <span class="gender">Female</span>
          </label>
          <label for="dot-3">
            <span class="dot three"></span>
            <span class="gender">Prefer not to say</span>
            </label>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Save">
        </div>
      </form>
    </div>
  </div>

</body>
</html>