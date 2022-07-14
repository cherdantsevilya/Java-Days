package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

    private Long id;
    private String login;
    private String password;
    private List<Chatroom> rooms;
    private List<Chatroom> activeRooms;

    public User(Long id, String login, String password, List<Chatroom> rooms, List<Chatroom> activeRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rooms = rooms;
        this.activeRooms = activeRooms;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Chatroom> getRooms() {
        return rooms;
    }

    public List<Chatroom> getActiveRooms() {
        return activeRooms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRooms(List<Chatroom> rooms) {
        this.rooms = rooms;
    }

    public void setActiveRooms(List<Chatroom> activeRooms) {
        this.activeRooms = activeRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && login.equals(user.login) && password.equals(user.password) && rooms.equals(user.rooms) && activeRooms.equals(user.activeRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, rooms, activeRooms);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rooms=" + rooms +
                ", activeRooms=" + activeRooms +
                '}';
    }
}
