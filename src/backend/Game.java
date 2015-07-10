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
    private ArrayDeque<Integer> historyStatus;
    private Controller controller;

    public Game(Controller controller, int n, int m){
        this.controller = controller;
        barStatus = 0;
        this.n = n;
        historyStatus = new ArrayDeque<Integer>();
        for (int i = 0; i < m; i++){
            historyStatus.addLast(0);
        }
    }

    protected void runOneTurn(){
        Integer numberInBar = 0;
        count++;
        for (Player player : playerSet){
            Integer choose = player.getDecision();
            numberInBar = numberInBar + choose;
        }
        setBarStatus(numberInBar);
        for (Player player : playerSet){
            player.updateMemory(numberInBar);
        }
        updateObserver();
    }

    private void setBarStatus(Integer numberInBar){
        if (numberInBar * 2 > n){
            barStatus = 1;
        }else{
            barStatus = 0;
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
}
