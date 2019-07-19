import java.util.List;

public class YatzyValidator {

    public static final int NUMBER_OF_ROLLS_ALLOWED = 5;
    public static final String INVALID_NUMBER_OF_ROLLS_ERROR = "Invalid number of rolls.";
    public static final String INVALID_VALUES_OF_ROLLS_ERROR = "Invalid values of rolls.";
    public static final int DICE_LOWEST_VALUE = 1;
    public static final int DICE_HIGHEST_VALUE = 6;

    public void validateNumberOfRolls(List<Integer> rolls) throws IllegalArgumentException{
        if (!(rolls.size() == NUMBER_OF_ROLLS_ALLOWED)) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_ROLLS_ERROR);
        }
    }

    public void validateValuesOfRolls(List<Integer> rolls) throws IllegalArgumentException {
        if (rolls.stream().allMatch(roll -> roll < DICE_LOWEST_VALUE || roll > DICE_HIGHEST_VALUE)) {
            throw new IllegalArgumentException(INVALID_VALUES_OF_ROLLS_ERROR);
        }
    }

}
