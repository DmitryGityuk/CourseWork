package domain;

import java.math.BigDecimal;

/***
 * Класс описывает предмет для списка потенциальных затрат
 */
public class Item {
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
        return "Предвидится трата на  " + this.name + " (" + " по цене " + getPrice() + ", в приоритете: " + this.priority + ')';
    }
}
