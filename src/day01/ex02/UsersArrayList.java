package day01.ex02;

import java.util.Objects;

public class UsersArrayList implements UsersList {

    private User[] users;
    private Integer count;

    public UsersArrayList() {
        this.users = new User[10];
        this.count = 0;
    }

    @Override
    public void addUser(User user) {
        if (count == users.length) {
            User[] tmp = new User[users.length * 2];
            for (int i = 0; i < users.length; i++)
                tmp[i] = users[i];
            users = tmp;
        }
        users[count] = user;
        count++;
    }

    @Override
    public User getUserById(Integer id) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(users[i].getId(), id))
                return users[i];
        }
        throw new UserNotFoundException("User with id " + id + " not found");
    }

    @Override
    public User getUserByIndex(Integer index) {
        return this.users[index];
    }

    @Override
    public Integer getNumOfUsers() {
        return this.count;
    }
}
