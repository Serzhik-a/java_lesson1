package ru.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders {

    static int orderPizzaSize;                                                  //храним размер пицы до размещения в заказ
    static StringBuilder additions;                                              //добавки пожелания
    static Scanner scanner = new Scanner(System.in);                             //объект для чтения из консоли
    static int orderNumber = 0;                                                 //переменная номера заказа
    static List<PizzaClass> pizzaList = new ArrayList<>();                      //массив объектов pizza / заказов

    public static void generateOrder() {
        while (true) {
            System.out.print("Do you wanna some pizza? да/нет: ");           // Опрос перед заказом
            StringBuilder answer = new StringBuilder(scanner.nextLine());         //читаем ответ
            switch (answer.toString().toLowerCase()) {                            //проверка с исправлением регистра
                case ("да"): {                                                  //делаем заказ через функцию
                    orderMake();
                    break;
                }
                case ("нет"): {                                                     // ну как хочешь
                    System.out.println("Goodbye!");
                    return;
                }
                default:
                    System.out.println("Incorrect input");
                    continue;
            }

            pizzaList.add(new PizzaClass(orderPizzaSize, additions));                      //Добавление объекта в список
            System.out.println("Your pizza is cooking now, order number is: " + (orderNumber + 1));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Something interrupt while thread sleep");
                e.printStackTrace();
            }
            System.out.println("Your order #" + (orderNumber + 1) + " pizza size " + pizzaList.get(orderNumber).getSizePizza() +
                    " with " + pizzaList.get(orderNumber).getAddInPizza() + " additions is ready!");       //вывод информации заказчику
            orderNumber++;                                                                                  //инкремент счетчика заказов
        }


    }
    public static void orderMake() {                                                                        //делаем заказ
        System.out.println("Let`s make an order...");
        while (true) {                                              //уточняем детали в цикле
            System.out.print("What size of pizza do you want? (max size is " + PizzaClass.MAX_SIZE_PIZZA + "): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Incorrect input. Need the number.");
                scanner.skip(".*\n");
                continue;
            }
            orderPizzaSize = scanner.nextInt();
            scanner.skip("\n");                                           // nextInt не удаляет символ конца строки, поэтому делаем это вручную
            if (orderPizzaSize <= PizzaClass.MAX_SIZE_PIZZA) {           //проверка размера
                System.out.print("May be some additions? : ");
                additions = new StringBuilder(scanner.nextLine());
                if (additions.length() == 0) {
                    additions.append("no");
                }
                break;
            } else {
                System.out.println("It`s too big.");
            }
        }
    }
}
