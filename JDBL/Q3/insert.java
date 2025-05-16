public boolean insertStudent(Student student) {
    try (Connection conn = DBUtil.getConnection()) {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, student.getId());
        stmt.setString(2, student.getName());
        stmt.setString(3, student.getEmail());
        stmt.setDate(4, student.getDob());
        stmt.setString(5, student.getMajor());
        stmt.setDate(6, student.getAdmissionDate());
        stmt.setDouble(7, student.getGpa());
        
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
