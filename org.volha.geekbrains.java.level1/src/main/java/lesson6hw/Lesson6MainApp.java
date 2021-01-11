package lesson6hw;

public class Lesson6MainApp {
//    Создать классы Собака и Кот с наследованием от класса Животное.
//    Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//    У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//            * Добавить подсчет созданных котов, собак и животных.

    public static void main(String[] args) {
        Cat catJhon = new Cat("Jhon");
        Cat catBob = new Cat("Bod");
        Cat catJack = new Cat("Jack");
        Cat catSam = new Cat("Sam");
        Cat catTim = new Cat("Tim");
        catTim.run(0);
        catBob.run(-10);
        catJack.run(150);
        catSam.run(350);
        catJhon.swim(1);
        Dog dogBlack = new Dog("Black");
        Dog dogGrey = new Dog("Grey");
        Dog dogWhite = new Dog("White");
        Dog dogBrown = new Dog("Brown");
        dogBlack.run(-2);
        dogGrey.run(0);
        dogGrey.run(500);
        dogBrown.run(678);
        dogBlack.swim(-10);
        dogBlack.swim(15);
        dogBlack.swim(3);
        System.out.println("There are " + Animal.animalsNumber + " animals.");
        System.out.println("There are " + Cat.catsNumber + " cats.");
    }
}


