package game.demo.yuemota._GameResult;

import game.demo.yuemota._Scene.Map_Factory;

import javax.swing.*;
import java.awt.*;

import java.awt.*;

public class GameDead extends JFrame {
    public GameDead() {
        // 初始化
        super("主人公死亡!失败!");
        setSize(500, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        g.drawImage(Toolkit.getDefaultToolkit().getImage("image\\界面素材\\游戏失败死亡.jpg"),0,0,500,300,this);
    }
}
