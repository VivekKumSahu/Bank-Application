<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
     <title>Account Created Successful</title>
     <style>
         body
         {
              background-image:url('Project Image/Account created.webp');
              background-repeat:no-repeat;
              background-attachment: fixed;
              background-size:cover;          
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
    <%
       out.println(request.getAttribute("Message"));
       session.invalidate();
    %>
    <a href="Main.html">Main Page</a>
	<a href="BankWelcomePage.html">Home Page</a>
</body>
</html>