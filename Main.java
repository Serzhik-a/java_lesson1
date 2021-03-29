package ru.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        boolean orderComplete = false;          // флаг завершения заказа
        String orderPizzaSize = "0";                  //храним размер пицы до размещения в заказ
        String additions = "no";                       //добавки пожелания
        Scanner scanner = new Scanner(System.in); //объект для чтения из консоли
        int orderNumber = 0;                        //переменная номера заказа
        List<PizzaClass> pizzaList = new ArrayList<>(); //массив объектов pizza / заказов

        while (!orderComplete) {
            System.out.print("Do you wanna some pizza? y/n: ");           // Опрос перед заказом
            String inputstring = scanner.nextLine();                        //читаем ответ
            switch (inputstring.toLowerCase()) {                            //проверка с исправлением регистра
                case ("y"): {
                    System.out.println("Let`s make an order...");
                    while (true) {                                          //уточняем детали в цикле

                        System.out.print("What size of pizza do you want? (max size is " + PizzaClass.maxSizePizza + "): ");
                        orderPizzaSize = scanner.nextLine();
                        if (Integer.parseInt(orderPizzaSize) <= PizzaClass.maxSizePizza) {           //проверка размера
                            System.out.print("May be some additions? If no - leave the blank: ");
                            additions = scanner.nextLine();
                            if (additions.isEmpty())
                                additions = "no";
                            break;
                        } else {
                            System.out.println("It`s too big.");
                        }
                    }
                    break;
                }
                case ("n"): {                                               // ну как хочешь
                    System.out.println("Goodbye!");
                    orderComplete = true;
                    return;
                }
                default:
                    System.out.println("Incorrect input");
                    continue;
            }

            pizzaList.add(new PizzaClass(Integer.parseInt(orderPizzaSize), additions));                      //Добавление объекта в список
            System.out.println("Your pizza is cooking now, order number is: " + (orderNumber + 1));
            Thread.sleep(5000);
            System.out.println("Your order #" + (orderNumber + 1) + " pizza size " + pizzaList.get(orderNumber).getSizePizza() +
                    " with " + pizzaList.get(orderNumber).getAddInPizza() + " additions is ready!");       //вывод информации заказчику
            orderNumber++;                                                                                  //инкремент счетчика заказов
        }

    }
}
