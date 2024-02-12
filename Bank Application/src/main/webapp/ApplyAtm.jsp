<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="comman_programs.BeanClass"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Displaying ATM Card Details</title>
   <style>
		.container
		{
			display: flex;
			flex-wrap: wrap;
			justify-content: center;
			align-items: center;
			gap: 20px;
			padding: 20px;
		}
		.employee-card
		{
			width: 500px;
			background-color: #f5f5f5;
			border-radius: 10px;
			box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
			overflow: hidden;
		}
		.employee-img
		{
			width: 100%;
			height: 300px;
			object-fit: cover;
		}
		.employee-info
		{
			padding: 20px;
		}
		.employee-name
		{
			font-size: 24px;
			font-weight: bold;
			margin-bottom: 10px;
		}
		.employee-title
		{
			font-size: 16px;
			font-style: italic;
			margin-bottom: 10px;
		}
		.employee-stats
		{
			display: flex;
			flex-direction: column;
			margin-bottom: 10px;
		}
		.employee-stats-item
		{
			font-size: 16px;
			margin-bottom: 5px;
		}
        a
        {
            background-color: #3b5998;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 30%;
			text-align: center;
        }
        a:hover
        {
             background-color: #2d4373;
        }
	</style>
</head>
<body>
	<div class="container">
		<div class="employee-card">
			<img src="Project Image/Generate ATM.png" alt="card image" class="employee-img">
			<div class="employee-info">
     <%
        BeanClass bc=(BeanClass)request.getAttribute("BeanClass");
        session.invalidate();
        if(request.getAttribute("Message")!=null)
        {
        	out.println(request.getAttribute("Message"));
        }
     %>
				<div class="employee-name">Name : <%=bc.getName().toUpperCase()%></div>
				<div class="employee-title">Account No : <%=bc.getAccountNo()%></div>
				<div class="employee-stats">
					<div class="employee-stats-item">ATM Card No : <%=bc.getATMcardNo()%></div>
					<div class="employee-stats-item">Expiry Date : <%=bc.getExpiryDate()%></div>
					<div class="employee-stats-item">CVV : <%=bc.getCvv()%></div><br>
					<a href="Main.html">Main Page</a><br>
					<a href="BankWelcomePage.html">Home Page</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>