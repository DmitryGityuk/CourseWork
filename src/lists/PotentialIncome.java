package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/***
 * Класс описывает список потенциального дохода и работы с ним
 */

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

    /***
     *
     * Метод добавления нового дененежного поступления
     *
     * @param category - куда поступили деньги
     * @param value - сумма поступлений
     * @param comment - комментарий к поступлению
     */
    /*public void add(String category, BigDecimal value, String comment) {
        List<Income> incomeList = this.incoming.get(category);
        if (incomeList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        incomeList.add(new Income(category, new BigDecimal(value), comment));//таже беда что и в затратах
    }*/

    /***
     * Метод производит подсчет поступлений по категории
     *
     * @param category - куда поступили деньги
     * @return - возвращаемое значение посутплений
     */
    public BigDecimal getValue(String category) {
        List<Income> list = this.incoming.get(category);
        if (list == null)
            return BigDecimal.valueOf(-1);
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Income income : list)
            cost.add(income.getValue());
        return cost;
    }

    /***
     * Метод получения общей суммы поступлений
     */
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

    /***
     * Метод производит печать всего списка поступлений
     */
    @Override
    public void print() {
        for (int i = 0; i < incoming.size(); i++) {
            out.println(incoming.get(i));
        }
    }
}
