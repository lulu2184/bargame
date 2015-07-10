package backend;

import java.util.Timer;

/**
 * Created by LU on 15/7/9.
 */
public class AutoGame extends Game{
    private Timer timer;

    public AutoGame(Controller controller, int n, int m, int s){
        super(controller, n, m);
        playerSet = new Player[n];
        for (int i = 0; i < n; i++){
            playerSet[i] = new AutoPlayer(m, s);
        }
    }

    public void run(){
        timer = new Timer();
        timer.schedule(new GameRunTask(this), 3000, 3000);
    }

    public void stop(){
        timer.cancel();
        timer = null;
    }
}
