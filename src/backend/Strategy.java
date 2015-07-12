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
    private Integer contentSize;

    public static final Integer STAY = -1;
    public static final Integer GO = 1;

    public Strategy(int m){
        score = 0;
        contentSize = (1 << m);
        content = new Integer[contentSize];
        Random r = new Random();
        for (int i = 0; i < contentSize; i++){
            if (r.nextBoolean()) content[i] = GO;
            else content[i] = STAY;
        }
    }

    public void update(ArrayDeque<Integer> shortMemory, Integer barStatus){
        Integer choose = getDecision(shortMemory);
        if ((barStatus.equals(Game.FREE) && choose.equals(GO)) || (barStatus.equals(Game.BUSY) && choose.equals(STAY))){
            score++;
        }
    }

    public Integer getDecision(ArrayDeque<Integer> shortMemory){
        Integer index = 0;
        for (Iterator iter = shortMemory.iterator(); iter.hasNext();){
            Integer digit = (Integer)iter.next();
            if (digit.equals(STAY)) digit = 0;
            index = index * 2 + digit;
        }
        return content[index];
    }

    public Integer[] getContent(){
        return content;
    }

    public Strategy fightTo(Strategy opponent){
        Integer opS = opponent.getScore();
        if (score > opS){
            return this;
        }else if (score.equals(opS)) {
            if (new Random().nextBoolean()) return opponent;
            else return this;
        }else{
            return opponent;
        }
    }

    public Integer getScore(){
        return score;
    }
}
