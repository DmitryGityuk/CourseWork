package enums.interfaces;

import java.io.IOException;
import java.math.BigDecimal;

public interface IServiceWalletAndCard {

    /***
     * интерфейс получения общей суммы
     */
    BigDecimal getTotalSum();

    /***
     * Интерфейс сохранения списка в фаил
     * @throws IOException
     */
    void saveToFile() throws IOException;
}
