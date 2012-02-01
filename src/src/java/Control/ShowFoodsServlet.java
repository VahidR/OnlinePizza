/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.*;
import Model.*;
import Data.*;
import java.util.ArrayList;
import Control.MailUtil;
import javax.mail.MessagingException;


public class ShowFoodsServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    private Available_FoodsBean availableFoodListBean = new Available_FoodsBean();
    ArrayList allUsedIng = new ArrayList();
    //private FoodListBean foodListBean = new FoodListBean();
    private String message = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session = request.getSession();
        String URL = "";

        if(request.getParameter("action").equals("showFoods")){
            message = "";
            URL = "/showFoods.jsp";
            ArrayList availableFoodList = availableFoodListBean.getAvailableFoodList();
            session.setAttribute("availableFoodList", availableFoodList);

        }
        else if(request.getParameter("action").equals("addToBasket")){

            String foodIDS = request.getParameter("foodID");
            String quantityS = request.getParameter("quantity");
            String foodName = request.getParameter("foodName");
            String foodPriceS = request.getParameter("foodPrice");

            if (!ifInt(quantityS) || quantityS.charAt(0)=='0'){
                if (request.getParameter("page").equals("editBasket"))
                    URL = "/basket.jsp";
                else
                    URL = "/showFoods.jsp";
                message="Please enter a posetive integer number for " +foodName +"'s quantity!";
            }
            else
            {
                int foodID = Integer.parseInt(foodIDS);
               // String quantityS = request.getParameter("quantity");
                int quantity = Integer.parseInt(quantityS);
                float foodPrice = Float.valueOf(foodPriceS);

                java.util.ArrayList basketList;
                
                message="";//"The Items in you basket";
                basketList = new ArrayList();
                if (null != session.getAttribute("basketList"))
                {
                    basketList = (ArrayList)session.getAttribute("basketList");
                    allUsedIng = (ArrayList)session.getAttribute("allUsedIng");
                }

                //String foodIDS = request.getParameter("foodID");
                

                boolean flag = true;
                for (int i = 0; i < basketList.size(); i++){
                    ItemsBean ib = (ItemsBean)basketList.get(i);

                    if (foodID == ib.getFoodID())
                    {
                        if (request.getParameter("page").equals("editBasket") && (!isAvailableFood(foodID, quantity - ib.getQuantity(), true))){
                            URL = "/basket.jsp";
                            message="Sorry, We don't have enough ingredient to prepare ";
                            message += quantityS + " " + foodName + " pizza for you now!";
                        }
                       else if (request.getParameter("page").equals("showFoods") && (!isAvailableFood(foodID, quantity - ib.getQuantity(), true))){
                           URL = "/showFoods.jsp";
                           message="Sorry, We don't have enough ingredient to prepare ";
                           message += quantityS + " " + foodName + " pizza for you now!";
                        }
                        else{
                            //basketList.remove(i);
                            if (request.getParameter("page").equals("editBasket"))
                                ib.setQuantity(quantity);
                            else
                                ib.setQuantity(quantity + ib.getQuantity());
                            basketList.set(i,ib);

                            session.setAttribute("totalPrice", totalPrice(basketList));
                            session.setAttribute("basketList", basketList);
                            session.setAttribute("allUsedIng", allUsedIng);
                            URL = "/basket.jsp";
                        }
                        flag = false;
                    }
                }

                if (flag)
                {
                    if (!isAvailableFood(foodID, quantity, true)){
                        if (request.getParameter("page").equals("editBasket"))
                            URL = "/basket.jsp";
                        else
                            URL = "/showFoods.jsp";
                           message="Sorry, We don't have enough ingredient to prepare ";
                           message += quantityS + " " + foodName + " pizza for you now!";                    }
                    else{
                        ItemsBean ib = new ItemsBean();
                        ib.setFoodID(foodID);
                        ib.setQuantity(quantity);
                        ib.setFoodName(foodName);
                        ib.setFoodPrice(foodPrice);
                        basketList.add(ib);

                        session.setAttribute("totalPrice", totalPrice(basketList));
                        session.setAttribute("allUsedIng", allUsedIng);
                        session.setAttribute("basketList", basketList);
                        URL = "/basket.jsp";
                    }
                }
                

            }
        }
        else if(request.getParameter("action").equals("remove")){
            String foodIDS = request.getParameter("foodID");
            String foodName = request.getParameter("foodName");

            int foodID = Integer.parseInt(foodIDS);
               // String quantityS = request.getParameter("quantity");
            java.util.ArrayList basketList;
            message="";//"The Items in you basket";
            basketList = new ArrayList();
            
            if (null != session.getAttribute("basketList"))
            {
                basketList = (ArrayList)session.getAttribute("basketList");
                allUsedIng = (ArrayList)session.getAttribute("allUsedIng");
            }

            boolean flag = true;
            for (int i = 0; i < basketList.size(); i++){
                ItemsBean ib = (ItemsBean)basketList.get(i);

                if (foodID == ib.getFoodID())
                {
                    basketList.remove(i);
                    removeIngFromUsedIng(ib);

                    session.setAttribute("totalPrice", totalPrice(basketList));
                    session.setAttribute("basketList", basketList);
                    session.setAttribute("allUsedIng", allUsedIng);
                    message = "The " + foodName + "is succesfuly removed from your basket";
                    URL = "/basket.jsp";
                    flag = false;
                }
            }

            if(flag){
                message = "The " + foodName + "is not found!";
                URL = "/basket.jsp";
            }

        }
        else if(request.getParameter("action").equals("finalizeBasket")){

            UserBean user = (UserBean) session.getAttribute("user");
            if (user == null || user.getUserID() == 0 ){
                message = "Please register before finalizing !";
                URL = "/userLogin.jsp";

            }
            else{
                //String totalPriceS = (String) session.getAttribute("totalPrice");
                //float totalPrice = Float.valueOf( totalPriceS );
                float totalPrice = (Float) session.getAttribute("totalPrice");
                java.util.ArrayList basketList = (ArrayList)session.getAttribute("basketList");

                Date date = new Date();
                OrderBean ob = new OrderBean();
                ob.setOrderPrice(totalPrice);
                ob.setOrderNo(date.getTime());
                ob.setUserID(user.getUserID());

                BasketDB.insertOrder(ob);
                ob.setOrderID(BasketDB.getOrderID(ob));
                ArrayList notAvailable = new ArrayList();
                ArrayList servedFoods = new ArrayList();
                allUsedIng = new ArrayList();
                for (int i = 0; i < basketList.size(); i++){
                        ItemsBean ib = (ItemsBean)basketList.get(i);
                        if (! isAvailableFood(ib.getFoodID(), ib.getQuantity(), true)){
                            notAvailable.add(ib);
                        }
                        else{
                            OrderItemBean oib = new OrderItemBean();
                            oib.setFoodID(ib.getFoodID());
                            oib.setFoodPrice(ib.getFoodPrice());
                            oib.setOrderID(ob.getOrderID());
                            oib.setQuantity(ib.getQuantity());
                            BasketDB.insertOrderItem(oib);
                            servedFoods.add(ib);
                        }
                }
                // Upadte DB i.e decrease the number of used Ingredients
                for (int i = 0 ; i< allUsedIng.size(); i++){
                    IngredientBean ingBean = (IngredientBean) allUsedIng.get(i);
                    IngredientDB.updateIngQuantity(ingBean);
                }
                message = "Thanks for your shopping !";
                if (notAvailable.size() > 0)    session.setAttribute("notAvailable", notAvailable);
                if (servedFoods.size() > 0 ) session.setAttribute("servedFoods", servedFoods);
                request.setAttribute("orderNo", ob.getOrderNo());
                session.setAttribute("totalPrice", totalPrice(servedFoods));

                String to = user.getEmail();
                String from = "email@domain_name";
                String title = "Confirm Order"+ ob.getOrderNo();
                String body;
                body = fillBody(servedFoods, notAvailable, totalPrice, user,ob.getOrderNo());

                try{
                   MailUtil.sendMail(to, from, title, body, true);
                }
               catch (MessagingException e)
                {
                   System.out.println("Error !!!!");
               }

                session.removeAttribute("basketList");
                session.removeAttribute("allUsedIng");
                URL = "/confirm.jsp";
            }

        }
        request.setAttribute("message", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(URL);
        rd.forward(request, response);
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /*
     * @param pCOde as argument which postal code or phone number as string will
     * be pass to this parameter to check if those parameter are integer and be positive
     * numbers and unequal to zero.
     * ifInt method return true if the postalcode or telephone number which passed
     * to this method as arguments are right numbers.
     * this method return false if it's not a right number, charecter or negative or zero number.
     */
    public String fillBody(ArrayList servedFoods, ArrayList notAvailable, float totalPrice, UserBean user, long orderNo){
        String body ="";

        body = "Dear "+ user.getFirstName() + " " + user.getLastName()+ ",<br>";
        body += "<br>Thanks for your shopping here is you orders (Order No"+ orderNo + ")";
        if (servedFoods.size()>0){
            body += "<br>The list of the foods that we will send you :<br>";
            body += "<table border=\"0\" cellpadding=\"5\" align=\"center\"><tr>";
            body +="<td><b> Food Name</b></td><td><b> Item Price</b></td><td><b> Quantity</b></td><td><b> Price</b></td></tr>";
            for (int i = 0 ; i < servedFoods.size(); i++){
                body += "<tr>";
                ItemsBean ib = (ItemsBean) servedFoods.get(i);
                body += "<td>" + ib.getFoodName() + "</td>";
                body += "<td>" + ib.getFoodPrice() + "</td>";
                body += "<td>" + ib.getQuantity() + "</td>";
                body += "<td>" + ib.getQuantity()*ib.getFoodPrice() + "</td>";
                body += "</tr>";
            }
            body += "</table> <h3 align =\"center\"> The total price :" + totalPrice + "</h3>";
        }

        if (notAvailable.size()>0){
            body += "Sorry we doesn't have enough ingredient to provide the following foods ";
            body += "So, they are not included in your order";
            body += "<table border=\"0\" cellpadding=\"5\" align=\"center\"><tr>";
            body +="<td><b> Food Name</b></td><td><b> Item Price</b></td><td><b> Quantity</b></td><td><b> Price</b></td></tr>";
            for (int i = 0 ; i < notAvailable.size(); i++){
                body += "<tr>";
                ItemsBean ib = (ItemsBean) notAvailable.get(i);
                body += "<td>" + ib.getFoodName() + "</td>";
                body += "<td>" + ib.getFoodPrice() + "</td>";
                body += "<td>" + ib.getQuantity() + "</td>";
                body += "<td>" + ib.getQuantity()*ib.getFoodPrice() + "</td>";
                body += "</tr>";
            }
            body += "</table>";
        }
        body += "<br><br><br>Best Regards,<br>Online Pizza shop team";
        return body;
    }
    public boolean ifInt(String ptel)
    {
       int i;
       String pCode = ptel;
       for(i=0; i<pCode.length(); i++)
       {
           if(pCode.charAt(i)<'0' || pCode.charAt(i)>'9')
               return false;
           if (i == pCode.length())
               return true;
        }
       return true;
    }

    /**
     *
     * this function get the ID and the quantity of the ordered food and
     * check whether is it possible to make the food or not? i.e Do we have enough
     * ingredient for the food?
     *
     * @param foodID the ID of the food
     * @param quantity the quantity of the ordered food
     * @param reduce determine to only check the availability of the ingredient if it is false
     *  otherwise if it is true, check the availability and reduce the ingredient
     *
     * @return true if we have enough ingredient for the order
     */
    public boolean isAvailableFood(int foodID, int quantity, boolean reduce){

       FoodListBean flb= new FoodListBean();
       ArrayList ingItem = flb.getFoodIngList(foodID);

       IngredientListBean ilb = new IngredientListBean();
       ArrayList allIng = ilb.getIngredientList();
       
       boolean flag = true;
       for(int i = 0; i< ingItem.size(); i++){

           FoodIngBean fib = (FoodIngBean) ingItem.get(i);
           IngredientBean ib = new IngredientBean();
           for(int j = 0; j<allIng.size();j++) {
               ib = (IngredientBean) allIng.get(j);
               if (ib.getIngID() == fib.getIngID()) break;
           }
           int ind = findIndex(ib);
           int usedQ = 0;
           if (ind != -1){
               IngredientBean ibTemp = (IngredientBean) allUsedIng.get(ind);
               usedQ = ibTemp.getIngQuantity();

           }

           if (ib.getIngQuantity() < (usedQ + (fib.getQuantityNeeded()*quantity))){
               flag = false;
               break;
           }
        }
        // add Ingredient that should be used until now
       if (flag && reduce){
           for(int i = 0; i< ingItem.size(); i++){

               FoodIngBean fib = (FoodIngBean) ingItem.get(i);
               IngredientBean ib = new IngredientBean();
               for(int j = 0; j<allIng.size();j++) {
                   ib = (IngredientBean) allIng.get(j);
                   //System.out.println("Is VAlids befor if: " + allUsedIng.size());
                   if (ib.getIngID() == fib.getIngID()) {
                       int ind = findIndex(ib);
                       if (ind == -1){
                           ib.setIngQuantity(fib.getQuantityNeeded()*quantity);
                           allUsedIng.add(ib);
                       }
                       else {
                           IngredientBean ibTemp = (IngredientBean) allUsedIng.get(ind);
                           allUsedIng.remove(ind);
                           ibTemp.setIngQuantity(ibTemp.getIngQuantity() + (fib.getQuantityNeeded()*quantity));
                           allUsedIng.add(ibTemp);
                       }
                       break;
                   }
               }

           }
       }
       return flag;
    }
/**
 * This function get an basket list which is an arraylist of Itembean and calculate
 * the total price of the basket and return it.
 * 
 * @param bl an arraylist of item bean which make the basket
 * @return the total price of the basket;
 */
    public float totalPrice(ArrayList bl){

        float tp = 0;
        for (int i = 0; i < bl.size(); i++){
                    ItemsBean ib = (ItemsBean)bl.get(i);
                    tp += ib.getFoodPrice() * ib.getQuantity();
        }

        return tp;
    }

    /**
     * find the index of instance of ingredient bean in allusedIng.
     * if find the item return its index otherwise return -1
     * @param ib ingredientbean to be searched
     * @return the index of the ib and -1 if there is no entity with such a element
     */
    public int findIndex(IngredientBean ib){
        for(int j = 0; j<allUsedIng.size();j++) {
           IngredientBean ibT = (IngredientBean) allUsedIng.get(j);
           //System.out.println("Is VAlids befor if: " + allUsedIng.size());
           if (ibT.getIngID() == ib.getIngID())
               return j;
        }
        return -1;
    }

    public int removeIngFromUsedIng(ItemsBean ib){

        FoodListBean flb= new FoodListBean();
        ArrayList ingItem = flb.getFoodIngList(ib.getFoodID());

        for(int i = 0; i< ingItem.size(); i++){
               FoodIngBean fib = (FoodIngBean) ingItem.get(i);
               IngredientBean ingb = new IngredientBean();
               for(int j = 0; j<allUsedIng.size();j++) {
                   ingb = (IngredientBean) allUsedIng.get(j);
                   if (ingb.getIngID() == fib.getIngID()) {
                       int ind = findIndex(ingb);
                       if (ind == -1)
                           return -1;
                       else {
                           int remainQ = ingb.getIngQuantity() - ib.getQuantity() * fib.getQuantityNeeded();
                           allUsedIng.remove(ind);
                           if (remainQ >0 )
                            ingb.setIngQuantity(remainQ);
                            allUsedIng.add(ingb);
                       }
                       break;
                   }
               }

           }
        return 1;
    }
}
