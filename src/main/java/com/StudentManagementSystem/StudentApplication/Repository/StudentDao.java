package com.StudentManagementSystem.StudentApplication.Repository;

import com.StudentManagementSystem.StudentApplication.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;
    public StudentDao( JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    private final class StudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNu) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setFee(rs.getLong("fee"));
            student.setStandard(rs.getInt("standard"));
            return student;
        }
    }
        public List<Student> findAll(){
            String query1 = "SELECT * FROM STUDENT_TABLE";
            return jdbcTemplate.query(query1,new StudentMapper());
        }
        public int saveStudent(Student student){
            String query1 = "INSERT INTO STUDENT_TABLE(ID,NAME,FEE,STANDARD) values (?,?,?,?)";
            return jdbcTemplate.update(query1,student.getId(),student.getName(),student.getFee(),student.getStandard());
        }
        public Student getStudent(int id) {
            String query = "SELECT * FROM STUDENT_TABLE WHERE id = ?";
            try {
                return jdbcTemplate.queryForObject(query, new Object[]{id}, new StudentMapper());
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        }
        public int updateStudent(Student student){
            String query1 = "UPDATE student_table SET name = ?, fee = ?, standard = ? WHERE id = ?";
            return jdbcTemplate.update(query1,student.getName(),student.getFee(),student.getStandard(),student.getId());

        }
        public int deleteStudent(int id){
            String query1 = "DELETE FROM STUDENT_TABLE WHERE ID = ?";
            return jdbcTemplate.update(query1,id);
        }
}
