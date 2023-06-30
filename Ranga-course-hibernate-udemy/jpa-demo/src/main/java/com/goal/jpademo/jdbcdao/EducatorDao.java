package com.goal.jpademo.jdbcdao;

import com.goal.jpademo.entity.jdbc.Educator;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EducatorDao {

    private final JdbcTemplate jdbcTemplate;

    static class StudnetRowMapper implements RowMapper<Educator> {
        @Override
        public Educator mapRow(ResultSet rs, int rowNum) throws SQLException {
            Educator educator = new Educator();
            educator.setId(rs.getInt("id"));
            educator.setName(rs.getString("name"));
            educator.setLocation(rs.getString("location"));
            educator.setBirthDate(rs.getDate("birth_date").toLocalDate());
            return educator;
        }

    }

    public List<Educator> findAll() {
        return jdbcTemplate.query("Select * from Educator", new BeanPropertyRowMapper<>(Educator.class));
    }

    public Educator findById(int id) {
        return jdbcTemplate.queryForObject("select * from Educator where id=?", new Object[]{id},
                new StudnetRowMapper());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Educator where id=?", id);
    }

    public int insert(Educator educator) {
        return jdbcTemplate.update("insert into Educator (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
                educator.getId(), educator.getName(), educator.getLocation(),
                educator.getBirthDate());
    }

    public int update(Educator educator) {
        return jdbcTemplate.update("update Educator " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
                educator.getName(), educator.getLocation(),educator.getBirthDate(),
                educator.getId());
    }
}
