package day01.ex03;

public interface UsersList {
    void addUser(User user);
    User getUserById(int id);
    User getUserByIndex(int index);
    int getNumOfUsers();
}
