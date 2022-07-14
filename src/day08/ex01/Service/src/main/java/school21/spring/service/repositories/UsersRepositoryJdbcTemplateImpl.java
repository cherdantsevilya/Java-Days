package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource jdbcTemplate) {
        this.jdbcTemplate = new JdbcTemplate(jdbcTemplate);
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM \"User\" WHERE id = ?", new UserMapper(), id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM \"User\"", new UserMapper());
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO \"User\" (id, email) VALUES (?, ?)", entity.getId(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE \"User\" SET email = ? WHERE id = ?", entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM \"User\" WHERE id = ?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM \"User\" WHERE email = ?", new UserMapper(), email);
        return Optional.of(user);
    }

    public static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getLong(1), rs.getString(2));
        }
    }
}
