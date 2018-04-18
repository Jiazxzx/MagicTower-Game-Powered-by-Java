package game.demo.yuemota._Prop;

import java.awt.*;

public class Prop {
    private String name;// 道具名称
    private int relativeAttribute;// 相关属性
    private int relativeAmount;// 相关数量
    private int pos_X;
    private int pos_Y;
    private Image img;
    //构造
    public Prop(String name,int x,int y,int relativeAttribute,int relativeAmount){
        this.name=name;
        this.relativeAttribute=relativeAttribute;
        this.relativeAmount=relativeAmount;
        img=Toolkit.getDefaultToolkit().getImage("image\\Prop\\"+this.name+".png");
        pos_X=x;
        pos_Y=y;
    }

    //获得道具信息
    public Image getImg(){return img;}
    public int getRelativeAttribute(){return relativeAttribute;}
    public int getRelativeAmount(){return relativeAmount;}
    public int getX()
    {
        return pos_X;
    }
    public int getY()
    {
        return pos_Y;
    }
}
