package modelUI;

import domain.Item;
import enums.interfaces.IServiceUI;
import service.PotentialExpenses;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import static java.lang.System.out;

public class PotentialExpenseUI implements IServiceUI {
    Scanner scanner = new Scanner(System.in);
    PotentialExpenses potentialExpenses = new PotentialExpenses();

    @Override
    public void userMenu() throws IOException, ParseException {
        int var;
        out.println("1: Add new potential expense \n" +
                "2: Sort by priority \n" +
                "3: Sort alphabetically \n" +
                "4: Get total cost potential expense \n" +
                "5: Print list potential expense \n" +
                "0: Exit \n" +
                "Enter the menu item number:");
        Scanner userInput = new Scanner(System.in);
        var = userInput.nextInt();
        if (var == 1) {
            addNewPotentialExpense();
        } else if (var == 2) {
            sortedByPriority();
        } else if (var == 3) {
            sortedAlphabetically();
        } else if (var == 4) {
            printTotalSum();
        } else if (var == 5) {
            print();
        } else if (var == 0) {
            out.print("Good Bye");
            System.exit(0);
        }
    }

    public void addNewPotentialExpense() throws IOException, ParseException {
        Item item = new Item();
        out.println("Enter the name of the potential expense");
        String name = scanner.nextLine();
        item.setName(name);
        out.println("Enter the price of the potential expense");
        String price = scanner.nextLine();
        item.setPrice(price);
        out.println("Enter the priority of the potential expense");
        int priority = scanner.nextInt();
        item.setPriority(priority);
        potentialExpenses.add(item);
        potentialExpenses.saveToFile();
        userMenu();
    }

    public void sortedByPriority() throws IOException, ParseException {
        potentialExpenses.sortedPriority();
        userMenu();
    }

    public void sortedAlphabetically() throws IOException, ParseException {
        potentialExpenses.sortedAlphabet();
        userMenu();
    }

    @Override
    public void printTotalSum() throws IOException, ParseException {
        out.println(potentialExpenses.getTotalCosts());
        userMenu();
    }

    @Override
    public void print() throws IOException, ParseException {
        potentialExpenses.getItemList()
                .stream()
                .forEach(out::println);
        userMenu();
    }
}
