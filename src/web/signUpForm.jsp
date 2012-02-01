
<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_home.jsp" />

<!-- start the middle column -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Model.UserBean" %>

<script type="text/javascript" language="JavaScript" src="scripts/signupValidationForm.js"></script>

<td colspan="2">
        <h1>Please first do registration to be able to make an order!</h1>
        <font color="red">
            <p><i>${message}</i></p></font>
        
            <form action="./User?action=RegisterUser" method="post">
              <table border ="0" cellpadding="5">
                  <tr>
                     <td></td>
                     <td align = "left">Please fill out all the fields which are
                          specified by <font color="red">*</font> </td>
                  </tr>
                  <tr>
                       <td align="right"> User Name </td>
                       <td><input type="text" name="userName" size="20" maxlength="20" 
                                  value="${user.userName}">
                       <font color ="red">*</font></td>
                  </tr>
                   <tr>
                        <td align="right"> Password </td>
                        <td><input type="password" name="password" size="10"
                                   value="${user.password}">
                         <font color="red">*</font></td>
                   </tr>
                   <tr>
                       <td align="right"> Confirm password </td>
                       <td><input type="password" name="password2" size="10"
                                  value="${user.password}">
                           <font color="red">*</font></td>

                   </tr>
                   <tr>
                         <td align="right"> First Name </td>
                         <td><input type="text" name="firstName" size="10"
                                    value="${user.firstName}">
                          <font color="red">*</font></td>
                   </tr>
                   <tr>
                           <td align="right"> Last Name </td>
                           <td><input type="text" name="lastName" size="10"
                                      value="${user.lastName}">
                           <font color="red">*</font></td>
                    </tr>
                    <tr>
                           <td align="right"> Email Address </td>
                           <td><input type="text" name="email" size="20"
                                      value="${user.email}">
                             <font color="red">*</font></td>
                   </tr>
                   <tr>
                            <td align="right"> Address </td>
                            <td><input type="text" name="address" size="50"
                                       value="${user.address}">
                             <font color="red">*</font></td>
                   </tr>
                   <tr>
                            <td align="right"> Postal Code </td>
                            <td><input type="text" name="postalCode" size="10"
                                       value="${user.postalCode}">
                             <font color="red">*</font></td>
                   </tr>
                    <tr>
                            <td align="right"> City </td>
                             <td><input type="text" name="city" size="20"
                                        value="${user.city}">
                             <font color="red">*</font></td>
                   </tr>
                    <tr>
                           <td align="right"> Telephone Number </td>
                           <td><input type="text" name="telephone" size="20"
                                      value="${user.telephone}">
                            <font color="red">*</font></td>
                   </tr>
                    <tr>
                           <td align="right"></td>
                           <td>
                               <script language="javascript">
                                     document.write('<input type="button" value="Register" onClick="validate(this.form)">');
                                </script>
                                <noscript>
                                    <input type="submit" value="Register">
                                 </noscript>
                                               &nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" value="Reset"></td>
                   </tr>
           </table>
      </form>
</td>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />
