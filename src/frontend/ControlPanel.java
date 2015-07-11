package frontend;


import backend.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LU on 15/6/24.
 */
public class ControlPanel extends JPanel{
    private JButton runButton;
    private JButton stopButton;

    public ControlPanel(){
        super();
        //this.setSize(100, 100);
        this.setBorder(new LineBorder(Color.gray, 3, true));
        //this.setLayout(new FlowLayout());
        this.add(new JLabel("control"));
        this.add(this.getRunButton(), null);
        this.add(this.getStopButton(), null);
    }

    private JButton getRunButton(){
        if (runButton == null){
            runButton = new JButton();
            runButton.setText("Run");
            runButton.addActionListener(new RunButton());
            runButton.setSize(50, 20);
        }
        return runButton;
    }

    private JButton getStopButton(){
        if (stopButton == null){
            stopButton = new JButton();
            stopButton.setText("Stop");
            stopButton.addActionListener(new StopButton());
            stopButton.setSize(50, 20);
        }
        return stopButton;
    }


    private class RunButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Controller.getController().run();
//            runButton.setEnabled(false);
//            stopButton.setEnabled(true);
        }
    }

    private class StopButton implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Controller.getController().stop();
//            runButton.setEnabled(true);
//            stopButton.setEnabled(false);
        }
    }
}
