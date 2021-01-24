package lesson3;
import java.util.HashMap;
import java.util.Map;

public class MainApp {
    //Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    static String [] wordsArray = {
             "January",
             "April",
             "Ferbruary",
             "September",
             "March",
             "April",
             "May",
             "June",
             "March",
             "April",
             "July",
             "August",
             "September",
             "april",
             "November",
             "December",
             "March",
             "April",
     };
 //   Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать, сколько раз встречается каждое слово.
    public static void countWords (String[] wordsArray){
        Map<String, Integer> wordsCount = new HashMap<>();
                for (String word : wordsArray){
                    Integer count = wordsCount.getOrDefault(word,0);
                    wordsCount.put(word,count+1);
        }
                System.out.println(wordsCount);
    }

    public static void main(String[] args) {
        countWords(wordsArray);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.put("Uladzimir", 1111222333);
        phoneBook.put("Uladzimir", 1111222303);
        phoneBook.put("Gedymin", 1111522333);
        phoneBook.put("Alherd", 1111442333);
        phoneBook.get("Uladzimir");
        phoneBook.get("Ivan");

    }

}
