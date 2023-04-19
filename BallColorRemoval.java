import java.util.*;

public class BallColorRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> ballColors = new HashMap<>();

        System.out.println("Enter color and ball count in the format: 'Color: count'. Type 'End' to finish.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("End")) {
                break;
            }
            String[] splitInput = input.split(":");
            String color = splitInput[0].trim();
            int count = Integer.parseInt(splitInput[1].trim());
            ballColors.put(color, count);
        }

        int minimumBallsToRemove = getMinimumBallsToRemove(ballColors);
        System.out.println("Min balls to remove: " + minimumBallsToRemove);
    }

    private static int getMinimumBallsToRemove(Map<String, Integer> ballColors) {
        int totalBalls = 0;
        int maxColorCount = 0;

        for (Integer count : ballColors.values()) {
            totalBalls += count;
            if (count > maxColorCount) {
                maxColorCount = count;
            }
        }

        return totalBalls - maxColorCount;
    }
}
