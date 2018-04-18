package game.demo.yuemota._NPC;

import java.awt.*;
import java.util.ArrayList;

//第一句话是开头，玩家做出选项，是就是第二句，否就是第三句，然后触发事件
public class NPC
{
    public ArrayList<String> dialogs;// 对话列表,每四个元素组储存一句话
    private String name;
    private int pos_X;
    private int pos_Y;
    public static String[] currentDialog={"NPC对话区域,按","Enter进行对话","",""};// 要显示在状态栏的对话
    public int[][]event = new int [4][7];// 4个选项,改变7个属性
    private Image img;

    public NPC(String nm,int x,int y,ArrayList<String> dia,int[][]change)
    {
        name=nm;
        pos_X=x;
        pos_Y=y;
        dialogs=dia;
        event=change;
        img=Toolkit.getDefaultToolkit().getImage("image\\NPC\\"+name+".png");
    }

    //修改currentDialog
    public void setCurrentDialog(int i)
    {
        //currentDialog=dialogs;
        currentDialog[0]=dialogs.get(i);
        currentDialog[1]=dialogs.get(i+1);
        currentDialog[2]=dialogs.get(i+2);
        currentDialog[3]=dialogs.get(i+3);
    }

    //返回对话数组大小
    public int DialogSize()
    {
        return dialogs.size();
    }

    public int getX() {
        return pos_X;
    }

    public int getY() {
        return pos_Y;
    }

    public Image getImg() { return img; }
}