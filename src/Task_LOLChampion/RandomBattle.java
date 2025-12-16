package Task_LOLChampion;

import java.util.List;
import java.util.Random;

public class RandomBattle{
    //속성
    List<? extends Champion> redPlayer;
    List<? extends Champion> bluePlayer;
    int minTeamSize = 0;
    int blueNum;
    int redNum;
    int blueMaxTeamSize;
    int redMaxTeamSize;
    int blueRangeSize;
    int redRangeSize;

    //생성자
    public RandomBattle(List<?extends Champion> redTeam,List<? extends Champion> blueTeam){//와일드 카드로 사용
        //List<?extends Champion> 챔피언 클래스를 상속받은 어떤 타입의 배열만 가능하다
        //챔피언을 상속받은 가렌,에쉬..등 도 가능하다.!

        this.blueMaxTeamSize = blueTeam.size();
        this.redMaxTeamSize = redTeam.size();
        this.blueRangeSize = blueMaxTeamSize - minTeamSize;
        this.redRangeSize = redMaxTeamSize - minTeamSize;
        this.redPlayer =  redTeam;
        this.bluePlayer = blueTeam;
    }
    public void randomBattleManager(List<Champion> redTeam,List<Champion> blueTeam){
        //팀원이 있는지 검사하기
        if(redTeam.isEmpty()){
            System.out.println("레드팀 팀원이 없습니다.");
            System.out.println("프로그램을 종료하겠습니다.");
            System.exit(0);
        }
        if(blueTeam.isEmpty()){
            System.out.println("블루팀 팀원이 없습니다.");
            System.out.println("프로그램을 종료하겠습니다.");
            System.exit(0);
        }

        //양팀에서 각 챔피언 1명씩 랜덤하게 뽑기.
        //베열에서 랜덤한 난수를 일으켜 인덱스로 활용하여 챔피언 꺼내기
        Random randomSize = new Random();
        this.blueNum = randomSize.nextInt(this.blueRangeSize);
        this.redNum = randomSize.nextInt(this.redRangeSize);

        Champion redPlayer2 = redTeam.get(this.redNum);
        Champion bluePlayer2 = blueTeam.get(this.blueNum);

        //선후공 랜덤으로 뽑은후 전투 하기
        //0=레드 1=블루
        int firstAndSecond = randomSize.nextInt(2);
        System.out.println("------------1:1 레드팀 VS 블루팀 대결을 시작합니다.------------");
        System.out.println("선공을 랜덤으로 정합니다.");
        if(firstAndSecond == 0){
            System.out.println("레드팀이 공격입니다.");
            System.out.println(redPlayer2.getName()+" vs "+bluePlayer2.getName());
            System.out.println(redPlayer2.getName()+" -> "+bluePlayer2.getName()+" 공격!!");
            redPlayer2.useQ(bluePlayer2, bluePlayer2);
        }else{
            System.out.println("------------1:1 블루팀 VS 레드팀 대결을 시작합니다.------------");
            System.out.println("블루팀이 공격입니다.");
            System.out.println(bluePlayer2.getName()+" vs "+redPlayer2.getName());
            System.out.println(bluePlayer2.getName()+" -> "+redPlayer2.getName()+" 공격!!");
            bluePlayer2.useQ(redPlayer2, redPlayer2);
        }
    }
}
