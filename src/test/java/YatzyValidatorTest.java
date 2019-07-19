import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class YatzyValidatorTest {

    public static final int DICE_LOWEST_VALUE = 1;
    public static final int DICE_HIGHEST_VALUE = 6;

    @Test(expected = IllegalArgumentException.class)
    public void validateNumberOfRollsFails() {
        //given
        YatzyValidator tested = new YatzyValidator();

        List<Integer> input = Arrays.asList(1, 2, 3);
        //when
        tested.validateNumberOfRolls(input);
        //then
    }

    @Test()
    public void validateNumberOfRollsPass() {
        //given
        YatzyValidator tested = new YatzyValidator();

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        //when
        tested.validateNumberOfRolls(input);
        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateValuesOfRollsFailsLowerValue() {
        //given
        YatzyValidator tested = new YatzyValidator();

        List<Integer> input = Arrays.asList(DICE_LOWEST_VALUE-1);
        //when
        tested.validateValuesOfRolls(input);
        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateValuesOfRollsFailsHigherValue() {
        //given
        YatzyValidator tested = new YatzyValidator();

        List<Integer> input = Arrays.asList(DICE_HIGHEST_VALUE+1);
        //when
        tested.validateValuesOfRolls(input);
        //then
    }

    @Test()
    public void validateValuesOfRollsPass() {
        //given
        YatzyValidator tested = new YatzyValidator();

        List<Integer> input = Arrays.asList(DICE_LOWEST_VALUE, YatzyValidator.DICE_HIGHEST_VALUE);
        //when
        tested.validateValuesOfRolls(input);
        //then
    }

}
