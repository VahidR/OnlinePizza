<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean class="Model.UserBean" id="user" scope="session"/>
<td width="200" valign="top" bgcolor="#FFFFCC" cellpadding="0">
    <br><br>
    <a href="<%=response.encodeURL("/OnlinePizza/index.jsp")%>">
     Home
    </a><br>
    <a href="<%=response.encodeURL("/OnlinePizza/ShowFoods?action=showFoods")%>">
     Order Pizza
    </a><br>
    <c:if test="${user.userID ==0}">
        <a href="<%=response.encodeURL("/OnlinePizza/User?action=signUpForm")%>">
            Sing Up
        </a><br>
        <a href="<%=response.encodeURL("/OnlinePizza/userLogin.jsp")%>">
            login
        </a><br>
    </c:if>
    <c:if test="${user.userID !=0}">
        <a href="<%=response.encodeURL("/OnlinePizza/editUserProfile.jsp")%>">
            Edit Profile ${user.userName}
        </a><br>
        <a href="<%=response.encodeURL("/OnlinePizza/User?action=UserLogOut")%>">
            Sign out
        </a><br>
    </c:if>

    <a href="<%=response.encodeURL("/OnlinePizza/admin/index.jsp")%>">
        Admin login
    </a><br>
</td>

