package modelUI;

import domain.BankCard;
import enums.interfaces.Currency;
import enums.interfaces.IServiceUI;
import service.BankCardService;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class BankCardUI implements IServiceUI {
    Scanner scanner = new Scanner(System.in);
    BankCardService bankCardService = new BankCardService();

    @Override
    public void userMenu() throws BankCard.MinusCardNumberException, BankCard.ShortNameException, IOException {
        int var;
        out.println("1: Issue a new bankCard \n" +
                "2: Show balance for all cards \n" +
                "3: Printing a list of cards \n" +
                "4: Go to wallet menu \n" +
                "0: Exit \n" +
                "Enter the menu item number:");
        Scanner userInput = new Scanner(System.in);
        var = userInput.nextInt();
        if (var == 1) {
            addedCard();
        } else if (var == 2) {
            printTotalSum();
        } else if (var == 3) {
            print();
        } else if (var == 4) {
            exitToWalletMenu();
        } else if (var == 0) {
            out.print("Good Bye");
            System.exit(0);
        }
    }

    /***
     * Выпуск новой карты
     * @throws BankCard.MinusCardNumberException
     * @throws BankCard.ShortNameException
     */
    public void addedCard() throws BankCard.MinusCardNumberException, BankCard.ShortNameException, IOException {
        BankCard firstBankCard = new BankCard();
        out.println("Currently, the opening of the card is only available with the type of currency " + Currency.RUB);
        out.println("Enter the name of the card issuing bank");
        String nameBankCard = scanner.nextLine();
        firstBankCard.setNameBankCard(nameBankCard);
        out.println("Enter your bank card details");
        String requisites = scanner.nextLine();
        firstBankCard.setCardNumber(requisites);
        out.println("Enter the amount of money on the card");
        String balance = scanner.nextLine();
        firstBankCard.setBalance(balance);
        out.println("Your card has been successfully issued");
        bankCardService.add(firstBankCard);
        bankCardService.saveToFile();
        userMenu();
    }

    /***
     * Метод производит печать общей суммы по банковским картам
     * @return
     */
    @Override
    public void printTotalSum() throws IOException {
        out.println(bankCardService.getTotalSum());
        userMenu();
    }

    /***
     * Метод производит печать списка банковских карт
     */
    public void print() throws IOException {
        bankCardService.getBankCards()
                .stream()
                .forEach(out::println);
        userMenu();
    }


    public void exitToWalletMenu() throws IOException {
        WalletUI walletUI = new WalletUI();
        walletUI.userMenu();
        userMenu();
    }
}
