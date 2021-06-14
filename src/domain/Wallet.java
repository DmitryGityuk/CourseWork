package domain;

import java.math.BigDecimal;
import java.util.*;

public class Wallet {
    /***
     * Имя кошелька
     */
    private String nameWallet;
    /***
     * список банкнот
     */
    private List<BigDecimal> bills = new ArrayList<>();
    /***
     * список банковских карт в кошельке
     */
    private Map<String, BigDecimal> bankCards = new HashMap<>();

    public Wallet() {
    }

    public Wallet(String nameWallet, List<BigDecimal> bills, Map<String, BigDecimal> bankCards) {
        this.nameWallet = nameWallet;
        this.bills = bills;
        this.bankCards = bankCards;
    }

    public String getNameWallet() {
        return nameWallet;
    }

    public void setNameWallet(String nameWallet) {
        this.nameWallet = nameWallet;
    }

    public List<BigDecimal> getBills() {
        return bills;
    }

    public void setBills(List<BigDecimal> bills) {
        this.bills = bills;
    }

    public Map<String, BigDecimal> getBankCards() {
        return bankCards;
    }

    public void setCreditCards(Map<String, BigDecimal> bankCards) {
        this.bankCards = bankCards;
    }


    /***
     * Метод добавляет банкноту в кошелёк
     * @param bill - банкнота
     */
    public void adBill(Wallet wallet, BigDecimal bill) {
        bills.add(bill);
    }

    public void getBill(BigDecimal bill){
        bills.remove(bill);
    }

    /***
     * Метод добавляет банковскую карту
     * @param cardName - имя карты
     * @param balance - количество денежных средств на карте
     */
    public void addCard(String cardName, BigDecimal balance) {
        bankCards.put(cardName, balance);
    }

    /***
     * Метод производит замену имени кошелька
     * @param newNameWallet - имя кошелька
     */
    public void changeNameWallet(String newNameWallet) {
        this.nameWallet = newNameWallet;
    }

    /***
     * Метод производит подсчёт общей суммы денежных средств
     * @param num
     * @return
     */
    private BigDecimal summarize(Collection<BigDecimal> num) {
        BigDecimal sum = new BigDecimal(0);
        for (BigDecimal nm : num)
            sum = sum.add(nm);
        return sum;
    }


    /***
     * Метод производит подсчёт суммы денежных средств на банковских картах лежащих в кошельке
     * @return
     */
    public BigDecimal cardSum() {
        return summarize(bankCards.values());
    }

    /***
     * Метод производит подсчёт суммы денежных средств(банкнот) в кошельке
     * @return
     */
    public BigDecimal billsSum() {
        return summarize(bills);
    }

    /***
     * Метод производит подсчёт общей суммы денежных средств на кошельке (купюры + д.с на банковских картах)
     * @return
     */
    public BigDecimal allSum() {
        return billsSum().add(cardSum());
    }


    @Override
    public String toString() {
        return "Wallet {" +
                " Имя кошелька: " + nameWallet + '\\' +
                " Наличных в кошельке: " + bills + '\\' +
                " Сумма денег на карте: " +  + '\\' +
                " Всего денег в кошельке: " + allSum() + '}';
    }
}
