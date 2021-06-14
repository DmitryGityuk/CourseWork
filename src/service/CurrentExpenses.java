package service;

import domain.Expense;
import enums.interfaces.ServiceList;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

import static java.lang.System.out;

/***
 * Класс описывает список текущих затрат и работы с ними
 */
public class CurrentExpenses implements ServiceList {

    /***
     * Мапа с категорией как ключ и списком как значение
     */
    Map<String, List<Expense>> expanses;

    public CurrentExpenses() {
        this.expanses = new HashMap<>();
        String[] categories = {"home", "sport", "transport", "entertainment", "food", "travel"};
        for (String cat : categories) {
            this.expanses.put(cat, new ArrayList<>());
        }
    }

    /***
     * Метод позволяет добавить проинициализированную трату
     * @param expense
     * @param category
     */
    public void addExpense(Expense expense, String category){
        List<Expense> expenseList = this.expanses.get(category);
        if (expenseList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        expenseList.add(expense);
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
    public void add(String nameExpanse, String price, String date, String category) throws ParseException {
        List<Expense> expenseList = this.expanses.get(category);
        if (expenseList == null)
            throw new IllegalArgumentException("Категории " + category + " не существует.");
        expenseList.add(new Expense(nameExpanse, price, date));
    }

    /***
     * Метод производит удаления трат в категории
     * @param category - категория трат
     */
    public void deleteExpense(String category) {
        expanses.remove(category);

    }

    /***
     * Метод получения одной из затрат
     *
     * @return - возвращаемое значение
     */
    public List<Expense> getExpense() {
        List<Expense> list = new ArrayList<>();
        for (List<Expense> ex : expanses.values())
            list.addAll(ex);
        return list;
    }

    /***
     * Метод получения суммы затрат по категории
     *
     * @return - возращаемое значение
     */
    public void getCostsCategory(String category) {
        List<Expense> exp = this.expanses.get(category);
        BigDecimal cat = exp
                .stream()
                .map(Expense::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма затрат по категории " + category + ": " + cat);
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
        expanses.values()
                .stream()
                .flatMap(List::stream)
                .forEach(out::println);
    }
}



