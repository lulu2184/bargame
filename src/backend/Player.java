package backend;

import java.util.ArrayDeque;

/**
 * Created by LU on 15/7/9.
 */
abstract public class Player {
    ArrayDeque<Integer> shortMemory;

    public Player(int m){
        shortMemory = new ArrayDeque<Integer>();
        for (int i = 0; i < m; i++){
            shortMemory.addLast(0);
        }
    }
    abstract public Integer getDecision();
    abstract public void update(Integer barStatus);

    public Integer[] getShortMemory(){
        return shortMemory.toArray(new Integer[0]);
    }
}
