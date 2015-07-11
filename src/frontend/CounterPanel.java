package frontend;

import backend.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by LU on 15/7/10.
 */
public class CounterPanel extends JPanel{
    private JLabel roundLabel;

    public CounterPanel() {
        super();
        this.setSize(100, 100);
//        this.setBorder(new LineBorder(Color.gray, 3, true));
        this.setBorder(BorderFactory.createTitledBorder("round"));
        this.setLayout(new FlowLayout());
        this.add(new JLabel("Round : "));
        this.add(this.getStatusLabel(), null);
    }

    private String getRound(){
        Integer status = Controller.getController().getRound();
        return status.toString();
    }

    private JLabel getStatusLabel(){
        if (roundLabel == null){
            roundLabel = new JLabel(getRound());
        }
        return roundLabel;
    }

    public void refresh(){
        roundLabel.setText(getRound());
    }
}
