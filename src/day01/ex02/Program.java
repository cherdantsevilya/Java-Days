package day01.ex02;

public class Program {
    public static void main(String[] args) {

        UsersList list = new UsersArrayList();
        User john = new User("John", 21);
        User mike = new User("Mike", 543);
        User kevin = new User("Kevin", 5);

        System.out.println(john);
        System.out.println(mike);
        System.out.println(kevin);

        list.addUser(john);
        list.addUser(mike);
        list.addUser(kevin);

        System.out.println("Num of users - " + list.getNumOfUsers());
        System.out.println("User with index 1 - " + list.getUserByIndex(1));
        System.out.println("User with id 2 - " + list.getUserById(2));
        System.out.println("User with id 5 - " + list.getUserById(5));
        System.out.println("User with id 0 - " + list.getUserById(0));
    }
}
