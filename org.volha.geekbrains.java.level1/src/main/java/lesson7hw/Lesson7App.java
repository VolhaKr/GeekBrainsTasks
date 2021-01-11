package lesson7hw;

import java.util.Random;

public class Lesson7App {
    //    Расширить задачу про котов и тарелки с едой.
//    Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
//    Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//    Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//    Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
//    Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
    public static void main(String[] args) {
        int catsNumber = 10;
        int foodAtPlate = 20;
        Cat[] cat = new Cat[catsNumber];
        Random random = new Random();
        for ( int i = 0; i < catsNumber; i++ ) {
            cat[i] = new Cat("Bars" + i, random.nextInt(10));
        }
        Plate plate = new Plate(foodAtPlate);
        plate.info();
        for ( Cat catI : cat ) {
            catI.eat(plate);
        }
        plate.info();
        for ( Cat catI : cat ) {
            catI.info();
        }
        plate.increaseFood(110);
        plate.info();
        for ( Cat catI : cat ) {
            catI.eat(plate);
        }
        plate.info();
        for ( Cat catI : cat ) {
            catI.info();
        }
    }
}
