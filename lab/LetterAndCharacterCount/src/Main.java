import model.WordAndCharacterCounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        WordAndCharacterCounter counter = new WordAndCharacterCounter(inputString);
        counter.countWordsAndCharacters();
        counter.displayResults();
    }
}