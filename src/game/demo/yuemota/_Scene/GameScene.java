package game.demo.yuemota._Scene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import game.demo.yuemota._Hero.new_Hero;
import game.demo.yuemota._NPC.*;
import game.demo.yuemota._GameResult.*;
import game.demo.yuemota._Monster.*;
import java.util.ArrayList;

public class GameScene extends JFrame implements KeyListener{

    private new_Hero new_player=new new_Hero(0,9,10000,1000,100);// 主角
    private Image pic[]=null;// 图片资源
    public static int grade=0;// 当前关卡
    private int mons_step=0;// 怪物步数

    //双缓冲机制
    private Image iBuffer;
    private Graphics gBuffer;

    private static boolean isInited = false;

    // 读取图片资源
    public void getPic(){
        pic=new Image[10];
        for(int i=0;i<10;i++)
            pic[i]=Toolkit.getDefaultToolkit().getImage("image\\Tile\\pic"+i+".png");
    }

    public void paint(Graphics g)
    {
        if(!isInited){
            return;
        }

        if(iBuffer==null)
        {
            iBuffer=createImage(this.getSize().width,this.getSize().height);
            gBuffer=iBuffer.getGraphics();
        }
        
        // 打印地图瓦片
        for(int i=0;i<Map_Factory.map_height;i++)
            for (int j = 0; j < Map_Factory.map_width; j++)
                  gBuffer.drawImage(pic[Map_Factory.map[grade][i][j]], Map_Factory.transX(j), Map_Factory.transY(i)
                          , Map_Factory.tile_width, Map_Factory.tile_height, this);

        if(!new_player.ifDead()) {
            gBuffer.drawImage(new_player.getImg(), Map_Factory.transX(new_player.getX()), Map_Factory.transY(new_player.getY()),
                    Map_Factory.tile_width, Map_Factory.tile_height, this);
        }
        // 打印怪物
        for(int i=0;i<Map_Factory.monster_list[grade].size();i++)
            gBuffer.drawImage(Map_Factory.monster_list[grade].get(i).getImg(),
                    Map_Factory.transX(Map_Factory.monster_list[grade].get(i).getX()),
                    Map_Factory.transY(Map_Factory.monster_list[grade].get(i).getY()),
                    Map_Factory.tile_width,
                    Map_Factory.tile_height,
                    this);
        // 打印道具
        for(int i=0;i<Map_Factory.prop_list[grade].size();i++)
            gBuffer.drawImage(Map_Factory.prop_list[grade].get(i).getImg(),
                    Map_Factory.transX(Map_Factory.prop_list[grade].get(i).getX()),
                    Map_Factory.transY(Map_Factory.prop_list[grade].get(i).getY()),
                    Map_Factory.tile_width,
                    Map_Factory.tile_height,
                    this);

        // 打印NPC
        for(int i=0;i<Map_Factory.NPC_list[grade].size();i++)
            gBuffer.drawImage(Map_Factory.NPC_list[grade].get(i).getImg(),
                    Map_Factory.transX(Map_Factory.NPC_list[grade].get(i).getX()),
                    Map_Factory.transY(Map_Factory.NPC_list[grade].get(i).getY()),
                    Map_Factory.tile_width,
                    Map_Factory.tile_height,
                    this);

        //绘制状态栏
        gBuffer.drawImage(Toolkit.getDefaultToolkit().getImage("image\\界面素材\\背景.jpg"),600,30,180,630,this);
        gBuffer.drawImage(Toolkit.getDefaultToolkit().getImage("image\\界面素材\\状态栏.png"),600,30,180,630,this);

        //基准位置
        int basePosX=630;
        int basePosY=63;
        gBuffer.setColor(Color.BLACK);
        gBuffer.setFont(new Font("黑体",Font.BOLD,15));

        //楼层
        gBuffer.drawString("现在在第",basePosX,basePosY);
        gBuffer.drawString(String.valueOf(grade+1),basePosX+73,basePosY);
        gBuffer.drawString("层",basePosX+90,basePosY);

        //主人公生命攻击防御
        gBuffer.drawString(String.valueOf(new_player.getBattleState().HP),basePosX+40,basePosY+35);//生命
        gBuffer.drawString(String.valueOf(new_player.getBattleState().ATK),basePosX+40,basePosY+61);//攻击
        gBuffer.drawString(String.valueOf(new_player.getBattleState().DEF),basePosX+40,basePosY+88);//防御
        gBuffer.drawString(String.valueOf(new_player.getMoney()),basePosX+40,basePosY+113);//金钱

        //主人公钥匙
        gBuffer.drawString(String.valueOf(new_player.getKey(2)),basePosX+15,basePosY+140);//金钥匙
        gBuffer.drawString(String.valueOf(new_player.getKey(1)),basePosX+70,basePosY+140);//银钥匙
        gBuffer.drawString(String.valueOf(new_player.getKey(0)),basePosX+125,basePosY+140);//铜钥匙


        //怪物属性

        //1 史莱姆
        gBuffer.drawString("90",basePosX+35,basePosY+200);//生命
        gBuffer.drawString(" 15",basePosX+60,basePosY+200);//攻击
        gBuffer.drawString(" 1",basePosX+85,basePosY+200);//防御
        gBuffer.drawString(" 1",basePosX+110,basePosY+200);//掉落金钱

        //2 骷髅
        gBuffer.drawString("105",basePosX+35,basePosY+223);//生命
        gBuffer.drawString(" 20",basePosX+60,basePosY+223);//攻击
        gBuffer.drawString(" 3",basePosX+85,basePosY+223);//防御
        gBuffer.drawString(" 1",basePosX+110,basePosY+223);//掉落金钱

        //3 兽人
        gBuffer.drawString("120",basePosX+35,basePosY+246);//生命
        gBuffer.drawString(" 30",basePosX+60,basePosY+246);//攻击
        gBuffer.drawString(" 8",basePosX+85,basePosY+246);//防御
        gBuffer.drawString(" 1",basePosX+110,basePosY+246);//掉落金钱

        //4 时间信徒
        gBuffer.drawString("120",basePosX+35,basePosY+269);//生命
        gBuffer.drawString(" 30",basePosX+60,basePosY+269);//攻击
        gBuffer.drawString(" 15",basePosX+85,basePosY+269);//防御
        gBuffer.drawString(" 1",basePosX+110,basePosY+269);//掉落金钱

        //5 大表哥
        gBuffer.drawString("120",basePosX+35,basePosY+292);//生命
        gBuffer.drawString(" 40",basePosX+60,basePosY+292);//攻击
        gBuffer.drawString(" 15",basePosX+85,basePosY+292);//防御
        gBuffer.drawString(" 1",basePosX+110,basePosY+292);//掉落金钱

        //6 沉睡的巨人
        gBuffer.drawString("400",basePosX+35,basePosY+315);//生命
        gBuffer.drawString(" 20",basePosX+60,basePosY+315);//攻击
        gBuffer.drawString(" 30",basePosX+85,basePosY+315);//防御
        gBuffer.drawString(" 10",basePosX+110,basePosY+315);//掉落金钱

        //7 巫师
        gBuffer.drawString("150",basePosX+35,basePosY+338);//生命
        gBuffer.drawString(" 40",basePosX+60,basePosY+338);//攻击
        gBuffer.drawString(" 20",basePosX+85,basePosY+338);//防御
        gBuffer.drawString(" 20",basePosX+110,basePosY+338);//掉落金钱

        //8 送葬者
        gBuffer.drawString("160",basePosX+35,basePosY+360);//生命
        gBuffer.drawString(" 45",basePosX+60,basePosY+360);//攻击
        gBuffer.drawString(" 30",basePosX+85,basePosY+360);//防御
        gBuffer.drawString(" 30",basePosX+110,basePosY+360);//掉落金钱

        //9 BOSS
        gBuffer.drawString("??",basePosX+35,basePosY+382);//生命
        gBuffer.drawString("??",basePosX+60,basePosY+382);//攻击
        gBuffer.drawString("??",basePosX+85,basePosY+382);//防御
        gBuffer.drawString("??",basePosX+110,basePosY+382);//掉落金钱

        //NPC区域
        Font drawFont = new Font("黑体",Font.BOLD,20);
        gBuffer.drawString(NPC.currentDialog[0],basePosX,basePosY+420);//NPC对话
        gBuffer.drawString(NPC.currentDialog[1],basePosX,basePosY+450);//NPC对话
        gBuffer.drawString(NPC.currentDialog[2],basePosX,basePosY+480);//NPC对话
        gBuffer.drawString(NPC.currentDialog[3],basePosX,basePosY+510);//NPC对话
        
//        gBuffer.setColor(Color.RED);
//        gBuffer.setFont(new Font("楷体_2312",Font.BOLD,30));
//        gBuffer.drawString("现在在第",150,140);
//        gBuffer.drawString(grade+"",310,140);
//        gBuffer.drawString("层",360,140);

        g.drawImage(iBuffer,0,0,this);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    // 总场景初始化
    public GameScene() {
        // 初始化
        super("月莫塔");
        setSize(Map_Factory.map_width*Map_Factory.tile_width+180,
                Map_Factory.map_height*Map_Factory.tile_height+30);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getPic();
        this.setFocusable(true);
        this.addKeyListener(this);
        Map_Factory.initMap();
        isInited = true;
    }
    // 重载键盘监听
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_W)
            new_player.move(0);
        if(e.getKeyCode()==KeyEvent.VK_A)
            new_player.move(1);
        if(e.getKeyCode()==KeyEvent.VK_S)
            new_player.move(2);
        if(e.getKeyCode()==KeyEvent.VK_D)
            new_player.move(3);
        // 遍历本层怪物列表
        for(int i=0;i<Map_Factory.monster_list[grade].size();i++)
            if(new_player.getX()==Map_Factory.monster_list[grade].get(i).getX()&&
                    new_player.getY()==Map_Factory.monster_list[grade].get(i).getY())
                new_player.battleWith(Map_Factory.monster_list[grade].get(i));
        // 遍历本层道具列表
        for(int i=0;i<Map_Factory.prop_list[grade].size();i++)
            if(new_player.getX()==Map_Factory.prop_list[grade].get(i).getX()&&
                    new_player.getY()==Map_Factory.prop_list[grade].get(i).getY())
                new_player.addProp(Map_Factory.prop_list[grade].get(i));
        // 遍历NPC列表
        //<editor-fold desc="Description">
        int stepLength=4;//每四个元素组储存一句话,跨度为4
        for(int i=0;i<Map_Factory.NPC_list[grade].size();i++)
            if(new_player.getX()==Map_Factory.NPC_list[grade].get(i).getX()&&
                    new_player.getY()==Map_Factory.NPC_list[grade].get(i).getY())
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    if(new_player.talkNum<Map_Factory.NPC_list[grade].get(i).DialogSize())
                    {
                        Map_Factory.NPC_list[grade].get(i).setCurrentDialog(new_player.talkNum);
                        new_player.talkNum+=stepLength;
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_1)
                {
                    if(new_player.talkNum==Map_Factory.NPC_list[grade].get(i).DialogSize())
                    {
                        new_player.interactWith(Map_Factory.NPC_list[grade].get(i),0);
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_2)
                {
                    if(new_player.talkNum==Map_Factory.NPC_list[grade].get(i).DialogSize())
                    {
                        new_player.interactWith(Map_Factory.NPC_list[grade].get(i),1);
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_3)
                {
                    if(new_player.talkNum==Map_Factory.NPC_list[grade].get(i).DialogSize())
                    {
                        new_player.interactWith(Map_Factory.NPC_list[grade].get(i),2);
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_4)
                {
                    if(new_player.talkNum==Map_Factory.NPC_list[grade].get(i).DialogSize())
                    {
                        new_player.interactWith(Map_Factory.NPC_list[grade].get(i),3);
                    }
                }
            }
            else
            {
                NPC.currentDialog=new String[]{"NPC对话区域,按","Enter进行对话","",""};
                new_player.talkNum=0;
            }
        //</editor-fold>
        //判定是否游戏失败
        if(!new_player.ifDead()&& new_player.getMoney()>=0) {
            repaint();
        }
        else if(new_player.getMoney()<0)
        {
            new GameNoMoney();
        }
        else
        {
            new GameDead();
        }
        //判定是否游戏成功
        ArrayList<new_Monster> lastLevel=Map_Factory.monster_list[Map_Factory.totalLevel-1];
        if(lastLevel.size()==0)
        {
            new GameVictory();
        }

    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[]args)
    {
        new GameScene();
    }
}
