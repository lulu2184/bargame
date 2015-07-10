package backend;

import java.util.TimerTask;

/**
 * Created by LU on 15/7/10.
 */
public class GameRunTask extends TimerTask{
    private Game game;

    public GameRunTask(Game game){
        super();
        this.game = game;
    }

    public void run(){
        game.runOneTurn();
    }
}
