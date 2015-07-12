package backend;

import java.util.Timer;

/**
 * Created by LU on 15/7/9.
 */
public class InteractiveGame extends Game{
//    private Timer timer;
    public InteractiveGame(InteractiveController controller, int n, int m, int s){
        super(controller, n, m);
        playerSet = new Player[n];
        playerSet[0] = new HumanPlayer(controller, m);
        for (int i = 1; i < n; i++){
            playerSet[i] = new AutoPlayer(m, s);
        }
    }

    public void run(){
          runOneTurn();
    }

    public void stop(){
    }
}
