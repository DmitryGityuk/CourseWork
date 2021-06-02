package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/***
 * Класс описывает список потенциальных затрат и работы с ними
 */
public class PotentialExpenses implements ServiceList {
    /***
     * Список затрат
     */
    private List<Item> itemList;
    /***
     * Стоимость траты
     */
    BigDecimal сost;

    public PotentialExpenses() {
        this.itemList = new ArrayList<>();
        this.сost = new BigDecimal(0);
    }

    /***
     * Метод добавления новой потенциальной затраты
     *
     * @param item - затрата
     */
    public void add(Item item) {
        itemList.add(item);
        сost.add(item.getPrice()); //так можно будет сохранить промежуточную сумму по мере добавления
    }

    /***
     * Метод производит сортировку по алфавиту
     *
     */
    public void sortedAlphabet(){
        itemList.stream().sorted(Comparator.comparing(Item::getName)).forEach(out::println);
    }

    /***
     * Метод производит сортировку по приоритету
     */
    public void sortedPriority(){
        itemList.stream().sorted(Comparator.comparing(Item::getPriority)).forEach(out::println);
    }

    /***
     * Метод получения общей суммы затрат
     *
     */
    @Override
    public void getTotalCosts() {
        BigDecimal total = itemList
                .stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма затрат " + total);
    }

    /***
     * Метод производит печать всего списка потенциальных затрат
     */
    @Override
    public void print() {
        itemList.stream().forEach(out::println);
    }
}

/***
 * Класс описывает потенциальную затрату
 */
class Item {
    /***
     * Название траты
     */
    String name;
    /***
     * стоимость траты
     */
    BigDecimal price;
    /***
     * количество
     */
    int priority;

    public Item(String name, BigDecimal price, int priority) {
        this.name = name;
        this.price = price;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return this.name + " (" + " price is " + getPrice() + ", in priority " + this.priority + ')';
    }
}

class TestExpenses {
    public static void main(String[] args) {
        PotentialExpenses expenses = new PotentialExpenses();
        Item item = new Item("Iphone", new BigDecimal(70000.00), 5);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        Item item1 = new Item("Toaster", new BigDecimal(1500.00), 1);
        items.add(item1);
        Item item2 = new Item("CoffeeMachine", new BigDecimal(25000.00), 4);
        items.add(item2);
        expenses.add(item);
        expenses.add(item1);
        expenses.add(item2);
        expenses.print();
        expenses.getTotalCosts();
        expenses.sortedAlphabet();


    }
}
