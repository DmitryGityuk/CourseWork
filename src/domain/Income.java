package domain;

import enums.interfaces.Currency;
import java.math.BigDecimal;

/***
 * Класс описывает доход
 */
public class Income {
    private String comment;
    private BigDecimal value;


    public Income(BigDecimal value, String comment) {
        this.comment = comment;
        this.value = value;
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

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Поступил(а) " + this.comment + " в размере " + this.value + " " + Currency.RUB ;
    }
}
