package sample.ports;

import sample.InGameColor;
import sample.Treasure;
import sample.rightSideMenu.trade.TradingController;

import java.util.ArrayList;

import static sample.BoardController.BATTLE;
import static sample.GameManager.currentPlayer;
import static sample.GameManager.launchTradeWindow;

public class TradingPort extends Port {

    public TradingPort(InGameColor color, String portName) {
        super(color, portName);
        safeInventory = new ArrayList<>();
        nonSafeInventory = new ArrayList<>();
    }


    @Override
    public void playerArrive() {
        TradingController controller = new TradingController();
        launchTradeWindow(this);
        controller.initializeVariable(currentPlayer, this);
    }
}
