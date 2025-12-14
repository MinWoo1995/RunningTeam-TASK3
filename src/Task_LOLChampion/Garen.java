package Task_LOLChampion;

public class Garen extends Champion implements Tanker,ShortDistance,otherResurrect {
    public Garen(String name){
        super(name,1,1000,50,600,500);
    }
    @Override
    public void defenseDamageUp() {
        System.out.println("------------근거리 패시브------------");
        System.out.println("방어력이 100 증가합니다.");
        setdefenseDamageUp1(100);
        System.out.println(getName()+"의 패시브 반영 방어력 : "+getdefenseDamageUp1());
        System.out.println("----------------------------");
    }
    @Override
    public void dash(){
        System.out.println("------------탱커 패시브------------");
        System.out.println("앞으로 순간이동을 실시합니다!!");
        System.out.println("----------------------------");
    }
    @Override
    public void useQ(Champion target, otherResurrect target2) {
        System.out.println("------------useQ------------");
        System.out.println(getName() + "이(가) 'Q' 스킬을 사용합니다.");
        attackTo(target);
        System.out.println("----------------------------");
        GameConstants.battleCount++;
        target2.ohterResurrect();
        String logMemo = this.getName()+"의 "+"Q 스킬 전투로그 기록 타겟 : "+ target.getName();
        GameConstants.Log(logMemo);
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
        GameConstants.battleCount++;
        String logMemo = this.getName()+"의 "+"R 스킬 전투로그 기록 타겟 : "+ target.getName();
        GameConstants.Log(logMemo);
    }
    @Override
    public void useE(Champion target) {
        System.out.println("------------useE------------");
        System.out.println(getName() + "이(가) 'E' 스킬을 사용합니다.");
        System.out.println(getName() + "의 'E' 스킬은 랜덤한 확률로 치명타 데미지가 발생합니다.");
        int probability = criticalDamage();
        if (probability >= 100) {
            int hp = target.getHP()-getrandomDamage();
            target.setHP(hp);
            GameConstants.battleCount++;
            System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        }else{
            System.out.println(getName() + "의 치명타가 발생하지 않았습니다.");
        }
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        int mp = getMP();
        mp -= 50;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());
        System.out.println("---------------------------");
        String logMemo = this.getName()+"의 "+"E 스킬 전투로그 기록 타겟 : "+ target.getName();
        GameConstants.Log(logMemo);
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
        GameConstants.battleCount++;
        String logMemo = this.getName()+"의 "+"W 스킬 전투로그 기록 타겟 : "+ target.getName();
        GameConstants.Log(logMemo);
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
    @Override
    public void checkHP(){
         if(getHP()<=0){
             System.out.println(getName()+"의 체력이 "+getHP()+" 사망하였습니다.");
             resurrect1();
         }
    }
    @Override
    public void ohterResurrect(){
        this.setmaxresurrectCount();
        int b = this.getresurrectCount();
        int c = this.getmaxresurrectCount();
        if(b<c){
            if(this.getHP()<=0){
                System.out.println(this.getName()+"의 체력이 "+this.getHP()+" 사망하였습니다.");
                resurrect1();
                b++;
                this.setresurrectCount(b);
            }
        }else{
            System.out.println(this.getName()+"은 부활"+this.getmaxresurrectCount()+"회를 사용 하셨음으로 부활이 불가합니다.");
        }
    }

}
