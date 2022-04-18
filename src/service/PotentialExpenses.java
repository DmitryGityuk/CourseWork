package service;

import domain.Item;
import enums.interfaces.IServiceList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/***
 * Класс описывает список потенциальных затрат(покупок/хотелок) и работы с ними
 */
public class PotentialExpenses implements IServiceList {
    /***
     * Список затрат
     */
    private List<Item> itemList = new ArrayList<>();

    public PotentialExpenses() {

    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

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
    public void deleteExpenses(Item item) {
        itemList.remove(item);
    }

    /***
     * Метод производит сортировку по алфавиту
     *
     */
    public void sortedAlphabet() {
        itemList.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(out::println);
    }

    /***
     * Метод производит сортировку по приоритету
     */
    public void sortedPriority() {
        itemList.stream()
                .sorted(Comparator.comparing(Item::getPriority))
                .forEach(out::println);
    }

    /***
     * Метод получения общей суммы затрат
     *
     * @return
     */
    @Override
    public BigDecimal getTotalCosts() {
        BigDecimal total = itemList
                .stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    @Override
    public void saveToFile() throws IOException {
        Writer writePotentialExpense = new FileWriter("src/files/potentialExpense.txt", true);
        for (Item line : itemList) {
            writePotentialExpense.write(String.valueOf(line));
        }
        writePotentialExpense.close();
    }
}



