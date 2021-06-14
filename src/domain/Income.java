package domain;

import enums.interfaces.Currency;
import enums.interfaces.Parse;

import java.math.BigDecimal;

/***
 * Класс описывает доход
 */
public class Income implements Parse {
    private String comment;
    private BigDecimal value;

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
        return "Поступил(а) " + this.comment + " в размере " + this.value + " " + Currency.RUB;
    }

    @Override
    public BigDecimal parseBigDecimal(String str) {
        str.replace(',', '.');
        BigDecimal b = new BigDecimal(str);
        b = b.setScale(2, BigDecimal.ROUND_DOWN);
        return b;
    }
}
