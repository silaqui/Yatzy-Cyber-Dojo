import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class YatzyScoreCalculatorTest {

    @Mock
    private YatzyHelper yatzyHelper;

    @InjectMocks
    private YatzyScoreCalculator tested;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateChance() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int expected = 6;
        //when
        int actual = tested.calculateChance(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void calculateYatzyPass() {
        //given
        List<Integer> input = Arrays.asList(5, 5, 5, 5);
        int expected = 50;
        //when
        int actual = tested.calculateYatzy(input);
        //then
        assertEquals(50, actual);
    }

    @Test
    public void calculateYatzyFail() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int expected = 0;
        //when
        int actual = tested.calculateYatzy(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void calculateOnes() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int calculatedNumber = 1;
        //when
        tested.calculateOnes(input);
        //then
        verify(yatzyHelper, times(1)).sumGivenNumbers(input, calculatedNumber);
    }

    @Test
    public void calculateTwos() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int calculatedNumber = 2;
        //when
        tested.calculateTwos(input);
        //then
        verify(yatzyHelper, times(1)).sumGivenNumbers(input, calculatedNumber);
    }

    @Test
    public void calculateThrees() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int calculatedNumber = 3;
        //when
        tested.calculateThrees(input);
        //then
        verify(yatzyHelper, times(1)).sumGivenNumbers(input, calculatedNumber);
    }

    @Test
    public void calculateFours() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int calculatedNumber = 4;
        //when
        tested.calculateFours(input);
        //then
        verify(yatzyHelper, times(1)).sumGivenNumbers(input, calculatedNumber);
    }

    @Test
    public void calculateFives() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int calculatedNumber = 5;
        //when
        tested.calculateFives(input);
        //then
        verify(yatzyHelper, times(1)).sumGivenNumbers(input, calculatedNumber);
    }

    @Test
    public void calculateSixes() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int calculatedNumber = 6;
        //when
        tested.calculateSixes(input);
        //then
        verify(yatzyHelper, times(1)).sumGivenNumbers(input, calculatedNumber);
    }

    @Test
    public void calculatePairs() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int occurrence = 2;
        //when
        tested.calculatePairs(input);
        //then
        verify(yatzyHelper, times(1)).sumMultipleOccurrenceOfHigherValue(input, occurrence);
    }

    @Test
    public void calculateThreeOfAKind() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int occurrence = 3;
        //when
        tested.calculateThreeOfAKind(input);
        //then
        verify(yatzyHelper, times(1)).sumMultipleOccurrenceOfHigherValue(input, occurrence);
    }

    @Test
    public void calculateFourOfAKind() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int occurrence = 4;
        //when
        tested.calculateFourOfAKind(input);
        //then
        verify(yatzyHelper, times(1)).sumMultipleOccurrenceOfHigherValue(input, occurrence);
    }

    @Test
    public void calculateTwoPairs() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int occurrenceOne = 2;
        int occurrenceTwo = 2;
        //when
        tested.calculateTwoPairs(input);
        //then
        verify(yatzyHelper, times(1)).sumMultipleOccurrenceOfHigherValue(input, occurrenceOne, occurrenceTwo);
    }

    @Test
    public void calculateFullHouse() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int occurrenceOne = 2;
        int occurrenceTwo = 3;
        //when
        tested.calculateFullHouse(input);
        //then
        verify(yatzyHelper, times(1)).sumMultipleOccurrenceOfHigherValue(input, occurrenceOne, occurrenceTwo);
    }

    @Test
    public void calculateSmallStraight() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int rangeStart = 1;
        int rangeEnd = 5;
        //when
        tested.calculateSmallStraight(input);
        //then
        verify(yatzyHelper, times(1)).calculateStraightScore(input, rangeStart, rangeEnd);
    }

    @Test
    public void calculateLargeStraight() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);
        int rangeStart = 2;
        int rangeEnd = 6;
        //when
        tested.calculateLargeStraight(input);
        //then
        verify(yatzyHelper, times(1)).calculateStraightScore(input, rangeStart, rangeEnd);
    }


}
