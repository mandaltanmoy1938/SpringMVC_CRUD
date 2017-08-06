package springmvc_crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_crud.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<User> listAllUser() {
		String sql = "SELECT id, first_name, last_name, address FROM users";
		List<User> userList = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null), new UserMapper());
		return userList;
	}

	public SqlParameterSource getSqlParameterSource(User user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (user != null) {
			paramSource.addValue("id", user.getId());
			paramSource.addValue("first_name", user.getFirstName());
			paramSource.addValue("last_name", user.getLastName());
			paramSource.addValue("address", user.getAddress());
		}
		return paramSource;
	}

	private static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setAddress(rs.getString("address"));
			return user;
		}
	}

	public void addUser(User user) {
		String sql = "INSERT INTO users (first_name, last_name, address) VALUES (:first_name, :last_name, :address)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(user));

	}

	public void updateUser(User user) {
		String sql = "UPDATE users SET first_name = :first_name, last_name = :last_name, address = :address WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(user));
	}

	public void deleteUser(int id) {
		String sql = "DELTE FROM users WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(new User(id)));
	}

	public User findUserById(int id) {
		String sql = "SELECT * FROM users WHERE id = :id";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSource(new User(id)), new UserMapper());
	}

}
