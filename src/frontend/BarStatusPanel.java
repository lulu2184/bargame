package frontend;



import backend.Controller;
import backend.Game;

import javax.swing.border.LineBorder;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by LU on 15/6/24.
 */
public class BarStatusPanel extends JPanel{
    private JLabel statusLabel;

    public BarStatusPanel() {
        super();
        this.setSize(100, 100);
//        this.setBorder(new LineBorder(Color.gray, 3, true));
        this.setBorder(BorderFactory.createTitledBorder("bar status"));
        this.setLayout(new FlowLayout());
        this.add(new JLabel("bar status: "));
        this.add(this.getStatusLabel(), null);
    }

    private String barStatus(){
        Integer status = Controller.getController().getBarStatus();
        if (status.equals(Game.FREE)) return "free";
        else return "busy";
    }

    private JLabel getStatusLabel(){
        if (statusLabel == null){
            statusLabel = new JLabel(barStatus());
        }
        return statusLabel;
    }

    public void refresh(){
        statusLabel.setText(barStatus());
    }
}
