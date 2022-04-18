package service;

import domain.Income;
import enums.interfaces.IServiceList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.*;

/***
 * Класс описывает список потенциального дохода и работы с ним
 */

public class PotentialIncome implements IServiceList {

    Map<String, List<Income>> incoming;

    public PotentialIncome() {
        this.incoming = new HashMap<>();
        String[] categories = {"Wallet", "BankCard"};
        for (String cat : categories) {
            this.incoming.put(cat, new ArrayList<>());
        }
    }

    public Map<String, List<Income>> getIncoming() {
        return incoming;
    }

    public void setIncoming(Map<String, List<Income>> incoming) {
        this.incoming = incoming;
    }

    /***
     * Метод получения дохода
     */
    public List<Income> getIncome() {
        List<Income> list = new ArrayList<>();
        for (List<Income> incomes : incoming.values())
            list.addAll(incomes);
        return list;
    }

    /***
     * Метод позволяет добавить проинициализированный доход
     * @param income
     * @param category
     */
    public void addIncome(Income income, String category) {
        List<Income> incomeList = this.incoming.get(category);
        if (incomeList == null)
            throw new IllegalArgumentException("Category " + category + " not found.");
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
    public BigDecimal getCostCategory(String category) {
        List<Income> list = this.incoming.get(category);
        BigDecimal cat = list
                .stream()
                .map(Income::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return cat;
    }

    /***
     * Метод получения общей суммы поступлений
     * @return
     */
    @Override
    public BigDecimal getTotalCosts() {
        BigDecimal total = incoming
                .values()
                .stream()
                .flatMap(List::stream)
                .map(Income::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    @Override
    public void saveToFile() throws IOException {
        try {
            Writer writeCurrentExpense = new FileWriter("src/files/potentialIncome.txt", true);
            for (String key : incoming.keySet()) {
                writeCurrentExpense.write(key + ":" + incoming.get(key) + "\n");
                writeCurrentExpense.flush();
            }
            writeCurrentExpense.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

