package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariDataSource.setUsername("pkari");
        hikariDataSource.setPassword("");

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        User author = new User( 3L, "Kevin", "1111", new ArrayList(), new ArrayList());
        Chatroom room = new Chatroom(2L, "internship", author, new ArrayList());
        Message message = new Message(null, author, room, "анонс", LocalDateTime.now());

        messagesRepository.save(message);
        System.out.println(message);
        hikariDataSource.close();
    }
}
