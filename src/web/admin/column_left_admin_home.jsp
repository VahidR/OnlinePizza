<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean class="Model.UserBean" id="user" scope="session"/>

<td width="150" valign="top" bgcolor="#FFFFCC" cellpadding="0">
    <br><br>
    <a href="<%=response.encodeURL("/OnlinePizza/index.jsp")%>">
     Home
    </a><br>
    <a href="<%=response.encodeURL("/OnlinePizza/AddFood?action=Add")%>">
     Add Food
    </a><br>
    <a href="<%=response.encodeURL("/OnlinePizza/AddFood?action=AddIng")%>">
     Add Ingredient
    </a><br>
    
</td>

