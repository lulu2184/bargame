package backend;

import java.util.ArrayDeque;

/**
 * Created by LU on 15/7/9.
 */
abstract public class Player {
    protected ArrayDeque<Integer> shortMemory;
    protected Integer capital;

    public static final Integer WIN = 1;
    public static final Integer LOSE = -1;


    public Player(int m){
        shortMemory = new ArrayDeque<Integer>();
        for (int i = 0; i < m; i++){
            shortMemory.addLast(LOSE);
        }
        capital = 0;
    }
    abstract public Integer getDecision();
    abstract public void update(Integer barStatus);

    public Integer[] getShortMemory(){
        return shortMemory.toArray(new Integer[0]);
    }

    abstract public Strategy getStrategy(int strategyNum);

    public Integer getCapital(){
        return capital;
    }
}
