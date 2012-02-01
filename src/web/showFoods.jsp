<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_home.jsp" />

<!-- start the middle column -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page import="java.util.ArrayList" %>
        <script language="Javascript" src="scripts/showFoodsValidation.js"></script>

        <td width ="400" cellpadding="0" colspan="2">
            <font color="red"><h4> ${message} </h4> </font>
    <table border="1" cellpadding="5" align="center">
            <tr bgcolor="FF6600">
                <td><b>Food Name</b></td>
                <td><b>Price</b></td>
            </tr>

            <%--
                 ArrayList foodList= (ArrayList) session.getAttribute("foodList");
                 String rowColor;
                 for(int i=0; i<foodList.size(); i++ )
                      {
                          FoodBean fb= (FoodBean) foodList.get(i);
                          if (i%2==0)
                              rowColor="CCFF33";
                          else
                              rowColor="33FFFF";
            --%>
            <% String rowColor; %>

            <c:forEach var="fb" items="${availableFoodList}" varStatus="status">
                <c:set var="rowColor" value="33FFFF"/>
                <c:if test="${status.index % 2 ==0}">
                <c:set var="rowColor" value="CCFF33"/>
                </c:if>
                <tr bgcolor=${rowColor} >
                    <td>${fb.foodName}<br> ${fb.foodDescription} </td>
                    <td>${fb.foodPrice}</td>
                    <td>
                        <form action="./ShowFoods?action=addToBasket" method="Post">
                        <input type="hidden" name="foodID"
                                value=${fb.foodID} >
                        <input type="hidden" name="foodName"
                                value=${fb.foodName} >
                        <input type="hidden" name="foodPrice"
                                value=${fb.foodPrice} >
                        <input type=text size=2 name="quantity"
                                value=1>
                        <input type="hidden" name="page" value="showFoods">
                        <script language="javascript">
                            document.write('<input type="button" value="Add to my basket" onClick="validate(this.form)">');
                        </script>
                        <noscript>
                        <input type="submit" value="Add to my basket">
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

