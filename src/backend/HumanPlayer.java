package backend;

import frontend.DecisionFrame;

/**
 * Created by LU on 15/7/9.
 */
public class HumanPlayer extends Player{
    private boolean waitingFlag;
    private Integer currentDecision;
    private InteractiveController controller = null;

    public HumanPlayer(InteractiveController controller, int m){
        super(m);
        this.controller = controller;
    }

    public Integer getDecision(){
//        waitingFlag = true;
//        DecisionFrame decisionFrame = new DecisionFrame(this);
        currentDecision = controller.getDecision();
        return currentDecision;
    }

    public void decisionCallback(Integer choose){
        currentDecision = choose;
        waitingFlag = false;
    }

    public void update(Integer barStatus){
        shortMemory.removeFirst();
        if ((barStatus.equals(Game.BUSY) && currentDecision.equals(Strategy.GO)) || (barStatus.equals(Game.FREE) && barStatus.equals(Strategy.STAY))){ //和大部分人选择一样，则失败
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
