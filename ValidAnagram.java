import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaras";
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram(s,t);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            if (arr[c - 'a'] == 0) return false;
            arr[c - 'a']--;
        }
        return true;

//        HashMap<Character,Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()){
//            if (map.containsKey(c)){
//                map.put(c,map.get(c)+1);
//                continue;
//            }
//            map.put(c,1);
//        }
//        for (char c : t.toCharArray()){
//            if (map.containsKey(c)){
//                map.put(c,map.get(c)-1);
//                if (map.get(c) == 0){
//                    map.remove(c);
//                }
//            }
//        }
//
//        System.out.println(map);
//        if (map.isEmpty()) {
//            System.out.println(true);
//            return true;
//        }
//        return false;
    }
}
