package service;

import domain.Wallet;
import enums.interfaces.IServiceWalletAndCard;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.out;

/***
 * Класс описывает список кошельков и работы с ними
 */
public class WalletsService implements IServiceWalletAndCard {
    /***
     * список всех кошельков
     */
    private ArrayList<Wallet> wallets;

    public WalletsService() {
        this.wallets = new ArrayList<>();
    }

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(ArrayList<Wallet> wallets) {
        this.wallets = wallets;
    }

    /***
     * Метод производит добавление нового кошелька
     * @param wallet - кошелёк
     */
    public void add(Wallet wallet) {
        wallets.add(wallet);
    }

    /***
     * Метод производит удаление кошелька
     */
    public void deleteWallet(Wallet nameWallet) {
        wallets.remove(nameWallet);
    }

    /***
     * Метод производит подсчёт общей суммы по всем кошелькам
     * @return
     */
    @Override
    public BigDecimal getTotalSum() {
        BigDecimal total = (BigDecimal) wallets
                .stream()
                .map(Wallet::allSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма составляет: " + total);
        return total;
    }

    /***
     * Метод производит сохранение списка кредитных карт
     * @throws IOException
     */
    public void saveToFile() throws IOException {
        Writer writeWallet = new FileWriter("src/files/wallets.txt", true);
        for (Wallet line : wallets) {
            writeWallet.write(String.valueOf(line));
        }
        writeWallet.close();
    }

    @Override
    public String toString() {
        return "Wallet "
                ;
    }
}




