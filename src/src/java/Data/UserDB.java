
package Data;

import java.sql.*;
import Model.UserBean;
import Model.RoleBean;


/*
 * The aim of this method of UserDB class is to insert information when user fill out the form to database,
 * make a connection object to our database and insert information by related fields which
 * are attributes according to User object's attribute in UserBean and in order to those attributes
 * in our database.
 */
public class UserDB {

    public static int insert(UserBean user,RoleBean userRole){

        /**
         * create pool object by getInstance method of connectionPool object and then make
         * a connection object to our database.
         */
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        /**
         * By this query the values of instance variables of user object will insert in to database
         * and each of the attributes will set to a column according to the script of mysql in DBSQL
         * package and each one shows a column in ecpdatabase.Otherwise sqlException will occur which
         * shows an error to make a connection or inserting data to our database.
         */
        String query =
                "INSERT INTO user (userName, password, firstName, lastName, address, postalCode, telephone, city, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String roleQuery =
                "INSERT INTO role (userName, roleName) " +
                "VALUES (?, ?)";
        try
         {
                ps = connection.prepareStatement(query);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFirstName());
                ps.setString(4, user.getLastName());
                ps.setString(5, user.getAddress());
                ps.setInt(6, user.getPostalCode());
                ps.setInt(7, user.getTelephone());
                ps.setString(8, user.getCity());
                ps.setString(9, user.getEmail());
                ps.executeUpdate();

                // set the role for the new user
                ps=connection.prepareStatement(roleQuery);
                ps.setString(1, userRole.getUserName());
                ps.setString(2, userRole.getRoleName());
                ps.executeUpdate();

                return 1;
           }
        /*
         *@exception e appears when trying to connection to the database is failed in all situations and print the error.
         */
          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        /**
         * make free connection object and put it back to connection pool.
         */
        finally {
                 DBUtil.closePreparedStatement(ps);
                  pool.freeConnection(connection);
               }
     }
    public static String update(UserBean user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        //This method updates the record with a matching userName.
        //It returns a value of 0 if the userName can't be found.
        String query = "UPDATE user SET " +
                "userName = ?, " +
                "password = ?, " +
                "firstName = ?, " +
                "lastName = ?, " +
                "address = ?, " +
                "postalCode = ?, " +
                "telephone = ?, " +
                "city = ?, " +
                "email = ? " +
                "WHERE userName = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getPostalCode());
            ps.setInt(7, user.getTelephone());
            ps.setString(8, user.getCity());
            ps.setString(9, user.getEmail());
            ps.setString(10, user.getUserName());
            
            ps.executeUpdate();
            return user.getUserName();
        }
        /*
         *@exception e appears when trying to connection to the database is failed in all situations and print the error.
         */
        catch(SQLException e)
        {
            e.printStackTrace();
            return "0";
        }
    /**
     * The aim of using this method is to release the connection pooling.
     * This method either close the connection or in the case of SQL exception prints stackTrace.
     */
        finally
        {
            //DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    /*
     * The aim of this method of UserDB class is to check user name and password by select query which inserted by
     * user for login and check if userName and password are exist and return it if the query find it.
     * As this class return boolean and return false if it couldn't find the inserted userName and password
     * which means the user is not registered yet.
     */
    public static boolean userPassExists(String userName, String password)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT userName FROM User " +
                "WHERE userName = ? AND password = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next();
        }
        /*
         * @exception e appears when trying to connection to the database is failed in all situations and print the error.
         */
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    /**
     * The aim of using this method is to release the connection pooling.
     * This method either close the connection or in the case of SQL exception prints stackTrace.
     */
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    /*
     * The aim of this method of UserDB class is to find the userName which is insrted by user by the
     * select query if it's already exist in our database. If the class find the username
     * return it otherwise return false which means that username is not exist in the database.
     */
    public static boolean userExists(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT userName FROM User " +
                "WHERE userName = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            return rs.next();
            
        }
        /*
         *@exception e appears when trying to connection to the database is failed in all situations and print the error.

         */
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    /**
     * The aim of using this method is to release the connection pooling.
     * This method either close the connection or in the case of SQL exception prints stackTrace.
     */
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    /*
     * The aim of using this method of UserDB class is to find the UserID according to userName
     * by select query and return the userID if it would be found otherwise it will return -2.
     */
    public static int selectUserID(UserBean user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //This method returns 0 if UserID isn't found.
        String query = "SELECT userID FROM User " +
                "WHERE userName = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getInt("UserID");
            else
                return -2;
        }
        /*
         *@exception e appears when trying to connection to the database is failed in all situations and print the error.
         */
        catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    /**
     * The aim of using this method is to release the connection pooling.
     * This method either close the connection or in the case of SQL exception prints stackTrace.
     */
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    /*
     * The aim of this method is to select all the attributes by select query according to
     * the userName of user which is inserted by user and set all attributes of that username
     * and return an object of UserBean class.
     */
      public static UserBean selectUser(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User " +
                       "WHERE userName = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            UserBean user = null;
            if (rs.next())
            {
                user = new UserBean();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setAddress(rs.getString("address"));
                user.setPostalCode(rs.getInt("postalCode"));
                user.setTelephone(rs.getInt("telephone"));
                user.setCity(rs.getString("city"));
                user.setEmail(rs.getString("email"));
            }
            return user;
        }
        /*
         *@exception e appears when trying to connection to the database is failed in all situations and print the error.
         */
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    /**
     * The aim of using this method is to release the connection pooling.
     * This method either close the connection or in the case of SQL exception prints stackTrace.
     */
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
