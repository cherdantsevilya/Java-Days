package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariDataSource.setUsername("pkari");
        hikariDataSource.setPassword("");

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message ID");
        System.out.print("-> ");
        Optional<Message> message = messagesRepository.findById(scanner.nextLong());
        if (message.isPresent()) {
            System.out.println(message.get());
        } else {
            System.out.println("There is nos such ID in the database");
        }
        hikariDataSource.close();
    }
}
