package Model;

/**
 * This bean will be used to fill the food bean from the data stored in the
 * data base and store them in an Array, i.e there will be one bean per each row
 * in the database and each bean will be stored in an array.
 * 
 */
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import Data.*;

public class FoodListBean implements Serializable {

    private static java.util.ArrayList foodList;
    //private static java.util.ArrayList ingList;

    public FoodListBean() {
        // create an Array to store the beans
        foodList = new ArrayList();
        // make the connection to the DB using the connection pool
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Food ORDER BY foodName ASC";

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            // iterate through the resultset and place each bean in the array
            while (rs.next()) {
                FoodBean fb = new FoodBean();
                fb.setFoodID(rs.getInt(1));
                fb.setFoodName(rs.getString(2));
                fb.setFoodPrice(rs.getFloat(3));
                fb.setFoodDescription(rs.getString(4));
                foodList.add(fb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public ArrayList getFoodIngList(int fID) {

        //Make an array list so ingredientList can have all the ingredinets as array and the entire ingredients as array list.
        ArrayList ingredientList = new ArrayList();

        //Database connection to get an instance of connection pool object.
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //SQL query to read all the ingredinets and sort them by name.
        String query = "SELECT * FROM foodingredient where foodID = ? ORDER BY ingID ASC";

        try {

            //Perform the query and save the quesry result in rs.
            ps = connection.prepareStatement(query);
            ps.setInt(1, fID);
            rs = ps.executeQuery();

            //Read the result set row by row and put these information in igredientList.
            while(rs.next()) {
                FoodIngBean fib = new FoodIngBean();
                fib.setIngID(rs.getInt(2));
                fib.setQuantityNeeded(rs.getInt(3));

                ingredientList.add(fib);
            }
        }

        //If the is problem in DB connectivity, pool object or performing the query then it will print StackTrace in the browser.
        catch(SQLException e) {
            e.printStackTrace();
        }

        //When everythings are finished then close the result set and prepared statement and also take it back the pool object.
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return ingredientList;
    }

   
       
}
