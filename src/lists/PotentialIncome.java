package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class PotentialIncome implements ServiceList {

    class Income {
        private String comment;
        private BigDecimal value;

        public Income(String comment, BigDecimal value) {
            this.comment = comment;
            this.value = value;
        }

        public BigDecimal getValue() {
            return value;
        }
    }

    Map<String, List<Income>> incoming;

    public PotentialIncome() {
        this.incoming = new HashMap<>();
        String[] categories = {"wallet", "card", "moneybox", "other"};
        for (String cat : categories) {
            this.incoming.put(cat, new ArrayList<>());
        }
    }

    // TODO: добавляем новый приход
    public void add(String category, BigDecimal value, String comment) {
        List<Income> incomeList = this.incoming.get(category);
        if (incomeList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        incomeList.add(new Income(category, new BigDecimal(value), comment));//таже беда что и в затратах
    }

    // TODO: сумма поступлений по категории
    public BigDecimal getValue(String category) {
        List<Income> list = this.incoming.get(category);
        if (list == null)
            return BigDecimal.valueOf(-1);
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Income income : list)
            cost.add(income.getValue());
        return cost;
    }

    // TODO: общая сумма поступлений
    public BigDecimal getAllValue() {
        BigDecimal value = BigDecimal.valueOf(0);
        for (List<Income> incomeList : incoming.values())
            for (Income income : incomeList)
                value.add(income.getValue());
        return value;
    }

    @Override
    public void getTotalCosts() {
        BigDecimal total = incoming
                .values()
                .stream()
                .flatMap(List::stream)
                .map(Income::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println(total);

    }

    @Override
    public void print() {
        for (int i = 0; i < incoming.size(); i++) {
            out.println(incoming.get(i));
        }
    }
}
