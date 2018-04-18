package game.demo.yuemota._Scene;

import java.util.ArrayList;
import game.demo.yuemota._Monster.*;
import game.demo.yuemota._Monster._instance.Devils;
import game.demo.yuemota._Monster._instance.Monster_common.*;
import game.demo.yuemota._Monster._instance.Monster_elite.Giant;
import game.demo.yuemota._Monster._instance.Monster_elite.Mourner;
import game.demo.yuemota._Monster._instance.Monster_elite.Witcher;
import game.demo.yuemota._Prop.*;
import game.demo.yuemota._Prop._instance._battle.*;
import game.demo.yuemota._Prop._instance._key.Key_bronze;
import game.demo.yuemota._Prop._instance._key.Key_gold;
import game.demo.yuemota._Prop._instance._key.Key_silver;
import game.demo.yuemota._NPC.*;

public class Map_Factory {
    // 关卡数
    public static final int totalLevel=10;
    // 地图瓦片大小
    public static final int tile_width=60;
    public static final int tile_height=60;
    public static final int tile_oblique=(int)Math.sqrt(tile_width*tile_width+tile_height*tile_height);
    // 地图整体大小
    public static final int map_width=10;
    public static final int map_height=10;
    // 地形信息
    //<editor-fold desc="Description">
    public static byte map[][][]={
            {// 1
                    {0,0,0,1,0,2,0,0,0,0},
                    {0,0,0,1,0,1,1,1,1,1},
                    {0,0,0,2,0,0,0,0,0,0},
                    {0,0,0,1,0,1,1,1,1,0},
                    {1,1,1,1,0,1,0,0,1,0},
                    {0,0,0,1,0,1,0,0,1,0},
                    {0,0,0,2,0,1,0,0,1,0},
                    {0,0,0,1,0,1,0,0,1,0},
                    {1,1,1,1,0,1,0,0,1,0},
                    {0,0,0,0,0,0,0,0,1,5}

            },
            {// 2
                    {6,1,0,0,0,1,0,0,0,0},
                    {0,1,0,0,0,1,0,0,0,0},
                    {0,1,0,0,0,1,0,0,0,0},
                    {0,1,1,0,1,1,1,1,0,1},
                    {0,3,0,0,0,0,0,0,0,0},
                    {0,1,1,0,1,1,1,1,0,1},
                    {0,1,0,0,0,1,0,0,0,0},
                    {0,1,0,0,0,1,0,0,0,0},
                    {0,1,0,0,0,1,0,0,0,0},
                    {5,1,0,0,0,1,0,0,0,0}

            },
            {// 3
                    {0,0,1,0,1,0,0,1,0,0},
                    {0,0,1,0,3,0,0,2,0,0},
                    {0,0,2,0,1,0,0,1,0,0},
                    {0,0,1,0,1,1,1,1,1,1},
                    {1,1,1,0,0,0,0,0,0,0},
                    {0,0,1,0,1,1,2,1,1,0},
                    {0,0,2,0,1,0,0,0,1,0},
                    {0,0,1,0,1,0,0,0,1,0},
                    {1,1,1,0,1,0,0,0,1,0},
                    {6,0,0,0,1,0,0,0,1,5}

            },
            {// 4
                    {0,0,0,1,0,0,0,0,0,0},
                    {0,0,0,1,0,1,1,1,1,0},
                    {0,0,0,2,0,1,0,0,0,0},
                    {0,0,0,1,0,1,0,1,1,1},
                    {1,1,1,1,0,1,0,1,0,0},
                    {0,0,0,1,0,1,0,2,0,0},
                    {0,0,0,1,0,1,0,1,0,0},
                    {0,0,0,1,0,1,0,1,0,0},
                    {1,3,1,1,0,1,0,1,1,1},
                    {6,0,0,0,0,1,0,0,0,5}

            },
            {// 5
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,1,1,1,1,1,1,1,1,0},
                    {0,1,0,0,0,0,0,0,1,0},
                    {0,1,0,1,1,1,1,0,1,0},
                    {0,1,0,2,0,0,1,0,1,0},
                    {0,1,0,2,0,0,1,0,1,0},
                    {0,1,1,1,1,0,1,0,1,0},
                    {0,0,0,0,0,0,1,0,1,0},
                    {1,1,1,1,1,1,1,0,1,0},
                    {6,0,2,0,0,0,0,0,1,5}

            },
            {// 6
                    {0,0,0,0,0,3,0,0,0,0},
                    {0,0,0,0,0,1,0,1,1,2},
                    {1,1,1,1,1,1,0,1,0,0},
                    {0,0,0,0,0,1,0,1,0,0},
                    {2,1,1,1,0,1,0,1,0,0},
                    {0,0,0,1,0,1,0,1,5,0},
                    {0,0,0,1,0,1,0,1,1,1},
                    {0,0,0,1,0,1,0,0,0,0},
                    {1,3,1,1,0,1,1,1,1,0},
                    {6,0,0,0,0,0,0,0,0,0}

            },
            {// 7
                    {7,7,7,7,0,7,7,7,7,7},
                    {7,7,7,7,7,7,7,7,7,7},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {1,1,1,1,2,1,1,1,1,1},
                    {0,0,0,2,0,2,0,0,0,0},
                    {0,0,0,1,0,1,0,0,0,0},
                    {0,0,0,1,0,1,0,0,0,0},
                    {1,1,1,1,0,1,1,1,1,1},
                    {6,0,0,0,0,0,0,0,0,5}
            },
            {// 8
                    {0,0,0,1,0,0,7,7,0,0},
                    {1,0,1,1,0,0,7,7,0,0},
                    {0,0,0,1,7,7,7,7,7,7},
                    {0,0,0,1,7,7,7,7,7,7},
                    {1,0,1,1,0,0,7,7,0,0},
                    {0,0,0,1,0,0,7,7,0,0},
                    {0,0,0,1,0,0,7,7,0,0},
                    {0,0,0,1,7,7,7,7,7,7},
                    {1,3,1,1,7,7,7,7,7,7},
                    {6,0,0,0,0,0,0,0,0,5}

            },
            {// 9
                    {8,8,8,8,0,8,8,8,8,8},
                    {8,8,8,8,0,8,8,8,8,8},
                    {8,8,8,8,0,8,8,8,8,8},
                    {8,8,8,8,0,8,8,8,8,8},
                    {8,8,8,8,4,8,8,8,8,8},
                    {0,0,0,8,0,8,0,0,0,0},
                    {0,0,0,2,0,2,0,0,0,0},
                    {0,0,0,8,0,8,0,0,0,0},
                    {8,8,8,8,0,8,8,8,8,8},
                    {6,0,0,0,0,0,0,0,0,5}

            },
            {// 10
                    {8,8,8,8,8,8,8,8,8,8},
                    {8,8,8,8,8,8,8,8,8,8},
                    {8,8,8,8,8,8,8,8,8,8},
                    {8,8,8,8,8,8,8,8,8,8},
                    {8,8,8,0,0,0,8,8,8,8},
                    {8,8,8,0,0,0,8,8,8,8},
                    {8,8,8,0,6,0,8,8,8,8},
                    {8,8,8,8,8,8,8,8,8,8},
                    {8,8,8,8,8,8,8,8,8,8},
                    {8,8,8,8,8,8,8,8,8,8}
            }
    };
    //</editor-fold>
    // 怪物列表
    public static ArrayList<new_Monster>[] monster_list=new ArrayList[totalLevel];
    // 道具列表
    public static ArrayList<Prop>[] prop_list=new ArrayList[totalLevel];
    // NPC列表
    public static ArrayList<NPC>[] NPC_list=new ArrayList[totalLevel];

    // 初始化地图
    public static void initMap()
    {
        // 实例化怪物列表
        //<editor-fold desc="Description">
        monster_list[0]=new ArrayList<new_Monster>()
        {{
            add(new Slime(6,8));
            add(new Slime(7,8));
            add(new Slime(6,0));
            add(new Monster_one(2,6));
            add(new Monster_one(2,2));
        }};
        monster_list[1]=new ArrayList<new_Monster>()
        {{
            add(new Monster_one(6,1));
            add(new Monster_one(7,1));
            add(new Monster_one(8,1));
            add(new Monster_one(9,1));
            add(new Monster_one(6,8));
            add(new Monster_one(7,8));
            add(new Monster_one(8,8));
            add(new Monster_one(9,8));
            add(new Giant(2,4));
            add(new Monster_four(6,4));
        }};
        monster_list[2]=new ArrayList<new_Monster>()
        {{
            add(new Slime(5,1));
            add(new Slime(1,6));
            add(new Slime(5,7));
            add(new Slime(6,7));
            add(new Slime(7,7));
            add(new Monster_one(1,2));
            add(new Monster_one(6,6));
        }};
        monster_list[3]=new ArrayList<new_Monster>()
        {{
            add(new Monster_two(2,2));
            add(new Monster_one(8,5));
        }};
        monster_list[4]=new ArrayList<new_Monster>()
        {{
            add(new Monster_one(0,0));
            add(new Monster_one(0,7));
            add(new Slime(3,9));
            add(new Slime(7,9));
            add(new Monster_one(7,2));
            add(new Monster_one(2,2));
            add(new Monster_two(9,0));
            add(new Monster_two(9,6));
        }};
        monster_list[5]=new ArrayList<new_Monster>()
        {{
            add(new Slime(4,8));
            add(new Slime(4,6));
            add(new Monster_one(4,4));
            add(new Monster_one(3,3));
            add(new Monster_two(1,3));
            add(new Monster_two(9,2));
        }};
        monster_list[6]=new ArrayList<new_Monster>()
        {{
            add(new Monster_three(2,5));
            add(new Monster_three(6,5));
            add(new Witcher(4,3));
        }};
        monster_list[7]=new ArrayList<new_Monster>()
        {{
            add(new Monster_four(1,2));
            add(new Monster_three(1,5));
        }};
        monster_list[8]=new ArrayList<new_Monster>()
        {{
            add(new Monster_four(2,6));
            add(new Monster_four(6,6));
            add(new Mourner(4,3));
        }};
        monster_list[9]=new ArrayList<new_Monster>()
        {{
            add(new Devils(4,4));
        }};
        //</editor-fold>
        // 实例化道具列表
        //<editor-fold desc="Description">
        prop_list[0]=new ArrayList<Prop>()
        {{
            add(new Sapphire(0,1));
            add(new Ruby(0,5));
            add(new Pots(0,3));
            add(new Pots(0,7));
            add(new Key_gold(1,1));
            add(new Key_gold(1,5));
            add(new Key_gold(1,7));
            add(new Key_gold(8,0));
            add(new Key_gold(1,3));
            add(new Key_gold(6,4));
            add(new Key_gold(6,5));
            add(new Key_gold(7,5));
            add(new Key_silver(7,4));
        }};
        prop_list[1]=new ArrayList<Prop>()
        {{
            add(new Ruby(2,0));
            add(new Ruby(3,0));
            add(new Ruby(4,0));
            add(new Pots(3,1));
            add(new Pots(3,7));
            add(new Key_gold(2,8));
            add(new Key_gold(3,8));
            add(new Key_gold(4,8));
            add(new Sapphire(2,9));
            add(new Sapphire(3,9));
            add(new Sapphire(4,9));
        }};
        prop_list[2]=new ArrayList<Prop>()
        {{
            add(new Key_gold(0,0));
            add(new Key_gold(0,1));
            add(new Key_gold(0,2));
            add(new Key_silver(0,3));
            add(new Ruby(0,5));
            add(new Key_gold(0,7));
            add(new Sapphire(5,9));
            add(new Key_gold(7,9));
        }};
        prop_list[3]=new ArrayList<Prop>()
        {{
            add(new Key_gold(0,0));
            add(new Key_silver(0,2));
            add(new Blade(0,5));
            add(new Key_gold(9,4));
            add(new Pots(9,5));
        }};
        prop_list[4]=new ArrayList<Prop>()
        {{
            add(new Pots(5,4));
            add(new Pots(5,5));
            add(new Key_gold(4,9));
            add(new Sapphire(5,0));
            add(new Sapphire(4,5));
            add(new Ruby(4,4));
            add(new Ruby(7,5));
        }};
        prop_list[5]=new ArrayList<Prop>()
        {{
            add(new Shield(1,5));
            add(new Key_gold(2,0));
            add(new Key_gold(2,1));
            add(new Pots(1,0));
            add(new Pots(1,1));
            add(new Ruby(0,0));
            add(new Sapphire(0,1));
            add(new Pots(8,3));
        }};
        prop_list[6]=new ArrayList<Prop>()
        {{
            add(new Key_gold(0,5));
            add(new Ruby(0,6));
            add(new Sapphire(0,7));
            add(new Key_gold(9,5));
            add(new Ruby(9,6));
            add(new Sapphire(9,7));
            add(new Ruby(0,2));
            add(new Ruby(1,2));
            add(new Sapphire(0,3));
            add(new Sapphire(1,3));
            add(new Pots(8,2));
            add(new Pots(8,3));
            add(new Pots(9,2));
            add(new Pots(9,3));
        }};
        prop_list[7]=new ArrayList<Prop>()
        {{
            add(new Icesword(1,0));
            add(new Ruby(4,4));
            add(new Ruby(4,5));
            add(new Ruby(5,4));
            add(new Ruby(5,5));
            add(new Sapphire(8,4));
            add(new Sapphire(8,5));
            add(new Sapphire(9,4));
            add(new Sapphire(9,5));
            add(new Pots(0,7));
            add(new Pots(2,7));
            add(new Pots(4,6));
            add(new Pots(5,6));
            add(new Pots(8,6));
            add(new Pots(9,6));
            add(new Key_bronze(9,0));
        }};
        prop_list[8]=new ArrayList<Prop>()
        {{
            add(new Ruby(0,5));
            add(new Sapphire(0,6));
            add(new Pots(0,7));
            add(new Ruby(9,5));
            add(new Sapphire(9,6));
            add(new Pots(9,7));
        }};
        prop_list[9]=new ArrayList<Prop>()
        {{

        }};
        //</editor-fold>
        // 实例化NPC列表
        NPC_list[0]=new ArrayList<NPC>()
        {{

        }};
        NPC_list[1]=new ArrayList<NPC>()
        {{
            add(new NPC("触发事件NPC",8,9,
                    new ArrayList<String>()
                    {{
                        add("唉,好心人啊!");
                        add("我在时空错乱");
                        add("中迷失了方向");
                        add("你能帮助我吗?");

                        add("1.接受");
                        add("2.拒接");
                        add("");
                        add("");
                    }},
                    new int [][]{{0,5,5,0,0,0,0}, {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}));
        }};
        NPC_list[2]=new ArrayList<NPC>()
        {{
            add(new NPC("商人",9,1,
                    new ArrayList<String>()
                    {{
                        add("我是穿越时空,");
                        add("的商人");
                        add("来一场公平的");
                        add("PY吧!");

                        add("如果你付给我");
                        add("10个金币");
                        add("");
                        add("");

                        add("我可以提升你");
                        add("的能力呦~");
                        add("");
                        add("");

                        add("1.加血50点");
                        add("2.加攻击2点");
                        add("3.加防御2点");
                        add("");
                    }},
                    new int [][]{{50,0,0,-10,0,0,0}, {0,2,0,-10,0,0,0},{0,0,2,-10,0,0,0},{0,0,0,0,0,0,0}}));
        }};
        NPC_list[3]=new ArrayList<NPC>()
        {{

        }};
        NPC_list[4]=new ArrayList<NPC>()
        {{

        }};
        NPC_list[5]=new ArrayList<NPC>()
        {{

        }};
        NPC_list[6]=new ArrayList<NPC>()
        {{

        }};
        NPC_list[7]=new ArrayList<NPC>()
        {{
            add(new NPC("触发事件NPC",4,0,
                    new ArrayList<String>()
                    {{
                        add("我是随意穿梭");
                        add("时空,改变时间");
                        add("的永恒之长者");
                        add("");

                        add("我会利用时间");
                        add("来帮助你");
                        add("所有精英怪!");
                        add("");

                        add("嗯");
                        add("就是这样");
                        add("......");
                        add("");

                        add("1.答应");
                        add("2.拒绝");
                        add("");
                        add("");
                    }},
                    new int [][]{{0,0,0,0,-1,0,0}, {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}));
        }};
        NPC_list[8]=new ArrayList<NPC>()
        {{

        }};
        NPC_list[9]=new ArrayList<NPC>()
        {{

        }};
    }
    // 横坐标转换
    public static int transX(int pos_X)
    {
        return pos_X*tile_width;
    }
    // 纵坐标转换
    public static int transY(int pos_Y)
    {
        return pos_Y*tile_height+30;
    }
}
