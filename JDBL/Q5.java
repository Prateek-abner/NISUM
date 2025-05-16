public List<CourseInfo> getCoursesByStudentId(int studentId) {
    List<CourseInfo> courseList = new ArrayList<>();
    try (Connection conn = DBUtil.getConnection()) {
        String sql = """
            SELECT c.course_name, c.instructor, e.grade 
            FROM enrollments e
            JOIN courses c ON e.course_id = c.id
            WHERE e.student_id = ?
        """;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, studentId);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            courseList.add(new CourseInfo(
                rs.getString("course_name"),
                rs.getString("instructor"),
                rs.getString("grade")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return courseList;
}
