package service;

import domain.Item;
import enums.interfaces.ServiceList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/***
 * Класс описывает список потенциальных затрат(покупок/хотелок) и работы с ними
 */
public class PotentialExpenses implements ServiceList {
    /***
     * Список затрат
     */
    private List<Item> itemList = new ArrayList<>();

    /***
     * Метод добавления новой потенциальной затраты
     *
     * @param item - затрата
     */
    public void add(Item item) {
        itemList.add(item);
    }

    /***
     * Метод производит удаление потенциальной затраты
     * @param item
     */
    public void deleteExpenses(Item item){
        itemList.remove(item);
    }

    /***
     * Метод производит сортировку по алфавиту
     *
     */
    public void sortedAlphabet(){
        itemList.stream().sorted(Comparator.comparing(Item::getName)).forEach(out::println);
    }

    /***
     * Метод производит сортировку по приоритету
     */
    public void sortedPriority(){
        itemList.stream().sorted(Comparator.comparing(Item::getPriority)).forEach(out::println);
    }

    /***
     * Метод получения общей суммы затрат
     *
     */
    @Override
    public void getTotalCosts() {
        BigDecimal total = itemList
                .stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма затрат " + total);
    }

    /***
     * Метод производит печать всего списка потенциальных затрат
     */
    @Override
    public void print() {
        itemList.stream().forEach(out::println);
    }
}

