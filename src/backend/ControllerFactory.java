package backend;

import frontend.MainFrame;

import java.awt.*;

/**
 * Created by LU on 15/7/9.
 */
public class ControllerFactory {
    static public Controller createController(MainFrame frame, boolean isPlayer, int n, int m, int s){
        Controller controller;
        if (isPlayer){
            controller = new InteractiveController(frame, n, m, s);
        }else{
            controller = new AutoController(frame, n, m, s);
        }
        return controller;
    }
}
