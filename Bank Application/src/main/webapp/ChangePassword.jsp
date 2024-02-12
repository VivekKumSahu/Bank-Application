<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Change Password Form</title>
    <style>
        body
        {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        h1
        {
            text-align: center;
            margin-top: 50px;
            margin-bottom: 50px;
        }
        form
        {
            width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px #ccc;
        }
        label
        {
            display: block;
            margin-bottom: 10px;
        }
        input[type="password"]
        {
            padding: 10px;
            border-radius: 5px;
            border: none;
            margin-bottom: 20px;
            box-shadow: 0px 0px 5px #ccc;
        }
        input[type="submit"]
        {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover
        {
            background-color: #3e8e41;
        }
        a
        {
            background-color: #3b5998;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        a:hover
        {
            background-color: #2d4373;
        }
    </style>
  </head>
<body>
    <strong style='color:#ff0f0f;'>The OTP Will Be Sent To On Your Registered Mail Id Please Check The Mail...</strong>
    <h1>Change Password</h1>
    <form action="PasswordChangeServlet" method="post">
      <label>New Password</label>
      <input type="password" name="newpassword">
      <label>Confirm New Password</label>
      <input type="password" name="confirmpassword">
      <label>Enter OTP</label>
      <input type="text" name="otp"><br><br>      
      <a href="Main.html">Main Page</a>
      <input type="submit" value="Change Password">
    </form>
</body>
</html>