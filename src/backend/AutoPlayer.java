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

    public Integer getDecision(){ // 0：表示不去 1：表示去
        currentDecision = strategy.getDecision(shortMemory);
        return currentDecision;
    }

    public void update(Integer barStatus){
        strategy.updateStrategy(shortMemory, barStatus);
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
        return strategy.getStrategy(strategyNum);
    }
}
