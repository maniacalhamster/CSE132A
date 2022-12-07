// import JDBC
import java.sql.*;
import java.util.Arrays;

public class FTM {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Applications do not need to explicitly load the org.postgresql
        // driver will be loaded by PostgreSQL as long as driver's jar file is in path 

        String URL = "jdbc:postgresql://ubuntu/postgres";
        String user = "marethyu";
        String password = "tyrfing";

        try {
            URL= args[0];
            user= args[1];
            password  = args[2];
        } catch (Exception e) {
            // System.err.println("Issues reading in params: " + Arrays.toString(args));
            // e.printStackTrace();
            // return;

            // Continue w/ defaults (local WSL testing) params defined
            // uncomment above before submitting
        }

        // Connect to local database
        Connection conn = DriverManager.getConnection(URL, user, password);

        // Form and Execute queries
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT age, name FROM Student");

        // Close all resources after use (any results, statements, connections)
        rset.close();
        stmt.close();
        conn.close();
    }
}