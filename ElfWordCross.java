import java.util.Scanner;

public class ElfWordCross {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first word:");
        String firstWord = scanner.nextLine().toLowerCase();

        System.out.println("Enter the second word:");
        String secondWord = scanner.nextLine().toLowerCase();

        int removedLettersCount = countRemovedLetters(firstWord, secondWord) + countRemovedLetters(secondWord, firstWord);

        System.out.println("Removed letters count: " + removedLettersCount);
    }

    public static int countRemovedLetters(String word, String otherWord) {
        int removedLettersCount = 0;

        for (char c : word.toCharArray()) {
            if (otherWord.contains(Character.toString(c))) {
                otherWord = otherWord.replaceFirst(Character.toString(c), "");
            } else {
                removedLettersCount++;
            }
        }

        return removedLettersCount;
    }
}