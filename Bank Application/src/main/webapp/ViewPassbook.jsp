<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="comman_programs.BeanClass"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Account Passbook Display</title>
    <style>
         body
         {
	         margin: 0;
	         padding: 0;
	         font-family: Arial, sans-serif;
         }
         header
         {
	         background-color: #336699;
	         color: #fff;
	         padding: 20px;
         }
         main
         {
	         max-width: 800px;
	         margin: 0 auto;
	         padding: 20px;
	         display: flex;
	         flex-direction: column;
	         align-items: center;
         }
         .customer-info
         {
	         display: flex;
	         flex-direction: row;
	         align-items: center;
         }
         .customer-image
         {
	         margin-right: 20px;
         }
         .customer-image img
         {
	         max-width: 400px;
	         max-height: 300px;
	         border-radius: 50%;
         }
         .customer-details h2
         {
	         margin-top: 0;
         }
         .customer-details p
         {
	         margin-bottom: 10px;
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
      BeanClass bc=(BeanClass)request.getAttribute("BeanClass");
      session.invalidate();
    %>
	<header>
		<h1>Account Passbook Display</h1>
	</header>
	<main>		
		<section class="customer-info">
			<div class="customer-image">
				<img src="<%=bc.getDbPhoto()%>" alt="Customer Image">
			</div>
			<div class="customer-details">
				<h2>Customer Information</h2>
				<p>Name : <%=bc.getName()%></p>
				<p>Account No : <%=bc.getAccountNo()%></p>
				<p>Account Balance : <%=bc.getAccountBalance()%></p>
				<p>Father Name : <%=bc.getFatherName()%></p>
				<p>Aadhaar No : <%=bc.getAadhaarNo()%></p>
				<p>Date Of Birth :<%=bc.getDateOfBirth()%></p>
				<p>Contact No :<%=bc.getContactNo()%></p>
				<p>Email Id :<%=bc.getEmailId()%></p>
				<p>Gender :<%=bc.getGender()%></p>
				<p>Occupation :<%=bc.getOccupation()%> </p>
				<p>Account Type :<%=bc.getAccountType()%> </p>
				<p>Nominee :<%=bc.getNominee()%> </p>
				<p>Address :<%=bc.getAddress()%> </p>
				<p>Account Opening Date :<%=bc.getOpeningDate()%></p><br>
                <a href="Main.html">Main Page</a>
	            <a href="BankWelcomePage.html">Home Page</a>
			</div>
		</section>
	</main>
</body>
</html>