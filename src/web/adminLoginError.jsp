<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_home.jsp" />

<td colspan="2" >

    <form action="<%= response.encodeURL("j_security_check") %>">
            <table align="center" border="0" cellspacing="10">
                <tr>
                    <td align="right">Username:</td>
                    <td align="left"><input type="text" name="j_username" size="20"></td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td align="left"><input type="password" name="j_password" size="20"></td>
                </tr>
                <tr>
                    <td align="right"><input type="submit" value="Login"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
                <tr>
                    <b><font color=red>Invalid Username/Password! Please try again!</font></b>
                </tr>
            </table>
        </form>
</td>

<jsp:include page="/includes/footer.jsp" />
