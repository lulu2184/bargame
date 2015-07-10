package frontend;

import backend.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LU on 15/7/10.
 */
public class StrategyInputPanel extends JPanel{
    private JLabel playerNumLabel;
    private JTextField playerNumField;
    private JButton viewButton;

    public StrategyInputPanel(){
        super();
        this.setBorder(new LineBorder(Color.gray, 3, true));
        this.setLayout(new FlowLayout());
        this.add(this.getPlayerNumLabel(), null);
        this.add(this.getPlayerNumField(), null);
        this.add(this.getViewButton(), null);
    }

    private JButton getViewButton(){
        if (viewButton == null){
            viewButton = new JButton();
            viewButton.setText("View");
            viewButton.addActionListener(new ViewButton());
            viewButton.setSize(50, 20);
        }
        return viewButton;
    }

    private JTextField getPlayerNumField(){
        if (playerNumField == null){
            playerNumField = new JTextField();
            playerNumField.setSize(50, 20);
            playerNumField.setColumns(5);
        }
        return playerNumField;
    }

    private JLabel getPlayerNumLabel(){
        if (playerNumLabel == null){
            playerNumLabel = new JLabel("player num: ");
        }
        return playerNumLabel;
    }


    private class ViewButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int player = Integer.parseInt(playerNumField.getText());
            new StrategyFrame(player);
        }
    }


}
