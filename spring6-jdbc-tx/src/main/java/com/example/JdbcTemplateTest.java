package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Map;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testAdd(){
        String sql = "insert into t_emp values(null, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, "colin", 45, "男");
        System.out.println(rows);

        sql = "update t_emp set name=? where id=?";
        rows = jdbcTemplate.update(sql, "colin_zhang", 1);
        System.out.println(rows);


    }

    @Test
    public void testSelectObject() {
        String sql = "select * from t_emp where id=?";
//        Emp result = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
//            Emp emp = new Emp();
//            emp.setId(rs.getInt("id"));
//            emp.setName(rs.getString("name"));
//            emp.setAge(rs.getInt("age"));
//            emp.setSex(rs.getString("sex"));
//
//            return emp;
//        }, 1);

        Emp result = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);

        System.out.println(result);
    }

    @Test
    public void testSelectList() {
        String sql = "select * from t_emp";

        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));

        System.out.println(list);
    }

    @Test
    public void testSelectSingleValue() {
        String sql = "select count(*) from t_emp";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

        System.out.println(count);
    }
}
