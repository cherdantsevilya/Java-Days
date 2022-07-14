package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private final DataSource dataSource;
    private final String SELECT_QUERY = "SELECT * FROM \"Message\" WHERE id = ";

    public MessagesRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) {
        Optional<Message> optionalMessage = Optional.empty();
        Message message = null;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY + id);
            resultSet.next();

            User user = new User(1L, "Tom", "12345", null, null);
            Chatroom chatroom = new Chatroom(1L, "general", null, null);
            message = new Message(resultSet.getLong("id"), user, chatroom, resultSet.getString("text"), resultSet.getObject(5, LocalDateTime.class));

            optionalMessage = Optional.of(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalMessage;
    }
}
