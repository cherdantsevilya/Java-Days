package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {
    private DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = null;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String SELECT_QUERY = "SELECT * FROM \"Product\" WHERE identifier = ";
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY + id);
            resultSet.next();
            product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.of(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String SELECT_QUERY = "SELECT * FROM \"Product\"";
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            while (resultSet.next())
                products.add(new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public void save(Product product) {
        try {
            Connection connection = dataSource.getConnection();
            String INSERT_QUERY = "INSERT INTO \"Product\" (identifier, name, price) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setLong(1, product.getIdentifier());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Product product) {
        try {
            Connection connection = dataSource.getConnection();
            String UPDATE_QUERY = "UPDATE \"Product\" SET name = ?, price = ? WHERE identifier = ?;";
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setLong(3, product.getIdentifier());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            String DELETE_QUERY = "DELETE FROM \"Product\" WHERE identifier = ?;";
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
