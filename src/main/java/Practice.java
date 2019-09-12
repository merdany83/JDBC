import java.sql.*;

public class Practice {


    public static void main(String[] args) throws SQLException {

        String connection_str = "jdbc:oracle:thin:@34.228.70.164:1521:xe"; // replace ip with your ip
        String db_user = "hr";
        String db_password = "hr";

        Connection conn = DriverManager.getConnection(connection_str, db_user, db_password);

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE
                , ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = stmt.executeQuery("SELECT * FROM countries");
        //  ResultSet rs = stmt.executeQuery("SELECT country_name FROM countries where country_name='Zimbabwe'");
//        while (rs.next()) {
//            System.out.println(
//                    rs.getObject("country_id")
//                            + " " + rs.getObject("region_id") + " " +
//                            rs.getObject("country_name")); }
//        System.out.println("--------------------------------------------------------");
//        while (rs.previous()) {
//            System.out.println(rs.getObject("country_id")
//                    + " " + rs.getObject("region_id")
//                    + " " + rs.getObject("country_name")); }

        rs.absolute(2);
        System.out.println(rs.getObject("country_id")
                + " " + rs.getObject("region_id")
                + " " + rs.getObject("country_name"));

      rs.first();
        System.out.println(rs.getObject("country_id")
                   + " " + rs.getObject("region_id")
                   + " " + rs.getObject("country_name"));
//        rs.beforeFirst();
//               System.out.println(rs.getObject("country_id")
//                + " " + rs.getObject("region_id")
//                + " " + rs.getObject("country_name"));

        rs.last();
        System.out.println(rs.getObject("country_id")
                   + " " + rs.getObject("region_id")
                   + " " + rs.getObject("country_name"));

        rs.close();
        stmt.close();
        conn.close();
}

      //  ResultSet rs1 = stmt.executeQuery("SELECT * FROM countries");
    }


