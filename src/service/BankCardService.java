package service;

import domain.BankCard;
import enums.interfaces.IServiceWalletAndCard;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;


/***
 * Класс описывает список банковских карт и работы с ними
 */
public class BankCardService implements IServiceWalletAndCard, Serializable {
    /***
     * Список всех банковских карт
     */
    private ArrayList<BankCard> bankCards;

    public BankCardService() {
        this.bankCards = new ArrayList<>();
    }

    public ArrayList<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(ArrayList<BankCard> bankCards) {
        this.bankCards = bankCards;
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
    public void changeNameBankCard(BankCard bankCard, String newNameCard) {
        bankCard.setNameBankCard(newNameCard);
    }

    /***
     * Метод производит замену реквизитов карты
     * @param bankCard
     * @param newCardNumber
     */
    public void changeCardNumber(BankCard bankCard, String newCardNumber) {
        bankCard.setCardNumber(newCardNumber);
    }

    /***
     * Метод производит подсчёт общей суммы по банковским картам
     * @return
     */
    @Override
    public BigDecimal getTotalSum() {
        BigDecimal total = bankCards
                .stream()
                .map(BankCard::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    /***
     * Метод производит сохранение списка кредитных карт
     * @throws IOException
     */
    public void saveToFile() throws IOException {
        Writer writeCreditCard = new FileWriter("src/files/creditCards.txt", true);
        for (BankCard line : bankCards) {
            writeCreditCard.write(String.valueOf(line));
        }
        writeCreditCard.close();
    }
}




