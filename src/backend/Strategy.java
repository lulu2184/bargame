package backend;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by LU on 15/7/9.
 */
public class Strategy {
    private Integer content[];
    private Integer score;
    private Integer M;
    private Integer contentSize;

    public Strategy(int m){
        M = m;
        score = 0;
        contentSize = (1 << m);
        content = new Integer[contentSize];
        Random r = new Random();
        for (int i = 0; i < contentSize; i++){
            if (r.nextBoolean()) content[i] = 1;
            else content[i] = -1;
        }
    }

    public void update(ArrayDeque<Integer> shortMemory, Integer barStatus){
        Integer choose = getDecision(shortMemory);
        if (choose.equals(barStatus)){
            score++;
        }
    }

    public Integer getDecision(ArrayDeque<Integer> shortMemory){
        Integer index = 0;
        for (Iterator iter = shortMemory.iterator(); iter.hasNext();){
            index = index * 2 + (Integer)iter.next();
        }
        return content[index];
    }

    public Integer[] getContent(){
        return content;
    }

    public Strategy fightTo(Strategy opponent){
        if (score > opponent.getScore()){
            return this;
        }else{
            return opponent;
        }
    }

    public Integer getScore(){
        return score;
    }
}
