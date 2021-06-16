package enums.interfaces;

import domain.BankCard;

import java.io.IOException;
import java.text.ParseException;

public interface IServiceUI {
    /***
     * интерфейс печати всего списка
     */
    void print() throws IOException, ParseException;

    /***
     * интерфейс меню пользователя
     * @throws BankCard.MinusCardNumberException
     * @throws BankCard.ShortNameException
     * @throws IOException
     * @throws ParseException
     */
    void userMenu() throws BankCard.MinusCardNumberException, BankCard.ShortNameException, IOException, ParseException;

    /***
     * интерфейс печати суммы
     * @throws IOException
     * @throws ParseException
     */
    void printTotalSum() throws IOException, ParseException;

    //void exitToGlobalMenu();
}
