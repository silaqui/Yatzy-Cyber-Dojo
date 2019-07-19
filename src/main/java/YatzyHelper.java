import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class YatzyHelper {

    public int sumGivenNumbers(List<Integer> rolls, Integer numberCalculated) {
        return rolls.stream().filter(roll -> roll.equals(numberCalculated)).reduce(0, Integer::sum);
    }

    public int sumMultipleOccurrenceOfHigherValue(List<Integer> rolls, Integer numberOfOccurrence) {
        Map<Integer, Long> countedRolls = countOccurrence(rolls);
        return getScoreForOccurrence(numberOfOccurrence, countedRolls);
    }

    public int sumMultipleOccurrenceOfHigherValue(List<Integer> rolls, Integer firstNumberOfOccurrence, Integer secondNumberOfOccurrence) {
        Map<Integer, Long> countedRolls = countOccurrence(rolls);

        Integer firstScore = getScoreForOccurrence(firstNumberOfOccurrence, countedRolls);

        if (firstScore != 0) {
            countedRolls.remove(firstScore / firstNumberOfOccurrence);
        }

        Integer secondScore = getScoreForOccurrence(secondNumberOfOccurrence, countedRolls);

        if (firstScore != 0 && secondScore != 0) {
            return firstScore + secondScore;
        } else {
            return 0;
        }
    }

    public Map<Integer, Long> countOccurrence(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));
    }

    public Integer getScoreForOccurrence(Integer numberOfOccurrence, Map<Integer, Long> countedRolls) {
        Integer output = 0;
        for (Map.Entry<Integer, Long> entry : countedRolls.entrySet()) {
            if (entry.getValue().equals(Long.valueOf(numberOfOccurrence))) {
                output = Math.toIntExact(entry.getValue() * entry.getKey());
            }
        }
        return output;
    }

    public Integer calculateStraightScore(List<Integer> list, Integer rangeStart, Integer rangeEnd) {

        Set<Integer> set = new HashSet<Integer>(list);
        if (set.size() != list.size() || set.size() != rangeEnd - rangeStart + 1) {
            return 0;
        }
        int score = 0;
        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (set.contains(i)) {
                score += i;
            } else return 0;
        }
        return score;
    }
}
