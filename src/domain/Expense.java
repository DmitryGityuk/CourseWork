package domain;

import enums.interfaces.IParse;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/***
 * Класс описывает затрату
 */
public class Expense implements IParse {
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

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = parseDate(date);
    }

    /***
     * Конструктор по умолчанию
     */
    public Expense() {
    }

    /***
     * Конструктор инициализирующий список текущих затрат
     *
     * @param name
     * @param price
     * @param date
     * @throws ParseException
     */
    public Expense(String name, String price, String date) throws ParseException {
        this.name = name;
        this.price = parseBigDecimal(price);
        this.date = parseDate(date);
    }

    @Override
    public String toString() {
        return "Purchase " + this.name + " by price " + '(' + this.price + ')' + " rub. " + " purchase date: " + this.date + "\n";
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

    /***
     * Метод преобразования строки в BigDecimal
     * @param str
     * @return
     */
    @Override
    public BigDecimal parseBigDecimal(String str) {
        BigDecimal b = new BigDecimal(str);
        b = b.setScale(2);
        return b;
    }
}
