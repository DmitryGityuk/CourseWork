package domain;

import enums.interfaces.Currency;
import enums.interfaces.IParse;

import java.math.BigDecimal;

/***
 * Класс описывает доход
 */
public class Income implements IParse {
    private String comment;
    private BigDecimal value;

    /***
     * Конструктор по умолчанию
     */
    public Income() {
    }

    /***
     * КОнструктор инициализирующий новый доход
     * @param value
     * @param comment
     */
    public Income(String value, String comment) {
        this.comment = comment;
        this.value = parseBigDecimal(value);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = parseBigDecimal(value);
    }

    @Override
    public String toString() {
        return " Received " + this.comment + " at the rate of " + this.value + " " + Currency.RUB;
    }

    @Override
    public BigDecimal parseBigDecimal(String str) {
        BigDecimal b = new BigDecimal(str);
        b = b.setScale(2);
        return b;
    }
}
