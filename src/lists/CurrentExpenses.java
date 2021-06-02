package lists;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

/***
 * Класс описывает список текущих затрат и рабоыт с ними
 */
public class CurrentExpenses implements ServiceList {

    class Expense {
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
        //private Instant day = date.atStartOfDay(ZoneId.systemDefault()).toInstant(); прикольно попробовать так, но как передать в конструктор хз

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
            return this.name + '(' + this.price + ')';
        }

        public BigDecimal getPrice() {
            return price;
        }

        /***
         * Метод преобразования строки в дату
         *
         * @param date
         * @return
         * @throws ParseException
         */
        public Date parseDate(String date) throws ParseException {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format.parse(date);
            return date1;
        }

    }

    /***
     * Мапа с категорией как ключ и списком как значение
     */
    Map<String, List<Expense>> expanses;

    public CurrentExpenses() {
        this.expanses = new HashMap<>();
        String[] categories = {"home", "sport", "transport", "entertainment", "food", "travel"};
        for (String cat : categories) {
            this.expanses.put(cat, new LinkedList<>());
        }
    }


    /***
     * Метод добавляет в список новую трату
     *
     * @param nameExpanse - наименование траты
     * @param price - стоимость траты
     * @param date - дата траты
     * @param category - категория
     * @throws ParseException
     */
   /* public void add(String nameExpanse, BigDecimal price, String date, String category) throws ParseException {
        List<Expense> expenseList = this.expanses.get(category);
        if (expenseList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        expenseList.add(new Expense(nameExpanse, new BigDecimal(price), date));// найти способ впихнуть сюда бигдесимал
        // через valueOf() тоже не работает
    }*/

    /***
     * Метод получения одной из затрат
     *
     * @return - возвращаемое значение
     */
    public List<Expense> getExpense() {
        List<Expense> list = new ArrayList<>();
        for (List<Expense> ex : this.expanses.values())
            list.addAll(ex);
        return list;
    }

    /***
     * Метод получения суммы затрат по категории
     *
     * @param category - категория
     * @return - возращаемое значение
     */
    public BigDecimal getCosts(String category) {
        List<Expense> list = this.expanses.get(category);
        if (list == null)
            return BigDecimal.valueOf(-1);
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Expense ex : list)
            cost.add(ex.getPrice());
        return cost;
    }

    /***
     * Метод получения общей суммы текущих затрат
     */
    @Override
    public void getTotalCosts() {
        BigDecimal totalCost = expanses
                .values()
                .stream()
                .flatMap(List::stream)
                .map(Expense::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма затрат: " + totalCost);
    }

    /***
     * Метод производит печать всего списка текущих затрат
     */
    @Override
    public void print() {
        for (int i = 0; i < expanses.size(); i++) {
            out.println(expanses.get(i));
        }
    }
}

class TestCurrentExpenses {
    public static void main(String[] args) throws ParseException {
        CurrentExpenses currentExpenses = new CurrentExpenses();
      //  currentExpenses.add("Beer", new BigDecimal(78.00), "2021-05-15", "food");
        System.out.println(currentExpenses.getExpense());
    }
}
