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

        Optional<Message> optionalMessage = messagesRepository.findById(1L);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            System.out.println(message);
            message.setText("OS");
            messagesRepository.update(message);
            System.out.println();
            System.out.println(message);
        } else {
            System.out.println("No such message in the database");
        }
        hikariDataSource.close();
    }
}
