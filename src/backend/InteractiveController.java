package backend;

import frontend.MainFrame;
import sun.applet.Main;

/**
 * Created by LU on 15/7/9.
 */
public class InteractiveController extends Controller{

    public InteractiveController(MainFrame frame){
        super(frame);
    }

    public void initialize(int n, int m, int s){
       game = new InteractiveGame(this, n, m, s);
    }
}
