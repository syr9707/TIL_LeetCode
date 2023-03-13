import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int len = musicinfos.length;
        int maxTime = -1;
        
        for(int i = 0; i < len; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            int minute = countMinute(musicinfo[0], musicinfo[1]);
            musicinfo[3] = replaceMelody(musicinfo[3]);
            m = replaceMelody(m);
            String musicList = musicList(musicinfo[3], minute);
            
            if(musicList.contains(m) && (maxTime < minute)) {
                answer = musicinfo[2];
                maxTime = minute;
            }
        }
        
        if(maxTime == -1) return "(None)";
        
        return answer;
    }
    
    public static int countMinute(String s0, String s1) {
        int minute = (Integer.parseInt(s1.substring(0, 2)) - Integer.parseInt(s0.substring(0, 2))) * 60
            + (Integer.parseInt(s1.substring(3, 5)) - Integer.parseInt(s0.substring(3, 5)));
        
        return minute;
    }
    
    public static String musicList(String s, int minute) {
        StringBuilder sb = new StringBuilder();
        
        if(s.length() < minute) {
            for(int i = 0; i < minute / s.length(); i++) {
                sb.append(s);
            }
            sb.append(s.substring(0, minute % s.length()));
        } else {
            sb.append(s.substring(0, minute));
        }
        
        String musicList = sb.toString();
        return musicList;
    }
    
    public static String replaceMelody(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        s = s.replaceAll("A#", "a");
        
        return s;
    }
}