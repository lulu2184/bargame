package backend;

import frontend.DecisionFrame;

/**
 * Created by LU on 15/7/9.
 */
public class HumanPlayer extends Player{
    private Integer currentDecision;
    private InteractiveController controller = null;

    public HumanPlayer(InteractiveController controller, int m){
        super(m);
        this.controller = controller;
    }

    public Integer getDecision(){
        currentDecision = controller.getDecision();
        return currentDecision;
    }

    public void update(Integer barStatus){
        shortMemory.removeFirst();
        historyChoose.removeFirst();
        historyChoose.addLast(currentDecision);
        if ((barStatus.equals(Game.BUSY) && currentDecision.equals(Strategy.GO)) || (barStatus.equals(Game.FREE) && currentDecision.equals(Strategy.STAY))){ //和大部分人选择一样，则失败
            shortMemory.addLast(LOSE);
        }else{
            shortMemory.addLast(WIN);
            capital++;
        }
    }

    public Strategy getStrategy(int strategyNum){
        return null;
    }
}
