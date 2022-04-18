package enums.interfaces;

import java.io.IOException;
import java.math.BigDecimal;

public interface IServiceList {
    /***
     * интерфейс получения общей суммы
     * @return
     */
    BigDecimal getTotalCosts();

    void saveToFile() throws IOException;
}
