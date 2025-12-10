package Task_LOLChampion;

import java.util.Random;

public abstract class Champion {
    private String name;
    private int levle;
    private int attackDamage;
    private int defenseDamage;
    private int HP;
    private int MP;
    private int ex;
    private int maxEx;
    Random rand = new Random();
    int mindamage=100;
    int maxmindamage=300;
    int range = maxmindamage - mindamage+1;
    int randomDamage = rand.nextInt(range)+mindamage;

    public Champion(String name,int level,int attackDamage,int defenseDamage,int HP,int MP,int maxEx) {
        this.name = name;
        this.levle = level;
        this.attackDamage=attackDamage;
        this.defenseDamage = defenseDamage;
        this.HP = HP;
        this.MP = MP;
        this.maxEx = maxEx;
    }
    public int getlevel() {
        return levle;
    }
    public void setlevel(int level) {
        this.levle += level;
    }
    public int getrandomDamage(){
        return randomDamage;
    }
    public int getmaxEx(){
        return maxEx;
    }
    public void setmaxEx(int maxEx) {
        this.maxEx = maxEx;
    }
    public int getEx(){
        return ex;
    }
    public void setEx(int ex){
        this.ex = ex;
    }
    public String getName() {
        return name;
    }
    public int getLevle() {
        return levle;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getHP() {
        return this.HP;
    }
    public int getMP() {
        return this.MP;
    }
    public void setMP(int MP) {
        this.MP = MP;
    }
    public int getattackDamage() {
        return this.attackDamage;
    }
    public void setattackDamage(int attackDamage){
        this.attackDamage += attackDamage;
    }
    public void attackTo(Champion target){
        this.HP-=target.getattackDamage();
        System.out.println(target.getName()+"가"+this.name+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+this.HP+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        this.MP-=100;
        System.out.println(this.name+"의 남은 마력 : "+this.MP);
    }
    public abstract void useQ(Champion target);
    public abstract void useW(Champion target);
    public abstract void useE(Champion target);
    public abstract void useR(Champion target);
    public void takeDamage(int damage) {
        System.out.println("------------takeDamage------------");
        int m = this.HP - damage;
        if (m <= 0) {
            System.out.println(this.name + "가 사망 하였습니다.");
            System.out.println("-------------------------------");
            setHP(0);
        } else {
            System.out.println(this.name + "의 남은 체력 :" + this.HP);
            System.out.println("-------------------------------");
            setHP(m);
        }
    }
}
