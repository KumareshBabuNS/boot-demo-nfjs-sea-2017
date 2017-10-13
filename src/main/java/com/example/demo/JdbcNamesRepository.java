package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcNamesRepository implements NamesRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcNamesRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	String nameRowMapper(ResultSet rs, int arg1) throws SQLException {
		return rs.getString("name");
	}
	
	@Override
	public String getFirstName() {
		return jdbc.query("select name from names", this::nameRowMapper).get(0);
	}
	
}
