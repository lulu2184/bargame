package frontend;

import backend.Controller;
import backend.Strategy;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/7/10.
 */
public class StrategyFrame extends JFrame {
    private int playerNum;
    private int strategyNum;
    private int cols;
    private int rows;

    private JLabel historyLabel;
    private JLabel actionLabel;
    private JLabel titleLabel;

    private JScrollPane scrollPane;
    private JPanel panel;

    public StrategyFrame(int playerNum, int strategyNum) {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        this.cols = Controller.getController().getM();
        this.rows = (1 << this.cols);
        int width = 60 + 25 * cols;
        int height = Math.min(400, 25 * (rows + 3));
        panel.setSize(width, height);
        this.playerNum = playerNum;
        this.strategyNum = strategyNum;
        this.titleLabel = getTitleLabel();
        this.historyLabel = getHistoryLabel();
        this.actionLabel = getActionLabel();
        addStrategies();
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);
        this.setSize(width, height);
        this.setResizable(false);
    }

    private JLabel getBlockLabel(String str) {
        JLabel label = new JLabel(str);
        label.setBorder(BorderFactory.createEtchedBorder());
        return label;
    }

    private void addStrategies() {
        GridBagConstraints constraints = getContraints(0, 2, 1, 1, 3);
        Strategy strategy = Controller.getController().getSStrategy(playerNum, strategyNum);
        if (strategy == null) return;
        Integer[] content = strategy.getContent();
        for (int i = 0; i < rows; i++) {
            constraints.gridx = 0;
            constraints.gridy++;
            constraints.gridwidth = 1;
            String str = Integer.toBinaryString(i);
            while (str.length() < cols) {
                str = "0" + str;
            }
            for (int j = 0; j < cols; j++) {
                panel.add(getBlockLabel(Character.toString(str.charAt(j))), constraints);
                constraints.gridx++;
            }
            constraints.gridwidth = 4;
            panel.add(getBlockLabel("->"), constraints);
            constraints.gridx += 4;
            constraints.gridwidth = 0;
            panel.add(getBlockLabel(content[i].toString()), constraints);
        }
    }

    private GridBagConstraints getContraints(int x, int y, int width, int height, int padding) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.insets = new Insets(padding, padding, padding, padding);
        return constraints;
    }

    private JLabel getHistoryLabel() {
        if (historyLabel == null) {
            historyLabel = new JLabel("hisotry");
            historyLabel.setBorder(BorderFactory.createEtchedBorder());
            GridBagConstraints constraints = getContraints(0, 1, cols, 1, 0);
            panel.add(historyLabel, constraints);
        }
        return historyLabel;
    }

    private JLabel getActionLabel() {
        if (actionLabel == null) {
            actionLabel = new JLabel("action");
            actionLabel.setBorder(BorderFactory.createEtchedBorder());
            GridBagConstraints constraints = getContraints(cols + 4, 1, 4, 1, 0);
            panel.add(actionLabel, constraints);
        }
        return actionLabel;
    }

    private JLabel getTitleLabel() {
        if (titleLabel == null) {
            titleLabel = new JLabel("Strategy " + Integer.toString(strategyNum) + " of player " + Integer.toString(playerNum));
            titleLabel.setBorder(BorderFactory.createEtchedBorder());
            GridBagConstraints constraints = getContraints(0, 0, cols + 10, 1, 0);
            panel.add(titleLabel, constraints);
        }
        return titleLabel;
    }
}
