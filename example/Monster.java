package example;

import example.Line.Position;

import java.util.List;

public class Monster implements Linable {
    public static final int MAX_NUM=64;
    private int r;
    private int g;
    private int b;
    public int id;
    private Position position;
    private static int monsterNum=0;
    private static Monster[] monsters=new Monster[MAX_NUM];
    Monster(int r, int g, int b) {
        if(monsterNum>=MAX_NUM)
            return;
        this.r = r;
        this.g = g;
        this.b = b;
        this.id=monsterNum;
        monsters[monsterNum]=this;
        monsterNum++;
    }

    public static Monster getMonsterByRank(int rank) {
        return monsters[rank];
    }

    public int rank() {
        return this.id;
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }

}