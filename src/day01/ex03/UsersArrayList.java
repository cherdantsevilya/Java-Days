package day01.ex03;

public class UsersArrayList implements UsersList {

    private User[] users;
    private int count;

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
    public User getUserById(int id) {
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
