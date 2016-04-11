<%--
    Document   : index
    Created on : Jun 6, 2012, 9:14:12 PM
    Author     : scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LDAP Service</title>
  </head>
  <body>
    <a href="<%=request.getContextPath()%>/addressbook">Address Book (all contacts in XML or JSON)</a>
    <p><a href="<%=request.getContextPath()%>/contact.jsp">Add Contact Form</a>
    </p>
  </body>
</html>
