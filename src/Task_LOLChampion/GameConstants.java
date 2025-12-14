package Task_LOLChampion;

import java.util.ArrayList;
import java.util.List;

public class GameConstants {//여기에는 static 선언 불가.
    //내부에 동일한 이름을 가진 (GameConstants)을 2중 구조로 선언시 내부 클래스에는 static 선언이 가능하다.
    //내부에 2중 클래스를 만들어 static을 부여하는 사용법은 크게 2가지 정도이다.
    //1.대규모 상수 그룹의 논리적 분리 (Namespacing) 2. 독립적인 Helper Class 제공
    //1번 이유
    //챔피언 관련	GameConstants.Champion.HP
    //시스템 설정	GameConstants.System.TIMEOUT
    //UI 색상	GameConstants.UI.COLOR_RED
    //2번 이유
    //바깥 클래스의 객체 없이도 독립적으로 동작해야 하는 유틸리티성 헬퍼 클래스를 만들 때 사용

    static final int HP=100;//final 키워드 사용과 동시에 변수 값을 초기화하기 않으면 오류가 발생
    private static final int attackDamage=100;
    private static final int defenseDamage=50;//static이 붙게 되면 class 레벨의 변수가 된다!! 객체 생성없이 바로 사용가능하니까
    //static final은 외부 클래스에서 접근은 가능 하나 수정이 불가하고 참조만 가능하다.
    //static final private은 외부클래스에서 접근이 불가하고 내부 메서드나 생성자를 통해 접근이 가능하다.

    static int battleCount = 0;//모든 챔피언의 전투 횟수 카운트하기 위한 독립 변수
    private static final int resurrectCount = 0;
    private static final int maxresurrectCount = 2;
    private static final int maxresurrectCount2 = 3;



    private GameConstants(){
        throw new AssertionError("이 클래스는 상수만 취급하는 클래스입니다. [클래스명.상수명]으로 호출하세요");
        //객체를 생성할려고 한다면, 오류문을 출력하여 올바르게 사용할수 있도록 안내하자!
    }
    //스태틱으로 선언된 상수들만 취급함으로, 생성자를 퍼블릭으로 사용하게 되면,
    //다른 개발자가 불필요하게 객체를 생성하는 일을 방지하여 자원을 효율적으로 사용할수있다.
    //왜냐하면 스태틱 변수들은 객체 생성 없이 바로 클래스명.상수명으로 바로 호출하여 사용하기 때문이다.
    public static int getAttackDamage(){
        return GameConstants.attackDamage;//static 키워드 때문에 this.변수명이 아닌 [클래스명.상수명]으로 리턴을 하면된다.
    }
    public static int getDefenseDamage(){
        return GameConstants.defenseDamage;
    }
    public static int getresurrectCount(){
        return GameConstants.resurrectCount;
    }
    public static int getmaxresurrectCount(){
        return GameConstants.maxresurrectCount;
    }
    public static int getmaxresurrectCount2(){
        return GameConstants.maxresurrectCount2;
    }
    public static List<String> log = new ArrayList<>();//전투로그 저장하는 동적배열
    public static void Log(String logMassage){
        log.add(logMassage);
        System.out.println("전투로그가 기록되었습니다.");
    }
    public static void LogPrint(){
        for(int i=0;i<log.size();i++){
            System.out.println((i+1)+"번 "+log.get(i));
        }
    }



}
