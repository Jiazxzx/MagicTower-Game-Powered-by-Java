package game.demo.yuemota._Hero;

import game.demo.yuemota._BattleState.BattleState;
import game.demo.yuemota._Monster.*;
import game.demo.yuemota._Scene.*;
import game.demo.yuemota._Prop.*;
import game.demo.yuemota._NPC.*;

import java.awt.*;

public class new_Hero {
    private boolean inBattle=false;// 角色是否处于战斗状态
    private int money=0;// 角色金钱
    private int pos_X;
    private int pos_Y;
    private int[] key={0,1,2};// 三种钥匙 0-红钥匙 1-蓝钥匙 2-黄钥匙
    private BattleState battleState;// 战斗属性
    private Image img=Toolkit.getDefaultToolkit().getImage("image\\Player.png");


    // 当前对话号
    public int talkNum=0;

    public new_Hero(int x,int y,int hp,int atk,int def)
    {
        pos_X=x;
        pos_Y=y;
        battleState=new BattleState(hp,atk,def);
    }

    // 移动决策
    public void move(int dir)
    {
        switch (dir)
        {
            case 0://上
                if(pos_Y-1>=0)
                {
                    int new_Y=pos_Y - 1;
                    attemptMove(pos_X,new_Y);
                }
                break;
            case 1://左
                if(pos_X-1>=0)
                {
                    int new_X=pos_X - 1;
                    attemptMove(new_X,pos_Y);
                }
                break;
            case 2://下
                if(pos_Y+1<Map_Factory.map_height) {
                    int new_Y = pos_Y + 1;
                    attemptMove(pos_X, new_Y);
                }
                break;
            case 3://右
                if(pos_X+1<Map_Factory.map_width) {
                    int new_X = pos_X + 1;
                    attemptMove(new_X, pos_Y);
                }
                break;
        }
    }
    // 确认移动
    private void attemptMove(int new_X,int new_Y)
    {
        // 目标区域类型
        int dest_type=Map_Factory.map[GameScene.grade][new_Y][new_X];
        switch(dest_type)
        {
            // 目的地是地板
            case 9:
            case 0:
                setPos(new_X,new_Y);
                break;
            // 目的地是铜门
            case 2:
                if(key[2]>0)
                {
                    key[2]--;
                    Map_Factory.map[GameScene.grade][new_Y][new_X]=0;
                    setPos(new_X,new_Y);
                }
                break;
            // 目的地是银门
            case 3:
                if(key[1]>0)
                {
                    key[1]--;
                    Map_Factory.map[GameScene.grade][new_Y][new_X]=0;
                    setPos(new_X,new_Y);
                }
                break;
            // 目的地是金门
            case 4:
                if(key[0]>0)
                {
                    key[0]--;
                    Map_Factory.map[GameScene.grade][new_Y][new_X] = 0;
                    setPos(new_X,new_Y);
                }
                break;
            case 5:
                if(GameScene.grade+1<Map_Factory.totalLevel)
                {
                    GameScene.grade++;
                    for(int i=0;i<Map_Factory.map_height;i++)
                    {
                        boolean founded=false;
                        for (int j = 0; j < Map_Factory.map_width; j++)
                            if(Map_Factory.map[GameScene.grade][i][j]==6)
                            {
                                founded=true;
                                setPos(j,i);
                                break;
                            }
                        if(founded)
                            break;
                    }
                }
                break;
            case 6:
                if(GameScene.grade-1>=0)
                {
                    GameScene.grade--;
                    for(int i=0;i<Map_Factory.map_height;i++)
                    {
                        boolean founded=false;
                        for (int j = 0; j < Map_Factory.map_width; j++)
                            if(Map_Factory.map[GameScene.grade][i][j]==5)
                            {
                                founded=true;
                                setPos(j,i);
                                break;
                            }
                        if(founded)
                            break;
                    }
                }
                break;
        }
    }
    // 进行战斗
    public void battleWith(new_Monster enemy)
    {
        // 攻击失败
        if(battleState.ATK<=enemy.getBattleState().DEF)
            battleState.HP=0;
        // 攻击成功
        else
        {
            int damage=0;
            // 判定是否掉血
            if(enemy.getBattleState().ATK>battleState.DEF)
            {
                damage=enemy.getBattleState().HP*(enemy.getBattleState().ATK-battleState.DEF)
                        /(battleState.ATK-enemy.getBattleState().DEF);
                battleState.HP-=damage;
            }
            Map_Factory.monster_list[GameScene.grade].remove(enemy);
            money+=enemy.money;
        }
        if(battleState.HP<=0)
            battleState.isAlive=false;
    }
    // 更新位置
    private void setPos(int new_X,int new_Y)
    {
        pos_X=new_X;
        pos_Y=new_Y;
    }
    // 获得横坐标
    public int getX()
    {
        return pos_X;
    }
    // 获得纵坐标
    public int getY()
    {
        return pos_Y;
    }
    // 返回图像
    public Image getImg()
    {
        return img;
    }
    // 玩家是否死亡
    public boolean ifDead()
    {
        return !battleState.isAlive;
    }
    // 返回战斗状态
    public BattleState getBattleState()
    {
        return battleState;
    }
    // 返回hero金钱
    public int getMoney()
    {
        return money;
    }
    // 添加道具
    public void addProp(Prop prop)
    {
        switch (prop.getRelativeAttribute())
        {
            case 0:// 铜钥匙
                key[0]++;
                break;
            case 1:// 银钥匙
                key[1]++;
                break;
            case 2:// 金钥匙
                key[2]++;
                break;
            case 3:// 攻击
                battleState.ATK+=prop.getRelativeAmount();
                break;
            case 4:// 防御
                battleState.DEF+=prop.getRelativeAmount();
                break;
            case 5:// 血
                battleState.HP+=prop.getRelativeAmount();
                break;
            case 6:// 冰冻岩浆
                for(int i=0;i<Map_Factory.totalLevel;i++)
                    for(int j=0;j<Map_Factory.map_height;j++)
                        for(int k=0;k<Map_Factory.map_width;k++)
                            if(Map_Factory.map[i][j][k]==7)
                                Map_Factory.map[i][j][k]=9;
                break;
        }
        Map_Factory.prop_list[GameScene.grade].remove(prop);
    }

    public void interactWith(NPC npc,int i)
    {
        battleState.HP+=npc.event[i][0];;
        battleState.ATK+=npc.event[i][1];
        battleState.DEF+=npc.event[i][2];
        money+=npc.event[i][3];
        key[0]+=npc.event[i][4];
        key[1]+=npc.event[i][5];
        key[2]+=npc.event[i][6];

        //Map_Factory.NPC_list[GameScene.grade].remove(npc); //NPC消失
    }
    // 返回某种钥匙数量，用于打印
    public int getKey(int i)
    {
        return key[i];
    }
}
