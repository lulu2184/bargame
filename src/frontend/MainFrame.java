package frontend;


import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/6/24.
 */
public class MainFrame extends JFrame{
    private ControlPanel controlPanel;
    private BarStatusPanel statusPanel;
    private CounterPanel counterPanel;
    private StrategyInputPanel sInputPanel;
    private HistoryTablePanel historyPanel;
    private StrategyFrame strategyframe;
    private JPanel emptyPanel;
    private BarStatusChartPanel barChartPanel;
    private CapitalChartPanel capitalChartPanel;

    public MainFrame(){
        super();

        ConfigFrame config = new ConfigFrame(this);
        setVisible(false); //初始默认不可见
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("bar game simulator");
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
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(3,3,3,3);
        this.add(controlPanel, constraints);

        statusPanel = new BarStatusPanel();
        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(3,3,3,3);
        this.add(statusPanel, constraints);

        counterPanel = new CounterPanel();
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(3,3,3,3);
        this.add(counterPanel, constraints);

        sInputPanel = new StrategyInputPanel(this);
        constraints = new GridBagConstraints();
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(3,3,3,3);
        this.add(sInputPanel, constraints);

        historyPanel = new HistoryTablePanel();
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridheight = 3;
        constraints.gridwidth = 0;
        constraints.insets = new Insets(3,3,3,3);
        this.add(historyPanel, constraints);

        barChartPanel = new BarStatusChartPanel("headcount at bar");
        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 7;
        constraints.gridwidth = 0;
        constraints.gridheight = 3;
        constraints.weighty = 1;
        this.add(barChartPanel, constraints);

        capitalChartPanel = new CapitalChartPanel("agent capital");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 4;
        constraints.gridheight = 3;
        this.add(capitalChartPanel, constraints);

        emptyPanel = new JPanel();
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 0;
        constraints.gridheight = 1;
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(3,3,3,3);
        this.add(emptyPanel, constraints);

    }

    public void setStrategyFrame(StrategyFrame frame){
        if (strategyframe != null){
            strategyframe.dispose();
        }
        strategyframe = frame;
        strategyframe.setVisible(true);
    }

    public void refresh(){
        statusPanel.refresh();
        counterPanel.refresh();
        historyPanel.update();
        capitalChartPanel.refresh();
        barChartPanel.refresh();
    }

}
