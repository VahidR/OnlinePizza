
<jsp:include page="/includes/header.html" />
<jsp:include page="/admin/column_left_admin_home.jsp" />

<!-- start the middle column -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Model.NewFoodBean" %>

<script type="text/javascript" language="JavaScript" src="scripts/addNewFoodValidationForm.js"></script>

<td colspan="2">
        <h1>Please first do registration to be able to make an order!</h1>
        <font color="red">
            <p><i>${message}</i></p></font>

            <form action="./AddFood?action=AddFoodd" method="post">
              <table border ="0" cellpadding="5">
                  <tr>
                     <td></td>
                     <td align = "left">Please fill out all the fields which are
                          specified by <font color="red">*</font> </td>
                  </tr>
                  <tr>
                       <td align="right"> Food Name </td>
                       <td><input type="text" name="foodName" size="20" maxlength="20"
                                  value="${newFood.foodName}">
                       <font color ="red">*</font></td>
                  </tr>
                  <tr>
                       <td align="right"> Food Description </td>
                       <td><input type="text" name="foodDescription" size="50" maxlength="50"
                                  value="${newFood.foodDescription}">
                       <font color ="red">*</font></td>
                  </tr>
                  <tr>
                       <td align="right"> Ingredient1 Name  </td>
                       <td><input type="text" name="ingName1" size="10" maxlength="20"
                                  value="${newFood.ingName1}">
                       <font color ="red">*</font></td>
                       <td align="right"> Ingredient1 Price  </td>
                       <td><input type="text" name="price1" size="2" maxlength="2"
                                  value="${newFood.price1}">
                       <font color ="red">*</font></td>
                       <td align="right"> Ingredient1 Quantity  </td>
                       <td><input type="text" name="quantityNeeded1" size="2" maxlength="2"
                                  value="${newFood.quantityNeeded1}">
                       <font color ="red">*</font></td>
                  </tr>
                  <tr>
                       <td align="right"> Ingredient2 Name  </td>
                       <td><input type="text" name="ingName2" size="10" maxlength="20"
                                  value="${newFood.ingName2}">
                       
                       <td align="right"> Ingredient2 Price  </td>
                       <td><input type="text" name="price2" size="2" maxlength="2"
                                  value="${newFood.price2}">
                       
                       <td align="right"> Ingredient2 Quantity  </td>
                       <td><input type="text" name="quantityNeeded2" size="2" maxlength="2"
                                  value="${newFood.quantityNeeded2}">
                      
                  </tr>
                  <tr>
                       <td align="right"> Ingredient3 Name  </td>
                       <td><input type="text" name="ingName3" size="10" maxlength="20"
                                  value="${newFood.ingName3}">
                       
                       <td align="right"> Ingredient3 Price  </td>
                       <td><input type="text" name="price3" size="2" maxlength="2"
                                  value="${newFood.price3}">
                    
                       <td align="right"> Ingredient3 Quantity  </td>
                       <td><input type="text" name="quantityNeeded3" size="2" maxlength="2"
                                  value="${newFood.quantityNeeded3}">
                      
                  </tr>
                  <tr>
                       <td align="right"> Ingredient4 Name  </td>
                       <td><input type="text" name="ingName4" size="10" maxlength="20"
                                  value="${newFood.ingName4}">
                       
                       <td align="right"> Ingredient4 Price  </td>
                       <td><input type="text" name="price4" size="2" maxlength="2"
                                  value="${newFood.price4}">
                      
                       <td align="right"> Ingredient4 Quantity  </td>
                       <td><input type="text" name="quantityNeeded4" size="2" maxlength="2"
                                  value="${newFood.quantityNeeded4}">
                       
                  </tr>
                  <tr>
                       <td align="right"> Ingredient5 Name  </td>
                       <td><input type="text" name="ingName5" size="10" maxlength="20"
                                  value="${newFood.ingName5}">
                       
                       <td align="right"> Ingredient5 Price  </td>
                       <td><input type="text" name="price5" size="2" maxlength="2"
                                  value="${newFood.price5}">
                       
                       <td align="right"> Ingredient5 Quantity  </td>
                       <td><input type="text" name="quantityNeeded5" size="2" maxlength="2"
                                  value="${newFood.quantityNeeded5}">
                       
                  </tr>
                   
                    
                    
                    <tr>
                           <td align="right"></td>
                           <td>
                               <script language="javascript">
                                     document.write('<input type="button" value="Save" onClick="validate(this.form)">');
                                </script>
                                <noscript>
                                    <input type="submit" value="Save">
                                 </noscript>
                                               &nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" value="Reset"></td>
                   </tr>
           </table>
      </form>
</td>

<!-- end the middle column -->

<jsp:include page="/includes/footer.jsp" />
