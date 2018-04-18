package game.demo.yuemota._BattleState;

public class BattleState {
    public int HP;
    public int ATK;
    public int DEF;
    public boolean isAlive=true;
    public BattleState(int hp,int atk,int def)
    {
        HP=hp;
        ATK=atk;
        DEF=def;
    }
}
