package backend;

import frontend.MainFrame;
import sun.applet.Main;

import java.util.ArrayDeque;

/**
 * Created by LU on 15/7/9.
 */
public abstract class Controller {
    static private Controller controller;

    protected Game game;
    private MainFrame frame;

    private int n;
    private int m;
    private int s;

    static public void createController(MainFrame frame, boolean isPlayer, int n, int m, int s){
        controller = ControllerFactory.createController(frame, isPlayer, n, m, s);
    }

    static public Controller getController(){
        return controller;
    }

    public Controller(MainFrame frame, int n, int m, int s){
        this.frame = frame;
        this.n = n;
        this.m = m;
        this.s = s;
    }

    public void updateObserver(){
        frame.refresh();
    }

    public void run(){
        game.run();
    }

    public void stop(){
        game.stop();
    }

    public Integer getBarStatus(){
        return game.getBarStatus();
    }

    public Integer getRound() {
        return game.getRound();
    }

    public int getN(){
        return n;
    }

    public int getM(){
        return m;
    }

    public int getS(){
        return s;
    }

    public Integer[] getHistoryStatus(){
        return game.getHistoryStatus();
    }

    public Integer[][] getShortMemory(){
        return game.getShortMemory();
    }

    public Strategy getSStrategy(int playerNum, int strategyNum){
        return game.getStrategy(playerNum, strategyNum);
    }

    abstract public String getControllerType();

    public Integer[] getPlayerCapital(){
        return game.getPlayerCapital();
    }

    public Integer getBusyness(){
        return game.getBusyness();
    }

    public Integer[][] getHistoryChoose(){
        return game.getHistoryChoose();
    }
}
