package Task_LOLChampion;

public class Garen extends Champion {
    public Garen(String name){
        super(name,1,100,50,600,500,100);
    }
    @Override
    public void useQ(Champion target) {
        System.out.println("------------useQ------------");
        System.out.println(getName() + "이(가) 'Q' 스킬을 사용합니다.");
        attackTo(target);
        System.out.println("----------------------------");
    }
    @Override
    public void useR(Champion target) {
        System.out.println("------------useR------------");
        System.out.println(getName() + "이(가) 'R' 스킬을 사용합니다.");
        int hp = target.getHP()-getattackDamage();
        target.setHP(hp);
        System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        int mp = getMP();
        mp -= 100;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());
        System.out.println("----------------------------");
    }
    @Override
    public void useE(Champion target) {
        System.out.println("------------useE------------");
        System.out.println(getName() + "이(가) 'E' 스킬을 사용합니다.");
        System.out.println(getName() + "의 'E' 스킬은 랜덤한 치명타 데미지가 발생합니다.");
        int hp = target.getHP()-getrandomDamage();
        target.setHP(hp);
        System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        int mp = getMP();
        mp -= 50;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());
        System.out.println("---------------------------");
    }
    @Override
    public void useW(Champion target) {
        System.out.println("------------useW------------");
        System.out.println(getName() + "이(가) 'E' 스킬을 사용합니다.");
        int hp = getattackDamage();
        System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        target.takeDamage(hp);
        int mp = getMP();
        mp -= 20;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());

        System.out.println("----------------------------");
    }
    public void levelUp(int ex) {
        System.out.println("------------levelUp-------------");
        System.out.println(getName()+"이 획득한 경험치 : "+ex);
        int getex = getEx();
        int ex1 = getex+ex;
        setEx(ex1);
        System.out.println(getName()+"의 현재 총 경험치 : "+getEx());
        int getex1 = getEx();
        int maxex = getmaxEx();
        int ex2 = maxex-getex1;
        System.out.println(getName()+"의 레벨업까지 필요한 경험치 : "+ex2);
        if(getex1>=maxex){
            setlevel(1);
            System.out.println(getName()+"레벨업 하였습니다. : 현재레벨 "+getlevel());
            setattackDamage(50);
            setHP(150);
            System.out.println(getName()+"의 총 체력 : "+getHP()+" 총 공경력 :"+getattackDamage());
        }
        System.out.println("-------------------------------");
    }





}
