import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class YatzyHelperTest {

    YatzyHelper tested = new YatzyHelper();

    @Test
    public void sumGivenNumbersNoMatch() {
        //given
        List<Integer> input = Arrays.asList(5, 5, 5, 5);
        int numbersToCount = 4;
        int expected = 0;
        //when
        int actual = tested.sumGivenNumbers(input, numbersToCount);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumGivenNumbers() {
        //given
        List<Integer> input = Arrays.asList(5, 5, 1, 2, 3);
        int numbersToCount = 5;
        int expected = 10;
        //when
        int actual = tested.sumGivenNumbers(input, numbersToCount);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumMultipleOccurrenceOfHigherValueNoOccurrence() {
        //given
        List<Integer> input = Arrays.asList(5, 5);
        int numberOfOccurrence = 3;
        int expected = 0;
        //when
        int actual = tested.sumMultipleOccurrenceOfHigherValue(input, numberOfOccurrence);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumMultipleOccurrenceOfHigherValueOccurrenceTooManyTimes() {
        //given
        List<Integer> input = Arrays.asList(5, 5, 5, 5);
        int numberOfOccurrence = 3;
        int expected = 0;
        //when
        int actual = tested.sumMultipleOccurrenceOfHigherValue(input, numberOfOccurrence);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumMultipleOccurrenceOfHigherValue() {
        //given
        List<Integer> input = Arrays.asList(5, 5, 5, 5);
        int numberOfOccurrence = 4;
        int expected = 20;
        //when
        int actual = tested.sumMultipleOccurrenceOfHigherValue(input, numberOfOccurrence);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumMultipleOccurrenceOfHigherValueMultiplePairs() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 5, 5);
        int numberOfOccurrence = 2;
        int expected = 10;
        //when
        int actual = tested.sumMultipleOccurrenceOfHigherValue(input, numberOfOccurrence);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void countOccurrence() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 5, 5);
        Map<Integer, Long> expected = new HashMap<Integer, Long>();
        expected.put(1, 2l);
        expected.put(5, 2l);
        //when
        Map<Integer, Long> actual = tested.countOccurrence(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getScoreForOccurrence() {
        //given
        Map<Integer, Long> input = new HashMap<Integer, Long>();
        input.put(1, 2l);
        input.put(5, 2l);
        Integer expected = 10;
        //when
        Integer actual = tested.getScoreForOccurrence(2, input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getScoreForOccurrenceNoOccurrence() {
        //given
        Map<Integer, Long> input = new HashMap<Integer, Long>();
        input.put(1, 2l);
        input.put(5, 2l);
        Integer expected = 0;
        //when
        Integer actual = tested.getScoreForOccurrence(3, input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumMultipleOccurrenceOfHigherValueTwoOccurrenceNoMatch() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 5, 5);
        int numberOfOccurrenceOne = 2;
        int numberOfOccurrenceTwo = 3;
        int expected = 0;
        //when
        int actual = tested.sumMultipleOccurrenceOfHigherValue(input, numberOfOccurrenceOne, numberOfOccurrenceTwo);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumMultipleOccurrenceOfHigherValueTwoOccurrence() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 5, 5);
        int numberOfOccurrenceOne = 2;
        int numberOfOccurrenceTwo = 2;
        int expected = 12;
        //when
        int actual = tested.sumMultipleOccurrenceOfHigherValue(input, numberOfOccurrenceOne, numberOfOccurrenceTwo);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sumMultipleOccurrenceOfHigherValueDoubleAndTriple() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 1, 2, 2, 5, 5);
        int numberOfOccurrenceOne = 2;
        int numberOfOccurrenceTwo = 3;
        int expected = 13;
        //when
        int actual = tested.sumMultipleOccurrenceOfHigherValue(input, numberOfOccurrenceOne, numberOfOccurrenceTwo);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void calculateStraightScoreInvalidInputDuplicate() {
        //given
        List<Integer> input = Arrays.asList(4, 2, 2, 3);
        int rangeStart = 1;
        int rangeEnd = 3;
        int expected = 0;
        //when
        int actual = tested.calculateStraightScore(input, rangeStart, rangeEnd);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void calculateStraightScoreInvalidInputWrongRange() {
        //given
        List<Integer> input = Arrays.asList(4, 1, 2, 3);
        int rangeStart = 1;
        int rangeEnd = 3;
        int expected = 0;
        //when
        int actual = tested.calculateStraightScore(input, rangeStart, rangeEnd);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRangeScore() {
        //given
        List<Integer> input = Arrays.asList(4, 1, 2, 3);
        int rangeStart = 1;
        int rangeEnd = 4;
        int expected = 10;
        //when
        int actual = tested.calculateStraightScore(input, rangeStart, rangeEnd);
        //then
        assertEquals(expected, actual);
    }

}
