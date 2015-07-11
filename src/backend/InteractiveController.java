package backend;

import frontend.DecisionFrame;
import frontend.MainFrame;
import sun.applet.Main;

/**
 * Created by LU on 15/7/9.
 */
public class InteractiveController extends Controller{
    private DecisionFrame dframe = null;
    private Integer decision = null;

    public InteractiveController(MainFrame frame, int n, int m, int s){
        super(frame, n, m, s);
        game = new InteractiveGame(this, n, m, s);
    }

    @Override
    public void run(){
        if (decision == null) {
            if (dframe == null) {
                dframe = new DecisionFrame(this);
            }
        }else {
            game.run();
            decision = null;
        }
    }

    public Integer getDecision(){
        return decision;
    }

    public void setDecision(Integer decision){
        this.decision = decision;
    }
}

