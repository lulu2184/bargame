package backend;

import frontend.DecisionFrame;

/**
 * Created by LU on 15/7/9.
 */
public class HumanPlayer extends Player{
    private boolean waitingFlag;
    private Integer currentDecision;

    public HumanPlayer(int m){
        super(m);
    }

    public Integer getDecision(){
        waitingFlag = true;
        DecisionFrame decisionFrame = new DecisionFrame(this);
        while (waitingFlag);
        return currentDecision;
    }

    public void decisionCallback(Integer choose){
        currentDecision = choose;
        waitingFlag = false;
    }

    public void update(Integer barStatus){
        shortMemory.removeFirst();
        if (barStatus.equals(currentDecision)) {
            shortMemory.addLast(0);
        }else{
            shortMemory.addLast(1);
        }
    }
}
