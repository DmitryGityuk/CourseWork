package lists;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static java.lang.System.out;

public class CurrentExpenses implements ServiceList {

    class Expense {
        private String name;
        private BigDecimal price;
        private Date date;
        //private Instant day = date.atStartOfDay(ZoneId.systemDefault()).toInstant(); прикольно попробовать так, но как передать в конструктор хз

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

        public Date parseDate(String date) throws ParseException {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format.parse(date);
            //System.out.println(date1);
            return date1;
        }

    }

    // TODO: мапа с категорией как ключ и списком как значение
    Map<String, List<Expense>> expanses;

    public CurrentExpenses() {
        this.expanses = new HashMap<>();
        String[] categories = {"home", "sport", "transport", "entertainment", "food", "travel"};
        for (String cat : categories) {
            this.expanses.put(cat, new LinkedList<>());
        }
    }

    // TODO: добавляем новую трату
    public void add(String expanse, BigDecimal price, String date, String category) throws ParseException {
        List<Expense> expenseList = this.expanses.get(category);
        if (expenseList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        expenseList.add(new Expense(expanse, new BigDecimal(price), date));// найти способ впихнуть сюда бигдесимал
        // через valueOf() тоже не работает
    }

    // TODO: взять одну из затрат
    public List<Expense> getExpense() {
        List<Expense> list = new ArrayList<>();
        for (List<Expense> ex : this.expanses.values())
            list.addAll(ex);
        return list;
    }

    // TODO: сумма затрат по категории
    public BigDecimal getCosts(String category) {
        List<Expense> list = this.expanses.get(category);
        if (list == null)
            return BigDecimal.valueOf(-1);
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Expense ex : list)
            cost.add(ex.getPrice());
        return cost;
    }

    // TODO: общая сумма затрат
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
        currentExpenses.add("Beer", new BigDecimal(78.00), "2021-05-15", "food");
        System.out.println(currentExpenses.getExpense());
    }
}
