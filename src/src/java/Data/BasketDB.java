/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.sql.*;

import Model.*;

public class BasketDB {

    public static int insertOrder(OrderBean ob)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;


        String query = "INSERT INTO Orders "
                + "(UserID, price, orderDate, orderNo) "
                + "VALUES "
                + "(?, ?, NOW(), ?)";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ob.getUserID());
            ps.setFloat(2, ob.getOrderPrice());
            ps.setLong(3, ob.getOrderNo());
            return ps.executeUpdate();
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
    /**
     *
     * @param oib an orederitembean to be inserted into DB
     * @return integer value that is equal to the number of the affected rows in DB
     * if it 's value is zero, it means that no row has been updated
     */
    public static int insertOrderItem(OrderItemBean oib)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;


        String query = "INSERT INTO OrderItem "
                + "(orderID, foodID, quantity, foodPrice) "
                + "VALUES "
                + "(?, ?, ?, ?)";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, oib.getOrderID());
            ps.setInt(2, oib.getFoodID());
            ps.setInt(3, oib.getQuantity());
            ps.setFloat(4, oib.getFoodPrice());
            return ps.executeUpdate();
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

    public static int getOrderID(OrderBean ob)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;


        String query = "SELECT orderID FROM Orders "
                + "WHERE userID = ? AND price = ? AND orderNo = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ob.getUserID());
            ps.setFloat(2, ob.getOrderPrice());
            ps.setLong(3,ob.getOrderNo());
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getInt(1);
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
}
