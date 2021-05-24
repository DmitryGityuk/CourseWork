package model;

import java.math.BigDecimal;
import java.util.*;
import static java.lang.System.out;

public class Wallets implements ServiceWalletAndCard{
    private ArrayList<Wallet> wallets;

    public Wallets() {
        this.wallets = new ArrayList<>();
    }

    public void add(Wallet wallet) {
        wallets.add(wallet);
    }

    @Override
    public void print() {
        for (int i = 0; i < wallets.size(); i++) {
            out.println(wallets.get(i));
        }
    }

    // TODO: сумма по всем кошелькам
    @Override
    public void getAllSum() {
        BigDecimal total = (BigDecimal) wallets
                .stream()
                .map(Wallet::allSum)
                .reduce(BigDecimal.ZERO, BigDecimal:: add);
        out.println("Общая сумма составляет: " + total);
    }


    static class Wallet {
        private String nameWallet;
        private List<BigDecimal> bills = new ArrayList<>();
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

        public void adBill(BigDecimal bill) {
            bills.add(bill);
        }

        public void addCard(String cardName, BigDecimal balance) {
            creditCards.put(cardName, balance);
        }

        private BigDecimal summarize(Collection<BigDecimal> num) {
            BigDecimal sum = new BigDecimal(0);
            for (BigDecimal nm : num)
                sum = sum.add(nm);
            return sum;
        }

        // TODO: сумма по картам в кошельке
        public BigDecimal cardSum() {
            return summarize(creditCards.values());
        }

        // TODO: сумма по наличке
        public BigDecimal billsSum() {
            return summarize(bills);
        }

        // TODO: всего денег в кошельке
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

class TestWallet{
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

    }

}
