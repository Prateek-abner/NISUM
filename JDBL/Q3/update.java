public boolean updateStudent(Student student) {
    try (Connection conn = DBUtil.getConnection()) {
        String sql = "UPDATE students SET name=?, email=?, date_of_birth=?, major=?, admission_date=?, gpa=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getEmail());
        stmt.setDate(3, student.getDob());
        stmt.setString(4, student.getMajor());
        stmt.setDate(5, student.getAdmissionDate());
        stmt.setDouble(6, student.getGpa());
        stmt.setInt(7, student.getId());

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
