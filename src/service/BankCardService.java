package service;

import domain.BankCard;
import enums.interfaces.ServiceWalletAndCard;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

/***
 * Класс описывает список банковских карт и работы с ними
 */
public class BankCardService implements ServiceWalletAndCard {
    /***
     * Список всех банковских карт
     */
    private ArrayList<BankCard> bankCards;

    public BankCardService() {
        this.bankCards = new ArrayList<>();
    }

    /***
     * Метод добавляет банковскую карту
     * @param card - карта
     */
    public void add(BankCard card) {
        bankCards.add(card);
    }

    /***
     * Метод производит удаление карты
     * @param card - банковская карта
     */
    public void deleteCard(BankCard card) {
        bankCards.remove(card);
    }

    /***
     * Метод производит замену имени карты
     * @param bankCard
     * @param newNameCard
     */
    public void changeNameBankCard(BankCard bankCard, String newNameCard){
        bankCard.setNameBankCard(newNameCard);
    }

    /***
     * Метод производит замену реквизитов карты
     * @param bankCard
     * @param newCardNumber
     */
    public void changeCardNumber(BankCard bankCard, long newCardNumber){
        bankCard.setCardNumber(newCardNumber);
    }


    /***
     * Метод производит подсчёт общей суммы по банковским картам
     */
    @Override
    public void getTotalSum() {
        BigDecimal total = bankCards
                .stream()
                .map(BankCard::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма на картах составляет " + total);
    }

    /***
     * Метод производит печать списка банковских карт
     */
    @Override
    public void print() {
        bankCards.stream().forEach(out::println);
    }
}




