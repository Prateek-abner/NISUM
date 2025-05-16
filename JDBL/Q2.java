import java.sql.*;

public class StudentDAO {
    public Student getStudentById(int id) {
        Student student = null;
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getDate("date_of_birth"),
                    rs.getString("major"),
                    rs.getDate("admission_date"),
                    rs.getDouble("gpa")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
