package day01.ex03;

public class UserIdsGenerator {

    private static UserIdsGenerator instance;
    private static Integer id = 0;

    private UserIdsGenerator() {};

    public static UserIdsGenerator getInstance() {
        if (instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }

    public Integer generateId() { return id++; }

}