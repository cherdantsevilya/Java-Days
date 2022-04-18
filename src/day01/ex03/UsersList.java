package day01.ex03;

import day01.ex02.User;

public interface UsersList {
    void addUser(day01.ex02.User user);
    day01.ex02.User getUserById(int id);
    User getUserByIndex(int index);
    int getNumOfUsers();
}
