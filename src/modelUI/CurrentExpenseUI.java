package modelUI;

import enums.interfaces.IServiceUI;
import service.CurrentExpenses;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static java.lang.System.out;

public class CurrentExpenseUI implements IServiceUI {
    Scanner scanner = new Scanner(System.in);
    CurrentExpenses currentExpenses = new CurrentExpenses();


    @Override
    public void userMenu() throws IOException, ParseException {
        int var;
        out.println("1: Add new Current Expense \n" +
                "2: Get the sum of costs by category \n" +
                "3: Get the total cost \n" +
                "4: Printing a list of expense \n" +
                "5: Remove all spending in a category \n" +
                "0: Exit \n" +
                "Enter the menu item number:");
        Scanner userInput = new Scanner(System.in);
        var = userInput.nextInt();
        if (var == 1) {
            addNewExpense();
        } else if (var == 2) {
            printSumCategory();
        } else if (var == 3) {
            printTotalSum();
        } else if (var == 4) {
            print();
        } else if (var == 5) {
            removeExpense();
        } else if (var == 0) {
            out.print("Good Bye");
            System.exit(0);
        }
    }

    public void addNewExpense() throws IOException, ParseException {
        out.println("Enter the name of the expense");
        String nameExpense = scanner.nextLine();
        out.println("Enter the cost expense");
        String price = scanner.nextLine();
        out.println("Enter the date expense");
        String date = scanner.nextLine();
        out.println("Enter the category expense");
        String category = scanner.nextLine();
        currentExpenses.add(nameExpense, price, date, category);
        currentExpenses.saveToFile();
        userMenu();
    }

    public void printSumCategory() throws IOException, ParseException {
        out.println("For which category do you want to receive the amount");
        String cat = scanner.nextLine();
        out.println("The amount of costs for the selected category: " + currentExpenses.getCostsCategory(cat));
        userMenu();
    }

    @Override
    public void printTotalSum() throws IOException, ParseException {
        out.println("Total cost: " + currentExpenses.getTotalCosts());
        userMenu();
    }

    public void removeExpense() throws IOException, ParseException {
        out.println("Select the category of spending you want to delete");
        String cat = scanner.nextLine();
        currentExpenses.deleteExpense(cat);
        userMenu();
    }

    @Override
    public void print() throws IOException, ParseException {
        currentExpenses.getExpense()
                .stream()
                .forEach(out::println);
        userMenu();
    }
}
