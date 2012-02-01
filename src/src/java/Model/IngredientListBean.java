package Model;


import java.io.Serializable;
import java.sql.*;
import java.util.*;
import Data.*;

/**
 * This Java Bean is used to list/show all the ingredients in the database and also make the capabilities for
 * admin to add, edit or remove an ingredient in the database and shows the effects of these modifications 
 * automatically without any needs to refresh the browser by admin/users.
 * 
 */
public class IngredientListBean implements Serializable {

    //Attribute for this class that holds all the ingredients.
    private static java.util.ArrayList ingredientList;

    //Zero constroctor for IngredientListBean class according to the definitionm of JavaBeans
    public IngredientListBean() {

        //Make an array list so ingredientList can have all the ingredinets as array and the entire ingredients as array list.
        ingredientList = new ArrayList();

        //Database connection to get an instance of connection pool object.
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //SQL query to read all the ingredinets and sort them by name.
        String query = "SELECT * FROM ingredient ORDER BY ingName ASC";

        try {

            //Perform the query and save the quesry result in rs.
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            //Read the result set row by row and put these information in igredientList.
            while(rs.next()) {
                IngredientBean ib = new IngredientBean();
                ib.setIngID(rs.getInt(1));
                ib.setIngName(rs.getString(2));
                ib.setIngPrice(rs.getFloat(3));
                ib.setIngQuantity(rs.getInt(4));
                ingredientList.add(ib);
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
    }

    /**
     * Getter for IngredientListBean class according to the definition of JavaBeans.
     * The aim of using getter is that since attribute is private and it is not reachable
     * outside of this class, to have access to this attribute we need to use getter.
     * @return ingredientList which is attribute of IngredientListBean class as arrayList.
     */
    public ArrayList getIngredientList() {
        return ingredientList;
    }

    /**
     * Setter for IngredientListBean class according to the definition of JavaBeans.
     * The aim of using this setter is that since attribute is private and we can not change it
     * outside of this class, to have the ability to change/set it we need to have this setter method.
     * @param ingredientList is Collection (ArrayList) which contains all the ingredients in the database.
     */
    public void setIngredientList(ArrayList ingredientList) {
        this.ingredientList = ingredientList;
    }


}
