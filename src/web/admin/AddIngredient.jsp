<jsp:include page="/includes/header.html" />
<jsp:include page="/admin/column_left_admin_home.jsp" />

<!-- start the middle column -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        
<script language="Javascript" src="scripts/addIngredientValidationForm.js"></script>
        <td width ="400" cellpadding="0" colspan="2">
            <font color="red"><h4> ${message} </h4> </font>
    <table border="1" cellpadding="5" align="center">
            <tr bgcolor="FF6600">
                <td><b>Ingredient Name</b></td>
                <td><b>Ingredient Quantity</b></td>
            </tr>


            <% String rowColor; %>

            <c:forEach var="ib" items="${ingList}" varStatus="status">
                <c:set var="rowColor" value="33FFFF"/>
                <c:if test="${status.index % 2 ==0}">
                <c:set var="rowColor" value="CCFF33"/>
                </c:if>
                <tr bgcolor=${rowColor} >
                    <td>${ib.ingName}</td>
                    <td>${ib.ingQuantity}</td>
                    <td>
                        <form action="./AddFood?action=AddIngredient" method="Post">
                        <input type="hidden" name="ingID"
                                value=${ib.ingID} >
                        <input type="hidden" name="ingName"
                                value=${ib.ingName} >
                        <input type="hidden" name="ingPrice"
                                value=${ib.ingPrice} >
                        <input type=text size=2 name="ingQuantity">

                        <input type="hidden" name="page" value="AddFood">

                        <script language="javascript">
                            document.write('<input type="button" value="Increase Ingredient" onClick="validate(this.form)" >');
                        </script>
                        <noscript>
                        <input type="submit" value="Increase Ingredient">
                        </noscript>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <%-- } --%>
        </table>
</td>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />

