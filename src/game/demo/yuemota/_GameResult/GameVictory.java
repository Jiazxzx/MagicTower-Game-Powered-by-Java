package game.demo.yuemota._GameResult;

import javax.swing.*;
import java.awt.*;

public class GameVictory extends JFrame {
    public GameVictory() {
        // 初始化
        super("成功!");
        setSize(500, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        g.drawImage(Toolkit.getDefaultToolkit().getImage("image\\界面素材\\游戏成功.png"),0,0,500,300,this);
    }
}
