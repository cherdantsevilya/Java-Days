package school21.spring.service.repositories;

import com.zaxxer.hikari.HikariDataSource;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private DataSource dataSource;

    public UsersRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String SELECT_QUERY = "SELECT * FROM \"User\" WHERE id = ";
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY + id);
            resultSet.next();
            user = new User(resultSet.getLong(1), resultSet.getString(2));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String SELECT_QUERY = "SELECT * FROM \"User\"";
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            while (resultSet.next())
                users.add(new User(resultSet.getLong(1), resultSet.getString(2)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void save(User entity) {
        try {
            Connection connection = dataSource.getConnection();
            String INSERT_QUERY = "INSERT INTO \"User\" (id, email) VALUES (?, ?);";
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(User entity) {
        try {
            Connection connection = dataSource.getConnection();
            String UPDATE_QUERY = "UPDATE \"Message\" SET email = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            String DELETE_QUERY = "DELETE FROM \"User\" WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = null;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String SELECT_QUERY = "SELECT * FROM \"User\" WHERE email = ";
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY + email);
            resultSet.next();
            user = new User(resultSet.getLong(1), resultSet.getString(2));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.of(user);
    }
}
