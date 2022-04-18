
import modelUI.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static java.lang.System.out;

public class GlobalMenu {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ParseException {
        GlobalMenu globalMenu = new GlobalMenu();
        globalMenu.menuUser();
    }

    public void menuUser() throws IOException, ParseException {
        BankCardUI bankCardUI = new BankCardUI();
        CurrentExpenseUI currentExpenseUI = new CurrentExpenseUI();
        IncomeUI incomeUI = new IncomeUI();
        PotentialExpenseUI potentialExpenseUI = new PotentialExpenseUI();
        WalletUI walletUI = new WalletUI();
        int var;
        System.out.println("¬ыберите необходимое действие");
        out.println("1: ѕроизвести операции с банковской картой \n" +
                "2: ѕроизвести операции с кошельком \n" +
                "3: ѕроизвести операции с списком текущих затрат \n" +
                "4: ѕроизвести операции с списком потенциальных затрат \n" +
                "5: ѕроизвести операции с списком потенциального дохода \n" +
                "0: Exit \n" +
                "Enter the menu item number:");
        var = scanner.nextInt();
        if (var == 1) {
            bankCardUI.userMenu();
            menuUser();
        } else if (var == 2) {
            walletUI.userMenu();
            menuUser();
        } else if (var == 3) {
            currentExpenseUI.userMenu();
            menuUser();
        } else if (var == 4) {
            potentialExpenseUI.userMenu();
            menuUser();
        } else if (var == 5) {
            incomeUI.userMenu();
            menuUser();
        } else if (var == 0) {
            out.print("Good Bye");
            System.exit(0);
        }
    }
}

