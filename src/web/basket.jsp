<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_home.jsp" />

<!-- start the middle column -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="Model.*" %>
        <script language="Javascript" src="scripts/showFoodsValidation.js"></script>


        <td width ="400" cellpadding="0" colspan="2">
            
        <h1>You've Added the following food to your basket!</h1>
        <%-- <h2>${message}</h2> --%>
        <%--
            // get parameter from reqest
            String foodID = request.getParameter("foodID");
            String quantity = request.getParameter("quantity");
            String foodName = request.getParameter("foodName");
            //int quantity=Integer.parseInt(quantityS);
        --%>
        <%--<h3 align="center" > You have <%=quantity %>
             number of Food with Id in your basket <%=foodID %>
        </h3>
        --%>
        <font color="red"> <h4> ${message} </h4></font>
        <c:if test="${(totalPrice > 0) }">
            <h4 align="right"> <a href="<%=response.encodeURL("/OnlinePizza/ShowFoods?action=finalizeBasket")%>"> finalize your basket </a></h4>
            <table border="1" cellpadding="5" align="center">
                <tr bgcolor="FF6600">
    <!--                <td><b>Food ID</b></td>-->
                    <td><b> Food Name</b></td>
                    <td><b> Item Price</b></td>
                    <td><b> Quantity</b></td>
                    <td><b> Price</b></td>
                    <td><b> Edit </b></td>
                    <td><b> Remove </b></td>
                </tr>
                <% String rowColor; %>
                <c:forEach var="ib" items="${basketList}" varStatus="status">
                        <c:set var="rowColor" value="33FFFF"/>
                        <c:if test="${status.index % 2 ==0}">
                        <c:set var="rowColor" value="CCFF33"/>
                        </c:if>
                        <tr bgcolor=${rowColor} >
                             <td>${ib.foodName}</td>
                             <td>${ib.foodPrice}</td>
                            <form action="./ShowFoods?action=addToBasket" method="Post">
                                <td><input type="text" name="quantity" value="${ib.quantity}"</td>
                                <td>${ib.foodPrice * ib.quantity}</td>
                                <td>
                                    <input type="hidden" name="foodName" value="${ib.foodName}">
                                    <input type="hidden" name="page" value="editBasket">
                                    <input type="hidden" name="foodID" value=${ib.foodID}>
                                    <input type="hidden" name="foodPrice" value=${ib.foodPrice} >
                                    <script language="javascript">
                                        document.write('<input type="button" value="Edit" onClick="validate(this.form)">');
                                    </script>
                                    <noscript>
                                        <input type="submit" value="Edit">
                                    </noscript>
                                </td>
                            </form>
                            <td>
                                <form action="./ShowFoods?action=remove" method="Post">
                                        <input type="hidden" name="foodName" value="${ib.foodName}">
                                        <input type="hidden" name="foodID" value=${ib.foodID}>
                                        <input type="submit" value="Remove from Basket">
                                </form>
                            </td>
                        </tr>
                </c:forEach>
            </table>
                <h3 align="center">The total Price is: ${totalPrice}</h3>
        </c:if>
                <c:if test="${(totalPrice == 0) || (empty totalPrice) }">
                    <h2 align="center"> Your Basket is Empty </h2>
                </c:if>
</td>
<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />
