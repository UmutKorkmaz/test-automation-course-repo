import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/localdb";
        String user = "root";
        String password = "localdbpass";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM umut_korkmaz");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
