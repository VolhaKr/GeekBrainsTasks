package lesson3;

//        Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер
//        телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев)
//        , тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять лишний функционал
//        (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
//        Консоль использовать только для вывода результатов проверки телефонного справочника.

import java.util.*;

public class PhoneBook {
    HashMap <String, List<Integer>> phoneBook = new HashMap<>();
    public void put(String name, int number) {
        List<Integer> tempNumberList = phoneBook.getOrDefault(name, new ArrayList<Integer>());
        tempNumberList.add(number);
        phoneBook.put(name, tempNumberList);
    }

    public void get(String name){
        System.out.println("Name " + name);
        System.out.println(" phone(s): ");
        try{
            for (int i = 0; i<phoneBook.get(name).size(); i++){
                System.out.println(phoneBook.get(name).get(i));
            }
        }
        catch (NullPointerException e){
            System.out.println("There is no a number for such name");
        }
    }
}
