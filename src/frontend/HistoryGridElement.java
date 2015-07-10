package frontend;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/7/10.
 */
public class HistoryGridElement extends JPanel{
    private JPanel block;

    public HistoryGridElement(){
        this.add(getBlock(), null);
        setLayout(new FlowLayout());
    }

    public void update(Integer backgroundType, Integer blockType){
        this.setBackground(getBackground(backgroundType));
        block.setBackground(getBlockGround(blockType));
    }

    private Color getBlockGround(Integer type){
        if (type.equals(0)){
            return Color.white;
        }else{
            return Color.black;
        }
    }

    private Color getBackground(Integer type){
        if (type.equals(0)){
            return Color.green;
        }else{
            return Color.ORANGE;
        }
    }

    private JPanel getBlock(){
        if (block == null){
            block = new JPanel();
        }
        return block;
    }
}
