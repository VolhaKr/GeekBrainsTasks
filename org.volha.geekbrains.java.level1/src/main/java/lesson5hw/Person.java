package lesson5hw;

public class Person {

    //    Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//    Конструктор класса должен заполнять эти поля при создании объекта.
//    Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    String name;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Person(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.printf("%25s", name);
        System.out.printf("%20s", position);
        System.out.printf("%25s", email);
        System.out.printf("%15s", phoneNumber);
        System.out.printf("%15d", salary);
        System.out.printf("%4d", age);
        System.out.println();

    }
}
