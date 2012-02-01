<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_home.jsp" />

<!-- start the middle column -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="Model.*" %>


        <td width ="400" cellpadding="0" colspan="2">

        <h4> ${message} </h4>
         <c:if test="${not empty servedFoods}">
            <h4 align="Center">  your Order number is ${orderNo}. The following Foods are included in your Order
            </h4>
            <table border="1" cellpadding="5" align="center">
                <tr bgcolor="FF6600">
    <!--                <td><b>Food ID</b></td>-->
                    <td><b> Food Name</b></td>
                    <td><b> Item Price</b></td>
                    <td><b> Quantity</b></td>
                    <td><b> Price</b></td>
                </tr>
                <% String rowColor; %>
                <c:forEach var="ib" items="${servedFoods}" varStatus="status">
                        <c:set var="rowColor" value="33FFFF"/>
                        <c:if test="${status.index % 2 ==0}">
                        <c:set var="rowColor" value="CCFF33"/>
                        </c:if>
                        <tr bgcolor=${rowColor} >
                             <td>${ib.foodName}</td>
                             <td>${ib.foodPrice}</td>
                             <td>${ib.quantity}</td>
                             <td>${ib.foodPrice * ib.quantity}</td>
                        </tr>
                </c:forEach>
            </table>
                <h3 align="center">The total Price is: ${totalPrice}</h3>
        </c:if>

        <c:if test="${not empty notAvailable}">
            <h3 align="Center"> Sorry for inconvenience, we do not have enough ingredient to prepare the following orders:</h3>
            <table border="1" cellpadding="5" align="center">
                <tr bgcolor="FF6600">
    <!--                <td><b>Food ID</b></td>-->
                    <td><b> Food Name</b></td>
                    <td><b> Item Price</b></td>
                    <td><b> Quantity</b></td>
                    <td><b> Price</b></td>
                </tr>
                <c:forEach var="ib" items="${notAvailable}" varStatus="status">
                        <c:set var="rowColor" value="33FFFF"/>
                        <c:if test="${status.index % 2 ==0}">
                        <c:set var="rowColor" value="CCFF33"/>
                        </c:if>
                        <tr bgcolor=${rowColor} >
                             <td>${ib.foodName}</td>
                             <td>${ib.foodPrice}</td>
                             <td>${ib.quantity}</td>
                             <td>${ib.foodPrice * ib.quantity}</td>
                        </tr>
                </c:forEach>
            </table>
        </c:if>
                
</td>
<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />
