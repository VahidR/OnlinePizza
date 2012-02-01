<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_home.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>

<td width ="400" cellpadding="0" colspan="2">
        <table border="1" cellpadding="5" align="center">
            <tr bgcolor="FF6670">
                <td><b>Ingredient Name</b></td>
                <td><b>Quantity</b></td>
            </tr>
            <c:forEach var="ing" items="${ingredientList}" varStatus="status">
                <c:set var="rowColor" value="33FFFF"/>
                <c:if test="${status.index % 2 ==0}">
                <c:set var="rowColor" value="CCFF33"/>
                </c:if>
                <tr bgcolor=${rowColor} >
                    <td>${ing.ingName}<br>
                    <td>${ing.ingQuantity}</td>
                    <td>
                        <form action="./ECPGroupTwo?action=Add" method="Post">
                            <input type="submit" value="Add">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>




<jsp:include page="/includes/footer.jsp" />
