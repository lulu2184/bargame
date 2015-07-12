package frontend;

import backend.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/7/12.
 */
public class CapitalPanel extends JPanel{
    private JLabel[] label;
    private int n;

    public CapitalPanel(){
        n = Controller.getController().getN();
        String type = Controller.getController().getControllerType();
        this.setBorder(BorderFactory.createTitledBorder("agent capital"));
        this.setLayout(new GridLayout(2, n));
        for (int i = 0; i < n; i++){
            JLabel label = new JLabel(Integer.toString(i));
            if (i == 0 && type.equals("Interactive")){
                label.setForeground(new Color(204, 26, 26));
            }
            label.setFont(new Font("Dialog", 0, 15));
            label.setBorder(BorderFactory.createEtchedBorder());
            this.add(label);
        }
        label = new JLabel[n];
        for (int i = 0; i < n; i++){
            label[i] = new JLabel();
            if (i == 0 && type.equals("Interactive")){
                label[i].setForeground(new Color(204, 26, 26));
            }
            label[i].setBorder(BorderFactory.createEtchedBorder());
            label[i].setFont(new Font("Dialog", 0, 15));
            this.add(label[i]);
        }
        update();
    }

    public void update(){
        Integer[] score = Controller.getController().getPlayerCapital();
        for (int i = 0; i < n; i++){
            label[i].setText(score[i].toString());
        }
    }
}
