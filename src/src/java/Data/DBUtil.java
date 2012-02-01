package Data;

import java.sql.*;

/**
 * The aim of using this class is to close statements and result sets in a easier way.
 *
 */
public class DBUtil {

    /**
     * Try to close a statement. If everything goes fine then the statement will be closed otherwise it prints out the stackTrace.
     *
     * @param s is a sql statement that should be closed.
     */
    public static void closeStatement(Statement s) {
        try {
            if(s != null)
                s.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Try to close a prepared statement. If everything goes fine then the statement will be closed otherwise it prints out the stackTrace.
     *
     * @param ps is a prepared sql statement that should be closed.
     */
    public static void closePreparedStatement(Statement ps) {
        try {
            if(ps != null)
                ps.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Try to close the result set. If everything goes fine then the result will be closed otherwise it prints out the stackTrace.
     * 
     * @param rs is the result set that should be closed.
     */
    public static void closeResultSet(ResultSet rs) {
        try {
            if(rs != null)
                rs.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
