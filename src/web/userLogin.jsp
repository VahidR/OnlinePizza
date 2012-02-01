<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_home.jsp" />

<!-- start the middle column -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Model.UserBean" %>

<script type="text/javascript" language="JavaScript" src="scripts/loginValidationForm.js"></script>

<td colspan="2">
        <h1>Please first do registration to be able to make an order!</h1>
        <font color="red">
            <p><i>${message}</i></p></font>

            <form action="./User?action=UserLogIn" method="post">
              <table border ="0" cellpadding="5">
                  <tr>
                       <td align="right"> User Name </td>
                       <td><input type="text" name="userName" size="20" maxlength="20"
                                  value="${user.userName}"> </td>
                  </tr>
                  <tr>
                        <td align="right"> Password </td>
                        <td><input type="password" name="password" size="10"
                                   value="${user.password}"></td>
                   </tr>
                    <tr>
                           <td align="right"></td>
                           <td>
                               <script language="javascript">
                                     document.write('<input type="button" value="Log in" onClick="loginValidate(this.form)">');
                                </script>
                                <noscript>
                                    <input type="submit" value="Log in">
                                 </noscript>
                                               &nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" value="Reset"></td>
                   </tr>
              </table>
            </form>
                   <br/>
                   <h3> Create <a href="<%=response.encodeURL("/OnlinePizza/User?action=signUpForm")%>">New Account </a> </h3>
</td>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />
