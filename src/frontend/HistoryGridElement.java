package frontend;

import backend.Game;
import backend.Player;
import backend.Strategy;

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
        if ((type.equals(Strategy.STAY))){
            return Color.white;
        }else{
            return Color.black;
        }
    }

    private Color getBackground(Integer type){
        if (type.equals(Game.FREE)){
            return new Color(14, 65, 156);
        }else{
            return new Color(204, 26, 26);
        }
    }

    private JPanel getBlock(){
        if (block == null){
            block = new JPanel();
        }
        return block;
    }
}
