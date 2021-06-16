
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
        System.out.println("�������� ����������� ��������");
        out.println("1: ���������� �������� � ���������� ������ \n" +
                "2: ���������� �������� � ��������� \n" +
                "3: ���������� �������� � ������� ������� ������ \n" +
                "4: ���������� �������� � ������� ������������� ������ \n" +
                "5: ���������� �������� � ������� �������������� ������ \n" +
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

