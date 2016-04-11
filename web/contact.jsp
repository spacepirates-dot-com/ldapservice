<%--
/*
 * Copyright 2012, Scott Douglass <scott@swdouglass.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * on the World Wide Web for more details:
 * http://www.fsf.org/licensing/licenses/gpl.txt
 */
    Document   : contact
    Created on : Jun 9, 2012, 8:04:31 AM
    Author     : scott
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script type="text/javascript"><!--
      function formCheck()
      {
        if (document.entryForm.firstName.value == "") {
          alert("A first name is required.");
          return false;
        }

        if (document.entryForm.lastName.value == "") {
          alert("A last name is required.");
          return false;
        }

        if (document.entryForm.displayName.value == "") {
          alert("A display name is required.");
          return false;
        }
      }
      //--></script>
  </head>
  <body>
    <form name="entryForm" action="contact" method="post" onSubmit="return formCheck()">
      <input type="hidden" name="uid" value="<%="id" + new Date().getTime()%>">
      <div class="control">
        <table border="0" cellspacing="0">
          <tr>
            <td>
              <b>First Name (required):</b><br>
              <input type="text" name="firstName" size="16">
            </td>
            <td>
              <b>Last Name (required):</b><br>
              <input type="text" name="lastName" size="16">
            </td>
          </tr>
          <tr>
            <td>
              <b>Nickname:</b><br>
              <input type="text" name="nickName" size="16">
            </td>
            <td>
              <b>Display Name (required):</b><br>
              <input type="text" name="displayName" size="16">
            </td>
          </tr>
          <tr>
            <td>
              <b>Primary E-mail:</b><br>
              <input type="text" name="primaryEmail" size="25">
            </td>
            <td>
              <b>Secondary E-mail:</b><br>
              <input type="text" name="secondaryEmail" size="25">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <b>Use HTML E-mail:</b><br>
              <input type="checkBox" name="useHtml" >
            </td>
          </tr>
          <tr>
            <td>
              <b>Home Phone:</b><br>
              <input type="text" name="homePhone" size="16">
            </td>
            <td>
              <b>Work Phone:</b><br>
              <input type="text" name="workPhone" size="16">
            </td>
          </tr>
          <tr>
            <td>
              <b>Mobile Number:</b><br>
              <input type="text" name="mobile" size="16">
            </td>
            <td>
              <b>Pager Number:</b><br>
              <input type="text" name="pager" size="16">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <b>Fax Number:</b><br>
              <input type="text" name="faxNumber" size="16">
            </td>
          </tr>
        </table>
      </div>
      <div class="control">
        <table>
          <tr><td><b>Work Address</b></td></tr>
          <tr>
            <td colspan="2">
              <b>Line 1:</b><br>
              <input type="text" name="postalAddress" size="25">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <b>Line 2:</b><br>
              <input type="text" name="postalAddress2" size="25">
            </td>
          </tr>
          <tr>
            <td>
              <b>City:</b><br>
              <input type="text" name="localityName" size="25">
            </td>
            <td>
              <b>State:</b><br>
              <input type="text" name="state" size="16">
            </td>
          </tr>
          <tr>
            <td>
              <b>Postal Code:</b><br>
              <input type="text" name="postalCode" size="10">
            </td>
            <td>
              <b>Country:</b><br>
              <input type="text" name="country" size="16">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <b>Work URL:</b><br>
              <input type="text" name="workUrl" size="16">
            </td>
          </tr>
        </table>
      </div>
      <div class="control">
        <table>
          <tr>
            <td>
              <b>Company:</b><br>
              <input type="text" name="company" size="16">
            </td>
          </tr>
          <tr>
            <td>
              <b>Department:</b><br>
              <input type="text" name="group" size="16">
            </td>
          </tr>
          <tr>
            <td>
              <b>Title:</b><br>
              <input type="text" name="title" size="16">
            </td>
          </tr>
        </table>
      </div>
      <div class="control">
        <table>
          <tr>
            <td>
              <b>Custom 1:</b><br>
              <input type="text" name="custom1" size="16">
            </td>
            <td>
              <b>Custom 2:</b><br>
              <input type="text" name="custom2" size="16">
            </td>
          </tr>
          <tr>
            <td>
              <b>Custom 3:</b><br>
              <input type="text" name="custom3" size="16">
            </td>
            <td>
              <b>Custom 4:</b><br>
              <input type="text" name="custom4" size="16">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <b>Description:</b><br>
              <input type="text" name="description" size="40">
            </td>
          </tr>
        </table>
      </div>
      <table border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="left"><input type="button" name="cancel" value="Cancel" onClick="location.href='contact.jsp';"></td>
          <td align="center"><input type="reset" name="revert" value="Reset Form"></td>
          <td align="right"><input type="submit" name="save" value="Save"></td>
        </tr>
      </table>
  </body>
</html>
