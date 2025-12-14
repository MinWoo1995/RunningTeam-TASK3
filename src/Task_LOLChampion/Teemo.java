package Task_LOLChampion;

public class Teemo extends Champion{
    public Teemo(String name) {
        super(name,2,30,10,400);
    }
    @Override
    public void useQ(Champion target, otherResurrect target2) {
        System.out.println(getName() + "이(가) 'Q' 스킬을 사용합니다.");
        attackTo(target);
        GameConstants.battleCount++;
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
    }
    @Override
    public void useE(Champion target) {
        System.out.println(getName() + "이(가) 'E' 스킬을 사용합니다.");
        int hp = target.getHP()-getattackDamage();
        target.setHP(hp);
        System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        int mp = getMP();
        mp -= 60;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());
        GameConstants.battleCount++;
    }
    @Override
    public void useW(Champion target) {
        System.out.println(getName() + "이(가) 'E' 스킬을 사용합니다.");
        int hp = target.getHP()-getattackDamage();
        target.setHP(hp);
        System.out.println(target.getName()+"가"+getName()+"에게 공격 당하였습니다. 현재"+target.getName()+"의 체력은"+target.getHP()+"입니다.");
        //출력문을 데미지 계산 위에 위치시켜서 감소된 HP 확인이 안되었다.[문제]
        int mp = getMP();
        mp -= 80;
        setMP(mp);
        System.out.println(getName()+"의 남은 마력 : "+getMP());
        GameConstants.battleCount++;
    }
    @Override
    public void checkHP(){
        if(getHP()<=0){
            resurrect();
        }
    }
    public void hook(){
        System.out.println(this.getName()+"은 부활하면서 체력 증강 +400 버프를 추가 적용받았습니다.");
        int buf = this.getHP()+100;
        this.setHP(buf);
    }
}
