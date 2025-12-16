package Task_LOLChampion;

import java.util.ArrayList;
import java.util.List;

public class printTeamMembers{
    public static void printTeamMembers(List<? extends Champion> team){
        System.out.println("---------- 팀 멤버 목록 ----------");
        if (team.isEmpty()) {
            System.out.println("팀에 멤버가 없습니다.");
            return;
        }

        for (Champion member : team) {
            System.out.println(member.getName());
        }
        System.out.println("---------------------------------");
    }
}


