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
        ash2.useQ(garen2);
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






    }
}
