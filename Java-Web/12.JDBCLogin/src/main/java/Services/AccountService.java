package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountService {
    public static void AddUser(Connection con, String username, String password,String email) throws SQLException {
        String sql = "INSERT INTO t_users (username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new SQLException("Error adding user: " + e.getMessage());
        }
    }

}
