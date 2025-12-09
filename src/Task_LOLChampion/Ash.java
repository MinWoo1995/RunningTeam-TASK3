package Task_LOLChampion;

public class Ash {
    private String name;
    private int levle;
    private int attackDamage;
    private int defenseDamage;
    private int HP;
    private int MP;

    public Ash(String name,int level,int attackDamage,int defenseDamage,int HP,int MP) {
        this.name = name;
        this.levle = level;
        this.attackDamage=attackDamage;
        this.defenseDamage = defenseDamage;
        this.HP = HP;
        this.MP = MP;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getattackDamage() {
        return this.attackDamage;
    }
    public void attackTo(Garen target){
        this.HP-=target.getattackDamage();
        System.out.println(target.getName()+"가"+this.name+"에게 공격 당하였습니다. 현재"+this.HP+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
    }
}
