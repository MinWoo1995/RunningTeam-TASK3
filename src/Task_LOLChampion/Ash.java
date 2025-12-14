package Task_LOLChampion;

public class Ash extends Champion implements otherResurrect {
    public Ash(String name){
        super(name,1,600,50,600,500);
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
        System.out.println(getName() + "이(가) 'R' 스킬을 사용합니다.");
        int hp = target.getHP()-getattackDamage();
        target.setHP(hp);
        System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        int mp = getMP();
        mp -= 100;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());
        GameConstants.battleCount++;
        String logMemo = this.getName()+"의 "+"R 스킬 전투로그 기록 타겟 : "+ target.getName();
        GameConstants.Log(logMemo);
    }
    @Override
    public void useE(Champion target) {
        System.out.println(getName() + "이(가) 'E' 스킬을 사용합니다.");
        int hp = target.getHP()-getattackDamage();
        target.setHP(hp);
        System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        int mp = getMP();
        mp -= 50;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());
        GameConstants.battleCount++;
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
    @Override
    public void checkHP(){
        if(getHP()<=0){
            resurrect();
        }
    }
    @Override
    public void ohterResurrect(){
        this.setmaxresurrectCount2();
        int b = this.getresurrectCount2();
        int c = this.getmaxresurrectCount2();
        if(b<c){
            if(this.getHP()<=0){
                System.out.println(this.getName()+"의 체력이 "+this.getHP()+" 사망하였습니다.");
                resurrect1();
                b++;
                this.setresurrectCount2(b);
            }
        }else{
            System.out.println(this.getName()+"은 부활"+this.getmaxresurrectCount2()+"회를 사용 하셨음으로 부활이 불가합니다.");
        }
    }

}
