package Model;

/**
 * This bean will be used to retrieve the list of available food from database
 * by using available_foods view.
 * the list of available foods will be stored them in an Array, which is the name
 * of available foods.
 *
 * 
 */
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import Data.*;
import java.util.ArrayList;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Available_FoodsBean implements Serializable {

    private static java.util.ArrayList availableFoodList;

    public Available_FoodsBean() {
        // create an Array to store the beans
        availableFoodList = new ArrayList();
        // make the connection to the DB using the connection pool
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM available_foods ORDER BY foodName ASC";

        java.util.ArrayList availableFoodNameList = new ArrayList();
        FoodListBean flb = new FoodListBean();
        ArrayList foodList = flb.getFoodList();

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            // iterate through the resultset and place each bean in the array
            while (rs.next()) {
                availableFoodNameList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        for(int i=0; i<foodList.size();i++){
            FoodBean fb = (FoodBean) foodList.get(i);
            int ind = availableFoodNameList.indexOf(fb.getFoodName());
            if (ind > -1)
                availableFoodList.add(fb);

        }

    }

    /**
     * the get method to return the list of beans
     * @return availableFoodList the array which in the beans are stored
     */
    public ArrayList getAvailableFoodList() {
        return availableFoodList;
    }

    /**
     * the set method to set the array with the given collection
     * @param availableFoodList the collection introduced by the user
     */
    public void setAvailableFoodList(ArrayList availableFoodList) {
        this.availableFoodList = availableFoodList;
    }

}
