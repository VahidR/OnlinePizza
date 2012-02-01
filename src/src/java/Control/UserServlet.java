/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Model.*;
import Data.UserDB;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.security.Principal;


public class UserServlet extends HttpServlet {
   
    private UserBean user;
    private String message = "";
    private RoleBean rb = new RoleBean();
    private String URL;

    @Override
    public void init() throws ServletException {

        try {
            user = new UserBean();
        }
        catch (Exception e) {
            throw new ServletException(e);
        }

        ServletContext sc = getServletContext();
    }
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        if(request.getParameter("action").equals("signUpForm")){

            message = " Welcome to sign up page";
            URL = "/signUpForm.jsp";
        }
        else if(request.getParameter("action").equals("RegisterUser"))
        {
            if (isValidate(request,session))
            {
                 message = "Now your registeration is complete.";

                 rb.setUserName(user.getUserName());
                 rb.setRoleName("user");

                 UserDB.insert(user,rb);
                 URL = "/index.jsp";
                 user.userResident(user.getUserName());
                 session.setAttribute("user", user);
            }
            else
            {
                if(checkIntNumber(request.getParameter("postalCode")))
                    user.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
                if(checkIntNumber(request.getParameter("telephone")))
                    user.setTelephone(Integer.parseInt(request.getParameter("telephone")));

                request.setAttribute("user", user);
                URL = "/signUpForm.jsp";
            }
            //message =Integer.toString(UserDB.insert(user));
        }
        else if (request.getParameter("action").equals("EditProfileUser"))
        {
             if (isEditValid(request,session))
             {
                 session.setAttribute("user", user);
                 UserDB.update(user);
                 message = "You have edited your profile.";
                 URL = "/index.jsp";
            }
            else
            {
                if(checkIntNumber(request.getParameter("postalCode")))
                    user.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
                if(checkIntNumber(request.getParameter("telephone")))
                    user.setTelephone(Integer.parseInt(request.getParameter("telephone")));

                request.setAttribute("user", user);
                request.setAttribute("message", message);
                URL = "/editUserProfile.jsp";
            }
        }
        else if (request.getParameter("action").equals("UserLogIn"))
        {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            if (userName.length() == 0 || password.length()== 0){
                URL = "/userLogin.jsp";
                message = "Please enter value for both UserName and Password";
            }
            else if (UserDB.userPassExists(userName, password)){
                    user = UserDB.selectUser(userName);

                    URL = "/index.jsp";
                    message = "";
                    session.setAttribute("user", user);
                }
                    else{
                        URL = "/userLogin.jsp";
                        message = "Please enter a vaild UserName and Password";
                    }


         }
        else if (request.getParameter("action").equals("UserLogOut")){
            user = new UserBean();
            user.setUserID(0);
            session.setAttribute("user", user);
            session.invalidate();

            message = "";
            URL = "/index.jsp";
        }
        else if (request.getParameter("action").equals("deleteSession")){
            session.invalidate();
            message = "All infroamtion is removed from the current session !";
            URL = "/index.jsp";
        }
            
       request.setAttribute("message", message);
       RequestDispatcher rd = getServletContext().getRequestDispatcher(URL);
       rd.forward(request, response);
        
    }

    /// some method that do the validation
    /*
     * isInt method is used to check if the postal code or telephone number are integer
     * return true otherwise return false.
     */
    public boolean isInt(String pCode)
    {
        try
        {
            Integer.parseInt(pCode);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    /*
     * @param pCOde as argument which postal code or phone number as string will
     * be pass to this parameter to check if those parameter are integer and be positive
     * numbers and unequal to zero.
     * ifInt method return true if the postalcode or telephone number which passed
     * to this method as arguments are right numbers.
     * this method return false if it's not a right number, charecter or negative or zero number.
     */
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
     * Check if the given string is convertible to integer or not. If it is then return true, false otherwise.
     *
     * @param text is String to check whether can be convertible to integer or not.
     * @return boolean true if the text can convert to integer, false otherwise.
     */
    public boolean checkIntNumber(String text)
    {
        try
        {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean checkFloatNumber(String text) {
        try {
            Float.parseFloat(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param username, password,....,telephone check to be valid ,not equal to null
     * for string parameters or be integer and right for numeric parameters.
     * @postalCode which get by request object as string and set at least after validation
     * as integer.
     * @telephone which get by request object as string and set at least after validation
     * as integer.
     */

    public boolean isValidate(HttpServletRequest request,HttpSession session)
    {
        String URL = "/";

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String postalCodeString = request.getParameter("postalCode");
        String city = request.getParameter("city");
        String telephoneString = request.getParameter("telephone");

        //user = new UserBean();
        /*
         * set the string parameters at first ,in this case the form will show
         * those parameters which insert by user eachtime that they are inserted
         * except postal code and telephone as integer parameters ause they should be
         * convert to string after avlidation so we don't set them at the first time.
         */
        user.setUserName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(address);
        user.setCity(city);

        if (userName.length() == 0 || password.length() == 0 ||
            firstName.length() == 0 || lastName.length() == 0 ||
            email.length()== 0||address.length() == 0 ||
            postalCodeString.length()==0 ||city.length() == 0 ||
            telephoneString.length()==0)
        {
             message = "Please fill out all fields which are signed by a red star.";
             request.setAttribute("message", message);
             URL = "/signUpForm.jsp";
             return false;
        }
         /*
         * check the password and password confirmation field to be equal and not empty
         * if they are not equal set them both to empty string.
         */
           else if (!password.equals(password2))
        {
            message = "Please confirm the password by the same password.";
            request.setAttribute("message", message);
            user.setPassword("");
            URL = "/signUpForm.jsp";
            return false;
        }
        /*
         *
         * To check in UserDB if userName exixt by userName as a interval if it extists
         * return false and set message which shows the userName is already exist.
         */
        else if( UserDB.userExists(userName))
        {
            message = "This UserName already exists. <br>"+userName;
            session.setAttribute("message", message);
            URL = "/index.jsp";
            return false;
        }
        /*
         * check the format of email address for validation to include '@' and '.' charecters.
         */
         else if(email.indexOf('@') == -1 || email.lastIndexOf('.')== -1)
         {
             message = "Please enter a valid email address";
             request.setAttribute("message", message);
             URL = "/signUpForm.jsp";
             return false;
         }
        /*
         * else if result would return false : if the postal code is not integer or when it's negetive number
         * or zero value.
         */
         else if (! ifInt(postalCodeString)||(postalCodeString.charAt(0)=='0'))
         {
             message = "Postal code should be a positive number.";
             request.setAttribute("message", message);
             URL = "/signUpForm.jsp";
             return false;
         }
        /*
         * else if result would return false : if the phone number is not integer or when it's negetive number
         * or zero value.
         */
        else if(! ifInt(telephoneString)|| (telephoneString.charAt(0)== '0'))
        {
            message = "Telephone number should be numbers.";
            URL = "/signUpForm.jsp";
            return false;
        }
        /*
         * if telephone number and postal code validate to be integer and right numbers
         * in else part set in user object.
         */
        else
        {
            int postalCode = Integer.parseInt(postalCodeString);
            user.setPostalCode(postalCode);
            int telephone = Integer.parseInt(telephoneString);
            user.setTelephone(telephone);

            request.setAttribute("user", user);
            return true;
        }
    }

    /**
     * @param username, password,....,telephone check to be valid ,not equal to null
     * for string parameters or be integer and right for numeric parameters.
     * @postalCode which get by request object as string and set at least after validation
     * as integer.
     * @telephone which get by request object as string and set at least after validation
     * as integer.
     */

    public boolean isEditValid(HttpServletRequest request,HttpSession session)
    {
        String URL = "/";
        String userIDString = request.getParameter("userID");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String postalCodeString = request.getParameter("postalCode");
        String city = request.getParameter("city");
        String telephoneString = request.getParameter("telephone");

        message = request.getParameter("userName");

        //user = new UserBean();

        /*
         * set the string parameters at first ,in this case the form will show
         * those parameters which insert by user eachtime that they are inserted
         * except postal code and telephone as integer parameters ause they should be
         * convert to string after avlidation so we don't set them at the first time.
         */
        int userID = Integer.parseInt(userIDString);
        user.setUserID(userID);
        user.setUserName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(address);
        user.setCity(city);

         /*
         * check the userID if it's not equal to zero and then check other fields
          * which should not be empty.
         */
        if (userID != 0 )
        {
        if ( password.length() == 0 || password2.length()==0 ||
            firstName.length() == 0 || lastName.length() == 0 ||
            email.length()== 0||address.length() == 0 ||
            postalCodeString.length()==0 ||city.length() == 0 ||
            telephoneString.length()==0)
        {
             message = "Please fill out all fields which are signed by a red star.";
             request.setAttribute("message", message);
             URL = "/editUserProfile.jsp";
             return false;
        }
         /*
         * check the password and password confirmation field to be equal and not empty
         * if they are not equal set them both to empty string.
         */
        else if (!password.equals(password2))
        {
            message = "Please confirm the password by the same password.";
            request.setAttribute("message", message);
            user.setPassword("");
            URL = "/editUserProfile.jsp";
            return false;
        }
         /*
         * check the format of email address for validation to include '@' and '.' charecters.
         */
         else if(email.indexOf('@') == -1 || email.lastIndexOf('.')== -1)
         {
             message = "Please enter a valid email address";
             request.setAttribute("message", message);
             URL = "/editUserProfile.jsp";
             return false;
         }
        /*
         * else if result would return false : if the postal code is not integer or when it's negetive number
         * or zero value.
         */
         else if (! ifInt(postalCodeString)||(postalCodeString.charAt(0)=='0'))
         {
             message = "Postal code should be a positive number.";
             request.setAttribute("message", message);
             URL = "/editUserProfile.jsp";
             return false;
         }
        /*
         * else if result would return false : if the phone number is not integer or when it's negetive number
         * or zero value.
         */
        else if(! ifInt(telephoneString)|| (telephoneString.charAt(0)== '0'))
        {
            message = "Telephone number should be numbers.";
            URL = "/signUpForm.jsp";
            return false;
        }
        /*
         * if telephone number and postal code validate to be integer and right numbers
         * in else part set in user object.
         */
        else
        {
            int postalCode = Integer.parseInt(postalCodeString);
            user.setPostalCode(postalCode);
            int telephone = Integer.parseInt(telephoneString);
            user.setTelephone(telephone);

            request.setAttribute("user", user);

            return true;
        }
        }
        else
            return false;
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

}
