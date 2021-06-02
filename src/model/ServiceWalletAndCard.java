package model;

public interface ServiceWalletAndCard {
    /***
     * интерфейс печати всего списка
     */
    void print();

    /***
     * интерфейс получения общей суммы по кошелькам/ банковским картам
     */
    void getAllSum();

}
