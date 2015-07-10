package frontend;


import backend.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by LU on 15/6/24.
 */
public class MainFrame extends JFrame{
    private ControlPanel controlPanel;
    private BarStatusPanel statusPanel;
    private CounterPanel counterPanel;
    private StrategyInputPanel sInputPanel;
    private HistoryTablePanel historyPanel;

    public MainFrame(){
        super();

        ConfigFrame config = new ConfigFrame(this);
        setVisible(false); //初始默认不可见
        Dimension size = new Dimension(500, 500);
        this.setSize(size);   //设置窗口大小
    }

    public void initialize(){
        this.setVisible(true);
        //设置布局
        this.setLayout(new GridBagLayout());
        controlPanel = new ControlPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(controlPanel, constraints);

        statusPanel = new BarStatusPanel();
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(statusPanel, constraints);

        counterPanel = new CounterPanel();
        constraints.gridx = 2;
        constraints.gridy = 0;
        this.add(counterPanel, constraints);

        sInputPanel = new StrategyInputPanel();
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(sInputPanel, constraints);

        historyPanel = new HistoryTablePanel();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 3;
        constraints.gridwidth = 4;
        this.add(historyPanel, constraints);
    }

    public void refresh(){
        statusPanel.refresh();
        counterPanel.refresh();
        historyPanel.update();
//        countLabel.setText(Integer.toString(PlayerGroup.getInstance().getCount()));
    }

}
