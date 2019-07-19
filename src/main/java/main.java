import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        YatzyValidator validator = new YatzyValidator();

        Scanner reader = new Scanner(System.in);

        while (true) {

            System.out.println("Write 'exit' to exit");
            System.out.println("Enter your rolls (use , as separator): ");
            String input = reader.next();
            if (input.equals("exit")) {
                break;
            }
            String[] stringArray = input.split(",");
            List<Integer> rolls = new ArrayList<>();
            for (String s : stringArray) {
                try {
                    rolls.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("Atleast one of numbers was invalid");
                }
            }
            try {
                validator.validateNumberOfRolls(rolls);
                validator.validateValuesOfRolls(rolls);

                System.out.println("What score you want to calculate for rolls: " + rolls + "?");
                System.out.println("1.calculate Chance");
                System.out.println("2.calculate Yatzy");
                System.out.println("3.calculate Ones");
                System.out.println("4.calculate Twos");
                System.out.println("5.calculate Threes");
                System.out.println("6.calculate Fours");
                System.out.println("7.calculate Fives");
                System.out.println("8.calculate Sixes");
                System.out.println("9.calculate Pairs");
                System.out.println("10.calculate TwoPairs");
                System.out.println("11.calculate Three Of A Kind");
                System.out.println("12.calculate Four Of A Kind");
                System.out.println("13.calculate Full House");
                System.out.println("14.calculate Small Straight");
                System.out.println("15.calculate Large Straight");

                try {
                    int score = calculateForPickedCategory(rolls, Integer.parseInt(reader.next()));
                    System.out.println("Your Score: " + score);
                } catch (NumberFormatException e) {
                    System.out.println("I don't know what to do");

                }

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid rolls");
            }
        }
        reader.close();
    }

    public static int calculateForPickedCategory(List<Integer> rolls, Integer pickedCategory) {
        YatzyHelper yatzyHelper = new YatzyHelper();
        YatzyScoreCalculator calculator = new YatzyScoreCalculator(yatzyHelper);
        switch (pickedCategory) {
            case 1:
                return calculator.calculateChance(rolls);
            case 2:
                return calculator.calculateYatzy(rolls);
            case 3:
                return calculator.calculateOnes(rolls);
            case 4:
                return calculator.calculateTwos(rolls);
            case 5:
                return calculator.calculateThrees(rolls);
            case 6:
                return calculator.calculateFours(rolls);
            case 7:
                return calculator.calculateFives(rolls);
            case 8:
                return calculator.calculateSixes(rolls);
            case 9:
                return calculator.calculatePairs(rolls);
            case 10:
                return calculator.calculateTwoPairs(rolls);
            case 11:
                return calculator.calculateThreeOfAKind(rolls);
            case 12:
                return calculator.calculateFourOfAKind(rolls);
            case 13:
                return calculator.calculateFullHouse(rolls);
            case 14:
                return calculator.calculateSmallStraight(rolls);
            case 15:
                return calculator.calculateLargeStraight(rolls);
            default:
                return 0;
        }
    }
}



