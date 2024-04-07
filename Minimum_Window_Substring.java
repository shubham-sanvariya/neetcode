public class Minimum_Window_Substring {
    public static void main(String[] args) {
        Minimum_Window_Substring minimumWindowSubstring = new Minimum_Window_Substring();
        String s = "ADOBECODEBANC", t = "ABC";
        minimumWindowSubstring.minWindow(s,t);
    }

    public String minWindow(String s, String t) {
        if(s== null || t == null || s.length()==0 || t.length()==0) return new String();
        int[] map = new int[128];
        int count = t.length();
        int st = 0, e=0, min = Integer.MAX_VALUE, indx =0;
        for(char c: t.toCharArray()){
            map[c]++;
        }
        char[] ch = s.toCharArray();
        while(e<ch.length){
            if(map[ch[e++]]-->0){
                count--;
            }
            while(count==0){
                if(e - st<min){
                    indx = st;
                    min = e-st;
                }
                if(map[ch[st++]]++==0) count++;
            }
        }
        return min == Integer.MAX_VALUE ? new String():
                new String(ch,indx,min);
    }
}
