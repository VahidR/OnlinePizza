/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;


import java.sql.*;
import Model.*;

public class IngredientDB {

    public static int updateIngQuantity(IngredientBean ib )
    {
         ConnectionPool pool = ConnectionPool.getInstance();

        Connection connection = pool.getConnection();
        PreparedStatement ps = null, psU = null;
        ResultSet rs = null;

        String query = "SELECT * FROM ingredient "
                + "WHERE ingID = ?";
        String updateQ = "UPDATE ingredient SET quantity = ? WHERE ingID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            psU = connection.prepareStatement(updateQ);
            ps.setInt(1, ib.getIngID());
            rs = ps.executeQuery();
            if (rs.next()){
                psU.setInt(1, rs.getInt(4) - ib.getIngQuantity());
                psU.setInt(2, ib.getIngID());
                return psU.executeUpdate();
            }
            else
                return 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }


    }

    public static void updateIngQuantity1(int ingID, int ingQuantity)
    {
        try
        {
        ConnectionPool pool = ConnectionPool.getInstance();

        Connection connection = pool.getConnection();


        CallableStatement PreparedFunc = connection.prepareCall
                                ("{ call add_ingredient(?, ?) }");
                PreparedFunc.setInt(1, ingID);
                PreparedFunc.setInt(2, ingQuantity);
                PreparedFunc.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();

        }
        finally
        {

            
        }


    }
    

}
