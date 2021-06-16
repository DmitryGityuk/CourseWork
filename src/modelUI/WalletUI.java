package modelUI;

import domain.Wallet;
import enums.interfaces.IServiceUI;
import service.WalletsService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.System.out;

public class WalletUI implements IServiceUI {
    Scanner scanner = new Scanner(System.in);
    Wallet wallet = new Wallet();
    WalletsService walletsService = new WalletsService();

    @Override
    public void userMenu() throws IOException {
        int var;
        out.println("1: Issue a new wallet \n" +
                "2: Add a bank card to the wallet \n" +
                "3: Add a bills card to the wallet \n" +
                "4: Show cash balance \n" +
                "5: Show credit card balance \n" +
                "6: Show the total balance of the wallet \n" +
                "7: Printing a list of wallet \n" +
                "8: Delete wallet \n" +
                "0: Exit \n" +
                "Enter the menu item number:");
        Scanner userInput = new Scanner(System.in);
        var = userInput.nextInt();
        if (var == 1) {
            addNewWallet();
        } else if (var == 2) {
            addCard();
        } else if (var == 3) {
            addBills();
        } else if (var == 4) {
            printBillsSum();
        } else if (var == 5) {
            printCardSum();
        } else if (var == 6) {
            printTotalSum();
        } else if (var == 7) {
            print();
        } else if (var == 8) {
            deleteWallet();
        } else if (var == 0) {
            out.print("Good Bye");
            System.exit(0);
        }
    }

    public void addNewWallet() throws IOException {
        out.println("Enter the name of the wallet");
        String nameWallet = scanner.nextLine();
        wallet.setNameWallet(nameWallet);
        walletsService.add(wallet);
        walletsService.saveToFile();
        userMenu();
    }

    public void addBills() throws IOException {
        out.println("Enter the amount of bills on wallet");
        BigDecimal bills = scanner.nextBigDecimal();
        wallet.adBill(bills);
        userMenu();
    }

    public void addCard() throws IOException {
        out.println("Enter the name of the card");
        String nameCard = scanner.nextLine();
        out.println("Enter the amount of money on card");
        BigDecimal value = scanner.nextBigDecimal();
        wallet.addCard(nameCard, value);
        userMenu();
    }

    public void printCardSum() throws IOException {
        out.println(wallet.cardSum());
        userMenu();
    }

    public void printBillsSum() throws IOException {
        out.println(wallet.billsSum());
        userMenu();
    }

    @Override
    public void printTotalSum() throws IOException {
        out.println(wallet.allSum());
        userMenu();
    }

    public void deleteWallet() throws IOException {
        out.println("Enter name wallet which needs to be removed");
        String nameWallet = scanner.nextLine();
        if (wallet.getNameWallet().equals(nameWallet)) {
            walletsService.deleteWallet(wallet);
        }
        userMenu();
    }

    @Override
    public void print() throws IOException {
        walletsService.getWallets().stream().forEach(out::println);
        userMenu();
    }
}

