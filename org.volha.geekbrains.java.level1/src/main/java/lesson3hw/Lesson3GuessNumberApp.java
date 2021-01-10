package lesson3hw;

//1. Написать программу, которая загадывает случайное число от 0 до 9,
// и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
// или меньше. После победы или проигрыша выводится запрос – то«Поврить игру еще раз?
// 1 – да / 0 – нет»(1 – повторить, 0 – нет).

import java.util.Random;
import java.util.Scanner;

public class Lesson3GuessNumberApp {
    static int numberToGuess;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int continueFlag = 1;
        while (continueFlag == 1) {
            System.out.println("Guess the number. Input from 0 to 9. You have three tries. ");
            numberToGuess = createNumber();
            System.out.println("It's a secret. Number to guess is..." + numberToGuess);
            if (guess()) {
                System.out.println("Yes, you are right!");
            } else {
                System.out.println("No, you are wrong.");
            }
            continueFlag = askIfContinue();
        }
    }

    static int askIfContinue() {
        System.out.println(" Повторить игру еще раз? 1 – да / 0 – нет.");
        return scanner.nextInt();
    }

    static int createNumber() {
        Random random = new Random();
        return random.nextInt(10);
       }

    static boolean guess() {
        for ( int k = 1; k <= 3; k++ ) {
            int inputNumber = scanner.nextInt();
            if (inputNumber == numberToGuess) {
                return true;
            }
        }
        return false;
    }
}
