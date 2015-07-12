package frontend;

import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/7/12.
 */
public class CapitalChartPanel extends JPanel{
    private ChartPanel panel;
    private LinechartCt chart;

    public CapitalChartPanel(String title){
        setLayout(new FlowLayout());
        chart = new LinechartCt(title);
        panel = chart.refresh();
        this.add(panel, null);
        this.setSize(600, 600);
        this.setBorder(BorderFactory.createTitledBorder(title));
    }

    public void refresh(){
        ChartPanel newOne = chart.refresh();
        this.remove(panel);
        panel = newOne;
        this.add(panel, null);
    }
}
