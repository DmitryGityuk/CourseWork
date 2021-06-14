package service;

import domain.Income;
import enums.interfaces.Holder;
import enums.interfaces.ServiceList;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.out;

/***
 * Класс описывает список потенциального дохода и работы с ним
 */

public class PotentialIncome implements ServiceList {

    Map<String, List<Income>> incoming;

    public PotentialIncome() {
        this.incoming = new HashMap<>();
        String[] categories = {"wallet", "card"};
        for (String cat : categories) {
            this.incoming.put(cat, new ArrayList<>());
        }
    }
    /***
     * Метод позволяет добавить проинициализированный доход
     * @param income
     * @param category
     */
    public void addIncome(Income income, String category){
        List<Income> incomeList = this.incoming.get(category);
        if (incomeList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        incomeList.add(income);
    }

    /***
     * Метод добавления нового дененежного поступления
     *
     * @param category - куда поступили деньги
     * @param value - сумма поступлений
     * @param comment - комментарий к поступлению
     */
    public void add(String value, String comment, String category) {
        List<Income> incomeList = this.incoming.get(category);
        if (incomeList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        incomeList.add(new Income(value, comment));
    }

    /***
     * Метод производит подсчет поступлений по категории
     *
     * @param category - куда поступили деньги
     * @return - возвращаемое значение посутплений
     */
    public void getCostCategory(String category) {
        List<Income> list = this.incoming.get(category);
        BigDecimal cat = list
                .stream()
                .map(Income::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("поступление по категории " + category + ": " + cat);
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
        incoming.values()
                .stream()
                .flatMap(List::stream)
                .forEach(out::println);
    }
}
