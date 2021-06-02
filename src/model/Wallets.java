package model;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.out;

/***
 * Класс описывает список кошельков и работы с ними
 */
public class Wallets implements ServiceWalletAndCard {
    /***
     * список всех кошельков
     */
    private ArrayList<Wallet> wallets;

    public Wallets() {
        this.wallets = new ArrayList<>();
    }

    public void add(Wallet wallet) {
        wallets.add(wallet);
    }

    /***
     * Метод производит печать списка всех кошельков
     */
    @Override
    public void print() {
        wallets.stream().forEach(out::println);
        }


    /***
     * Метод производит подсчёт общей суммы по всем кошелькам
     */
    @Override
    public void getAllSum() {
        BigDecimal total = (BigDecimal) wallets
                .stream()
                .map(Wallet::allSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма составляет: " + total);
    }

    /***
     * Класс описывает кошелёк
     */
    static class Wallet {
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
        private Map<String, BigDecimal> creditCards = new HashMap<>();


        public Wallet(String nameWallet) {
            this.nameWallet = nameWallet;
        }

        public String getNameWallet() {
            return nameWallet;
        }

        public void setNameWallet(String nameWallet) {
            this.nameWallet = nameWallet;
        }

        /***
         * Метод добавляет банкноту в кошелёк
         * @param bill - банкнота
         */
        public void adBill(BigDecimal bill) {
            bills.add(bill);
        }

        public void deleteInformation(String newNameWallet) {
            this.nameWallet = newNameWallet;
        }

        /***
         * Метод добавляет банковскую карту
         * @param cardName - имя карты
         * @param balance - количество денежных средств на карте
         */
        public void addCard(String cardName, BigDecimal balance) {
            creditCards.put(cardName, balance);
        }

        public void deleteCard(String cardName){
            creditCards.remove(cardName);
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
            return summarize(creditCards.values());
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
                    " Наличных в кошельке: " + billsSum() + '\\' +
                    " Сумма денег на карте: " + cardSum() + '\\' +
                    " Всего денег в кошельке: " + allSum() + '}';
        }
    }
}

class TestWallet {
    public static void main(String[] args) {
        Wallets wallets = new Wallets();
        Wallets.Wallet wallet = new Wallets.Wallet("FirstWallet");
        wallet.adBill(new BigDecimal(500.00));
        wallet.addCard("Visa Sberbank", new BigDecimal(50000.00));
        wallet.adBill(new BigDecimal(5000.00));
        wallet.addCard("MasterCard PSB", new BigDecimal(30000.00));
        wallets.add(wallet);
        Wallets.Wallet wallet1 = new Wallets.Wallet("SecondWallet");
        wallet1.addCard("Visa VTB", new BigDecimal(90000.00));
        wallet1.addCard("MasterCard Tinkoff", new BigDecimal(70000.00));
        wallet1.adBill(new BigDecimal(2000.00));
        wallet1.adBill(new BigDecimal(200.00));
        wallets.add(wallet1);
        wallets.print();
        wallets.getAllSum();
        wallet1.deleteInformation("SecondW545allet");
        wallets.print();
    }
}
