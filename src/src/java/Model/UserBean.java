
package Model;

import java.io.Serializable;
import java.sql.*;
import Data.*;

/**
 *
 *
 * The aim of using this class is to implement user beans properties and instances
 * Then we can get data needed by user and save to database by invoking this class
 * and it's methods.
 */
public class UserBean implements Serializable
{
    private int userID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int postalCode;
    private String city;
    private int telephone;

    /**
     * No argument (Zero constructor) to instantiate the instances.
     * @param userID Integer which represents the ID of the user.
     * @param userName String which represents the userName of user.
     * @param password String password represents the password of user.
     * @param firstName String represents first name of user.
     * @param lastName String represents lastName of user.
     * @param emailAddress, address, postalCode, city and telNumber which represent
     * emailAddress, address ,postalCode ,city and telNumber of the user.
     */
    public UserBean()
    {
        userID = 0;
        userName = "";
        password = "";
        firstName = "";
        lastName = "";
        email = "";
        address = "";
        postalCode = 0;
        city = "";
        telephone = 0;
    }

    /**
     * User constructor with instantiate of instances and it makes my User object
     */
    public UserBean (int ID, String Name,String pass,
            String first,String last,String email1,
            String add,int postal,String cit, int tel)
    {
        userID = ID;
        userName = Name;
        password = pass;
        firstName = first;
        lastName = last;
        email = email1;
        address = add;
        postalCode = postal;
        city = cit;
        telephone = tel;
    }

    /** 
     * Setter for UserBean class according to the definition of JavaBeans.
     * The aim of using this setter is that since attribute is private and we can not change it
     * outside of this class, by using this setter method we have ability to change/set it.
     * @param id which represents userID as argument
     */
    public void setUserID(int id)
    {
        userID = id;
    }

    /**
     * Getter method to return the userID for the object which was set when one
     * record as user object attribute add to the database
     * @return userID a value representing the ID of the user which defined by database
     */
    public int getUserID()
    {
      return userID;
    }

    /**
     * Setter method to set the value of the userName to the value which inserted by the
     * user
     * @param uName which represents userName as argument
     */
    public void setUserName(String uName)
    {
        userName = uName;
    }

    /**
     * Getter method to return the user Name for the user object
     * @return userName which return userName attribute
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * Setter method to set the value of the password to the value which clarified by the
     * user
     * @param pass which represents password as argument
     */
    public void setPassword(String pass)
    {
        password = pass;
    }
    
    /**
     * Getter method to return the password for the user object
     * @return password which returns password attribute
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Setter method to set the value of the firstName to the value which inserted by the
     * user
     * @param fName which represents firstName as argument
     */
    public void setFirstName(String fName)
    {
        firstName = fName;
    }

    /**
     * Getter method to return the first Name for the user object.
     * @return firstName which return firstName attribute
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Setter method to set the value of the lastName to the value which inserted by the
     * user
     * @param lName which represents lastName as argument
     */
    public void setLastName(String lName)
    {
        lastName = lName;
    }

    /**
     * Getter method to return the last Name for the user object.
     * @return lastName which returns lastName attribute
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Setter method to set the value of the email to the value which inserted by the
     * user
     * @param eAddress which represents emailAddress as argument
     */
    public void setEmail(String eAddress)
    {
        email = eAddress;
    }

    /**
     * Getter method to return the email for the user object
     * @return emailAddress which returns emailAddress attribute
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Setter method to set the value of the address to the value which inserted by the
     * user
     * @param addr which represents address as argument
     */
    public void setAddress(String addr)
    {
        address = addr;
    }

    /**
     * Getter method to return the  address for the user object
     * @return address which returns address attribute
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Setter method to set the value of the postal code to the value which inserted by the
     * user
     * @param pCode which represents postalCode as argument
     */
    public void setPostalCode(int pCode)
    {
        postalCode = pCode;
    }

    /**
     * Getter method to return the postalCode for the user object
     * @return postalCode which returns postalCode attribute
     */
    public int getPostalCode()
    {
        return postalCode;
    }

    /**
     * Setter method to set the value of the city to the value which inserted by the
     * user
     * @param myCity which represents city as argument
     */
    public void setCity(String myCity)
    {
        city = myCity;
    }

    /**
     * Getter method to return the city for the user object
     * @return city which returns city attribute
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Setter method to set the value of the telephone to the value which inserted by the
     * user
     * @param telNum which represents telNumber as argument
     */
    public void setTelephone(int telNum)
    {
        telephone = telNum;
    }

    /**
     * Getter method to return the telephone number for the user object
     * @return telNumber which returns telNumber attribute
     */
    public int getTelephone()
    {
       return telephone;
    }

    public void userResident(String userX) {

         ConnectionPool pool = ConnectionPool.getInstance();
         Connection connection = pool.getConnection();
         PreparedStatement ps = null;
         ResultSet rs = null;

         String query = "SELECT * FROM user WHERE userName = ?";

         try {
             ps = connection.prepareStatement(query);
             ps.setString(1, userX);
             rs = ps.executeQuery();
             rs.next();

             userID = rs.getInt(1);
             userName = rs.getString(2);
             password = rs.getString(3);
             firstName = rs.getString(4);
             lastName = rs.getString(5);
             address = rs.getString(6);
             postalCode = rs.getInt(7);
             telephone = rs.getInt(8);
             city = rs.getString(9);
             email = rs.getString(10);
         }
         catch(SQLException e) {
             e.printStackTrace();
         }
         finally {
             DBUtil.closeResultSet(rs);
             DBUtil.closePreparedStatement(ps);
             pool.freeConnection(connection);
         }
     }
}
