package frontend;

import backend.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;

/**
 * Created by LU on 15/7/10.
 */
public class HistoryTablePanel extends JPanel{
    private int n;
    private int m;
    private HistoryGridElement gridElement[][];


    public HistoryTablePanel(){
        n = Controller.getController().getN();
        m = Controller.getController().getM();
        setLayout(new GridLayout(m + 1, n + 1));
        this.add(new JLabel());
        for (int i = 1; i < n + 1; i ++){
            this.add(new JLabel(Integer.toString(i)));
        }
        int round = Controller.getController().getRound();
        gridElement = new HistoryGridElement[m][n];
        for (int i = 0; i < m; i++){
            this.add(new JLabel("Round " + Integer.toString(round)));
            round--;
            for (int j = 0; j < n; j++){
                gridElement[i][j] = new HistoryGridElement();
            }
        }
        update();
    }

    public void update(){
        Integer[] status = Controller.getController().getHistoryStatus();
        Integer[][] memory = Controller.getController().getShortMemory();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                gridElement[i][j].update(status[i], memory[j][i]);
            }
        }
    }
}
