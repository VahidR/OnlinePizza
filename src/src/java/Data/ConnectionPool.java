package Data;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;


/**
 *
 * The aim of using this class is to use Connection pooling in order to Database connectivity.
 * When we use connection pooling instead of for each query the system connects to the database, it
 * connect to the objects which is presented by the connection pooling.
 *
 */
public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSoutce = null;

    /**
     * Zero constructor for ConnectionPool class. The aim of this constructor is to try to connect to the database.
     *
     * @exception e appears when trying to connection to the database is failed in all situations and print the error.
     */
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSoutce = (DataSource) ic.lookup("java:/comp/env/jdbc/PizzaShopDB");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting instance of pool
     * @return pool which is a reference to the connection pool instance.
     */
    public static ConnectionPool getInstance() {
        if(pool == null)
            pool = new ConnectionPool();
        return pool;
    }

    /**
     * Once the connection pool has been created, the application can use this method to access the database.
     *
     * @return datasource which it is connection object if everything goes fine, null otherwise.
     * @exception print SQL stackTrace if something goes wrong in all situations.
     */
    public Connection getConnection() {
        try {
            return dataSoutce.getConnection();
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    /**
     * The aim of using this method is to release the connection pooling. 
     * This method either close the connection or in the case of SQL exception prints stackTrace.
     *
     * @param c is a connection object.
     */
    public void freeConnection(Connection c) {
        try {
            c.close();
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
