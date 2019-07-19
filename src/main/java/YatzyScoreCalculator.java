import java.util.List;

public class YatzyScoreCalculator {

    final YatzyHelper yatzyHelper;

    public static final int YATZY_SCORE = 50;

    public YatzyScoreCalculator(YatzyHelper yatzyHelper) {
        this.yatzyHelper = yatzyHelper;
    }

    public int calculateChance(List<Integer> rolls) {
        return rolls.stream().reduce(0, Integer::sum);
    }

    public int calculateYatzy(List<Integer> rolls) {
        return rolls.stream().allMatch(rolls.get(0)::equals) ? YATZY_SCORE : 0;
    }

    public int calculateOnes(List<Integer> rolls){
        return yatzyHelper.sumGivenNumbers(rolls,1);
    }

    public int calculateTwos(List<Integer> rolls){
        return yatzyHelper.sumGivenNumbers(rolls,2);
    }

    public int calculateThrees(List<Integer> rolls){
        return yatzyHelper.sumGivenNumbers(rolls,3);
    }

    public int calculateFours(List<Integer> rolls){
        return yatzyHelper.sumGivenNumbers(rolls,4);
    }

    public int calculateFives(List<Integer> rolls){
        return yatzyHelper.sumGivenNumbers(rolls,5);
    }

    public int calculateSixes(List<Integer> rolls){
        return yatzyHelper.sumGivenNumbers(rolls,6);
    }

    public int calculatePairs(List<Integer> rolls){
        return yatzyHelper.sumMultipleOccurrenceOfHigherValue(rolls,2);
    }

    public int calculateThreeOfAKind(List<Integer> rolls){
        return yatzyHelper.sumMultipleOccurrenceOfHigherValue(rolls,3);
    }

    public int calculateFourOfAKind(List<Integer> rolls){
        return yatzyHelper.sumMultipleOccurrenceOfHigherValue(rolls,4);
    }

    public int calculateTwoPairs(List<Integer> rolls){
        return yatzyHelper.sumMultipleOccurrenceOfHigherValue(rolls,2,2);
    }

    public int calculateFullHouse(List<Integer> rolls){
        return yatzyHelper.sumMultipleOccurrenceOfHigherValue(rolls,2,3);
    }

    public int calculateSmallStraight(List<Integer> rolls){
        return yatzyHelper.calculateStraightScore(rolls,1,5);
    }
    public int calculateLargeStraight(List<Integer> rolls){
        return yatzyHelper.calculateStraightScore(rolls,2,6);
    }

}
