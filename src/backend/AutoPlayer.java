package backend;

/**
 * Created by LU on 15/7/9.
 */
public class AutoPlayer extends Player{
    private StrategySet strategy;
    private Integer currentDecision;

    public AutoPlayer(int m, int s){
        super(m);
        strategy = new StrategySet(m, s);
    }

    public Integer getDecision(){
        currentDecision = strategy.getDecision(shortMemory);
        return currentDecision;
    }

    public void updateMemory(Integer barStatus){
        strategy.updateStrategy(shortMemory, barStatus);
        shortMemory.removeFirst();
        shortMemory.addLast(currentDecision);
    }
}
