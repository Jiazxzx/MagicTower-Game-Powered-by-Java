package game.demo.yuemota._Monster;

import java.awt.*;

import game.demo.yuemota._BattleState.BattleState;
import game.demo.yuemota._Hero.new_Hero;
import game.demo.yuemota._Scene.GameScene;
import game.demo.yuemota._Scene.Map_Factory;

public class new_Monster
{
    public String name;
    public int money;
    private int pos_X;
    private int pos_Y;
    private BattleState battleState;
    private Image img;
    // 构造
    public new_Monster(String nm,int x,int y,int mny,int hp,int atk,int def)
    {
        name=nm;
        pos_X=x;
        pos_Y=y;
        money=mny;
        battleState=new BattleState(hp,atk,def);
        img=Toolkit.getDefaultToolkit().getImage("image\\Monster\\"+name+".png");
    }
    // 尝试跟随
    public void tryToFollow(new_Hero target)
    {
        int new_X=pos_X;
        int new_Y=pos_Y;
        if(pos_X+1==target.getX())
            new_X+=1;
        else if(pos_X-1==target.getX())
            new_X-=1;
        else if(pos_Y+1==target.getY())
            new_Y+=1;
        else if(pos_Y-1==target.getY())
            new_Y-=1;

        if(new_X>=0&&new_X<Map_Factory.map_width
                &&new_Y>=30&&new_Y<Map_Factory.map_height)
            // 目的位置为玩家所在位置，开始战斗
            if(new_X==target.getX()&&new_Y==target.getY())
                target.battleWith(this);
            // 否则进行移动
            else if(Map_Factory.map[GameScene.grade][new_Y][new_X]==0)
            {
                pos_X=new_X;
                pos_Y=new_Y;
            }
    }

    public BattleState getBattleState()
    {
        return this.battleState;
    }

    public int getX() {
        return pos_X;
    }

    public int getY() {
        return pos_Y;
    }

    public Image getImg()
    {
        return img;
    }
}
