import java.util.*;

public class Word_Ladder {
    public static void main(String[] args) {
        List<String> list = List.of("hot","dot","dog","lot","log","cog");
        List<String> wordList = new ArrayList<>(list);
        String beginWord = "hit", endWord = "cog";
        Word_Ladder wordLadder = new Word_Ladder();
        wordLadder.ladderLength(beginWord,endWord,wordList);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            StringBuilder sb = null;
            for (int i = 0; i < word.length(); i++) {
                sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(word);
            }
        }

        int step = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                StringBuilder sb = null;
                for (int j = 0; j < word.length(); j++) {
                    sb = new StringBuilder(word);
                    sb.setCharAt(j, '*');
                    for (String w : map.get(sb.toString())) {
                        if (w.equals(endWord)) {
                            System.out.println(step);
                            return step;
                        }
                        if (visited.contains(w)) {
                            continue;
                        }
                        q.offer(w);
                        visited.add(w);
                    }
                }
            }
        }
        return 0;
    }
}
