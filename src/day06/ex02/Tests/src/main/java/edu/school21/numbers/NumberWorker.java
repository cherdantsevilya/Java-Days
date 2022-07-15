package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        if (number < 2) {
            throw new IllegalNumberException("Wrong number");
        }
        else {
            int count;
            for (count = 2; count * count <= number; count++) {
                if (number % count == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public int digitSum(int number) {
        int result = 0;
        while(number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String message) {
        super(message);
    }
}
