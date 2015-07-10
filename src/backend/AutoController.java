package backend;

import frontend.MainFrame;

import java.util.Timer;

/**
 * Created by LU on 15/7/9.
 */
public class AutoController extends Controller{
    public AutoController(MainFrame frame){
        super(frame);
    }

    public void initialize(int n, int m, int s){
        game = new AutoGame(this, n, m, s);
    }
}
