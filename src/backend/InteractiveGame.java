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
//            try {
//                Thread.sleep(5);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//                System.err.println(e);
//                break;
//            }
//        }
//        timer = new Timer();
//        timer.schedule(new GameRunTask(this), 3000, 3000);
    }

    public void stop(){
//        timer.cancel();
//        timer = null;
    }
}
