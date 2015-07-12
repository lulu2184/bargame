package backend;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by LU on 15/7/9.
 */
public class StrategySet {
    private ArrayList<Strategy> strategies;
    private Integer S;

    public StrategySet(int m, int s){
        S = s;
        strategies = new ArrayList<Strategy>();
        for (int i = 0; i < s; i ++){
            strategies.add(new Strategy(m));
        }
    }

    public Integer getDecision(ArrayDeque<Integer> shortMemory){
        Strategy optimal = null;
        for (Strategy strategy : strategies){
            if (optimal == null){
                optimal = strategy;
            }else{
                optimal = optimal.fightTo(strategy);
            }
        }
        return optimal.getDecision(shortMemory);
    }

    public void updateStrategy(ArrayDeque<Integer> shortMemory, Integer barStatus){
        for (Strategy strategy : strategies){
            strategy.update(shortMemory, barStatus);
        }
    }

    public Strategy getStrategy(int strategyNum){
        if (strategyNum >= S) return null;
        return strategies.get(strategyNum);
    }
}
