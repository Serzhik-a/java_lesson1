package ru.home;

public class PizzaClass {

    public static final int MAX_SIZE_PIZZA = 52;    //Максимальный размер пиццы
    private int sizePizza;                   //Размер заказанной пицы
    private StringBuilder addInPizza;              //Пожелания по добавкам

    public PizzaClass(int sizePizza, StringBuilder additions) {
        this.sizePizza = sizePizza;
        this.addInPizza = additions;
    }


    public int getSizePizza() {
        return sizePizza;
    }

    public String getAddInPizza() {
        return addInPizza.toString();
    }
}
