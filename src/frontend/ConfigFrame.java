package frontend;

import backend.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by LU on 15/6/24.
 */
public class ConfigFrame extends JFrame {
    private JButton playButton;
    private JButton viewButton;
    private JTextField nField;
    private JTextField mField;
    private JTextField sField;
    private JLabel nLabel;
    private JLabel mLabel;
    private JLabel sLabel;
    private JLabel title;
    private MainFrame father;

    private static int ROW_OF_N = 0;
    private static int ROW_OF_M = 1;
    private static int ROW_OF_S = 2;

    public ConfigFrame(MainFrame fatherFrame) {
        super();
        this.father = fatherFrame;
        Dimension formSize = new Dimension(200, 250);
        this.setLocationRelativeTo(null);
        this.setSize(formSize);
        this.setMaximumSize(new Dimension(formSize));
        this.getContentPane().setLayout(null);
        this.setTitle("config");
        this.add(this.getnLabel(), null);
        this.add(this.getmLabel(), null);
        this.add(this.getsLabel(), null);
        this.add(this.getmField(), null);
        this.add(this.getnField(), null);
        this.add(this.getsField(), null);
        //      this.add(this.getConfigTitle(), null);
        this.add(this.getPlayButton(), null);
        this.add(this.getViewButton(), null);
        this.setVisible(true);
    }

    private JLabel createLabel(int row, String text) {
        JLabel label = new JLabel();
        label.setBounds(60, 20 + 30 * row, 40, 20);
        label.setText(text);
        return label;
    }

    private JTextField createTextField(int row) {
        JTextField tField = new JTextField(10);
        tField.setBounds(80, 20 + 30 * row, 60, 20);
        return tField;
    }

    private JLabel getnLabel() {
        if (nLabel == null) {
            nLabel = createLabel(ROW_OF_N, "N = ");
        }
        return nLabel;
    }

//    private JLabel getConfigTitle(){
//        if (title == null){
//            title = new JLabel();
//            title.setBounds(80, 10, 100, 20);
//            title.setText("config");
//        }
//        return title;
//    }

    private JLabel getmLabel() {
        if (mLabel == null) {
            mLabel = createLabel(ROW_OF_M, "M = ");
        }
        return mLabel;
    }

    private JLabel getsLabel() {
        if (sLabel == null) {
            sLabel = createLabel(ROW_OF_S, "S = ");
        }
        return sLabel;
    }

    private JTextField getmField() {
        if (mField == null) {
            mField = createTextField(ROW_OF_M);
        }
        return mField;
    }

    private JTextField getnField() {
        if (nField == null) {
            nField = createTextField(ROW_OF_N);
        }
        return nField;
    }

    private JTextField getsField() {
        if (sField == null) {
            sField = createTextField(ROW_OF_S);
        }
        return sField;
    }

    private JButton getPlayButton() {
        if (playButton == null) {
            playButton = new JButton();
            playButton.setBounds(30, 120, 150, 20);
            playButton.setText("I am a player");
            playButton.addActionListener(new playButton());
        }
        return playButton;
    }

    private JButton getViewButton() {
        if (viewButton == null) {
            viewButton = new JButton();
            viewButton.setBounds(30, 160, 150, 20);
            viewButton.setText("I am a spetator");
            viewButton.addActionListener(new viewButton());
        }
        return viewButton;
    }

    private int getNumber(JTextField tField) {
        return Integer.parseInt(tField.getText());
    }


    private class playButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Controller.createController(father, true, getNumber(nField), getNumber(mField), getNumber(sField));
            father.initialize();
            dispose();
        }
    }

    private class viewButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Controller.createController(father, false, getNumber(nField), getNumber(mField), getNumber(sField));
            father.initialize();
            dispose();
        }
    }
}
