package backend;

import frontend.MainFrame;

/**
 * Created by LU on 15/7/9.
 */
abstract public class Game {
    protected int count;
    protected int n;
    protected Player playerSet[];
    private Integer barStatus;
    private Controller controller;

    public Game(Controller controller){
        this.controller = controller;
        barStatus = 0;
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
}
