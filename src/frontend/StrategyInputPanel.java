package frontend;

import backend.Controller;
import sun.applet.Main;

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
    private JLabel strategyNumLabel;
    private JTextField playerNumField;
    private JTextField strategyNumField;
    private JButton viewButton;
    private MainFrame father;

    public StrategyInputPanel(MainFrame father){
        super();
        this.father = father;
//        this.setBorder(new LineBorder(Color.gray, 3, true));
        this.setBorder(BorderFactory.createTitledBorder("watch"));
        this.setLayout(new FlowLayout());
        this.add(this.getPlayerNumLabel(), null);
        this.add(this.getPlayerNumField(), null);
        this.add(this.getStrategyNumLabel(), null);
        this.add(this.getStrategyNumField(), null);
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

    private JLabel getStrategyNumLabel(){
        if (strategyNumLabel == null){
            strategyNumLabel = new JLabel("strategy num:");
        }
        return strategyNumLabel;
    }

    private JTextField getStrategyNumField(){
        if (strategyNumField == null){
            strategyNumField = new JTextField();
            strategyNumField.setSize(50, 20);
            strategyNumField.setColumns(5);
        }
        return strategyNumField;
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
            int strategyNum = Integer.parseInt(strategyNumField.getText());
            father.setStrategyFrame(new StrategyFrame(player, strategyNum));
        }
    }


}
