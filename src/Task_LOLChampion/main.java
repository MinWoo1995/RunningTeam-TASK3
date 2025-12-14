package Task_LOLChampion;

public class main {
    public static void main(String[] args) {
        Garen garen1 = new Garen("Garen1");
        Garen garen2 = new Garen("Garen2");
        Ash ash1 = new Ash("Ash1");
        Ash ash2 = new Ash("Ash2");

        //가렌1과 에쉬1이 서로 공격을 주고받음
        garen1.attackTo(ash1);
        ash1.attackTo(garen1);

        //Q/W/E/R 스킬을 모두 추상 메서드로 확장해보기
        ash2.useQ(garen2,garen2);
        ash2.useW(garen2);
        ash2.useE(garen2);
        ash2.useR(garen2);

        //Lux, Teemo 등 챔피언 2명 더 만들기
        Lux lux1 = new Lux("Lux1");
        Teemo teemo1 = new Teemo("Teemo1");

        //가렌에게 “레벨업(levelUp)” 메서드를 만들어 체력·공격력 증가하게 해보기
        garen1.levelUp(200);
        garen1.useR(ash1);

        //takeDamage 후 체력이 0 이하가 되면 “가렌 사망!” 메시지 출력
        ash1.useW(garen1);

        //attackDamage 값을 난수(랜덤)로 만들어 “치명타 개념” 추가해보기
        garen2.useE(ash2);

        //인터페이스를 2개 이상 조합한 챔피언 만들기(예: 근거리 + 탱커)
        garen2.defenseDamageUp();
        garen2.dash();

        //“치명타 확률” 같은 고유 패시브를 메서드로 추가해보기
        garen1.useE(ash1);

        //기본 체력, 기본 공격력, 기본 방어력 값 GameConstants의 static final 상수 사용
        Ash ash3 = new Ash("Ash3");

        //모든 챔피언의 전투 횟수(static) 카운팅 기능 추가
        System.out.println("모든 챔피언의 총 전투 횟수 : "+GameConstants.battleCount);

        //고정된 부활(resurrect) 규칙을 final 메서드로 만들기
        Ash ash4 = new Ash("Ash4");
        ash4.setattackDamage(1000);//어택데미지 변수가 상수로 초기 셋팅 되어 기존 어택데미지를 높게 재설정
        ash4.useQ(garen1,garen1);

        //인터페이스 otherResurrect을 만들어 추상메서드를 선언하여 서로 다른 챔피언의 부활 조건을 결정
        //가렌은 최대 2번만 부활이 가능하다.
        //에쉬는 최대 3번만 부활이 가능하다.
        ash4.useQ(garen1,garen1);
        ash4.useQ(garen1,garen1);
        garen1.useQ(ash4,ash4);
        garen1.useQ(ash4,ash4);
        garen1.useQ(ash4,ash4);
        garen1.useQ(ash4,ash4);

        //전투 로그 기록 출력
        GameConstants.LogPrint();
    }
}
