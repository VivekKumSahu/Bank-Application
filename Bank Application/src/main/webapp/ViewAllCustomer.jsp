<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.ArrayList"
         import="comman_programs.BeanClass"%>
<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
     <title>Printing All Customer</title>
     <style>
		 table
		 {
			 font-family: Arial, sans-serif;
			 border-collapse: collapse;
			 width: 100%;
		 }
		 td,th
		 {
			 border: 1px solid #ddd;
			 text-align: left;
			 padding: 8px;
		 }
		 tr:nth-child(even)
		 {
			 background-color: #f2f2f2;
		 }
		 th
		 {
			 background-color: #4CAF50;
			 color: white;
		 }
		 div
		 {
             width:900px;              
             background:#ffffff;
             margin:auto;
             border-radius:25px;
             padding:20px;
             box-shadow:5px 5px 10px #808000;
         }
         a
         {
             background-color: #4CAF50;
             color: #fff;
             padding: 10px;
             border: none;
             text-align:center;
             border-radius: 5px;
             font-size: 20px;
             margin-top: 10px;
             cursor: pointer;
         }
         a:hover
         {
             background-color: #3e8e41;
         }
	</style>
</head>
<body>
    <%
       ArrayList<BeanClass> al=(ArrayList<BeanClass>)request.getAttribute("ArrayList");
       if(al==null)
       {
    %>
    	  <h1><strong style='color:#ff0f0f;'>Not a single customer open account in the bank</strong></h1>
   <%
       }
       else
       {
   %>
    	   <h1>Customer Record Table</h1>
    		   <div>
    		   	<table>
    		   		<thead>
    		   			<tr>
    		   			     <th>Account No</th>
    		   				 <th>Customer Name</th>
    		   				 <th>Account Balance</th>
    		   				 <th>Aadhaar No</th>
    		   				 <th>Contact No</th>
    		   			</tr>
    		   	   </thead>
   <%
    		       	   for(BeanClass z:al)
    		       	   {
   %>
    		   	   <tbody>
    		   			 <tr>
    		   				<td><%=z.getAccountNo()%></td>
    		   				<td><%=z.getName()%></td>
    		   				<td><%=z.getAccountBalance()%></td>
    		   				<td><%=z.getAadhaarNo()%></td>
    		   				<td><%=z.getContactNo()%></td>    		   				
    		   				<td><img src="<%=z.getDbPhoto()%>" width="150px" height="150px"/></td>
    		   			 </tr>
    		   	   </tbody>
   <%
    		       	   }
   %>
    		       </table>
    		   </div><br><br>
   <% 
    	}
   %>
   <a href="EmployeeLogoutServlet">Logout</a>
   <a href="EmployeeCheckingFullDetailsOfCustomer.html">View Full Details Of Customer</a>
   <a href="EmployeeOptionPage.html">Main Page</a>
</body>
</html>