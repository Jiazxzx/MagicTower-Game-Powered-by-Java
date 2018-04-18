package game.demo.yuemota._GameResult;

import javax.swing.*;
import java.awt.*;

public class GameNoMoney extends JFrame {
    public GameNoMoney() {
        // 初始化
        super("主人公死亡!没有钱剩余!");
        setSize(500, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        g.drawImage(Toolkit.getDefaultToolkit().getImage("image\\界面素材\\游戏失败没钱.jpg"),0,0,500,300,this);
    }
}