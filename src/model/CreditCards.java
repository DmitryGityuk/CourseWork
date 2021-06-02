package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static java.lang.System.out;

/***
 * Класс описывает список банковских карт и работы с ними
 */
public class CreditCards implements ServiceWalletAndCard {
    /***
     * Список всех банковских карт
     */
    private ArrayList<CreditCard> creditCards;

    public CreditCards() {
        this.creditCards = new ArrayList<>();
    }

    /***
     * Метод добавляет банковскую карту
     * @param card - карта
     */
    public void add(CreditCard card) {
        creditCards.add(card);
    }

    /***
     * Метод производит печать списка банковских карт
     */
    @Override
    public void print() {
        creditCards.stream().forEach(out::println);
        }


    /***
     * Метод производит подсёт общей суммы по банковским картам
     */
    @Override
    public void getAllSum() {
        BigDecimal total = creditCards
                .stream()
                .map(CreditCard::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма на картах составляет " + total);
    }

    /***
     * Класс описывает банковскую карту
     */
    static class CreditCard {
        /***
         * Имя банка карты
         */
        private String nameCard;
        /***
         * Количество денежных средств на банковской карте
         */
        private BigDecimal balance;
        /***
         * Реквизиты банковской карты
         */
        private long cardNumber;
        /***
         * Тип валюты банковской карты
         */
        private CurrencyType currency;

        /***
         * Конструктор инизиализирующий банковскую карту
         * @param nameCard
         * @param cardNumber
         * @param value
         * @param currency
         * @throws shortNameException
         * @throws minusCardNumberException
         */
        public CreditCard(String nameCard, long cardNumber, BigDecimal value, CurrencyType currency)
                throws shortNameException, minusCardNumberException {
            if (nameCard.length() < 0) throw new shortNameException(nameCard);
            this.nameCard = nameCard;
            this.balance = value;
            if (cardNumber < 0) throw new minusCardNumberException(cardNumber);
            this.cardNumber = cardNumber;
            this.currency = currency;
            this.balance.setScale(2, RoundingMode.UNNECESSARY);
        }

        public String getNameCard() {
            return nameCard;
        }

        public void setNameCard(String nameCard) throws shortNameException {
            if (nameCard.length() < 0) throw new shortNameException(nameCard);
            this.nameCard = nameCard;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        public long getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(long cardNumber) throws minusCardNumberException {
            if (cardNumber < 0) throw new minusCardNumberException(cardNumber);
            this.cardNumber = cardNumber;
        }

        public CurrencyType getCurrency() {
            return currency;
        }

        public void setCurrency(CurrencyType currency) {
            this.currency = currency;
        }


        /***
         * Метод производит списание денежных средств с карты
         * @param sum - сумма списания
         * @return true если все прошло успешно
         * @throws minusBalanceException
         */
        public boolean getMoney(BigDecimal sum) throws minusBalanceException {
            BigDecimal result;
            if (balance.compareTo(sum) < 0) throw new minusBalanceException(balance, sum);
            result = balance.subtract(sum);
            out.println("Баланс карты " + result);
            balance = balance.subtract(sum);
            return true;
        }

        @Override
        public String toString() {
            return "CreditCard { " +
                    "Имя карты: " + nameCard + '\\' +
                    " Номер карты: " + cardNumber + '\\' +
                    " Баланс карты: " + balance + '\\' +
                    " Тип валюты: " + currency + '}';
        }

        public enum CurrencyType {
            RUB
        }

        /***
         * Исключение обрабатывающее ошибку в реквезитах банковской карты
         */
        public class minusCardNumberException extends Exception {
            public minusCardNumberException(long cardNumber) {
                super("Номер счёта не может быть отрицательным " + cardNumber + " ");
            }
        }

        /***
         * Исключение обрабатывающее ошибку в наименовании банка карты
         */
        public class shortNameException extends Exception {
            public shortNameException(String nameCard) {
                super("Длинна имени банка карты не менее 1-го символа " + nameCard);
            }
        }

        /***
         * Исключение обрабатывающее ошибку в балансе банковской карты
         */
        public class minusBalanceException extends Exception {
            public minusBalanceException(BigDecimal balance, BigDecimal sum) {
                super("Недостаточно средств на счёте \n Баланс: " + balance + "\n Сумма: " + sum);
            }
        }
    }
}


class TestCard {
    public static void main(String[] args) throws CreditCards.CreditCard.minusCardNumberException, CreditCards.CreditCard.shortNameException {
        CreditCards creditCards = new CreditCards();
        CreditCards.CreditCard card = new CreditCards.CreditCard("SMP", 124_124_125, new BigDecimal(30000.00), CreditCards.CreditCard.CurrencyType.RUB);
        CreditCards.CreditCard card1 = new CreditCards.CreditCard("PSB", 125_125_125, new BigDecimal(50000.00), CreditCards.CreditCard.CurrencyType.RUB);
        CreditCards.CreditCard card2 = new CreditCards.CreditCard("Tinkoff", 126_126_126, new BigDecimal(70000.00), CreditCards.CreditCard.CurrencyType.RUB);
        CreditCards.CreditCard card3 = new CreditCards.CreditCard("Sberbank", 127_127_127, new BigDecimal(20000.00), CreditCards.CreditCard.CurrencyType.RUB);
        creditCards.add(card);
        creditCards.add(card1);
        creditCards.add(card2);
        creditCards.add(card3);
        creditCards.getAllSum();
    }
}
