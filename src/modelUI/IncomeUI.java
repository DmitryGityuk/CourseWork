package modelUI;

import domain.BankCard;
import enums.interfaces.Holder;
import service.BankCardService;
import service.PotentialIncome;
import static java.lang.System.out;

import java.util.Scanner;

public class IncomeUI {
    public void createIncome(){
        PotentialIncome incoming = new PotentialIncome();
        Scanner scanner = new Scanner(System.in);
        int selectPlaceIncome;
        out.println("Выберите куда поступили денежные средства: 1. Банковская карта 2. Кошелёк ");
        selectPlaceIncome = scanner.nextInt();
        Holder holder;
        switch (selectPlaceIncome){
            case 1 -> holder = Holder.BANKCARD;
            case 2 -> holder = Holder.WALLET;
        }
        if (selectPlaceIncome == 1){
            out.println("Выберите карту на которую поступили денежные средства");


        }


    }

    public void addBills(){

    }
}
