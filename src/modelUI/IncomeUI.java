package modelUI;

import domain.BankCard;
import enums.interfaces.IServiceUI;
import service.PotentialIncome;

import static java.lang.System.out;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class IncomeUI implements IServiceUI {
    Scanner scanner = new Scanner(System.in);
    PotentialIncome potentialIncome = new PotentialIncome();

    @Override
    public void userMenu() throws BankCard.MinusCardNumberException, BankCard.ShortNameException, IOException, ParseException {
        int var;
        out.println("1: Add new Income \n" +
                "2: Get the total income \n" +
                "3: Get the category of income \n" +
                "4: Printing a list of income \n" +
                "0: Exit \n" +
                "Enter the menu item number:");
        Scanner userInput = new Scanner(System.in);
        var = userInput.nextInt();
        if (var == 1) {
            addIncome();
        } else if (var == 2) {
            printTotalSum();
        } else if (var == 3) {
            getSumCategory();
        } else if (var == 4) {
            print();
        } else if (var == 0) {
            out.print("Good Bye");
            System.exit(0);
        }
    }

    public void addIncome() throws IOException, ParseException {
        out.println("Enter the amount of income");
        String value = scanner.nextLine();
        out.println("Enter the type of income");
        String comment = scanner.nextLine();
        out.println("Enter where the income was received : 1. Wallet 2. BankCard");
        String category = scanner.nextLine();
        potentialIncome.add(value, comment, category);
        potentialIncome.saveToFile();
        userMenu();
    }

    public void getSumCategory() throws IOException, ParseException {
        out.println("For which category do you want to receive the amount");
        String category = scanner.nextLine();
        potentialIncome.getCostCategory(category);
        userMenu();
    }

    @Override
    public void printTotalSum() throws IOException, ParseException {
        out.println(potentialIncome.getTotalCosts());
        userMenu();
    }

    @Override
    public void print() throws IOException, ParseException {
        potentialIncome.getIncome()
                .stream()
                .forEach(out::print);
    }
}
