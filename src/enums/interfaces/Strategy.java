package enums.interfaces;

import domain.Wallet;
import service.PotentialIncome;

public interface Strategy {
    int userChoice(int a);

}

class StrategyWallet implements Strategy{
    @Override
    public int userChoice(int a) {
        return 0;
    }
}
