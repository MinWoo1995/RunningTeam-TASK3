package Task_LOLChampion;

import java.util.ArrayList;
import java.util.List;
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
    private int mindamage=100;
    private int maxmindamage=300;
    private int randomDamage;
    private int range = maxmindamage - mindamage+1;
    private int resurrectCount = 0;
    private int resurrectCount2 = 0;
    private int maxresurrectCount = 0;
    private int maxresurrectCount2 = 0;

    final double CRITICAL_CHANCE = 0.5;//50% 확률
    Random random = new Random();



    public Champion(String name,int level,int attackDamage,int defenseDamage,int MP,int maxEx) {
        this.name = name;
        this.levle = level;
        this.attackDamage=GameConstants.getAttackDamage();//private static final 상수이기 때문에 게터 메서드로 참조
        this.defenseDamage = GameConstants.getDefenseDamage();//private static final 상수이기 때문에 게터 메서드로 참조
        this.HP = GameConstants.HP;//static final으로 상수를 가져와서 초기화 진행
        this.MP = MP;
        this.maxEx = maxEx;
    }
    public int criticalDamage(){
        double probabilityCheck = random.nextDouble();
        if (probabilityCheck < CRITICAL_CHANCE) {
            randomDamage = rand.nextInt(range)+mindamage;
        }
        return this.randomDamage;
    }


    public void setresurrectCount(int resurrectCount){
        this.resurrectCount = resurrectCount;
    }
    public int getresurrectCount(){
        return this.resurrectCount;
    }


    public void setmaxresurrectCount(){
        this.maxresurrectCount = GameConstants.getmaxresurrectCount();
    }
    public int getmaxresurrectCount(){
        return this.maxresurrectCount;
    }

    public void setmaxresurrectCount2(){
        this.maxresurrectCount2 = GameConstants.getmaxresurrectCount2();
    }
    public int getmaxresurrectCount2(){
        return this.maxresurrectCount2;
    }

    public void setresurrectCount2(int resurrectCount){
        this.resurrectCount2 = resurrectCount;
    }
    public int getresurrectCount2(){
        return this.resurrectCount2;
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
    public void setdefenseDamageUp1(int defenseDamage) {
        this.defenseDamage += defenseDamage;
    }
    public int getdefenseDamageUp1(){
        return defenseDamage;
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
        int a=target.getHP()-this.attackDamage;
        target.setHP(a);
        System.out.println(target.getName()+"가"+this.name+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.HP+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        this.MP-=100;
        System.out.println(this.name+"의 남은 마력 : "+this.MP);
    }
    public abstract void useQ(Champion target,otherResurrect target2);
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
    //고정된 부활(resurrect) 규칙을 final 메서드로 만들기
    final void resurrect1(){
        if(this.HP<=0){
            this.HP=0;//너무 큰 데미지를 입어 마이너스 체력까지 떨어진 상태일 경우 0으로 체력을 초기화후 20센트 체력을 주입
            this.HP+=(int)(GameConstants.HP * 0.2);//해당 변수들이 int 형이기 때문에 더블형이 불가하여 형변환을 해야한다.
            System.out.println(this.name + "의 체력이 20% 회복되어 부활 되었습니다. 현재 체력 : " + this.HP);
            System.out.println(this.name + "님 어서 우물로 돌아가 체력을 회복하세요~");
        }
    }
    final void resurrect(){
        if(this.HP<=0){
            this.HP=0;
        }
    }

    public abstract void checkHP();//공격자가 공격 당한 챔피언의 피를 본인 스스로 확인해보라는 메서드

}
