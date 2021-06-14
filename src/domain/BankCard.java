package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import enums.interfaces.Currency;

public class BankCard {
    /***
     * Имя банка карты
     */
    private String nameBankCard;
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
    private Currency currency;

    /***
     * Конструктор инициализирующий банковскую карту
     * @param nameBankCard - имя банка эмитента карты
     * @param balance - баланс карты
     * @param cardNumber - реквизиты карты
     * @throws shortNameException
     * @throws minusCardNumberException
     */
    public BankCard(String nameBankCard, BigDecimal balance, long cardNumber) throws shortNameException, minusCardNumberException {
        if (nameBankCard.length() < 0) throw new shortNameException(nameBankCard);
        this.nameBankCard = nameBankCard;
        if (cardNumber < 0) throw new minusCardNumberException(cardNumber);
        this.balance = balance.setScale(2, RoundingMode.UNNECESSARY);
        this.cardNumber = cardNumber;

    }

    public String getNameBankCard() {
        return nameBankCard;
    }

    public void setNameBankCard(String nameBankCard) {
        this.nameBankCard = nameBankCard;
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

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /***
     * Исключение обрабатывающее ошибку в реквизитах банковской карты
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

    @Override
    public String toString() {
        return "CreditCard { " +
                "Имя карты: " + nameBankCard + '\\' +
                " Номер карты: " + cardNumber + '\\' +
                " Баланс карты: " + balance + '\\' +
                " Тип валюты: " + Currency.RUB + '}';
    }
}
