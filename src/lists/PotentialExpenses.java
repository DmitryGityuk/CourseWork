package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class PotentialExpenses implements ServiceList {
    private List<Item> itemList;
    BigDecimal сost;

    public PotentialExpenses() {
        this.itemList = new ArrayList<>();
        this.сost = new BigDecimal(0);
    }

    // TODO: добавляем новую трату (хотелку)
    public void add(Item item) {
        itemList.add(item);
        сost.add(item.getPrice()); //так можно будет сохранить промежуточную сумму по мере добавления
    }

    // TODO: общая сумма затрат
    @Override
    public void getTotalCosts() {
        BigDecimal total = itemList
                .stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal:: add);
        out.println("Общая сумма затрат " + total);
    }

    // TODO: печать всего списка
    @Override
    public void print() {
        for (int i = 0; i < itemList.size(); i++) {
            out.println(itemList.get(i));
        }
    }
}

class Item {
    String name;
    BigDecimal price;
    int quantity;

    public Item(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price.multiply(new BigDecimal(quantity));
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.name + " (" + " price is " + getPrice() + ", in quantity " + this.quantity + ')';
    }
}

class TestExpenses {
    public static void main(String[] args) {
        PotentialExpenses expenses = new PotentialExpenses();
        Item item = new Item("Apple", new BigDecimal(10.00), 3);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        out.println(item.quantity + " item(s) " + item.name + " is TC " + item.getPrice() + " Each item priced at " + item.price);
        Item item1 = new Item("Orange", new BigDecimal(15.00), 4);
        items.add(item1);
        Item item2 = new Item("PineApple", new BigDecimal(150.00), 2);
        items.add(item2);
        expenses.add(item);
        expenses.add(item1);
        expenses.add(item2);
        expenses.print();
        expenses.getTotalCosts();
    }
}
