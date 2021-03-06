package backend;

import frontend.MainFrame;

import java.util.ArrayDeque;

/**
 * Created by LU on 15/7/9.
 */
abstract public class Game {
    protected int count;
    protected int n;
    protected Player playerSet[];
    private Integer barStatus;
    private Integer busyness;
    private ArrayDeque<Integer> historyStatus;
    private Controller controller;

    public static final Integer BUSY = 1;
    public static final Integer FREE = -1;

    public Game(Controller controller, int n, int m){
        this.controller = controller;
        barStatus = FREE;
        this.n = n;
        historyStatus = new ArrayDeque<Integer>();
        for (int i = 0; i < m; i++){
            historyStatus.addLast(FREE);
        }
    }

    protected void runOneTurn(){
        if (count < 99) {
            Integer numberInBar = 0;
            count++;
            for (Player player : playerSet) {
                Integer choose = player.getDecision();
                numberInBar = numberInBar + choose;
            }
            setBarStatus(numberInBar);
            busyness = numberInBar;
            for (Player player : playerSet) {
                player.update(barStatus);
            }
            updateObserver();
        }else stop();
    }

    private void setBarStatus(Integer numberInBar){
        if (numberInBar > 0){
            barStatus = BUSY;
        }else{
            barStatus = FREE;
        }
        historyStatus.removeFirst();
        historyStatus.addLast(barStatus);
    }

    abstract public void run();
    abstract public void stop();

    private void updateObserver(){
        controller.updateObserver();
    }

    public Integer getBarStatus(){
        return barStatus;
    }

    public Integer getRound(){
        return count;
    }

    public Integer[] getHistoryStatus(){
        return historyStatus.toArray(new Integer[0]);
    }

    public Integer[][] getShortMemory(){
        Integer[][] ret = new Integer[n][];
        for (int i = 0; i < n; i++){
            ret[i] = playerSet[i].getShortMemory();
        }
        return ret;
    }

    public Integer[][] getHistoryChoose(){
        Integer[][] ret = new Integer[n][];
        for (int i = 0; i < n; i++){
            ret[i] = playerSet[i].getHistoryChoose();
        }
        return ret;
    }

    public Strategy getStrategy(int playerNum, int strategyNum){
        if (playerNum >= n) return null;
        return playerSet[playerNum].getStrategy(strategyNum);
    }

    public Integer[] getPlayerCapital(){
        Integer[] ret = new Integer[n];
        for (int i = 0; i < n; i++){
            ret[i] = playerSet[i].getCapital();
        }
        return ret;
    }

    public Integer getBusyness(){
        return busyness;
    }
}
