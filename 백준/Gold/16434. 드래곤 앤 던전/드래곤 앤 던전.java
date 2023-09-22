import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long soldierAttack = Long.parseLong(st.nextToken());
        long soldierCurHP = 0, soldierMaxHp = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int attack = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());

            if (type == 1) {
                soldierCurHP += attack * ((hp / soldierAttack) - (hp % soldierAttack != 0 ? 0 : 1));
                soldierMaxHp = Math.max(soldierMaxHp, soldierCurHP);
            } else {
                soldierAttack += attack;
                soldierCurHP = Math.max(soldierCurHP - hp, 0);
            }
        }

        soldierMaxHp++;

        System.out.println(soldierMaxHp);
    }
}