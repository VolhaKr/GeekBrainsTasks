package lesson5hw;

public class Lesson5MainApp {
    //    Создать массив из 5 сотрудников.
//            Пример:
//    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//    persArray[1] = new Person(...);
//...
//    persArray[4] = new Person(...);
//    С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

//    Person[] persArray = new Person[5];
//    persArray[0] =
//    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);

    //    persArray[1] = new Person(...);
//...
//    persArray[4] = new Person(...);
    public static final int OLD_AGE = 40;

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Glebov Gleb", "Engineer", "ggleb@mailbox.com", "812312892", 30001, 41);
        persArray[2] = new Person("Petrov Petr", "Manager", "ppetr@mailbox.com", "812923123", 40000, 25);
        persArray[3] = new Person("Pavlov Pavel", "Analyst", "ppavel@mailbox.com", "812312923", 45000, 50);
        persArray[4] = new Person("Ignatov Ignat", "Tester", "iignat@mailbox.com", "892311111", 25000, 30);

        System.out.println("                           All Employees:");
        System.out.printf("%25s %20s %25s %15s %12s %4s %n", "NAME", "POSITION", "EMAIL", "PHONE NUMBER", "SALARY", "AGE");
        for ( Person person : persArray ) {
            person.printInfo();
        }
        System.out.println("                           Employees older than " + OLD_AGE);
        System.out.printf("%25s %20s %25s %15s %12s %4s %n", "NAME", "POSITION", "EMAIL", "PHONE NUMBER", "SALARY", "AGE");
        // System.out.println();
        for ( int i = 0; i < persArray.length; i++ ) {
            if (persArray[i].getAge() > OLD_AGE) {
                persArray[i].printInfo();
            }
        }
    }
}

