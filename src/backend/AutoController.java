package backend;

import frontend.MainFrame;

import java.util.Timer;

/**
 * Created by LU on 15/7/9.
 */
public class AutoController extends Controller{
    public AutoController(MainFrame frame, int n, int m, int s){
        super(frame, n, m, s);
        game = new AutoGame(this, n, m, s);
    }

    public String getControllerType(){
        return "Auto";
    }

}
