<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.ArrayList"
         import="comman_programs.BeanClass"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Printing BalanceInquiry</title>
   <style>
        header
        {
	         background-color: #336699;
	         color: #fff;
	         padding: 20px;
        }
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
        .passbook
        {
	         background-color: #f5f5f5;
	         border-radius: 5px;
	         padding: 20px;
	         margin-bottom: 20px;
        }
        .passbook h2
        {
	         margin-top: 0;
        }
        .passbook table
        {
	         width: 100%;
	         border-collapse: collapse;
	         margin-top: 20px;
        }
        .passbook table th,.passbook table td
        {
	         padding: 10px;
	         text-align: left;
        }
        .passbook table th
        {
	         background-color: #336699;
	         color: #fff;
        }
        .passbook table tbody tr:nth-child(even)
        {
	         background-color: #ddd;
        }
        .passbook table tbody tr:hover
        {
	         background-color: #ccc;
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
    <section class="passbook">
    <header>
			<h2>Passbook Entries</h2>
    </header>
         <section class="customer-info">
         <%
            BeanClass bc=(BeanClass)request.getAttribute("BeanClass");
         %>
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
			 </div>
		 </section>
			  <table>
				  <thead>
					  <tr>
						 <th>Date</th>
						 <th>Description</th>
						 <th>Amount</th>
						 <th>Time</th>
					  </tr>
				  </thead>
	    <%
			ArrayList<BeanClass> al=(ArrayList<BeanClass>)request.getAttribute("ArrayList");
		    for(BeanClass z:al)
  		    {
        %>
			      <tbody>				  
					  <tr>
						 <td><%=z.getOpeningDate()%></td>
						 <td><%=z.getDescription()%></td>
						 <td><%=z.getTransactionAmount()%></td>
						 <td><%=z.getTime()%></td>
					  </tr>					
				  </tbody>			  
		<%
			}
		    session.invalidate();
	    %>
	          </table>			  
    </section>
     <a href="Main.html">Main Page</a>
     <a href="BankWelcomePage.html">Home Page</a>
 </body>
</html>