package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    NumberWorker numberWorker;

    @BeforeEach
    void beforeEach() {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {13, 113, 3, 97})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 100, 169})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -100, -5})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/data.csv")
    void digitsSum(int x, int y) {
        Assertions.assertEquals(numberWorker.digitSum(x), y);
    }
}
