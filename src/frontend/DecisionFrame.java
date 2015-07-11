package frontend;

import backend.Controller;
import backend.HumanPlayer;
import backend.InteractiveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LU on 15/7/9.
 */
public class DecisionFrame extends JFrame{
    private HumanPlayer player;
    private JButton stayButton;
    private JButton goButton;
    private InteractiveController controller;

    public DecisionFrame(InteractiveController controller){
        this.controller = controller;
        this.stayButton = getStayButton();
        this.goButton = getGoButton();
        this.add(stayButton);
        this.add(goButton);
        this.setSize(100, 100);
        this.setResizable(false);
        setLayout(new FlowLayout());
        this.setVisible(true);
    }

    private JButton getStayButton(){
        if (stayButton == null){
            stayButton = new JButton("stay at home");
            stayButton.addActionListener(new stayButton());
            stayButton.setSize(20, 80);
        }
        return stayButton;
    }

    private JButton getGoButton(){
        if (goButton == null){
            goButton = new JButton("go to bar");
            goButton.addActionListener(new goButton());
            goButton.setSize(20, 80);
        }
        return goButton;
    }

    private class stayButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //decisionCallback(-1);
            controller.setDecision(-1);
            controller.run();
            dispose();
        }
    }

    private class goButton implements  ActionListener{
        public void actionPerformed(ActionEvent e){
//            player.decisionCallback(1);
            controller.setDecision(1);
            controller.run();
            dispose();
        }
    }

}
