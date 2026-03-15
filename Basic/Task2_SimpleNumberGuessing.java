package Basic;

import java.util.Random;
import java.util.Scanner;

class SimpleNumberGuessingGame {

    void numberGuessing() {
        Random random = new Random();
        int randomNum = random.nextInt(10);

        Scanner sc = new Scanner(System.in);

        System.out.println("---------------Welcome to number guessing game-----------");

        System.out.println("Rules:\nyou have 3 attempts to guess number.");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Guess Number - Attempt :" + i);
            int guessNum = sc.nextInt();

            if (randomNum == guessNum) {
                System.out.println("You Win the Match as guessed correct number.......");
                break;
            } else if (guessNum > randomNum) {
                System.out.println("too high");
            } else {
                System.out.println("too low");
            }
        }
        sc.close();
    }

    public static void main(String[] args) {

        SimpleNumberGuessingGame simpleNumberGuessingGame = new SimpleNumberGuessingGame();
        simpleNumberGuessingGame.numberGuessing();
    }
}
