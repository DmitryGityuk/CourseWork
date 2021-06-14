package service;

import domain.Wallet;
import enums.interfaces.ServiceWalletAndCard;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.out;

/***
 * Класс описывает список кошельков и работы с ними
 */
public class WalletsService implements ServiceWalletAndCard {
    /***
     * список всех кошельков
     */
    private ArrayList<Wallet> wallets;

    public WalletsService() {
        this.wallets = new ArrayList<>();
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
     *
     */
    public void deleteWallet(Wallet nameWallet) {
        wallets.remove(nameWallet);
    }

    /***
     * Метод производит подсчёт общей суммы по всем кошелькам
     */
    @Override
    public void getTotalSum() {
        BigDecimal total = (BigDecimal) wallets
                .stream()
                .map(Wallet::allSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Общая сумма составляет: " + total);
    }

    /***
     * Метод производит печать списка всех кошельков
     */
    @Override
    public void print() {
        wallets.stream().forEach(out::println);
    }


}


