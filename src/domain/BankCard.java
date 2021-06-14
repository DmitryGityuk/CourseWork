package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import enums.interfaces.Currency;
import enums.interfaces.Parse;

public class BankCard implements Parse {
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
    private String cardNumber; //todo исправлен на стринг потому что, строка immutable и никто не изменит наши реквизиты
    /***
     * Тип валюты банковской карты
     */
    private Currency currency;

    /***
     * Конструктор по умолчанию
     */
    public BankCard() {
    }

    /***
     * Конструктор инициализирующий банковскую карту
     * @param nameBankCard - имя банка эмитента карты
     * @param balance - баланс карты
     * @param cardNumber - реквизиты карты
     * @throws shortNameException
     * @throws minusCardNumberException
     */
    public BankCard(String nameBankCard, String balance, String cardNumber) throws shortNameException, minusCardNumberException {
        if (nameBankCard.length() < 0) throw new shortNameException(nameBankCard);
        this.nameBankCard = nameBankCard;
        if (cardNumber == null) throw new minusCardNumberException(cardNumber);
        this.balance = parseBigDecimal(balance).setScale(2, RoundingMode.UNNECESSARY);//todo здесь оставлен setScale просто непонятно в методе от деприкатед, а тут нет.
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

    public void setBalance(String balance) {
        this.balance = parseBigDecimal(balance);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = wrongRequisitesCardNumber(cardNumber);
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
        public minusCardNumberException(String cardNumber) {
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

    /***
     * Метод проверки строки реквизитов на правильность ввода
     * @param cardNumber
     * @return
     */
    public String wrongRequisitesCardNumber(String cardNumber) {
        String s = cardNumber.replaceAll("[^0-9.]", "");
        return s;
    }

    @Override
    public String toString() {
        return "CreditCard { " +
                "Имя карты: " + nameBankCard + '\\' +
                " Номер карты: " + cardNumber + '\\' +
                " Баланс карты: " + balance + '\\' +
                " Тип валюты: " + Currency.RUB + '}';
    }

    @Override
    public BigDecimal parseBigDecimal(String str) {
        str.replace(',', '.');
        BigDecimal b = new BigDecimal(str);
        b = b.setScale(2, BigDecimal.ROUND_DOWN);
        return b;
    }
}
