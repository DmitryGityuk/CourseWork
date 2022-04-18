package domain;

import enums.interfaces.IParse;
import java.math.BigDecimal;

/***
 * Класс описывает предмет для списка потенциальных затрат
 */
public class Item implements IParse {
    /***
     * Название траты
     */
    String name;
    /***
     * стоимость траты
     */
    BigDecimal price;
    /***
     * приоритет
     */
    int priority;

    /***
     * Конструктор по умолчанию
     */
    public Item() {
    }

    /***
     * Конструктор инициализирующий покупку
     * @param name
     * @param price
     * @param priority
     */
    public Item(String name, String price, int priority) {
        this.name = name;
        this.price = parseBigDecimal(price);
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

    public void setPrice(String price) {
        this.price = parseBigDecimal(price);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return " It is planned to spend on  " + this.name + " (" + " by price: " + getPrice() + ", in priority: " + this.priority + ')';
    }

    @Override
    public BigDecimal parseBigDecimal(String str) {
        BigDecimal b = new BigDecimal(str);
        b = b.setScale(2);
        return b;
    }
}
