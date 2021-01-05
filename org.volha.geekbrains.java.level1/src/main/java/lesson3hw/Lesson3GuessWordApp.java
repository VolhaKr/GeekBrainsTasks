package lesson3hw;

import java.util.Random;
import java.util.Scanner;

/*  2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
            apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы
     */
public class Lesson3GuessWordApp {
    static String word;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        word = wordsArray[random.nextInt(wordsArray.length)];
        System.out.println("It's a secret. The woed to guess is... " + word);
        System.out.println("Guess the word from the list {\"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"}");
        String wordTry = scanner.nextLine();
        boolean continueFlag = true;
        while (continueFlag) {
            if (word.equals(wordTry)) {
                System.out.println("You are right!");
                continueFlag = false;
            }
            if (!word.equals(wordTry)) {
                System.out.println(compareToWord(wordTry));
                wordTry = scanner.nextLine();
            }
        }
    }

    private static String compareToWord(String wordTry) {
        StringBuilder wordToPrint = new StringBuilder("");
        int i;
        for ( i = 0; i < Math.min(word.length(), wordTry.length()); i++ ) {
            if (word.charAt(i) == wordTry.charAt(i)) {
                wordToPrint.append(word.charAt(i));
            } else {
                wordToPrint.append('#');
            }
        }
        for ( int j = i; j < 15; j++ ) {
            wordToPrint.append('#');
        }
        return wordToPrint.toString();
    }
}
