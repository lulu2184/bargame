package backend;

import frontend.MainFrame;
import sun.applet.Main;

/**
 * Created by LU on 15/7/9.
 */
public abstract class Controller {
    static private Controller controller;

    protected Game game;
    private MainFrame frame;

    static public void createController(MainFrame frame, boolean isPlayer, int n, int m, int s){
        controller = ControllerFactory.createController(frame, isPlayer, n, m, s);
    }

    static public Controller getController(){
        return controller;
    }

    public Controller(MainFrame frame){
        this.frame = frame;
    }

    abstract public void initialize(int n, int m, int s);

    public void updateObserver(){
        frame.refresh();
    }

    public void run(){
        game.run();
    }

    public void stop(){
        game.stop();
    }

    public Integer getBarStatus(){
        return game.getBarStatus();
    }

    public Integer getRound(){
        return game.getRound();
    }
}
