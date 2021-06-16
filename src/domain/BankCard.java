package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;


import enums.interfaces.Currency;
import enums.interfaces.IParse;
import javafx.scene.control.CheckBox;

public class BankCard implements IParse, Serializable {
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
    private String cardNumber;
    /***
     * Тип валюты банковской карты
     */
    private Currency currency;

    public BankCard() {
    }

    /***
     * Конструктор по умолчанию
     * @param text
     * @param addRequisitesCardText
     * @param addBalanceCardText
     * @param typeCurrency
     */
    public BankCard(String text, String addRequisitesCardText, String addBalanceCardText, CheckBox typeCurrency) {

    }

    /***
     * Конструктор инициализирующий банковскую карту
     * @param nameBankCard - имя банка эмитента карты
     * @param balance - баланс карты
     * @param cardNumber - реквизиты карты
     *
     */
    public BankCard(String nameBankCard, String balance, String cardNumber) throws ShortNameException, MinusCardNumberException {
        if (nameBankCard.length() < 0) throw new ShortNameException(nameBankCard);
        this.nameBankCard = nameBankCard;
        if (cardNumber == null) throw new MinusCardNumberException(cardNumber);
        this.balance = parseBigDecimal(balance).setScale(2, RoundingMode.UNNECESSARY);
        this.cardNumber = wrongRequisitesCardNumber(cardNumber);
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
     * Исключение обрабатывающее ошибку в наименовании банка карты
     */
    public class ShortNameException extends IllegalStateException {
        public ShortNameException(String nameCard) {
            super("Длинна имени банка карты не менее 1-го символа " + nameCard);
        }
    }

    /***
     * Исключение обрабатывающее ошибку в реквизитах банковской карты
     */
    public class MinusCardNumberException extends IllegalStateException {
        public MinusCardNumberException(String cardNumber) {
            super("Номер счёта не может быть отрицательным " + cardNumber + " ");
        }
    }

    /***
     * Исключение обрабатывающее ошибку в балансе банковской карты
     */
    public class MinusBalanceException extends IllegalStateException {
        public MinusBalanceException(BigDecimal balance, BigDecimal sum) {
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
        return "BankCard - " +
                "Name Card : " + nameBankCard + ',' +
                " Requisites card : " + cardNumber + ',' +
                " Balance card: " + balance + ',' +
                " Type of currency: " + Currency.RUB;
    }

    @Override
    public BigDecimal parseBigDecimal(String str) {
        BigDecimal b = new BigDecimal(str);
        b = b.setScale(2);
        return b;
    }
}
