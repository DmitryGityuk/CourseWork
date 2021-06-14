package modelUI;

import domain.Wallet;

import java.util.Scanner;

public class WalletUI {

    public void addNameWallet(){
        Wallet wallet = new Wallet();
        Scanner scanner = new Scanner(System.in);
        wallet.setNameWallet(scanner.nextLine());
    }

}

