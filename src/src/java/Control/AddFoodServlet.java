/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;


import Model.*;
import Data.FoodDB;
import Data.IngredientDB;
import Model.NewFoodBean;
import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.security.Principal;

public class AddFoodServlet extends HttpServlet {

    private String message = "";
    private String URL = "";
    private NewFoodBean newFood;
    private IngredientListBean IngredientsListBean;
    @Override
    public void init() throws ServletException {


        
        try {
            newFood = new NewFoodBean();
             IngredientsListBean = new IngredientListBean();
        }
        catch (Exception e) {
            throw new ServletException(e);
        }

        ServletContext sc = getServletContext();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();



        HttpSession session = request.getSession();

        if(request.getParameter("action").equals("Add")){

        message = "Add food to database!";
        URL = "/admin/AddFood.jsp";
        session.setAttribute("newFood", newFood);

        }
        else if (request.getParameter("action").equals("AddFoodd")) {
        if (isValidate(request,session))
        {
                 int intmessage = FoodDB.insert(newFood);
                 message = Integer.toString(intmessage);
                 URL = "/admin/index.jsp";

                 //message = "New food added!";

                 //user.userResident(user.getUserName());
                 //session.setAttribute("newFood", newFood);
            
        }
        }
        else if (request.getParameter("action").equals("AddIng")) {

                 message = "Add Ingredient to database!";
                 URL = "/admin/AddIngredient.jsp";
                 ArrayList ingredientList = IngredientsListBean.getIngredientList();
                 session.setAttribute("ingList", ingredientList);

        }
        else if (request.getParameter("action").equals("AddIngredient")) {

                 message = "Ingredient Increased!";
                 URL = "/admin/index.jsp";
                 
                 //message=session.getAttribute("ingQuantity").toString();
                 //session.setAttribute("ingList", ingredientList);

                 String ingIDS = request.getParameter("ingID");
                 
                 String ingQuantityS = request.getParameter("ingQuantity");

                 int ingID = Integer.parseInt(ingIDS);
                 
                 int ingQuantity = Integer.parseInt(ingQuantityS);

                 IngredientDB.updateIngQuantity1(ingID, ingQuantity);
        }




       request.setAttribute("message", message);
       RequestDispatcher rd = getServletContext().getRequestDispatcher(URL);
       rd.forward(request, response);




        }
    public boolean isValidate(HttpServletRequest request,HttpSession session)
    {

        String foodName = request.getParameter("foodName");
        String foodDescription = request.getParameter("foodDescription");

        String ingName1 = request.getParameter("ingName1");
        int price1 = Integer.parseInt(request.getParameter("price1"));
        int quantityNeeded1 = Integer.parseInt(request.getParameter("quantityNeeded1"));

        String price1Str = request.getParameter("price1");
        String quantityNeeded1Str = request.getParameter("quantityNeeded1");
        


        if (foodName.length() == 0 || foodDescription.length() == 0 ||
            ingName1.length() == 0 || price1 == 0 ||
            quantityNeeded1 == 0)
        {
             message = "Please fill out all fields which are signed by a red star.";
             //message = foodName + foodDescription + ingName1 + price1Str + quantityNeeded1Str;
             //request.setAttribute("message", message);
             //URL = "/admin/AddFood.jsp";
             return false;
        }

        newFood.setFoodName(foodName);
        newFood.setFoodDescription(foodDescription);
        newFood.setIngName1(ingName1);
        newFood.setPrice1(price1);
        newFood.setQuantityNeeded1(quantityNeeded1);

        ////////////////////

        

        String ingName2 = request.getParameter("ingName2");
        int price2 = Integer.parseInt(request.getParameter("price2"));
        int quantityNeeded2 = Integer.parseInt(request.getParameter("quantityNeeded2"));

        String price2Str = request.getParameter("price2");
        String quantityNeeded2Str = request.getParameter("quantityNeeded2");


        if(ingName2.length() != 0 || price2 != 0 ||
                quantityNeeded2 != 0)
        {
            if(ingName2.length() == 0 || price2 == 0 ||
                  quantityNeeded2 == 0)
            {
                message = "Please fill out all fields of an ingredient!";
                return false;
            }
            else
            {
                newFood.setIngName2(ingName2);
                newFood.setPrice2(price2);
                newFood.setQuantityNeeded2(quantityNeeded2);
            }
        }

        //////////////////////////////////////////////

        
        String ingName3 = request.getParameter("ingName3");
        int price3 = Integer.parseInt(request.getParameter("price3"));
        int quantityNeeded3 = Integer.parseInt(request.getParameter("quantityNeeded3"));

        String price3Str = request.getParameter("price3");
        String quantityNeeded3Str = request.getParameter("quantityNeeded3");


        if(ingName3.length() != 0 || price3 != 0 ||
                quantityNeeded3 != 0)
        {
            if(ingName3.length() == 0 || price3 == 0 ||
                  quantityNeeded3 == 0)
            {
                message = "Please fill out all fields of an ingredient!";
                return false;
            }
            else
            {
                newFood.setIngName3(ingName3);
                newFood.setPrice3(price3);
                newFood.setQuantityNeeded3(quantityNeeded3);
            }
        }

        ///////////////////////////////////////////////////


        String ingName4 = request.getParameter("ingName4");
        int price4 = Integer.parseInt(request.getParameter("price4"));
        int quantityNeeded4 = Integer.parseInt(request.getParameter("quantityNeeded4"));

        String price4Str = request.getParameter("price4");
        String quantityNeeded4Str = request.getParameter("quantityNeeded4");


        if(ingName4.length() != 0 || price4 != 0 ||
                quantityNeeded4 != 0)
        {
            if(ingName4.length() == 0 || price4 == 0 ||
                  quantityNeeded4 == 0)
            {
                message = "Please fill out all fields of an ingredient!";
                return false;
            }
            else
            {
                newFood.setIngName4(ingName4);
                newFood.setPrice4(price4);
                newFood.setQuantityNeeded4(quantityNeeded4);
            }
        }


        /////////////////////////////////////////////////


        String ingName5 = request.getParameter("ingName5");
        int price5 = Integer.parseInt(request.getParameter("price5"));
        int quantityNeeded5 = Integer.parseInt(request.getParameter("quantityNeeded5"));

        String price5Str = request.getParameter("price5");
        String quantityNeeded5Str = request.getParameter("quantityNeeded5");


        if(ingName5.length() != 0 || price5 != 0 ||
                quantityNeeded5 != 0)
        {
            if(ingName5.length() == 0 || price5 == 0 ||
                  quantityNeeded5 == 0)
            {
                message = "Please fill out all fields of an ingredient!";
                return false;
            }
            else
            {
                newFood.setIngName5(ingName5);
                newFood.setPrice5(price5);
                newFood.setQuantityNeeded5(quantityNeeded5);
            }
        }
        return true;
 }





        


        /*else if( UserDB.userExists(userName))
        {
            message = "This UserName already exists. <br>"+userName;
            session.setAttribute("message", message);
            URL = "/index.jsp";
            return false;
        }*/

       
           
        
    

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

}
