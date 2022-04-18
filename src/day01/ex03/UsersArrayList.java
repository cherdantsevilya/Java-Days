package day01.ex03;

import day01.ex02.User;

public class UsersArrayList implements UsersList {

    private day01.ex02.User[] users;
    private int count;

    public UsersArrayList() {
        this.users = new day01.ex02.User[10];
        this.count = 0;
    }

    @Override
    public void addUser(day01.ex02.User user) {
        if (count == users.length) {
            day01.ex02.User[] tmp = new day01.ex02.User[users.length * 2];
            for (int i = 0; i < users.length; i++)
                tmp[i] = users[i];
            users = tmp;
        }
        users[count] = user;
        count++;
    }

    @Override
    public day01.ex02.User getUserById(int id) {
        for (int i = 0; i < count; i++) {
            if (users[i].getId() == id)
                return users[i];
        }
        throw new UserNotFoundException("User with id " + id + " not found");
    }

    @Override
    public User getUserByIndex(int index) {
        return this.users[index];
    }

    @Override
    public int getNumOfUsers() {
        return this.count;
    }
}
