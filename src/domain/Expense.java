package domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/***
 * Класс описывает затрату
 */
public class Expense {
    /***
     * Наименование затраты
     */
    private String name;
    /***
     * Стоимость затрат
     */
    private BigDecimal price;
    /***
     * Дата траты
     */
    private Date date;

    private String[] categories;

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

    /***
     * Конструктор инициализирующий список текущих затрат
     *
     * @param name
     * @param price
     * @param date
     * @throws ParseException
     */
    public Expense(String name, BigDecimal price, String date) throws ParseException {
        this.name = name;
        this.price = price;
        this.date = parseDate(date);
    }

    @Override
    public String toString() {
        return "Покупка " + this.name + " по цене " + '(' + this.price + ')' + " руб. " + " дата покупки: " + this.date + "\n";
    }

    /***
     * Метод преобразования строки в дату
     *
     * @param date - дата
     * @return
     * @throws ParseException
     */
    public Date parseDate(String date) throws ParseException {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        Date date1 = format.parse(date);
        Timestamp tm = new Timestamp(date1.getTime());
        return tm;
    }
}
